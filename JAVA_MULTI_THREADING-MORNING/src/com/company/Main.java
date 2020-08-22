package com.company;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

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

        ArrayBlockingQueue<Integer> sharedQueue = new ArrayBlockingQueue<Integer>(queueSize,true);
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

class Producer implements Runnable{
    private final ArrayBlockingQueue<Integer> sharedQueue;
    private String threadName;
    private int queueSize;
    private int countVal;

    public Producer(ArrayBlockingQueue<Integer> sharedQueue, String threadName, int queueSize,int threadNo){
        this.sharedQueue = sharedQueue;
        this.threadName = threadName;
        this.queueSize = queueSize;
        countVal = 1000*threadNo;
    }

    @Override
    public void run(){
        while(true){
            try{
                if(sharedQueue.size() == queueSize){
                    System.out.println("Queue Full. Waiting for Deque.");
                }
                sharedQueue.put(countVal);
                System.out.println("Produced: " + countVal  +  " By: " + this.threadName);
                ++countVal;
                Thread.sleep(200);
            }catch(InterruptedException exc){
                exc.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable{
    private final ArrayBlockingQueue<Integer> sharedQueue;
    private String threadName;

    public Consumer(ArrayBlockingQueue<Integer> sharedQueue, String threadName){
        this.sharedQueue = sharedQueue;
        this.threadName = threadName;
    }

    @Override
    public void run(){
        while(true){
            try{
                if(sharedQueue.size()==0){
                    System.out.println("Queue Empty. Waiting for enqueue");
                }
                int num = sharedQueue.take();
                System.out.println("Consumed: " + num + " By: " + this.threadName);
                Thread.sleep(200);
            }catch(InterruptedException exc){
                exc.printStackTrace();
            }
        }
    }
}