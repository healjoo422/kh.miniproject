package com.kh.example.opp4;

import java.util.Scanner;

public class ShapeMenu {
	Scanner sc;
	SquareController scr;
	TriangleController tc;
	
	public ShapeMenu() {
		sc = new Scanner(System.in);
		scr = new SquareController();
		tc = new TriangleController();
	}
	
	public void inputMenu() {
		while(true) {
			System.out.println();
			System.out.println("===== 도형 프로그램 =====");
			System.out.println("3. 삼각형");
			System.out.println("4. 사각형");
			System.out.println("9. 프로그램 종료");
			System.out.print("메뉴 번호 : ");
			
			int cont = 0;
			cont = sc.nextInt();
			sc.nextLine();
			
			switch(cont) {
				case 3:
					triangleMenu();
					break;
				case 4: 
					squareMenu();
					break;
				case 9: 
					return;
				default: 
					System.out.println("잘못된 번호입니다. 다시 입력하세요");
					break;
			}
		}
	}
	
	private void triangleMenu() {
		while(true) {
			System.out.println();	
			System.out.println("===== 삼각형 =====");
			System.out.println("1. 삼각형 면적");
			System.out.println("2. 삼각형 색칠");
			System.out.println("3. 삼각형 정보");
			System.out.println("9. 메인으로 ");
			System.out.print("메뉴 번호 : ");
			
			int cont = 0;
			cont = sc.nextInt();
			sc.nextLine();
			
			switch(cont) {
				case 1:
					inputSize(3, cont);
					break;
				case 2:
					System.out.print("색깔을 입력하세요 : ");
					tc.paintColor(sc.nextLine());
					break;
				case 3:
					printInformation(3);
					break;
				case 9:
					return;
				default :
					System.out.println("잘못된 번호입니다. 다시 입력하세요");
					break;					
			}
		}
		
	}
	
	private void squareMenu() {
		while(true) {
			System.out.println();
			System.out.println("===== 사각형 =====");
			System.out.println("1. 사각형 둘레");
			System.out.println("2. 사각형 면적");
			System.out.println("3. 사각형 색칠");
			System.out.println("4. 사각형 정보");
			System.out.println("9. 메인으로 ");
			System.out.print("메뉴 번호 : ");
			
			int cont = 0;
			cont = sc.nextInt();
			sc.nextLine();
			
			switch(cont) {
				case 1:
					inputSize(4, cont);
					break;
				case 2:
					inputSize(4, cont);
					break;
				case 3:
					System.out.print("색깔을 입력하세요 : ");
					scr.paintColor(sc.nextLine());
					break;
				case 4:
					printInformation(4);
					break;
				case 9:
					return;
				default:
					System.out.println("잘못된 번호입니다. 다시 입력하세요");
					break;
					
			}
		}

	}
	
	private void inputSize(int type, int menuNum) {
		System.out.print("높이 : ");
		int height = sc.nextInt();
		sc.nextLine();
		System.out.print("너비 : ");
		int width = sc.nextInt();
		sc.nextLine();
		
		switch(type) {
			case 3:
				System.out.println("삼각형 면적 : "+ tc.calcArea(height, width));
				break;
			case 4:
				if(menuNum == 1) {
					System.out.println("사각형 둘레 : "+ scr.clacPerimeter(height, width));
					break;
				}
				else if(menuNum == 2) {
					System.out.println("사각형 면적 : "+ scr.calcArea(height, width));
					break;
				}
				
		}
		
	}
	
	private void printInformation(int type) {
		switch(type) {
			case 3:
				System.out.println(tc.print());
				break;
			case 4:
				System.out.println(scr.print());
				break;
		}	
	}
}
