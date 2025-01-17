package com.myspring.mypro;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.member.MemberDTO;
import com.myspring.member.MemberServiceImpl;



@Controller
public class MemberController {
	@Autowired
	MemberServiceImpl service;
	
	// 회원가입 화면
	@RequestMapping(value = "/member", method = RequestMethod.GET)
	public ModelAndView join() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/member/join");
		return mav;
	}
	
	// 의료진 전공 선택 화면
	@RequestMapping(value = "/list.staff", method = RequestMethod.GET)
	public ModelAndView staff_select() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/member/listselect");
		return mav;
	}
	
	// 선택된 전공 소속 의료진 목록 요청
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public ModelAndView staff_list(@RequestParam Map<String, Object> map) {
		String m_code = map.get("m_code").toString();
		List<MemberDTO> staff_list = this.service.staff_list(m_code);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("m_code", m_code);
		mav.addObject("data", staff_list);
		mav.setViewName("/member/list");
		return mav;
	}
	
	// 아이디 중복확인 요청
	@ResponseBody @RequestMapping(value = "/id_check", method = RequestMethod.POST)
	public boolean id_check(String id) {
		return this.service.id_check(id);
	}
	
	// 회원가입 요청
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public ModelAndView join(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		map.put("phone", map.get("ph1")+"-"+map.get("ph2")+"-"+map.get("ph3"));
		map.put("addr", map.get("addr")+" "+map.get("addr2"));
		String id = this.service.join(map);
		if(id == null) {
			mav.setViewName("redirect:/member");
		} else {
			mav.setViewName("redirect:/");
		}
		return mav;
	}
	
	// 로그인 요청
	@ResponseBody @RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String id, String pw, HttpSession session) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pw", pw);
		
		MemberDTO dto = this.service.login(map);
		session.setAttribute("login_info", dto);
		
		return dto == null ? "false" : "true";
		
	}
	
	// 로그아웃 요청
	@ResponseBody @RequestMapping(value = "/logout", method = RequestMethod.POST)
	public void logout(HttpSession session) {
		session.removeAttribute("login_info");
	}
	
	
	// 회원 상세페이지 요청
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView detail(String id) {
		ModelAndView mav = new ModelAndView();
		MemberDTO dto = this.service.detail(id);
		mav.addObject("data", dto);
		mav.setViewName("/member/detail");
		return mav;
	}
	
	// 회원 정보 수정 요청
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public ModelAndView modify(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		String id = map.get("id").toString();
		String phone = map.get("phone").toString();
		String addr = map.get("addr").toString();
		
		String ph1 = phone.substring(0, 3);
		String ph2 = phone.substring(4, 8);
		String ph3 = phone.substring(9);
			
		String addr1 = addr.substring(0, addr.lastIndexOf(" "));
		String addr2 = addr.substring(addr.lastIndexOf(" ")+1);
		
		MemberDTO dto = this.service.detail(id);
		mav.addObject("data", dto);
		mav.addObject("ph1", ph1);
		mav.addObject("ph2", ph2);
		mav.addObject("ph3", ph3);
		mav.addObject("addr", addr1);
		mav.addObject("addr2", addr2);
		mav.setViewName("/member/modify");
		
		return mav;
	}
	
	// 회원 정보 수정 후 
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public ModelAndView modifyPost(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		map.put("phone", map.get("ph1")+"-"+map.get("ph2")+"-"+map.get("ph3"));
		map.put("addr", map.get("addr")+" "+map.get("addr2"));
		
		boolean isUpdateSuccess = this.service.modify(map);
		if(isUpdateSuccess) {
			String id = map.get("id").toString();
			mav.setViewName("redirect:/detail?id=" + id);
		} else {
			mav.setViewName("redirect:/");
		}
		return mav;
	}
			
	// 회원 탈퇴 요청
	@RequestMapping(value = "/delete", method = RequestMethod.POST)  
	public ModelAndView delete(@RequestParam Map<String, Object> map, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		String id = map.get("id").toString();
		boolean isDeleteSuccess = this.service.delete(id);  
		if (isDeleteSuccess) { 
			session.removeAttribute("login_info");
			mav.setViewName("redirect:/");  
		} else {
			mav.setViewName("redirect:/detail?id=" + id);  
		} 
		return mav;  
	} 
}
