package com.lec.ex;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
@WebServlet({ "/FrontController", "*.do" })
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		// localhost명+프로젝트명
		String uri = request.getRequestURI();
		// 프로젝트명
		String conPath = request.getContextPath(); 
		// 슬래시(/)뒤에 오는 것들 ex) insert.do 등
		// substring :: conPath만큼 자르기
		String command = uri.substring(conPath.length());
		
		System.out.println(uri);
		System.out.println(conPath);
		System.out.println(command);
		
		if(command.equals("/insert.do"))
		{
			response.getWriter().println("My Insert");
		}
		else if(command.equals("/test.do"))
		{
			response.getWriter().println("T E S T");
		}
		else
		{
			response.getWriter().println("cmd : " + command);
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
