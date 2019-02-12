package com.example.webdvsp19serverjava.models;

public class Sections {
	private Integer id;
	private String sectionName;
	
	public Sections(Integer id, String sectionName) {
		super();
		this.id = id;
		this.sectionName = sectionName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
}
