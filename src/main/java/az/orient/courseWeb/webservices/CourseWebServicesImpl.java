package az.orient.courseWeb.webservices;

import az.orient.courseWeb.exception.ExceptionConstants;
import az.orient.courseWeb.model.Student;
import az.orient.courseWeb.model.Teacher;
import az.orient.courseWeb.request.ReqStudent;
import az.orient.courseWeb.response.RespStatus;
import az.orient.courseWeb.response.RespStudent;
import az.orient.courseWeb.response.RespTeacher;
import az.orient.courseWeb.service.StudentService;
import az.orient.courseWeb.service.TeacherService;
import az.orient.courseWeb.util.Methods;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebService;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
@WebService(endpointInterface = "az.orient.courseWeb.webservices.CourseWebServices")
public class CourseWebServicesImpl implements CourseWebServices {

    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;

    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CourseWebServicesImpl.class);

    @Override
    public List<RespStudent> getStudentList() {
        List<RespStudent> respStudents = new ArrayList<RespStudent>();
        try {
            List<Student> studentList = studentService.getStudentList();
            for(Student st: studentList) {
                RespStudent res = new RespStudent();
                res.setName(st.getName());
                res.setSurname(st.getSurname());
                res.setAddress(st.getAddress());
                if(st.getDob() != null) {
                    res.setDob(df.format(st.getDob()));
                }
                res.setTeacherName(st.getTeacherName());
                res.setTeacherSurname(st.getTeacherSurname());
                respStudents.add(res);
            }
        } catch (Exception ex) {
            LOGGER.error("Internal Exception " + Methods.generateUniqueNumber(), ex);
            ex.printStackTrace();
        }
        return respStudents;
    }

    @Override
    public List<RespTeacher> getTeacherList() {
        List<RespTeacher> response = new ArrayList<RespTeacher>();
        try {
            List<Teacher> teacherList = teacherService.getTeacherList();
            for(Teacher tc: teacherList) {
                RespTeacher res = new RespTeacher();
                res.setId(tc.getId_teacher());
                res.setName(tc.getName());
                res.setSurname(tc.getSurname());
                res.setAddress(tc.getAddress());
                if(tc.getDob() != null) {
                    res.setDob(df.format(tc.getDob()));
                }
                response.add(res);
            }
        } catch (Exception ex) {
            LOGGER.error("Internal Exception " + Methods.generateUniqueNumber(), ex);
            ex.printStackTrace();
        }
        return response;
    }

    @Override
    public RespStudent getStudentListById(long studentId) {
        RespStudent respStudent = new RespStudent();
        try {
            Student st = studentService.getStudentById(studentId);
            respStudent.setName(st.getName());
            respStudent.setSurname(st.getSurname());
            respStudent.setAddress(st.getAddress());
            if(st.getDob() != null) {
                respStudent.setDob(df.format(st.getDob()));
            }
            respStudent.setTeacherName(st.getTeacherName());
            respStudent.setTeacherSurname(st.getTeacherSurname());
            respStudent.setRespStatus(RespStatus.getSuccessStatus());
        } catch (Exception e) {
            respStudent.setRespStatus(new RespStatus(ExceptionConstants.INTERNAL_EXCEPTION, "Internal Exception"));
            e.printStackTrace();
        }

        return respStudent;
    }

    @Override
    public RespStatus addStudent(ReqStudent reqStudent) {
        RespStatus respStatus = null;
        try {
            Student st = new Student();
            st.setName(reqStudent.getName());
            st.setSurname(reqStudent.getSurname());
            st.setAddress(reqStudent.getAddress());
            if(reqStudent.getDob() != null) {
                st.setDob(reqStudent.getDob());
            }
            Teacher tc = new Teacher();
            tc.setId_teacher(reqStudent.getTeacherId());
            st.setTeacher(tc);

            boolean res = studentService.addStudent(st);
            if(res){
                respStatus = RespStatus.getSuccessStatus();
                LOGGER.info("Success " + respStatus);
            }
            else {
                respStatus = new RespStatus(ExceptionConstants.ADD_STUDENT_EXCEPTION, "Add Student Exception");
                LOGGER.error("Add Student Exception " + Methods.generateUniqueNumber());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            LOGGER.error("Internal Exception " + Methods.generateUniqueNumber(), ex);
            respStatus = new RespStatus(ExceptionConstants.INTERNAL_EXCEPTION, "Internal Exception " + Methods.generateUniqueNumber());
        }

        return respStatus;
    }
}
