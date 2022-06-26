package com.LearnSpring.Controller;

import java.util.ArrayList;
import java.util.List;

import com.LearnSpring.Model.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/json")
	@ResponseBody
	public User testJSON() {
		return new User(1, "kai", "abc@gmail.com");
	}

	@RequestMapping("/list-json")
	@ResponseBody
	public List<User> testListJSON() {
		List<User> listUser = new ArrayList<>();
		listUser.add(new User(1, "kai", "abc@gmail.com"));
		listUser.add(new User(2, "stack", "def@yahoo.com"));
		return listUser;
	}
}
