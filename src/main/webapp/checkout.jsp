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
  <title>Thanh toán</title>

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
<c:import url="header.jsp" />
<!-- Header Section End -->

<!-- Checkout Section Begin -->
<section class="checkout spad">
  <div class="container">
    <h2>HÓA ĐƠN CỦA BẠN</h2>
    <div class="checkout__form">
      <h4>Chi tiết hóa đơn</h4>
      <form action="#">
        <div class="row">
          <div class="col-lg-8 col-md-6">
            <div class="row">
              <div class="col-lg-6">
                <div class="checkout__input">
                  <p>
                    Name<span>*</span>
                  </p>
                  <input type="text" value="${sessionScope.user.uname }">
                </div>
              </div>
              <div class="col-lg-6">
                <div class="checkout__input">
                  <p>
                    Email<span>*</span>
                  </p>
                  <input type="text" value="${sessionScope.user.email }">
                </div>
              </div>
            </div>
          </div>
          <div class="col-lg-4 col-md-6">
            <div class="checkout__order">
              <h4>Sản phẩm của bạn</h4>
              <div class="checkout__order__products">
                Sản phẩm <span>Tổng</span>
              </div>
              <ul>
                <c:set var="total" value="0"></c:set>
                <c:forEach items="${cart.items }" var="item">
                  <c:set var="total"
                         value="${total + item.product.price * item.quantity }"></c:set>
                  <li>${item.product.pName }<span>${item.product.price }VNĐ</span></li>
                </c:forEach>
              </ul>
              <div class="checkout__order__total">
                Tổng tiền <span>${total }VNĐ</span>
              </div>
              <a href="OrderServlet" type="submit" class="site-btn">XÁC NHẬN</a>
            </div>
          </div>
        </div>
      </form>
    </div>
  </div>
</section>


<!-- Checkout Section End -->
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