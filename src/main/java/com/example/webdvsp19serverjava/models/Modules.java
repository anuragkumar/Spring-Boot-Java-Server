package com.example.webdvsp19serverjava.models;

import java.util.ArrayList;

public class Modules {
	private Integer id;
	private String moduleName;
	private ArrayList<Chapters> chapters = new ArrayList<Chapters>();
	public Modules(Integer id, String moduleName) {
		super();
		this.id = id;
		this.moduleName = moduleName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public ArrayList<Chapters> getChapters() {
		return chapters;
	}
	public void setChapters(ArrayList<Chapters> chapters) {
		this.chapters = chapters;
	}
	public ArrayList<Chapters> createLesson(Chapters chapter) {
		this.chapters.add(chapter);
		return this.chapters;
	}
	public ArrayList<Chapters> findAllLessons() {
		return this.chapters;
	}
	public Chapters findLessonById(Integer lid) {
		for(Chapters chapter: this.chapters) {
			if(chapter.getId() == lid) {
				return chapter;
			}
		}
		return null;
	}
	public ArrayList<Chapters> updateLesson(Integer lid, Chapters chapter) {
		for(Chapters chap: this.chapters) {
			if(chap.getId() == lid) {
				chap.setChapterName(chapter.getChapterName());
				return this.chapters;
			}
		}
		return null;
	}
	public ArrayList<Chapters> deleteLesson(Integer lid) {
		for(Chapters chapter: this.chapters) {
			if(chapter.getId() == lid) {
				this.chapters.remove(chapter);
				return this.chapters;
			}
		}
		return null;
	}
}
