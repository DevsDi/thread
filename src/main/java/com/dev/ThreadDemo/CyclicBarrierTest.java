package com.dev.ThreadDemo;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
    public static void main(String[] args) throws Exception {
    	
    	int parties=5;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(parties, new Runnable() {
            public void run() {
                System.out.println("线程组执行结束");
            }
        });
        for (int i = 0; i < parties; i++) {
            new Thread(new readNum(i,cyclicBarrier)).start();
        }
        //CyclicBarrier 可以重复利用，
        // 这个是CountDownLatch做不到的
//        for (int i = 11; i < 16; i++) {
//            new Thread(new readNum(i,cyclicBarrier)).start();
//        }
    }

}
 class readNum  implements Runnable{
    private int id;
    private CyclicBarrier cyc;
    public readNum(int id,CyclicBarrier cyc){
        this.id = id;
        this.cyc = cyc;
    }
    public void run() {
        synchronized (this){
            try {
            	System.out.println("id = "+id);
                cyc.await();//开始等待，直到parties个线程都调用了await方法，cyc才开始执行，之后下面代码才执行
                System.out.println("线程组任务" + id + "结束，其他任务继续");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}