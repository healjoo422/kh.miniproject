package com.kh.array;

public class ArrayMemory {

	public static void main(String[] args) {
		
		int i = 10;
		int[] iArr1 = new int[5];
		
		int[] iArr2 = iArr1;
		int[] iArr3 = iArr1.clone();
		
		System.out.println(iArr1); // 참조변수 출력시 자료형 + @ + 16진수 해시값이 기본형임
		System.out.println(iArr1.hashCode());
		System.out.println(iArr2);
		System.out.println(iArr2.hashCode());
		System.out.println(iArr3.hashCode());
		
		/*
		 * Literal을 바로 담을 수 있는 변수 -> 일반변수
		 * 다른 메모리의 주소값을 담고있는 변수 -> 참조변수
		 * 
		 * 기본자료형(원시타입) : int, double, float, char, long
		 * -> 크기가 고정적임
		 * 실제 리터럴 값을 직접 담기 때문에 메모리공간의 크기를 예측할 수 있고
		 * 그 크키가 변하지 않음
		 * 
		 * 그 외 객체형(참조타입) : String, int[], double[], List... 등등
		 * -> 필요한 메모리의 크기가 가변적임
		 */
		
		/*
		 * Heap 메모리의 데이터 중 호출이 불가한 값(연결이 끊어진 값들)은 더이상 쓸모가 없으므로
		 * GC(가비지 컬렉터)가 알아서 회수한다 
		 */
		
		int[] iArr4 = {1,2,3};
		int[] iArr5 = {1,2,3};
		
		System.out.println(iArr4 == iArr5);
		// 각 참조변수는 == 를 통해서 비교시, 주소값을 비교한다
		
		
	}

}
