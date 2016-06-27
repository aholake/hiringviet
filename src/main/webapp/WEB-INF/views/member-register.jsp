<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title><spring:message code="label.register.member.title"></spring:message></title>
<!-- Local style -->
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/hiringviet/register/css/member-register.css'/>">
</head>

<body>
	<div class="main-container">
		<div class="row">
			<div class="col m6 offset-m3">
				<div class="card-panel">
					<div class="panel-title">
						<spring:message code="label.register.member.title"></spring:message>
					</div>
					<div class="panel-content">
						<form:form modelAttribute="newMember" cssClass="margin-10"
							action="/rest/saveMember" method="POST">
							<div class="input-field">
								<form:input path="firstName" id="firstName" cssClass="validate"
									type="text" required="required" />
								<label for="firstName"><spring:message
										code="label.register.member.input.first_name"></spring:message>
								</label>
							</div>
							<div class="input-field">
								<form:input path="lastName" id="lastName" cssClass="validate"
									type="text" required="required" />
								<label for="firstName"><spring:message
										code="label.register.member.input.last_name"></spring:message>
								</label>
							</div>
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
								<button type="reset" class="btn waves-effect waves-light grey">
									<spring:message code="label.register.account.button.reset"></spring:message>
								</button>
								<button type="submit"
									class="btn waves-effect waves-light orange">
									<spring:message code="label.register.account.button.register"></spring:message>
								</button>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Local js -->
	<script type="text/javascript"
		src="/resources/hiringviet/register/js/validate.js"></script>
</body>
</html>