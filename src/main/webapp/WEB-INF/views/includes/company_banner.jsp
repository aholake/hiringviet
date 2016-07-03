<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div class="company-banner">
		<img class="company-cover responsive-img img-full"
			src="/resources/images/company_background.jpg" alt="company cover" />
		<div class="social-connect-box">
			<span class="social-company-name">
				${company.displayName}
			</span> 
			<a href="#">
				<img src="/resources/images/facebook.png" />
			</a> 
			<a href="#">
				<img src="/resources/images/linkedin.png" />
			</a> 
			<a href="#">
				<img src="/resources/images/twitter.png" />
			</a>
		</div>
		<div class="company-logo">
			<img class="responsive-img img-full" src="${company.avatar}" alt="company logo" />
		</div>
	</div>
</body>
</html>