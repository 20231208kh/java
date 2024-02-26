package day14;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageFormatEx1 {

	public static void main(String[] args) {
		int num1 =1, num2 =2;
		
		String str1 = "num1 = " + num1 + ", num2 = " + num2;
		System.out.println(str1);
		
		String pattern = "num1 = {0}, num2 = {1}";
		String str2 = MessageFormat.format(pattern,num1,num2);
		System.out.println(str2);
		
		Date today = new Date();
		
		SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
		
		
		
		
		
		String a [] = date.format(today).split("/");
		
		
		for(String tmp : a) {
			System.out.print(tmp+"/");
		}
		
		List<String[]> dateList = new ArrayList<String[]>();
		dateList.add(a);
		
		System.out.println(dateList);
		
		/*
		[소켓통신]
		
				
		클래스
		프로그램
		구현프로그램
		메인
		매니저
		서비스
		프린트서비스
		
				
				
		[회원가입]
		[로그인]
		[파일]
		[지출 / 지출내역(어디다썼는지) / 날짜(등록된)]
		
		[1. 지출 금액수정]
		[2. 지출내역 수정]
		[3. 지출 날짜수정]
		[4. 지출 내역 삭제]
				
		[수입 / 수입출처(어디서 얻었는지)/ 날짜(등록된)]
		[1. 수입 금액수정]
		[2. 수입 출처수정]
		[3. 수입 날짜수정]
		[4. 수입 내역 삭제]
		
		[조회]
		[1. 출처별 조회]
		[2. 금액별 조회]
		[3. 날짜별 조회]
		[4. 전체 조회]
		[파일]
				
		[종료]
		*/
		
		
	}

}