package com.kh.example.Inherit;

public class RectangleController {
	
	Rectangle r = new Rectangle();
	
	public String calcArea(int x, int y, int width, int height) {
		this.r.setX(x);
		this.r.setY(y);
		this.r.setHeight(height);
		this.r.setWidth(width);
		
		return r.toString()+" / "+ height * width;
	}
	
	public String calcPerimeter(int x, int y, int width, int height) {
		this.r.setX(x);
		this.r.setY(y);
		this.r.setHeight(height);
		this.r.setWidth(width);
		
		return r.toString()+" / "+ 2 * (width + height); 
	}
}
