package com.kh.thread.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServerSend extends Thread {

	private Socket socket;

	public ServerSend(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		// 클라이언트에게 메시지를 계속 내보내기
	
		try (Scanner sc = new Scanner(System.in);
				PrintWriter pw = new PrintWriter(socket.getOutputStream());){
			
			while(true) {
				System.out.print("보낼 내용: ");
				String sendMessage = sc.nextLine();
				
				pw.println(sendMessage);
				pw.flush();
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
