package com.example.webdvsp19serverjava.services;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.webdvsp19serverjava.models.Chapters;
import com.example.webdvsp19serverjava.models.Courses;
import com.example.webdvsp19serverjava.models.Faculty;
import com.example.webdvsp19serverjava.models.Modules;
import com.example.webdvsp19serverjava.models.Topics;

@RestController
public class TopicService {
	@PostMapping("/api/courses/{cid}/{mid}/lessons/{lid}/topics")
	public ArrayList<Topics> createTopic(@PathVariable("cid") Integer cid,
											@PathVariable("mid") Integer mid,
											@PathVariable("lid") Integer lid,
											@RequestBody Topics topic,
											HttpSession session){
		Faculty user = (Faculty)session.getAttribute("currentUser");
		Courses course = user.findCourseById(cid);
		Modules module = course.findModuleById(mid);
		Chapters chapter = module.findLessonById(lid);
		return chapter.createTopic(topic);
	}
	
	@GetMapping("/api/course/{cid}/{mid}/lessons/{lid}/topics")
	public ArrayList<Topics> findAllTopics(@PathVariable("cid") Integer cid, 
											@PathVariable("mid") Integer mid,
											@PathVariable("lid") Integer lid,
											HttpSession session){
		Faculty user = (Faculty)session.getAttribute("currentUser");
		Courses course = user.findCourseById(cid);
		Modules module = course.findModuleById(mid);
		Chapters chapter = module.findLessonById(lid);
		return chapter.findAllTopics();
	}
	
	@GetMapping("/api/modules/{cid}/{mid}/lessons/{lid}/topics/{tid}")
	public Topics findLessonById(@PathVariable("cid") Integer cid, 
									@PathVariable("mid") Integer mid, 
									@PathVariable("lid") Integer lid,
									@PathVariable("tid") Integer tid,
									HttpSession session){
		Faculty user = (Faculty)session.getAttribute("currentUser");
		Courses course = user.findCourseById(cid);
		Modules module = course.findModuleById(mid);
		Chapters chapter = module.findLessonById(lid);
		return chapter.findTopicById(tid);
	}
	
	@PutMapping("/api/modules/{cid}/{mid}/lessons/{lid}/topics/{tid}")
	public ArrayList<Topics> updateTopic(@PathVariable("cid") Integer cid, 
									@PathVariable("mid") Integer mid, 
									@PathVariable("lid") Integer lid, 
									@PathVariable("tid") Integer tid, 
									@RequestBody Topics topic,
									HttpSession session){
		Faculty user = (Faculty)session.getAttribute("currentUser");
		Courses course = user.findCourseById(cid);
		Modules module = course.findModuleById(mid);
		Chapters chapter = module.findLessonById(lid);
		return chapter.updateTopic(tid, topic);
	}
	
	@DeleteMapping("/api/courses/{cid}/{mid}/lessons/{lid}/topics/{tid}")
	public ArrayList<Topics> deleteTopic(@PathVariable("cid") Integer cid, 
											@PathVariable("mid") Integer mid,
											@PathVariable("lid") Integer lid,
											@PathVariable("tid") Integer tid,
											HttpSession session){
		Faculty user = (Faculty)session.getAttribute("currentUser");
		Courses course = user.findCourseById(cid);
		Modules module = course.findModuleById(mid);
		Chapters chapter = module.findLessonById(lid);
		return chapter.deleteTopic(tid);
	}
}
