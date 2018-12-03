<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 11/13/2018
  Time: 3:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<ul class="sidebar-menu" data-widget="tree">
    <li class="header">Main Menu</li>

    <c:choose>
        <c:when test="${user.role_name eq 'ROLE_ADMIN'}">
            <li class="treeview">
                <a href="#"><i class="fa fa-graduation-cap"></i> <span>Students</span>
                    <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="${pageContext.request.contextPath}/studentList">List of Students</a></li>
                    <li><a href="${pageContext.request.contextPath}/newStudent">Add New Student</a></li>
                </ul>
            </li>

            <li class="treeview">
                <a href="#"><i class="fa fa-briefcase"></i> <span>Teachers</span>
                    <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="${pageContext.request.contextPath}/teacherList">List of Teachers</a></li>
                    <li><a href="${pageContext.request.contextPath}/newTeacher">Add New Teacher</a></li>
                </ul>
            </li>

            <li class="treeview">
                <a href="#"><i class="fa fa-book"></i> <span>Lesson</span>
                    <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="${pageContext.request.contextPath}/lessonList">List of Lessons</a></li>
                    <li><a href="#">Add New Lesson</a></li>
                </ul>
            </li>

            <li class="treeview">
                <a href="#"><i class="fa fa-university"></i> <span>Schedule</span>
                    <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="${pageContext.request.contextPath}/showSchedule">Show Schedule</a></li>
                    <li><a href="#">Add Schedule</a></li>
                </ul>
            </li>
        </c:when>
        <c:when test="${user.role_name eq 'ROLE_TEACHER'}">
            <li class="treeview">
                <a href="#"><i class="fa fa-graduation-cap"></i> <span>Students</span>
                    <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="${pageContext.request.contextPath}/studentList">List of Students</a></li>
                </ul>
            </li>
            <li class="treeview">
                <a href="#"><i class="fa fa-briefcase"></i> <span>Teachers</span>
                    <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="${pageContext.request.contextPath}/teacherList">List of Teachers</a></li>
                </ul>
            </li>
            <li class="treeview">
                <a href="#"><i class="fa fa-book"></i> <span>Lesson</span>
                    <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="${pageContext.request.contextPath}/lessonList">List of Lessons</a></li>
                </ul>
            </li>
            <li class="treeview">
                <a href="#"><i class="fa fa-university"></i> <span>Schedule</span>
                    <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="${pageContext.request.contextPath}/showSchedule">Show Schedule</a></li>
                </ul>
            </li>
        </c:when>
        <c:when test="${user.role_name eq 'ROLE_STUDENT'}">
            <li class="treeview">
                <a href="#"><i class="fa fa-briefcase"></i> <span>Teachers</span>
                    <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="${pageContext.request.contextPath}/teacherList">List of Teachers</a></li>
                </ul>
            </li>
            <li class="treeview">
                <a href="#"><i class="fa fa-book"></i> <span>Lesson</span>
                    <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="${pageContext.request.contextPath}/lessonList">List of Lessons</a></li>
                </ul>
            </li>
        </c:when>
    </c:choose>
</ul>
