package com.dev.ThreadDemo;

public class ValatileDemo extends Thread {

	private volatile boolean isRunning =true;
	public synchronized void  setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}
	@Override
	public void run() {
		System.out.println("isRunning == "+ isRunning);
		while (isRunning) {
			//ThreadLocal和局部变量是线程安全的，静态和实例变量都是不安全的
			//多个线程访问一个成员变量时  每个线程都会得到一个该变量的副本  在自己的线程的栈中保存、计算 以提高速度。  
			//但是这样就会有同步的问题了。当一个线程修改了自己栈内副本的值  还没有立即将同步到主存中，
			//其他线程再来获取主存中的该变量时  就会得到过期数据。 
//			try {
//				Thread.sleep(500);
//				System.out.println("while ...");
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
		System.out.println("线程停止");
	}

	public static void main(String[] args) throws InterruptedException {
		ValatileDemo demo=new ValatileDemo();
		demo.start();
		Thread.sleep(1000);
		demo.setRunning(false);
		System.out.println("isRunning设置成false");
	}

}
