package com.kh.example.oop7;

import java.util.Scanner;

public class ProductMenu {

	private ProductController pc = new ProductController();
	private Scanner sc = new Scanner(System.in);
	private int select = 0;
	
	public void mainMenu() {
		while(select != 9) {
			System.out.println();
			System.out.println("====== 상품 관리 메뉴 ======");
			System.out.println("1. 상품 추가");
			System.out.println("2. 상품 전체 조회");
			System.out.println("9. 프로그램 종료");
			System.out.print("메뉴 번호 : ");
			
			select = sc.nextInt();	sc.nextLine();
			
			switch(select) {
			case 1:
				String pName, brand;
				int price;
				
				System.out.print("추가할 상품명 : ");
				pName = sc.nextLine();
				System.out.print("추가할 가격 : ");
				price = sc.nextInt();	sc.nextLine();
				System.out.print("추가할 브랜드 : ");
				brand = sc.nextLine();
				
				pc.insertProduct(pName, price, brand);
				
				break;
				
			case 2:
				for(int i=0; i<ProductController.qty; i++) {
					System.out.println(pc.selectProduct()[i].inform());
				}
				break;
				
			case 9:
				System.out.println("프로그램을 종료합니다.");
				break;
				
			default :
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
}
