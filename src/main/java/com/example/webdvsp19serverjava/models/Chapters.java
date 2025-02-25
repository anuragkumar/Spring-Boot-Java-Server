package com.example.webdvsp19serverjava.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Chapters {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String chapterName;
	
	@OneToMany(mappedBy = "chapter")
	private List<Topics> topics = new ArrayList<Topics>();
	
	@ManyToOne
    @JsonIgnore
    private Modules module;
	
	public Modules getModule() {
        return module;
    }

    public void setModule(Modules module) {
        this.module = module;
    }
	
	public Chapters(Integer id, String chapterName) {
		super();
		this.id = id;
		this.chapterName = chapterName;
	}
	
	public Chapters() {
		
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
	public List<Topics> getTopics() {
		return topics;
	}
	public void setTopics(List<Topics> topics) {
		this.topics = topics;
	}
	public List<Topics> createTopic(Topics topic) {
		this.topics.add(topic);
		return this.topics;
	}
	public List<Topics> findAllTopics() {
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
	public List<Topics> updateTopic(Integer tid, Topics topic) {
		for(Topics top: this.topics) {
			if(top.getId() == tid) {
				top.setTopicName(topic.getTopicName());
				return this.topics;
			}
		}
		return null;
	}
	public List<Topics> deleteTopic(Integer tid) {
		for(Topics topic: this.topics) {
			if(topic.getId() == tid) {
				this.topics.remove(topic);
				return this.topics;
			}
		}
		return null;
	}
	
}
