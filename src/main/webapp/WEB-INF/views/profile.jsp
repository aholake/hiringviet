<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="label.company.title"/></title>
<!-- Local style -->
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/hiringviet/home/css/home.css'/>">
<!-- CSS media query on a link element -->
<link rel="stylesheet" href="/resources/hiringviet/home/css/smart-home.css" />
<link rel="stylesheet" href="/resources/hiringviet/profile/css/profile.css" />
</head>
<body>
	<jsp:include page="/layouts/navbar"></jsp:include>

	<jsp:include page="/layouts/profileBanner"></jsp:include>

	<div id="main-container">

		<jsp:include page="/layouts/profileHeader"></jsp:include>

		<div class="row">
			<div class="col m8">
				<div class="card-panel padding-10 light-blue darken-3 overflow-auto hoverable">
					<h1 class="title cl-white"><spring:message code="label.profile.title.addSkill"/></h1>
					<p class="cl-white small-text"><spring:message code="label.profile.title.value_statement"/></p>
					<div class="chip-inputs">
						<div class="chip-inputs-wrapper">
							<div class="list-skill-chip">
								<c:forEach items="${member.resume.skillSet}" var="skill">
									<div class="chip">
									    ${skill.displayName}
									    <i class="material-icons">close</i>
									</div>
								</c:forEach>
								<div class="chip add-chip">
								    <input type="text" id="addNewSkill" placeHolder="<spring:message  code='label.profile.title.add_skill' />"/>
								</div>
							</div>
						</div>
					</div>
					<div class="col m12 margin-top-5 p-0">
						<a class="waves-effect waves-light cl-black opacity-7 lime accent-2 btn"><spring:message code="label.profile.title.add_skill.save"/> </a>
						<a class="waves-effect waves-light cl-black opacity-7 grey lighten-2 btn"><spring:message code="label.profile.title.add_skill.skill"/></a>
						<a href="" class="cl-white a-text-color"><spring:message code="label.profile.title.add_skill.done_add"/></a>
					</div>
				</div>
			</div>
			<div class="col m4">
				<div class="card-panel">
				</div>
			</div>
		</div>
	</div>
	<!-- Modal Structure -->
	<div id="modal1" class="modal bottom-sheet">
		<div class="modal-content">
			<h4>Modal Header</h4>
			<p>A bunch of text</p>
		</div>
		<div class="modal-footer">
			<a href="#!"
				class=" modal-action modal-close waves-effect waves-green btn-flat">Agree</a>
		</div>
	</div>
	<script src="<c:url value='/resources/hiringviet/profile/js/profile.js'/>"></script>
</body>
</html>