package com.kh.object.ex2;

public class BankAccount {
	// 필드
	int balance;
	String accountNumber;
	
	/*
	 * 개발자가 생성자를 정의하지 않으면, 컴파일 과정에서 기본생정자가 자동으로 생성됨
	 * 생성자를 하나라도 정의한다면, 기본생정자는 생성되지 않는다
	 * 생성자는 여러개가 존재 할 수 있다
	 */
	public BankAccount() {
		// TODO Auto-generated constructor stub
	}
	public BankAccount(int balance, String accountNumber) {
		this.balance = balance;
		this.accountNumber = accountNumber;
	}
	
	
	// 입금 메서드
	void deposit(int amount) {
		balance += amount;
	}
	
	// 출금 메서드
	void withdraw(int amount) {
		balance -= amount;
	}
	
	// 잔액조회 메서드
	void checkMyBalance() {
		System.out.println("balance : " + balance);
	}
}
