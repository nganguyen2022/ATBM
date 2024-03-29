
<%@page isELIgnored="false"%>
<!doctype html>
<html class="no-js" lang="en">


<!-- Mirrored from template.hasthemes.com/ruiz/ruiz/checkout.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 06 Nov 2021 12:50:36 GMT -->


<!-- Mirrored from ruizzz.tk/checkout.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 02 Nov 2022 09:21:29 GMT -->
<!-- Added by HTTrack -->
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<!-- /Added by HTTrack -->
<head>
	<meta charset="utf-8">
	<%@ page language="java" contentType="text/html; charset=UTF-8"
			 pageEncoding="UTF-8"%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="x-ua-compatible" content="ie=edge">
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<%--  <fmt:setLocale value="vi_VN"/> --%>
	<c:set var="lg" value="${sessionScope.language}"></c:set>
	<c:if test="${lg eq 'US' }">
		<fmt:setLocale value="en_US"/>
	</c:if>
	<c:if test="${lg eq 'VN' || lg == null }">
		<fmt:setLocale value="vi_VN"/>
	</c:if>
	<fmt:setBundle basename="app" var="language"/>
	<title>Thanh toán</title>
	<meta name="robots" content="noindex, follow" />
	<meta name="description" content="">
	<meta name="viewport"
		  content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- Favicon -->
	<link rel="shortcut icon" type="image/x-icon" href="assets/images/favicon.ico">
	<link rel="stylesheet" href="<c:url value="assets/css/style.css"></c:url>">
	<!-- CSS============================================ -->
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
	<!--<link rel="stylesheet" href="assets/css/style.min.css">-->
	<link rel="stylesheet"
		  href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
	<link rel="stylesheet" href="../assets/css/main.css">
	<link rel="stylesheet" href="../assets/css/base.css">
	<link rel="stylesheet" href="../assets/css/grid.css">
	<link rel="stylesheet" href="../assets/css/rebonsive.css">
	<link rel="stylesheet"
		  href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css">
	<style>
		.dialog {
			display: none;
			position: fixed;
			top: 50%;
			left: 50%;
			transform: translate(-50%, -50%);
			background-color: white;
			padding: 20px;
			border: 1px solid #ccc;
			box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
			z-index: 999;
		}
	</style>
	<style>
		@import url('https://fonts.googleapis.com/css?family=Open+Sans&display=swap');
		body{background-color: #eeeeee;font-family: 'Open Sans',serif}

		.card{position: relative;display: -webkit-box;display: -ms-flexbox;display: flex;-webkit-box-orient: vertical;-webkit-box-direction: normal;-ms-flex-direction: column;flex-direction: column;min-width: 0;word-wrap: break-word;background-color: #fff;background-clip: border-box;border: 1px solid rgba(0, 0, 0, 0.1);border-radius: 0.10rem}
		.card-header:first-child{border-radius: calc(0.37rem - 1px) calc(0.37rem - 1px) 0 0}.card-header{padding: 0.75rem 1.25rem;margin-bottom: 0;background-color: #fff;border-bottom: 1px solid rgba(0, 0, 0, 0.1)}.track{position: relative;background-color: #ddd;height: 7px;display: -webkit-box;display: -ms-flexbox;display: flex;margin-bottom: 60px;margin-top: 50px}.track .step{-webkit-box-flex: 1;-ms-flex-positive: 1;flex-grow: 1;width: 25%;margin-top: -18px;text-align: center;position: relative}.track .step.active:before{background: #FF5722}.track .step::before{height: 7px;position: absolute;content: "";width: 100%;left: 0;top: 18px}.track .step.active .icon{background: #ee5435;color: #fff}.track .icon{display: inline-block;width: 40px;height: 40px;line-height: 40px;position: relative;border-radius: 100%;background: #ddd}.track .step.active .text{font-weight: 400;color: #000}.track .text{display: block;margin-top: 7px}.itemside{position: relative;display: -webkit-box;display: -ms-flexbox;display: flex;width: 100%}.itemside .aside{position: relative;-ms-flex-negative: 0;flex-shrink: 0}.img-sm{width: 80px;height: 80px;padding: 7px}ul.row, ul.row-sm{list-style: none;padding: 0}.itemside .info{padding-left: 15px;padding-right: 7px}.itemside .title{display: block;margin-bottom: 5px;color: #212529}p{margin-top: 0;margin-bottom: 1rem}.btn-warning{color: #ffffff;background-color: #ee5435;border-color: #ee5435;border-radius: 1px}.btn-warning:hover{color: #ffffff;background-color: #ff2b00;border-color: #ff2b00;border-radius: 1px}
	</style>
	<style>
	.btn-primary {
	background-color: #FF5722;
	color: #fff;
	padding: 10px 20px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	}

	.btn-primary:hover {
	background-color: #E64A19;
	}

	/* Style for form input fields */
	input[type="text"] {
	width: 100%;
	padding: 10px;
	margin-bottom: 15px;
	border: 1px solid #ccc;
	border-radius: 5px;
	}

	/* Add this to your existing styles or create a new CSS file */

	/* Style for Hóa đơn (Invoice) section */
	.your-order-wrapper {
		background-color: #f9f9f9;
		padding: 20px;
		border: 1px solid #ddd;
		border-radius: 5px;
	}

	.your-order-wrap {
		margin-bottom: 20px;
	}

	.your-order-table table {
		width: 100%;
		border-collapse: collapse;
		margin-top: 15px;
	}

	.your-order-table th, .your-order-table td {
		border: 1px solid #ddd;
		padding: 10px;
		text-align: left;
	}

	.your-order-table th {
		background-color: #f2f2f2;
	}

	.your-order-table tfoot {
		font-weight: bold;
	}

	.payment-method {
		margin-top: 20px;
	}

	.order-button-payment {
		text-align: right;
	}

	.btn-checkOut {
		background-color: #FF5722;
		color: #fff;
		padding: 10px 20px;
		border: none;
		border-radius: 5px;
		cursor: pointer;
	}

	.btn-checkOut:hover {
		background-color: #E64A19;
	}

	/* Additional styles can be added as needed */


	</style>

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
						<li class="breadcrumb-item">Trang chủ / Thanh toán</li>
					</ul>
					<!-- breadcrumb-list end -->
				</div>
			</div>
		</div>
	</div>
	<!-- breadcrumb-area end -->

	<form action="/DonHang" method="get">
		<!-- main-content-wrap start -->
		<div class="main-content-wrap section-ptb checkout-page">
			<div class="container">
				<div class="row">
					<div class="col">
						<div class="coupon-area">
							<!-- coupon-accordion start -->
							<!-- coupon-accordion end -->
						</div>
					</div>
				</div>
				<!-- checkout-details-wrapper start -->
				<div class="checkout-details-wrapper">
					<div class="row">
						<div class="col-lg-6 col-md-6">
							<!-- billing-details-wrap start -->
							<div class="billing-details-wrap">
								<br>
								<h3 class="shoping-checkboxt-title">Thanh toán</h3>
								<% String privateKeyError = (String) request.getAttribute("privateKeyError"); %>
                                          <% if (privateKeyError != null && !privateKeyError.isEmpty()) { %>
                                         <div class="alert alert-danger" role="alert">
                                            <%= privateKeyError %>
                                              </div>
                                  <% } %>
								<div class="row">
									<div class="col-lg-12">
										<p class="single-form-row">
											<label>Họ và tên <span class="required">*</span></label> <input
												type="text" name="Firstname">
										</p>
									</div>
									<div class="col-lg-12">
										<p class="single-form-row">
											<label for="address-details">Địa chỉ chi tiết</label>
											<input type="text" id="address-details" name="address-details">
										</p>
									</div>

									<div class="col-lg-12">
										<p class="single-form-row">
											<label>Số điện thoại<span class="required">*</span></label>
											<input type="text" name="telephone">
										</p>
									</div>
									<input type="hidden" id="idOrder" name="idOrder" value="">
									<input type="hidden" name="dateDeliveryOder" id="dateDeliveryOder" value="">
									<input type="hidden" name="addressOder" id="addressOder" value="">

										<div class="col-lg-12">
											<p class="single-form-row ">
												<label>Ghi chú<span class="required">*</span></label> <input
													type="text" name="note"
													placeholder="Hãy ghi chú cho đơn hàng của bạn"
													rows="2" cols="5">
											</p>
										</div>
										<div class="col-lg-12">
                                                                                   <p class="single-form-row ">
                                                                                     <label>Phương thức thanh toán<span class="required">*</span></label>
                                                                                     <div class="payment-method">
                                                                                          <div class="form-check">
                                                                                               <input type="radio" class="form-check-input" name="paymentMethod" id="onlinePayment" value="online"
                                                                                                onclick="updatePaymentStatus('1')" checked>
                                                                                                <label class="form-check-label" for="onlinePayment">Thanh toán online</label>
                                                                                          </div>
                                                                                          <div class="form-check">
                                                                                               <input type="radio" class="form-check-input" name="paymentMethod" id="offlinePayment" value="offline"
                                                                                               onclick="updatePaymentStatus('0')">
                                                                                               <label class="form-check-label" for="offlinePayment">Thanh toán khi nhận hàng</label>
                                                                                          </div>
                                                                                     </div>
                                                                                   </p>
                                                                                </div>
								</div>
								<div class="containera">
										<div class="form-group">

											<label for="prikey">Nhập private key của bạn:</label><br>
											<input type="text" id="prikey" name="prikey" required>
										</div>
								</div>
								<div class="dialog">

									<p class="dialong__title">Xác nhận</p>
									<div class="dialog__main">
										<p class="dialog__text">Bạn có muốn thanh toán?</p>
										<button class="dialog__btn " type="button">Hủy</button>
										<button class="dialog__btn dialog__btn-ok" type="submit">Đồng ý</button>
									</div>
								</div>
							</div>
							<!-- billing-details-wrap end -->
						</div>
						<div class="col-lg-6 col-md-6">
							<!-- your-order-wrapper start -->
							<div class="your-order-wrapper">
								<h3 class="shoping-checkboxt-title">Hóa đơn</h3>
								<!-- your-order-wrap start-->
								<div class="your-order-wrap">
									<!-- your-order-table start -->
									<div class="your-order-table table-responsive">
										<table>
											<thead>
											<tr>
												<th class="product-name">Sản phẩm</th>
												<th class="product-total">Tổng tiền</th>
											</tr>
											</thead>
											<tbody>
											<c:forEach items="${sessionScope.cart}" var="item">
												<tr class="cart_item">
													<td class="product-name">${item.value.nameP}<strong
															class="product-quantity"> x
															${item.value.quantity}</strong>
													</td>
													<td class="product-total"><span class="amount">${item.value.total}00
																₫</span></td>
												</tr>
											</c:forEach>
											</tbody>
											<tfoot>
											<tr class="cart-subtotal">
												<th>Tổng tiền</th>
												<td><span class="amount" id="total">${sessionScope.total}</span>00
													₫</td>
											</tr>
											<tr class="shipping">
												<th>Phí vận chuyển</th>
												<td><span class="amount" id="fee" name="fee">
													<c:out value="${sessionScope.fee}"/></span>00 ₫
												</td>
											</tr>

											<tr class="order-total">
												<th>Tổng hóa đơn</th>
												<td><strong><span class="amount" id="totalPrice">${sessionScope.fullPrice}</span>00
													₫</strong></td>
											</tr>

											</tfoot>
										</table>
									</div>

									<!-- your-order-table end -->

									<!-- your-order-wrap end -->
									<div class="payment-method">
										<div class="order-button-payment ">
											<input class="btn-primary btn-checkOut" type="button" value="Thanh toán">
										</div>
									</div>
									<!-- your-order-wrapper start -->

								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- checkout-details-wrapper end -->
			</div>
		</div>
		<!-- main-content-wrap end -->
	</form>
	<!-- footer Start -->
	<!-- footer End -->
</div>
<jsp:include page="/footer.jsp"></jsp:include>



<!-- JS
============================================ -->
<!-- Modernizer JS -->
<script src="product/assets/js/vendor/modernizr-3.6.0.min.js"></script>
<!-- jquery -->

<!-- jquery -->
<script src="product/assets/js/vendor/jquery-3.5.1.min.js"></script>
<script src="product/assets/js/vendor/jquery-migrate-3.3.0.min.js"></script>


<!-- Bootstrap JS -->
<script src="product/assets/js/vendor/popper.min.js"></script>
<script src="product/assets/js/vendor/bootstrap.min.js"></script>

<!-- Plugins JS -->
<script src="product/assets/js/plugins/slick.min.js"></script>

<script src="product/assets/js/plugins/jquery.nice-select.min.js"></script>
<script src="product/assets/js/plugins/countdown.min.js"></script>
<script src="product/assets/js/plugins/image-zoom.min.js"></script>
<script src="product/assets/js/plugins/fancybox.js"></script>
<script src="product/assets/js/plugins/scrollup.min.js"></script>
<script src="product/assets/js/plugins/jqueryui.min.js"></script>
<script src="product/assets/js/plugins/ajax-contact.js"></script>



<!-- Vendor & Plugins JS (Please remove the comment from below vendor.min.js & plugins.min.js for better website load performance and remove js files from avobe) -->
<!--
<script src="assets/js/vendor/vendor.min.js"></script>
<script src="assets/js/plugins/plugins.min.js"></script>
-->

<!-- Main JS -->
<script src="product/assets/js/main.js"></script>
<script>
	// JavaScript code to handle the confirmation dialog
	document.addEventListener("DOMContentLoaded", function () {
		var dialog = document.querySelector(".dialog");
		var btnThanhToan = document.querySelector(".btn-checkOut");

		btnThanhToan.onclick = function () {
			// Show the dialog when the button is clicked
			dialog.style.display = 'block';
		};

		// Add event listeners for the dialog buttons
		var btnCancel = document.querySelector(".dialog__btn");
		var btnConfirm = document.querySelector(".dialog__btn-ok");

		btnCancel.onclick = function () {
			// Hide the dialog when "Hủy" (Cancel) button is clicked
			dialog.style.display = 'none';
		};

		btnConfirm.onclick = function () {
			// Submit the form when "Đồng ý" (OK) button is clicked
			document.forms[0].submit();
		};
	});
</script>
<script>
	// Khi trang web được tải, đặt giá trị ngẫu nhiên cho trường idOrder
	document.getElementById("idOrder").value = generateRandomString(5);

	// Hàm tạo UUID
	function generateRandomString(length) {
		var result = '';
		var characters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
		var charactersLength = characters.length;
		for (var i = 0; i < length; i++) {
			result += characters.charAt(Math.floor(Math.random() * charactersLength));
		}
		return result;
	}
</script>

<script>
        document.getElementById("image").addEventListener("change", function() {
            var preview = document.getElementById("preview");
            var file = this.files[0];

            if (file) {
                var reader = new FileReader();

                reader.addEventListener("load", function() {
                    preview.style.display = "block";
                    preview.src = reader.result;
                });

                reader.readAsDataURL(file);
            } else {
                preview.style.display = "none";
            }
        });
    </script>
    <script>
                    function updatePaymentStatus(status) {

                        document.getElementById("paymentStatus").value = status;


                        document.forms[0].submit();
                    }
                </script>
</body>

<!-- Mirrored from template.hasthemes.com/ruiz/ruiz/checkout.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 06 Nov 2021 12:50:36 GMT -->


<!-- Mirrored from ruizzz.tk/checkout.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 02 Nov 2022 09:21:30 GMT -->
</html>