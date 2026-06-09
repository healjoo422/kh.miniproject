package com.kh.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServer {
	
	/*
	 * TCP
	 * 서버-클라이언트간 1:1 소켓통신
	 * 
	 * Socket
	 * 프로세스간의 통신용
	 * input/outputStream을 가지고 있음
	 * 
	 * ServerSocket
	 * 포트와 연결되어 외부의 연결요청을 대기 -> 하다가 요청이오면 수락
	 * 수락되면 통신할 수 있는 Socket이 생성됨
	 * 
	 */
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = null;
		BufferedReader br = null;
		
		int port = 3000;
		
		try {
			ServerSocket server = new ServerSocket(port);
			
			System.out.println("클라이언트 요청 대기");
			Socket socket = server.accept();
			
			InetAddress clientIP = socket.getInetAddress();
			System.out.println(clientIP.getHostAddress() + "가 연결을 요청함");
			
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			pw = new PrintWriter(socket.getOutputStream());
			
			while(true) {
				String message = br.readLine();
				System.out.println("클라이언트 : " + message);
				
				System.out.print("보낼 내용: ");
				String sendMessage = sc.nextLine();
				
				pw.println(sendMessage);
				pw.flush();
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
