package com.example.webdvsp19serverjava.models;

public class Widgets {
	private Integer id;
	private String widgetName;
	public Widgets() {
		
	}
	public Widgets(Integer id, String widgetName) {
		super();
		this.id = id;
		this.widgetName = widgetName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getWidgetName() {
		return widgetName;
	}
	public void setWidgetName(String widgetName) {
		this.widgetName = widgetName;
	}
	
}
