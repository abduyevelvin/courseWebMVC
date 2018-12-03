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
        $('#teacherDobId').datepicker({
            autoclose: true
        });

        $('#updateTeacherBtnId').click(function () {
            var db = $('#teacherDobId').val();
            if(db != "") {
                updateTeacher();
            }
            else {
                alert("Please enter a birth date");
            }
        });
    });
    
</script>

<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
        <span aria-hidden="true">&times;</span></button>
    <h4 class="modal-title">Edit Teacher</h4>
</div>
<div class="modal-body">
    <div class="form-group">
        <label>Name</label>
        <input type="text" class="form-control" id="teacherNameId" placeholder="Enter Teacher Name..." value="${teacher.name}" />
    </div>
    <div class="form-group">
        <label>Surname</label>
        <input type="text" class="form-control" id="teacherSurnameId" placeholder="Enter Teacher Surname..." value="${teacher.surname}" />
    </div>
    <div class="form-group">
        <label>Address</label>
        <textarea class="form-control" id="teacherAddressId" placeholder="Enter Teacher Address...">${teacher.address}</textarea>
    </div>
    <div class="form-group">
        <label>Birth Date</label>
        <input type="text" class="form-control" id="teacherDobId" placeholder="Enter Teacher Birth Date..." value="<fmt:formatDate pattern='MM/dd/yyyy' value='${teacher.dob}' />" />
    </div>
</div>
<div class="modal-footer">
    <button type="button" class="btn btn-outline btn-danger pull-left" data-dismiss="modal">Close</button>
    <button type="button" class="btn btn-outline btn-success" id="updateTeacherBtnId">Save Changes</button>
</div>