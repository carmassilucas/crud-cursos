package br.com.ignite.rocketseat.crudcursos.module.course.exception;

public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException(String message) {
        super(message);
    }
}
