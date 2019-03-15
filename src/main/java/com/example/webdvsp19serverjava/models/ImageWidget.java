package com.example.webdvsp19serverjava.models;

import javax.persistence.Entity;

@Entity
public class ImageWidget extends Widgets {
	private String imageUrl;
	
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public ImageWidget() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ImageWidget(Integer id, String widgetName, String url) {
		super(id, widgetName);
		this.imageUrl = url;
	}
	
}
