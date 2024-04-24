package br.com.ignite.rocketseat.crudcursos.module.course.controller;

import br.com.ignite.rocketseat.crudcursos.module.course.dto.CreateCourseRequestDto;
import br.com.ignite.rocketseat.crudcursos.module.course.dto.ListCourseRequestDto;
import br.com.ignite.rocketseat.crudcursos.module.course.dto.UpdateCourseRequestDto;
import br.com.ignite.rocketseat.crudcursos.module.course.useCase.CreateCourseUseCase;
import br.com.ignite.rocketseat.crudcursos.module.course.useCase.DeleteCourseUseCase;
import br.com.ignite.rocketseat.crudcursos.module.course.useCase.ListCourseUseCase;
import br.com.ignite.rocketseat.crudcursos.module.course.useCase.UpdateCourseUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CreateCourseUseCase createCourseUseCase;

    @Autowired
    private ListCourseUseCase listCourseUseCase;

    @Autowired
    private UpdateCourseUseCase updateCourseUseCase;

    @Autowired
    private DeleteCourseUseCase deleteCourseUseCase;

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

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable UUID id, @RequestBody UpdateCourseRequestDto dto) {
        try {
            var course = this.updateCourseUseCase.execute(id, dto);
            return ResponseEntity.ok().body(course);
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id) {
        try {
            this.deleteCourseUseCase.execute(id);
            return ResponseEntity.ok().build();
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

}
