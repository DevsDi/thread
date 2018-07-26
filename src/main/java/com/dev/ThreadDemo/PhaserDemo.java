package com.dev.ThreadDemo;

import java.util.concurrent.Phaser;

public class PhaserDemo implements Runnable {

	private Phaser phaser;

	public PhaserDemo(Phaser phaser) {
		this.phaser = phaser;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName() + "===============11111===============");
		phaser.arriveAndAwaitAdvance();

		System.out.println(Thread.currentThread().getName() + "===============22222===============");
		phaser.arriveAndAwaitAdvance();

		phaser.arriveAndDeregister();
		System.out.println("----------------");
	}

	public static void main(String[] args) {
		Phaser phaser = new Phaser();

		for (int i = 0; i < 3; i++) {
			new Thread(new PhaserDemo(phaser)).start();
			phaser.register();
		}

	}

}