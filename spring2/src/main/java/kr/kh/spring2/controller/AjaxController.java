package kr.kh.spring2.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.kh.spring2.model.dto.LoginDTO;

@RestController //@Controller + @ResponseBody , 비동기 통신용 컨트롤러
@RequestMapping("/ajax")
public class AjaxController {

	@PostMapping("/json/json")
	public Map<String, Object> jsonJson(@RequestBody LoginDTO member){
		HashMap<String, Object> map = new HashMap<String, Object>();
		System.out.println(member);
		
		map.put("member", member);
		map.put("name", "홍길동");
		
		return map;
	}
	
	@GetMapping("/object/json")
	public Map<String,Object> objectJson(
			@RequestParam("id")String id, @RequestParam("name")String name){
		HashMap<String,Object> map = new HashMap<String, Object>();
		
		return map;
	}
	
	@PostMapping("/test")
	public Map<String,Object> testJson(
			@RequestParam("name")String name, @RequestParam("age")String ageStr){
		
		System.out.println(name);
		int age = Integer.parseInt(ageStr);
		System.out.println(age);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("result", "성공");
		return map;
		
	}
}
