package com.kh.network;

import java.net.InetAddress;

public class Run {

	/*
	 * 네트워크 : 여러대의 컴퓨터들이 연결되어있는 통신망
	 * 
	 * IP주소 : 네트워크상에 각 컴퓨터를 식별하기 위한 주소
	 * port : 컴퓨터 내의 프로그램을 식별하기 위한 코드
	 * 
	 * 서버 - 클라이언트 연결 방식
	 * 클라이언트 : 서버에 요청을 보내는 머신
	 * 서버 : 클라이언트의 요청을 받아서 고객에게 서비스를 제공해주는 컴퓨터 또는 프로그램
	 * 
	 * 도메인 : 특정 서버에 접근하기위한 정보(ip, port)를 사람이 읽고 기억하기 어렵기 때문에 쉽게 만들어 둔 주소
	 *  -> 도메인으로 요청시 DNS(Domain Name System)에서 IP로 변경해서 위치를 찾음
	 * 
	 */
	
	public static void main(String[] args) {
		try {
			InetAddress localhost = InetAddress.getLocalHost();
			System.out.println(localhost);
			
			System.out.println("내 PC 이름 : " +localhost.getHostName());
			System.out.println("내 IP 주소 : " +localhost.getHostAddress());
			
			InetAddress googlehost = InetAddress.getByName("www.google.co.kr");
			
			System.out.println("google PC 이름 : " +googlehost.getHostName());
			System.out.println("google IP 주소 : " +googlehost.getHostAddress());
			
		} catch(Exception e) {
			
		}

	}

}
