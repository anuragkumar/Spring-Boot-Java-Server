package com.example.webdvsp19serverjava.models;

import java.util.ArrayList;

public class Modules {
	private Integer id;
	private String moduleName;
	private ArrayList<Chapters> chapters = new ArrayList<Chapters>();
	public Modules(Integer id, String moduleName) {
		super();
		this.id = id;
		this.moduleName = moduleName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public ArrayList<Chapters> getChapters() {
		return chapters;
	}
	public void setChapters(ArrayList<Chapters> chapters) {
		this.chapters = chapters;
	}
}
