package com.example.webdvsp19serverjava.repositories;

import com.example.webdvsp19serverjava.models.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Courses, Integer> {

}
