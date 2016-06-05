<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>

<meta charset="utf-8">
<!--Import Google Icon Font-->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet"
	href="<c:url value='/resources/common/css/materialize.min.css'/>"
	media="screen,projection" />

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<!--Import jQuery before materialize.js-->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript"
	src="<c:url value='/resources/common/js/materialize.min.js'/>"></script>

<!--Common Style-->
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/common/css/style.css'/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/hiringviet/home/css/navbar.css'/>">

<!--common js-->
<script type="text/javascript"
	src="<c:url value='/resources/hiringviet/home/js/common.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/resources/hiringviet/home/js/search.js'/>"></script>
</head>
<body>
	<nav>
	<ul id="slide-out" class="side-nav">
		<li class="mobile-search center"><input type="text"
			placeholder="Tìm kiếm công việc, công ty, người dùng,..."> <a
			href="#" class="btn">Tìm kiếm</a></li>
		<li><a href="#!">Đăng nhập</a></li>
		<li><a href="#!">Đăng ký</a></li>
	</ul>
	<a href="#" data-activates="slide-out" class="button-collapse"><i
		class="material-icons white-text">menu</i></a> </nav>
	<header>
	<div id="topnav">
		<a href="#" class="navbar-logo left"> <img
			class="navbar-logo-img responsive-img"
			src="/resources/common/images/small_logo.png">
		</a>
		<div class="right">
			<div id="search-bar">
				<div id="search-input" class="left">
					<input type="text" id="search-auto-complete"
						placeholder="Tìm kiếm công việc, công ty, người dùng,...">
					<p class="search-hint">
						<spring:message code="label.navbar.title.key_word" />
						: Thông dịch viên, lập trình Java, lập trình PHP...
					</p>
					<div id="suggestion-box" class="z-depth-1">
						<div class="search-progress">
							<img src="/resources/images/loading.gif" />
							<p>
								<spring:message code="label.navbar.title.process_search" />
							</p>
						</div>
						<ul class="wrap-search-results">

						</ul>
					</div>
				</div>
				<a id="search-btn" class="circle-btn left orange darken-1 noselect">
					<i class="material-icons white-text">search</i>
				</a>

				<div class="menu-group">
					<a id="menu-btn" class="circle-btn red lighten-2 noselect"> <i
						class="material-icons white-text">menu</i>
					</a>
					<div id="dropdown-menu" class="z-depth-1">
						<div class="top-menu-box">
							<c:if test="${empty memberDTO }">
								<div id="login-box">
									<h1 class="title info center">
										<spring:message code="label.login.button.sign_in" />
									</h1>
									<div class="rectangle-input">
										<label for="email-login"> <spring:message
												code="label.login.field.email_title" />:
										</label> <input id="email-login" type="text" class="validate"></input>
									</div>
									<div class="rectangle-input">
										<label for="email-login"> <spring:message
												code="label.login.field.password_title" />:
										</label> <input id="password-login" type="text" class="validate"></input>
									</div>
									<p>
										<input type="checkbox" id="test5" /> <label for="test5"><spring:message
												code="label.login.title.remember_account" /></label>
									</p>
									<div class="margin-top-10 center">
										<a id="login-btn" href="#" class="btn"><spring:message
												code="label.login.button.sign_in" /></a>
									</div>
								</div>
							</c:if>
							<c:if test="${not empty memberDTO}">
								<div id="profile">
									<img src="/resources/images/profile_photo.jpg"
										class="circle profile-photo">
									<h5>
										<a href="#">Võ Tấn Lộc</a>
									</h5>
									<h6>
										<a href="#"><spring:message
												code="label.navbar.title.add_skill" /></a>
									</h6>
								</div>
							</c:if>
						</div>
						<c:if test="${not empty memberDTO}">
							<ul class="menu-item">
								<li>
									<div class="menu-item-header">
										<a href="#"><i class="material-icons prefix-icon">account_box</i>
											<spring:message code="label.navbar.title.profile" /> </a>
									</div>
									<div class="menu-item-body">
										<ul>
											<li><a href="#"><spring:message
														code="label.navbar.title.edit_profile" /></a></li>
											<li><a href="#"><spring:message
														code="label.navbar.title.visiting_number" /></a></li>
											<li><a href="#"><spring:message
														code="label.navbar.title.activity_log" /></a></li>
											<li><a href="#"><spring:message
														code="label.navbar.title.mailbox" /></a></li>
										</ul>
									</div>
								</li>
								<li>
									<div class="menu-item-header">
										<a href="#"><i class="material-icons prefix-icon">add_alert</i>Thông
											báo</a>
										<div class="chip red lighten-2 white-text noti-count">5</div>
									</div>
								</li>
								<li>
									<div class="menu-item-header">
										<a href="#"><i class="material-icons prefix-icon">donut_large</i>
										<spring:message code="label.navbar.title.follow" /></a>
									</div>
									<div class="menu-item-body">
										<ul>
											<li><a href="#">Người đang theo dõi</a></li>
											<li><a href="#">Công ty đang theo dõi</a></li>
										</ul>
									</div>
								</li>
								<li>
									<div class="menu-item-header">
										<a href="#"><i class="material-icons prefix-icon">bookmark</i>Quản
											lý nghề nghiệp</a>
									</div>
									<div class="menu-item-body">
										<ul>
											<li><a href="#">Công việc đã lưu</a></li>
											<li><a href="#">Công việc đề xuất</a></li>
										</ul>
									</div>
								</li>
								<li>
									<div class="menu-item-header">
										<a href="#"><i class="material-icons prefix-icon">account_circle</i>
											<spring:message code="label.navbar.title.account" /> </a>
									</div>
								</li>
								<li>
									<div class="menu-item-header">
										<a href="#"><i class="material-icons prefix-icon">exit_to_app</i>
											<spring:message code="label.navbar.title.sign_out" /> </a>
									</div>
								</li>
							</ul>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>
	</header>
</body>
</html>