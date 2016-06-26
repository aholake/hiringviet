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
					<div class="panel-title">
						<spring:message code="label.register.company.title"></spring:message>
					</div>
					<div class="panel-content">
						<form:form modelAttribute="newCompany" cssClass="margin-10"
							action="/rest/addNewCompany" method="POST">
							<div id="company-info">
								<h5>
									<spring:message code="label.register.company.title.info"></spring:message>
								</h5>
								<div class="input-field">
									<form:input path="displayName" id="displayName"
										cssClass="validate" type="text" required="required" />
									<label for="displayName"><spring:message
											code="label.register.company.input.company_name"></spring:message></label>
								</div>

								<div class="input-field">
									<form:input path="businessField" id="businessField"
										cssClass="validate" type="text" required="required" />
									<label for="country"><spring:message
											code="label.register.company.input.company_field"></spring:message></label>
								</div>

								<div class="input-field">
									<form:input id="streetName" type="text"
										path="address.streetName" cssClass="validate"
										required="required" />
									<label><spring:message
											code="label.register.company.input.street_name"></spring:message></label>
								</div>

								<div class="row">
									<div class="input-field col m6">
										<select id="countryAddress">
											<option value="-1" disabled selected><spring:message
													code="label.default.dropdown.none_value"></spring:message></option>
											<c:if test="${not empty countries }">
												<c:forEach items="${countries }" var="country">
													<option value="${country.id }">${country.countryName }</option>
												</c:forEach>
											</c:if>
										</select><label><spring:message
												code="label.register.company.input.country"></spring:message></label>
									</div>
									<div class="input-field col m6">
										<select id="provinceAddress">
											<option value="-1" disabled selected><spring:message
													code="label.default.dropdown.none_value"></spring:message></option>
										</select> <label><spring:message
												code="label.register.company.input.province"></spring:message></label>
									</div>

									<div class="input-field col m6">
										<select id="districtAddress">
											<option value="-1" disabled selected><spring:message
													code="label.default.dropdown.none_value"></spring:message></option>
										</select> <label><spring:message
												code="label.register.company.input.district"></spring:message></label>
									</div>
									<div class="input-field col m6">
										<spring:message code="label.default.dropdown.none_value"
											var="dropdown_none_value"></spring:message>
										<form:select id="wardAddress" path="address.ward.id">
											<form:option value="-1" label="${dropdown_none_value}"
												disabled="true"></form:option>
										</form:select>
										<label><spring:message
												code="label.register.company.input.ward"></spring:message></label>
									</div>
								</div>

								<div class="input-field center">
									<button id="nextButton" type="button"
										class="btn waves-effect waves-light">
										<spring:message code="label.register.company.button.next"></spring:message>
									</button>
								</div>
							</div>
							<div id="account-info">
								<div class="input-field">
									<form:input path="account.email" id="email" cssClass="validate"
										type="email" required="required" />
									<label for="email"><spring:message
											code="label.register.account.email"></spring:message> </label>
								</div>

								<div class="input-field">
									<form:input path="account.password" id="password"
										cssClass="validate" type="password" required="required" />
									<label for="password"><spring:message
											code="label.register.account.password"></spring:message> </label>
								</div>
								<div class="input-field">
									<input id="rePassword" class="validate" type="password"
										required="required" /> <label for="rePassword"><spring:message
											code="label.register.account.repassword"></spring:message> </label>
								</div>

								<div class="input-field center">
									<button id="backButton" type="button"
										class="btn waves-effect waves-light">
										<spring:message code="label.register.company.button.back"></spring:message>
									</button>
									<button type="submit"
										class="btn waves-effect waves-light orange">
										<spring:message code="label.register.account.button.register"></spring:message>
									</button>
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
							"<option value='-1' disabled selected><spring:message code="label.default.dropdown.none_value"></spring:message></option>");
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
							"<option value='' disabled selected><spring:message code="label.default.dropdown.none_value"></spring:message></option>");
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
							"<option value='' disabled selected><spring:message code="label.default.dropdown.none_value"></spring:message></option>");
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
					if (checkCompanyInfoValidate()) {
						if ($("#company-info").is(":visible")
								&& !$("#account-info").is(":visible")) {
							$("#company-info").hide();
							$("#account-info").show();
						}
					} else {
						$("#newCompany").find(":submit").click();
					}
				});

		function checkCompanyInfoValidate() {
			var displayNameValidate = $("#displayName")[0].checkValidity();
			var businessFieldValidate = $("#businessField")[0].checkValidity();
			var streetNameValidate = $("#streetName")[0].checkValidity();
			var checkDropdownList = validateAllDropdownList();

			//console.log(validateAllDropdownList());

			if (!displayNameValidate || !businessFieldValidate
					|| !streetNameValidate || !checkDropdownList) {
				return false;
			}
			return true;
		}

		$("#backButton").click(
				function() {
					if ($("#account-info").is(":visible")
							&& !$("#company-info").is(":visible")) {
						$("#account-info").hide();
						$("#company-info").show();
					}
				});

		function validateAllDropdownList() {
			var check = true;
			$("select").each(function(index, element) {
				console.log(index + " | " + element.value);
				if (element.value == null || element.value == -1) {
					check = false;
					return;
				}
			});
			console.log("To here");
			return check;
		}
	</script>
</body>
</html>