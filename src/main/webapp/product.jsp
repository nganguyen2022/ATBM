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
  <title>Sản phẩm</title>

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
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
        rel="stylesheet">
</head>
<style>
  .product__a {
    padding: 20px;
    padding-left: 100px;
  }
</style>
<body>
<!-- Header Section Begin -->
<c:import url="header/header.jsp" />
<!-- Header Section End -->
<section class="hero">
  <div class="container">
    <div class="row">
      <div class="col-lg-3">
        <div class="hero__categories">
          <div class="hero__categories__all">
            <i class="fa fa-bars"></i> <span>Danh mục sản phẩm</span>
          </div>
          <ul>
            <li><a href="CategoryServlet?cid=AN">Áo nam</a></li>
            <li><a href="CategoryServlet?cid=NU">Áo nữ</a></li>
            <li><a href="CategoryServlet?cid=AK">Áo khoác</a></li>
            <li><a href="CategoryServlet?cid=P">Áo Polo</a></li>

          </ul>
        </div>
      </div>
      <div class="col-lg-9">
        <div class="hero__search">
          <div class="hero__search__form">
            <form action="SearchServlet" method="post">
              <div class="hero__search__categories">
                Bạn muốn tìm?
              </div>
              <input value="${value }" name="txt" type="text"
                     placeholder="Tìm kiếm">
              <button type="submit" class="site-btn">Tìm kiếm</button>
            </form>
          </div>
          <div class="hero__search__phone">
            <div class="hero__search__phone__icon">
              <i class="fa fa-phone"></i>
            </div>
            <div class="hero__search__phone__text">
              <h5>0387524615</h5>
              <span>Hỗ trợ 24/7</span>
            </div>
          </div>
        </div>
        <div class="hero__item set-bg" data-setbg="images/bgtc.jpg">

        </div>
      </div>
    </div>
  </div>
</section>
<!-- Hero Section End -->
<!-- Featured Section Begin -->
<section class="featured spad">
  <div class="container">
    <div class="row">
      <div class="col-lg-12">
        <div class="section-title">
          <h2>Sản phẩm</h2>
        </div>
      </div>
    </div>
    <div class="row product__a">
      <c:forEach items="${listP }" var="p">
        <form action="/product/CartServlet?maSP=${p.pID}&action=Them" method="post">
        <div class="col-lg-3 col-md-4 col-sm-6 mix oranges fresh-meat">
          <div class="featured__item">
            <div class="featured__item__pic set-bg" data-setbg="${p.img }">
            </div>
            <div class="featured__item__text">
              <h6>
                <a class="namepro" style="white-space: nowrap" href="DetailServlet?pid=${p.pID }">${p.pName }</a>
              </h6>
              <h5 style="padding-left: 142px">${p.price }VNĐ</h5>
                <input class="primary-btn" type="submit" value="Thêm vào giỏ hàng">
            </div>
          </div>
        </div>
        </form>
      </c:forEach>
    </div>
  </div>
</section>
<!-- Featured Section End -->

<!-- Footer Section Begin -->
<footer class="footer spad">
  <div class="container">
    <div class="row">
      <div class="col-lg-3 col-md-6 col-sm-6">
        <div class="footer__about">
          <div class="footer__about__logo">
            <img src="images/logo2.jpg" alt="">
          </div>
          <ul>
            <li><i class="fa material-icons" style="font-size: 20px">&#xe0c8;</i>
              Khu phố 6 phường Linh Trung, Thủ Đức, TP.HCM</li>
            <li><i class="material-icons" style="font-size: 20px">&#xe0d1;</i>
              0387524615</li>
            <li><i class="material-icons" style="font-size: 20px">&#xe159;</i>
              dhstore@gmail.com</li>
          </ul>
        </div>
      </div>
      <div class="col-lg-4 col-md-6 col-sm-6 offset-lg-1">
        <div class="footer__widget">
          <h6>Truy cập nhanh</h6>
          <ul>
            <li><a href="#">Trang chủ</a></li>
            <li><a href="#">Về chúng tôi</a></li>
            <li><a href="#">Sản phẩm</a></li>
            <li><a href="#">Liên hệ</a></li>
            <li><a href="#">Đăng ký</a></li>
            <li><a href="#">Đăng nhập</a></li>
          </ul>
          <ul>
            <li><a href="#">Đăng xuất</a></li>
            <li><a href="#">Giỏ hàng</a></li>
            <li><a href="#">Áo nam</a></li>
            <li><a href="#">Áo nữ</a></li>
            <li><a href="#">Áo Polo</a></li>
            <li><a href="#">Áo khoác</a></li>
          </ul>
        </div>
      </div>
      <div class="col-lg-4 col-md-12">
        <div class="footer__widget">
          <h6>Nhập email để được tư vấn</h6>
          <p>Mọi thắc mắc hay góp ý vui lòng nhập email để được giải đáp
            và tư vấn theo yêu cầu của quý khách.</p>
          <form action="#">
            <input type="text" placeholder="Nhập email của bạn">
            <button type="submit" class="site-btn">Gửi</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</footer>

<!-- Footer Section End -->

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