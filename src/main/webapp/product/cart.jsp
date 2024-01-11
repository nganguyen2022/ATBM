<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<!doctype html>
<html class="no-js" lang="en">


<!-- Mirrored from template.hasthemes.com/ruiz/ruiz/cart.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 06 Nov 2021 12:50:36 GMT -->


<!-- Mirrored from ruizzz.tk/cart.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 02 Nov 2022 09:21:23 GMT -->
<!-- Added by HTTrack --><meta http-equiv="content-type" content="text/html;charset=utf-8" /><!-- /Added by HTTrack -->
<head>
	
    <meta charset="utf-8">
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%--  <fmt:setLocale value="vi_VN"/> --%> 
	<c:set var="lg" value="${sessionScope.language}"></c:set>
	<c:if test="${lg eq 'US' }">
	 <fmt:setLocale value="en_US"/>
	</c:if>
	<c:if test="${lg eq 'VN' || lg == null }">
	 <fmt:setLocale value="vi_VN"/>
	</c:if>

    <title>Giỏ hàng</title>
    <meta name="robots" content="noindex, follow" />
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Favicon -->
    <link rel="shortcut icon" type="image/x-icon" href="assets/images/favicon.ico">
    <!-- CSS											
	============================================ -->

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="assets/css/vendor/bootstrap.min.css">
    <!-- Icon Font CSS -->
    <link rel="stylesheet" href="assets/css/vendor/font-awesome.min.css">
    <link rel="stylesheet" href="assets/css/vendor/simple-line-icons.css">

    <!-- Plugins CSS -->
    <link rel="stylesheet" href="assets/css/plugins/animation.css">
    <link rel="stylesheet" href="assets/css/plugins/slick.css">
    <link rel="stylesheet" href="assets/css/plugins/animation.css">
    <link rel="stylesheet" href="assets/css/plugins/nice-select.css">
    <link rel="stylesheet" href="assets/css/plugins/fancy-box.css">
    <link rel="stylesheet" href="assets/css/plugins/jqueryui.min.css">

    <!-- Vendor & Plugins CSS (Please remove the comment from below vendor.min.css & plugins.min.css for better website load performance and remove css files from avobe) -->
    <!--
    <script src="assets/js/vendor/vendor.min.js"></script>
    <script src="assets/js/plugins/plugins.min.js"></script>
    -->

    <!-- Main Style CSS (Please use minify version for better website load performance) -->
    <link rel="stylesheet" href="assets/css/style.css">
    <link rel="stylesheet" href="assets/css/cart.css">
    <!--<link rel="stylesheet" href="assets/css/style.min.css">-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
    <link rel="stylesheet" href="../assets/css/main.css">
    <link rel="stylesheet" href="../assets/css/base.css">
    <link rel="stylesheet" href="../assets/css/grid.css">
    <link rel="stylesheet" href="../assets/css/rebonsive.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css">

</head>

