<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Home</title>

	<meta charset="utf-8">
	<!--Import Google Icon Font-->
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<!--Import materialize.css-->
	<link type="text/css" rel="stylesheet" href="/resources/common/css/materialize.min.css"  media="screen,projection"/>

	<!--Let browser know website is optimized for mobile-->
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>

	<!--Import jQuery before materialize.js-->
	<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="/resources/common/js/materialize.min.js"></script>

	<link rel="stylesheet" type="text/css" href="/resources/common/css/style.css">
	<link rel="stylesheet" type="text/css" href="/resources/hiringviet/login/css/login.css">

	<!--common js-->
	<script type="text/javascript" src="<c:url value='/resources/hiringviet/home/js/common.js'/>"></script>
</head>
<body>
	<input type="hidden" id="url_redirect_page" value="<c:url value='/home' />" />
	<input type="hidden" id="url_login" value="<c:url value='/member/login' />" />
	<input type="hidden" id="url_check_account" value="<c:url value='/member/checkAccount' />" />
	<div class="row">
		<div class="col m4 offset-m4">
			<div class="main-box">
				<div class="center">
					<img class="responsive-img logo-login" src="resources/common/images/small_logo.png">
				</div>
				<div class="center margin-30">
					<h5><spring:message code="label.login.login_title"/> </h5>
				</div>
				<div class="card-panel">
					<form:form >
						<p id="email_requierd" class="txt-errors">
							<spring:message code="label.login.errors.email_required" />
						</p>
						<p id="password_requierd" class="txt-errors">
							<spring:message code="label.login.errors.password_required" />
						</p>
						<p id="email_or_password_wrong" class="txt-errors">
							<spring:message code="label.login.errors.email_or_password_wrong" />
						</p>
						<p id="email_max_length" class="txt-errors">
							<spring:message code="label.login.errors.email_max_length" />
						</p>
						<p id="password_max_length" class="txt-errors">
							<spring:message code="label.login.errors.password_max_length" />
						</p>
						<div class="input-field">
							<input id="txtEmail" type="email" class="validate"></input>
							<label for="txtEmail" data-error="<spring:message code='label.login.errors.email_format' />" data-success="">
								<spring:message code="label.login.field.email_title"/>
							</label>
						</div>
						<div class="input-field">
							<input id="txtPassword" type="password" class="validate"></input>
							<label for="txtPassword" data-error="" data-success="">
								<spring:message code="label.login.field.password_title"/>
							</label>
						</div>
						<div class="row margin-top-10">
							<div class="col m6">
								<input type="checkbox" id="test5" />
								<label for="test5">
									<spring:message code="label.login.title.remember_account"/>
								</label>
							</div>
							<div class="col m6 right-align">
								<a href="#" class="small-text">
									<spring:message code="label.login.title.forget_password"/>
								</a>
							</div>
						</div>
						<a href="" id="btn-sign-in" class="btn waves-effect waves-light btn-block">
							<spring:message code="label.login.button.sign_in"/>
						</a>
					</form:form>
				</div>
				<div class="card-panel center">
					<spring:message code="label.login.ask.title"/> 
					<a href="#">
						<spring:message code="label.login.ask.created_account"/>
					</a>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="<c:url value='/resources/hiringviet/login/js/login.js'/>"></script>
</body>
</html>