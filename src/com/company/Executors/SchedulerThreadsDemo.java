package com.company.Executors;

import java.util.Date;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class SchedulerThreadsDemo {

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);
        for (int idx = 0; idx <= 3; idx++){
            try {
                Thread.sleep(2000);
               // Printer printer =
               executorService.schedule(new Printer("TASK " + idx), 5, TimeUnit.SECONDS);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        System.out.println("Completed all threads");
    }


}


class Printer implements Runnable {

    String taskname;

    public Printer(String taskname) {
        this.taskname = taskname;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + "Start time for " + this.taskname + " " + new Date());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "End time for" + this.taskname + " " + new Date());

    }
}
