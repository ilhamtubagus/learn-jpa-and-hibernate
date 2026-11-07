package org.github.com.ilhamtubagus.learnjpaandhibernate.course.jdbc;

import org.github.com.ilhamtubagus.learnjpaandhibernate.course.Course;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

// Spring jdbc

@Repository
public class CourseJdbcRepository {
    private final JdbcTemplate jdbcTemplate;

    public CourseJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String INSERT_QUERY =
            """
                 insert into course (id, name, author)
                 values (?, ?, ?)
            """;

    private static final String DELETE_QUERY =
            """
                    delete from course where id = ?;
                    """;

    private static final String SELECT_QUERY =
            """
                    select * from course where id = ?;
                    """;
    public void insert(Course course){
        this.jdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void delete(Long id){
        this.jdbcTemplate.update(DELETE_QUERY, id);
    }

    public Course findById(Long id){
        // ResultSet -> Bean -> Row mapper

        return this.jdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
    }
}
