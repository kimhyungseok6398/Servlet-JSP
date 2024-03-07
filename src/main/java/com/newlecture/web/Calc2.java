package com.newlecture.web;

import java.io.IOException;
import java.util.Iterator;

import javax.management.loading.PrivateClassLoader;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/calc2")
public class Calc2 extends HttpServlet {
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = request.getServletContext();
		HttpSession session = request.getSession();	
		Cookie[] cookies = request.getCookies();
		
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		// 어플리케이션 객체 ( 서블릿 컨텍스트 )
		String v_ = request.getParameter("v");
		String op = request.getParameter("operator");
		
		
		
		
		int v = 0;
		if(!v_.equals("")) v = Integer.parseInt(v_);
		
		if (op.equals("=")) {
			
			// int x = (Integer)application.getAttribute("value");
			// int x = (Integer)session.getAttribute("value");
			
			int x = 0;
			
			for(Cookie c : cookies) 
			
			if(c.getName().equals("value")) {
			x =Integer.parseInt(c.getValue());
			break;
			}	
		
			int y = v;		
			
			//String operator = (String)application.getAttribute("op");;
			//String operator = (String)session.getAttribute("op");;
			
			 	String operator = "";
			
			    for(Cookie c : cookies) 
				
				if(c.getName().equals("op")) {
				operator =c.getValue();
				break;
				}	
			
			
			
			int result = 0;
			
			if (operator.equals("+"))
				result = x+y;
			else
				result = x-y;
			response.getWriter().printf("result is %d\n", result);
		
		} else {	
		
		//application.setAttribute("value", v);
		//application.setAttribute("op", op);
			//session.setAttribute("value", v);
			//session.setAttribute("op", op);
		
			Cookie valuecookie = new Cookie("value", String.valueOf(v));
			Cookie opcookie = new Cookie("op", op);
			
			valuecookie.setPath("/calc2");
			valuecookie.setMaxAge(24*60*60);
			opcookie.setPath("/calc2");
			// add라는 경로만 가능
			response.addCookie(valuecookie);
			response.addCookie(opcookie);
			
			//response헤더에 심어진다.
			
			response.sendRedirect("calc2.html");
			// 사용자가 버튼을 누르면 그 사이트로 자동 이동
		}
	}	
			
}
