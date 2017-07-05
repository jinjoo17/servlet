

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.mem.MemberDAO;


@WebServlet("/memDel")
//                                            ?num=1
public class MemDel extends HttpServlet {//     ↓
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	 int num=Integer.parseInt(request.getParameter("num"));
     MemberDAO dao=new MemberDAO();
     int cnt=dao.memDel(num);
     
     //PrintWriter out=response.getWriter();
     if(cnt>0){
    	 response.sendRedirect("memList");
     }else{
    	 //out.println("FAILED");
    	 throw new ServletException("fail!!");//예외발생
     }
}
}