package com.example.webdvsp19serverjava.models;

public class ParagraphWidget extends Widgets {
	private String paragraphText;
	
	public String getParagraphText() {
		return paragraphText;
	}
	public void setParagraphText(String paragraphText) {
		this.paragraphText = paragraphText;
	}
	public ParagraphWidget(Integer id, String widgetName) {
		super(id, widgetName);
	}

}
