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
	<div class="row">
		<div class="col m8 offset-m2">
			<div class="card-panel">
				<div class="panel-title">KÍCH HOẠT TÀI KHOẢN THÀNH CÔNG</div>
				<div class="panel-content">
					<p class="margin-10">Xin chúc mừng, tài khoản email ${email }
						của bạn vừa được kích hoạt thành công. Bây giờ, bạn có thể sử dụng
						các chức năng của hệ thống.</p>
					</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>