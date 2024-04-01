package kr.kh.spring2.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.kh.spring2.model.dto.LoginDTO;
import kr.kh.spring2.model.dto.LoginDTOList;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, String id) {
		
		model.addAttribute("hi", "안녕하세요");
		
		return "home";
	}
	
	@PostMapping("/login")
	public String login(LoginDTO loginDTO, Model model) {
		System.out.println(loginDTO);
		
		model.addAttribute("member", loginDTO);
		
		return "/test";
	}
	
	@GetMapping("/name")
	public String name(String name) {
		System.out.println(name);
		return "redirect:/";
	}
	
	@GetMapping("/hobby")
	public String Hobby(String ...hobby) {
		
		for(String hobbies : hobby) {
			System.out.println(hobbies);
		}
		
		return "redirect:/";
	}
	
	@GetMapping("/send/object")
	public String sendObject() {
		
		
		return "sendobject";
	}
	
	
	@PostMapping("/send/object")
	public String sendObjectPost(LoginDTOList list) {
		
		System.out.println(list);
		return "redirect:/send/object";
	}
	
	@GetMapping("/send/path/{num}")
	public String sendPath(@PathVariable("num") int num) {
		System.out.println(num);
		return "redirect:/";
	}
	
	@GetMapping("/ajax")
	public String ajax() {
		return "ajax";
	}
	
	
	
}
