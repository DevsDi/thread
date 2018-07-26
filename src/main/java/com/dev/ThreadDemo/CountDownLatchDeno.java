package com.dev.ThreadDemo;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDeno {

    public static void main(String[] args) {    
        CountDownLatch c0 = new CountDownLatch(0); //①
        CountDownLatch c1 = new CountDownLatch(1); //②
        CountDownLatch c2 = new CountDownLatch(1); //③

        Thread t1 = new Thread(new Work(c0, c1));
        //c0为0，t1可以执行。t1的计数器减1

        Thread t2 = new Thread(new Work(c1, c2));
        //t1的计数器为0时，t2才能执行。t2的计数器c2减1

        Thread t3 = new Thread(new Work(c2, c2));
        //t2的计数器c2为0时，t3才能执行

        t2.start();
        t1.start();
        t3.start();

    }
    //定义Work线程类，需要传入开始和结束的CountDownLatch参数
    static class Work implements Runnable {
        CountDownLatch curLatch;
        CountDownLatch nextLatch;
        Work(CountDownLatch curLatch, CountDownLatch nextLatch){
            this.curLatch=curLatch;
            this.nextLatch=nextLatch;
        }
        public void run() {
            try {
            	curLatch.await();//curLatch为0才可以执行
                System.out.println("开始执行线程:"+ Thread.currentThread().getName());
                if (nextLatch.getCount()!=0) {
                    nextLatch.countDown();//nextLatch计数器减少
				}

            } catch (InterruptedException e) {              
            }  

        }
    }

}