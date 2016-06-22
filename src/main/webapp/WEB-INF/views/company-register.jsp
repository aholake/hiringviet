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
							<div id="company-info">
								<h5>Thông tin công ty</h5>
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
									<form:input path="address.streetName" />
									<label>Đường</label>
								</div>

								<div class="row">
									<div class="input-field col m6">
										<form:select id="countryAddress"
											path="address.ward.district.province.country">
											<form:option value="NONE" label="Choose your option"
												disabled="true"></form:option>
											<form:options items="${countries }" itemValue="id" />
										</form:select>
										<label>Quốc gia</label>
									</div>
									<div class="input-field col m6">
										<form:select id="provinceAddress"
											path="address.ward.district.province">
											<form:option value="NONE" label="Choose your option"
												disabled="true"></form:option>
										</form:select>
										<label>Tỉnh/Thành phô</label>
									</div>

									<div class="input-field col m6">
										<form:select id="districtAddress" path="address.ward.district">
											<form:option value="NONE" label="Choose your option"
												disabled="true"></form:option>
										</form:select>
										<label>Quận/Huyện</label>
									</div>
									<div class="input-field col m6">
										<form:select id="wardAddress" path="address.ward">
											<form:option value="NONE" label="Choose your option"
												disabled="true"></form:option>
										</form:select>
										<label>Phường</label>
									</div>

								</div>

								<div class="input-field center">
									<button type="button" class="btn waves-effect waves-light">Next</button>
								</div>
							</div>
							<div id="account-info">
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
									<button id="back" type="button"
										class="btn waves-effect waves-light">Back</button>
									<button type="submit" class="btn waves-effect waves-light">Đăng
										ký</button>
								</div>
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
	<script type="text/javascript">
		$("#account-info").hide();

		var provinces = [ {
			"id" : 1,
			"provinceName" : "Hồ Chí Minh"
		}, {
			"id" : 2,
			"provinceName" : "Hà Nội"
		}, {
			"id" : 3,
			"provinceName" : "Đà Nẵng"
		} ];
		
		$("#countryAddress").change(function() {
			var data = this.val();
			console.log(data);
			$.post("/rest/getProvinceList", data, function(data, status) {
				$.each(provinces, function(i, province) {
					$("#provinceAddress").append($('<option>', {
						value : province.id,
						text : province.provinceName
					}));
				});
			});
		});
		
	</script>
</body>
</html>