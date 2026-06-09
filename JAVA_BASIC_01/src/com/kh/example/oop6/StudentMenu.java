package com.kh.example.oop6;

public class StudentMenu {
	
	StudentController ssm = new StudentController();
	
	public StudentMenu() {
		int sArrLength = ssm.printStudent().length;
		// 학생 정보 출력
		System.out.println("==========학생 정보 출력==========");
		for(int i=0; i<sArrLength; i++) {
			System.out.println(ssm.printStudent()[i].inform());
		}
		
		// 학생 성적 출력
		System.out.println();
		System.out.println("==========학생 성적 출력==========");
		System.out.println("학생 점수 합계 : " + (int)ssm.avgScore()[0]);
		System.out.println("학생 점수 평균 : " + ssm.avgScore()[1]);
		
		// 성적 결과 출력
		System.out.println();
		System.out.println("==========성적 결과 출력==========");
		for(int i=0; i<sArrLength; i++) {
			System.out.print(ssm.printStudent()[i].getName()+"학생은 ");
			if(ssm.printStudent()[i].getScore() < StudentController.CUT_LINE) {
				System.out.println("재시험 대상입니다.");
			}
			else {
				System.out.println("통과입니다.");
			}
		}
		
	}
}
