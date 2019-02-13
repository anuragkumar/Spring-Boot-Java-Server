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

@RestController
public class LessonService {
	@PostMapping("/api/courses/{cid}/modules/{mid}/lessons")
	public ArrayList<Chapters> createLesson(@PathVariable("cid") Integer cid,
											@PathVariable("mid") Integer mid,
											@RequestBody Chapters chapter,
											HttpSession session){
		Faculty user = (Faculty)session.getAttribute("currentUser");
		Courses course = user.findCourseById(cid);
		Modules module = course.findModuleById(mid);
		return module.createLesson(chapter);
	}
	
	@GetMapping("/api/courses/{cid}/modules/{mid}/lessons")
	public ArrayList<Chapters> findAllLessons(@PathVariable("cid") Integer cid, 
											@PathVariable("mid") Integer mid,
											HttpSession session){
		Faculty user = (Faculty)session.getAttribute("currentUser");
		Courses course = user.findCourseById(cid);
		Modules module = course.findModuleById(mid);
		return module.findAllLessons();
	}
	
	@GetMapping("/api/courses/{cid}/modules/{mid}/lessons/{lid}")
	public Chapters findLessonById(@PathVariable("cid") Integer cid, 
									@PathVariable("mid") Integer mid, 
									@PathVariable("lid") Integer lid,
									HttpSession session){
		Faculty user = (Faculty)session.getAttribute("currentUser");
		Courses course = user.findCourseById(cid);
		Modules module = course.findModuleById(mid);
		return module.findLessonById(lid);
	}
	
	@PutMapping("/api/courses/{cid}/modules/{mid}/lessons/{lid}")
	public ArrayList<Chapters> updateLesson(@PathVariable("cid") Integer cid, 
									@PathVariable("mid") Integer mid, 
									@PathVariable("lid") Integer lid, 
									@RequestBody Chapters chapter,
									HttpSession session){
		Faculty user = (Faculty)session.getAttribute("currentUser");
		Courses course = user.findCourseById(cid);
		Modules module = course.findModuleById(mid);
		return module.updateLesson(lid, chapter);
	}
	
	@DeleteMapping("/api/courses/{cid}/modules/{mid}/lessons/{lid}")
	public ArrayList<Chapters> deleteCourse(@PathVariable("cid") Integer cid, 
											@PathVariable("mid") Integer mid,
											@PathVariable("lid") Integer lid,
											HttpSession session){
		Faculty user = (Faculty)session.getAttribute("currentUser");
		Courses course = user.findCourseById(cid);
		Modules module = course.findModuleById(mid);
		return module.deleteLesson(lid);
	}
}
