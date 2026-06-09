package com.kh.object.ex1;

public class Run {

	public static void main(String[] args) {
		
		Student s1;
		s1 = new Student();
		s1.name = "Bart Simpson";
		s1.age = 18;
		
		s1.myInfo();
		
		Student s2;
		s2 = new Student("Lisa Simpson", 15);
		
		s2.myInfo();

	}

}
