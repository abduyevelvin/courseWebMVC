package az.orient.courseWeb.dao;

import az.orient.courseWeb.model.Student;

import java.util.List;

public interface StudentDao {

    List<Student> getStudentList() throws Exception;
    boolean addStudent(Student st) throws Exception;
    Student getStudentById(long studentId) throws Exception;
    boolean deleteStudent(long stId) throws Exception;
    boolean updateStudent(Student st, long stId) throws Exception;
}
