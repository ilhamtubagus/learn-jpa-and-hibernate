package org.github.com.ilhamtubagus.learnjpaandhibernate.course;

import org.github.com.ilhamtubagus.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import org.github.com.ilhamtubagus.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import org.github.com.ilhamtubagus.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// CommandLineRunner - Auto run on startup
@Component // Mark as custom beans
public class CourseCommandLineRunner implements CommandLineRunner {
//    @Autowired
//    private CourseJdbcRepository repository;

//    @Autowired
//    private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
//        Spring jpa and jdbc methods
//        this.repository.insert(new Course(1, "Learn AWS", "Ilham"));
//        this.repository.insert(new Course(2, "Learn GCP", "Ilham"));
//        this.repository.insert(new Course(3, "Learn Java", "Ilham"));

        this.repository.save(new Course(1, "Learn AWS", "Ilham"));
        this.repository.save(new Course(2, "Learn GCP", "Ilham"));
        this.repository.save(new Course(3, "Learn Java", "Ilham"));

        this.repository.deleteById(2L);

        System.out.println(this.repository.findById(1L));
        System.out.println(this.repository.findById(3L));
    }
}
