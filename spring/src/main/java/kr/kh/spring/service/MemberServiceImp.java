package kr.kh.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import kr.kh.spring.dao.MemberDAO;
import kr.kh.spring.model.vo.MemberVO;
 
@Service
public class MemberServiceImp implements MemberService {
    @Autowired
    MemberDAO memberDao;

	@Override
	public MemberVO getMember(String id) {
		return memberDao.selectMember(id);
	}
}
