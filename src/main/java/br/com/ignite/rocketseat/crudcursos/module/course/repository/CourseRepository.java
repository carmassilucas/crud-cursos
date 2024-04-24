package br.com.ignite.rocketseat.crudcursos.module.course.repository;

import br.com.ignite.rocketseat.crudcursos.module.course.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface CourseRepository extends JpaRepository<CourseEntity, UUID> {
    @Query(
            "select ce " +
            "from course ce " +
            "where (:name is null or ce.name ilike %:name%) " +
            "and (:category is null or ce.category ilike %:category%)"
    )
    List<CourseEntity> findByNameAndCategory(@Param("name") String name, @Param("category") String category);

}
