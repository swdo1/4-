package global.sesoc.test3.controller;




import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import global.sesoc.test3.dao.ClientDAO;
import global.sesoc.test3.vo.ClientVO;

@Controller
public class ClientController {
	
	private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

	@Autowired
	ClientDAO dao;
	
	/*
	*			===============		회원가입		===============
	*/	
	//가입 폼으로 이동
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String joinForm(){
		logger.info("지나감");
		
		return "client/join";
	}
	//가입 처리
	@ResponseBody
	@RequestMapping(value = "join", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
	public void join(ClientVO vo){
		logger.debug("{}", vo);
		
		dao.join(vo);
	}
	//아이디 중복검사
	@ResponseBody
	@RequestMapping(value = "idCheck", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
	public String idCheck(String id){
		logger.debug("{}", id);
		String result = dao.idCheck(id);
		logger.debug("{}", result);
		
		return result;
	}
	
	/*
	*			===============		로그인		===============
	*/	
	//로그인 폼 이동
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String loginForm(){
		return "client/login";
	}
	//로그인 처리
	@ResponseBody
	@RequestMapping(value = "login", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
	public String login(String id, String password, HttpSession session){
		String result = "0";
		logger.debug("{}, {}", id, password);
		
		ClientVO vo = dao.getClient(id);
		logger.debug("{}", vo);
		
		if(vo != null && vo.getPassword().equals(password)){
			session.setAttribute("loginId", id);
			session.setAttribute("loginName", vo.getName());
			result = "1";
		}
/*		else{
			session.setAttribute("loginId", null);	//("loginId", null); 이렇게 하나 저렇게 하나 ""빈칸으로 인식한다. 스트링이기 때문
		}*/
		return result;
	}
	//로그아웃
	@RequestMapping(value="logout", method = RequestMethod.GET)
	public String logout(HttpSession session){
		session.removeAttribute("loginId");
		session.removeAttribute("loginName");
		
		return "redirect:/";
	}
	/*
	*			===============		수정		===============
	*/	
	//업데이트 폼 이동
	@RequestMapping(value="update", method=RequestMethod.GET)
	public String update(HttpSession session, Model model){
		String loginId = (String)session.getAttribute("loginId");
		ClientVO vo = dao.getClient(loginId);
		model.addAttribute("vo", vo);
		
		return "client/update";
	}
	//업데이트 처리
	@ResponseBody
	@RequestMapping(value="update", method=RequestMethod.POST)
	public void update(ClientVO vo ,HttpSession session){
		String loginId = (String)session.getAttribute("loginId");
		
		vo.setId(loginId);
		logger.debug("{}", vo);
		dao.update(vo);
		
	}
	/*
	*			===============		탈퇴		===============
	*/		
	//탈퇴 처리
	@ResponseBody
	@RequestMapping(value = "leave", method = RequestMethod.GET)
	public void update(HttpSession session){
		String loginId = (String)session.getAttribute("loginId");
		dao.leave(loginId);
		session.removeAttribute("loginId");
		session.removeAttribute("loginName");
	}
	

	
}
