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
		
		
		
		// Map<K, V> 형태로 선언되는 제네릭 클래스
		Map<Integer, String> myMap = new HashMap<>();
		
		// V put(K key, V value) : key-value 쌍을 저장하고 기존 key에 매핑되어있던 value를 반환한다
		// 새롭게 입력된 key라면 null을 반환
		String str = myMap.put(1, "일");
		System.out.println("put 반환값 : " + str);
		str = myMap.put(1, "갱신된 일");
		System.out.println("put 반환값 : " + str);
		
		// V get(K key) : key에 매핑되어있는 value를 반환
		str = myMap.get(1);
		System.out.println("get 반환값 : " + str);
		
		// int size() : 담겨있는 매핑의 갯수를 반환
		int num = myMap.size();
		System.out.println(num);
		
		// V remove(K key) : 전달된 key에 대응되는 key-value 쌍을 제거하고 value를 반환
		// 대응되는 key-value쌍이 없다면 null 반환
		str = myMap.remove(4);
		System.out.println("remove 반환 : " + str);
		
		// V replace(K key, V value) : key에 매핑을 value로 교체하고 기존값을 반환한다
		// put()과 다르게 새로운 값이 추가되지않아 조금 더 안전하다
		myMap.replace(1, "또 바꾼 일");
		
		// Set<K> keySet() : key 집합을 Set으로 만들어 반환한다
		Set<Integer> mySet = myMap.keySet();
		
		// boolean containsKey(K key) : key가 보관되어 있는지 체크해준다
		// Value 버전인 containsValue도 있으나 Map은 key 기반의 hash구조를 가지고있다보니 성능이 좋은편은 아니다
		System.out.println(myMap.containsKey(1));
	
		// void clear()
		myMap.clear();
		
		// boolean isEmpty()
		System.out.println(myMap.isEmpty());

		
	}
}
