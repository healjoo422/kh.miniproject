package com.kh.example.Inherit;

public class CircleController {

		Circle c = new Circle();
		
		public String calcArea(int x, int y, int radius) {
			this.c.setX(x);
			this.c.setY(y);
			this.c.setRadius(radius);
			
			return this.c.toString()+" / "+String.format("%.2f", Math.PI * radius * radius);
		}
		
		public String calcCircum(int x, int y, int radius) {
			this.c.setX(x);
			this.c.setY(y);
			this.c.setRadius(radius);
			
			return this.c.toString()+" / "+String.format("%.2f", Math.PI * radius * 2);
		}
}
