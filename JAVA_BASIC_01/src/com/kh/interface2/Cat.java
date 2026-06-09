package com.kh.interface2;

public class Cat extends Animal {

	// 추상 클래스를 상속받았기 때문에 무조건 추상 메서드를 오버라이딩으로 구현해야 함
	@Override
	public void speak() {
		System.out.println("야옹~");
		
	}
}
