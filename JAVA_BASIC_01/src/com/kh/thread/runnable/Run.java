package com.kh.thread.runnable;

public class Run {
	/*
	 * 스레드 : 프로그램 내에서 실행의 흐름을 가지고 있는 최소단위
	 * main메서드 실행시 메인 스레드가 실행됨
	 * 
	 * 스레드를 만드는 법1 : Runnable 인터페이스를 구현
	 * run() 메서드에 해당 스레드에서 실행하고자 하는 코드를 재정의
	 * 
	 * 스레드를 만드는 법2 : Thread 클래스를 상속받기
	 * run() 메서드에 해당 스레드에서 실행하고자 하는 코드를 재정의
	 */
	
	public static void main(String[] args) {
		
		Runnable run1 = new Task1();
		Thread t1 = new Thread(run1);
		
		Thread t2 = new Task2();
		
		t1.start();
		t2.start();
		System.out.println("END : " + Thread.currentThread().getName());
	}
}
