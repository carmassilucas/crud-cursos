package br.com.ignite.rocketseat.crudcursos.module.course.useCase;

import br.com.ignite.rocketseat.crudcursos.module.course.dto.ListCourseRequestDto;
import br.com.ignite.rocketseat.crudcursos.module.course.entity.CourseEntity;
import br.com.ignite.rocketseat.crudcursos.module.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListCourseUseCase {
    @Autowired
    private CourseRepository repository;

    public List<CourseEntity> execute(ListCourseRequestDto dto) {
        return this.repository.findByNameAndCategory(dto.name(), dto.category());
    }
}
