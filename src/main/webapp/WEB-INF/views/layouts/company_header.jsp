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
			<p class="company-name">Axon Active Vietnam</p>
			<p>45,500 <spring:message code="label.company.header.title.count_follow"/></p>
			<ul class="menu-banner">
				<li>
					<a href="/company" class="active">Home</a>
				</li>
				<li>
					<a href="/company/careers">Careers</a>
				</li>
			</ul>
		</div>
		<div class="col m4 margin-top-10 right-align">
			<a class="btn waves-effect waves-light">Message</a> <a
				class="btn waves-effect waves-light orange">Subscribe</a>
		</div>
	</div>
</body>
</html>