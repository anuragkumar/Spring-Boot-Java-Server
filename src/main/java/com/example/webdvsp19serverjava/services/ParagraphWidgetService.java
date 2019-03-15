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

import com.example.webdvsp19serverjava.models.ParagraphWidget;
import com.example.webdvsp19serverjava.models.Topics;
import com.example.webdvsp19serverjava.models.Widgets;
import com.example.webdvsp19serverjava.repositories.ParagraphWidgetRepository;
import com.example.webdvsp19serverjava.repositories.TopicRepository;
import com.example.webdvsp19serverjava.repositories.WidgetRepository;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class ParagraphWidgetService {
    @Autowired
    TopicRepository topicRepositroy;
    @Autowired
    ParagraphWidgetRepository paragraphWidgetRepository;
    @Autowired
    WidgetRepository widgetRepository;

    @PostMapping("/api/topic/{tid}/paragraph/widgets")
    public List<Widgets> createWidget(@PathVariable("tid") int topicId,
            								@RequestBody ParagraphWidget newWidget,
            								HttpSession session) {
        Topics topic = topicRepositroy.findById(topicId).get();
        newWidget.setTopic(topic);
        paragraphWidgetRepository.save(newWidget);
        return topicRepositroy.findById(topicId).get().getWidgets();
    }

    @GetMapping("/api/paragraph/widget/{wid}")
    public Widgets findWidgetById(@PathVariable("wid") int widgetId,
            						HttpSession session) {
        ParagraphWidget widget = paragraphWidgetRepository.findById(widgetId).get();
        if(widget !=null) {
            return widget;
        }

        return new Widgets();
    }

    @PutMapping("/api/paragraph/widget/{wid}")
    public List<Widgets> updateWidget(@PathVariable("wid") int widgetId,
            								@RequestBody ParagraphWidget widgetToBeUpdated,
            								HttpSession session) {
        ParagraphWidget widget = paragraphWidgetRepository.findById(widgetId).get();
        int topicId = widget.getTopic().getId();
        widgetToBeUpdated.setId(widgetId);
        widgetToBeUpdated.setTopic(widget.getTopic());
        paragraphWidgetRepository.delete(widget);
        paragraphWidgetRepository.save(widgetToBeUpdated);
        return topicRepositroy.findById(topicId).get().getWidgets();
    }

    @DeleteMapping("/api/paragraph/widget/{wid}")
    public List<Widgets> deleteWidget(@PathVariable("wid") int widgetId,
            								HttpSession session) {
        ParagraphWidget widget = paragraphWidgetRepository.findById(widgetId).get();
        int topicId = widget.getId();
        paragraphWidgetRepository.delete(widget);
        return topicRepositroy.findById(topicId).get().getWidgets();
    }
}