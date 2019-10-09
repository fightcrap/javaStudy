package com.pangxie.server.jsr107;

import javax.cache.Cache;
import javax.cache.CacheException;
import javax.cache.CacheManager;
import javax.cache.configuration.Configuration;
import javax.cache.spi.CachingProvider;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Create By fightingcrap On 2019/09/14
 * |  .--,       .--,
 * |( (  \.---./  ) )
 * | '.__/o   o\__.'
 * |    {=  ^  =}
 * |     >  -  <
 * |    /       \
 * |   //       \\
 * |  //|   .   |\\
 * |  "'\       /'"_.-~^`'-.
 * |     \  _  /--'         `
 * |   ___)( )(___
 * |  (((__) (__)))    程序镇压神兽，排查一切bug。
 * |
 * |
 * | PxCache107Manager
 * |
 * | @author fightingcrap
 **/
public class PxCache107Manager implements CacheManager {

    private final PxCache107Provider cachingProvider;
    private final ClassLoader classLoader;
    private final URI uri;
    private final Properties props;
    private volatile boolean isClosed;



    private final ConcurrentMap<String, PxCache107<?, ?>> caches = new ConcurrentHashMap<String, PxCache107<?, ?>>();

    public PxCache107Manager(PxCache107Provider cachingProvider, Properties props, ClassLoader classLoader, URI uri) {
        this.cachingProvider = cachingProvider;
        this.classLoader = classLoader;
        this.uri = uri;
        this.props = props;
    }

    @Override
    synchronized public void close() {
        if (!isClosed()) {
            cachingProvider.releaseCacheManager(getURI(), getClassLoader());

            isClosed = true;

            ArrayList<Cache<?, ?>> cacheList = new ArrayList<Cache<?, ?>>(caches.values());
            caches.clear();

            for (Cache<?, ?> cache : cacheList) {
                try {
                    cache.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    synchronized public <K, V, C extends Configuration<K, V>> Cache<K, V> createCache(String cacheName, C configuration)
            throws IllegalArgumentException {
        if (isClosed()) {
            throw new IllegalStateException();
        }

        checkNotNull(cacheName, "cacheName");
        checkNotNull(configuration, "configuration");

        PxCache107<?, ?> cache = caches.get(cacheName);

        if (cache == null) {
            cache = new PxCache107<K, V>(this, cacheName, configuration);
            caches.put(cache.getName(), cache);

            return (Cache<K, V>) cache;
        } else {
            throw new CacheException("A cache named " + cacheName + " already exists.");
        }
    }

    @Override
    synchronized public void destroyCache(String cacheName) {
        if (isClosed()) {
            throw new IllegalStateException();
        }

        checkNotNull(cacheName, "cacheName");

        Cache<?, ?> cache = caches.get(cacheName);

        if (cache != null) {
            cache.close();
        }
    }

    private void checkNotNull(Object object, String name) {
        if (object == null) {
            throw new NullPointerException(name + " can not be null");
        }
    }

    @Override
    public void enableManagement(String arg0, boolean arg1) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enableStatistics(String arg0, boolean arg1) {
        // TODO Auto-generated method stub

    }

    @SuppressWarnings("unchecked")
    @Override
    public <K, V> Cache<K, V> getCache(String cacheName) {
        return (Cache<K, V>) getCache(cacheName, Object.class, Object.class);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <K, V> Cache<K, V> getCache(String cacheName, Class<K> keyClazz, Class<V> valueClazz) {
        if (isClosed()) {
            throw new IllegalStateException();
        }

        checkNotNull(keyClazz, "keyType");
        checkNotNull(valueClazz, "valueType");

        PxCache107<K, V> cache = (PxCache107<K, V>) caches.get(cacheName);

        if (cache == null) {
            return null;
        } else {
            Configuration<?, ?> configuration = cache.getConfiguration(Configuration.class);

            if (configuration.getKeyType() != null && configuration.getKeyType().equals(keyClazz)) {
                if (configuration.getValueType() != null && configuration.getValueType().equals(valueClazz)) {
                    return cache;
                } else {
                    throw new ClassCastException("Incompatible cache value types specified, expected "
                            + configuration.getValueType() + " but " + keyClazz + " was specified");
                }
            } else {
                throw new ClassCastException("Incompatible cache key types specified, expected "
                        + configuration.getKeyType() + " but " + valueClazz + " was specified");
            }
        }
    }

    @Override
    public Iterable<String> getCacheNames() {
        if (isClosed()) {
            throw new IllegalStateException();
        }

        return Collections.unmodifiableList(new ArrayList<String>(caches.keySet()));
    }

    @Override
    public CachingProvider getCachingProvider() {
        return cachingProvider;
    }

    @Override
    public ClassLoader getClassLoader() {
        return this.classLoader;
    }

    @Override
    public Properties getProperties() {
        return this.props;
    }

    @Override
    public URI getURI() {
        return this.uri;
    }

    @Override
    public boolean isClosed() {
        return isClosed;
    }

    @Override
    public <T> T unwrap(Class<T> clazz) {
        if (clazz.isAssignableFrom(getClass())) {
            return clazz.cast(this);
        }

        throw new IllegalArgumentException("Unwapping to " + clazz + " is not a supported by this implementation");
    }

    synchronized public void releaseCache(String cacheName) {
        if (cacheName == null) {
            throw new NullPointerException();
        }

        caches.remove(cacheName);
    }

}