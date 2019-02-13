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
import com.example.webdvsp19serverjava.models.Modules;

@RestController
public class ModuleService {
	
	@PostMapping("/api/courses/{cid}/modules")
	public ArrayList<Modules> createModule(@PathVariable("cid") Integer id,
											@RequestBody Modules module,
											HttpSession session){
		Faculty user = (Faculty)session.getAttribute("currentUser");
		Courses course = user.findCourseById(id);
		return course.createModule(module);
	}
	
	@GetMapping("/api/course/{cid}/modules")
	public ArrayList<Modules> findAllModules(@PathVariable("cid") Integer id, 
											HttpSession session){
		Faculty user = (Faculty)session.getAttribute("currentUser");
		Courses course = user.findCourseById(id);
		return course.findAllModules();
	}
	
	@GetMapping("/api/modules/{cid}/{mid}")
	public Modules findModuleById(@PathVariable("cid") Integer cid, 
									@PathVariable("mid") Integer mid, 
									HttpSession session){
		Faculty user = (Faculty)session.getAttribute("currentUser");
		Courses course = user.findCourseById(cid);
		return course.findModuleById(mid);
	}
	
	@PutMapping("/api/modules/{cid}/{mid}")
	public ArrayList<Modules> updateModule(@PathVariable("cid") Integer cid, 
									@PathVariable("mid") Integer mid, 
									@RequestBody Modules module,
									HttpSession session){
		Faculty user = (Faculty)session.getAttribute("currentUser");
		Courses course = user.findCourseById(cid);
		return course.updateModule(mid, module);
	}
	
	@DeleteMapping("/api/courses/{cid}/{mid}")
	public ArrayList<Modules> deleteCourse(@PathVariable("cid") Integer cid, 
											@PathVariable("mid") Integer mid,
											HttpSession session){
		Faculty user = (Faculty)session.getAttribute("currentUser");
		Courses course = user.findCourseById(cid);
		return course.deleteModule(mid);
	}
}
