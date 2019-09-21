package com.pangxie.server.thradlocal;

/**
 * Create By fightingcrap On 2019/09/18
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
 * | ThreadLocalTest
 * |
 * | @author fightingcrap
 **/
public class ThreadLocalTest {

    private static InheritableThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        Thread thread = new Thread(new Task());
        Thread thread1 = new Thread(new Task());
        thread1.start();
        thread.start();

        threadLocal.set("test");
    }


    static class Task implements Runnable {

        @Override
        public void run() {
            threadLocal.set(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getName() + ": 已经塞入值");

            System.out.println(Thread.currentThread().getName() + ": 获取塞入值:" + threadLocal.get());
        }
    }
}
