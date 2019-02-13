package com.example.webdvsp19serverjava.models;

import java.util.ArrayList;

public class Courses {
	private int id;
	private String courseName;
	private ArrayList<Modules> modules = new ArrayList<Modules>();
	
	public Courses(int id, String courseName) {
		super();
		this.id = id;
		this.courseName = courseName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public ArrayList<Modules> getModules() {
		return modules;
	}
	public void setModules(ArrayList<Modules> modules) {
		this.modules = modules;
	}
	
	public ArrayList<Modules> createModule(Modules module){
		this.modules.add(module);
		return this.modules;
	}
	
	public ArrayList<Modules> findAllModules(){
		return this.modules;
	}
}
