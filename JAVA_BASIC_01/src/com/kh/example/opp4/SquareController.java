package com.kh.example.opp4;

public class SquareController {
	Shape s;
	
	public SquareController() {
		s = new Shape();
	}
	
	public double clacPerimeter(double height, double width){
		s = new Shape(4, height, width);
		return (width*2) + (height*2);
	}
	
	public double calcArea(double height, double width) {
		s = new Shape(4, height, width);
		return height * width;
	}
	
	public void paintColor(String color) {
		s.setColor(color);
	}
	
	public String print() {
		return "사각형 " + s.infomation(); 
	}
	
	
}
