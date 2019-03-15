package com.example.webdvsp19serverjava.models;

import javax.persistence.Entity;

@Entity
public class LinkWidget extends Widgets {
	private String linkUrl;
	private String linkText;
	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public String getLinkText() {
		return linkText;
	}

	public void setLinkText(String linkText) {
		this.linkText = linkText;
	}

	public LinkWidget() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LinkWidget(Integer id, String widgetName, String url, String text) {
		super(id, widgetName);
		this.linkUrl = url;
		this.linkText = text;
	}

}
