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
		
		
		
		
		//Set<E> 형태로 선언하는 제네릭 클래스
		Set<Integer> mySet = new HashSet<>();
		
		// boolean add(E e) : 전달된 요소 e를 추가함
		// 이미 해당 요소가 있어서 추가에 실패하면 false 반환
		mySet.add(3);
		mySet.add(-2);
		
		// boolean contains(Object o) : 자료구조 안에 o가 포함되어있는지 확인
		// subSet이 mySet의 부분집합일 때, 매개변수로 subSet을 전달하면 true를 반환
		mySet.contains(3);
		
		// boolean remove(Object o) : 전달된 요소를 삭제함
		// 요소가 없어서 삭제에 실패하면 false
		mySet.remove(-2);
		
		// int size() : 요소의 총 갯수 반환
		mySet.size();
		
		// void clear() : 모든 요소를 제거
		mySet.clear();
		
		// boolean isEmpty() : 집합이 비어있는지 확인
		mySet.isEmpty();
		
		// Iterator<E> iterator() : 포함된 요소들을 담고있는 반복자 반환
		// 순서가 있는 Set은 순서대로 반환, HashSet은 무작위순서
		mySet.iterator();
		
		
	}
}
