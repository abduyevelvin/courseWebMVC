<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 11/14/2018
  Time: 7:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%java.text.DateFormat df = new java.text.SimpleDateFormat("MM/dd/yyyy"); %>

<script type="text/javascript">

    $(function () {
        $('#teacherComboId').val('${student.id_teacher}');

        $('#studentDobId').datepicker({
            autoclose: true
        });

        $('#updateStudentBtnId').click(function () {
            var tId = $('#teacherComboId').val();
            var db = $('#studentDobId').val();
            if(tId != 0 && db != "") {
                updateStudent();
            }
            else {
                alert("Please choose a teacher and birth date");
            }
        });
    });
    
</script>

<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
        <span aria-hidden="true">&times;</span></button>
    <h4 class="modal-title">Edit Student</h4>
</div>
<div class="modal-body">
    <div class="form-group">
        <label>Name</label>
        <input type="text" class="form-control" id="studentNameId" placeholder="Enter Student Name..." value="${student.name}" />
    </div>
    <div class="form-group">
        <label>Surname</label>
        <input type="text" class="form-control" id="studentSurnameId" placeholder="Enter Student Surname..." value="${student.surname}" />
    </div>
    <div class="form-group">
        <label>Address</label>
        <textarea class="form-control" id="studentAddressId" placeholder="Enter Student Address...">${student.address}</textarea>
    </div>
    <div class="form-group">
        <label>Birth Date</label>
        <input type="text" class="form-control" id="studentDobId" placeholder="Enter Student Birth Date..." value="<fmt:formatDate pattern='MM/dd/yyyy' value='${student.dob}' />" />
    </div>
    <div class="form-group">
        <label>Choose Teacher</label>
        <select class="form-control" id="teacherComboId">
            <option value="0">Choose Teacher</option>
            <c:forEach items="${teacherList}" var="tl">
                <option value="${tl.id_teacher}">${tl.name} ${tl.surname}</option>
            </c:forEach>
        </select>
    </div>
</div>
<div class="modal-footer">
    <button type="button" class="btn btn-outline btn-danger pull-left" data-dismiss="modal">Close</button>
    <button type="button" class="btn btn-outline btn-success" id="updateStudentBtnId">Save Changes</button>
</div>