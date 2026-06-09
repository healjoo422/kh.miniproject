package com.kh.polymorphism;

public class Avante extends Car {

	public Avante(String color, String fuel, int year) {
		super(color, fuel, year);
	}
	
	@Override
	public void drive() {
		System.out.println("슈웅슈웅");
	}

	public void moveAvante() {
		System.out.println("빵빵~ Avante");
	}
	
	
	// 문법상 오류는 없지만 넘겨받은 Car 참조형 객체가 Avante가 아닐 경우 오류를 야기한다
	// 그래서 instanceof 를 통해 실제로 Avante 객체를 포함하고 있는지 체크해주어야 함
	public void driveCar(Car car) {
		if(car instanceof Avante) {
			((Avante)car).moveAvante();
		}
	}
	
}
