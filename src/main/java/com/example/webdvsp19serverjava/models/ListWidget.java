package com.example.webdvsp19serverjava.models;

public class ListWidget extends Widgets {
	private String listText;
	private Integer listType;
	public String getListText() {
		return listText;
	}

	public void setListText(String listText) {
		this.listText = listText;
	}

	public Integer getListType() {
		return listType;
	}

	public void setListType(Integer listType) {
		this.listType = listType;
	}

	public ListWidget() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ListWidget(Integer id, String widgetName) {
		super(id, widgetName);
		// TODO Auto-generated constructor stub
	}
	
}
