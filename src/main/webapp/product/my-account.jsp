<%@page isELIgnored="false"%>
<!doctype html>
<html>

<head>
    <meta charset="UTF-8">
    <%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8"%>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <title>Thông tin cá nhân</title>
    <meta name="robots" content="noindex, follow" />
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Favicon -->
    <link rel="shortcut icon" type="image/x-icon" href="assets/images/favicon.ico">

    <!-- CSS
	============================================ -->

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="./assets/css/vendor/bootstrap.min.css">
    <!-- Icon Font CSS -->
    <link rel="stylesheet" href="./assets/css/vendor/font-awesome.min.css">
    <link rel="stylesheet" href="./assets/css/vendor/simple-line-icons.css">

    <!-- Plugins CSS -->
    <link rel="stylesheet" href="./assets/css/plugins/slick.css">
    <link rel="stylesheet" href="./assets/css/plugins/animation.css">
    <link rel="stylesheet" href="./assets/css/plugins/nice-select.css">
    <link rel="stylesheet" href="./assets/css/plugins/fancy-box.css">
    <link rel="stylesheet" href="./assets/css/plugins/jqueryui.min.css">

    <!-- Vendor & Plugins CSS (Please remove the comment from below vendor.min.css & plugins.min.css for better website load performance and remove css files from avobe) -->
    <!--
    <script src="assets/js/vendor/vendor.min.js"></script>
    <script src="assets/js/plugins/plugins.min.js"></script>
    -->

    <!-- Main Style CSS (Please use minify version for better website load performance) -->
    <link rel="stylesheet" href="./assets/css/style.css">
    <!--<link rel="stylesheet" href="assets/css/style.min.css">-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
    <link rel="stylesheet" href="./assets/css/main.css">
