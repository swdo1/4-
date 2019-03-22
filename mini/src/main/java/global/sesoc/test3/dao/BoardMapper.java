package global.sesoc.test3.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;

import global.sesoc.test3.vo.BoardVO;

public interface BoardMapper {
	//글쓰기
	public void write(BoardVO vo);
	//게시판 목록
	public ArrayList<BoardVO> list(RowBounds rb, HashMap<String, String> map);
	//전체 글 개수
	public int recordsTotal(HashMap<String, String> map);
	//글읽기
	public BoardVO read(int bnum);
	//조회수
	public void hit(int bnum);
	//글 하나 가져오기
	public BoardVO getBoard(int bnum);
	//글 수정
	public void updateWrite(BoardVO vo);
	//글 삭제
	public int del(BoardVO vo);
	

}
