package com.example.webdvsp19serverjava.models;

import java.util.ArrayList;

public class Faculty extends Person {
	public Faculty(int id, String username, String password, String firstName, String lastName){
		super(id, username, password, firstName, lastName);
		courses = new ArrayList<Courses>();
		sections = new ArrayList<Sections>();
	}
	
	ArrayList<Courses> courses;
	ArrayList<Sections> sections;
	
	public ArrayList<Courses> getCourses() {
		return courses;
	}
	public void setCourses(ArrayList<Courses> courses) {
		this.courses = courses;
	}
	
	public ArrayList<Courses> addCourse(Courses course) {
		this.courses.add(course);
		return this.courses;
	}
	
	public ArrayList<Courses> findAllCourses(){
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
	
	public ArrayList<Courses> updateCourse(Integer id, Courses course){
		for(Courses cour: this.courses) {
			if(cour.getId() == id) {
				cour.setCourseName(course.getCourseName());
				return this.courses;
			}
		}
		return null;
	}
	
	public ArrayList<Courses> deleteCourse(Integer id){
		for(Courses course: this.courses) {
			if(course.getId() == id) {
				this.courses.remove(course);
				return this.courses;
			}
		}
		return null;
	}

}
