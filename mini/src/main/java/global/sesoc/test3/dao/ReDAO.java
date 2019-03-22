package global.sesoc.test3.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import global.sesoc.test3.vo.ReVO;

@Repository
public class ReDAO {

	@Autowired
	SqlSession sqlSession;
	
	//리플 등록
	public void insert(ReVO vo) {
		ReMapper mapper = sqlSession.getMapper(ReMapper.class);
		mapper.insert(vo);
		
	}
	//리플 리스트 가져오기
	public ArrayList<ReVO> list(int bnum) {
		ReMapper mapper = sqlSession.getMapper(ReMapper.class);
		ArrayList<ReVO> list = mapper.list(bnum);
		
		return list;
	}

}
