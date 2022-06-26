package com.LearnSpring.Model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "list-user")
public class ListUser {
	private List<User> listUser;

	public ListUser() {
	}

	public ListUser(List<User> listUser) {
		this.listUser = listUser;
	}

	public List<User> getListUser() {
		return listUser;
	}

	@XmlElement(name = "user")
	public void setListUser(List<User> listUser) {
		this.listUser = listUser;
	}
}
