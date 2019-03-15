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

import com.example.webdvsp19serverjava.models.Chapters;
import com.example.webdvsp19serverjava.models.Topics;
import com.example.webdvsp19serverjava.repositories.LessonRepository;
import com.example.webdvsp19serverjava.repositories.TopicRepository;

@RestController
@CrossOrigin(origins = "*", allowCredentials ="true", allowedHeaders = "*")
public class TopicService {
	@Autowired
    LessonRepository lessonRepository;
    @Autowired
    TopicRepository topicRepositroy;

    @GetMapping("/api/lesson/{lid}/topics")
    public List<Topics> findAllTopics(@PathVariable("lid") int lessonId,
            								HttpSession session) {
        Chapters lesson = lessonRepository.findById(lessonId).get();
        return lesson.getTopics();
    }


    @PostMapping("/api/lesson/{lid}/topics")
    public List<Topics> createTopic(@PathVariable("lid") int lessonId,
            							@RequestBody Topics newTopic,
            							HttpSession session) {
        Chapters lesson = lessonRepository.findById(lessonId).get();
        newTopic.setChapter(lesson);
        topicRepositroy.save(newTopic);
        return lessonRepository.findById(lessonId).get().getTopics();
    }


    @GetMapping("/api/topic/{tid}")
    public Topics findTopicById(@PathVariable("tid") int topicId,
            					HttpSession session) {
        Topics topic = topicRepositroy.findById(topicId).get();
        if(topic != null) {
            return topic;
        }

        return new Topics(0, "");
    }

    @PutMapping("/api/topic/{tid}")
    public List<Topics> updateTopic(@PathVariable("tid") int topicId,
            							@RequestBody Topics topicToBeUpdated,
            							HttpSession session) {
        Topics topic = topicRepositroy.findById(topicId).get();
        if(topic == null) {
            return null;
        }
        topic.setTopicName(topicToBeUpdated.getTopicName());
        topicRepositroy.save(topic);
        Chapters lesson = lessonRepository.findById(topic.getChapter().getId()).get();
        return lesson.getTopics();
    }


    @DeleteMapping("/api/topic/{tid}")
    public List<Topics> deleteTopic(@PathVariable("tid") int topicId,
            							HttpSession session) {
        Topics topic = topicRepositroy.findById(topicId).get();
        int lessonId = topic.getChapter().getId();
        topicRepositroy.delete(topic);
        Chapters lesson = lessonRepository.findById(lessonId).get();
        return lesson.getTopics();
    }
}
