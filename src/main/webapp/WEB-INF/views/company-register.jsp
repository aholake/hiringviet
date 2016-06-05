<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>Home</title>
<!-- Local style -->
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/hiringviet/home/css/home.css'/>">
<!-- CSS media query on a link element -->
<link rel="stylesheet"
	href="/resources/hiringviet/home/css/smart-home.css" />

</head>
<body>
	<jsp:include page="/layouts/navbar"></jsp:include>

	<div id="introduce-slider"></div>

	<div id="main-container">
		<div class="card-panel">
			<div class="panel-title">Đăng ký cho doanh nghiệp</div>
			<div class="panel-content">
				<div class="row" style="padding: 0 25px;">
					<form:form modelAttribute="company" method="post">
						<div class="input-field col s12">
							<form:input path="email" id="email" cssClass="validate" />
							<label for="email">Email:</label>
						</div>
					</form:form>

					<div class="input-field col s6">
						<form:input path="password" id="password" cssClass="validate"
							type="password" />
						<label for="password">Mật khẩu: </label>
					</div>

					<div class="input-field col s6">
						<form:input path="repassword" id="repassword" cssClass="validate"
							type="password" />
						<label for="repassword">Xác nhận mật khẩu: </label>
					</div>

					<div class="input-field col s12">
						<form:input path="companyName" id="companyName"
							cssClass="validate" />
						<label for="companyName">Tên công ty</label>
					</div>
					<div class="input-field col s6">
						<form:select path="foundedYear" id="foundedYear">
							<form:option value="" disable selected>Choose your option</form:option>
							<form:option value="2014">2014</form:option>
							<form:option value="2015">2015</form:option>
							<form:option value="2016">2016</form:option>
							<form:option value="2017">2017</form:option>
						</form:select>
						<label for="foundedYear">Founded Year</label>
					</div>

					<div class="input-field col s6">
						<form:select path="country" id="country">
							<form:option value="" disable selected>Choose your option</form:option>
							<form:option value="Vietnam">Vietnam</form:option>
							<form:option value="China">China</form:option>
							<form:option value="USA">USA</form:option>
						</form:select>
						<label for="country">Quốc gia</label>
					</div>

					<div class="input-field col s6">
						<form:select path="companySize" id="companySize">
							<form:option value="" disable selected>Choose your option</form:option>
							<form:option value="100-200">100-200</form:option>
							<form:option value="200-400">200-400</form:option>
							<form:option value="400-1000">400-1000</form:option>
						</form:select>
						<label for="companySize">Quy mô</label>
					</div>

					<div class="input-field col s6">
						<form:input path="street" id="street" cssClass="validate" />
						<label for="street">Đường:</label>
					</div>
					<div class="input-field col s6">
						<input placeholder="Placeholder" id="display_name" type="text"
							class="validate"> <label for="display_name">Phường/Xã:</label>
					</div>
					<div class="input-field col s6">
						<input placeholder="Placeholder" id="display_name" type="text"
							class="validate"> <label for="display_name">Quận/Huyện:</label>
					</div>
					<div class="input-field col s6">
						<input placeholder="Placeholder" id="display_name" type="text"
							class="validate"> <label for="display_name">Tỉnh/Thành
							phố:</label>
					</div>
					<
					<div class="input-field col s12">
						<input placeholder="Placeholder" id="display_name" type="text"
							class="validate"> <label for="display_name">Website:</label>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="footer">Copyright 2016 by Nong Lam University, all right
		reserved.</div>

	<!-- Local js -->
	<script type="text/javascript" src="/resources/js/home.js"></script>
</body>
</html>