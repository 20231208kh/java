package kr.kh.spring2.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class LoginDTO {
	private String id;
	private String pw;
}
