package com.example.webdvsp19serverjava.services;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.webdvsp19serverjava.models.Chapters;
import com.example.webdvsp19serverjava.models.Courses;
import com.example.webdvsp19serverjava.models.Faculty;
import com.example.webdvsp19serverjava.models.Modules;
import com.example.webdvsp19serverjava.models.Topics;
import com.example.webdvsp19serverjava.models.Widgets;

@RestController
public class WidgetService {
	@PostMapping("/api/courses/{cid}/modules/{mid}/lessons/{lid}/topics/{tid}/widgets")
	public ArrayList<Widgets> createTopic(@PathVariable("cid") Integer cid,
											@PathVariable("mid") Integer mid,
											@PathVariable("lid") Integer lid,
											@PathVariable("tid") Integer tid,
											@RequestBody Widgets widget,
											HttpSession session){
		Faculty user = (Faculty)session.getAttribute("currentUser");
		Courses course = user.findCourseById(cid);
		Modules module = course.findModuleById(mid);
		Chapters chapter = module.findLessonById(lid);
		Topics topic = chapter.findTopicById(tid);
		return topic.createWidget(widget);
	}
	
	@GetMapping("/api/courses/{cid}/modules/{mid}/lessons/{lid}/topics/{tid}/widgets")
	public ArrayList<Widgets> findAllWidgets(@PathVariable("cid") Integer cid, 
											@PathVariable("mid") Integer mid,
											@PathVariable("lid") Integer lid,
											@PathVariable("tid") Integer tid,
											HttpSession session){
		Faculty user = (Faculty)session.getAttribute("currentUser");
		Courses course = user.findCourseById(cid);
		Modules module = course.findModuleById(mid);
		Chapters chapter = module.findLessonById(lid);
		Topics topic = chapter.findTopicById(tid);
		return topic.findAllWidgets();
	}
	
	@DeleteMapping("/api/courses/{cid}/modules/{mid}/lessons/{lid}/topics/{tid}/widgets/{wid}")
	public ArrayList<Widgets> deleteTopic(@PathVariable("cid") Integer cid, 
											@PathVariable("mid") Integer mid,
											@PathVariable("lid") Integer lid,
											@PathVariable("tid") Integer tid,
											@PathVariable("wid") Integer wid,
											HttpSession session){
		Faculty user = (Faculty)session.getAttribute("currentUser");
		Courses course = user.findCourseById(cid);
		Modules module = course.findModuleById(mid);
		Chapters chapter = module.findLessonById(lid);
		Topics topic = chapter.findTopicById(tid);
		return topic.deleteWidget(wid);
	}
}
