package kr.kh.spring.dao;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring.model.vo.MemberVO;

public interface MemberDAO {
    public String getEmail(@Param("id")String id);

	public MemberVO selectMember(@Param("id")String id);

	public boolean insertMember(@Param("member")MemberVO member);
}