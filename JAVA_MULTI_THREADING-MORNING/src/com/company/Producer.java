package com.company;

public class Producer implements Runnable{
    private final MyBlockingQueue sharedQueue;
    private String threadName;
    private int queueSize;
    private int countVal;

    public Producer(MyBlockingQueue sharedQueue, String threadName, int queueSize,int threadNo){
        this.sharedQueue = sharedQueue;
        this.threadName = threadName;
        this.queueSize = queueSize;
        countVal = 1000*threadNo; //To differentiate numbers added by different threads
    }

    @Override
    public void run(){
        while(true){
            sharedQueue.put(countVal,threadName);
            ++countVal;
        }
    }
}
