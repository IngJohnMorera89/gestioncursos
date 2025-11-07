package com.devsenior.jmorera.gestioncursos.exception;

public class CourseNotFoundException extends  RuntimeException {
    public CourseNotFoundException(String message) {
        super(message);
    }
}
