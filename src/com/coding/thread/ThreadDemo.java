package com.coding.thread;

/**
 * ThreadDemo td = new ThreadDemo();
 * td.start();
 * for (int i = 0; i < 50; i++)
 * System.out.println("i = " + i + ", i * i = " + i * i);
 */
public class ThreadDemo extends Thread {

    @Override
    public void run() {
        for (int count = 1, row = 1; row < 20; row++, count++) {
            for (int i = 0; i < count; i++)
                System.out.print('*');
            System.out.print('\n');
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * ThreadDemo.ThreadDemo2 td = new ThreadDemo.ThreadDemo2();
     * td.run();
     */
    public static class ThreadDemo2 implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 50; i++)
                System.out.println("i = " + i + ", i * i = " + i * i);
        }
    }
}
