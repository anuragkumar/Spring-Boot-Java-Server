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

import com.example.webdvsp19serverjava.models.ListWidget;
import com.example.webdvsp19serverjava.models.Topics;
import com.example.webdvsp19serverjava.models.Widgets;
import com.example.webdvsp19serverjava.repositories.ListWidgetRepository;
import com.example.webdvsp19serverjava.repositories.TopicRepository;
import com.example.webdvsp19serverjava.repositories.WidgetRepository;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class ListWidgetService {

    @Autowired
    TopicRepository topicRepositroy;
    @Autowired
    ListWidgetRepository listWidgetRepository;
    @Autowired
    WidgetRepository widgetRepository;

    @GetMapping("/api/topic/{tid}/list/widgets")
    public ArrayList<Widgets> findAllWidgets(@PathVariable("tid") int topicId,
            									HttpSession session) {

        Topics topic = topicRepositroy.findById(topicId).get();
        return topic.getWidgets();
    }

    @PostMapping("/api/topic/{tid}/list/widgets")
    public ArrayList<Widgets> createWidget(@PathVariable("tid") int topicId,
            								@RequestBody ListWidget newWidget,
            								HttpSession session) {
        Topics topic = topicRepositroy.findById(topicId).get();
        newWidget.setTopic(topic);
        listWidgetRepository.save(newWidget);
        return topicRepositroy.findById(topicId).get().getWidgets();
    }

    @GetMapping("/api/list/widget/{wid}")
    public Widgets findWidgetById(@PathVariable("wid") int widgetId,
            						HttpSession session) {
        ListWidget widget = listWidgetRepository.findById(widgetId).get();
        if(widget !=null) {
            return widget;
        }
        return new Widgets();
    }

    @PutMapping("/api/list/widget/{wid}")
    public ArrayList<Widgets> updateWidget(@PathVariable("wid") int widgetId,
            								@RequestBody ListWidget widgetToBeUpdated,
            								HttpSession session) {
        ListWidget widget = listWidgetRepository.findById(widgetId).get();
        int topicId = widget.getTopic().getId();
        widgetToBeUpdated.setId(widgetId);
        widgetToBeUpdated.setTopic(widget.getTopic());
        listWidgetRepository.delete(widget);
        listWidgetRepository.save(widgetToBeUpdated);
        return topicRepositroy.findById(topicId).get().getWidgets();
    }

    @DeleteMapping("/api/list/widget/{wid}")
    public ArrayList<Widgets> deleteWidget(@PathVariable("wid") int widgetId,
            								HttpSession session) {
        ListWidget widget = listWidgetRepository.findById(widgetId).get();
        int topicId = widget.getId();
        listWidgetRepository.delete(widget);
        return topicRepositroy.findById(topicId).get().getWidgets();
    }
}