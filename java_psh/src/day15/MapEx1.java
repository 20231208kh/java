package day15;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapEx1 {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String,String>();
		
		map.put("abc123","abc123!");
		map.put("def456","abc123!");
		map.put("abc123","123ad"); // key값은 중복 허용x value값은 중복 허용 o
		map.put("admin","admin");
		map.put("def","def");
		System.out.println(map.remove("abc123")); //해당 key의 value를 반환하고 key를 삭제
		System.out.println(map);
		
		Set<String> keySet = map.keySet();
		for(String tmpString : keySet) {
			String value = map.get(tmpString);
			System.out.println(value);
		}
		
		Set<Map.Entry<String,String>> entrySet = map.entrySet();
		
		
	}

}

class Entry1<K,V>{
	K key;
	V Value;
}