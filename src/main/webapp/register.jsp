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
    <style>
        .form-check {
            display: flex;
            align-items: center; /* Align checkboxes vertically centered */
            justify-content: space-between;
            margin-bottom: 15px; /* Adjust the margin between the checkbox group and other elements */
        }

        .form-check-left,
        .form-check-right {
            display: flex;
            align-items: center; /* Align checkboxes vertically centered */
        }

        .form-check-right {
            margin-left: auto; /* Push the right checkbox to the right */
        }
    </style>
</head>
<body>
<!-- Header Section Begin -->
<c:import url="/header/header.jsp" />
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
                    <!-- ... (previous HTML code) ... -->
                    <form action="RegisterServlet" method="POST">
                        <fieldset class="p-4">
                            <p class="text-danger">${messuname}</p>
                            <p class="text-danger">${messmail }</p>
                            <p class="text-danger">${mess }</p>
                            <p class="text-danger">${messpass }</p>
                            <p class="text-danger">${messkeys}</p>
                            <p class="text-danger">${userexit }</p>
                            <label><b>Họ và tên*</b></label>
                            <input name="full_name" type="text" placeholder="Họ và tên" class="border p-3 w-100 my-2">
                            <label><b>Tên đăng ký*</b></label>
                            <input name="name" type="text" placeholder="Tên đăng nhập" class="border p-3 w-100 my-2">
                            <label><b>Email*</b></label>
                            <input name="email" type="email" placeholder="Email" class="border p-3 w-100 my-2">
                            <label><b>Số điện thoại*</b></label>
                            <input name="phone" type="text" placeholder="Nhập số điện thoại" class="border p-3 w-100 my-2">
                            <label><b>Địa chỉ*</b></label>
                            <input name="address" type="text" placeholder="Địa chỉ" class="border p-3 w-100 my-2">
                            <label><b>Mật khẩu*</b></label>
                            <input name="pass" type="password" placeholder="Mật khẩu" class="border p-3 w-100 my-2">
                            <label><b>Nhập lại mật khẩu*</b></label>
                            <input name="repass" type="password" placeholder="Nhập lại mật khẩu" class="border p-3 w-100 my-2">
                            <div class="form-check my-2">
                                <div class="form-check-left">
                                    <input class="form-check-input key-checkbox" type="checkbox" id="alreadyHaveAccount" name="alreadyHaveAccount">
                                    <label class="form-check-label" for="alreadyHaveAccount">
                                        Đã có khóa
                                    </label>
                                </div>
                                <div class="form-check-right">
                                    <input class="form-check-input key-checkbox" type="checkbox" id="noKey" name="noKey">
                                    <label class="form-check-label" for="noKey">
                                        Chưa có khóa
                                    </label>
                                </div>
                            </div>
                            <!-- ... (previous HTML code) ... -->

                            <div id="keyFields" style="display: none;">
                                <label><b>Public Key*</b></label>
                                <input id="publicKey" name="publicKey" type="text" placeholder="Public Key" class="border p-3 w-100 my-2">
                                <label><b>Private Key*</b></label>
                                <input id="privateKey" name="privateKey" type="text" placeholder="Private Key" class="border p-3 w-100 my-2">
                            </div>

                            <div id="otherKeyFields" style="display: none;">
                                <label><b>Public Key*</b></label>
                                <input name="publicKey" type="text" placeholder="Public Key" class="border p-3 w-100 my-2">
                                <label><b>Private Key*</b></label>
                                <input name="privateKey" type="text" placeholder="Private Key" class="border p-3 w-100 my-2">
                            </div>
                            <label>*Sau khi đăng ký thành công khóa của bạn sẽ được lưu với đường dẫn D:\KEYS\</label>
                            <button class="btn btn-primary btn-block border-0 py-3" type="submit">Đăng ký</button>

                        </fieldset>
                    </form>
                    <!-- ... (remaining HTML code) ... -->

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
<script>
    function toggleKeyFields(checkbox) {
        var keyCheckboxes = document.querySelectorAll('.key-checkbox');
        var keyFields = document.getElementById('keyFields');
        var otherKeyFields = document.getElementById('otherKeyFields');
        var publicKeyInput = document.getElementById('publicKey');
        var privateKeyInput = document.getElementById('privateKey');

        keyCheckboxes.forEach(function (otherCheckbox) {
            if (otherCheckbox !== checkbox && otherCheckbox.checked) {
                otherCheckbox.checked = false;
            }
        });

        // Check if at least one of the key checkboxes is checked
        var isChecked = Array.from(keyCheckboxes).some(checkbox => checkbox.checked);

        keyFields.style.display = isChecked ? 'block' : 'none';
        otherKeyFields.style.display = isChecked ? 'none' : 'block';

        if (isChecked) {
            // If at least one checkbox is checked
            publicKeyInput.value = '';
            privateKeyInput.value = '';

            if (checkbox.id === 'noKey' && checkbox.checked) {
                // Random key when "Chưa có khóa" is selected
                generateRandomKey();
            }
        } else {
            // If no checkbox is checked, hide the key input fields
            publicKeyInput.value = '';
            privateKeyInput.value = '';
        }
    }

    // function toggleKeyFields(checkbox) {
    //     var keyCheckboxes = document.querySelectorAll('.key-checkbox');
    //     var keyFields = document.getElementById('keyFields');
    //     var otherKeyFields = document.getElementById('otherKeyFields');
    //     var publicKeyInput = document.getElementById('publicKey');
    //     var privateKeyInput = document.getElementById('privateKey');
    //
    //     keyCheckboxes.forEach(function (otherCheckbox) {
    //         if (otherCheckbox !== checkbox && otherCheckbox.checked) {
    //             otherCheckbox.checked = false;
    //         }
    //     });
    //
    //     // Check if at least one of the key checkboxes is checked
    //     var isChecked = Array.from(keyCheckboxes).some(checkbox => checkbox.checked);
    //
    //     keyFields.style.display = isChecked ? 'block' : 'none';
    //     otherKeyFields.style.display = isChecked ? 'none' : 'block';
    //
    //     if (isChecked) {
    //         // Chưa có khóa được chọn, random khóa và điền vào input
    //         publicKeyInput.value = '';
    //         privateKeyInput.value = '';
    //
    //         if (checkbox.id === 'noKey' && checkbox.checked) {
    //             // Random khóa khi chọn "Chưa có khóa"
    //             generateRandomKey();
    //         }
    //     }
    // }

    function generateRandomKey() {
        // Gọi servlet để lấy khóa ngẫu nhiên từ máy chủ
        // Sử dụng fetch API để thực hiện điều này
        fetch('/RandomKeyServlet')
            .then(response => response.json())
            .then(data => {
                // Điền khóa vào ô input
                document.getElementById('publicKey').value = data.publicKey;
                document.getElementById('privateKey').value = data.privateKey;
            })
            .catch(error => console.error('Error:', error));
    }

    document.querySelectorAll('.key-checkbox').forEach(function (checkbox) {
        checkbox.addEventListener('change', function () {
            toggleKeyFields(checkbox);
        });
    });
    // document.querySelectorAll('.key-checkbox').forEach(function (checkbox) {
    //     checkbox.addEventListener('change', function () {
    //         toggleKeyFields(checkbox);
    //     });
    // });

</script>
</body>
</html>