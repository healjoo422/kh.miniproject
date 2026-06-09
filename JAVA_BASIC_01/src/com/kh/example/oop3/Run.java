package com.kh.example.oop3;

public class Run {

	public static void main(String[] args) {
		Book b1 = new Book();
		Book b2 = new Book("호밀밀 밭의 파수꾼", "출판사G", "제롬 데이비드 셀린저");
		Book b3 = new Book("데미안", "출판사D", "헤르만 헤세", 28000, 10.5);
		
		b1.inform();
		b2.inform();
		b3.inform();

		
	}

}
