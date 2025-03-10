package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class movieok extends HttpServlet {
	private static final long serialVersionUID = 1L;

	PrintWriter pw = null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		try {
			this.pw = response.getWriter();
			
			String mname = request.getParameter("mname");
			String mtel = request.getParameter("mtel");
			String movie = request.getParameter("movie");
			String date = request.getParameter("date");
			
			String dates[] = date.split("-");
			
			ArrayList<String> data = new ArrayList<String>();
			data.add(mname);
			data.add(mtel);
			data.add(movie);
			
			for(int f = 0; f < dates.length; f++) {
				data.add(dates[f]);				
			}
			
			request.setAttribute("data", data);
			
			/*
			request.setAttribute("mname", mname);
			request.setAttribute("mtel", mtel);
			request.setAttribute("movie", movie);
			// request.setAttribute("date", date);
			request.setAttribute("dates", dates);
			*/
			
			RequestDispatcher rd = request.getRequestDispatcher("./movie_part2.jsp");
			rd.forward(request, response);
		}
		catch(Exception e) {
			this.pw.write("<script>"
					+ "alert('시스템 오류로 인하여 예매가 완료 되지 않았습니다.');"
					+ "location.href='./movie_part1.jsp';"
					+ "</script>");
		}
		finally {
			this.pw.close();
		}
	}
}