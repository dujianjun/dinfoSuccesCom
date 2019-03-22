package com.dscexpen.internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class EchoS{

	private ServerSocket serverSocket;

	public EchoS() {

		try {
			serverSocket = new ServerSocket(60000);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void Server() {
		while (true) {
			try {
				Socket socket = serverSocket.accept();

				System.out.println("client:" + socket.getInetAddress() + ":" + socket.getLocalPort());

				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);

				String linestr;

				while ((linestr = br.readLine()) != null) {

					System.out.println(linestr);

					pw.println("--->" + linestr);

				}
			} catch (IOException e) {
				System.out.println("连接断开：（");
			}

		}
	}
}
