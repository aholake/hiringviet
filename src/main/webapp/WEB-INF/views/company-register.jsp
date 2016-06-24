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
										<select id="countryAddress">
											<option value="" disabled selected>Choose your
												option</option>
											<c:if test="${not empty countries }">
												<c:forEach items="${countries }" var="country">
													<option value="${country.id }">${country.countryName }</option>
												</c:forEach>
											</c:if>
										</select> <label>Quốc gia</label>
									</div>
									<div class="input-field col m6">
										<select id="provinceAddress">
											<option value="" disabled selected>Choose your
												option</option>
										</select> <label>Tỉnh/Thành phô</label>
									</div>

									<div class="input-field col m6">
										<select id="districtAddress">
											<option value="" disabled selected>Choose your
												option</option>
										</select> <label>Quận/Huyện</label>
									</div>
									<div class="input-field col m6">
										<form:select id="wardAddress" path="address.ward.id">
											<form:option value="-1" label="Choose your option"
												disabled="true"></form:option>
										</form:select>
										<label>Phường</label>
									</div>
								</div>

								<div class="input-field center">
									<button id="nextButton" type="button"
										class="btn waves-effect waves-light">Next</button>
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
									<button id="backButton" type="button"
										class="btn waves-effect waves-light">Back</button>
									<button type="submit"
										class="btn waves-effect waves-light orange">Đăng ký</button>
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

		$("#countryAddress").change(
				function() {
					var data = $(this).val();
					callAPI('/rest/getProvincesByCountry', 'POST', data,
							'processGetProvinces', false);
				});

		$("#provinceAddress").change(
				function() {
					var data = $(this).val();
					callAPI('/rest/getDistrictsByProvince', 'POST', data,
							'processGetDistricts', false);
				});

		$("#districtAddress").change(
				function() {
					var data = $(this).val();
					callAPI('/rest/getWardsByDistrict', 'POST', data,
							'processGetWards', false);
				});

		function processGetProvinces(response) {
			console.log(response);
			$("#provinceAddress")
					.empty()
					.append(
							"<option value='' disabled selected>Choose your option</option>");
			$.each(response, function(i, province) {
				console.log("Province: " + province);
				$("#provinceAddress").append($('<option>', {
					value : province.id,
					text : province.provinceName
				}));
			});
			$('#provinceAddress').material_select();
		}

		function processGetDistricts(response) {
			console.log(response);
			$("#districtAddress")
					.empty()
					.append(
							"<option value='' disabled selected>Choose your option</option>");
			$.each(response, function(i, district) {
				console.log("District: " + district);
				$("#districtAddress").append($('<option>', {
					value : district.id,
					text : district.districtName
				}));
			});
			$('#districtAddress').material_select();
		}

		function processGetWards(response) {
			console.log(response);
			$("#wardAddress")
					.empty()
					.append(
							"<option value='' disabled selected>Choose your option</option>");
			$.each(response, function(i, ward) {
				console.log("Ward: " + ward);
				$("#wardAddress").append($('<option>', {
					value : ward.id,
					text : ward.wardName
				}));
			});
			$('#wardAddress').material_select();
		}

		$("#nextButton").click(
				function() {
					//validateAllDropdownList();
					if (!$("#newCompany")[0].checkValidity()) {
						$("#newCompany").find(':submit').click()
					} else {
						if ($("#company-info").is(":visible")
								&& !$("#account-info").is(":visible")) {
							$("#company-info").hide();
							$("#account-info").show();
						}
					}
				});

		$("#backButton").click(
				function() {
					if ($("#account-info").is(":visible")
							&& !$("#company-info").is(":visible")) {
						$("#account-info").hide();
						$("#company-info").show();
					}
				});

		function validateAllDropdownList() {
			$("select").each(function(index, element) {
				console.log(index + " | " + element.value);
				if (element.value == null || element.value == -1) {
					element.setValidity("You should select an option");
				} else {
					element.setValidity("");
				}
			});
		}
	</script>
</body>
</html>