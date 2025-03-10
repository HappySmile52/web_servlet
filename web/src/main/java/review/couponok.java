package review;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class couponok extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	PrintWriter pw = null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		try {
			this.pw = response.getWriter();
			
			String mid = request.getParameter("mid");	// 고객명
			String mno = request.getParameter("mno");	// 쿠폰번호
			
			String coupon_no[] = {"A1316B1004", "C4024A0096", "B1987C3136"};	// 쿠폰 번호 리스트
			
			ArrayList<String> data = new ArrayList<String>();	// 데이터 배열
			data.add(mid);
			
			boolean coupon = false;	// 쿠폰번호 체크
			
			for(int f = 0; f < coupon_no.length; f++) {
				if(mno.equals(coupon_no[f])) {
					data.add(mno);
					coupon = true;	// 쿠폰번호가 일치하면 true
					break;
				}
			}
			
			if(!coupon) {	// 쿠폰 번호가 일치하지 않을 경우
				this.pw.write("<script>"
						+ "alert('해당 쿠폰번호를 확인하세요');"
						+ "history.go(-1);"
						+ "</script>");
			}
			else {	// 쿠폰 번호가 일치하는 경우
				request.setAttribute("data", data);
				
				RequestDispatcher rd = request.getRequestDispatcher("./coupon_part2.jsp");
				rd.forward(request, response);
			}
		}
		catch(Exception e) {
			this.pw.write("<script>"
					+ "alert('시스템 오류로 인하여 쿠폰 등록이 완료 되지 않았습니다.');"
					+ "history.go(-1);"
					+ "</script>");
		}
		finally {
			this.pw.close();
		}
	}
}