

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.mem.MemberDAO;
import kr.bit.mem.MemberVO;


@WebServlet("/memView")
public class MemView extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int num=Integer.parseInt(request.getParameter("num"));
		 
		 MemberDAO dao=new MemberDAO();
		 MemberVO vo=dao.memView(num);
		 response.setContentType("text/html;charset=euc-kr");
		 PrintWriter out=response.getWriter();

		 out.println("<html>");
		 out.println("<head><title>회원상세보기</title></head>");
		 out.println("<body>");
		 out.println("<table border='1'width='500px'>");
		 out.println("<tr>");
		 out.println("<td>번호</td>");
		 out.println("<td width='100px'>"+vo.getNum()+"</td>");
		 out.println("</tr>");
		 out.println("<td>이름</td>");
		 out.println("<td>"+vo.getIrum()+"</td>");
		 out.println("</tr>");
		 out.println("<td>나이</td>");
		 out.println("<td>"+vo.getAge()+"</td>");
		 out.println("</tr>");
		 out.println("<td>이메일</td>");
		 out.println("<td>"+vo.getEmail()+"</td>");
		 out.println("</tr>");
		 out.println("<td>자기소개</td>");
		 out.println("<td>"+vo.getIntro()+"</td>");
		 out.println("</tr>");
		 out.println("<table>");
		 out.println("<body>");
		 out.println("</html>");
	}

}
