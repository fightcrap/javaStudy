package com.pangxie.server.thradlocal.aqs;

import com.sun.tools.javac.util.Assert;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Create By fightingcrap On 2019/09/21
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
 * | NonReentrantLock
 * |
 * | @author fightingcrap
 **/
public class NonReentrantLock implements Lock, Serializable {

    private final Sync sync = new Sync();


    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {


    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {


        return false;
    }

    @Override
    public void unlock() {

        sync.release(1);
    }


    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }

    public boolean isHeldExclusively() {
        return sync.isHeldExclusively();
    }


    private static class Sync extends AbstractQueuedSynchronizer {
        @Override
        protected boolean tryAcquire(int arg) {

            assert arg == 1;
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }

            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            assert arg == 1;

            if (getState() == 0) {
                throw new IllegalMonitorStateException();
            }

            setExclusiveOwnerThread(null);
            setState(0);

            return true;
        }

        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        ConditionObject newCondition() {
            return new ConditionObject();
        }
    }
}
