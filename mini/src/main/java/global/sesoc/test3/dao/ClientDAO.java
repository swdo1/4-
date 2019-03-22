package global.sesoc.test3.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import global.sesoc.test3.vo.ClientVO;

@Repository
public class ClientDAO {

	@Autowired
	SqlSession sqlSession;
	//가입처리
	public void join(ClientVO vo) {
		
		ClientMapper mapper = sqlSession.getMapper(ClientMapper.class);
		
		try{
			mapper.join(vo);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//회원 리스트
	public ArrayList<ClientVO> list() {
		ClientMapper mapper = sqlSession.getMapper(ClientMapper.class);
		
		ArrayList<ClientVO> list = mapper.list();
		
		return list;
	}
	//아이디 중복 처리
	public String idCheck(String id) {
		ClientMapper mapper = sqlSession.getMapper(ClientMapper.class);
		ClientVO vo = null;
		String result = "true";
		try{
			vo = mapper.idCheck(id);
			//System.out.println(vo);
			if(vo == null){
				result = "false";
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	//객체 하나 불러옴
	public ClientVO getClient(String id) {
		ClientMapper mapper = sqlSession.getMapper(ClientMapper.class);
		
		ClientVO vo = null;
		vo = mapper.getClient(id);
		return vo;
	}
	//업데이트
	public void update(ClientVO vo) {
		ClientMapper mapper = sqlSession.getMapper(ClientMapper.class);		
		mapper.update(vo);
	}
	//탈퇴
	public void leave(String id) {
		ClientMapper mapper = sqlSession.getMapper(ClientMapper.class);
		mapper.leave(id);
	}
	

	
	
	
	
}
