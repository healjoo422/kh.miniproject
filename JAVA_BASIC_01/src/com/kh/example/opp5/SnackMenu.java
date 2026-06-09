package com.kh.example.opp5;

import java.util.Scanner;

import javax.security.auth.callback.ConfirmationCallback;

public class SnackMenu {
	Scanner sc = new Scanner(System.in);
	SnackController scr = new SnackController();
	
	public void menu() {
		String kind;
		String name;
		String flavor;
		int numOf;
		int price;
		char ch;
		
		System.out.print("종류 : ");
		kind = sc.nextLine();
		System.out.print("이름 : ");
		name = sc.nextLine();
		System.out.print("맛 : ");
		flavor = sc.nextLine();
		System.out.print("개수 : ");
		numOf = sc.nextInt();	sc.nextLine();
		System.out.print("가격 : ");
		price = sc.nextInt();	sc.nextLine();
		
		System.out.println(scr.saveData(kind, name, flavor, numOf, price));
		
		System.out.print("저장한 정보를 확인하시겠습니까?(y/n) : ");
		ch = sc.nextLine().charAt(0);
		if(ch == 'y' || ch == 'Y') System.out.println(scr.confirmData());
		
		
		return;
	}
}
