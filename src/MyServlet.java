

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ms")
public class MyServlet extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res)
			               throws ServletException, IOException {
	//응답을 날짜시간정보 응답
		Date d=new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd : hh : mm");
		String day=sf.format(d);
		
	    PrintWriter out=res.getWriter();
	    out.print(day);
	}

}
