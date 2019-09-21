package com.pangxie.server.thradlocal.aqs;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;

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
 * | Main
 * |
 * | @author fightingcrap
 **/
public class Main {

    final static NonReentrantLock lock = new NonReentrantLock();

    final static Condition notFull = lock.newCondition();

    final static Condition notEmpty = lock.newCondition();

    final static Queue<String> query = new LinkedBlockingDeque<>();

    final static int size = 10;

    public static void main(String[] args) {

        Thread product = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    while (query.size() == size) {
                        notEmpty.await();
                    }

                    query.add("ele");

                    notFull.signalAll();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });


        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    while (query.size() == 0) {
                        notFull.await();
                    }

                    String value = query.poll();
                    notEmpty.signalAll();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        product.start();
        consumer.start();
    }

}
