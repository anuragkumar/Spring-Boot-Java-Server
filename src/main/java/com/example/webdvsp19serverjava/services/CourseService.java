package com.example.webdvsp19serverjava.services;

import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.webdvsp19serverjava.models.Courses;
import com.example.webdvsp19serverjava.models.Faculty;

@RestController
@CrossOrigin(origins = "*", allowCredentials ="true")
public class CourseService {
	Random ran = new Random();
	
	@PostMapping("/api/courses")
	public ArrayList<Courses> createCourse(@RequestBody Courses course, HttpSession session) {
		Faculty user = (Faculty)session.getAttribute("currentUser");
		course.setId(ran.nextInt(100));
		return user.addCourse(course);
	}
	
	@GetMapping("/api/courses")
	public ArrayList<Courses> findAllCourses(HttpSession session) {
		Faculty user = (Faculty)session.getAttribute("currentUser");
		return user.findAllCourses();
	}
	
	@GetMapping("/api/courses/{courseID}")
	public Courses findCourseById(@PathVariable("courseID") Integer id, HttpSession session) {
		Faculty user = (Faculty)session.getAttribute("currentUser");
		return user.findCourseById(id);
	}
	
	@PutMapping("/api/courses/{courseID}")
	public ArrayList<Courses> updateCourse(@PathVariable("courseID") Integer id, 
										@RequestBody Courses newCourse, 
										HttpSession session){
		Faculty user = (Faculty)session.getAttribute("currentUser");
		return user.updateCourse(id, newCourse);
	}
	
	@DeleteMapping("/api/courses/{courseID}")
	public ArrayList<Courses> deleteCourse(@PathVariable("courseID") Integer id, 
											HttpSession session){
		Faculty user = (Faculty)session.getAttribute("currentUser");
		return user.deleteCourse(id);
	}
}
