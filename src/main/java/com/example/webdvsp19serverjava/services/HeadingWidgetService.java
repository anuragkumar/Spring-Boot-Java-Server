package com.example.webdvsp19serverjava.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.webdvsp19serverjava.models.HeadingWidget;
import com.example.webdvsp19serverjava.models.Topics;
import com.example.webdvsp19serverjava.models.Widgets;
import com.example.webdvsp19serverjava.repositories.HeadingWidgetRepository;
import com.example.webdvsp19serverjava.repositories.TopicRepository;

import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class HeadingWidgetService {

    @Autowired
    TopicRepository topicRepositroy;
    @Autowired
    HeadingWidgetRepository headingWidgetRepository;

    @GetMapping("/api/topic/{tid}/heading/widgets")
    public ArrayList<Widgets> findAllWidgets(@PathVariable("tid") int topicId,
            								HttpSession session) {
        Topics topic = topicRepositroy.findById(topicId).get();
        return topic.getWidgets();
    }

    @PostMapping("/api/topic/{tid}/heading/widgets")
    public ArrayList<Widgets> createWidget(@PathVariable("tid") int topicId,
            								@RequestBody HeadingWidget newWidget,
            								HttpSession session) {
        Topics topic = topicRepositroy.findById(topicId).get();
        newWidget.setTopic(topic);
        headingWidgetRepository.save(newWidget);
        return topicRepositroy.findById(topicId).get().getWidgets();
    }

    @GetMapping("/api/heading/widget/{wid}")
    public Widgets findWidgetById(@PathVariable("wid") int widgetId,
            						HttpSession session) {
        HeadingWidget widget = headingWidgetRepository.findById(widgetId).get();
        if(widget !=null) {
            return widget;
        }

        return new Widgets();
    }

    @PutMapping("/api/heading/widget/{wid}")
    public ArrayList<Widgets> updateWidget(@PathVariable("wid") int widgetId,
            								@RequestBody HeadingWidget widgetToBeUpdated,
            								HttpSession session) {
        HeadingWidget widget = headingWidgetRepository.findById(widgetId).get();
        int topicId = widget.getTopic().getId();
        widgetToBeUpdated.setId(widgetId);
        widgetToBeUpdated.setTopic(widget.getTopic());
        headingWidgetRepository.delete(widget);
        headingWidgetRepository.save(widgetToBeUpdated);
        return topicRepositroy.findById(topicId).get().getWidgets();
    }

    @DeleteMapping("/api/heading/widget/{wid}")
    public ArrayList<Widgets> deleteWidget(@PathVariable("wid") int widgetId,
            								HttpSession session) {
        HeadingWidget widget = headingWidgetRepository.findById(widgetId).get();
        int topicId = widget.getId();
        headingWidgetRepository.delete(widget);
        return topicRepositroy.findById(topicId).get().getWidgets();
    }

}
