<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Đăng ký</title>

    <!-- Google Font -->
    <link
            href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap"
            rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="css/style.css" type="text/css">
</head>
<body>
<!-- Header Section Begin -->
<c:import url="header.jsp" />
<!-- Header Section End -->
<!-- From login -->
<section class="login py-5 border-top-1">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-9 col-md-5 align-item-center">
                <div class="border">
                    <center>
                        <h3 class="bg-gray p-4">
                            <b>Đăng ký</b>
                        </h3>
                    </center>
                    <form action="RegisterServlet" method="POST">
                        <fieldset class="p-4">
                            <p class="text-danger">${mess }</p>
                            <p class="text-danger">${userexit }</p>
                            <label for="uname"><b>Tên đăng ký*</b></label> <input
                                name="name" type="text" placeholder="Tên đăg nhập"
                                class="border p-3 w-100 my-2"> <label for="uname"><b>Email*</b></label>
                            <input name="email" type="email" placeholder="Email"
                                   class="border p-3 w-100 my-2"> <label for="uname"><b>Mật
                            khẩu*</b></label> <input name="pass" type="password"
                                                     placeholder="Mật khẩu" class="border p-3 w-100 my-2"> <label
                                for="uname"><b>Nhập lại mật khẩu*</b></label> <input
                                name="repass" type="password" placeholder="Nhập lại mật khẩu"
                                class="border p-3 w-100 my-2">
                            <button class="btn btn-primary btn-block border-0 py-3"
                                    type="submit">Đăng ký</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- From login end -->
<!-- Footer Section Begin -->
<c:import url="footer.jsp" />
<!-- Footer Section Begin -->
<!-- Js Plugins -->
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.nice-select.min.js"></script>
<script src="js/jquery-ui.min.js"></script>
<script src="js/jquery.slicknav.js"></script>
<script src="js/mixitup.min.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/main.js"></script>
</body>
</html>