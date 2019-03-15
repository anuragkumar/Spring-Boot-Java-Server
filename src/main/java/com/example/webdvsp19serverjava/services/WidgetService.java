package com.example.webdvsp19serverjava.services;

import java.util.ArrayList;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.webdvsp19serverjava.models.Topics;
import com.example.webdvsp19serverjava.models.Widgets;
import com.example.webdvsp19serverjava.repositories.TopicRepository;
import com.example.webdvsp19serverjava.repositories.WidgetRepository;

@RestController
@CrossOrigin(origins = "*", allowCredentials ="true", allowedHeaders = "*")
public class WidgetService {
	@Autowired
    TopicRepository topicRepositroy;
    @Autowired
    WidgetRepository widgetRepository;
    
    @GetMapping("/api/topic/{tid}/widgets")
    public ArrayList<Widgets> findAllWidgets(@PathVariable("tid") int topicId,
            								HttpSession session) {
        Topics topic = topicRepositroy.findById(topicId).get();
        return topic.getWidgets();
    }

    @PostMapping("/api/topic/{tid}/widgets")
    public ArrayList<Widgets> createWidget(@PathVariable("tid") int topicId,
            								@RequestBody Widgets newWidget,
            								HttpSession session) {
        Topics topic = topicRepositroy.findById(topicId).get();
        newWidget.setTopic(topic);
        widgetRepository.save(newWidget);
        return topicRepositroy.findById(topicId).get().getWidgets();
    }

    @GetMapping("/api/widget/{wid}")
    public Widgets findWidgetById(@PathVariable("wid") int widgetId,
            					HttpSession session) {
        Widgets widget = widgetRepository.findById(widgetId).get();
        if(widget !=null) {
            return widget;
        }

        return new Widgets();
    }

    @PutMapping("/api/widget/{wid}")
    public ArrayList<Widgets> updateWidget(@PathVariable("wid") int widgetId,
            								@RequestBody Widgets widgetToBeUpdated,
            								HttpSession session) {
        return null;
    }

    @DeleteMapping("/api/widget/{wid}")
    public ArrayList<Widgets> deleteWidget(@PathVariable("wid") int widgetId,
            								HttpSession session) {
        widgetRepository.deleteById(widgetId);
        return null;
    }

    @DeleteMapping("/api/widget/delete-all/{tid}")
    public void deleteAllWidgets(@PathVariable("tid") int topicId,
            					HttpSession session) {
        Topics topic = topicRepositroy.findById(topicId).get();
        ArrayList<Widgets> widgets = topic.getWidgets();
        for(Widgets widget: widgets) {
            widgetRepository.delete(widget);
        }
    }
}
