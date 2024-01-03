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
    <title>Yêu cầu cấp lại khóa</title>
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
                        <li class="breadcrumb-item">Trang chủ / Thông tin tài khoản / Yêu cầu cấp lại khóa</li>
                    </ul>
                    <!-- breadcrumb-list end -->
                </div>
            </div>
        </div>
    </div>
    <!-- breadcrumb-area end -->


    <!-- main-content-wrap start -->
    <section class="login py-5 border-top-1">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-9 col-md-5 align-item-center">
                    <div class="border">
                        <center>
                            <h3 class="bg-gray p-4">
                                <b>Yêu cầu cấp lại khóa</b>
                            </h3>
                        </center>
                                        <form class="form-container" id="requestForm" method="post" action="/ReportServlet">
                                            <fieldset class="p-4">
                                                <label for="fullName">Họ và tên:</label>
                                                <input type="text" class="form-control" id="fullName" name="fullName" required>
                                                <p class="text-danger">${errName}</p>
                                                <label for="email">Email:</label>
                                                <input type="email" class="form-control" id="email" name="email" required>
                                                <p class="text-danger">${errEmail }</p>
                                                <label for="phone">Số điện thoại:</label>
                                                <input type="text" class="form-control" id="phone" name="phone" required>
                                                <p class="text-danger">${errPhone }</p>
                                                <p class="text-danger">${err }</p>
                                                <label for="description">Lý do yêu cầu:</label>
                                                <textarea class="form-control" id="description" name="description" rows="3" required></textarea>
                                                <p class="text-danger">${errDes }</p>
                                            <button type="submit" class="btn btn-primary btn-block">Gửi Yêu Cầu</button>
                                            </fieldset>
                                        </form>
                                </div>
                            </div>
                        </div>
                    </div>
    </section>
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