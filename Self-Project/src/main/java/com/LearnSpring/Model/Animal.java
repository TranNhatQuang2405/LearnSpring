package com.LearnSpring.Model;

import java.io.Serializable;

public class Animal implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	protected int Id;
	protected String Name;
	protected String Description;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Animal(int id, String name, String description) {
		super();
		Id = id;
		Name = name;
		Description = description;
	}
	public Animal() {
		super();
	}
	
	
}
