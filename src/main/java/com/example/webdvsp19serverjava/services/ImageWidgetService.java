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

import com.example.webdvsp19serverjava.models.ImageWidget;
import com.example.webdvsp19serverjava.models.Topics;
import com.example.webdvsp19serverjava.models.Widgets;
import com.example.webdvsp19serverjava.repositories.ImageWidgetRepository;
import com.example.webdvsp19serverjava.repositories.TopicRepository;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class ImageWidgetService {

    @Autowired
    TopicRepository topicRepositroy;
    @Autowired
    ImageWidgetRepository imageWidgetRepository;

    @PostMapping("/api/topic/{tid}/image/widgets")
    public ArrayList<Widgets> createWidget(@PathVariable("tid") int topicId,
            								@RequestBody ImageWidget newWidget,
            								HttpSession session) {
        Topics topic = topicRepositroy.findById(topicId).get();
        newWidget.setTopic(topic);
        imageWidgetRepository.save(newWidget);
        return topicRepositroy.findById(topicId).get().getWidgets();
    }

    @GetMapping("/api/image/widget/{wid}")
    public Widgets findWidgetById(@PathVariable("wid") int widgetId,
            						HttpSession session) {
        ImageWidget widget = imageWidgetRepository.findById(widgetId).get();
        if(widget !=null) {
            return widget;
        }

        return new Widgets();
    }

    @PutMapping("/api/image/widget/{wid}")
    public ArrayList<Widgets> updateWidget(@PathVariable("wid") int widgetId,
            								@RequestBody ImageWidget widgetToBeUpdated,
            								HttpSession session) {

        ImageWidget widget = imageWidgetRepository.findById(widgetId).get();
        int topicId = widget.getTopic().getId();
        widgetToBeUpdated.setId(widgetId);
        widgetToBeUpdated.setTopic(widget.getTopic());
        imageWidgetRepository.delete(widget);
        imageWidgetRepository.save(widgetToBeUpdated);
        return topicRepositroy.findById(topicId).get().getWidgets();
    }

    @DeleteMapping("/api/image/widget/{wid}")
    public ArrayList<Widgets> deleteWidget(@PathVariable("wid") int widgetId,
            								HttpSession session) {
        ImageWidget widget = imageWidgetRepository.findById(widgetId).get();
        int topicId = widget.getId();
        imageWidgetRepository.delete(widget);
        return topicRepositroy.findById(topicId).get().getWidgets();
    }
}