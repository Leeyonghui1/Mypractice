package com.javlec.ex;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CommandCtroller
 */
@WebServlet({ "/CommandCtroller", "*.do" })
public class CommandCtroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommandCtroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath(); 
		String command = uri.substring(conPath.length());
		System.out.println(uri);
		System.out.println(conPath);
		System.out.println(command);
		
		Service service;
		if(command.equals("/insert.do"))
		{
			service = new ServiceInsert();
		}
		else if(command.equals("/update.do"))
		{
			service = new ServiceUpdate();
		}
		else if(command.equals("/delete.do"))
		{
			service = new ServiceDelete();
		}
		else
		{
			service = new ServiceSelect();
		}
		
		ArrayList<MemberDTO> dtos = service.execute(request, response);
		if(dtos!=null)
		{
			for (MemberDTO memberDTO : dtos) {
				System.out.println(memberDTO.getId());
				System.out.println(memberDTO.getPw());
				System.out.println(memberDTO.getGender());
				System.out.println(memberDTO.getName());
			}
		}
	}

}
