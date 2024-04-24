package br.com.ignite.rocketseat.crudcursos.module.course.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateCourseRequestDto(
        @NotBlank(message = "Campo name deve estar preenchido ao cadastrar um curso")
        String name,

        @NotBlank(message = "Campo category deve estar preenchido ao cadastrar um curso")
        String category
) {
}
