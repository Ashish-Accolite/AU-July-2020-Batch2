package com.company;

import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int producers,consumers,queueSize;

        System.out.println("Enter No of Producers required");
        producers = sc.nextInt();
        System.out.println("Enter No of Consumers required");
        consumers = sc.nextInt();
        System.out.println("Enter Max queue size");
        queueSize = sc.nextInt();

        if(producers <= 0 || consumers <=0 || queueSize <= 0){
            System.out.println("No of Producers, No of Consumers and max Queue size must be greater than 0");
            return;
        }

        MyBlockingQueue sharedQueue = new MyBlockingQueue(queueSize);
        Thread producerArray[] = new Thread[producers];
        Thread consumerArray[] = new Thread[consumers];

        for(int producerCount=0; producerCount<producers; ++producerCount){
            Thread tmp = new Thread(new Producer(sharedQueue,"prodThread" + producerCount,queueSize,producerCount));
            producerArray[producerCount] = tmp;
        }

        for(int consumerCount=0; consumerCount<consumers; ++consumerCount){
            Thread tmp = new Thread((new Consumer(sharedQueue,"consThread" + consumerCount)));
            consumerArray[consumerCount] = tmp;
        }

        for(Thread tmp : producerArray){
            tmp.start();
        }

        for(Thread tmp : consumerArray){
            tmp.start();
        }
    }
}