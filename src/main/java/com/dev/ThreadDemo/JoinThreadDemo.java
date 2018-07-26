package com.dev.ThreadDemo;

public class JoinThreadDemo {

	public static void main(String[] args) {

		final Thread t1 = new Thread(new Runnable() {
			public void run() {
				System.out.println("t1");
			}
		});

		final Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					t1.join();
				} catch (InterruptedException e) {

				}
				System.out.println("t2");

			}

		});
		final Thread t3 = new Thread(new Runnable() {
			public void run() {
				try {
					t2.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("t3");

			}
		});

		t1.start();
		t2.start();
		t3.start();

	}
}
