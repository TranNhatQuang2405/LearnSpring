package com.LearnSpring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TypeReturnController {
	@RequestMapping("/body")
	public String home() {
		return "home";
	}

	@RequestMapping("/body/test")
	@ResponseBody
	public String test1() {
		return "test1";
	}
}
