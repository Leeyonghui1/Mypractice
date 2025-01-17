package com.myspring.mypro;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import customer.CustomerVo;
import member.MemberServiceImpl;
import member.MemberVo;

@Controller
public class MemberController {
	@Autowired
	MemberServiceImpl service;
	
	// 의료진 목록 화면
		@RequestMapping(value="/list.staff", method = RequestMethod.GET)
		public ModelAndView list_staff() {
			ModelAndView mav = new ModelAndView();
			List<MemberVo> list_staff = service.member_list();
			mav.addObject("list", list_staff);
			mav.setViewName("/member/list");
			return mav;
		}
	
	
	
	// 로그인 요청
	@ResponseBody @RequestMapping("/login")
	public String login(String id, String pw, HttpSession session) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("pw", pw);
		MemberVo vo = service.member_login(map);
		session.setAttribute("login_info", vo);
		
		return vo==null?"false":"true";
	}
	
	// 로그아웃 요청
	@ResponseBody @RequestMapping("/logout")
	public void logout(HttpSession session) {
		session.removeAttribute("login_info");
	}
	
	// 회원가입 화면 요청
	@RequestMapping("/member")
	public String member(HttpSession session) {
		session.setAttribute("category", "join");
		return "member/join";
	}
	
	// 아이디 중복확인 요청
	@ResponseBody @RequestMapping("/id_check")
	public boolean id_check(String id) {
		return service.member_id_check(id);
	}
}
