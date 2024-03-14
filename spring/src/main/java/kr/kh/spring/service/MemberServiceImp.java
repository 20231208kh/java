package kr.kh.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.spring.dao.MemberDAO;
import kr.kh.spring.model.dto.LoginDTO;
import kr.kh.spring.model.vo.MemberVO;
 
@Service
public class MemberServiceImp implements MemberService {
    @Autowired
    MemberDAO memberDao;

	@Override
	public MemberVO getMember(String id) {
		return memberDao.selectMember(id);
	}

	@Override
	public boolean insertMember(MemberVO member) {
		if(member.getMe_id()==null|| 
		   member.getMe_pw()==null||
		   member.getMe_email()==null) {
			return false;
		}
		
		
		MemberVO user = memberDao.selectMember(member.getMe_id());
		if(user != null) {
			return false;
		}
		
		return memberDao.insertMember(member);
	}

	@Override
	public MemberVO login(LoginDTO loginDTO) {
		if(loginDTO ==null||
			!checkString(loginDTO.getId())||
			!checkString(loginDTO.getPw())) {
			return null;
		}
		MemberVO user = memberDao.selectMember(loginDTO.getId());
		
		if(user == null || !user.getMe_pw().equals(loginDTO.getPw())) {
			return null;
		}
		return user;
		
	}
	
	public boolean checkString(String str) {
		if(str == null || str.length() == 0) {
			return false;
		}
		return true;
	}
	
	
	
}
