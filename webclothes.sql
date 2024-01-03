-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 27, 2023 lúc 10:23 AM
-- Phiên bản máy phục vụ: 10.4.27-MariaDB
-- Phiên bản PHP: 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `webclothes`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `categories`
--

CREATE TABLE `categories` (
  `cateId` char(5) NOT NULL,
  `cateName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `categories`
--

INSERT INTO `categories` (`cateId`, `cateName`) VALUES
('AK', 'Áo khoác'),
('AN', 'Áo nam'),
('NU', 'Áo nữ'),
('P', 'Áo Polo');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `detailorder`
--

CREATE TABLE `detailorder` (
  `idOrder` varchar(5) NOT NULL,
  `pId` char(5) NOT NULL,
  `amount` int(11) DEFAULT NULL,
  `price` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `detailorder`
--

INSERT INTO `detailorder` (`idOrder`, `pId`, `amount`, `price`) VALUES
('1g9m7', 'AK1', 1, 155),
('1g9m7', 'AK3', 1, 125),
('kaCYL', 'AK4', 1, 205),
('UIH67', 'AK4', 2, 410),
('VsSG1', 'AK2', 2, 350);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `orderproduct`
--

CREATE TABLE `orderproduct` (
  `idOrder` varchar(5) NOT NULL,
  `nameAcc` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `dateOrder` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `dateDelivery` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `totalMoney` float DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `nameRecipient` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `note` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `checkout` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `status` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `orderproduct`
--

INSERT INTO `orderproduct` (`idOrder`, `nameAcc`, `dateOrder`, `dateDelivery`, `totalMoney`, `phone`, `nameRecipient`, `address`, `note`, `checkout`, `status`) VALUES
('1g9m7', 'hy', '2023-12-26', '', 300, '0356481529', 'hy', 'Ha nội,', 'giao hang nhanh', '0', 1),
('kaCYL', 'hy', '2023-12-26', '', 225, '1234567789', 'hu', 'tr,', 'sd', '0', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product`
--

CREATE TABLE `product` (
  `pId` char(5) NOT NULL,
  `pName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` float DEFAULT NULL,
  `pDescription` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `cateId` char(5) DEFAULT NULL,
  `img` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `product`
--

INSERT INTO `product` (`pId`, `pName`, `price`, `pDescription`, `cateId`, `img`) VALUES
('AK1', 'Áo khoác dù nam màu nâu', 155, 'Chất liệu vải Linen, nhẹ, thoát nhiệt tốt, nhanh khô.', 'AK', 'http://localhost:8080/ATBM/src/main/webapp/images/ak1.jpg'),
('AK2', 'Áo khoác dù nam màu đen', 175, 'Chất liệu vải Cotton, mềm, thoáng khí, thấm hút mồ hôt tốt.', 'AK', 'http://localhost:8080/ATBM/src/main/webapp/images/ak2.jpg'),
('AK3', 'Áo khoác nỉ đen dày dặn', 125, 'Chất liệu vải lanh, chắc chắn, bóng mượt hơn vải Cotton.', 'AK', 'http://localhost:8080/ATBM/src/main/webapp/images/ak3.jpg'),
('AK4', 'Áo khoác dù cổ tròn', 205, 'Chất liệu vải Polyester, chống nước nhẹ thoải mái, cản gió.', 'AK', 'http://localhost:8080/ATBM/src/main/webapp/images/ak4.jpg'),
('AK5', 'Áo khoác có mũ 4 màu', 115, 'Chất liệu vải Len và Len pha, tự nhiên thoáng khí, cách nhiệt tốt.', 'AK', 'http://localhost:8080/ATBM/src/main/webapp/images/ak5.jpg'),
('AK6', 'Áo Hoodie xanh ngọc', 185, 'Chất liệu vải Cashmere, nhẹ, mềm, không bị xước, dễ đàn hồi.', 'AK', 'http://localhost:8080/ATBM/src/main/webapp/images/ak6.jpg'),
('AK7', 'Áo khoác nữ màu nâu', 215, 'Chất liệu vải Cotton, mềm, thoáng khí, thấm hút mồ hôt tốt.', 'AK', 'http://localhost:8080/ATBM/src/main/webapp/images/ak7.jpg'),
('AK8', 'Áo khoác nữ jeans', 145, 'Chất liệu vải jeans, chắc chắn, .', 'AK', 'http://localhost:8080/ATBM/src/main/webapp/images/ak8.jpg'),
('AN01', 'Áo thun tay ngắn', 80, 'Chất liệu cải Modal, mềm mịn, co giãn, hút ẩm tốt.', 'AN', 'http://localhost:8080/ATBM/src/main/webapp/images/men1.jpg'),
('AN02', 'Áo thun HONGKONG', 75, 'Chất liệu vải Rayon, mềm mịn, thoáng khí.', 'AN', 'http://localhost:8080/ATBM/src/main/webapp/images/men2.jpg'),
('AN03', 'Áo thun nam đen', 100, 'Chất liệu PE, dày dặn.', 'AN', 'http://localhost:8080/ATBM/src/main/webapp/images/men3.jpg'),
('AN04', 'Thun nam trắng đen', 65, 'Chất liệu vải Rayon, mềm mịn, thoáng khí.', 'AN', 'http://localhost:8080/ATBM/src/main/webapp/images/men4.jpg'),
('AN05', 'Thun nam cổ trụ', 95, 'Chất liệu vải Cotton, thấm hút tốt, mát mẻ.', 'AN', 'http://localhost:8080/ATBM/src/main/webapp/images/men5.jpg'),
('AN06', 'Thun nam 1973', 85, 'Chất liệu vải lanh, chắc chắn, bóng mượt hơn vải Cotton.', 'AN', 'http://localhost:8080/ATBM/src/main/webapp/images/men6.jpg'),
('AN07', 'Thun nam Champion', 65, 'Chất liệu vải Lycra, co giãn tốt.', 'AN', 'http://localhost:8080/ATBM/src/main/webapp/images/men7.jpg'),
('AN08', 'Thun nam sọc trắng đen', 55, 'Chất liệu vải lanh, chắc chắn, bóng mượt hơn vải Cotton.', 'AN', 'http://localhost:8080/ATBM/src/main/webapp/images/men8.jpg'),
('AN09', 'Thun nam hình mặt cười', 65, 'Chất liệu cải Modal, mềm mịn, co giãn, hút ẩm tốt.', 'AN', 'http://localhost:8080/ATBM/src/main/webapp/images/men9.jpg'),
('AN10', 'Thun nam hình bản đồ', 65, 'Chất liệu vải Lycra, co giãn tốt.', 'AN', 'http://localhost:8080/ATBM/src/main/webapp/images/men10.jpg'),
('NU01', 'Áo nữ tay loe', 70, 'Chất liệu vải Cotton, thấm hút tốt, mát mẻ.', 'NU', 'http://localhost:8080/ATBM/src/main/webapp/images/woman1.jpg'),
('NU02', 'Áo nữ tay dài 2 màu', 60, 'Chất liệu PE, dày dặn.', 'NU', 'http://localhost:8080/ATBM/src/main/webapp/images/woman2.jpg'),
('NU03', 'Áo thun nưx ngắn tay', 100, 'Chất liệu vải lanh, chắc chắn, bóng mượt hơn vải Cotton.', 'NU', 'http://localhost:8080/ATBM/src/main/webapp/images/woman3.jpg'),
('NU04', 'Áo thun nữ rách tay', 90, 'Chất liệu vải Lycra, co giãn tốt.', 'NU', 'http://localhost:8080/ATBM/src/main/webapp/images/woman4.jpg'),
('NU05', 'Thun nữ hình đám mây', 90, 'Chất liệu vải Rayon, mềm mịn, thoáng khí.', 'NU', 'http://localhost:8080/ATBM/src/main/webapp/images/woman5.jpg'),
('NU06', 'Thun nữ co dãn', 165, 'Chất liệu cải Modal, mềm mịn, co giãn, hút ẩm tốt.', 'NU', 'http://localhost:8080/ATBM/src/main/webapp/images/woman6.jpg'),
('NU07', 'Thun nữ hồng nhạt', 65, 'Chất liệu vải Lycra, co giãn tốt.', 'NU', 'http://localhost:8080/ATBM/src/main/webapp/images/woman7.jpg'),
('NU08', 'Thun nữ hình cô bé', 100, 'Chất liệu PE, dày dặn.', 'NU', 'http://localhost:8080/ATBM/src/main/webapp/images/woman8.jpg'),
('NU09', 'Thun nữ form rộng', 75, 'Chất liệu vải Cotton, thấm hút tốt, mát mẻ.', 'NU', 'http://localhost:8080/ATBM/src/main/webapp/images/woman9.jpg'),
('NU10', 'Thun nữ hình cô gái', 105, 'Chất liệu vải Rayon, mềm mịn, thoáng khí.', 'NU', 'http://localhost:8080/ATBM/src/main/webapp/images/woman10.jpg'),
('P01', 'Áo Polo trắng đen', 150, 'Chất liệu vải Cotton, thấm hút tốt, mát mẻ.', 'P', 'http://localhost:8080/ATBM/src/main/webapp/images/aopolo1.jpg'),
('P02', 'Áo Polo nữ 3 màu', 80, 'Chất liệu vải Lycra, co giãn tốt.', 'P', 'http://localhost:8080/ATBM/src/main/webapp/images/aopolo2.jpg'),
('P03', 'Áo Polo thêu hình', 150, 'Chất liệu cải Modal, mềm mịn, co giãn, hút ẩm tốt.', 'P', 'http://localhost:8080/ATBM/src/main/webapp/images/aopolo5.jpg'),
('P04', 'Polo trắng viền đen', 180, 'Chất liệu vải Rayon, mềm mịn, thoáng khí.', 'P', 'http://localhost:8080/ATBM/src/main/webapp/images/aopolo11.jpg'),
('P05', 'Polo trắng đen', 120, 'Chất liệu PE, dày dặn.', 'P', 'http://localhost:8080/ATBM/src/main/webapp/images/aopolo4.jpg'),
('P06', 'Polo thêu hình 4 màu ', 165, 'Chất liệu cải Modal, mềm mịn, co giãn, hút ẩm tốt.', 'P', 'http://localhost:8080/ATBM/src/main/webapp/images/aopolo6.jpg'),
('P07', 'Polo sọc trắng', 115, 'Chất liệu vải lanh, chắc chắn, bóng mượt hơn vải Cotton.', 'P', 'http://localhost:8080/ATBM/src/main/webapp/images/aopolo7.jpg'),
('P08', 'Polo màu da', 125, 'Chất liệu vải Lycra, co giãn tốt.', 'P', 'http://localhost:8080/ATBM/src/main/webapp/images/aopolo8.jpg'),
('P09', 'Polo trắng viền cổ đen', 165, 'Chất liệu vải Cotton, thấm hút tốt, mát mẻ.', 'P', 'http://localhost:8080/ATBM/src/main/webapp/images/aopolo9.jpg'),
('P10', 'Polo nữ màu xám', 195, 'Chất liệu vải lanh, chắc chắn, bóng mượt hơn vải Cotton.', 'P', 'http://localhost:8080/ATBM/src/main/webapp/images/aopolo10.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `userkeys`
--

CREATE TABLE `userkeys` (
  `keyID` int(11) NOT NULL,
  `userID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `publicKey` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `date_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `key_status` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `userkeys`
--

INSERT INTO `userkeys` (`keyID`, `userID`, `publicKey`, `date_time`, `key_status`) VALUES
(2, 'hy', 'MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwVMuq4WEAdJI6IlZMbIqsmfky2OsnCp6cj4KSKYDakHXu+FelDtW/RHsU0754H0piCFy4Ap0EGUJLPcm/dK1q4RkOBUCNBSuer+ogcqA09xzWx8Ts8C9kFhC4QKmJ7XrXGi3H5bI9PfsG3EN2XyxxUkRCgRNS03k4xLEe4Shtk5XWiIO3j8E5NeXEV4TBWLbiQ95yw70ghkAIOS0kaG6dNKca/eaMvtj+ZRt5yetDTEjm0i8JcqZEB7phSXK+ZXNYqkk1e9azDkq5DAlvH9n62KIjNo/6Ko07m8RXlQ64wu7+XCBSxOL2WjWsvZKsL63nsX1cLfBI/ErcdO2c+1X+QIDAQAB', '2023-12-25 17:14:06', 1),
(3, 'hau', 'MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA8o9qhlQH2jKXEKrnzr3cCzNN0aO+kH0R2SkTvtt2eEMPngy+HVL2LqsmIemmCXk2nVYQSd/eki/4wbVziGBQdAPmGYuu1srJRq28TQwL/1ol6RnCHzWdM+nUFfKw0brc4qAr5ig/hkf4kT93ENo4+yt/pyZb+sPJ4+np9ko8DfYXquVqWvcXWm0/zdtBtAfmdZ0F2heueGS3ksGTPYf8wBxW05X58WXauyk+ns21sgo0MGnRkOFXdOof8kXR8CKvsykY/u+sALftC6XaMqXMAzBUwCqpDljirQBOJ//14QMN8EcI1sLDJ/MG8FW+Q7GJTFeERUxZvoxF2pjhmOAJ6QIDAQAB', '2023-12-25 17:15:45', 1),
(4, 'haun', 'MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsxVzDLwK0sgBSZJBIRe1OlSgJ4J/YaJGSPB3+qfM1PHn2joItjIF/Tl0VwrxEn4SpjIF3ICqWDHJlyjEZylQI2hRyj6BwGBx8sbzu/jhAUhff+SD7coxSplQYc/LY2XG/OsqkV/VWEx2TDcadiWUXhRnwS1A2NBlVPSCuxf93Q75PySSX2qR0xlPfiSDtdEoSwfbh06vQgskb0e0e60JPBIDeZ872daull5Qb71Nna4WKFouwdZXpNVwv/l3Nq+4+DOfEu79R70855i/qHlEUMxYL+2CfEssCOpBT5j4b6fTipUNWpcXG4IYXhqG+1nesLtS6mZS79BU/oqzS927rwIDAQAB', '2023-12-26 05:10:33', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `fullname` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `userName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phone` varchar(12) DEFAULT NULL,
  `address` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `upassword` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `isUser` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`id`, `fullname`, `userName`, `email`, `phone`, `address`, `upassword`, `isUser`) VALUES
(2, 'Nguyễn Văn Dẫn', 'dan', 'dan@gmail.com', '0384374241', 'Dĩ An, Bình Dương', 'dan001', 0),
(3, 'hy', 'hy', 'toanh@gmail.com', '0808721321', 'Hà Nội', '/diLC2tSxchCCtPiU43/XSiHjLQ=', 1),
(4, 'Nguyen Thi Hau', 'hau', '20130255@st.hcmuaf.edu.vn', '+84356481519', 'Thái Bình', '8AZQX7Gh3fhE99jNfpFUXAI/Lak=', 0),
(5, 'haunguyen', 'haun', 'haunguyen@gmail.com', '0800861321', 'Hà Nội', '8AZQX7Gh3fhE99jNfpFUXAI/Lak=', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `views`
--

CREATE TABLE `views` (
  `pId` char(5) DEFAULT NULL,
  `view_count` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`cateId`);

--
-- Chỉ mục cho bảng `detailorder`
--
ALTER TABLE `detailorder`
  ADD PRIMARY KEY (`idOrder`,`pId`);

--
-- Chỉ mục cho bảng `orderproduct`
--
ALTER TABLE `orderproduct`
  ADD PRIMARY KEY (`idOrder`);

--
-- Chỉ mục cho bảng `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`pId`);

--
-- Chỉ mục cho bảng `userkeys`
--
ALTER TABLE `userkeys`
  ADD PRIMARY KEY (`keyID`),
  ADD KEY `userID` (`userID`);

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `userName` (`userName`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `userkeys`
--
ALTER TABLE `userkeys`
  MODIFY `keyID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `userkeys`
--
ALTER TABLE `userkeys`
  ADD CONSTRAINT `userkeys_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `users` (`userName`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
