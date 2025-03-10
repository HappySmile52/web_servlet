package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class paylist extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	PrintWriter pw = null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		try {
			this.pw = response.getWriter();
			
			String product[] = request.getParameterValues("selectedProducts");
			String price = request.getParameter("total");
			
			ArrayList<String> product_nm = new ArrayList<String>();
			ArrayList<String> product_p = new ArrayList<String>();
			
			for(String products : product) {
				String[] pd = products.split(", ");
				
				for (String product_list : pd) {
					String[] part = product_list.split(" - ");
		            
		            if (part.length == 2) {
		                product_nm.add(part[0].trim());  // 공백 제거 후 저장
		                product_p.add(part[1].trim());   // 공백 제거 후 저장
		            }
				}
			}
			
			request.setAttribute("product_nm", product_nm);
			request.setAttribute("product_p", product_p);
			request.setAttribute("price", price);
			
			RequestDispatcher rd = request.getRequestDispatcher("./basket_part2.jsp");
			rd.forward(request, response);
		}
		catch(Exception e) {
			this.pw.write("<script>"
					+ "alert('시스템 오류로 인하여 데이터 처리가 되지 않았습니다.');"
					+ "location.href='./basket.jsp';"
					+ "</script>");
		}
		finally {
			this.pw.close();
		}
	}
}