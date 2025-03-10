package review;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(
	fileSizeThreshold = 1024 * 1024 * 5,
	maxFileSize = 1024 * 1024 * 50,
	maxRequestSize = 1024 * 1024 * 100
)

public class io_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	PrintWriter pw = null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		try {
			this.pw = response.getWriter();
			
			Part mfile = request.getPart("mfile");
			String filename = mfile.getSubmittedFileName();
			long filesize = mfile.getSize();
			
			if(filesize > 5242880) {
				this.pw.write("<script>"
					+ "alert('파일 첨부 용량은 최대 5MB까지 가능합니다.');"
					+ "history.go(-1);"
					+ "</script>");
			}
			else {
				// 디렉토리를 자동으로 생성하여 파일 저장
				String ori = request.getServletContext().getRealPath("/notice/");
				File f = new File(ori);
				f.mkdir();
				
				// 해당 경로에 디렉토리 직접 생성하여 파일 저장
				// String url = request.getServletContext().getRealPath("");
				// System.out.println(url);
				
				// notice 디렉토리에 파일 저장
				String url = request.getServletContext().getRealPath("/notice/");
				mfile.write(url + filename);
				this.pw.write("<script>"
						+ "alert('정상적으로 파일 업로드 되었습니다.');"
						+ "history.go(-1);"
						+ "</script>");
			}
		}
		catch(Exception e) {
			this.pw.write("<script>"
					+ "alert('올바른 접근 방식이 아닙니다.');"
					+ "history.go(-1);"
					+ "</script>");
		}
		finally {
			this.pw.close();
		}
	}
}