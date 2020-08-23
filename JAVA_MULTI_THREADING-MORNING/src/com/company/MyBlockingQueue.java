package com.company;

import java.util.LinkedList;
import java.util.Queue;

//Custom Blocking Queue
public class MyBlockingQueue {
    int size;
    Queue<Integer> integerQueue;
    private Object lock = new Object();

    MyBlockingQueue(int size){
        this.size = size;
        integerQueue = new LinkedList<>();
    }

    void put(int num,String threadName){
        synchronized (lock){
            if(integerQueue.size() == size){
                System.out.println("Queue is full. Waiting for dequeue.");
                try{
                    lock.wait();
                }catch(InterruptedException exc){
                    exc.printStackTrace();
                }
            }else{
                System.out.println("Adding message " + num + " to the queue by: " + threadName);
                integerQueue.add(num);
                lock.notifyAll();
            }
            try{
                Thread.sleep(200);
            }catch (InterruptedException exc){
                exc.printStackTrace();
            }
        }
    }

    void take(String threadName){
        synchronized (lock){
            if(integerQueue.size() == 0){
                System.out.println("Queue is empty. Waiting for enqueue.");
                try{
                    lock.wait();
                }catch(InterruptedException exc){
                    exc.printStackTrace();
                }
            }else{
                int removedElement = integerQueue.remove();
                System.out.println("Removing message " + removedElement + " from the queue by: " + threadName);
                lock.notifyAll();
            }
            try{
                Thread.sleep(200);
            }catch (InterruptedException exc){
                exc.printStackTrace();
            }
        }
    }


}
