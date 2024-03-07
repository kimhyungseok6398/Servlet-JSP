package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/notice-reg")	// 어노테이션을 이용해 매핑가능, 주의!! 어노테이션을 사용해서 매핑하는경우,
					// xml에 있는 메타데이터를 false로 바꿔줘야한다
public class NoticeReg extends HttpServlet{
	
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	resp.setCharacterEncoding("UTF-8");
	resp.setContentType("text/html; charset=UTF-8");
	
	//req.setCharacterEncoding("UTF-8");
	// 명시를 해줘야 한다
	PrintWriter out = resp.getWriter();
	
	String title = req.getParameter("title");
	String content = req.getParameter("content");

	out.println(title);
	out.println(content);

	
	// 여기서 쿼리 값이 없으면 에러발생!
	// ?cnt=2 등을 써줘야함
	


	
	// 서블릿 매핑 = xml로 가서 그 전단계를 지금 패키지 이름으로 수정!
	// 톰켓 설정법 다이나믹 웹 프로젝트 -> taget runtime(new Runtime) 톰켓 9설정 -> 설치경로도 같이 설정(홈 디렉토리 bin있는 폴더 설정)
	// -> 피니시
}
}
