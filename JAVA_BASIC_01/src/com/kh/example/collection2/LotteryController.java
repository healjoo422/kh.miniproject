package com.kh.example.collection2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class LotteryController {
	
	Set<Lottery> lottery = new HashSet<>();
	Set<Lottery> win = new HashSet<>();
	
	public boolean insertObject(Lottery l) {
		return lottery.add(l);
	}
	
	public boolean deleteObject(Lottery l) {
		if(lottery.remove(l)) {
			win.remove(l);
			return true;
		} else
			return false;
	}
	
	public HashSet<Lottery> winObject(){
		if(lottery.size() < 4) {
			System.out.println("추첨에 사용될 풀이 4명이상이어야 합니다");
			return null;
		}
		List<Lottery> mylist = new ArrayList<>(lottery);
		Random rd = new Random();
		while(win.size() < 4) {
			win.add(mylist.get(rd.nextInt(mylist.size())));
		}
		
		return (HashSet)win;
	}
	
	public TreeSet<Lottery> sortedWinObject(){
		// win을 정렬해서 treeset에 담아 반환
		return null;
	}
	
	public boolean searchWinner(Lottery l) {
		return win.contains(l); 
	}
}
