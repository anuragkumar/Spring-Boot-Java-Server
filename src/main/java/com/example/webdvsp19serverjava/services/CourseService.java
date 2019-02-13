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

import com.example.webdvsp19serverjava.models.Courses;
import com.example.webdvsp19serverjava.models.Faculty;

@RestController
public class CourseService {
	
	@PostMapping("/api/courses")
	public Courses createCourse(@RequestBody Courses course, HttpSession session) {
		Faculty user = (Faculty)session.getAttribute("currentUser");
		user.addCourse(course);
		return course;
	}
	
	@GetMapping("/api/courses")
	public ArrayList<Courses> findAllCourses(HttpSession session) {
		Faculty user = (Faculty)session.getAttribute("currentUser");
		return user.findAllCourses();
	}
	
	@GetMapping("/api/courses/{courseID}")
	public Courses findUserById(@PathVariable("courseID") Integer id, HttpSession session) {
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
