<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/hiringviet/home/css/navbar.css'/>">
<script type="text/javascript" src="<c:url value='/resources/hiringviet/login/js/login.js'/>" ></script>
</head>
<body>
	<input type="hidden" id="url_redirect_page"
		value="<c:url value='/home' />" />
	<input type="hidden" id="url_check_account"
		value="<c:url value='/account/checkAccount' />" />
	<input type="hidden" id="url_search"
		value="<c:url value='/search/suggest' />" />
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
							<c:if test="${empty account }">
								<div id="login-box">
									<h1 class="title info center">
										<spring:message code="label.login.button.sign_in" />
									</h1>
									<p id="email_requierd" class="txt-errors margin-bottom-5">
										<spring:message code="label.login.errors.email_required" />
									</p>
									<p id="password_requierd" class="txt-errors margin-bottom-5">
										<spring:message code="label.login.errors.password_required" />
									</p>
									<p id="email_or_password_wrong"
										class="txt-errors margin-bottom-5">
										<spring:message
											code="label.login.errors.email_or_password_wrong" />
									</p>
									<p id="email_max_length" class="txt-errors margin-bottom-5">
										<spring:message code="label.login.errors.email_max_length" />
									</p>
									<p id="password_max_length" class="txt-errors margin-bottom-5">
										<spring:message code="label.login.errors.password_max_length" />
									</p>
									<div class="input-field">
										<label for="txtEmail"
											data-error="<spring:message code='label.login.errors.email_format' />"
											data-success=""> <spring:message
												code="label.login.field.email_title" />
										</label> <input id="txtEmail" type="text" class="validate"></input>
									</div>
									<div class="input-field">
										<label for="txtPassword"> <spring:message
												code="label.login.field.password_title" />
										</label> <input id="txtPassword" type="password" class="validate"></input>
									</div>
									<p>
										<input type="checkbox" id="remember_cb" /> <label
											for="remember_cb"> <spring:message
												code="label.login.title.remember_account" />
										</label>
									</p>
									<div class="margin-top-10 center">
										<a id="btn-sign-in" href="#" class="btn"> <spring:message
												code="label.login.button.sign_in" />
										</a>
									</div>
								</div>
							</c:if>
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
							<c:choose>
								<c:when test="${account.roleID == 0}">
								</c:when>
								<c:when test="${account.roleID == 2}">
								</c:when>
								<c:otherwise>
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
								</c:otherwise>
							</c:choose>
						</c:if>
					</div>
				</div>
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
</body>

</html>