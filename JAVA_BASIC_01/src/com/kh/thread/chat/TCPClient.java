package com.kh.thread.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		PrintWriter pw = null;
		BufferedReader br = null;
		
		String serverIP = "192.168.10.7";
		int port = 3000;
		
		try {
			Socket socket = new Socket(serverIP, port);
			
			if(socket != null) {
				ClientReceive cr = new ClientReceive(socket);
				cr.start();
				
				ClientSend cs = new ClientSend(socket);
				cs.start();
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
