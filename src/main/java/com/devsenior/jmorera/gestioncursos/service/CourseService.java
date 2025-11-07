package com.devsenior.jmorera.gestioncursos.service;

import java.util.List;

import com.devsenior.jmorera.gestioncursos.model.Course;

public interface CourseService {

    List<Course> getAll();
    Course getOneById(Long id);
    List<Course> getAllThatContainName(String partialName);
    Course create(Course course);
    Course update(Long id, Course course);
    void delete (Long id);


}
