package com.kh.example.poly1;

public class AnimalManager {

	public static void main(String[] args) {
		
		Animal[] animalArr = new Animal[5];
		
		animalArr[0] = new Dog("멍뭉이1", 1, "리트리버");
		animalArr[1] = new Dog("멍뭉이2", 2, "시츄");
		animalArr[2] = new Cat("야옹이1", 1, "하얀색");
		animalArr[3] = new Cat("야옹이2", 2, "고동색");
		animalArr[4] = new Cat("야옹이3", 1, "검은색");
		
		for(Animal a : animalArr) {
			a.speak();
			if(a instanceof Dog) {
				System.out.printf("이 개의 견종은 %s입니다.\n\n", ((Dog)a).getBreed());
			}
			else if(a instanceof Cat) {
				System.out.printf("이 고양이의 색상은 %s입니다.\n\n", ((Cat)a).getColor());
			}
		}
		
		Animal a1 = new Animal("동물이름1", 2);
		Cat c1 = new Cat("야옹이1", 1, "하얀색");
		
		a1.speak();
		c1.speak();
		
	
	}

}
