package com.javassem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	
	@RequestMapping("/test.do")
	public void test() {
		System.out.println("test.do 요청");
	}
	
	@RequestMapping("/test2.do")
	public String test2(String name, Model m) {
		System.out.println("파라미터: " + name);
		m.addAttribute("message", name+"님 오늘도 졸려");
		return "happyPage";	//뷰 페이지 지정
	}
}
