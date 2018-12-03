var globalStudentId = 0;

$(function () {
    $('#studentTableId').DataTable({
        'paging': true,
        'lengthChange': false,
        'searching': true,
        'ordering': true,
        'info': true,
        'autoWidth': true
    });

    $('#studentDobId').datepicker({
        autoclose: true
    });

    $('#addStudentBtnId').click(function () {
        var tId = $('#teacherComboId').val();
        if (tId != 0) {
            addStudent();
        }
        else {
            alert("Please choose a teacher...");
        }
    });

});

function addStudent() {
    var name = $('#studentNameId').val();
    var surname = $('#studentSurnameId').val();
    var address = $('#studentAddressId').val();
    var dob = $('#studentDobId').val();
    var teacher = $('#teacherComboId').val();

    var data = {
        name: name,
        surname: surname,
        address: address,
        dob: dob,
        teacher: teacher
    };

    $.ajax({
        url: 'addStudent',
        type: 'POST',
        data: data,
        success: function (data) {
            if (data == "true") {
                alert("The Student added successfully...");
                $('#studentNameId').val('');
                $('#studentSurnameId').val('');
                $('#studentAddressId').val('');
                $('#studentDobId').val('');
                $('#teacherComboId').val(0);
            }
            else {
                alert("Error! Student cannot addedd...");
            }
        }
    });
}

function updateStudent() {
    var name = $('#studentNameId').val();
    var surname = $('#studentSurnameId').val();
    var address = $('#studentAddressId').val();
    var dob = $('#studentDobId').val();
    var teacher = $('#teacherComboId').val();

    var data = {
        name: name,
        surname: surname,
        address: address,
        dob: dob,
        teacher: teacher,
        stId: globalStudentId
    };

    $.ajax({
        url: 'updateStudent',
        type: 'POST',
        data: data,
        success: function (data) {
            if (data == "true") {
                alert("The Student edited successfully...");
                $('#studentEditModalId').modal("hide");
                location.reload();
            }
            else {
                alert("Error! Student cannot edited...");
            }
        }
    });
}

function editStudent(stId) {
    globalStudentId = stId;
    $.ajax({
        url: 'editStudent',
        type: 'GET',
        data: 'stId=' + stId,
        dataType: 'html',
        success: function (data) {
            $('.modal-content').html(data);
            $('#studentEditModalId').modal("show");
        }
    });
}

function deleteStudent(stId) {
    var yes = confirm("Are you sure to delete the student?");
    if (yes) {
        $.ajax({
            url: 'deleteStudent',
            type: 'POST',
            data: 'stId=' + stId,
            success: function (data) {
                if (data == "true") {
                    alert("The student has been deleted successfully!");
                    location.reload();
                }
                else {
                    alert("Error, the student is not deleted...");
                }
            }
        });
    }
}