package com.javlec.ex;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServiceDelete implements Service {

	@Override
	public ArrayList<MemberDTO> execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		MemberDAO m = MemberDAO.getInstance();
		MemberDTO dto = new MemberDTO();
		dto.setId(request.getParameter("id"));
		m.memberDelete(dto);
		return null;
	}

}
