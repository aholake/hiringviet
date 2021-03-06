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
				<div class="panel-title">CHÚC MỪNG BẠN ĐÃ ĐĂNG KÝ THÀNH CÔNG</div>
				<div class="panel-content">
					<p class="margin-10">Chào mừng bạn đến với mạng lưới việc
						làm HiringViet. Vui lòng kiểm tra hòm thư email để hoàn tất thủ
						tục đăng ký.</p>
					<p class="red-text margin-10">
						<strong>Chú ý: Tài khoản của bạn sẽ bị xóa nếu không kích
							hoạt trong vòng 24h.</strong>
					</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>