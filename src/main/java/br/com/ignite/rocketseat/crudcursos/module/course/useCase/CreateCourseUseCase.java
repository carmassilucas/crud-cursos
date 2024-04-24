package br.com.ignite.rocketseat.crudcursos.module.course.useCase;

import br.com.ignite.rocketseat.crudcursos.module.course.dto.CreateCourseRequestDto;
import br.com.ignite.rocketseat.crudcursos.module.course.entity.CourseEntity;
import br.com.ignite.rocketseat.crudcursos.module.course.repository.CourseRepository;
import br.com.ignite.rocketseat.crudcursos.module.course.enumeration.Active;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCourseUseCase {
    @Autowired
    private CourseRepository repository;

    public CourseEntity execute(CreateCourseRequestDto dto) {
        var course = CourseEntity.builder()
                .name(dto.name())
                .category(dto.category())
                .active(Active.active)
                .build();

        return this.repository.save(course);
    }
}
