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

import com.example.webdvsp19serverjava.models.Chapters;
import com.example.webdvsp19serverjava.models.Modules;
import com.example.webdvsp19serverjava.repositories.LessonRepository;
import com.example.webdvsp19serverjava.repositories.ModuleRepository;

@RestController
@CrossOrigin(origins = "*", allowCredentials ="true", allowedHeaders = "*")
public class LessonService {
	@Autowired
    ModuleRepository moduleRepository;
    @Autowired
    LessonRepository lessonRepository;
	
    @PostMapping("/api/module/{mid}/lessons")
    public ArrayList<Chapters> createLesson(@PathVariable("mid") int moduleId,
            								@RequestBody Chapters newLesson,
            								HttpSession session) {
        Modules module = moduleRepository.findById(moduleId).get();
        newLesson.setModule(module);
        lessonRepository.save(newLesson);

        return moduleRepository.findById(moduleId).get().findAllLessons();
    }
	
	@GetMapping("/api/module/{mid}/lessons")
    public ArrayList<Chapters> findAllLessons(@PathVariable("mid") int moduleId, 
    											HttpSession session) {
        Modules module = moduleRepository.findById(moduleId).get();
        return module.findAllLessons();
    }
	
	@GetMapping("/api/lesson/{lid}")
    public Chapters findLessonById(@PathVariable("lid") int lessonId,
            						HttpSession session) {
        Chapters lesson = lessonRepository.findById(lessonId).get();
        if(lesson != null) {
            return lesson;
        }

        return new Chapters(0, "");
    }


    @PutMapping("/api/lesson/{lid}")
    public ArrayList<Chapters> updateLesson(@PathVariable("lid") int lessonId,
            								@RequestBody Chapters lessonToBeUpdated,
            								HttpSession session) {
        Chapters lesson = lessonRepository.findById(lessonId).get();
        if(lesson == null) {
            return null;
        }
       lesson.setChapterName(lessonToBeUpdated.getChapterName());
       lessonRepository.save(lesson);
       Modules module = moduleRepository.findById(lesson.getModule().getId()).get();
       return module.findAllLessons();
    }

    @DeleteMapping("/api/lesson/{lid}")
    public ArrayList<Chapters> deleteLesson(@PathVariable("lid") int lessonId,
            								HttpSession session) {
        Chapters lesson = lessonRepository.findById(lessonId).get();
        int moduleId = lesson.getModule().getId();
        lessonRepository.delete(lesson);
        Modules module = moduleRepository.findById(moduleId).get();
        return module.findAllLessons();
    }
}
