package az.orient.courseWeb.dao;

import az.orient.courseWeb.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class TeacherDaoImpl implements TeacherDao {

    @Autowired
    private DataSource dataSource;

    @Override
    public List<Teacher> getTeacherList() throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<Teacher> teacherList = null;
        String sql = "SELECT * FROM teacher WHERE active = 1";
        try {
            teacherList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Teacher.class));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return teacherList;
    }

    @Override
    public Teacher getTeacherById(long teacherId) throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Teacher tc = null;
        String sql = "SELECT * FROM teacher WHERE active = 1 AND id_teacher = ?";
        try {
            tc = (Teacher) jdbcTemplate.queryForObject(sql, new Object[] {teacherId}, new BeanPropertyRowMapper(Teacher.class));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return tc;
    }

    @Override
    public boolean deleteTeacher(long tcId) throws Exception {
        boolean res = false;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "UPDATE teacher SET active = 0 WHERE id_teacher = ?";
        try {
            jdbcTemplate.update(sql, new Object[] {tcId});
            res = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return res;
    }

    @Override
    public boolean updateTeacher(Teacher tc, long tcId) throws Exception {
        boolean res = false;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "UPDATE teacher SET name = ?, surname = ?, address = ?, dob = ? WHERE active = 1 AND id_teacher = ?";
        try {
            jdbcTemplate.update(sql, new Object[] {tc.getName(), tc.getSurname(), tc.getAddress(), tc.getDob(), tcId});
            res = true;
        } catch (Exception ex) {
            ex.printStackTrace();
            res = false;
        }

        return res;
    }

    @Override
    public boolean addTeacher(Teacher tc) throws Exception {
        boolean res = false;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "INSERT INTO teacher (name, surname, address, dob) VALUES(?, ?, ?, ?)";
        try {
            jdbcTemplate.update(sql, new Object[] {tc.getName(), tc.getSurname(), tc.getAddress(), tc.getDob()});
            res = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return res;
    }
}
