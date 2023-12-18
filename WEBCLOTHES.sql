create database WEBCLOTHES;
 use WEBCLOTHES;

CREATE TABLE USERS (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       fullname NVARCHAR(100),
                       userName NVARCHAR(50) NOT NULL UNIQUE,
                       email NVARCHAR(50),
                       phone VARCHAR(12),
                       address NVARCHAR(1000),
                       upassword NVARCHAR(30) NOT NULL,
                       isUser INT
);

CREATE TABLE USERKEYS (
                          keyID INT AUTO_INCREMENT PRIMARY KEY,
                          userID NVARCHAR(50),
                          FOREIGN KEY (userID) REFERENCES USERS(userName),
                          publicKey NVARCHAR(2000),
                          date_time TIMESTAMP,
                          key_status INT
);

CREATE TABLE CATEGORIES (cateId CHAR(5) NOT NULL PRIMARY KEY,
                         cateName NVARCHAR(50) NOT NULL );

CREATE TABLE PRODUCT (pId CHAR(5) NOT NULL PRIMARY KEY,
                      pName NVARCHAR(50) NOT NULL,
                      price float,
                      pDescription NVARCHAR(200),
                      cateId CHAR(5) REFERENCES CATEGORIES(cateId) ,
                      img NVARCHAR(500));
create table OrderProduct( idOrder varchar(5) PRIMARY KEY ,
                           nameAcc nvarchar(50) ,
                           dateOrder nvarchar(50),
                           dateDelivery nvarchar(50), /* ngày nhận hàng */
                           totalMoney float,
                           phone varchar(10),
                           nameRecipient nvarchar(50),    /*tên người nhận*/
                           address nvarchar(100),
                           note nvarchar(500),
                           checkout nvarchar(500),
                           status int
);
create table DetailOrder(idOrder varchar(5) references OrderProduct(idOrder),
                         pId char(5) REFERENCES Product(pId),
                         amount int,
                         price float,
                         constraint PK_DS PRIMARY KEY(idOrder, pId)
);
create table Views(pId char(5)references Product(pId),
                   view_count int);
