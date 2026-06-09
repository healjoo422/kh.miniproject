package com.kh.control;

import java.util.Scanner;

public class Exp2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a, b, c, money = -1;
		
		System.out.print("Input dice : ");
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		
		if((a == b)) {							// a, b가 같을 때
			if(a == c) money = 10000;	// c까지 같으면 당첨임
			else money = 1000;			// 아니라면 a, b만 같으므로 2등상
		}
		else if(a == c) {						// a, b는 다르고 a, c가 같을 때
			money = 1000 + a*100;				// 그럼 a, c두개만 같은거니까
		}
		else if(b == c) {						// 그럼 b, c가 같을때
			money = 1000 + b*100;				// a는 다르다고 위에서 체크하고 왔으니						
		}
		else {									// 같은 숫자가 없으니 가장 큰놈을 찾아야함...
			if((a > b) && (a > c)) money = a*100;// a가 제일 클때
			else if((b > a) && (b > c)) money = b*100;// 그러면 b가 제일 클때	
			else money = c*100;					// 모두 아니라면 c가 제일 큰거
		}
		
		System.out.printf("Money is : %d\n", money);
		
	
	}

}
