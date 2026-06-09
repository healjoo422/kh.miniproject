package com.kh.example.Inherit2;

import java.util.Scanner;

public class PersonMenu {

	private Scanner sc = new Scanner(System.in);
	private PersonController pc = new PersonController();
	
	public void mainMenu() {
		// 전체 메뉴 출력 및 선택 처리
		// 학생 수 3명 초과 시 추가 불가, 사원 수 10명 초과 시 추가 불가
		while(true) {
			System.out.println("학생은 최대 "+pc.printStudent().length+"명까지 저장할 수 있습니다.");
			System.out.println("현재 저장된 학생은 "+pc.personCount()[0]+"명입니다.");
			
			System.out.println("사원은 최대 "+pc.printEmployee().length+"명까지 저장할 수 있습니다.");
			System.out.println("현재 저장된 사원은 "+pc.personCount()[1]+"명입니다.");
			
			System.out.println();
			System.out.println("=== 전체 메뉴 ===");
			System.out.println("1. 학생 메뉴");
			System.out.println("2. 사원 메뉴");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			
			int select = sc.nextInt();
			sc.nextLine();
			
			switch(select) {
			case 1:
				this.studentMenu();
				break;
			case 2:
				this.employeeMenu();
				break;
			case 9:
				System.out.println("종료합니다.");
				return;
			default :
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
	
	public void studentMenu() {
		while(true) {
			System.out.println();
			System.out.println("=== 학생 메뉴 ===");
			System.out.println("1. 학생 추가");
			System.out.println("2. 학생 보기");
			System.out.println("9. 메인으로");
			System.out.print("메뉴 번호 : ");

			int select = sc.nextInt();
			sc.nextLine();

			switch(select) {
			case 1:
				this.insertStudent();
				break;
			case 2:
				this.printStudent();
				break;
			case 9:
				return;
			default :
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
	
	public void employeeMenu() {
		while(true) {
			System.out.println();
			System.out.println("=== 사원 메뉴 ===");
			System.out.println("1. 사원 추가");
			System.out.println("2. 사원 보기");
			System.out.println("9. 메인으로");
			System.out.print("메뉴 번호 : ");
			
			int select = sc.nextInt();
			sc.nextLine();
			
			switch(select) {
			case 1:
				this.insertEmployee();
				break;
			case 2:
				this.printEmployee();
				break;
			case 9:
				return;
			default :
				System.out.println("잘못된 입력입니다");
			}
		}
	}
	
	public void insertStudent() {
		while(true) {

			if(pc.personCount()[0] == pc.printStudent().length) {
				System.out.println("학생을 담을 수 있는 공간이 꽉 찼기 때문에 학생 추가를 종료하고 학생 메뉴로 돌아갑니다.");
				return;
			}

			System.out.print("학생 이름 : ");
			String name = sc.nextLine();

			System.out.print("학생 나이 : ");
			int age = sc.nextInt();
			sc.nextLine();

			System.out.print("학생 키 : ");
			double height = sc.nextDouble();
			sc.nextLine();

			System.out.print("학생 몸무게 : ");
			double weight = sc.nextDouble();
			sc.nextLine();

			System.out.print("학생 학년 : ");
			int grade = sc.nextInt();
			sc.nextLine();

			System.out.print("학생 전공 : ");
			String major = sc.nextLine();	

			pc.insertStudent(name, age, height, weight, grade, major);
			
			System.out.print("그만하시려면 N(또는 n), 이어하시려면 아무 키나 누르세요 : ");
			char ch = sc.nextLine().charAt(0);
			if(ch == 'n' || ch == 'N') {
				System.out.println("학생 메뉴로 돌아갑니다.");
				return;
			}
		}
	}
	
	public void printStudent() {
		for(int i=0; i<pc.printStudent().length; i++) {
			if(pc.printStudent()[i] == null) {
				return;
			}
			System.out.println(pc.printStudent()[i].toString());
		}
	}
	
	public void insertEmployee() {
		while(true) {
 
			if(pc.personCount()[1] == pc.printEmployee().length) {
				System.out.println("사원을 담을 수 있는 공간이 꽉 찼기 때문에 사원 추가를 종료하고 사원 메뉴로 돌아갑니다.");
				return;
			}

			System.out.print("사원 이름 : ");
			String name = sc.nextLine();

			System.out.print("사원 나이 : ");
			int age = sc.nextInt();
			sc.nextLine();

			System.out.print("사원 키 : ");
			double height = sc.nextDouble();
			sc.nextLine();

			System.out.print("사원 몸무게 : ");
			double weight = sc.nextDouble();
			sc.nextLine();

			System.out.print("사원 급여 : ");
			int salary = sc.nextInt();
			sc.nextLine();

			System.out.print("사원 부서 : ");
			String dept = sc.nextLine();	

			pc.insertEmployee(name, age, height, weight, salary, dept);
		
			System.out.print("그만하시려면 N(또는 n), 이어하시려면 아무 키나 누르세요 : ");
			char ch = sc.nextLine().charAt(0);
			if(ch == 'n' || ch == 'N') {
				System.out.println("사원 메뉴로 돌아갑니다.");
				return;
			}
		}
	}
	
	public void printEmployee() {
		for(int i=0; i<pc.printEmployee().length; i++) {
			if(pc.printEmployee()[i] == null) {
				return;
			}
			System.out.println(pc.printEmployee()[i].toString());
		}
	}

}
/*
쿨찐들이 좋아해서 3대 쿨찐캐릭인데
시간이 지나면서 키워드만 전승되니까 잘 모르는 사람들은 얘네가 쿨찐인줄 알아요
아라라기 코요미씨는 생긴것과는 다르게 초 열혈 캐릭터구요...
오레키 호타로씨도 능력있고, 인망있는 사람인데 그냥 귀차니스트일 뿐입니다



*/