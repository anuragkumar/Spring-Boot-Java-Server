package com.example.webdvsp19serverjava.models;

import javax.persistence.Entity;

@Entity
public class ParagraphWidget extends Widgets {
	private String paragraphText;
	
	public String getParagraphText() {
		return paragraphText;
	}
	public void setParagraphText(String paragraphText) {
		this.paragraphText = paragraphText;
	}
	public ParagraphWidget(Integer id, String widgetName, String text) {
		super(id, widgetName);
		this.paragraphText = text;
	}
	
	public ParagraphWidget() {
		
	}

}
