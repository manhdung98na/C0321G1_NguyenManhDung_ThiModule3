<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Danh sách</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="../../assert/datatables/css/dataTables.bootstrap4.min.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"/>
    <style>

    </style>
</head>
<body>
<jsp:include page="../../view/layoutt/header.jsp"></jsp:include>
<div class="container-fluid">
    <div class="row">
        <div class="col-auto col-sm-2 p-0 m-0" style="height: 100vh">
            <jsp:include page="../../view/layoutt/left_content.jsp"></jsp:include>
        </div>
        <div class="col-12 col-sm-10">

            <div class="card mt-4">
                <div class="card-header">
                    <h3 style="color: #c41f00">Danh sách khách hàng</h3>
                </div>
                <c:if test="${empty list}">
                    <div class="card-body">
                        <div class="d-block">
                                <%--Hiển thị danh sách--%>
                            <h5 class="card-title d-inline-block">Danh sách rỗng</h5>
                        </div>
                        <a href="/phongtro?action=add" type="button" class="btn btn-success card-title float-right">
                            Add new phongtro
                        </a>
                    </div>
                </c:if>
                <c:if test="${not empty list}">
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
                    <%--Ô tìm kiếm--%>
                    <div class="card-body">
                        <div>
                            <div class="search-box">
                                <form class="search-form  d-flex" action="/phongtro" method="get">
                                    <div class="input-group mb-3">
                                        <input type="text" class="form-control" name="search_string"
                                               placeholder="Tìm kiếm"
                                               aria-label="Tìm kiếm" aria-describedby="button-addon2"
                                               onkeypress="activeBtnSearch()">
                                        <div class="input-group-prepend">
                                            <input hidden name="action" value="search">
                                            <button type="submit" class="btn btn-secondary" id="button-addon2" disabled>
                                                <i class="fas fa-search"></i>
                                            </button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <hr>
                        <div class="d-inline">
                                <%--Hiển thị danh sách--%>
                            <h5 class="card-title d-inline-block">List of Customers</h5>
                            <a href="/phongtro?action=add" type="button" class="btn btn-success card-title float-right">
                                Add new phongtro
                            </a></div>
                            <%--Bảng danh sách--%>
                        <table class="table table-sm align-middle table-striped table-bordered m-0 nowrap"
                               id="tableCustomer" style="width: 100%">
                                <%--tiêu đề của bảng--%>
                            <thead class="p-0 m-0 table-dark">
                            <tr class="">
                                <th class="text-center">Mã phòng</th>
                                <th class="text-center">Tên</th>
                                <th class="text-center">SDT</th>
                                <th class="text-center">Ngày thuê</th>
                                <th class="text-center">Thanh toán</th>
                                <th class="text-center">Ghi chú</th>
                                <th class="text-center">Action</th>
                            </tr>
                            </thead>
                                <%--danh sách người dùng--%>
                            <tbody>
                            <c:forEach items='${list}' var="phongtro">
                                <tr class="">
                                    <td class=" text-center">
                                        <a href="/phongtro?action=detail&id=${phongtro.maPhongTro}">${phongtro.maPhongTro}</a>
                                    </td>
                                    <td class=" text-center">${phongtro.tenNguoiThue}</td>
                                    <td class=" text-center">${phongtro.sdt}</td>
                                    <td class=" text-center">${phongtro.ngayThue}</td>
                                    <td class=" text-center">${phongtro.tenHinhThucThanhToan}</td>
                                    <td class=" text-center">${phongtro.ghiChu}</td>
                                    <td class=" text-center">
                                        <a class="btn btn-info btn-sm"
                                           href="/phongtro?action=edit&id=${phongtro.maPhongTro}"
                                           role="button">Edit</a>

                                        <!-- Button trigger modal -->
                                        <button type="button" class="btn btn-danger btn-sm" data-toggle="modal"
                                                data-target="#modalDel"
                                                onclick="sendInfoToDelete('${phongtro.maPhongTro}','${phongtro.tenNguoiThue}')">
                                            Delete
                                        </button>
                                        <!-- Modal -->
                                        <div class="modal fade" id="modalDel" tabindex="-1" role="dialog"
                                             aria-labelledby="modelTitleId" aria-hidden="true">
                                            <div class="modal-dialog" role="document">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <h5 class="modal-title">Xác nhận xoá</h5>
                                                        <button type="button" class="close" data-dismiss="modal"
                                                                aria-label="Close">
                                                            <span aria-hidden="true">&times;</span>
                                                        </button>
                                                    </div>
                                                    <form action="/phongtro" method="post">
                                                        <input hidden name="action" value="delete">
                                                        <input hidden name="id" value="" id="idDelete">
                                                        <div class="modal-body">
                                                            <div class="container-fluid">
                                                                Bạn muốn xoá
                                                                <input id="nameConfirm" value=""
                                                                       style="border: none; outline:none; color: red"
                                                                       readonly>
                                                            </div>
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button type="button" class="btn btn-secondary"
                                                                    data-dismiss="modal">
                                                                Close
                                                            </button>
                                                            <button type="submit" class="btn btn-danger">Delete</button>
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                        <script>
                                            function sendInfoToDelete(id, name) {
                                                document.getElementById("idDelete").value = id;
                                                document.getElementById("nameConfirm").value = name + '?';
                                            }
                                        </script>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </c:if>
            </div>
            <div class="d-flex justify-content-center">
                <a href="/phongtro" type="button" class="btn btn-dark text-wrap mt-3">
                    Show All Customers
                </a>
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
        $('#tableCustomer').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "scrollX": true,
            "pageLength": 5,
        });
    });
</script>
<script>
    $(document).ready(function () {
        $('.toast').toast('show');
        $('.toast').fadeOut(3500);
    });
</script>
<script>
    function activeBtnSearch() {
        document.getElementById("button-addon2").removeAttribute("disabled");
    }
</script>
</html>