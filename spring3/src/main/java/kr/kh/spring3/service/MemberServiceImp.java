package kr.kh.spring3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.kh.spring3.dao.MemberDAO;
import kr.kh.spring3.model.dto.LoginDTO;
import kr.kh.spring3.model.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService {

	@Autowired
	MemberDAO memberDao;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Override
	public int getMemberCount() {
		return memberDao.selectMemberCount();
	}

	@Override
	public boolean signup(MemberVO member) {
		
		if(member ==null||
		   !checkString(member.getMe_id())||
		   !checkString(member.getMe_pw())||
		   !checkString(member.getMe_email())) {
			return false;
		}
		
		String id = member.getMe_id();
		MemberVO dbMember = memberDao.selectMember(id);
		if(dbMember != null) {
			return false;
		}
		
		member.setMe_pw(passwordEncoder.encode(member.getMe_pw()));
		
		boolean res = memberDao.insertMember(member);
		
		return res;
		
		
		
	}
	
	public boolean checkString(String str) {
		if(str.length()==0 || str==null) {
			return false;
		}
		return true;
	}

	@Override
	public MemberVO login(LoginDTO loginDTO) {
		if(loginDTO == null||
		   !checkString(loginDTO.getId())||
		   !checkString(loginDTO.getPw())) {
			return null;
		}
		
		MemberVO user = memberDao.selectMember(loginDTO.getId());
		
		
		if(user==null || !passwordEncoder.matches(loginDTO.getPw(), user.getMe_pw())) {
			return null;
		}
		
		return user;
		
		
	}
}