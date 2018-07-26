package com.dev.ThreadDemo;

import java.util.concurrent.CountDownLatch;

import lombok.Synchronized;

public class CountDownlatchTest {
    public static void main(String[] args) throws InterruptedException {
    	int count =5;
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for(int i=0;i<count;i++){
            new Thread(new readNum(i,countDownLatch)).start();
        }
        countDownLatch.await();//当前线程等待，直到latchcount=0
        System.out.println("线程执行结束。。。。");
    }
 
    static class readNum  implements Runnable{
        private int id;
        private CountDownLatch latch;
        public readNum(int id,CountDownLatch latch){
            this.id = id;
            this.latch = latch;
        }
        @Synchronized
        public void run() {
                System.out.println("线程组任务"+id+"结束，其他任务继续");
                latch.countDown();
        }
    }
}