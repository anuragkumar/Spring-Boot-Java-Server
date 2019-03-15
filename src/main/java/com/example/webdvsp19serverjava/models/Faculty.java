package com.example.webdvsp19serverjava.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Faculty {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    
    @OneToMany(mappedBy = "author")
    private List<Courses> courses;

    public Faculty() {}
    
    public Faculty(int id, String username, String password, String firstName, String lastName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
	
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public List<Courses> getCourses() {
		return courses;
	}
	public void setCourses(List<Courses> courses2) {
		this.courses = courses2;
	}
	
	public List<Courses> addCourse(Courses course) {
		this.courses.add(course);
		return this.courses;
	}
	
	public List<Courses> findAllCourses(){
		return this.courses;
	}
	
	public Courses findCourseById(Integer id) {
		for(Courses course: this.courses) {
			if(course.getId() == id) {
				return course;
			}
		}
		return null;
	}
	
	public List<Courses> updateCourse(Integer id, Courses course){
		for(Courses cour: this.courses) {
			if(cour.getId() == id) {
				cour.setCourseName(course.getCourseName());
				return this.courses;
			}
		}
		return null;
	}
	
	public List<Courses> deleteCourse(Integer id){
		for(Courses course: this.courses) {
			if(course.getId() == id) {
				this.courses.remove(course);
				return this.courses;
			}
		}
		return null;
	}

}
