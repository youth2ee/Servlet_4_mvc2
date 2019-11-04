package com.naver.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NoticeController
 */
@WebServlet("/NoticeController")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public NoticeController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Notice Controller");
			
		String url = request.getServletPath();
		StringBuffer url2 = request.getRequestURL();
		String uri = request.getRequestURI();
		
		System.out.println(url);
		System.out.println(url2.toString());
		System.out.println(uri);
		
		//1
		/*
		 * String[] ar = url.split("/"); 
		 * url = ar[2].substring(0, ar[2].lastIndexOf("."));
		 */
		
		//2
		 url = url.substring(url.lastIndexOf("/")+1, url.lastIndexOf("."));
		 System.out.println(url);
		 
		
		//3
		/*
		 * int u1 = url.lastIndexOf("/"); int u2 = url.indexOf(".");
		 * String l = url.substring(u1+1, u2); System.out.println(l);
		 * String path = "./"+l+".jsp";
		 */
		
		String path ="";
		Boolean flag = false;
		
		if(url.equals("noticeList")) {
			path="./noticeList.jsp";
			request.setAttribute("board", "noticeList");
			flag = true;
			
		} else if(url.equals("noticeSelect")) {
			
		}

		
		if(flag) {
			RequestDispatcher view = request.getRequestDispatcher(path);
			view.forward(request, response);
		} else {
			response.sendRedirect(path);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