INSERT INTO USERS VALUES (2,'Nguyễn Văn Dẫn','dan','dan@gmail.com','0384374241','Dĩ An, Bình Dương','dan001', 0);
INSERT INTO CATEGORIES VALUES ('AN', N'Áo nam');
INSERT INTO CATEGORIES VALUES ('NU', N'Áo nữ');
INSERT INTO CATEGORIES VALUES ('P', N'Áo Polo');
INSERT INTO CATEGORIES VALUES ('AK', N'Áo khoác');
-- 1
INSERT INTO PRODUCT VALUES ('NU01', N'Áo nữ tay loe', 70.000, N'Chất liệu vải Cotton, thấm hút tốt, mát mẻ.','NU', 'http://localhost:8080/WebBanAo/images/woman1.jpg');
-- 2
INSERT INTO PRODUCT VALUES ('NU02', N'Áo nữ tay dài 2 màu', 60.000, N'Chất liệu PE, dày dặn.','NU', 'http://localhost:8080/WebBanAo/images/woman2.jpg');
-- 3
INSERT INTO PRODUCT VALUES ('NU03', N'Áo thun nưx ngắn tay', 100.000, N'Chất liệu vải lanh, chắc chắn, bóng mượt hơn vải Cotton.','NU', 'http://localhost:8080/WebBanAo/images/woman3.jpg');
-- 4
INSERT INTO PRODUCT VALUES ('NU04', N'Áo thun nữ rách tay', 90.000, N'Chất liệu vải Lycra, co giãn tốt.','NU', 'http://localhost:8080/WebBanAo/images/woman4.jpg');
-- 5
INSERT INTO PRODUCT VALUES ('NU05', N'Thun nữ hình đám mây', 90.000, N'Chất liệu vải Rayon, mềm mịn, thoáng khí.','NU', 'http://localhost:8080/WebBanAo/images/woman5.jpg');
-- 6
INSERT INTO PRODUCT VALUES ('NU06', N'Thun nữ co dãn', 165.000, N'Chất liệu cải Modal, mềm mịn, co giãn, hút ẩm tốt.','NU', 'http://localhost:8080/WebBanAo/images/woman6.jpg');
-- 7
INSERT INTO PRODUCT VALUES ('NU07', N'Thun nữ hồng nhạt', 65.000, N'Chất liệu vải Lycra, co giãn tốt.','NU', 'http://localhost:8080/WebBanAo/images/woman7.jpg');
-- 8
INSERT INTO PRODUCT VALUES ('NU08', N'Thun nữ hình cô bé', 100.000, N'Chất liệu PE, dày dặn.','NU', 'http://localhost:8080/WebBanAo/images/woman8.jpg');
-- 9
INSERT INTO PRODUCT VALUES ('NU09', N'Thun nữ form rộng', 75.000, N'Chất liệu vải Cotton, thấm hút tốt, mát mẻ.','NU', 'http://localhost:8080/WebBanAo/images/woman9.jpg');
-- 10
INSERT INTO PRODUCT VALUES ('NU10', N'Thun nữ hình cô gái', 105.000, N'Chất liệu vải Rayon, mềm mịn, thoáng khí.','NU', 'http://localhost:8080/WebBanAo/images/woman10.jpg');
-- 11
INSERT INTO PRODUCT VALUES ('AN01', N'Áo thun tay ngắn', 80.000, N'Chất liệu cải Modal, mềm mịn, co giãn, hút ẩm tốt.','AN', 'http://localhost:8080/WebBanAo/images/men1.jpg');
-- 12
INSERT INTO PRODUCT VALUES ('AN02', N'Áo thun HONGKONG', 75.000, N'Chất liệu vải Rayon, mềm mịn, thoáng khí.','AN', 'http://localhost:8080/WebBanAo/images/men2.jpg');
-- 13
INSERT INTO PRODUCT VALUES ('AN03', N'Áo thun nam đen', 100.000, N'Chất liệu PE, dày dặn.','AN', 'http://localhost:8080/WebBanAo/images/men3.jpg');
-- 14
INSERT INTO PRODUCT VALUES ('AN04', N'Thun nam trắng đen', 65.000, N'Chất liệu vải Rayon, mềm mịn, thoáng khí.','AN', 'http://localhost:8080/WebBanAo/images/men4.jpg');
-- 15
INSERT INTO PRODUCT VALUES ('AN05', N'Thun nam cổ trụ', 95.000, N'Chất liệu vải Cotton, thấm hút tốt, mát mẻ.','AN', 'http://localhost:8080/WebBanAo/images/men5.jpg');
-- 16
INSERT INTO PRODUCT VALUES ('AN06', N'Thun nam 1973', 85.000, N'Chất liệu vải lanh, chắc chắn, bóng mượt hơn vải Cotton.','AN', 'http://localhost:8080/WebBanAo/images/men6.jpg');
-- 17
INSERT INTO PRODUCT VALUES ('AN07', N'Thun nam Champion', 65.000, N'Chất liệu vải Lycra, co giãn tốt.','AN', 'http://localhost:8080/WebBanAo/images/men7.jpg');
-- 18
INSERT INTO PRODUCT VALUES ('AN08', N'Thun nam sọc trắng đen', 55.000, N'Chất liệu vải lanh, chắc chắn, bóng mượt hơn vải Cotton.','AN', 'http://localhost:8080/WebBanAo/images/men8.jpg');
-- 19
INSERT INTO PRODUCT VALUES ('AN09', N'Thun nam hình mặt cười', 65.000, N'Chất liệu cải Modal, mềm mịn, co giãn, hút ẩm tốt.','AN', 'http://localhost:8080/WebBanAo/images/men9.jpg');
-- 20
INSERT INTO PRODUCT VALUES ('AN10', N'Thun nam hình bản đồ', 65.000, N'Chất liệu vải Lycra, co giãn tốt.','AN', 'http://localhost:8080/WebBanAo/images/men10.jpg');
-- 21
INSERT INTO PRODUCT VALUES ('P01', N'Áo Polo trắng đen', 150.000, N'Chất liệu vải Cotton, thấm hút tốt, mát mẻ.','P', 'http://localhost:8080/WebBanAo/images/aopolo1.jpg');
-- 22
INSERT INTO PRODUCT VALUES ('P02', N'Áo Polo nữ 3 màu', 80.000, N'Chất liệu vải Lycra, co giãn tốt.','P', 'http://localhost:8080/WebBanAo/images/aopolo2.jpg');
-- 23
INSERT INTO PRODUCT VALUES ('P03', N'Áo Polo thêu hình', 150.000, N'Chất liệu cải Modal, mềm mịn, co giãn, hút ẩm tốt.','P', 'http://localhost:8080/WebBanAo/images/aopolo5.jpg');
-- 24
INSERT INTO PRODUCT VALUES ('P04', N'Polo trắng viền đen', 180.000, N'Chất liệu vải Rayon, mềm mịn, thoáng khí.','P', 'http://localhost:8080/WebBanAo/images/aopolo11.jpg');
-- 25
INSERT INTO PRODUCT VALUES ('P05', N'Polo trắng đen', 120.000, N'Chất liệu PE, dày dặn.','P', 'http://localhost:8080/WebBanAo/images/aopolo4.jpg');
-- 26
INSERT INTO PRODUCT VALUES ('P06', N'Polo thêu hình 4 màu ', 165.000, N'Chất liệu cải Modal, mềm mịn, co giãn, hút ẩm tốt.','P', 'http://localhost:8080/WebBanAo/images/aopolo6.jpg');
-- 27
INSERT INTO PRODUCT VALUES ('P07', N'Polo sọc trắng', 115.000, N'Chất liệu vải lanh, chắc chắn, bóng mượt hơn vải Cotton.','P', 'http://localhost:8080/WebBanAo/images/aopolo7.jpg');
-- 28
INSERT INTO PRODUCT VALUES ('P08', N'Polo màu da', 125.000, N'Chất liệu vải Lycra, co giãn tốt.','P', 'http://localhost:8080/WebBanAo/images/aopolo8.jpg');
-- 29
INSERT INTO PRODUCT VALUES ('P09', N'Polo trắng viền cổ đen', 165.000, N'Chất liệu vải Cotton, thấm hút tốt, mát mẻ.','P', 'http://localhost:8080/WebBanAo/images/aopolo9.jpg');
-- 30
INSERT INTO PRODUCT VALUES ('P10', N'Polo nữ màu xám', 195.000, N'Chất liệu vải lanh, chắc chắn, bóng mượt hơn vải Cotton.','P', 'http://localhost:8080/WebBanAo/images/aopolo10.jpg');
-- 31
INSERT INTO PRODUCT VALUES ('AK1', N'Áo khoác dù nam màu nâu', 155.000, N'Chất liệu vải Linen, nhẹ, thoát nhiệt tốt, nhanh khô.','AK', 'http://localhost:8080/WebBanAo/images/ak1.jpg');
-- 32
INSERT INTO PRODUCT VALUES ('AK2', N'Áo khoác dù nam màu đen', 175.000, N'Chất liệu vải Cotton, mềm, thoáng khí, thấm hút mồ hôt tốt.','AK', 'http://localhost:8080/WebBanAo/images/ak2.jpg');
-- 33
INSERT INTO PRODUCT VALUES ('AK3', N'Áo khoác nỉ đen dày dặn', 125.000, N'Chất liệu vải lanh, chắc chắn, bóng mượt hơn vải Cotton.','AK', 'http://localhost:8080/WebBanAo/images/ak3.jpg');
-- 34
INSERT INTO PRODUCT VALUES ('AK4', N'Áo khoác dù cổ tròn', 205.000, N'Chất liệu vải Polyester, chống nước nhẹ thoải mái, cản gió.','AK', 'http://localhost:8080/WebBanAo/images/ak4.jpg');
-- 35
INSERT INTO PRODUCT VALUES ('AK5', N'Áo khoác có mũ 4 màu', 115.000, N'Chất liệu vải Len và Len pha, tự nhiên thoáng khí, cách nhiệt tốt.','AK', 'http://localhost:8080/WebBanAo/images/ak5.jpg');
-- 36
INSERT INTO PRODUCT VALUES ('AK6', N'Áo Hoodie xanh ngọc', 185.000, N'Chất liệu vải Cashmere, nhẹ, mềm, không bị xước, dễ đàn hồi.','AK', 'http://localhost:8080/WebBanAo/images/ak6.jpg');
-- 37
INSERT INTO PRODUCT VALUES ('AK7', N'Áo khoác nữ màu nâu', 215.000, N'Chất liệu vải Cotton, mềm, thoáng khí, thấm hút mồ hôt tốt.','AK', 'http://localhost:8080/WebBanAo/images/ak7.jpg');
-- 38
INSERT INTO PRODUCT VALUES ('AK8', N'Áo khoác nữ jeans', 145.000, N'Chất liệu vải jeans, chắc chắn, .','AK', 'http://localhost:8080/WebBanAo/images/ak8.jpg');








