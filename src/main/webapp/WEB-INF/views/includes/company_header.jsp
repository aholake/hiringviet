<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Company Header</title>
</head>
<body>
	<div class="row company-header">
		<div class="col m6 offset-m2">
			<p class="company-name"><a href="<c:url value='/company/${company.id}' />">${company.displayName}</a></p>
			<p>${numberFollower} <spring:message code="label.company.header.title.count_follow"/></p>
			<ul class="menu-banner">
				<li>
					<a href="/company/${company.id}" class="active">
						<spring:message code="label.company.title.home"/>
					</a>
				</li>
				<li>
					<a href="/company/${company.id}/job">
						<spring:message code="label.company.title.careers"/>
					</a>
				</li>
			</ul>
		</div>
		<div class="col m4 margin-top-10 right-align">
			<a class="btn waves-effect waves-light">
				<spring:message code="label.company.title.message"/>
			</a> 
			<a class="btn waves-effect waves-light orange">
				<spring:message code="label.company.title.subscribe"/>
			</a>
		</div>
	</div>
</body>
</html>