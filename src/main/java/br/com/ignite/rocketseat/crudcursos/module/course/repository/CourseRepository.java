package br.com.ignite.rocketseat.crudcursos.module.course.repository;

import br.com.ignite.rocketseat.crudcursos.module.course.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CourseRepository extends JpaRepository<CourseEntity, UUID> {
}
