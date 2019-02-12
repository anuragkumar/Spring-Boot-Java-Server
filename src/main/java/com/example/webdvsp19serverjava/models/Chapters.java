package com.example.webdvsp19serverjava.models;

import java.util.ArrayList;

public class Chapters {
	private Integer id;
	private String chapterName;
	private ArrayList<Topics> topics = new ArrayList<Topics>();
	public Chapters(Integer id, String chapterName) {
		super();
		this.id = id;
		this.chapterName = chapterName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getChapterName() {
		return chapterName;
	}
	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}
	public ArrayList<Topics> getTopics() {
		return topics;
	}
	public void setTopics(ArrayList<Topics> topics) {
		this.topics = topics;
	}
	
}
