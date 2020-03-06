package com.urise.webapp;

public class DeadLock {
    public final static Object one = new Object(), two = new Object();

    public static void main(String... args) {

        Thread t1 = new Thread(() -> {
            synchronized (one) {
                Thread.yield();
                synchronized (two) {
                    System.out.println("Success!");
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (two) {
                Thread.yield();
                synchronized (one) {
                    System.out.println("Success!");
                }
            }
        });

        t1.start();
        t2.start();
    }
}