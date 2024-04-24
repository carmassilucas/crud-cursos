package br.com.ignite.rocketseat.crudcursos.module.course.controller;

import br.com.ignite.rocketseat.crudcursos.module.course.dto.CreateCourseRequestDto;
import br.com.ignite.rocketseat.crudcursos.module.course.useCase.CreateCourseUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CreateCourseUseCase createCourseUseCase;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody CreateCourseRequestDto dto) {
        var course = this.createCourseUseCase.execute(dto);
        return ResponseEntity.ok().body(course);
    }
}
