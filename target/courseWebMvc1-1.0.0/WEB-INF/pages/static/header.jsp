<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 11/13/2018
  Time: 4:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class="main-header">
    <!-- Logo -->
    <a href="http://localhost:8083/course/index" class="logo">
        <!-- mini logo for sidebar mini 50x50 pixels
        <span class="logo-mini"><b>A</b>LT</span>
        logo for regular state and mobile devices -->
        <span class="logo-lg"><b>Course</b></span>
    </a>
    <!-- Header Navbar -->
    <nav class="navbar navbar-static-top" role="navigation">
        <!-- Sidebar toggle button-->
        <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
            <span class="sr-only">Toggle navigation</span>
        </a>
        <!-- Navbar Right Menu -->
        <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
                <!-- Messages: style can be found in dropdown.less-->
                <li class="dropdown messages-menu">
                    <!-- Menu toggle button -->
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="fa fa-envelope-o"></i>
                        <span class="label label-success">4</span>
                    </a>
                    <ul class="dropdown-menu">
                        <li class="header">You have 4 messages</li>
                        <li>
                            <!-- inner menu: contains the messages -->
                            <ul class="menu">
                                <li><!-- start message -->
                                    <a href="#">
                                        <div class="pull-left">
                                            <!-- User Image -->
                                            <img src="${pageContext.request.contextPath}/resources/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                                        </div>
                                        <!-- Message title and timestamp -->
                                        <h4>
                                            Support Team
                                            <small><i class="fa fa-clock-o"></i> 5 mins</small>
                                        </h4>
                                        <!-- The message -->
                                        <p>Why not buy a new awesome theme?</p>
                                    </a>
                                </li>
                                <!-- end message -->
                            </ul>
                            <!-- /.menu -->
                        </li>
                        <li class="footer"><a href="#">See All Messages</a></li>
                    </ul>
                </li>
                <!-- /.messages-menu -->
                <!-- User Account Menu -->
                <li class="dropdown user user-menu">
                    <!-- Menu Toggle Button -->
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <!-- The user image in the navbar-->
                        <c:choose>
                            <c:when test="${user.gender eq 'male'}">
                                <img src="${pageContext.request.contextPath}/resources/dist/img/male.jpg" class="user-image" alt="Male Image">
                                <span class="hidden-xs">${user.name} ${user.surname}</span>
                            </c:when>
                            <c:when test="${user.gender eq 'female'}">
                                <img src="${pageContext.request.contextPath}/resources/dist/img/female.jpg" class="user-image" alt="Female Image">
                                <span class="hidden-xs">${user.name} ${user.surname}</span>
                            </c:when>
                        </c:choose>
                        <!-- hidden-xs hides the username on small devices so only the image appears. -->
                    </a>
                    <ul class="dropdown-menu">
                        <!-- The user image in the menu -->
                        <li class="user-header" style="margin-bottom: -19%; padding-top: 6%;">
                            <c:choose>
                                <c:when test="${user.gender eq 'male'}">
                                    <img src="${pageContext.request.contextPath}/resources/dist/img/male.jpg" class="user-image" alt="Male Image">
                                    <p>
                                            ${user.name} ${user.surname}
                                        <small>Member Since: <fmt:formatDate pattern="yyyy-MM-dd" value="${user.login_date}" /></small>
                                    </p>
                                </c:when>
                                <c:when test="${user.gender eq 'female'}">
                                    <img src="${pageContext.request.contextPath}/resources/dist/img/female.jpg" class="user-image" alt="Female Image">
                                    <p>
                                            ${user.name} ${user.surname}
                                        <small>Member Since: <fmt:formatDate pattern="yyyy-MM-dd" value="${user.login_date}" /></small>
                                    </p>
                                </c:when>
                            </c:choose>
                        </li>
                        <!-- Menu Body -->
                        <%--<li class="user-body">
                            <div class="row">
                                <div class="col-xs-4 text-center">
                                    <a href="#">Followers</a>
                                </div>
                                <div class="col-xs-4 text-center">
                                    <a href="#">Sales</a>
                                </div>
                                <div class="col-xs-4 text-center">
                                    <a href="#">Friends</a>
                                </div>
                            </div>
                            <!-- /.row -->
                        </li>--%>
                        <!-- Menu Footer-->
                        <li class="user-footer">
                            <div class="pull-left">
                                <a href="${pageContext.request.contextPath}/profile" class="btn btn-info btn-flat">Profile</a>
                            </div>
                            <div class="pull-right">
                                <a href="javascript: formSubmit();" class="btn btn-danger btn-flat">Sign out</a>
                            </div>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </nav>
</header>