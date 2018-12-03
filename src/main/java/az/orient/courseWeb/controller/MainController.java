package az.orient.courseWeb.controller;

import az.orient.courseWeb.model.Student;
import az.orient.courseWeb.model.Teacher;
import az.orient.courseWeb.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private LessonService lessonService;
    @Autowired
    private ScheduleService scheduleService;


    DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

    private String getUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String user = auth.getName();

        return user;
    }

    @RequestMapping(value = {"/index"}, method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView model = new ModelAndView("main");
        try {
            model.addObject("user", loginService.getUserDetailsByUsername(getUser()));
            model.addObject("studentList", studentService.getStudentList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    @RequestMapping(value = {"/studentList"}, method = RequestMethod.GET)
    public ModelAndView studentList() {
        ModelAndView model = new ModelAndView("student/studentList");
        try {
            model.addObject("user", loginService.getUserDetailsByUsername(getUser()));
            model.addObject("studentList", studentService.getStudentList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    @RequestMapping(value = {"/newStudent"}, method = RequestMethod.GET)
    public ModelAndView newStudent() {
        ModelAndView model = new ModelAndView("student/newStudent");
        try {
            model.addObject("user", loginService.getUserDetailsByUsername(getUser()));
            List<Teacher> teacherList = teacherService.getTeacherList();
            model.addObject("teacherList", teacherList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public @ResponseBody String addStudent(@RequestParam("name") String name, @RequestParam("surname") String surname, @RequestParam("address") String address,
                                           @RequestParam("dob") String dob, @RequestParam("teacher") Long teacher) throws Exception {
        String result = "false";
        Student st = new Student();
        Teacher tc = new Teacher();

        try {
            st.setName(name);
            st.setSurname(surname);
            st.setAddress(address);
            st.setDob(df.parse(dob));
            tc.setId_teacher(teacher);
            st.setTeacher(tc);

            boolean isAdded = studentService.addStudent(st);

            if(isAdded) {
                result = "true";
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return result;
    }

    @RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
    public @ResponseBody String updateStudent(@RequestParam("name") String name, @RequestParam("surname") String surname, @RequestParam("address") String address,
                                           @RequestParam("dob") String dob, @RequestParam("teacher") Long teacher, @RequestParam("stId") Long stId) throws Exception {
        String result = "false";
        Student st = new Student();
        Teacher tc = new Teacher();

        try {
            st.setName(name);
            st.setSurname(surname);
            st.setAddress(address);
            st.setDob(df.parse(dob));
            tc.setId_teacher(teacher);
            st.setTeacher(tc);

            boolean isEdited = studentService.updateStudent(st, stId);

            if(isEdited) {
                result = "true";
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return result;
    }

    @RequestMapping(value = "/editStudent", method = RequestMethod.GET)
    public ModelAndView editStudent(@RequestParam("stId") Long stId) throws Exception {
        ModelAndView model = new ModelAndView();
        model.setViewName("student/editStudent");

        model.addObject("user", loginService.getUserDetailsByUsername(getUser()));
        Student student = studentService.getStudentById(stId);
        List<Teacher> teacherList = teacherService.getTeacherList();
        model.addObject("student", student);
        model.addObject("teacherList", teacherList);

        return model;
    }

    @RequestMapping(value = "/deleteStudent", method = RequestMethod.POST)
    public @ResponseBody String deleteStudent(@RequestParam("stId") Long stId) throws Exception {
        String result = "false";
        boolean isDeleted = studentService.deleteStudent(stId);
        if(isDeleted) {
            result = "true";
        }

        return result;
    }

    @RequestMapping(value = {"/teacherList"}, method = RequestMethod.GET)
    public ModelAndView teacherList() {
        ModelAndView model = new ModelAndView("teacher/teacherList");
        try {
            model.addObject("user", loginService.getUserDetailsByUsername(getUser()));
            model.addObject("teacherList", teacherService.getTeacherList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    @RequestMapping(value = "/editTeacher", method = RequestMethod.GET)
    public ModelAndView editTeacher(@RequestParam("tcId") Long tcId) throws Exception {
        ModelAndView model = new ModelAndView();
        model.setViewName("teacher/editTeacher");

        model.addObject("user", loginService.getUserDetailsByUsername(getUser()));
        Teacher teacher = teacherService.getTeacherById(tcId);
        model.addObject("teacher", teacher);

        return model;
    }

    @RequestMapping(value = "/updateTeacher", method = RequestMethod.POST)
    public @ResponseBody String updateTeacher(@RequestParam("name") String name, @RequestParam("surname") String surname, @RequestParam("address") String address,
                                              @RequestParam("dob") String dob, @RequestParam("tcId") Long tcId) throws Exception {
        String result = "false";
        Teacher tc = new Teacher();

        try {
            tc.setName(name);
            tc.setSurname(surname);
            tc.setAddress(address);
            tc.setDob(df.parse(dob));

            boolean isEdited = teacherService.updateTeacher(tc, tcId);

            if(isEdited) {
                result = "true";
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return result;
    }

    @RequestMapping(value = "/deleteTeacher", method = RequestMethod.POST)
    public @ResponseBody String deleteTeacher(@RequestParam("tcId") Long tcId) throws Exception {
        String result = "false";
        boolean isDeleted = teacherService.deleteTeacher(tcId);
        if(isDeleted) {
            result = "true";
        }

        return result;
    }

    @RequestMapping(value = {"/newTeacher"}, method = RequestMethod.GET)
    public ModelAndView newTeacher() {
        ModelAndView model = new ModelAndView("teacher/newTeacher");
        try {
            model.addObject("user", loginService.getUserDetailsByUsername(getUser()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    @RequestMapping(value = "/addTeacher", method = RequestMethod.POST)
    public @ResponseBody String addTeacher(@RequestParam("name") String name, @RequestParam("surname") String surname, @RequestParam("address") String address,
                                           @RequestParam("dob") String dob) throws Exception {
        String result = "false";
        Teacher tc = new Teacher();

        try {
            tc.setName(name);
            tc.setSurname(surname);
            tc.setAddress(address);
            tc.setDob(df.parse(dob));

            boolean isAdded = teacherService.addTeacher(tc);

            if(isAdded) {
                result = "true";
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return result;
    }

    @RequestMapping(value = {"/lessonList"}, method = RequestMethod.GET)
    public ModelAndView lessonList() {
        ModelAndView model = new ModelAndView("lesson/lessonList");
        try {
            model.addObject("user", loginService.getUserDetailsByUsername(getUser()));
            model.addObject("lessonList", lessonService.getLessonList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    @RequestMapping(value = {"/showSchedule"}, method = RequestMethod.GET)
    public ModelAndView showSchedule() {
        ModelAndView model = new ModelAndView("schedule/showSchedule");
        try {
            model.addObject("user", loginService.getUserDetailsByUsername(getUser()));
            model.addObject("scheduleList", scheduleService.getScheduleList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    @RequestMapping(value = {"/profile"}, method = RequestMethod.GET)
    public ModelAndView profile() {
        ModelAndView model = new ModelAndView("profile");
        try {
            model.addObject("user", loginService.getUserDetailsByUsername(getUser()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }
}
