package day01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Variable4 {

	public static void main(String[] args) {
		List listSender = new ArrayList<Object>();
		Map<String, Object> mapSender = new HashMap<String, Object>();
		Map<String, Object> mapSender1 = new HashMap<String, Object>();
		// Map에 Data를 넣은 뒤에 List에 담는 로직(S)
		mapSender.put("key_1", "value_1");
		listSender.add(mapSender);
		mapSender1.put("key_2", "value_2");
		listSender.add(mapSender1);
//		System.out.println(listSender);
		
		System.out.println(listSender);
		
		String id = "key_1";
		String pw = "value_1";
		
		if(mapSender.containsKey(id)&&mapSender.containsValue(pw)) {
			System.out.println("o");
		}else {
			System.out.println("x");
		}
		
		
		
		//userdata 클래스생성
		//<String,String> login 해쉬맵 생성
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
