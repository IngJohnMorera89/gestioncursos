package com.devsenior.jmorera.gestioncursos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.jmorera.gestioncursos.model.Course;
import com.devsenior.jmorera.gestioncursos.service.CourseService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



//DRY  -   Don´t Repeat Yourself
 @RestController
 @RequestMapping("/api/cursos")

public class CourseController {

    private CourseService courseService;

    
    

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/api/cursos")
    public List<Course> getAllCourses() {
        return courseService.getAll();
    }

    @GetMapping("/{id}")
    public Course getCourseById (@PathVariable Long id) {
        return courseService.getOneById(id);
    }

    @GetMapping("/buscar")
    public List <Course> getCourseContainsName(@RequestParam ("nombre")String nameString) {
        return courseService.getAllThatContainName(nameString);
    }
    @PostMapping("path")
    public Course  CreateCourse(@RequestBody Course course) {
        //TODO: process POST request
        
        return courseService.create(course);
    }
    @PutMapping("path/{id}")
    public String updateCourse(@PathVariable Long  id,@RequestBody Course course) {
        //TODO: process PUT request
        
        return courseService.update(course);
    }
    //@DeleteMapping() TErminar


    
    
    
    
    
   
}
