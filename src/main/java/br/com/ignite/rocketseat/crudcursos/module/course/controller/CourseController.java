package br.com.ignite.rocketseat.crudcursos.module.course.controller;

import br.com.ignite.rocketseat.crudcursos.module.course.dto.CreateCourseRequestDto;
import br.com.ignite.rocketseat.crudcursos.module.course.dto.ListCourseRequestDto;
import br.com.ignite.rocketseat.crudcursos.module.course.useCase.CreateCourseUseCase;
import br.com.ignite.rocketseat.crudcursos.module.course.useCase.ListCourseUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CreateCourseUseCase createCourseUseCase;

    @Autowired
    private ListCourseUseCase listCourseUseCase;

    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody CreateCourseRequestDto dto) {
        var course = this.createCourseUseCase.execute(dto);
        return ResponseEntity.ok().body(course);
    }

    @GetMapping
    public ResponseEntity<Object> get(ListCourseRequestDto dto) {
        var courses = this.listCourseUseCase.execute(dto);
        return ResponseEntity.ok().body(courses);
    }
}
