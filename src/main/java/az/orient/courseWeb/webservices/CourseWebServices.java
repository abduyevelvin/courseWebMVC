package az.orient.courseWeb.webservices;

import az.orient.courseWeb.request.ReqStudent;
import az.orient.courseWeb.response.RespStatus;
import az.orient.courseWeb.response.RespStudent;
import az.orient.courseWeb.response.RespTeacher;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface CourseWebServices {

    //RespStudent getStudentListById(@WebParam(name = "id") long id); -- if we send any paremeter
    @WebMethod
    List<RespStudent> getStudentList();

    @WebMethod
    List<RespTeacher> getTeacherList();

    @WebMethod
    RespStudent getStudentListById(@WebParam(name = "studentId") long studentId);

    @WebMethod
    RespStatus addStudent(@WebParam(name = "reqStudent")ReqStudent reqStudent);
}
