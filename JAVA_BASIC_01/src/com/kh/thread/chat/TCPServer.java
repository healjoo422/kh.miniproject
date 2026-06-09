package com.kh.thread.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServer {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		PrintWriter pw = null;
		BufferedReader br = null;
		
		int port = 3000;
		
		try {
			ServerSocket server = new ServerSocket(port);
			
			System.out.println("클라이언트의 요청 기다리는 중...");
			Socket socket = server.accept();
			
			InetAddress clientIP = socket.getInetAddress();
			System.out.println(clientIP.getHostAddress() + "가 연결을 요청함");
			
			if(socket != null) {
				ServerReceive sr = new ServerReceive(socket);
				sr.start();
				
				ServerSend ss = new ServerSend(socket);
				ss.start();
			}
			
					
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
