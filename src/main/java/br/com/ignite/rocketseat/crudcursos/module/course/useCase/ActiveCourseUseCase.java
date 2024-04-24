package br.com.ignite.rocketseat.crudcursos.module.course.useCase;

import br.com.ignite.rocketseat.crudcursos.module.course.entity.CourseEntity;
import br.com.ignite.rocketseat.crudcursos.module.course.exception.CourseNotFoundException;
import br.com.ignite.rocketseat.crudcursos.module.course.repository.CourseRepository;
import br.com.ignite.rocketseat.crudcursos.module.course.enumeration.Active;
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

        var updatedActive = !course.getActive().getState();

        course.setActive(Active.fromBoolean(updatedActive));

        return this.repository.saveAndFlush(course);
    }
}
