package com.example.webdvsp19serverjava.services;

import java.util.ArrayList;
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

import com.example.webdvsp19serverjava.models.Courses;
import com.example.webdvsp19serverjava.models.Faculty;
import com.example.webdvsp19serverjava.repositories.CourseRepository;
import com.example.webdvsp19serverjava.repositories.FacultyRepository;

@RestController
@CrossOrigin(origins = "*", allowCredentials ="true", allowedHeaders = "*")
public class CourseService {
	private List<Courses> courses = new ArrayList<>();

    @Autowired
    FacultyRepository userRepository;
    @Autowired
    CourseRepository courseRepository;
	
	@PostMapping("/api/courses")
    public List<Courses> createCourse(@RequestBody Courses newCourse, 
    										HttpSession session) {
        Faculty currentUser = (Faculty) session.getAttribute("currentUser");
        currentUser = userRepository.findById(currentUser.getId()).get();
        
        this.courses = currentUser.getCourses();
        this.courses.add(newCourse);
        currentUser.setCourses(this.courses);
        newCourse.setAuthor(currentUser);
        courseRepository.save(newCourse);
        currentUser = userRepository.findById(currentUser.getId()).get();
        return currentUser.getCourses();
    }
	
	@GetMapping("/api/courses")
    public List<Courses> findAllCourses(HttpSession session) {
        Faculty currentUser = (Faculty) session.getAttribute("currentUser");
        currentUser = userRepository.findById(currentUser.getId()).get();
        return currentUser.getCourses();
    }
	
	@GetMapping("/api/courses/{cid}")
    public Courses findCourseById(@PathVariable("cid") int cid, HttpSession session) {
        Faculty currentUser = (Faculty) session.getAttribute("currentUser");
        currentUser = userRepository.findById(currentUser.getId()).get();
        this.courses = currentUser.getCourses();

        for(Courses course : this.courses) {
            if(course.getId() == cid) {
                return course;
            }
        }
        return null;
    }
	
	@PutMapping("/api/courses/{cid}")
    public Courses updateCourse(@PathVariable("cid") int cid,
            					@RequestBody Courses updatedCourse,
            					HttpSession session) {
        Faculty currentUser = (Faculty) session.getAttribute("currentUser");
        currentUser = userRepository.findById(currentUser.getId()).get();
        this.courses = currentUser.getCourses();

        for(Courses course : this.courses) {
            if(course.getId() == cid) {
                course.setCourseName(updatedCourse.getCourseName());
                userRepository.save(currentUser);
                return course;
            }
        }
        return null;
    }
	
	@DeleteMapping("/api/courses/{cid}")
    public List<Courses> deleteCourse (@PathVariable("cid") int cid, 
    											HttpSession session) {
        Faculty currentUser = (Faculty)session.getAttribute("currentUser");
        currentUser = userRepository.findById(currentUser.getId()).get();
        this.courses = currentUser.getCourses();
        for(int i=0; i < this.courses.size(); i++) {
            if(this.courses.get(i).getId() == cid) {
                courseRepository.delete(this.courses.get(i));
                this.courses.remove(i);
                return this.courses;
            }
        }

        return this.courses;
    }
}
