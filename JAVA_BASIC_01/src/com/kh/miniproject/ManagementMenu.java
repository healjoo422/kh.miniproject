package com.kh.miniproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagementMenu {

	BookController bc = new BookController();
	PersonController pc = new PersonController();
	Scanner sc = new Scanner(System.in);
	
	public void menu() {
		while(true) {
			System.out.println();
			System.out.println("=== 도서 관리 프로그램 ===");
			System.out.println("1. 사용자 등록");
			System.out.println("2. 사용자 탈퇴");
			System.out.println("3. 전체 사용자 목록");
			System.out.println("4. 도서 추가");
			System.out.println("5. 도서 삭제");
			System.out.println("6. 전체 도서 목록");
			System.out.println("7. 도서 대출");
			System.out.println("8. 도서 반납");
			System.out.println("9. 연체료 납부");
			System.out.println("10. 사용자 검색(이름으로)");
			System.out.println("11. 도서 검색(제목)");
			System.out.println("0. 종료");
			System.out.print("메뉴를 선택해 주세요 : ");
			int select = sc.nextInt();
			sc.nextLine();
			
			switch(select) {
			case 1:
				registUser();
				break;
			case 2:
				removeUser();
				break;
			case 3:
				printAllUser();
				break;
			case 4:
				addBook();
				break;
			case 5:
				removeBook();
				break;
			case 6:
				printAllBook();
				break;
			case 7:
				rentBook();
				break;
			case 8:
				returnBook();
				break;
			case 9:
				fee();
				break;
			case 10:
				searchUser();
				break;
			case 11:
				searchBook();
				break;
			case 0:
				return;
			default :
				System.out.println("잘못된 입력입니다");
			}
		}
	
	}
	
	// 사용자 등록
	public void registUser() {
		String userName, phoneNumber;
		
		System.out.print("등록할 사용자 이름을 입력해주세요 : ");
		userName = sc.nextLine();
		
		System.out.print("핸드폰 번호를 입력해주세요('-' 제외) : ");
		phoneNumber = sc.nextLine();
		
		Person p1 = new Person(userName, phoneNumber);
		
		pc.registUser(p1);	
	}
	
	// 사용자 삭제
	public void removeUser() {
		int num1;
		
		System.out.print("사용자 번호를 입력하세요 : ");
		num1 = sc.nextInt();
		sc.nextLine();
		
		Person p = pc.getPerson(num1);
		
		if(p == null) {
			System.out.println("일치하는 사용자가 없습니다!");
			return;
		}
		
		if(p.getFee() != 0) {
			System.out.println("연체료가 정산되지 않아 탈퇴할 수 없습니다");
			return;
		}

		pc.removeUser(p);	
	}
	
	// 전체 회원 리스트 출력
	public void printAllUser() {
		List<Person> pl = pc.getPersonList();
		
		for(Person p : pl) {
			System.out.println(p);
		}
	}
	
	// 사용자 검색
	public void searchUser() {
		String str;
		
		System.out.print("검색할 사용자 이름 입력 : ");
		str = sc.nextLine();
		
		int result = pc.seachPerson(str);
		
		if(result == 0) {
			System.out.println("이름이 일치하는 사용자가 없습니다");
		}
	}
	
	// 도서 추가
	public void addBook() {
		String str1, str2;
		
		System.out.print("제목 입력 : ");
		str1 = sc.nextLine();
		
		System.out.print("저자 입력 : ");
		str2 = sc.nextLine();
		
		bc.addBook(str1, str2);
	}
	
	
	// 도서 삭제
	public void removeBook() {
		int num1;
		
		System.out.print("도서 관리번호 입력 : ");
		num1 = sc.nextInt();
		sc.nextLine();
		
		bc.removeBook(num1);
	}
	
	// 전체 도서 리스트 출력
	public void printAllBook() {
		List<Book> bl = bc.allBook();
		
		for(Book b : bl) {
			System.out.println(b);
		}
	}
	
	// 도서 검색
	public void searchBook() {
		String name;
		
		System.out.print("검색하고 싶은 도서의 이름을 입력해주세요 : ");
		name = sc.nextLine();
		
		List<Book> bl = bc.searchBook(name);
		
		if(bl == null) {
			System.out.println("일치하는 도서가 없습니다!");
			return;
		}
		for(Book b : bl) {
			System.out.println(b);
		}
		
		
	}
	
	// 도서 대출
	public void rentBook() {
		int bookNum, userNum, date;
		
		System.out.print("도서 관리번호를 입력해주세요 : ");
		bookNum = sc.nextInt();
		sc.nextLine();
		
		System.out.print("사용자 번호를 입력해주세요 : ");
		userNum = sc.nextInt();
		sc.nextLine();
		
		System.out.print("대출일을 입력해주세요 : ");
		date = sc.nextInt();
		sc.nextLine();
		
		List<Person> pl = pc.getPersonList();
		for(Person p : pl) {
			if(p.getManagementID() == userNum) {
				int due = bc.rentBook(bookNum, userNum, date);
				System.out.println("예정 반납일은 "+due+"일 입니다");
				return;
			}
		}
		
		System.out.println("일치하는 사용자가 없습니다");
	
	}
	
	// 도서 반납(연체시 연체료 발생)
	public void returnBook() {
		int bookNum, date;
		
		System.out.print("도서 관리번호를 입력해주세요 : ");
		bookNum = sc.nextInt();
		sc.nextLine();
		
		System.out.print("반납일을 입력해주세요 : ");
		date = sc.nextInt();
		sc.nextLine();
		
		RentRecord r = bc.returnBook(bookNum, date);
		
		if(r == null) {
			return;
		}
		
		int num1 = r.getReturnDate() - r.getDueDate();
		if(num1 > 0) {
			System.out.println("반납이 " +num1+ "일 늦어졌습니다");
			System.out.println("연체료를 " +(num1*100)+ "원 부과합니다");
			
			pc.addFee(r.getmanagementID(), num1*100);
		}
				
	}
	
	// 요금 납부
	public void fee() {
		int num1, num2;
		
		System.out.print("사용자 번호를 입력해주세요 : ");
		num1 = sc.nextInt();
		sc.nextLine();
				
		System.out.print("납부할 금액을 입력해주세요 : ");
		num2 = sc.nextInt();
		sc.nextLine();
		
		int result = pc.subFee(num1, num2);
		
		if(result == -1) {
			System.out.println("사용자 번호를 잘못 입력하셨습니다");
		}
		
		System.out.println("남은 연체료는 " +result+ "원 입니다");
	}
	 
}
