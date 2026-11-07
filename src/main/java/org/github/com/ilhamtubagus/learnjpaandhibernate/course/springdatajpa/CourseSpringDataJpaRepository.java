package org.github.com.ilhamtubagus.learnjpaandhibernate.course.springdatajpa;

import org.github.com.ilhamtubagus.learnjpaandhibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {
}
