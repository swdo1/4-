package global.sesoc.test3.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import global.sesoc.test3.dao.ReDAO;
import global.sesoc.test3.vo.ReVO;

@Controller
public class ReController {
	
	private static final Logger logger = LoggerFactory.getLogger(ReController.class);
	
	@Autowired
	ReDAO dao;
	
	//리플 등록(ajax)
	@ResponseBody
	@RequestMapping(value="insert", method = RequestMethod.POST)
	public void	insert(ReVO vo){
		logger.debug("{}", vo);
		dao.insert(vo);
	}
	
	//리플 리스트
	@ResponseBody
	@RequestMapping(value="list", method=RequestMethod.POST, produces="application/json;charset=UTF-8")
	public ArrayList<ReVO> list(int bnum){		
		ArrayList<ReVO> list = dao.list(bnum);
		logger.debug("{}", list);
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
