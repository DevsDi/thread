package com.dev.ThreadDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {
//	private int t = 0;
	private AtomicInteger t=new AtomicInteger(0);

	synchronized int add() {
//		t = t + 10;
//		return t;
//		t.addAndGet(10);
		t.addAndGet(4);
		t.addAndGet(3);
		t.addAndGet(2);
		t.addAndGet(1);
		return t.get();
	}

	public static void main(String[] args) {
		final AtomicDemo demo = new AtomicDemo();
		List<Thread> list = new ArrayList<Thread>();
		for (int i = 0; i < 100; i++) {
			list.add(new Thread(new Runnable() {

				public void run() {
					System.out.println("t === " + demo.add());
				}
			}));
		}

		for (Thread thread : list) {
			thread.start();
		}

	}

}
