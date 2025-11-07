package com.devsenior.jmorera.gestioncursos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.devsenior.jmorera.gestioncursos.exception.CourseNotFoundException;
import com.devsenior.jmorera.gestioncursos.model.Course;


@Service
public class CourseServiceInMemory implements CourseService {

    private AtomicLong consecutive;
    private List<Course> courses;

    public CourseServiceInMemory(){
        courses = new ArrayList<>();
        consecutive = new AtomicLong(1);


    }

    @Override
    public List<Course> getAll() {
       //return new ArrayList<Course>(courses);
       return courses.stream().toList();
    }

    @Override
    // Obtener por Id
    public Course getOneById(Long id) {
      validateId(id);

        return courses.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new CourseNotFoundException(
                    String.format("EL curso con id '%d' no existe" , id)));
               
    }

    @Override
    public List<Course> getAllThatContainName(String partialName) {
       if(isBlank(partialName)){
        return getAll();
       }
       return courses.stream()
                .filter(c -> c.getName().contains(partialName) 
                        || c.getDescrition().contains(partialName))
                .toList();        
    }

    @Override
    public Course create(Course course) {

        validateCourse(course);

        //generamos el id
        course.setId(consecutive.getAndIncrement());

        //Agregar curso a la lista
        courses.add(course);
        return course;
    }

    @Override
    public Course update(Long id, Course course) {
       
        validateId(id);
        validateCourse(course);

        var existingCourse = getOneById(id);
        existingCourse.setName(course.getName());
        existingCourse.setCode(course.getCode());
        existingCourse.setDescrition(course.getDescrition());
        existingCourse.setInitalDate(course.getInitalDate());
        existingCourse.setFinalDate(course.getFinalDate());
        existingCourse.setCredits(course.getCredits());

        return existingCourse;

    }


    @Override
    public void delete(Long id) {
       validateId(id);

        var existingCourse = getOneById(id);

        courses.remove(existingCourse);
    }

    private boolean isBlank (String data){
        return data == null || data.isBlank();

    }

     private void validateId(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El Id está vacio");
        }
        if (id < 0) {
            throw new IllegalArgumentException("El Id no puede ser negativo");
        }
    }

    private void validateCourse(Course course){ 
        if (course == null) {
            throw new IllegalArgumentException("No fue enviado un curso a guardar.");
        }
        if (isBlank(course.getName())) {
            throw new IllegalArgumentException("El nombre del curso es obligatorio.");
        }
        if (course.getCredits() <= 0) {
            throw new IllegalArgumentException("Los créditos del curso deben ser mayores a 0.");
        }
        if (course.getInitalDate().isAfter(course.getFinalDate())) {
            throw new IllegalArgumentException("La fecha inicio debe ser anterior a la fecha final.");
        }
        // ...
    }
    

}



