package com.dscexpen.web;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name="test",urlPatterns={"/test"})
public class TestServletLujing extends HttpServlet {

	
	
	private static final long serialVersionUID = 1L;

	public TestServletLujing() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String s1=request.getRealPath("/");
		String s2=request.getRequestURI()+"/";
		String s3=request.getSession().getServletContext().getRealPath("/");
		String s4=this.getClass().getClassLoader().getResource("").getPath();
		String p1 = System.getProperty("user.dir")+"/";
		String p2 = System.getProperty("user.dir") + File.separator + "properties";
		String p3 = this.getClass().getResource("/").getPath();
		URL xmlpath = this.getClass().getClassLoader().getResource("config.properties");
		//String p4=
		
		System.out.println("s1--"+s1);
		System.out.println("s2--"+s2);
		System.out.println("s3--"+s3);
		System.out.println("s4--"+s4);
		System.out.println("p1--"+p1);
		System.out.println("p2--"+p2);
		System.out.println("p3--"+p3);
		System.out.println("xmlpath--"+xmlpath);
        doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.setCharacterEncoding("utf-8");
//		response.setHeader("countent-type", "text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write("Good luky！！！");
		
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
