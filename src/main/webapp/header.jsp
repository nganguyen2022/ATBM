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
  <title>Header</title>

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

<body>

<!-- Header Section Begin -->
<header class="header">
  <div class="header__top">
    <div class="container">
      <div class="row">
        <div class="col-lg-6 col-md-6">
          <div class="header__top__left">
            <c:if test="${sessionScope.user != null}">
              <ul>
                <li><i class="fa fa-envelope"></i>Hello
                    ${sessionScope.user.uname }</li>
                <li>Hoạt động từ 7:00 - 21:00</li>
              </ul>
            </c:if>
          </div>
        </div>
        <div class="col-lg-6 col-md-6">
          <div class="header__top__right">
            <c:if test="${sessionScope.user == null}">
              <div class="header__top__right__auth">
                <a href="register.jsp"><i class="fa fa-user-plus"></i> Đăng
                  ký</a>
              </div>
              <div class="header__top__right__auth">
                <a href="login.jsp"><i class="fa fa-user"></i> Đăng nhập</a>
              </div>
            </c:if>
            <c:if test="${sessionScope.user != null}">
              <div class="header__top__right__auth">
                <a href="LogoutServlet"><i class="fa fa-power-off"></i>
                  Đăng xuất</a>
              </div>
            </c:if>

          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="container">
    <div class="row">
      <div class="col-lg-3">
        <div class="header__logo">
          <a href="#"><img src="images/logo2.jpg" alt=""></a>
        </div>
      </div>
      <div class="col-lg-6">
        <nav class="header__menu">
          <ul>
            <li class="active"><a href="index.jsp">Trang chủ</a></li>
            <li><a href="ProductServlet">Sản phẩm</a></li>
            <c:if test="${sessionScope.user.isUser == 0}">
            <li><a href="ManagerProServlet">Quản lý SP</a>
              </c:if>
              <c:if test="${sessionScope.user.isUser == 1}">

              </c:if>
            <li><a href="contact.jsp">Liên hệ</a></li>
          </ul>
        </nav>
      </div>
      <div class="col-lg-3">
        <div class="header__cart">
          <ul>
            <li><a href="shoppingcart.jsp"><i class="fa fa-shopping-bag"></i> <span></span></a></li>
          </ul>

        </div>
      </div>
    </div>
    <div class="humberger__open">
      <i class="fa fa-bars"></i>
    </div>
  </div>
</header>
<!-- Header Section End -->

<!-- Hero Section Begin -->
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

</body>
</html>