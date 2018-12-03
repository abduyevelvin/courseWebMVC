package az.orient.courseWeb.webservices;

import az.orient.courseWeb.exception.CourseException;
import az.orient.courseWeb.exception.ExceptionConstants;
import az.orient.courseWeb.model.Student;
import az.orient.courseWeb.model.Teacher;
import az.orient.courseWeb.request.ReqStudent;
import az.orient.courseWeb.response.RespStatus;
import az.orient.courseWeb.response.RespStudent;
import az.orient.courseWeb.service.StudentService;
import az.orient.courseWeb.util.Methods;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CourseRestWebServicesImpl implements CourseRestWebServices {

    @Autowired
    private StudentService studentService;

    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CourseWebServicesImpl.class);

    @Override
    @Path("/getStudentList")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<RespStudent> getStudentList() {
        List<RespStudent> response = new ArrayList<RespStudent>();
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
                response.add(res);
            }
            LOGGER.info("success GETSTUDENTLIST REST");
        } catch (CourseException ex) {
            //new RespStatus(ExceptionConstants.INVALID_REQUEST_DATA, "Invalid Request Parameter-");
            LOGGER.error("Course Service Exception", ex);
        } catch (Throwable ex) {
            String rnd = Methods.generateUniqueNumber();
            //new RespStatus(ExceptionConstants.INTERNAL_EXCEPTION, "Internal Exception " + rnd);
            LOGGER.error("Internal Exception " + rnd, ex);
        }

        return response;
    }

    @Override
    @Path("/getStudentById")
    //@Path("/getStudentById/{studentId}") -- path param ucun
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    //public RespStudent getStudentById(@PathParam("studentId") Long studentId)
    public RespStudent getStudentById(@QueryParam("studentId") Long studentId) {
        RespStudent respStudent = new RespStudent();
        try {

            if(studentId == null){
                throw new CourseException(ExceptionConstants.INVALID_REQUEST_DATA, "Invalid Request Parameter");
            }

            Student st = studentService.getStudentById(studentId);
            respStudent.setName(st.getName());
            respStudent.setSurname(st.getSurname());
            respStudent.setAddress(st.getAddress());
            if(st.getDob() != null) {
                respStudent.setDob(df.format(st.getDob()));
            }
            respStudent.setRespStatus(RespStatus.getSuccessStatus());
        } catch (CourseException ex) {
            respStudent.setRespStatus(new RespStatus(ExceptionConstants.INVALID_REQUEST_DATA, "Invalid Request Parameter-"));
            LOGGER.error("Course Service Exception", ex);
        } catch (Throwable ex) {
            String rnd = Methods.generateUniqueNumber();
            respStudent.setRespStatus(new RespStatus(ExceptionConstants.INTERNAL_EXCEPTION, "Internal Exception " + rnd));
            LOGGER.error("Internal Exception " + rnd, ex);
        }

        return respStudent;
    }

    @Override
    @POST
    @Path("/addStudent")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public RespStatus addStudent(ReqStudent reqStudent) {
        RespStatus respStatus = null;
        try {

            if(reqStudent.getName() == null && reqStudent.getSurname() == null) {
                throw new CourseException(ExceptionConstants.INVALID_REQUEST_DATA, "Invalid Request Parameter");
            }

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
        } catch (CourseException ex) {
            respStatus = new RespStatus(ExceptionConstants.INVALID_REQUEST_DATA, "Invalid Request Parameter-");
            LOGGER.error("Course Service Exception", ex);
        } catch (Throwable ex) {
            String rnd = Methods.generateUniqueNumber();
            respStatus = new RespStatus(ExceptionConstants.INTERNAL_EXCEPTION, "Internal Exception " + rnd);
            LOGGER.error("Internal Exception " + rnd, ex);
        }

        return respStatus;
    }
}
