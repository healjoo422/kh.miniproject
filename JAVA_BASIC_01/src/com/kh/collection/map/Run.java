package com.kh.collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Run {

	/*
	 * Map
	 * key와 value 쌍으로 저장하는 구조
	 * key는 식별용도, value는 값을 저장하는 용도
	 * 
	 * HashMap(보편적), LinkedHashMap(순서보장), TreeMap(정렬 key의 순서보장)
	 * 
	 */
	
	public static void main(String[] args) {
		
		Map<Integer, Human> hMap = new HashMap<>();
		
		// .put(key, value) : 자료구조에 key, value 쌍으로 값을 추가
		hMap.put(10, new Human("일", 10));
		hMap.put(20, new Human("이", 20));
		hMap.put(30, new Human("삼", 300));
		hMap.put(40, new Human("사", 77));
		hMap.put(50, new Human("오", 20));
		hMap.put(60, new Human("오", 20));
		// 동일한 키를 입력할 경우, 기존에 존재하는 값에 덮어씌움
		hMap.put(40, new Human("칠", 700));
		
		System.out.println(hMap);
		
		// .get(key) : key를 통해 접근해 value를 반환
		System.out.println(hMap.get(30));
		
		// .size() : 자료구조에 담겨있는 요소의 갯수
		System.out.println(hMap.size());
			
		// .remove(key) : key를 참조해서 해당 요소를 제거
		hMap.remove(10);
		System.out.println(hMap);
		
		// 전체순회 방법
		// 다른 자료구조로 변환하는 과정을 거쳐야 함

		Set<Integer> ks = hMap.keySet();
		System.out.println(ks);
		
		for(Integer key : ks) {
			System.out.println(hMap.get(key));
		}
		
		// entrySet을 이용하기
		// key, value를 동시에 저장하는 set 자료구조
	 	// Set<Map.Entry<K,V>>  key, value 쌍을 Entry라는 자료구조로 변경해서 Set에 담는것
		Set<Entry<Integer, Human>> entrySet = hMap.entrySet();
		for(Entry e : entrySet) {
			System.out.println(e.getKey()+ ", " +e.getValue());
		}
		
	}
}
