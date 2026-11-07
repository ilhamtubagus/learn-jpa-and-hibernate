package org.github.com.ilhamtubagus.learnjpaandhibernate.course.springdatajpa;

import org.github.com.ilhamtubagus.learnjpaandhibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {
    // Custom method, "Author" match the attribute "author"
    List<Course> findByAuthor(String author);

    List<Course> findByName(String name);
}
