package email;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.m_dbinfo;

public class mailok extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Connection con = null;
	PreparedStatement ps = null;
	PrintWriter pw = null;
	
	m_dbinfo db = new m_dbinfo();	// DB 접속 정보
	
	String sql = "";	// DB Query문
	int result = 0;	// DB 저장 결과값
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		this.pw = response.getWriter();
		
		try {
			this.con = this.db.getConnection();
			
			String to_name = request.getParameter("to_name");
			String to_mail = request.getParameter("to_mail");
			String subject = request.getParameter("subject");
			String context = request.getParameter("context");
			
			this.sql = "insert into email (eidx,to_name,to_mail,subject,context,edate)"
					+ "values ('0',?,?,?,?,now())";
			this.ps = this.con.prepareStatement(this.sql);
			this.ps.setString(1, to_name);
			this.ps.setString(2, to_mail);
			this.ps.setString(3, subject);
			this.ps.setString(4, to_name);
			this.result = this.ps.executeUpdate();
			
			if(result > 0) {
				this.pw.write("<script>"
						+ "alert('메일이 전송되었습니다.');"
						+ "location.href = './email_write.html';"
						+ "</script>");
			}
		}
		catch(Exception e) {
			this.pw.write("<script>"
					+ "alert('데이터베이스 문제로 인하여 메일이 전송되지 않았습니다.');"
					+ "history.go(-1);"
					+ "</script>");
		}
		finally {
			try {
				this.ps.close();
				this.con.close();
				this.pw.close();
			}
			catch(Exception e) {
				
			}
		}
	}
}