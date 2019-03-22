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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import global.sesoc.test3.dao.BoardDAO;
import global.sesoc.test3.util.FileService;
import global.sesoc.test3.util.PageNavigator;
import global.sesoc.test3.vo.BoardVO;
import global.sesoc.test3.vo.ReVO;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	BoardDAO dao;
	

	private static final int countPerPage = 10;
	private static final int pagePerGroup = 10;
	final String uploadPath = "/testfile";
	
	//게시판 이동
	@RequestMapping(value = "board", method = RequestMethod.GET)
	public String board(
			Model model
			, @RequestParam(value="page", defaultValue="1") int page
			, @RequestParam(value="searchText", defaultValue="") String searchText
			, String type
			){
		logger.debug("페이지:{}, 검색:{}, 타입:{}", page, searchText, type);
		
		int total = dao.recordsTotal(searchText, type);		//전체 글 개수
		//logger.debug("{}", total);
		PageNavigator navi = new PageNavigator(countPerPage, pagePerGroup, page, total);
		
		ArrayList<BoardVO> list = dao.list(navi.getStartRecord(), navi.getCountPerPage(), searchText, type);
		
		model.addAttribute("list", list);
		model.addAttribute("navi", navi);
		model.addAttribute("searchText", searchText);
		
		return "board/board";
	}
	
	
	//글쓰기 폼
	@RequestMapping(value = "write", method = RequestMethod.GET)
	public String writeform(){
		logger.info("글쓰기 폼 지나감");
		return "board/write";
	}
	
	//글쓰기 처리 (jsp에서 일반적인 form으로 보냈을 경우)
	@RequestMapping(value = "write", method = RequestMethod.POST)
	public String write(BoardVO vo, HttpSession session, MultipartFile upload){
		String loginId = (String)session.getAttribute("loginId");
		vo.setId(loginId);
		logger.debug("업로드 파일명: {}", upload);
		//파일 업로드
		if(upload != null && !upload.isEmpty()){
			String savedfile = FileService.saveFile(upload, uploadPath);
			vo.setOriginalfile(upload.getOriginalFilename());
			vo.setSavedfile(savedfile);
		}
		
		dao.write(vo);
		logger.debug("{}", vo);
		
		return "redirect:board";
	}

	
/*	파일 업로드 부분 실패해서 보류
	//글쓰기 처리(jQuery와 Ajax를 이용한 경우)
	@ResponseBody
	@RequestMapping(value="write", method=RequestMethod.POST)
	public void write(BoardVO vo, HttpSession session, MultipartFile upload){
		String loginId = (String)session.getAttribute("loginId");
		vo.setId(loginId);
		logger.debug("업로드 파일명: {}", upload);
		//파일 처리
		if (upload != null && !upload.isEmpty()) {
			//upload != null은 객체가 안만들어 진거고, !upload.isEmpty() 파일이 없는거
			//upload != null가 무조건 조건 앞에 나와야한다. 자바 특성상 앞에 널이면 뒤 조건을 보지 않기 때문에 항상 널조건을 먼저 조건에 넣어줘야한다
				String savedfile = FileService.saveFile(upload, uploadPath);
				
				vo.setOriginalfile(upload.getOriginalFilename());	//내 이력서.hwp		이런식으로 저장
				vo.setSavedfile(savedfile);							//1.hwp
			}
		logger.debug("{}", vo);
		dao.write(vo);
	}
*/	
	//글읽기
	@RequestMapping(value = "read", method = RequestMethod.GET)
	public String read(Model model, int bnum, HttpSession session){
		logger.info("글읽기 폼 지나감");
		
		BoardVO vo = dao.read(bnum);
		model.addAttribute("vo", vo);
		
		//조회수
		dao.hit(bnum);
		
		//리플관련
		model.addAttribute("bnum", bnum);
		
		return "board/read";
	}

	//글수정 폼 이동
	@RequestMapping(value = "updateWrite", method = RequestMethod.GET)
	public String updateWriteForm(int bnum, Model model){
		//수정 할 글 하나 가져오기
		BoardVO vo = dao.getBoard(bnum);
		logger.debug("vo: {}", vo);
		model.addAttribute("vo", vo);
		
		return "board/updateWrite";
	}
	//글수정 처리
	@RequestMapping(value = "updateWrite", method = RequestMethod.POST)
	public String updateWrite(MultipartFile upload, BoardVO vo){
		
		if(upload !=null && !upload.isEmpty()){
			//파일삭제
			FileService.deleteFile(uploadPath + "/" + vo.getSavedfile());
			
			//파일저장
			String savedfile = FileService.saveFile(upload, uploadPath);
			
			vo.setOriginalfile(upload.getOriginalFilename());
			vo.setSavedfile(savedfile);
		}
		dao.updateWrite(vo);
		logger.debug("{}", vo);
		
		return "redirect:board";
	}
	//글삭제
	@RequestMapping(value = "del", method = RequestMethod.GET)
	public String del(int bnum, HttpSession session){
		//logger.debug("삭제할 글번호:{}", bnum);
		String loginId = (String)session.getAttribute("loginId");
		BoardVO vo = new BoardVO();
		vo.setBnum(bnum);
		vo.setId(loginId);
		String savedfile = dao.getBoard(bnum).getSavedfile();
		
		int result = dao.del(vo);
					
		logger.debug("savedfile:{}", savedfile);
		//파일삭제
		if(result == 1 && savedfile != null){
			FileService.deleteFile(uploadPath + "/" + savedfile);		
		}
		return "redirect:board";
	}
	
	
	
	
	
	
	
	
	
	
}
