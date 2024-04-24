package br.com.ignite.rocketseat.crudcursos.module.course.useCase;

import br.com.ignite.rocketseat.crudcursos.module.course.entity.CourseEntity;
import br.com.ignite.rocketseat.crudcursos.module.course.exception.CourseNotFoundException;
import br.com.ignite.rocketseat.crudcursos.module.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ActiveCourseUseCase {
    @Autowired
    private CourseRepository repository;

    public CourseEntity execute(UUID id) {
        var course = this.repository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException("Curso não encontrado"));

        course.setActive(!course.getActive());

        return this.repository.saveAndFlush(course);
    }
}
