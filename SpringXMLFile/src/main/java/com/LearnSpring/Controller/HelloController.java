package com.LearnSpring.Controller;

import java.util.ArrayList;
import java.util.List;

import com.LearnSpring.Model.ListUser;
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

	@RequestMapping("/xml")
	@ResponseBody
	public User testXML() {
		User user = new User(1, "kai", "abc@gmail.com");
		return user;
	}

	@RequestMapping("/list-xml")
	@ResponseBody
	public ListUser testListXML() {
		User user1 = new User(1, "kai", "abc@gmail.com");
		User user2 = new User(2, "stack", "def@yahoo.com");
		List<User> listUser = new ArrayList<User>();
		listUser.add(user1);
		listUser.add(user2);
		ListUser list = new ListUser(listUser);
		return list;
	}
}
