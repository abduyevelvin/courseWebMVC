package az.orient.courseWeb.dao;

import az.orient.courseWeb.model.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class ScheduleDaoImpl implements ScheduleDao {

    @Autowired
    private DataSource dataSource;

    @Override
    public List<Schedule> getScheduleList() throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<Schedule> scheduleList = null;
        String sql = "SELECT s.id_schedule, st.name studentName, st.surname studentSurname, t.name teacherName, t.surname teacherSurname, l.lesson_name FROM schedule s \n" +
                    "JOIN student st ON s.student_id = st.id_student JOIN teacher t ON s.teacher_id = t.id_teacher \n" +
                    "JOIN lesson l ON s.lesson_id = l.id_lesson WHERE s.active = 1";
        try {
            scheduleList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Schedule.class));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return scheduleList;
    }
}
