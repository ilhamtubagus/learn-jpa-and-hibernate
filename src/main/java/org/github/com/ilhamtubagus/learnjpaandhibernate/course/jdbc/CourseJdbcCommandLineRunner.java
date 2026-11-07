package org.github.com.ilhamtubagus.learnjpaandhibernate.course.jdbc;

import org.github.com.ilhamtubagus.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// CommandLineRunner - Auto run on startup
@Component // Mark as custom beans
public class CourseJdbcCommandLineRunner implements CommandLineRunner {
    private CourseJdbcRepository repository;

    public CourseJdbcCommandLineRunner(CourseJdbcRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        Course course = new Course(1, "Learn AWS", "Ilham");
        this.repository.insert(course);

        Course course2 = new Course(2, "Learn GCP", "Ilham");
        this.repository.insert(course2);

        this.repository.delete(2L);
    }
}
