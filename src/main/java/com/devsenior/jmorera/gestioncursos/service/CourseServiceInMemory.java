package com.devsenior.jmorera.gestioncursos.service;

import java.util.ArrayList;
import java.util.List;

import com.devsenior.jmorera.gestioncursos.exception.CourseNotFoundException;
import com.devsenior.jmorera.gestioncursos.model.Course;

public class CourseServiceInMemory implements CourseService {


    private List<Course> courses;

    public CourseServiceInMemory(){
        courses = new ArrayList<>();
    }

    @Override
    public List<Course> getAll() {
       return new ArrayList<Course>(courses);
    }

    @Override
    public Course getOneById(Long id) {
        if(id== null){
            throw new IllegalArgumentException("El Id está vacio");
        }
        if(id< 0){
            throw new IllegalArgumentException("El id no puede ser negativo");
        }

        return courses.stream()
                .filter(c->c.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new CourseNotFoundException(
                    String.format("EL curso con id '%d' no existe" , id)
                ))
               ;
    }

    @Override
    public List<Course> getAllThatContainName(String partialName) {
       if(partialName == null || partialName.isBlank()){
        return getAll();
       }
       return courses.stream()
                .filter(c -> c.getName().contains(partialName) || c.getDescrition().contains(partialName))
                .toList();        
    }

    @Override
    public Course create(Course course) {

        if(course == null){

            throw new IllegalArgumentException("No fue enviado un curso ");
        }
        if(course.getName() == null || course.getName().isBlank()){
            throw new IllegalArgumentException ("EL nombre del curso es obligatorio");
        }

        if(course.getCredits() <=0 ){
            throw new IllegalArgumentException("Los creditos del curso deben ser mayores a cero");

        }
        if(course.getInitalDate().isAfter(course.getFinalDate())){

            throw new IllegalArgumentException("La fecha de inicio deber ser anterior a la fecha final");
        }
       courses.add(course);
       return course;
    }

    @Override
    public Course update(Long id, Course course) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    private void boolean validateId(Long id){
         if(id== null){
            throw new IllegalArgumentException("El Id está vacio");
        }
        if(id< 0){
            throw new IllegalArgumentException("El id no puede ser negativo");
        }

    }
    


}
