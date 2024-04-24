package br.com.ignite.rocketseat.crudcursos.module.course.dto;

import java.util.UUID;

public record ListCourseResponseDto(
        UUID id,
        String name,
        String category,
        Boolean active
) {
}
