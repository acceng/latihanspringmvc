package com.eksad.latihanspringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/my")
public class MyController {
	
	@RequestMapping("hello")	//hello disini adalah untuk di URL
	public String hello() {
		
		return "hello";			//nama di return harus sama dengan nama file templates
	}
	
	@RequestMapping("myName")
	public String myName(@RequestParam String name, Model model) {		// menghubunfkan data java ke html
		
		model.addAttribute("name", name);
		
		return "myname";
	}
}
