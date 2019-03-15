package com.example.webdvsp19serverjava.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Courses {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String courseName;
	@OneToMany(mappedBy = "course")
	private List<Modules> modules = new ArrayList<Modules>();
	
	@ManyToOne
    @JsonIgnore
    private Faculty author;

    public Faculty getAuthor() {
        return author;
    }

    public void setAuthor(Faculty author) {
        this.author = author;
    }
	
	public Courses(int id, String courseName) {
		super();
		this.id = id;
		this.courseName = courseName;
	}
	
	public Courses() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public List<Modules> getModules() {
		return modules;
	}
	public void setModules(List<Modules> modules) {
		this.modules = modules;
	}
	
	public List<Modules> createModule(Modules module){
		Random ran = new Random();
		module.setId(ran.nextInt(100));
		this.modules.add(module);
		return this.modules;
	}
	
	public List<Modules> findAllModules(){
		return this.modules;
	}
	
	public Modules findModuleById(Integer id){
		for(Modules module: this.modules) {
			if(module.getId() == id) {
				return module;
			}
		}
		return null;
	}
	
	public List<Modules> updateModule(Integer id, Modules module){
		for(Modules mod: this.modules) {
			if(mod.getId() == id) {
				mod.setModuleName(module.getModuleName());
				return this.modules;
			}
		}
		return null;
	}
	
	public List<Modules> deleteModule(Integer id){
		for(Modules mod: this.modules) {
			if(mod.getId() == id) {
				this.modules.remove(mod);
				return this.modules;
			}
		}
		return null;
	}
	
}
