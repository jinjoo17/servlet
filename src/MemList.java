

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.mem.MemberDAO;
import kr.bit.mem.MemberVO;


@WebServlet("/memList")
public class MemList extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//member table에서 전체외원리스트 가져오자
		MemberDAO dao=new MemberDAO();
		List<MemberVO> list=dao.memList();
		
		//전체리스트를 HTML로 포장을 해서 응답해주자.==>JSP
		//응답하기전에 응답데이터에 있는 한글깨짐 방지
		response.setContentType("text/html;charset=euc-kr");
		
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head><title>회원리스트</title></head>");
		out.println("<body>");
		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("<td>번호</td>");
		out.println("<td>이름</td>");
		out.println("<td>나이</td>");
		out.println("<td>이메일</td>"); 
		out.println("<td>삭제</td>");
		out.println("</tr>");
		for(MemberVO vo:list){
		out.println("<tr>");
		out.println("<td>"+vo.getNum()+"</td>");
		out.println("<td><a href='memView?num="+vo.getNum()+"'>"+vo.getIrum()+"</td>");
		out.println("<td>"+vo.getAge()+"</td>");
		out.println("<td>"+vo.getEmail()+"</td>");
		out.println("<td><a href='memDel?num="+vo.getNum()+"'>삭제</a></td>");
		out.println("</tr>");
		}
		out.println("<tr>");
		out.println("<td colspan='5'>");
		out.println("<a href='member.html'>회원가입</a>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		
		
	}

}
