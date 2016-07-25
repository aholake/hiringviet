<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/hiringviet/home/css/navbar.css'/>">
<script type="text/javascript"
	src="<c:url value='/resources/hiringviet/login/js/login.js'/>"></script>
</head>
<body>
	<input type="hidden" id="url_redirect_page"
		value="<c:url value='/home' />" />
	<input type="hidden" id="url_check_account"
		value="<c:url value='/account/checkAccount' />" />
	<input type="hidden" id="url_search"
		value="<c:url value='/search/suggest' />" />

	<input type="hidden" id="title_follow"
		value="<spring:message code='label.navbar.title.follow'/>" />
	<input type="hidden" id="title_employee"
		value="<spring:message code='label.home.title.employee'/>" />

	<nav>
	<ul id="slide-out" class="side-nav">
		<li class="mobile-search center"><input type="text"
			placeholder="Tìm kiếm công việc, công ty, người dùng,..."> <a
			href="#" class="btn">Tìm kiếm</a></li>
		<li><a href="#!">Đăng nhập</a></li>
		<li><a href="#!">Đăng ký</a></li>
	</ul>
	<a href="#" data-activates="slide-out" class="button-collapse"> <i
		class="material-icons white-text">menu</i>
	</a> </nav>
	<header>
	<div id="topnav">
		<a href="#" class="navbar-logo left"> <img
			class="navbar-logo-img responsive-img"
			src="/resources/common/images/small_logo.png">
		</a>
		<div class="right">
			<div id="search-bar">
				<div id="search-input" class="left">
					<div class="mp0 display-flex">
						<!-- Dropdown Trigger -->
						<div class="dropdown-button" data-activates='search-menu'>
							<i class="material-icons">menu</i>
						</div>
						<!-- Dropdown Structure -->
						<ul id="search-menu" class="dropdown-content">
							<li><a href="#!"><spring:message
										code="label.navbar.title.search.menu.add" /></a></li>
							<li class="divider"></li>
							<li><a href="#!"><spring:message
										code="label.navbar.title.search.menu.company" /></a></li>
							<li class="divider"></li>
							<li><a href="#!"><spring:message
										code="label.navbar.title.search.menu.member" /></a></li>
							<li class="divider"></li>
							<li><a href="#!"><spring:message
										code="label.navbar.title.search.menu.skill" /></a></li>
							<li class="divider"></li>
							<li><a href="#!"><spring:message
										code="label.navbar.title.search.menu.job" /></a></li>
						</ul>
						<input type="text" id="search-auto-complete"
							placeholder="<spring:message code='label.navbar.title.search.placeholder' />">
					</div>
					<p class="search-hint">
						<spring:message code="label.navbar.title.key_word" />
						:
						<spring:message code="label.navbar.title.search.keywork" />
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
				<sec:authorize access="isAnonymous()">
					<a class="menu-group modal-trigger" href="#modal1"> <span
						id="menu-btn" class="circle-btn noselect"> <i
							class="material-icons">account_circle</i>
					</span>
					</a>
				</sec:authorize>
				<c:if test="${not empty account}">
					<a class="menu-group"> <span id="menu-btn"
						class="circle-btn red lighten-2 noselect"> <i
							class="material-icons white-text">menu</i>
					</span>
						<div id="dropdown-menu" class="z-depth-1">
							<div class="top-menu-box">
								<c:if test="${not empty account}">
									<c:choose>
										<c:when test="${account.roleID == 0}">
										</c:when>
										<c:when test="${account.roleID == 2}">
											<div id="profile">
												<img src="/resources/images/profile_photo.jpg"
													class="circle profile-photo">
												<h5>
													<a href="#">Võ Tấn Lộc</a>
												</h5>
											</div>
										</c:when>
										<c:otherwise>
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
										</c:otherwise>
									</c:choose>
								</c:if>
							</div>
							<c:if test="${not empty account}">
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
					</a>
				</c:if>
			</div>
		</div>
	</div>
	</header>
	<!--common js-->
	<script type="text/javascript"
		src="<c:url value='/resources/hiringviet/home/js/common.js'/>"></script>
	<script type="text/javascript"
		src="<c:url value='/resources/hiringviet/home/js/search.js'/>"></script>
</head>

<!-- Modal Structure -->
<c:url value="/login" var="loginUrl"></c:url>
<div id="modal1" class="modal">
	<div class="modal-content">
		<h5 class="center-align">Đăng nhập</h5>
		<p id="login-error" class="center-align red-text"></p>
		<div class="row">
			<form id="loginForm" class="col s6" action="${loginUrl}"
				method="post">
				<div class="row">
					<div class="input-field col s12 p-0">
						<input id="email" type="email" name="email" value=""
							class="validate" required="required"/> <label for="email"
							data-error="Sai định dạng">Email</label>
					</div>
					<div class="input-field col s12 p-0">
						<input id="password" type="password" name="password" value=""
							minlength="6" class="validate" required="required"/> <label for="password"
							data-error="Mật khẩu quá ngắn">Password</label>
					</div>
					<div class="col s12 p-0">
						<input type="checkbox" id="remember" /> <label for="remember">Remember
							me</label>
					</div>
					<div class="col s12 p-0">
						<button id="submitBtn" type="submit"
							class="waves-effect waves-light btn long-btn">Đăng nhập</button>
					</div>
				</div>
			</form>
			<div class="col m6">
				<div class="row">
					<div class="col s12 p-0">
						<a class="waves-effect waves-light btn long-btn blue darken-4"><i
							class="fa fa-facebook-official" aria-hidden="true"></i>Đăng nhập
							bằng Facebook</a>
					</div>
					<div class="col s12 p-0">
						<a class="waves-effect waves-light btn long-btn orange darken-4"><i
							class="fa fa-google-plus" aria-hidden="true"></i>Đăng nhập bằng
							Google</a>
					</div>
					<div class="col s12 p-0">
						<a class="waves-effect waves-light btn long-btn grey darken-4">Đăng
							ký</a>
					</div>
					<div class="col s12 p-0">
						<a
							class="waves-effect waves-light btn long-btn deep-orange accent-4">Đóng</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
	$(function() {
		$('.modal-trigger').leanModal();
	})

	$("#loginForm").submit(function(e) {
		e.preventDefault();
		console.log("Login progress start...")
		var email = $("#email").val();
		var password = $("#password").val();
		var url = "/action/login?email=" + email + "&password=" + password;
		callAPI(url, 'POST', '', 'processLogin');
	});

	function processLogin(data) {
		console.log(data);
		if (data.success) {
			location.reload();
		} else {
			$("#login-error").html(data.message);
		}
	}
</script>
</body>

</html>