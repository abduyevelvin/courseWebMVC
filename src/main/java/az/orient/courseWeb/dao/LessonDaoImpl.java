package az.orient.courseWeb.dao;

import az.orient.courseWeb.model.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class LessonDaoImpl implements LessonDao {

    @Autowired
    private DataSource dataSource;

    @Override
    public List<Lesson> getLessonList() throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<Lesson> lessonList = null;
        String sql = "SELECT * FROM lesson WHERE active = 1";
        try {
            lessonList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Lesson.class));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return lessonList;
    }
}
