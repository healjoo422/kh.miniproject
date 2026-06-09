package com.kh.polymorphism;

public class Run {

	public static void main(String[] args) {

	
		Cake b1 = new CheeseCake();
		CheeseCake b2 = new CheeseCake();
		
		b1.sweet();
		b1.yummy();
		b2.yummy();
		
		
		
		Car c1 = new Car("Red", "gasoline", 2021);
		c1.drive();
		
		Avante c2 = new Avante("white", "LPG", 2023);
		c2.drive();	// 오버라이딩된 drive가 호출
		c2.moveAvante();
		
		Car c3 = c2; // 업캐스팅
		c3.drive(); // 생성된 객체는 Avante 이기 때문에 오버라이딩 된 drive가 호출됨
//		c3.moveAvante();  업캐스팅이기 때문에 자식 객체의 멤버변수에는 접근할 수 없음
		
		Car c4 = new Sonata("black", "diesel", 2024); // 업캐스팅
		((Sonata)c4).moveSonata();
		// c4는 Car 참조형 변수지만 실제로 가르키고 있는 객체는 Sonata라는 Car의 자식 객체임
		// 따라서 다운캐스팅이 가능
		// 프로그래머가 명시적으로 지정해줘야만 가능함
	
		c2.driveCar(c1); // 문법상 오류는 없지만, 
		
	}

}
