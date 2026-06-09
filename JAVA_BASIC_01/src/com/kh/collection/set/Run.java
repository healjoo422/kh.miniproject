package com.kh.collection.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Run {

	/*
	 * Set
	 * 중복이 허용되지 않고, 순서가 없는 자료구조(수학의 집합 개념)
	 * 
	 * hashSet : 일반적인 해시알고리즘 기반의 set
	 * LinkedHashSet: HashSet + 순서기억
	 * TreeSet : 정렬기능 제공
	 * 
	 */
	
	public static void main(String[] args) {
		Set<Human> set = new HashSet<>();
		
		set.add(new Human("김상원", 18));
		set.add(new Human("김상덕", 19));
		set.add(new Human("구상만", 32));
		set.add(new Human("박상준", 17));
		Human h1 = new Human("이진숙", 20);
		System.out.println(set.add(h1));
		System.out.println(set.add(h1));

		
		
		System.out.println(set);
		
		// .contains(E e) : 자료구조 안에 e가 포함되어있는지 확인
		System.out.println(set.contains(h1));
		
		// .remove(E e) : 자료구조 내에 e 요소를 삭제
		set.remove(h1);
		System.out.println(set);
		
		
		List<Human> list = new ArrayList<>(set);
		System.out.println(list);
	}
}
