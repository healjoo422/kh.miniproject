package com.kh.example.Inherit2;

public class PersonController {

	private Student[] s = new Student[3];
	private Employee[] e = new Employee[10];
	
	public int[] personCount() {
		int[] iArr = { 3, 10 };
		
		// 순회하다가 s에 빈칸이 있다면 해당 인덱스 저장하고 순회중지
		for(int i=0; i<s.length; i++) {
			if(s[i] == null) {
				iArr[0] = i;
				break;
			}
		}
		
		// 순회하다가 e에 빈칸이 있다면 해당 인덱스 저장하고 순회중지
		for(int i=0; i<e.length; i++) {
			if(e[i] == null) {
				iArr[1] = i;
				break;
			}
		}
		
		// 빈칸이 없다면 사전에 저장해뒀던 3, 10이 반환됨
		return iArr;
	}
	
	public void insertStudent(String name, int age, double height, double weight, int grade, String major) {
		// 순회하다가 빈칸 발견하면 해당 칸에 객체 생성 후 순회중지
		for(int i=0; i<s.length; i++) {
			if(s[i] == null) {
				s[i] = new Student(name, age, height, weight, grade, major);
				break;
			}
		}
	}
	
	public Student[] printStudent() {
		return this.s;
	}
	
	public void insertEmployee(String name, int age, double height, double weight, int salary, String dept) {
		// 순회하다가 빈칸 발견하면 해당 칸에 객체 생성 후 순회중지
		for(int i=0; i<e.length; i++) {
			if(e[i] == null) {
				e[i] = new Employee(name, age, height, weight, salary, dept);
				break;
			}
		}
	}
	
	public Employee[] printEmployee() {
		return this.e;
	}
}
