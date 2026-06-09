package com.kh.thread.runnable;

public class Task2 extends Thread{
	
	@Override
	public void run() {
		/*
		int n1 = 20;
		int n2 = 30;
		
		String name = Thread.currentThread().getName();
		System.out.println(name+ " : " + (n1+n2));
		*/
		try {
			for(int i=1; i<=20; i++) {
				if(i % 2 != 0) {
					System.out.print(i + " ");
				}
				Thread.sleep(400);
			}
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
