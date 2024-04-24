package br.com.ignite.rocketseat.crudcursos.module.course.useCase;

import br.com.ignite.rocketseat.crudcursos.module.course.dto.ListCourseRequestDto;
import br.com.ignite.rocketseat.crudcursos.module.course.dto.ListCourseResponseDto;
import br.com.ignite.rocketseat.crudcursos.module.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListCourseUseCase {
    @Autowired
    private CourseRepository repository;

    public List<ListCourseResponseDto> execute(ListCourseRequestDto dto) {
        var courses = this.repository.findByNameAndCategory(dto.name(), dto.category());

        return courses.stream().map(course -> new ListCourseResponseDto(
                course.getId(),
                course.getName(),
                course.getCategory(),
                course.getActive()
        )).toList();
    }
}
