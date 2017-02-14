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

</head>
<body>
	<div class="row">
		<div class="col m8 offset-m2">
			<div class="card-panel" id="register-panel">
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
								<form:input id="explicitAddress" type="text"
									path="address.explicitAddress" cssClass="validate"
									required="required" />
								<label><spring:message
										code="label.register.company.input.address"></spring:message></label>
							</div>
							<div class="row">
								<div class="input-field col m3 p-0">
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
								<div class="input-field col m4 offset-m1 p-0">
									<select id="provinceAddress">
										<option value="-1" disabled selected><spring:message
												code="label.default.dropdown.none_value"></spring:message></option>
									</select> <label><spring:message
											code="label.register.company.input.province"></spring:message></label>
								</div>

								<div class="input-field col m3 offset-m1 p-0">
									<spring:message code="label.default.dropdown.none_value"
										var="dropdown_none_value"></spring:message>
									<form:select id="districtAddress" path="address.district.id">
										<form:option value="-1" label="${dropdown_none_value}"
											disabled="true" selected="selected"></form:option>
									</form:select>
									<label><spring:message
											code="label.register.company.input.district"></spring:message></label>
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
	
	<script type="text/javascript"
		src="/resources/hiringviet/register/js/validate.js"></script>
	<script type="text/javascript"
		src="/resources/hiringviet/register/js/address_auto_fill.js"></script>
	<script type="text/javascript"
		src="/resources/hiringviet/register/js/register_company.js"></script>
</body>
</html>