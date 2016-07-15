<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Profile Banner</title>
</head>
<body>
	<div class="profile-banner">
		<img class="profile-cover responsive-img img-full"
			src="/resources/images/company_background.jpg" alt="profile cover" />
		<div class="social-connect-box">
			<span class="social-company-name">
				${member.firstName} ${member.lastName}
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
		<div class="profile-logo">
			<img class="responsive-img img-full" src="${member.resume.avatarImage}" alt="profile logo" />
		</div>
	</div>
</body>
</html>