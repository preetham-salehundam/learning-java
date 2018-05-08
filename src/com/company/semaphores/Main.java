package com.company.semaphores;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        BlockingArrayList<String> blockingArrayList = new BlockingArrayList<>(5);

        Runnable runnable = () -> {
            try {
                blockingArrayList.add("One");
                blockingArrayList.add("Two");
                blockingArrayList.add("Three");
                blockingArrayList.add("four");
                blockingArrayList.add("five");
                System.out.println("Available permits to acquire" + blockingArrayList.getSemaphore().availablePermits());
                blockingArrayList.add("Six");
                blockingArrayList.add("Seven");
                System.out.println("Final list: " + blockingArrayList.getArrayList());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };


        // non lambda version
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("List before removing" + blockingArrayList.getArrayList());
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                blockingArrayList.remove("One");
                blockingArrayList.remove("Two");

                System.out.println("permits available " + blockingArrayList.getSemaphore().availablePermits());
            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable1);
        t1.start();
        t2.start();
        t1.getState();



    }
}
