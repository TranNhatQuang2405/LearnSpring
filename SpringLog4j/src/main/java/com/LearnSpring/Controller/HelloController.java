package com.LearnSpring.Controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	private static final Logger logger = Logger.getLogger(HelloController.class);

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/error")
	public String error() throws Exception {
		throw new Exception("testing");
	}

}
