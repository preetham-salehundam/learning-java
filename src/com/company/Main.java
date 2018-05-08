package com.company;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Vector<Person> personVector = new Vector<>();
        Person p1 = new Person(1, "Preetham");
        Person p2 = new Person(3, "Preetham");
        Person p3 = new Person(2, "Preetham");
        personVector.add(p1);
        personVector.add(p2);
        personVector.add(p3);
//        Collections.sort(personVector);
//        for(Person p: personVector){
//            System.out.println(p);
//        }

        Map<String, Integer> map = new HashMap<>();
        map.put("preetham", 1);
        map.put("amit", 2);

        Iterator itr = map.entrySet().iterator();
        while (itr.hasNext()) {
            //map.put("tarun",3);

            System.out.println(itr.next());
            //itr.remove();
        }

        HashSet hset = new HashSet<>();
        hset.add("preetham");
        hset.add("salehundam");
        hset.add("amit");
        hset.add(1);
        hset.add(null);

        System.out.println(hset);

        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("preetham");
        treeSet.add("salehundam");
        treeSet.add("amit");

        System.out.println(treeSet);


        HashMap countryCapitalMap = new HashMap();
        countryCapitalMap.put("Japan", "Tokyo");
        countryCapitalMap.put("France", "Paris");
        countryCapitalMap.put("Russia", "Moscow");
        countryCapitalMap.put("India", "Delhi");


        System.out.println(countryCapitalMap);

        System.out.println("after sorting");


        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Preetham");
        hashSet.add("amit");
        hashSet.add("Tarun");
        System.out.println(hashSet);


        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

        linkedHashSet.add("preetham");
        linkedHashSet.add("amit");
        linkedHashSet.add("Tarun");
        System.out.println(linkedHashSet.toString());

        TreeSet<String> tset = new TreeSet<>();
class Producer implements Runnable {
            BlockingQueue queue = null;

            public Producer(BlockingQueue queue) {
                this.queue = queue;
            }

            @Override
            public void run() {
                IntStream intStream = IntStream.range(1,50);
                intStream.parallel().forEachOrdered((idx) -> {
                    try {
                        System.out.println(Thread.currentThread().getName()+"Producing item " + idx);
                        queue.put("item " + idx);

                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                });
            }
        }

class Consumer implements Runnable {
            BlockingQueue queue = null;

            public Consumer(BlockingQueue queue) {
                this.queue = queue;
            }

            @Override
            public void run() {
                while (true) {
                    try {
                        // sleep will be interupted when the blocking queue is full
                        // as soon as consumer consumes one, producer produces one now
                        Thread.sleep(5000);
                        System.out.println(Thread.currentThread().getName()+" Consumed " + queue.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }

//        ExecutorService  executor = Executors.newFixedThreadPool(10);
//        BlockingQueue queue = new ArrayBlockingQueue(10);
//        Producer producer = new Producer(queue);
//        Consumer consumer = new Consumer(queue);
//         executor.submit(producer);
//         executor.submit(consumer);
//         executor.shutdownNow();



         //Array deque
        Deque deque = new ArrayDeque(10);
        IntStream.range(1,15).forEachOrdered(deque::add);
        IntStream.range(1,15).forEach((idx) -> System.out.println(deque.getLast()));
        System.out.println(deque);
/*
        IntStream.range(1, 100000).parallel().forEachOrdered((idx) -> {
            System.out.println(Thread.currentThread().getName() + "printing" + idx);

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });*/

        ArrayList list = new ArrayList();
        list.add("preetham");
        list.add("shahrukh");
        list.add("santhosh");


        list.forEach(System.out::println);



    }


}
