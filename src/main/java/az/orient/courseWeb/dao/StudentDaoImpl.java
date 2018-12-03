package az.orient.courseWeb.dao;

import az.orient.courseWeb.model.Student;
import az.orient.courseWeb.webservices.CourseWebServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    @Autowired
    private DataSource dataSource;

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(StudentDaoImpl.class);

    @Override
    public List<Student> getStudentList() throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        List<Student> studentList = null;
        jdbcTemplate.setDataSource(dataSource);
        String sql = "SELECT s.*, t.id_teacher, t.name teacherName, t.surname teacherSurname FROM student s \n" +
                "JOIN teacher t ON s.teacher_id = t.id_teacher WHERE s.active = 1";
        try {
            studentList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Student.class));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return studentList;
    }

    @Override
    public boolean addStudent(Student st) throws Exception {
        boolean res = false;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "INSERT INTO student(name, surname, address, dob, teacher_id) VALUES(?, ?, ?, ?, ?)";
        try {
            jdbcTemplate.update(sql, new Object[] {st.getName(), st.getSurname(), st.getAddress(), st.getDob(), st.getTeacher().getId_teacher()});
            res = true;
        } catch (Exception ex) {
            ex.printStackTrace();
            res = false;
        }
        return res;
    }

    @Override
    public Student getStudentById(long studentId) throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Student st = null;
        String sql = "SELECT s.*, t.id_teacher, t.name teacherName, t.surname teacherSurname FROM student s \n" +
                "JOIN teacher t ON s.teacher_id = t.id_teacher WHERE s.active = 1 and s.id_student = ?";
        try {
            st = (Student) jdbcTemplate.queryForObject(sql, new Object[] {studentId}, new BeanPropertyRowMapper(Student.class));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return st;
    }

    @Override
    public boolean deleteStudent(long stId) throws Exception {
        boolean res = false;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "UPDATE student SET active = 0 WHERE id_student = ?";
        try {
            jdbcTemplate.update(sql, new Object[] {stId});
            res = true;
        } catch (Exception ex) {
            ex.printStackTrace();
            res = false;
        }
        return res;
    }

    @Override
    public boolean updateStudent(Student st, long stId) throws Exception {
        boolean res = false;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "UPDATE student SET name = ?, surname = ?, address = ?, dob = ?, teacher_id = ? WHERE active = 1 AND id_student = ?";
        try {
            jdbcTemplate.update(sql, new Object[] {st.getName(), st.getSurname(), st.getAddress(), st.getDob(), st.getTeacher().getId_teacher(), stId});
            res = true;
        } catch (Exception ex) {
            ex.printStackTrace();
            res = false;
        }
        return res;
    }
}
