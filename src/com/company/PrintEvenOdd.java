package com.company;


public class PrintEvenOdd {


    public static void main(String[] args) {
        EvenOdd even = new EvenOdd(0);
        EvenOdd odd = new EvenOdd(1);

        Thread oddThread = new Thread(odd, "Odd");
        Thread evenThread = new Thread(even, "Even");

        oddThread.start();
        evenThread.start();

    }

}


class EvenOdd implements Runnable {

    int remainder; //remainder =1 odd,

    static int iterations = 1; // iterations = 1

    int print_numbers = 20;

    static final Object lock = new Object(); // this gives lock of the .class object

    final Object objLock = new Object(); // this gives lock on the object level

    public EvenOdd(int remainder) {
        this.remainder = remainder;
    }


    @Override
    public void run() {
        while (iterations < print_numbers) {
            synchronized (lock) {
                while (iterations % 2 != remainder) {
                    try {
                        System.out.println("waiting " + Thread.currentThread().getName());
                        System.out.println(Runtime.getRuntime().availableProcessors());
                        Thread.sleep(2000);
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " " + iterations);
                iterations++;
                lock.notify();
            }

        }

    }
}