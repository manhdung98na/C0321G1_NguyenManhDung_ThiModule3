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

            <h2 class="m-3">Customer's Information Detail</h2>
            <table class="table table-borderless">
                <div class="form-group">
                    <tr>
                        <td>
                            <label for="detailID" class="d-inline">ID</label>
                        </td>
                        <td>
                            <input type="text" disabled class="form-control d-inline" id="detailID"
                                   value="${customer.getCustomerId()}">
                        <td>
                    </tr>
                </div>
                <div class="form-group">
                    <tr>
                        <td>
                            <label for="detailType" class="d-inline">Customer type</label>
                        </td>
                        <td>
                            <select class="form-control d-inline" id="detailType" disabled>
                                <option value="1" ${customer.getCustomerType() == 1 ? 'selected': ''}>Diamond
                                </option>
                                <option value="2" ${customer.getCustomerType() == 2 ? 'selected': ''}>Platinium
                                </option>
                                <option value="3" ${customer.getCustomerType() == 3 ? 'selected': ''}>Gold</option>
                                <option value="4" ${customer.getCustomerType() == 4 ? 'selected': ''}>Silver
                                </option>
                                <option value="5" ${customer.getCustomerType() == 5 ? 'selected': ''}>Member
                                </option>
                            </select>
                        <td>
                    </tr>
                </div>
                <%--Edit Name--%>
                <div class="form-group">
                    <tr>
                        <td>
                            <label for="detailName" class="d-inline">Customer Name</label>
                        </td>
                        <td>
                            <input type="text" class="form-control d-inline" id="detailName"
                                   value="${customer.getCustomerName()}" aria-describedby="name_stu" disabled>
                        <td>
                    </tr>
                </div>
                <%--Edit Email--%>
                <div class="form-group">
                    <tr>
                        <td>
                            <label for="detailBirthday" class="d-inline">Birthday</label>
                        </td>
                        <td>
                            <input type="date" class="form-control d-inline" id="detailBirthday"
                                   value="${customer.getCustomerBirthday()}" disabled>
                        <td>
                    </tr>
                </div>
                <div class="form-group">
                    <tr>
                        <td>
                            <label class="d-inline">Gender</label>
                        </td>
                        <td style="float: left">
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" id="addGender1"
                                       value="Male" ${customer.getCustomerGender() == 'Male' ? 'checked':''}>
                                <label class="form-check-label" for="addGender1">Male</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" id="addGender2"
                                       value="Female" ${customer.getCustomerGender() == 'Female' ? 'checked':''}>
                                <label class="form-check-label" for="addGender2">Female</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" id="addGender3"
                                       value="Unknown" ${customer.getCustomerGender() == 'Unknown' ? 'checked':''}>
                                <label class="form-check-label" for="addGender3">Unknown</label>
                            </div>
                        <td>
                    </tr>
                </div>
                <div class="form-group">
                    <tr>
                        <td>
                            <label for="detailIdCard" class="d-inline">ID Card</label>
                        </td>
                        <td>
                            <input type="text" class="form-control d-inline" id="detailIdCard"
                                   value="${customer.getCustomerIdCard()}" aria-describedby="idCard_stu" disabled>
                        <td>
                    </tr>
                </div>
                <div class="form-group">
                    <tr>
                        <td>
                            <label for="detailPhone" class="d-inline">Phone</label>
                        </td>
                        <td>
                            <input type="text" class="form-control d-inline" id="detailPhone"
                                   value="${customer.getCustomerPhone()}" aria-describedby="phone_stu" disabled>
                        <td>
                    </tr>
                </div>
                <div class="form-group">
                    <tr>
                        <td>
                            <label for="detailEmail" class="d-inline">Email</label>
                        </td>
                        <td>
                            <input type="email" class="form-control d-inline" id="detailEmail"
                                   value="${customer.getCustomerEmail()}" aria-describedby="email_stu" disabled>
                        <td>
                    </tr>
                </div>
                <div class="form-group">
                    <tr>
                        <td>
                            <label for="detailAddress" class="d-inline">Address</label>
                        </td>
                        <td>
                            <input type="text" class="form-control d-inline" id="detailAddress"
                                   value="${customer.getCustomerAddress()}" disabled>
                        <td>
                    </tr>
                </div>
            </table>
            <div class="row justify-content-center">
                <a href="/customer" type="button" class="btn btn-secondary">Back</a>
            </div>
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
</html>