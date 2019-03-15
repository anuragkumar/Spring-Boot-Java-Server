package com.example.webdvsp19serverjava.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.webdvsp19serverjava.models.Chapters;

public interface LessonRepository extends CrudRepository<Chapters, Integer> {

}
