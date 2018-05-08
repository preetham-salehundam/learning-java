package com.company.ProducerConsumer;

public class SharedBuffer {

    private int x;
    boolean produced = false;

    public synchronized void consumeX() {
        //consumer should wait when producer has not produced
        while(!produced){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //its consuming now
        System.out.println("consumed "+x);
        //after consumption, value is gone, so produced is false
        produced = false;
        // producer to be notified to start production
        notify();

    }

    public synchronized void produceX(int x) {

        // when finished producing, producer has to wait
        while(produced){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("produced : "+x);
        // produced
        this.x = x;

        //after production is done, produced should be true
        produced = true;

        //after stopping producing call notify for consumer to consume
        notify();
    }


}

class Producer implements Runnable{
    SharedBuffer buffer;
    public Producer(SharedBuffer buffer) {
        this.buffer = buffer;
       //creating a thread inside a constructor to kickoff when the class is instantiated
        Thread producer = new Thread(this,"Producer");
        producer.start();

    }


    @Override
    public void run() {
        int i = 0;
        //for ever running process of production
        while(true){
            buffer.produceX(i++);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

class Consumer implements Runnable{
    SharedBuffer buffer;
    public Consumer(SharedBuffer buffer){
        this.buffer = buffer;
        Thread consumer = new Thread(this,"consumer");
        consumer.start();
    }


    @Override
    public void run() {
        while(true){

            buffer.consumeX();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class Main{
    public static void main(String[] args) {
        //instantiated to run
        SharedBuffer buffer = new SharedBuffer();
        new Producer(buffer);
        new Consumer(buffer);
    }

}