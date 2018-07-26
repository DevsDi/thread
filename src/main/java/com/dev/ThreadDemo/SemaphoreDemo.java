package com.dev.ThreadDemo;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
	// 控制线程的数目为1，也就是单线程
	private Semaphore semaphore = new Semaphore(3);

	public void driveCar() {
		try {
			
			semaphore.acquire();
			System.out.println(Thread.currentThread().getName() + " start at "+ System.currentTimeMillis());
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + " stop at "+  System.currentTimeMillis());
			// 释放允许，将占有的信号量归还
			semaphore.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SemaphoreDemo driver = new SemaphoreDemo();
		for (int i = 0; i < 5; i++) {
			(new Car(driver)).start();
		}
	}
}

class Car extends Thread {
	private SemaphoreDemo driver;

	public Car(SemaphoreDemo driver) {
		super();
		this.driver = driver;
	}

	public void run() {
		driver.driveCar();
	}
}