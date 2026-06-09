package com.kh.example.collection2;

import java.util.Scanner;

public class LotteryMenu {

	private Scanner sc = new Scanner(System.in);
	private LotteryController lc = new LotteryController();
	
	public void mainMenu() {
		System.out.println("========== KH 추첨 프로그램 ==========");
		while(true) {
			System.out.println("***** 메인 메뉴 *****");
			System.out.println("1. 추첨 대상 추가");
			System.out.println("2. 추첨 대상 삭제");
			System.out.println("3. 추첨 대상 확인");
			System.out.println("4. 정렬된 당첨 대상 확인");
			System.out.println("5. 당첨 대상 검색");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 입력 : ");
			
			int select = sc.nextInt();
			sc.nextLine();
			
			switch(select) {
			case 1:
				insertObject();
				break;
			case 2:
				deleteObject();
				break;
			case 3:
				winObject();
				break;
			case 4:
				sortedWinObject();
				break;
			case 5:
				searchWinner();
				break;
			case 9:
				return;
			default:
				System.out.println("잘못된 입력입니다.");
			}
			
		}
	}
	
	private void insertObject() {
		int num=0, total=0;
		String name, phone;
		
		
		System.out.print("추가할 추첨 대상 수 : ");
		total = sc.nextInt();
		sc.nextLine();
		
		while(num != total) {
			System.out.print("이름 : ");
			name = sc.nextLine();
			System.out.print("핸드폰 번호('-'제외) : ");
			phone = sc.nextLine();
			
			if(lc.insertObject(new Lottery(name, phone))) {
				num++;
			}
			else {
				System.out.println("이미 있는 대상입니다. 다시 입력해주세요.");
			}
		}
		
		System.out.println(num +"명 추가 완료되었습니다.");
	}
	
	private void deleteObject() {
		String name, phone;
		
		System.out.println("삭제한 대상의 이름과 핸드폰 번호를 입력하세요.");
		System.out.print("이름 : ");
		name = sc.nextLine();
		System.out.print("핸드폰 번호('-'제외) : ");
		phone = sc.nextLine();
		
		if(lc.deleteObject(new Lottery(name, phone))) {
			System.out.println("삭제 완료 되었습니다.");
		}
		else {
			System.out.println("존재하지 않는 대상입니다.");
		}
	}
	
	private void winObject() {
		System.out.println(lc.winObject());
	}
	
	private void sortedWinObject() {
		
	}
	
	private void searchWinner() {
		String name, phone;
		
		System.out.println("검색할 대상의 이름과 핸드폰 번호를 입력하세요.");
		System.out.print("이름 : ");
		name = sc.nextLine();
		System.out.print("핸드폰 번호('-'제외) : ");
		phone = sc.nextLine();
		
		if(lc.searchWinner(new Lottery(name, phone))) {
			System.out.println("축하합니다. 당첨 목록에 존재합니다.");
		}
		else {
			System.out.println("안타깝지만 당첨 목록에 존재하지 않습니다.");
		}
	}
}
