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
  <title>Giỏ hàng</title>

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

<!-- Shoping Cart Section Begin -->
<section class="shoping-cart spad">
  <div class="container">
    <div class="row">
      <div class="col-lg-12">
        <div class="shoping__cart__table">
          <h2>GIỎ HÀNG</h2><br>
          <table>
            <thead>
            <tr>
              <th class="shoping__product">Sản phẩm</th>
              <th>Giá</th>
              <th>Số lượng</th>
              <th>Tổng tiền</th>
              <th></th>
            </tr>
            </thead>
            <tbody>
            <c:set var="total" value="0"></c:set>
            <c:forEach items="${cart.items }" var="item">
              <c:set var="total" value="${total + item.product.price * item.quantity }"></c:set>
              <tr>
                <td class="shoping__cart__item"><img
                        src="${item.product.img }" alt="">
                  <h5>${item.product.pName }</h5></td>
                <td class="shoping__cart__price">${item.product.price }VNĐ</td>
                <td class="shoping__cart__quantity">
                  <form action="" method="post">
                    <input type="hidden" name="productCode"
                           value="<c:out value='${item.product.pID}'/>">
                    <input name="quantity" type="text" value="${item.quantity}">
                  </form>
                </td>
                <td class="shoping__cart__total">${item.totalCurrencyFormat} VNĐ</td>
                <td class="shoping__cart__item__close">
                  <form action="" method="post">
                    <input type="hidden" name="productCode"
                           value="<c:out value='${item.product.pID}'/>"> <input
                          type="hidden" name="quantity" value="0"> <input
                          class="primary-btn cart-btn" type="submit" value="Xóa">
                  </form>
                </td>
              </tr>

            </c:forEach>

            </tbody>
          </table>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-lg-12">
        <div class="shoping__cart__btns">
          <a href="ProductServlet" class="primary-btn cart-btn">TIẾP TỤC
            MUA SẮM</a>

        </div>
      </div>
      <div class="col-lg-6">

      </div>
      <div class="col-lg-6">
        <div class="shoping__checkout">
          <h5>Tổng tiền giỏ hàng</h5>
          <ul>
            <li>Tổng tiền <span>${total }VNĐ</span></li>
          </ul>
          <form action="" method="post">
            <input type="hidden" name="action" value="checkout"> <input
                  type="submit" class="primary-btn" value="THANH TOÁN">
          </form>
          <!-- <a href="#" name="action" class="primary-btn">THANH TOÁN</a> -->
        </div>
      </div>
    </div>
  </div>
</section>
<!-- Shoping Cart Section End -->

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