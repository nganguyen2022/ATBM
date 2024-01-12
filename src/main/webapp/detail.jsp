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
  <title>Chi tiết</title>

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
<!-- Product Details Section Begin -->
<section class="product-details spad">
  <div class="container">
    <div class="row">
      <div class="col-lg-6 col-md-6">
        <div class="product__details__pic">
          <div class="product__details__pic__item">
            <img class="product__details__pic__item--large"
                 src="${detail.img }" alt="">
          </div>
        </div>
      </div>
      <div class="col-lg-6 col-md-6">
        <div class="product__details__text">
          <h3>${detail.pName }</h3>
          <div class="product__details__rating">
            <i class="fa fa-star"></i>
            <i class="fa fa-star"></i>
            <i class="fa fa-star"></i>
            <i class="fa fa-star"></i>
            <i class="fa fa-star-half-o"></i>
            <span>(18 reviews)</span>
          </div>
          <form action="/product/CartServlet?maSP=${detail.pID}&action=Them" method="post">
            <div class="product__details__price">${detail.price }00 VNĐ</div>
            <p>${detail.description }</p>
            <div class="product__details__quantity">
              <div class="quantity">
                <div class="pro-qty">
                  <input type="number" value="1" min="1" name="quantity">
                </div>
              </div>
            </div>

            <input type="hidden" name="productCode"
                   value="<c:out value='${detail.pID}'/>">
            <button class="primary-btn" type="submit">Thêm vào giỏ hàng</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</section>
<!-- Product Details Section End -->

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