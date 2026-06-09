package com.kh.example.oop2;

public class Student {
	private int grade;
	private int classroom;
	private String name;
	private double height;
	private char gender;
	
	{
		grade = 1;
		classroom = 3;
		name = "박순자";
		height = 158;
		gender = 'F';
	}
	
	
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getClassroom() {
		return classroom;
	}
	public void setClassroom(int classroom) {
		this.classroom = classroom;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public String information() {
	/*	String str = 	"학년 : "+ Integer.toString(grade) +
						"\n반 : "+ Integer.toString(classroom) +
						"\n이름 : "+ name +
						"\n몸무게 : "+ Double.toString(height) +
						"\n성별 : "+ gender;
						*/
		String str = grade +", "+ classroom +", "+ name +", "+ height +", "+ gender;
		return str;
	}
}
