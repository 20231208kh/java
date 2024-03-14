package kr.kh.spring.service;

import kr.kh.spring.model.dto.LoginDTO;
import kr.kh.spring.model.vo.MemberVO;

public interface MemberService {
	public MemberVO getMember(String id);

	public boolean insertMember(MemberVO member);

	public MemberVO login(LoginDTO loginDTO);
}
