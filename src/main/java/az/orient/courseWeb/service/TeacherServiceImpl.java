package az.orient.courseWeb.service;

import az.orient.courseWeb.dao.TeacherDao;
import az.orient.courseWeb.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    @Override
    public List<Teacher> getTeacherList() throws Exception {
        return teacherDao.getTeacherList();
    }

    @Override
    public Teacher getTeacherById(long teacherId) throws Exception {
        return teacherDao.getTeacherById(teacherId);
    }

    @Override
    public boolean deleteTeacher(long tcId) throws Exception {
        return teacherDao.deleteTeacher(tcId);
    }

    @Override
    public boolean updateTeacher(Teacher tc, long tcId) throws Exception {
        return teacherDao.updateTeacher(tc, tcId);
    }

    @Override
    public boolean addTeacher(Teacher tc) throws Exception {
        return teacherDao.addTeacher(tc);
    }
}
