package com.kh.exampletest;


public class Run {

	public static void main(String[] args) {
		
		try {
			System.out.println("실행중1");
			throw new Exception("일부러 발생시킨 오류");
		} 
		catch(Exception e) {
			System.out.println("오류가 발생했습니다");
			e.printStackTrace();
		}
<<<<<<< HEAD
		
		System.out.println("트라이캐치 종료!!");
=======
>>>>>>> c44e760f93dd45ba51bfe76aeafff59304d544b1
	}
}
