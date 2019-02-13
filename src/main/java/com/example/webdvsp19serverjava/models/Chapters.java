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
	public ArrayList<Topics> createTopic(Topics topic) {
		this.topics.add(topic);
		return this.topics;
	}
	public ArrayList<Topics> findAllTopics() {
		return this.topics;
	}
	public Topics findTopicById(Integer tid) {
		for(Topics topic: this.topics) {
			if(topic.getId() == tid) {
				return topic;
			}
		}
		return null;
	}
	public ArrayList<Topics> updateTopic(Integer tid, Topics topic) {
		for(Topics top: this.topics) {
			if(top.getId() == id) {
				top.setTopicName(topic.getTopicName());
				return this.topics;
			}
		}
		return null;
	}
	public ArrayList<Topics> deleteTopic(Integer tid) {
		for(Topics topic: this.topics) {
			if(topic.getId() == id) {
				this.topics.remove(topic);
				return this.topics;
			}
		}
		return null;
	}
	
}
