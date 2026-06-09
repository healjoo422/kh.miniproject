package com.kh.example.Inherit;

import java.util.Scanner;

public class PointMenu {

	Scanner sc = new Scanner(System.in);
	CircleController cc = new CircleController();
	RectangleController rc = new RectangleController();
	
	public void mainMenu() {
		int select = 0;
		while(select != 9) {
			System.out.println();
			System.out.println("===== 메뉴 =====");
			System.out.println("1. 원");
			System.out.println("2. 사각형");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");

			select = sc.nextInt();
			sc.nextLine();
			
			switch(select) {
			case 1:
				this.circleMenu();
				break;
			case 2:
				this.rectangleMenu();
				break;
			case 9:
				System.out.println("종료합니다.");
				break;
			default :
				System.out.println("잘못된 입력입니다.");
				break;
			}
		}
	}
	
	public void circleMenu() {
		// 원 메뉴 출력 (1. 둘레, 2. 넓이, 9. 메인으로)
		int select = 0;
		while(select != 9) {
			System.out.println();
			System.out.println("===== 원 메뉴 =====");
			System.out.println("1. 원 둘레");
			System.out.println("2. 원 넓이");
			System.out.println("9. 메인으로");
			System.out.print("메뉴 번호 : ");
			
			select = sc.nextInt();
			sc.nextLine();
			
			switch(select) {
			case 1:
				this.calcCircum();
				break;
			case 2:
				this.calcCircleArea();
				break;
			case 9:
				System.out.println("메인으로 돌아갑니다.");
				break;
			default :
				System.out.println("잘못된 입력입니다.");
				break;
			}
		}
	}
	
	public void rectangleMenu() {
		// 사각형 메뉴 출력 (1. 둘레, 2. 넓이, 9. 메인으로)
		int select = 0;
		while(select != 9) {
			System.out.println();
			System.out.println("===== 사각형 메뉴 =====");
			System.out.println("1. 사각형 둘레");
			System.out.println("2. 사각형 넓이");
			System.out.println("9. 메인으로");		
			System.out.print("메뉴 번호 : ");

			select = sc.nextInt();
			sc.nextLine();

			switch(select) {
			case 1:
				this.calcPerimeter();
				break;
			case 2:
				this.calcRectArea();
				break;
			case 9:
				System.out.println("메인으로 돌아갑니다.");
				break;
			default :
				System.out.println("잘못된 입력입니다.");
				break;
			}
		}
	}
	public void calcCircum() {
		// 좌표·반지름 입력 → cc.calcCircum() 호출 및 출력
		int x, y, radius;
		System.out.print("x 좌표 : ");
		x = sc.nextInt();	sc.nextLine();
		System.out.print("y 좌표 : ");
		y = sc.nextInt();	sc.nextLine();
		System.out.print("반지름 : ");
		radius = sc.nextInt();	sc.nextLine();
		
		System.out.println(cc.calcCircum(x, y, radius));
	}
	public void calcCircleArea() {
		// 좌표·반지름 입력 → cc.calcArea() 호출 및 출력
		int x, y, radius;
		System.out.print("x 좌표 : ");
		x = sc.nextInt();	sc.nextLine();
		System.out.print("y 좌표 : ");
		y = sc.nextInt();	sc.nextLine();
		System.out.print("반지름 : ");
		radius = sc.nextInt();	sc.nextLine();
		
		System.out.println(cc.calcArea(x, y, radius));
		
		
	}
	public void calcPerimeter() {
		// 좌표·너비·높이 입력 → rc.calcPerimeter() 호출 및 출력
		int x, y, width, height;
		
		System.out.print("x 좌표 : ");
		x = sc.nextInt();	sc.nextLine();
		System.out.print("y 좌표 : ");
		y = sc.nextInt();	sc.nextLine();
		System.out.print("너비 : ");
		width = sc.nextInt();	sc.nextLine();
		System.out.print("높이 : ");
		height = sc.nextInt();	sc.nextLine();
		
		System.out.println(rc.calcPerimeter(x, y, width, height));
		
		
	}
	public void calcRectArea() {
		// 좌표·너비·높이 입력 → rc.calcArea() 호출 및 출력
		int x, y, width, height;
		
		System.out.print("x 좌표 : ");
		x = sc.nextInt();	sc.nextLine();
		System.out.print("y 좌표 : ");
		y = sc.nextInt();	sc.nextLine();
		System.out.print("너비 : ");
		width = sc.nextInt();	sc.nextLine();
		System.out.print("높이 : ");
		height = sc.nextInt();	sc.nextLine();
		
		System.out.println(rc.calcArea(x, y, width, height));
		
	}
}
