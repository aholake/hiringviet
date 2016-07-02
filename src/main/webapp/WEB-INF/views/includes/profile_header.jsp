<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Profile Header</title>
</head>
<body>
	<div class="row profile-header">
		<div class="col m6 offset-m2">
			<p class="profile-name"><a href="<c:url value='/profile/${member.id}' />">${member.firstName}  ${member.lastName}</a></p>
			<p>100 <spring:message code="label.profile.header.title.count_follow"/></p>
		</div>
		<div class="col m4 margin-top-10 right-align">
			<a class="btn waves-effect waves-light">
				<spring:message code="label.profile.title.message"/>
			</a> 
			<a class="btn waves-effect waves-light orange">
				<spring:message code="label.profile.title.subscribe"/>
			</a>
		</div>
	</div>
</body>
</html>