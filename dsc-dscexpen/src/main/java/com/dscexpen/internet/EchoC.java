package com.dscexpen.internet;


	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.io.PrintWriter;
	import java.net.Socket;
	import java.net.UnknownHostException;
	 
	class EchoC{
	   
	  private Socket socket;
	   
	  public EchoC() {
	    // TODO Auto-generated constructor stub
	    try {
	      socket = new Socket("localhost", 60000);
	    } catch (UnknownHostException e) {
	      e.printStackTrace();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	  }
	   
	  public void Client() {
	    try {
	      BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	      PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
	      BufferedReader lbr = new BufferedReader(new InputStreamReader(System.in));
	       
	      String linestr = null;
	      while ((linestr = lbr.readLine()) != null) {
	         
	        pw.println(linestr);
	         
	        System.out.println(br.readLine());
	         
	        if (linestr.equals("bye#")) {
	          break;
	        }
	      }
	       
	       
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	  }
	}
	 
