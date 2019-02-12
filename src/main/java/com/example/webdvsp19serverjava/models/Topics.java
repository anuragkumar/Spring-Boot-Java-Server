package com.example.webdvsp19serverjava.models;

import java.util.ArrayList;

public class Topics {
	private Integer id;
	private String topicName;
	private ArrayList<Widgets> widgets = new ArrayList<Widgets>();
	public Topics(Integer id, String topicName) {
		super();
		this.id = id;
		this.topicName = topicName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	public ArrayList<Widgets> getWidgets() {
		return widgets;
	}
	public void setWidgets(ArrayList<Widgets> widgets) {
		this.widgets = widgets;
	}
	
}
