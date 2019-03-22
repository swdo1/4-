package global.sesoc.test3.dao;

import java.util.ArrayList;

import global.sesoc.test3.vo.ClientVO;

public interface ClientMapper {
	//가입
	public void join(ClientVO vo);
	//회원 리스트
	public ArrayList<ClientVO> list();
	//아이디 중복처리
	public ClientVO idCheck(String id);
	//회원 객체 하나
	public ClientVO getClient(String id);
	//수정
	public void update(ClientVO vo);
	//탈퇴
	public void leave(String id);

}
