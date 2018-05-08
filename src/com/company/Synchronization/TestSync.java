package com.company.Synchronization;

public class TestSync {
    public static void main(String[] args) {
        Mailer mailer = new Mailer();
        Messenger messengerSaysHI = new Messenger("HI!!!!", mailer);
        Messenger messengerSaysBye = new Messenger("Bye!!!!", mailer);
        Thread t1 = new Thread(messengerSaysHI);
        Thread t2 = new Thread(messengerSaysBye);
        t1.start();
        t2.start();

//        try {
//            t1.join();
//            t2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }


}

class Mailer {


    public void send(String msg) {
        //synchronized (this) {
            System.out.println("sending" + msg + "by " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Message sent : " + msg + "by  " + Thread.currentThread().getName());
       // }

    }
}

class Messenger implements Runnable {

    Mailer mailer;
    String message;

    public Messenger(String msg, Mailer mailer) {
        this.mailer = mailer;
        this.message = msg;
    }


    @Override
    public void run() {
        //synchronize the object
        synchronized (mailer) {
        int i = 0;
        while (i != 10) {
            mailer.send(message);
            i++;

        }
        }

    }
}