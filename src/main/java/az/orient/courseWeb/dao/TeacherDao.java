package az.orient.courseWeb.dao;

import az.orient.courseWeb.model.Teacher;

import java.util.List;

public interface TeacherDao {

    List<Teacher> getTeacherList() throws Exception;
    Teacher getTeacherById(long teacherId) throws Exception;

    boolean deleteTeacher(long tcId) throws Exception;
    boolean updateTeacher(Teacher tc, long tcId) throws Exception;
    boolean addTeacher(Teacher tc) throws Exception;
}
