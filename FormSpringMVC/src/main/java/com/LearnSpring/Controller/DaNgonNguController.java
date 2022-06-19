package com.LearnSpring.Controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DaNgonNguController {

	@Autowired
	private MessageSource messageSource;

	@RequestMapping("/dangonngu")
	public String home(Model model,  HttpServletRequest request) {
		String message = messageSource.getMessage("hello", null, "default message", Locale.JAPANESE);
		System.out.println(message);
		model.addAttribute("message", message);
		return "dangonngu";
	}
}
