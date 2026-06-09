package com.kh.collection.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class Run {

	/*
	 * 컬렉션
	 * 자료구조 개념이 내장되어있는 인터페이스(java에서 자체적으로 제공)
	 */
	
	public static void main(String[] args) {
		// List ( 선형 자료구조, 순서 O, 중복값 허용 )
		// ArrayList(배열기반), LinkedList(노드기반), Vector, Stack(Vector기반 LIFO)
		
		List list = new ArrayList();
		
		// .add(E e) : 자료구조 끝에 e를 추가한다
		list.add(new Human("김세종", 32));
		list.add(new Human("이창섭", 30));
		list.add(new String("정중부"));
		
		System.out.println(list);
		
		// .add(int index, E e) : 자료구조의 index 위치에 e를 추가한다
		list.add(1, new String("중간삽입"));
		System.out.println(list);
		
		// .remove(int index) : index 위치의 데이터를 삭제
		list.remove(1);
		System.out.println(list);
		
		// .remove(E e) : 순차 순회하며 첫번째로 만나는 e와 동일한 요소를 삭제(.equals()로 비교함)
		// 컬렉션들은 대부분 .equals() 비교를 하기 때문에 클래스를 만들면 .equals()를 오버라이팅 해주는것이 좋음
		Human m1 = new Human("김사람", 15);
		list.add(m1);
		list.add(m1);
		list.remove(m1);
		System.out.println(list);
		
		// .set(int index, E e) : index 위치의 요소를 e로 대체함
		list.set(1, new Human("최성진", 42));
		System.out.println(list);

		// .size() : 리스트의 길이 반환
		System.out.println(list.size());
		
		// .get(int index) : index 위치의 요소를 반환
		System.out.println(list.get(1));
		
		// .addAll(Collection c) : c가 담고있는 요소들을 전부 추가
		list.addAll(list);
		System.out.println(list);
		
		// .isEmpty() : 컬렉션이 비어있는지 확인
		System.out.println(list.isEmpty());
		
		// .clear() : 요소를 전부 삭제
		list.clear();

		
		System.out.println();
		System.out.println();
		
		
		Stack<String> st = new Stack<>();
		
		// .push(E e) : 데이터 추가
		st.push("1st");
		st.push("2nd");
		st.push("3rd");
		System.out.println(st);
		
		// .peek() : 맨 위 요소 반환 
		System.out.println(st.peek());
		
		// .pop() : 맨 위 요소를 꺼내서 반환
		System.out.println(st.pop());
		System.out.println(st);
		
		// .search(E e) : 데이터 검색 후 해당 데이터가 위치한 깊이 반환
		st.push("3rd");
		System.out.println(st);
		System.out.println(st.search("3rd"));
		
		
		st.add(1, "mid");
		System.out.println(st);
		
		st.set(1, "change");
		System.out.println(st);
		
		st.remove(1);
		System.out.println(st);
	}
}