<body>
<jsp:include page="/header/header.jsp"></jsp:include>
    <div class="main-wrapper">

        <!--  Header Start -->
            <!-- breadcrumb-area start -->
            <div class="breadcrumb-area"  style="margin-top: var(--header-height)">
                <div class="container">
                    <div class="row">
                        <div class="col-12">
                            <!-- breadcrumb-list start -->
                            <ul class="breadcrumb-list">
                                <li class="breadcrumb-item">Trang chủ</li>
                                <li class="breadcrumb-item active">Giỏ hàng</li>
                            </ul>
                            <!-- breadcrumb-list end -->
                        </div>
                    </div>
                </div>
            </div>
            <!-- breadcrumb-area end -->

            <!-- main-content-wrap start -->
            <div class="main-content-wrap section-ptb cart-page">
                <div class="container">
                    <div class="row">
                        <div class="col-12">
                                <div class="table-content table-responsive">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th class="plantmore-product-thumbnail">Hình ảnh</th>
                                                <th class="cart-product-name">Sản phẩm</th>
                                                <th class="plantmore-product-price">Giá</th>
                                                <th class="plantmore-product-quantity">Số lượng</th>
                                                <th class="plantmore-product-subtotal">Tổng tiền</th>
                                                <th class="plantmore-product-remove">Xóa</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${sessionScope.cart}" var="item" >
                                            <p class="text-danger">${errorMessage}</p>
                                            <tr>
                                                <td class="plantmore-product-thumbnail thumbnail"><a href="<c:url value="/DetailServlet?maSP=${item.value.idP}"></c:url>"><img

                                                            src="${item.value.nameImage}" alt=""></a></td>

                                                <td class="plantmore-product-name"><a href="<c:url value="/DetailServlet?maSP=${item.value.idP}"></c:url>">${item.value.nameP}</a></td>
                                                <td class="plantmore-product-price"><span class="amount">${item.value.price}00
                                                        ₫</span></td>
                                                <td class="plantmore-product-quantity">
                                                <form method="post" action="<c:url value="/product/CartServlet?maSP=${item.value.idP}&action=Update"></c:url>">
                                                	<input name="quantity" value="${item.value.quantity}" type="number">
                                                	<button type="submit">Cập nhật</button>
                                                </form>
                                                    
                                                </td>
                                                <td class="product-subtotal"><span class="amount">${item.value.total}00 ₫</span>
                                                </td>
                                                <td class="plantmore-product-remove"><a href="<c:url value="/product/CartServlet?maSP=${item.value.idP}&action=Xoa"></c:url>"><i
                                                            class="fa fa-times"></i></a></td>  
                                            </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                <div class="row">
                                    <div class="col-md-8">
                                        <div class="coupon-all">
                                            <div class="coupon2">

                                                <a href=" <c:url value="/ProductServlet"></c:url>" class=" continue-btn btn-primary">Tiếp tục mua sắm</a>
                                            </div>
                                        </div>
                                            <ul>
                                                <div >
<%--                                                <li><fmt:message key= "assets.Summs" bundle="${language}"></fmt:message> <span>--%>
                                                    <p>Tổng tiền: <span id="totalMoney">${sessionScope.total}</span>00 ₫</p>
<%--    </span></li>--%>
                                                </div>
                                            </ul>
                                            <a href=" <c:url value="/checkout"></c:url>" class="proceed-checkout-btn btn-primary">Thanh toán</a>
                                        </div>
                                    </div>
                                </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- main-content-wrap end -->
            <!-- footer Start -->

            <!-- footer End -->


    </div>
<jsp:include page="/footer.jsp"></jsp:include>

    <!-- JS
============================================ -->

    <!-- Modernizer JS -->
    <script src="assets/js/vendor/modernizr-3.6.0.min.js"></script>
    <!-- jquery -->

    <!-- jquery -->
    <script src="assets/js/vendor/jquery-3.5.1.min.js"></script>
    <script src="assets/js/vendor/jquery-migrate-3.3.0.min.js"></script>


    <!-- Bootstrap JS -->
    <script src="assets/js/vendor/popper.min.js"></script>
    <script src="assets/js/vendor/bootstrap.min.js"></script>

    <!-- Plugins JS -->
    <script src="assets/js/plugins/slick.min.js"></script>

    <script src="assets/js/plugins/jquery.nice-select.min.js"></script>
    <script src="assets/js/plugins/countdown.min.js"></script>
    <script src="assets/js/plugins/image-zoom.min.js"></script>
    <script src="assets/js/plugins/fancybox.js"></script>
    <script src="assets/js/plugins/scrollup.min.js"></script>
    <script src="assets/js/plugins/jqueryui.min.js"></script>
    <script src="assets/js/plugins/ajax-contact.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <!-- Vendor & Plugins JS (Please remove the comment from below vendor.min.js & plugins.min.js for better website load performance and remove js files from avobe) -->
    <!--
<script src="assets/js/vendor/vendor.min.js"></script>
<script src="assets/js/plugins/plugins.min.js"></script>
-->

    <!-- Main JS -->
    <script src="assets/js/main.js"></script>

</body>


<!-- Mirrored from template.hasthemes.com/ruiz/ruiz/cart.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 06 Nov 2021 12:50:36 GMT -->


<!-- Mirrored from ruizzz.tk/cart.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 02 Nov 2022 09:21:24 GMT -->
</html>