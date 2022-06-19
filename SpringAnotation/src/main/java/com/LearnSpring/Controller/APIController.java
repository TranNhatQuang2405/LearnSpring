package com.LearnSpring.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIController {
	@RequestMapping("/api/test")
	public String test2() {
		return "test2";
	}
}
