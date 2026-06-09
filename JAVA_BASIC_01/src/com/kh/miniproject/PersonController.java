package com.kh.miniproject;

import java.util.ArrayList;
import java.util.List;

public class PersonController {

	private List<Person> pl = new ArrayList<>();
	
	//회원가입
	public int registUser(Person p) {
		for(Person person : pl) {
			if(p.equals(person)) {
				System.out.println("중복된 사용자입니다!");
				return 0;
			}
		}
		pl.add(p);
		System.out.println("등록완료!");
		return 1;
	}
	
	public int seachPerson(String str) {
		int cnt = 0;
		for(Person p : pl) {
			if(p.getUserID().equals(str)) {
				System.out.println(p);
				cnt++;
			}
		}
		return cnt;
	}
	
	public Person getPerson(int num1) {
		for(Person p : pl) {
			if(p.getManagementID() == num1) {
				return p;
			}
		}
		
		return null;
	}
	
	//연체료증가
	public void addFee(int managementID, int fee) {
		for(Person p : pl) {
			if(p.getManagementID() == managementID) {
				p.setFee(p.getFee()+fee);
				return;
			}
		}
	}
	
	//연체료감소
	public int subFee(int managementID, int fee) {
		for(Person p : pl) {
			if(p.getManagementID() == managementID) {
				if(fee > p.getFee()) {
					p.setFee(0);
					return p.getFee();
				}
				p.setFee(p.getFee()-fee);
				return p.getFee();
			}
		}
		return -1;
	}
	
	//탈퇴
	public int removeUser(Person p) {
		for(Person person : pl) {
			if(p.equals(person)) {		
				pl.remove(p);
				System.out.println("탈퇴 완료!");
				return 1;
			}
		}
			
		System.out.println("등록되지 않은 사용자입니다");
		return 0;
	}
	
	// 전체회원 조회
	public List<Person> getPersonList(){
		return pl;
	}
}
