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
</head>
<body>
	<div class="row">
		<div class="col m4 offset-m4">
			<div class="main-box">
				<div class="center">
					<img class="responsive-img logo-login" src="resources/common/images/small_logo.png">
				</div>
				<div class="center margin-30">
					<h5>Sign in to HiringViet</h5>
				</div>
				<div class="card-panel">
					<div class="input-field">
						<input id="email" type="email" class="validate"></input>
						<label for="email" data-error="Sai" data-success="Đúng">Email</label>
					</div>
					<div class="input-field">
						<input id="password" type="password" class="validate"></input>
						<label for="password" data-error="Sai" data-success="Đúng">Password</label>
					</div>
					<div class="row margin-top-10">
						<div class="col m6">
							<input type="checkbox" id="test5" />
							<label for="test5">Remember me</label>
						</div>
						<div class="col m6 right-align">
							<a href="#" class="small-text">Quên mật khẩu</a>
						</div>
					</div>
					<a href="" class="btn waves-effect waves-light btn-block">Đăng nhập</a>
				</div>
				<div class="card-panel center">
					New to HiringViet? <a href="#">Create an account</a>.
				</div>
			</div>
		</div>
	</div>
</body>
</html>