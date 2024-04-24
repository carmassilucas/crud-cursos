package br.com.ignite.rocketseat.crudcursos.module.course.useCase;

import br.com.ignite.rocketseat.crudcursos.module.course.dto.UpdateCourseRequestDto;
import br.com.ignite.rocketseat.crudcursos.module.course.entity.CourseEntity;
import br.com.ignite.rocketseat.crudcursos.module.course.exception.CourseNotFoundException;
import br.com.ignite.rocketseat.crudcursos.module.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.UUID;

@Service
public class UpdateCourseUseCase {
    @Autowired
    private CourseRepository repository;

    public CourseEntity execute(UUID id, UpdateCourseRequestDto dto) {
        var course = this.repository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException("Curso não encontrado"));

        var updatedCourse = copyNonNullProperties(course, dto);

        return this.repository.saveAndFlush(updatedCourse);
    }

    private CourseEntity copyNonNullProperties(CourseEntity course, UpdateCourseRequestDto dto) {
        Arrays.stream(UpdateCourseRequestDto.class.getDeclaredFields()).forEach(field -> {
            field.setAccessible(true);

            try {
                Object value = field.get(dto);

                if (value != null && !value.toString().trim().isEmpty()) {
                    Field courseField = CourseEntity.class.getDeclaredField(field.getName());
                    courseField.setAccessible(true);
                    courseField.set(course, value);
                }
            } catch (IllegalAccessException | NoSuchFieldException e) {
                throw new RuntimeException(e);
            }
        });

        return course;
    }

}
