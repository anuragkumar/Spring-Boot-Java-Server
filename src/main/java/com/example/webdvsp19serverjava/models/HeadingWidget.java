package com.example.webdvsp19serverjava.models;

import javax.persistence.Entity;

@Entity
public class HeadingWidget extends Widgets {
	private String headingText;
	private Integer headingSize;
	public String getHeadingText() {
		return headingText;
	}
	public void setHeadingText(String headingText) {
		this.headingText = headingText;
	}
	public Integer getHeadingSize() {
		return headingSize;
	}
	public void setHeadingSize(Integer headingSize) {
		this.headingSize = headingSize;
	}
	public HeadingWidget(Integer id, String widgetName, String text, Integer size) {
		super(id, widgetName);
		this.headingText = text;
		this.headingSize = size;
	}
	
}