<%--    <link rel="stylesheet" href="../assets/css/base.css">--%>
<%--    <link rel="stylesheet" href="../assets/css/grid.css">--%>
    <link rel="stylesheet" href="./assets/css/rebonsive.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css">

    <style>
        @import url('https://fonts.googleapis.com/css?family=Open+Sans&display=swap');
        body{background-color: #eeeeee;font-family: 'Open Sans',serif}

        .card{position: relative;display: -webkit-box;display: -ms-flexbox;display: flex;-webkit-box-orient: vertical;-webkit-box-direction: normal;-ms-flex-direction: column;flex-direction: column;min-width: 0;word-wrap: break-word;background-color: #fff;background-clip: border-box;border: 1px solid rgba(0, 0, 0, 0.1);border-radius: 0.10rem}
        .card-header:first-child{border-radius: calc(0.37rem - 1px) calc(0.37rem - 1px) 0 0}.card-header{padding: 0.75rem 1.25rem;margin-bottom: 0;background-color: #fff;border-bottom: 1px solid rgba(0, 0, 0, 0.1)}.track{position: relative;background-color: #ddd;height: 7px;display: -webkit-box;display: -ms-flexbox;display: flex;margin-bottom: 60px;margin-top: 50px}.track .step{-webkit-box-flex: 1;-ms-flex-positive: 1;flex-grow: 1;width: 25%;margin-top: -18px;text-align: center;position: relative}.track .step.active:before{background: #FF5722}.track .step::before{height: 7px;position: absolute;content: "";width: 100%;left: 0;top: 18px}.track .step.active .icon{background: #ee5435;color: #fff}.track .icon{display: inline-block;width: 40px;height: 40px;line-height: 40px;position: relative;border-radius: 100%;background: #ddd}.track .step.active .text{font-weight: 400;color: #000}.track .text{display: block;margin-top: 7px}.itemside{position: relative;display: -webkit-box;display: -ms-flexbox;display: flex;width: 100%}.itemside .aside{position: relative;-ms-flex-negative: 0;flex-shrink: 0}.img-sm{width: 80px;height: 80px;padding: 7px}ul.row, ul.row-sm{list-style: none;padding: 0}.itemside .info{padding-left: 15px;padding-right: 7px}.itemside .title{display: block;margin-bottom: 5px;color: #212529}p{margin-top: 0;margin-bottom: 1rem}.btn-warning{color: #ffffff;background-color: #ee5435;border-color: #ee5435;border-radius: 1px}.btn-warning:hover{color: #ffffff;background-color: #ff2b00;border-color: #ff2b00;border-radius: 1px}

        .main-content-wrap {
            background-color: #f9f9f9;
            padding: 30px 0;
        }

        .dashboard-upper-info {
            background-color: #fff;
            padding: 20px;
            margin-bottom: 20px;
            border: 1px solid #ddd;
        }

        .dashboard-content {
            background-color: #fff;
            padding: 20px;
            border: 1px solid #ddd;
            border-top: none;
        }

        .dashboard-list {
            background-color: #f9f9f9;
            padding: 15px;
            border: 1px solid #ddd;
            border-top: none;
        }

        .dashboard-list a {
            display: block;
            padding: 10px;
            margin-bottom: 10px;
            color: #333;
            text-decoration: none;
            transition: background-color 0.3s;
        }

        .dashboard-list a:hover {
            background-color: #ddd;
        }

        .btn {
            display: inline-block;
            padding: 10px 20px;
            font-size: 16px;
            text-align: center;
            text-decoration: none;
            cursor: pointer;
            border: none;
            border-radius: 4px;
            transition: background-color 0.3s;
        }

        .btn.default-btn {
            color: #fff;
            background-color: #ee5435;
        }

        .btn.default-btn:hover {
            background-color: #ff2b00;
        }
    </style>
</head>

<body>
<jsp:include page="../header/header.jsp"></jsp:include>
<div class="main-wrapper">
    <!-- breadcrumb-area start -->
    <div class="breadcrumb-area" style="margin-top: var(--header-height)">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <!-- breadcrumb-list start -->
                    <ul class="breadcrumb-list">
                        <li class="breadcrumb-item">Trang chủ / Thông tin tài khoản</li>
                    </ul>
                    <!-- breadcrumb-list end -->
                </div>
            </div>
        </div>
    </div>
    <!-- breadcrumb-area end -->


    <!-- main-content-wrap start -->
    <div class="main-content-wrap section-ptb my-account-page" style="padding: 30px 0;">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="account-dashboard">
                        <div class="dashboard-upper-info">
                            <div class="row align-items-center no-gutters">
                                <div class="col-lg-3 col-md-12">
                                    <div class="d-single-info" style="height: 60px;padding: 20px 0 20px;">
                                        <p class="user-name">Xin chào<span> ${sessionScope.user.fullName}</span></p>
                                    </div>
                                </div>

                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12 col-lg-2">
                                <!-- Nav tabs -->
                                <ul role="tablist" class="nav flex-column dashboard-list">
                                    <li><a href="#dashboard" data-bs-toggle="tab" class="nav-link active">Quản lý</a></li>
                                    <li><a href="#account-details" data-bs-toggle="tab" class="nav-link">Thông tin cá nhân</a></li>
                                    <li> <a href="#orders" data-bs-toggle="tab" class="nav-link">Đơn hàng</a></li>
                                    <li><a href="/product/report.jsp" class="nav-link">Yêu cầu</a></li>
                                    <li><a href="#listreport" data-bs-toggle="tab" class="nav-link">Danh sách yêu cầu</a></li>
                                    <li><a href="/LogoutServlet" class="nav-link">Đăng xuất</a></li>
                                </ul>
                            </div>
                            <div class="col-md-12 col-lg-10">
                                <!-- Tab panes -->
                                <div class="tab-content dashboard-content">
                                    <!-- quản lí tài khoản -->
                                    <div class="tab-pane active" id="dashboard">
                                        <h3>Quản lý tài khoản </h3>
                                        <div class="row">

                                            <div class="d111 col-md-4">
                                                <h6>Thông tin cá nhân <span class="sp111"></span></h6>
                                                <p>${sessionScope.user.uname}</p>
                                                <p>${sessionScope.user.email}</p>
                                                <p>${sessionScope.user.fullName}</p>
                                            </div>
                                            <div class="d111 col-md-8 "
                                                 style="border-left: rgb(255, 255, 255) 10px solid ;">
                                                <h6>Địa chỉ đặt hàng <span class="sp111"></span></h6>
                                                <p>${sessionScope.user.uname}</p>
                                                <p>(+84) ${sessionScope.user.phone}</p>
                                                <p>${sessionScope.user.address}</p>
                                            </div>
                                        </div>
                                        <div class="table-responsive d222">
                                            <h5>Đơn hàng</h5>
                                            <table class="table">
                                                <thead>
                                                <tr>
                                                    <th>ID</th>
                                                    <th>Tên người nhận</th>
                                                    <th>Ngày đặt hàng</th>
                                                    <th>Trạng thái</th>
                                                    <th>Tổng tiền</th>
                                                    <th>Chi tiết</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach var="dh" items="${donHang}">
                                                    <tr>
                                                        <td>${dh.idOrder}</td>
                                                        <td>${dh.nameRecipient}
                                                        </td>
                                                        <td>${dh.dateOrder}</td>
                                                        <c:set var="duyet" value="${dh.status}"></c:set>
                                                        <c:if test="${duyet == '1' }">
                                                            <td>Đang vận chuyển</td>
                                                            <td>${dh.totalMoney}00 đ</td>
                                                            <td><a href="/product/DetailOder?maDH=${dh.idOrder}" class="view">
                                                                Theo dõi</a></td>
                                                            <td><a href="/product/DetailOder?maDH=${dh.idOrder}" class="view">
                                                                Xác nhận</a></td>
                                                        </c:if>
                                                        <c:if test="${duyet == '0' }">
                                                            <td>Chưa được duyệt</td>
                                                            <td>${dh.totalMoney}00 đ</td>
                                                            <td><a href="/product/DetailOder?maDH=${dh.idOrder}" class="view">
                                                                Theo dõi</a></td>
                                                            <td><a href="/product/DetailOder?maDH=${dh.idOrder}" class="view">
                                                                Hủy</a></td>
                                                        </c:if>

                                                    </tr>
                                                </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>

                                    </div>
                                    <!-- thông tin cá nhân -->
                                    <div class="tab-pane fade" id="account-details">
                                        <div class="login" id="edit_111" style="display: none;">
                                            <div class="login-form-container">
                                                <div class="account-login-form">
                                                    <form action="#">
                                                        <!-- <label>Social title</label>
                                                        <div class="input-radio">
                                                            <span class="custom-radio"><input type="radio"
                                                                    value="1" name="id_gender"> Mr.</span>
                                                            <span class="custom-radio"><input type="radio"
                                                                    value="1" name="id_gender"> Mrs.</span>
                                                        </div> -->
                                                        <div class="account-input-box">
                                                            <label>Họ va tên</label>
                                                            <input type="text" name="first-name"
                                                                   value="${sessionScope.user.fullName}">
                                                            <label>Email</label>
                                                            <input type="text" name="email-name"
                                                                   value="${sessionScope.user.email}">
                                                            <label>Số điện thoại</label>
                                                            <input type="text" name="user-number"
                                                                   value="${sessionScope.user.phone}">
                                                            <label>Địa chỉ</label>
                                                            <input type="text"
                                                                   value="${sessionScope.user.address}" name="address">
                                                        </div>
                                                        <div class="example">
                                                            (Vd: 31/05/1970)
                                                        </div>
                                                        <div class="button-box">
                                                            <button class="btn default-btn" type="submit"
                                                                    id="submit_111">Lưu thông tin</button>
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                        <div id="save_111">
                                            <div class="row">
                                                <div class="col-3">
                                                    <p class="p441">Họ và tên</p>
                                                    <p>${sessionScope.user.fullName}</p>
                                                </div>
                                                <div class="col-3">
                                                    <p class="p441">Email</p>
                                                    <p>${sessionScope.user.email}</p>
                                                </div>
                                                <div class="col">
                                                    <p class="p441">Số điện thoại</p>
                                                    <p>(+84) ${sessionScope.user.phone}</p>
                                                </div>
                                            </div>
                                            <div class="button-box" style="padding-top: 20px;">
                                                <button class="btn default-btn" id="btn_edit_111">Sửa</button>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- đơn hàng -->
                                    <div class="tab-pane fade" id="orders">
                                        <h3>Đơn hàng</h3>
                                        <div class="table-responsive">
                                            <table class="table">
                                                <thead>
                                                <tr>
                                                    <th>ID</th>
                                                    <th>Tên người nhận</th>
                                                    <th>Ngày đặt hàng</th>
                                                    <th>Trạng thái</th>
                                                    <th>Tổng tiền</th>
                                                    <th>Chi tiết</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach var="dh" items="${donHang}">
                                                    <tr>
                                                        <td>${dh.idOrder}</td>
                                                        <td>${dh.nameRecipient}
                                                        </td>
                                                        <td>${dh.dateOrder}</td>
                                                        <c:set var="duyet" value="${dh.status}"></c:set>
                                                        <c:if test="${duyet == '1' }">
                                                            <td>Đang vận chuyển</td>
                                                        </c:if>
                                                        <c:if test="${duyet == '0' }">
                                                            <td>Chưa được duyệt</td>
                                                        </c:if>
                                                        <td>${dh.totalMoney}00 đ</td>

                                                        <td><a href="<c:url value="/product/DetailOder?maDH=${dh.idOrder}"></c:url>" class="view">
                                                            Theo dõi</a></td>
                                                    </tr>
                                                </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>

                                    <div class="tab-pane fade" id="listreport">
                                        <h3>Danh sách yêu cầu</h3>
                                        <br>
                                        <div class="table-responsive">
                                            <table class="table">
                                                <thead>
                                                <tr>
                                                    <th>STT</th>
                                                    <th>Thời gian</th>
                                                    <th>Nội dung</th>
                                                    <th>Trạng thái</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <c:set var="count" value="0"></c:set>
                                                <c:forEach var="re" items="${report}">
                                                    <tr>
                                                        <c:set var="count" value="${count + 1 }"></c:set>
                                                        <td>${count}</td>
                                                        <td>${re.time}</td>
                                                        <td>${re.description}</td>
                                                        <c:set var="duyet" value="${re.status}"></c:set>
                                                        <c:if test="${duyet == '1' }">
                                                            <td>Chưa được xử lý</td>
                                                        </c:if>
                                                        <c:if test="${duyet == '0' }">
                                                            <td>Đã được xử lý</td>
                                                        </c:if>
                                                    </tr>
                                                </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- main-content-wrap end -->

    <jsp:include page="/footer.jsp"></jsp:include>


    <!-- JS
============================================ -->

    <!-- Modernizer JS -->
    <script src="../product/assets/js/vendor/modernizr-3.6.0.min.js"></script>
    <!-- jquery -->

    <!-- jquery -->
    <script src="../product/assets/js/vendor/jquery-3.5.1.min.js"></script>
    <script src="../product/assets/js/vendor/jquery-migrate-3.3.0.min.js"></script>


    <!-- Bootstrap JS -->
    <script src="../product/assets/js/vendor/popper.min.js"></script>
    <script src="../product/assets/js/vendor/bootstrap.min.js"></script>

    <!-- Plugins JS -->
    <script src="../product/assets/js/plugins/slick.min.js"></script>

    <script src="../product/assets/js/plugins/jquery.nice-select.min.js"></script>
    <script src="../product/assets/js/plugins/countdown.min.js"></script>
    <script src="../product/assets/js/plugins/image-zoom.min.js"></script>
    <script src="../product/assets/js/plugins/fancybox.js"></script>
    <script src="../product/assets/js/plugins/scrollup.min.js"></script>
    <script src="../product/assets/js/plugins/jqueryui.min.js"></script>
    <script src="../product/assets/js/plugins/ajax-contact.js"></script>
    <!-- Main JS -->
    <script src="./assets/js/main.js"></script>

</body>
<!-- Mirrored from ruizzz.tk/my-account.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 02 Nov 2022 09:21:32 GMT -->
</html>