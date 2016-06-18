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
	href="<c:url value='/resources/hiringviet/register/css/company-register.css'/>">
<!-- CSS media query on a link element -->
<link rel="stylesheet"
	href="/resources/hiringviet/home/css/smart-home.css" />

</head>
<body>
	<jsp:include page="/layouts/navbar"></jsp:include>

	<div id="main-container">
		<div class="row">
			<div class="col m6 offset-m3">
				<div class="card-panel">
					<div class="panel-title">ĐĂNG KÝ DOANH NGHIỆP</div>
					<div class="panel-content">
						<form:form modelAttribute="newCompany" cssClass="margin-10"
							action="/rest/addNewCompany" method="POST">
							<div class="input-field">
								<form:input path="displayName" id="displayName"
									cssClass="validate" type="text" required="required" />
								<label for="displayName">Company name</label>
							</div>

							<div class="input-field">
								<form:input path="businessField" id="businessField"
									cssClass="validate" type="text" required="required" />
								<label for="country">Business field</label>
							</div>

							<div class="input-field">
								<form:input path="account.email" id="email" cssClass="validate"
									type="email" required="required" />
								<label for="email">Email</label>
							</div>

							<div class="input-field">
								<form:input path="account.password" id="password"
									cssClass="validate" type="password" required="required" />
								<label for="password">Password</label>
							</div>
							<div class="input-field">
								<input id="rePassword" class="validate" type="password"
									required="required" /> <label for="rePassword">Confirm
									password</label>
							</div>
							<div class="input-field center">
								<button type="submit" class="btn waves-effect waves-light">Đăng
									ký</button>
								<button type="reset" class="btn waves-effect waves-light">Hủy</button>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="footer">Copyright 2016 by Nong Lam University, all right
		reserved.</div>

	<!-- Local js -->
	<script type="text/javascript"
		src="/resources/hiringviet/register/js/validate.js"></script>
</body>
</html>