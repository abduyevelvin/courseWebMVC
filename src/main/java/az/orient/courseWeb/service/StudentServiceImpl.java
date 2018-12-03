package az.orient.courseWeb.service;

import az.orient.courseWeb.dao.StudentDao;
import az.orient.courseWeb.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> getStudentList() throws Exception {
        return studentDao.getStudentList();
    }

    @Override
    public boolean addStudent(Student st) throws Exception {
        return studentDao.addStudent(st);
    }

    @Override
    public Student getStudentById(long studentId) throws Exception {
        return studentDao.getStudentById(studentId);
    }

    @Override
    public boolean deleteStudent(long stId) throws Exception {
        return studentDao.deleteStudent(stId);
    }

    @Override
    public boolean updateStudent(Student st, long stId) throws Exception {
        return studentDao.updateStudent(st, stId);
    }
}
