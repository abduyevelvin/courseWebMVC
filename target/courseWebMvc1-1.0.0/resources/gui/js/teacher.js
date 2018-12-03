var globalTeacherId = 0;

$(function () {
    $('#teacherTableId').DataTable({
        'paging': true,
        'lengthChange': false,
        'searching': true,
        'ordering': true,
        'info': true,
        'autoWidth': true
    });

    $('#teacherDobId').datepicker({
        autoclose: true
    });

    $('#addTeacherBtnId').click(function () {
        addTeacher();
    });

});

function addTeacher() {
    var name = $('#teacherNameId').val();
    var surname = $('#teacherSurnameId').val();
    var address = $('#teacherAddressId').val();
    var dob = $('#teacherDobId').val();

    var data = {
        name: name,
        surname: surname,
        address: address,
        dob: dob
    };

    $.ajax({
        url: 'addTeacher',
        type: 'POST',
        data: data,
        success: function (data) {
            if (data == "true") {
                alert("The Teacher added successfully...");
                $('#teacherNameId').val('');
                $('#teacherSurnameId').val('');
                $('#teacherAddressId').val('');
                $('#teacherDobId').val('');
            }
            else {
                alert("Error! Teacher cannot addedd...");
            }
        }
    });
}

function updateTeacher() {
    var name = $('#teacherNameId').val();
    var surname = $('#teacherSurnameId').val();
    var address = $('#teacherAddressId').val();
    var dob = $('#teacherDobId').val();

    var data = {
        name: name,
        surname: surname,
        address: address,
        dob: dob,
        tcId: globalTeacherId
    };

    $.ajax({
        url: 'updateTeacher',
        type: 'POST',
        data: data,
        success: function (data) {
            if (data == "true") {
                alert("The Teacher edited successfully...");
                $('#teacherEditModalId').modal("hide");
                location.reload();
            }
            else {
                alert("Error! Teacher cannot edited...");
            }
        }
    });
}

function editTeacher(tcId) {
    globalTeacherId = tcId;
    $.ajax({
        url: 'editTeacher',
        type: 'GET',
        data: 'tcId=' + tcId,
        dataType: 'html',
        success: function (data) {
            $('.modal-content').html(data);
            $('#teacherEditModalId').modal("show");
        }
    });
}

function deleteTeacher(tcId) {
    var yes = confirm("Are you sure to delete the teacher?");
    if (yes) {
        $.ajax({
            url: 'deleteTeacher',
            type: 'POST',
            data: 'tcId=' + tcId,
            success: function (data) {
                if (data == "true") {
                    alert("The teacher has been deleted successfully!");
                    location.reload();
                }
                else {
                    alert("Error, the teacher is not deleted...");
                }
            }
        });
    }
}