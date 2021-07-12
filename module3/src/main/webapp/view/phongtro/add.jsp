<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Trang chủ</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="../../assert/datatables/css/dataTables.bootstrap4.min.css"/>
    <style>

    </style>
</head>
<body>
<jsp:include page="../../view/layoutt/header.jsp"></jsp:include>
<div class="container-fluid">
    <div class="row">
        <div class="col-2 p-0 m-0" style="height: 100vh">
            <jsp:include page="../../view/layoutt/left_content.jsp"></jsp:include>
        </div>
        <div class="col-10">

            <c:if test="${not empty status}">
                <div class="toast" data-autohide="false"
                     style="position: fixed; bottom: 15px; right: 15px; z-index: 1; min-width: 200px">
                    <div class="toast-header" style="background-color: ${requestScope['colorHeader']}">
                        <strong class="mr-auto">Trạng thái</strong>
                        <small>vừa xong</small>
                        <button type="button" class="ml-2 mb-1 close" data-dismiss="toast" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="toast-body">
                        <span style="color: red">${requestScope['status']}</span>
                    </div>
                </div>
            </c:if>
            <form method="post" action="/phongtro" class="text-center">
                <input hidden name="action" value="add">
                <h2 class="m-3">Add New PhongTro</h2>

                <table class="table table-borderless">
                    <div class="form-group">
                        <tr>
                            <td>
                                <label for="addName" class="d-inline">Tên người thuê</label>
                            </td>
                            <td>
                                <input type="text" class="form-control d-inline" id="addName" name="phongtro-name"
                                       aria-describedby="name_stu" value="${phongtro.tenNguoiThue}" required>
                                <input id="name_stu" class="form-text text-danger border-0 bg-white d-block w-100"
                                       style="font-size: smaller" value="" hidden disabled>
                            <td>
                        </tr>
                    </div>

                    <div class="form-group">
                        <tr>
                            <td>
                                <label for="addPhone" class="d-inline">Phone</label>
                            </td>
                            <td>
                                <input type="text" class="form-control d-inline" id="addPhone" name="phongtro-phone"
                                       aria-describedby="phone_stu" value="${phongtro.sdt}" required>
                                <input id="phone_stu" class="form-text text-danger text-wrap border-0 bg-white d-block w-100"
                                       style="font-size: smaller" value="" hidden disabled>
                            <td>
                        </tr>
                    </div>

                    <div class="form-group">
                        <tr>
                            <td>
                                <label for="addDate" class="d-inline">Ngày thuê</label>
                            </td>
                            <td>
                                <input type="date" class="form-control d-inline" id="addDate"
                                       name="phongtro-rent-date"
                                       value="${phongtro.ngayThue}" required>
                                <input id="date_stu" class="form-text text-danger border-0 bg-white d-block w-100"
                                       style="font-size: smaller" value="" hidden disabled>
                            <td>
                        </tr>
                    </div>

                    <div class="form-group">
                        <tr>
                            <td>
                                <label for="addPurchase" class="d-inline">Hình thức thanh toán</label>
                            </td>
                            <td>
                                <select class="form-control" id="addPurchase" name="phongtro-purchase">
                                    <option value="1" ${phongtro.hinhThucThanhToan == 1 ? 'selected' : ''}>Tháng</option>
                                    <option value="2" ${phongtro.hinhThucThanhToan == 2 ? 'selected' : ''}>Quý</option>
                                    <option value="3" ${phongtro.hinhThucThanhToan == 3 ? 'selected' : ''}>Năm</option>
                                </select>
                            <td>
                        </tr>
                    </div>
                    <div class="form-group">
                        <tr>
                            <td>
                                <label for="addNote" class="d-inline">Ghi chú</label>
                            </td>
                            <td>
                                <input type="text" class="form-control d-inline" id="addNote" name="phongtro-ghi-chu"
                                       value="${phongtro.ghiChu}">
                            <td>
                        </tr>
                    </div>
                </table>
                <a href="/phongtro" type="button" class="btn btn-secondary">Back</a>
                <button type="submit" class="btn btn-success" disabled="false" id="btn_submit">Submit</button>
            </form>

        </div>
    </div>
</div>
<jsp:include page="../../view/layoutt/footer.jsp"></jsp:include>
<script src="../../assert/jquery/jquery-3.5.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<script src="../../assert/datatables/js/jquery.dataTables.min.js"></script>
<script src="../../assert/datatables/js/dataTables.bootstrap4.min.js"></script>
</body>
<script>
    $(document).ready(function () {
        $('#addName').change(function () {
            let name = $("#addName").val();
            console.log(name);
            $.ajax({
                url: 'phongtro',
                data: {
                    action: "check_name",
                    name_check: name
                },
                success: function (responseText) {
                    if (responseText != "") {
                        document.getElementById("name_stu").value = responseText;
                        document.getElementById("name_stu").hidden = false;
                        document.getElementById("name_stu").disabled = true;
                        document.getElementById("btn_submit").disabled = true;
                    }else {
                        document.getElementById("name_stu").value = "";
                        document.getElementById("name_stu").hidden = true;
                        document.getElementById("btn_submit").disabled = false;
                    }
                }
            });
        });

        $('#addDate').change(function () {
            let date = $("#addDate").val();
            console.log(date);
            $.ajax({
                url: 'phongtro',
                data: {
                    action: "check_date",
                    date_check: date
                },
                success: function (responseText) {
                    if (responseText != "") {
                        document.getElementById("date_stu").value = responseText;
                        document.getElementById("date_stu").hidden = false;
                        document.getElementById("date_stu").disabled = true;
                        document.getElementById("btn_submit").disabled = true;
                    }else {
                        document.getElementById("date_stu").value = "";
                        document.getElementById("date_stu").hidden = true;
                        document.getElementById("btn_submit").disabled = false;
                    }
                }
            });
        });

        $('#addPhone').change(function () {
            let phone = $("#addPhone").val();
            console.log(phone);
            $.ajax({
                url: 'phongtro',
                data: {
                    action: "check_phone",
                    phone_check: phone
                },
                success: function (responseText) {
                    if (responseText != "") {
                        document.getElementById("phone_stu").value = responseText;
                        document.getElementById("phone_stu").hidden = false;
                        document.getElementById("phone_stu").disabled = true;
                        document.getElementById("btn_submit").disabled = true;
                    }else {
                        document.getElementById("phone_stu").value = "";
                        document.getElementById("phone_stu").hidden = true;
                        document.getElementById("btn_submit").disabled = false;
                    }
                }
            });
        });
    });
</script>

<script>
    $(document).ready(function () {
        $('.toast').toast('show');
        $('.toast').fadeOut(5000);
    });
</script>
</html>