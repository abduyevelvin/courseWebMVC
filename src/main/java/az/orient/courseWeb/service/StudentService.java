package az.orient.courseWeb.service;

import az.orient.courseWeb.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getStudentList() throws Exception;
    boolean addStudent(Student st) throws Exception;
    Student getStudentById(long studentId) throws Exception;
    boolean deleteStudent(long stId) throws Exception;
    boolean updateStudent(Student st, long stId) throws Exception;
}
