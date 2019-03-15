package com.example.webdvsp19serverjava.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;

@Entity
public class Topics {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String topicName;
	
	@OneToMany(mappedBy = "topic")
	private ArrayList<Widgets> widgets = new ArrayList<Widgets>();
	
	@ManyToOne
    @JsonIgnore
    private Chapters chapter;
	
	public Chapters getChapter() {
        return chapter;
    }

    public void setChapter(Chapters chapter) {
        this.chapter = chapter;
    }

	
	public Topics(Integer id, String topicName) {
		super();
		this.id = id;
		this.topicName = topicName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	public ArrayList<Widgets> getWidgets() {
		return widgets;
	}
	public void setWidgets(ArrayList<Widgets> widgets) {
		this.widgets = widgets;
	}
	public ArrayList<Widgets> createWidget(Widgets widget) {
		this.widgets.add(widget);
		return this.widgets;
	}
	public ArrayList<Widgets> findAllWidgets() {
		return this.widgets;
	}
	public ArrayList<Widgets> deleteWidget(Integer wid) {
		for(Widgets widget: this.widgets) {
			if(widget.getId() == wid) {
				this.widgets.remove(widget);
				return this.widgets;
			}
		}
		return null;
	}
	
}
