package com.kh.array;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Array1 {

	public static void main(String[] args) {
		
		// 배열의 선언 방법
		int[] iArr1 = new int[3];
		
		// 참조변수 선언과 객체 인스턴스 할당을 분리할 수 있음
		int[] iArr2; 
		iArr2 = new int[3];
		
		/*
		 * 위처럼 선언만 하면, 각 요소들은 기본값으로 초기화됨
		 * int → 0
		 * double → 0.0
		 * boolean → false
		 * String 및 객체 → null
		 */

		// 선언과 동시에 데이터를 열거하여 정적초기화도 가능
		int[] iArr3 = {4,5,6};
		
		// 중괄호{}를 이용해 알맞은 자료형을 열거하여 넣을 수도 있음
		int[] iArr4 = new int[] {7,8,9};
		
		// intArray1, intArray2, intArray3, intArray4 의 각 요소가 무엇을 담고있는지 확인해보자
		System.out.println(Arrays.toString(iArr1));
		System.out.println(Arrays.toString(iArr2));
		System.out.println(Arrays.toString(iArr3));
		System.out.println(Arrays.toString(iArr4));

		System.out.println();
		
		// 선언이 끝나고 난 뒤에 초기화는 개별적으로 해야함
		iArr1[0] = 1;
		iArr1[1] = 2;
		iArr1[2] = 3;
		System.out.println(Arrays.toString(iArr1));
		
		// Arrays.fill(대상배열, 채울값)을 이용한 초기화도 가능하다
		Arrays.fill(iArr2, 100);
		System.out.println(Arrays.toString(iArr2));
		
		// Arrays.copyOf(원본배열, 새로할당할크기)를 이용한 배열복사, 남는공간은 0으로 채움
		// 새로운 객체를 생성하는 방식임
		iArr3 = Arrays.copyOf(iArr4, 5);
		System.out.println(Arrays.toString(iArr3));
		
		// IntStream을 활용해 List를 생성하고
		// List를 다시 Array 객체로 변환하여 대입하는 방식으로 초기화
		iArr4 = IntStream.range(0, 3).toArray();
		System.out.println(Arrays.toString(iArr4));
		
		//향상된 for문(foreach)을 이용한 배열순회
		for(int i:iArr1) {
			System.out.print(i + " ");
		}	System.out.println();
		
		
		String a = "aBcDeFg";
		
        char[] chArray = a.toCharArray();
        
        for(int i=0; i<chArray.length; i++){
            if(chArray[i] > 96 && chArray[i] < 123) {
            	chArray[i] -= 32;
            	System.out.println(i + " : " + chArray[i]);
            }
            else {
            	System.out.println(i + " : " + chArray[i]);
            	chArray[i] += 32;
            	System.out.println(i + " : " + chArray[i]);
            }
                
            
        }


        
        

	}

}
