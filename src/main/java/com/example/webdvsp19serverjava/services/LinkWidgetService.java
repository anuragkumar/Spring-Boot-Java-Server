package com.example.webdvsp19serverjava.services;

import java.util.List;

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

import com.example.webdvsp19serverjava.models.LinkWidget;
import com.example.webdvsp19serverjava.models.Topics;
import com.example.webdvsp19serverjava.models.Widgets;
import com.example.webdvsp19serverjava.repositories.LinkWidgetRepository;
import com.example.webdvsp19serverjava.repositories.TopicRepository;
import com.example.webdvsp19serverjava.repositories.WidgetRepository;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class LinkWidgetService {

    @Autowired
    TopicRepository topicRepositroy;
    @Autowired
    LinkWidgetRepository linkWidgetRepository;
    @Autowired
    WidgetRepository widgetRepository;

    @GetMapping("/api/topic/{tid}/link/widgets")
    public List<Widgets> findAllWidgets(@PathVariable("tid") int topicId,
            									HttpSession session) {

        Topics topic = topicRepositroy.findById(topicId).get();
        return topic.getWidgets();
    }

    @PostMapping("/api/topic/{tid}/link/widgets")
    public List<Widgets> createWidget(@PathVariable("tid") int topicId,
            								@RequestBody LinkWidget newWidget,
            								HttpSession session) {
        Topics topic = topicRepositroy.findById(topicId).get();
        newWidget.setTopic(topic);
        linkWidgetRepository.save(newWidget);
        return topicRepositroy.findById(topicId).get().getWidgets();
    }

    @GetMapping("/api/link/widget/{wid}")
    public Widgets findWidgetById(@PathVariable("wid") int widgetId,
            						HttpSession session) {
        LinkWidget widget = linkWidgetRepository.findById(widgetId).get();
        if(widget !=null) {
            return widget;
        }
        return new Widgets();
    }

    @PutMapping("/api/link/widget/{wid}")
    public List<Widgets> updateWidget(@PathVariable("wid") int widgetId,
            								@RequestBody LinkWidget widgetToBeUpdated,
            								HttpSession session) {
        LinkWidget widget = linkWidgetRepository.findById(widgetId).get();
        int topicId = widget.getTopic().getId();
        widgetToBeUpdated.setId(widgetId);
        widgetToBeUpdated.setTopic(widget.getTopic());
        linkWidgetRepository.delete(widget);
        linkWidgetRepository.save(widgetToBeUpdated);
        return topicRepositroy.findById(topicId).get().getWidgets();
    }

    @DeleteMapping("/api/link/widget/{wid}")
    public List<Widgets> deleteWidget(@PathVariable("wid") int widgetId,
            								HttpSession session) {
        LinkWidget widget = linkWidgetRepository.findById(widgetId).get();
        int topicId = widget.getId();
        linkWidgetRepository.delete(widget);
        return topicRepositroy.findById(topicId).get().getWidgets();
    }
}