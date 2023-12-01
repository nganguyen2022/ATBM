<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Quản lý sản phẩm</title>
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="css/manager.css" rel="stylesheet" type="text/css" />
    <style>
        img {
            width: 200px;
            height: 120px;
        }
    </style>
<body>
<div class="container">
    <div class="table-wrapper">
        <div class="table-title">
            <div class="row">
                <div class="col-sm-6">
                    <h2>
                        Quản lý sản phẩm
                    </h2>
                </div>
                <div class="col-sm-6">
                    <a href="#addEmployeeModal" class="btn btn-success"
                       data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Thêm sản phẩm</span></a> <a href="#deleteEmployeeModal"
                                                                                                                    class="btn btn-danger" data-toggle="modal"><i
                        class="material-icons">&#xE15C;</i> <span>Xóa</span></a>
                </div>
            </div>
        </div>
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th><span class="custom-checkbox"> <input
                        type="checkbox" id="selectAll"> <label for="selectAll"></label>
						</span></th>
                <th>ID</th>
                <th>Tên</th>
                <th>Ảnh</th>
                <th>Giá</th>
                <th>Công cụ</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listP }" var="p">
                <tr>
                    <td><span class="custom-checkbox"> <input
                            type="checkbox" id="checkbox1" name="options[]" value="1">
									<label for="checkbox1"></label>
							</span></td>
                    <td>${p.pID }</td>
                    <td>${p.pName }</td>
                    <td><img
                            src="${p.img }">
                    </td>
                    <td>${p.price }VNĐ</td>
                    <td><a href="LoadProServlet?pid=${p.pID}" class="edit"
                           data-toggle="modal"><i class="material-icons"
                                                  data-toggle="tooltip" title="Edit">&#xE254;</i></a> <a
                            href="DeleteProServlet?pid=${p.pID}" class="delete" data-toggle="modal"><i
                            class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <a href="index.jsp"><button type="button"
                                class="btn btn-primary">Về trang chủ</button></a>
</div>
<!-- Edit Modal HTML -->
<div id="addEmployeeModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="AddProServlet" method="post">
                <div class="modal-header">
                    <h4 class="modal-title">Thêm sản phẩm</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>ID</label>
                        <input name="id" type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Tên sản phẩm</label>
                        <input name="name" type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Hình ảnh</label>
                        <input name="img" type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Giá</label>
                        <input name="price" type="number" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Mô tả</label>
                        <textarea name="description" class="form-control" required></textarea>
                    </div>
                    <div class="form-group">
                        <label>Loại sản phẩm</label>
                        <select name="cate" class="form-select" aria-label="Default select example">
                            <c:forEach items="${listCat }" var="c">
                                <option value="${c.cID }">${c.cName }</option>
                            </c:forEach>
                        </select>
                    </div>

                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Hủy">
                    <input type="submit" class="btn btn-success" value="Thêm sản phẩm">
                </div>
            </form>
        </div>
    </div>
</div>
<!-- Edit Modal HTML -->

<!-- Delete Modal HTML -->
<div id="deleteEmployeeModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form>
                <div class="modal-header">
                    <h4 class="modal-title">Xóa sản phẩm</h4>
                    <button type="button" class="close" data-dismiss="modal"
                            aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <p>Bạn có chắc muốn xóa chứ?</p>
                    <p class="text-warning">
                        <small>Hành động này không thẻ hoàn tác.</small>
                    </p>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal"
                           value="Cancel"> <input type="submit"
                                                  class="btn btn-danger" value="Delete">
                </div>
            </form>
        </div>
    </div>
</div>
<script src="js/manager.js" type="text/javascript"></script>
</body>
</html>