
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8"%>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <c:set var="lg" value="${sessionScope.language}"></c:set>
    <c:if test="${lg eq 'US' }">
        <fmt:setLocale value="en_US" />
    </c:if>
    <c:if test="${lg eq 'VN' || lg == null }">
        <fmt:setLocale value="vi_VN" />
    </c:if>
    <%@page isELIgnored="false"%>
    <fmt:setBundle basename="app" var="language" />
    <title>Insert title here</title>
</head>
<body>
<!-- Sidebar -->
<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

    <!-- Sidebar - Brand -->
    <a class="sidebar-brand d-flex align-items-center justify-content-center" href="<c:url value="/index.jsp"></c:url>">
        <div class="sidebar-brand-icon rotate-n-15">
            <i class="fas fa-laugh-wink"></i>
        </div>
        <div class="sidebar-brand-text mx-3">Brother Admin  </div>
    </a>

    <!-- Divider -->
    <hr class="sidebar-divider my-0">

    <!-- Nav Item - Dashboard -->
    <li class="nav-item active">
        <a class="nav-link" href="<c:url value="/admin/index.jsp"></c:url>">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>Bảng điều khiển</span></a>
    </li>

    <!-- Divider -->
    <hr class="sidebar-divider">




    <!-- Nav Item - Pages Collapse Menu -->


    <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
           aria-expanded="true" aria-controls="collapseUtilities">
            <i class="fas fa-fw fa-wrench"></i>
            <span>Danh sách quản lý </span>
        </a>
        <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"
             data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">

                <a class="collapse-item" href="<c:url value="/ProductServlet"></c:url>">Trang bán hàng</a>
                <a class="collapse-item" href="<c:url value="/admin/manage?loai=user"></c:url>">Người dùng</a>
                <a class="collapse-item" href="<c:url value="/admin/manage?loai=oder"></c:url>">Đơn hàng</a>
                <a class="collapse-item" href="<c:url value="/admin/manage?loai=product"></c:url>">Sản phẩm</a>
                <a class="collapse-item" href="<c:url value="/admin/manage?loai=log"></c:url>">Nhật ký</a>
            </div>
        </div>
    </li>





    <!-- Divider -->
    <hr class="sidebar-divider d-none d-md-block">

    <!-- Sidebar Toggler (Sidebar) -->
    <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
    </div>



</ul>
<!-- End of Sidebar -->
</body>
</html>