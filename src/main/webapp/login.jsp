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
  <title>Đăng nhập</title>

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
<c:import url="header/header.jsp" />
<!-- Header Section End -->
<!-- From login -->
<section class="login py-5 border-top-1">
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-lg-9 col-md-5 align-item-center">
        <div class="border">
          <center>
            <h3 class="bg-gray p-4">
              <b>Đăng nhập</b>
            </h3>
          </center>
          <form action="LoginServlet" method="POST">
            <fieldset class="p-4">
              <p class="text-danger">${massage }</p>
              <label><b>Tên đăng nhập*</b></label>
              <input name="uname" type="text" placeholder="Tên đăg nhập" class="border p-3 w-100 my-2"  required="required">
              <label><b>Mật khẩu*</b></label>
              <input name="pass" type="password" placeholder="Mật khẩu" class="border p-3 w-100 my-2" required="required">
              <div class="loggedin-forgot">
                <input type="checkbox" id="remember" name="remember"> <label
                      for="remember" class="pt-3 pb-2">Lưu đăng nhập</label>
              </div>

              <button class="btn btn-primary btn-block border-0 py-3"
                      type="submit">Đăng nhập</button>
            </fieldset>
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