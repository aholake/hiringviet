<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title><spring:message code="label.home.title" /></title>
</head>
<body>
	<div id="main-container">
		<div class="row">
			<div class="col m4 offset-m2">
				<div class="card">
					<div class="card-image">
						<img src="/resources/common/images/company-photo.jpg"> <span
							class="card-title">Bạn là doanh nghiệp?</span>
					</div>
					<div class="card-content">
						<p>Chúng tôi cung cấp các đặc trưng để bạn dễ dàng quản lý và
							tìm nguồn nhân lực chất lượng cao cho công ty của bạn</p>
					</div>
					<div class="card-action">
						<a href="/register/company">Đăng ký doanh nghiệp</a>
					</div>
				</div>
			</div>
			<div class="col m4">
				<div class="card">
					<div class="card-image">
						<img src="/resources/common/images/employee.jpg"> <span
							class="card-title">Bạn là người lao động?</span>
					</div>
					<div class="card-content">
						<p>Chúng tôi cung cấp các đặc trưng để bạn dễ dàng quản lý và
							tìm nguồn nhân lực chất lượng cao cho công ty của bạn</p>
					</div>
					<div class="card-action">
						<a href="/register/member">Đăng ký cá nhân</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>