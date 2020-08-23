package com.company;

public class Consumer implements Runnable{
    private final MyBlockingQueue sharedQueue;
    private String threadName;

    public Consumer(MyBlockingQueue sharedQueue, String threadName){
        this.sharedQueue = sharedQueue;
        this.threadName = threadName;
    }

    @Override
    public void run(){
        while(true){
            sharedQueue.take(threadName);
        }
    }
}
