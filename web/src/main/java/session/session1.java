package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// session1 => session을 생성하는 컨트롤러

/*
 session : 일정시간 동안 브라우저에 해당 값을 저장 및 유지시키는 방식 (Back-end)
 cookie : 브라우저에 cache 메모리의 값을 저장하는 방식 (도메인 및 IP 기준) -> Front-end, Back-end -> 눈에 보임
 storage : 메모리에 저장 (Front-end, Back-end) => 저장방식 : local, session -> 눈에 보여 보안은 최악
 */

public class session1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	PrintWriter pw = null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid = request.getParameter("mid");
		String mpass = request.getParameter("mpass");
		
		response.setContentType("text/html;charset=utf-8");
		
		this.pw = response.getWriter();
		
		// 정상적인 로그인 상황
		if(mid.equals("hong") && mpass.equals("a1234")) {
			String username = "홍길동";
			String usertel = "01012341004";
			
			// HttpSession : 브라우저의 cache 메모리에 데이터를 임시 저장
			HttpSession se = request.getSession();	// session 시작
			// session을 생성
			se.setAttribute("id", mid);	// 사용자 아이디
			se.setAttribute("name", username);	// 사용자 이름
			se.setAttribute("tel", usertel);	// 사용자 전화번호
		}
		else {	// 아이디 및 패스워드가 틀릴 경우
			this.pw.write("<script>"
					+ "alert('아이디 및 패스워드를 확인하세요');"
					+ "history.go(-1);"
					+ "</script>");
		}
		this.pw.close();
	}
}
