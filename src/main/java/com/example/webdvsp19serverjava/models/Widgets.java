package com.example.webdvsp19serverjava.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

@Entity
public class Widgets {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String widgetName;
	
	@ManyToOne
    @JsonIgnore
    private Topics topic;
	
	public Topics getTopic() {
        return topic;
    }

    public void setTopic(Topics topic) {
        this.topic = topic;
    }
    
	public Widgets() {
		
	}
	public Widgets(Integer id, String widgetName) {
		super();
		this.id = id;
		this.widgetName = widgetName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getWidgetName() {
		return widgetName;
	}
	public void setWidgetName(String widgetName) {
		this.widgetName = widgetName;
	}
	
}
