package com.example.webdvsp19serverjava.models;

import java.util.ArrayList;

public class Faculty extends Person {
	public Faculty(int id, String username, String password, String firstName, String lastName){
		super(id, username, password, firstName, lastName);
	}
	
	ArrayList<Courses> courses = new ArrayList<Courses>();
	ArrayList<Sections> sections = new ArrayList<Sections>();

}
