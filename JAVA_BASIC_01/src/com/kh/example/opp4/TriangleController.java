package com.kh.example.opp4;

public class TriangleController {
	Shape s;
	
	public TriangleController() {
		s = new Shape();
	}
	
	public double calcArea(double height, double width){
		s = new Shape(3, height, width);
		return width * height / 2;
	}
	
	public void paintColor(String color) {
		s.setColor(color);
	}
	
	public String print() {
		return "삼각형 " + s.infomation();
	}
}
