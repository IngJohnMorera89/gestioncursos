package com.devsenior.jmorera.gestioncursos.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.jmorera.gestioncursos.model.Course;
import com.devsenior.jmorera.gestioncursos.service.CourseService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

//DRY  -   Don´t Repeat Yourself
@Tag(name = "Cursos", description = "Api para la gestión de cursos académicos")
@RestController
@RequestMapping("/api/cursos")

public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @Operation(summary = "Listar Todos los cursos", description = "Retorna la información de los cursos habilitados en  el sistema")
    @ApiResponse(responseCode = "200", description = "Listado de cursos encontrados de manera existosa")
    @ApiResponse(responseCode = "205", description = "No hay cursos disponibles actualmente", content = @Content())
    @ApiResponse(responseCode = "404", description = "No hay cursos", content = @Content())
    @GetMapping()
    public List<Course> getAllCourses() {
        return courseService.getAll();
    }

    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    @Operation(summary = "Buscar un curso por Id", description = "Consulta la información del curso con Id dado")
    @ApiResponse(responseCode = "200", description = "Curso encontrado exitosamente", content = @Content)
    @ApiResponse(responseCode = "500", description = "El curso no fue encontrado", content = @Content)

    public Course getCourseById(@PathVariable Long id) {
        return courseService.getOneById(id);
    }

    @GetMapping("/buscar")
    public List<Course> getCourseContainsText(@RequestParam("nombre") String name) {
        return courseService.getAllThatContainName(name);
    }

    @Operation(summary = "Crear un nuevo curso")
    @PostMapping()
    public Course CreateCourse(
            @RequestBody(description = "Datos del nuevo curso a crear", required = true, content = @Content(schema = @Schema(implementation = Course.class))) Course course) {
        return courseService.create(course);
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course course) {

        return courseService.update(id, course);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.delete(id);
    }

}
