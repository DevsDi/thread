package com.dev.ThreadDemo;

public class ThreadlocalDemo {

	ThreadLocal<String> threadLocal = new ThreadLocal<String>();

	public void setThreadLocal(String val) {
		threadLocal.set(val);
	}

	public String getThreadLocal() {
		return threadLocal.get();
	}

	public static void main(String[] args) throws Exception {
		final ThreadlocalDemo demo = new ThreadlocalDemo();
		new Thread(new Runnable() {

			public void run() {
				demo.setThreadLocal("t1");
				System.out.println("t1==>" + demo.getThreadLocal());
			}
		}, "t1").start();

		new Thread(new Runnable() {

			public void run() {
				demo.setThreadLocal("t2");
				System.out.println("t2==>" + demo.getThreadLocal());
			}
		}, "t2").start();

		Thread.sleep(1000);
		System.out.println("main==>" + demo.getThreadLocal());

	}

}
