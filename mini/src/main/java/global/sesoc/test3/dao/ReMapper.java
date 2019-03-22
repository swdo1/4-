package global.sesoc.test3.dao;

import java.util.ArrayList;

import global.sesoc.test3.vo.ReVO;

public interface ReMapper {
	//리플 등록
	public void insert(ReVO vo);
	//리스트
	public ArrayList<ReVO> list(int bnum);

}
