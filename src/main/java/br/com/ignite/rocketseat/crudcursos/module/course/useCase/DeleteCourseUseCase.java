package br.com.ignite.rocketseat.crudcursos.module.course.useCase;

import br.com.ignite.rocketseat.crudcursos.module.course.exception.CourseNotFoundException;
import br.com.ignite.rocketseat.crudcursos.module.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteCourseUseCase {
    @Autowired
    private CourseRepository repository;

    public void execute(UUID id) {
        var course = this.repository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException("Curso não encontrado"));

        this.repository.delete(course);
    }
}
