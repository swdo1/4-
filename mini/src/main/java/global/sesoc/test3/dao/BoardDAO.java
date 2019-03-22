package global.sesoc.test3.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import global.sesoc.test3.vo.BoardVO;

@Repository
public class BoardDAO {

	@Autowired
	SqlSession sqlSession;
	
	//글쓰기
	public void write(BoardVO vo) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		mapper.write(vo);		
	}
	//게시판 글 목록
	public ArrayList<BoardVO> list(int start, int count, String searchText, String type) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		//검색(HashMap)
		HashMap<String, String> map = new HashMap<>();
		map.put("type", type);
		map.put("searchText", searchText);
		//RowBounds
		RowBounds rb = new RowBounds(start, count);		
		
		ArrayList<BoardVO> list = mapper.list(rb, map);

		return list;
	}
	//전체 글 개수
	public int recordsTotal(String searchText, String type) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		HashMap<String, String> map = new HashMap<>();
		map.put("type", type);
		map.put("searchText", searchText);
		
		int cnt = mapper.recordsTotal(map);
		
		return cnt;
	}
	public BoardVO read(int bnum) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		BoardVO vo = mapper.read(bnum);		
		return vo;
	}
	public void hit(int bnum) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		mapper.hit(bnum);		
	}
	//글 하나 가져오기
	public BoardVO getBoard(int bnum) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		BoardVO vo = null;
		try{
			vo = mapper.getBoard(bnum);
		}
		catch(Exception e){
			e.printStackTrace();
		}		
		return vo;
	}
	public void updateWrite(BoardVO vo) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		mapper.updateWrite(vo);
	}
	//글 삭제
	public int del(BoardVO vo) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		int result = 0;
		try{
			result = mapper.del(vo);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	
	
	
	
	
	
}
