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
  <title>Trang chủ</title>

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

<!-- Contact Section Begin -->
<section class="contact spad">
  <div class="container">
    <div class="row">
      <div class="col-lg-3 col-md-3 col-sm-6 text-center">
        <div class="contact__widget">
          <span class="icon_phone"></span>
          <h4>Điện thoại</h4>
          <p>+01-3-8888-6868</p>
        </div>
      </div>
      <div class="col-lg-3 col-md-3 col-sm-6 text-center">
        <div class="contact__widget">
          <span class="icon_pin_alt"></span>
          <h4>Địa chỉ</h4>
          <p>Khu phố 6, Linh Trung, Thủ Đức, TP.HCM</p>
        </div>
      </div>
      <div class="col-lg-3 col-md-3 col-sm-6 text-center">
        <div class="contact__widget">
          <span class="icon_clock_alt"></span>
          <h4>Thời gian mở cửa</h4>
          <p>7:00 - 21:00</p>
        </div>
      </div>
      <div class="col-lg-3 col-md-3 col-sm-6 text-center">
        <div class="contact__widget">
          <span class="icon_mail_alt"></span>
          <h4>Email</h4>
          <p>hello@colorlib.com</p>
        </div>
      </div>
    </div>
  </div>
</section>
<!-- Contact Section End -->

<!-- Map Begin -->
<div class="map">
  <iframe
          src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d31346.675175427183!2d106.7667278873347!3d10.862150701782202!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3174d88215693361%3A0x95009cc1803a7e51!2zTGluaCBUcnVuZywgVGjhu6cgxJDhu6ljLCBUaMOgbmggcGjhu5EgSOG7kyBDaMOtIE1pbmgsIFZp4buHdCBOYW0!5e0!3m2!1svi!2s!4v1641470485107!5m2!1svi!2s"
          height="500" style="border: 0;" allowfullscreen=""
          aria-hidden="false" tabindex="0"></iframe>

</div>
<!-- Map End -->

<!-- Contact Form Begin -->
<div class="contact-form spad">
  <div class="container">
    <div class="row">
      <div class="col-lg-12">
        <div class="contact__form__title">
          <h2>Liên hệ</h2>
        </div>
      </div>
    </div>
    <form action="#">
      <div class="row">
        <div class="col-lg-6 col-md-6">
          <input type="text" placeholder="Tên của bạn">
        </div>
        <div class="col-lg-6 col-md-6">
          <input type="text" placeholder="Email của bạn">
        </div>
        <div class="col-lg-12 text-center">
          <textarea placeholder="Lời nhắn của bạn"></textarea>
          <button type="submit" class="site-btn">Gửi</button>
        </div>
      </div>
    </form>
  </div>
</div>
<!-- Contact Form End -->
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