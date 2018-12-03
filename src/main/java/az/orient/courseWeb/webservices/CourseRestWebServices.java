package az.orient.courseWeb.webservices;

import az.orient.courseWeb.request.ReqStudent;
import az.orient.courseWeb.response.RespStatus;
import az.orient.courseWeb.response.RespStudent;

import java.util.List;

public interface CourseRestWebServices {

    List<RespStudent> getStudentList();
    RespStudent getStudentById(Long studentId);
    RespStatus addStudent(ReqStudent reqStudent);
}
