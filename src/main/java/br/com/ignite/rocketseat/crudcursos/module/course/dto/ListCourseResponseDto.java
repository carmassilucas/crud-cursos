package br.com.ignite.rocketseat.crudcursos.module.course.dto;

import br.com.ignite.rocketseat.crudcursos.module.course.enumeration.Active;

import java.util.UUID;

public record ListCourseResponseDto(
        UUID id,
        String name,
        String category,
        Active active
) {
}
