package com.kh.array.practice;

import java.util.Arrays;
import java.util.Scanner;

public class Practice8 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[100][100];
		int num1=0, cnt=0; // 색종이 갯수
		int x, y;
		int sum=0;
		
		// 도화지 0으로 초기화
		for(int[] a : arr) {
			Arrays.fill(a, 0);
		}
		
		
		System.out.print("색종이 갯수를 입력 : ");
		num1 = sc.nextInt();
		
		
		// 색종이 갯수만큼 반복
		// 도화지 채우는걸 for문으로 순회할거라 가독성을 위해 얘는 while로 씀
		while(cnt<num1) { 
			// 색종이가 도화지 밖으로 나가는 경우는 없다고 했으므로
			// 안전한 입력값이 보장되어있음
			System.out.print("색종이 좌표 입력 : ");
			x = sc.nextInt();
			y = sc.nextInt();
			
			// for(int i=x; i<x+10; i++) 로 구현해도 되는데
			// 판별식을 돌때마다 x+10을 계산하는 오버헤드가 있지 않을까?
			// 싶어서 판별식을 간단하게 만들기 위해 변형을 줬음
			/*
			for(int i=x+10; i-->x; ) {
				for(int j=y+10; j-->y; ) {
					arr[i][j] = 1;
				}
			}*/
			//그런데 요즘 컴파일러들은 알아서 loop unrolling(루프 펼치기) 이라는것을 한다고 함
			//컴파일러가 알아서 반복문을 펼쳐서 판별식이나, 증감식의 반복을 줄인다는 뜻
			//그러니 어설프게 최적화 하지말고 컴파일러가 알아보기 이쁘게 짜는게 더 좋을 수도 있음
			for(int i=0; i<x+10; i++) {
				for(int j=0; j<y+10; j++) {
					arr[i][j] = 1;
				}
			}
			cnt++;
		}
		
		//도화지 전체를 순회하면서 더하기
		for(int[] a : arr) {
			for(int n : a) {
				sum += n;
			}
		}
		
		System.out.println("넓이 : " + sum);
		
		sc.close();
	}

}
