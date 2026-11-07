package org.github.com.ilhamtubagus.learnjpaandhibernate.course.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.github.com.ilhamtubagus.learnjpaandhibernate.course.Course;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJpaRepository {
    @PersistenceContext // recommended instead of @Autowired
    private EntityManager entityManager; // manage entity

    public void insert(Course course) {
        entityManager.merge(course);
    }

    public Course findById(Long id) {
        return entityManager.find(Course.class, id);
    }

    public void deleteById(Long id) {
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }
}
