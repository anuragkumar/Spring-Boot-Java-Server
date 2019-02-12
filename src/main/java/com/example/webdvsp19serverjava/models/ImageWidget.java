package com.example.webdvsp19serverjava.models;

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

	public ImageWidget(Integer id, String widgetName) {
		super(id, widgetName);
		// TODO Auto-generated constructor stub
	}
	
}
