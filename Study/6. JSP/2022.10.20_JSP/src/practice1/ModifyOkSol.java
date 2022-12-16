package practice1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ModifyOkSol
 */
@WebServlet("/ModifyOkSol")
public class ModifyOkSol extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyOkSol() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAction(request, response);
	}
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String id = (String)request.getSession().getAttribute("id");
		System.out.println("id="+id);
		
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		
		MemberDAO dao = new MemberDAO();
		MemberDTO m = new MemberDTO();
		m.setId(id);
		m.setName(name);
		m.setGender(gender);
		dao.memberUpdate(m);
		request.getSession().setAttribute("name", m.getName());
		response.sendRedirect("modifyResultSol.jsp");
		
	}
}
