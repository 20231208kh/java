package kr.kh.spring3.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberVO {
	
	private String me_id;
	private String me_pw;
	private String me_email;
}
