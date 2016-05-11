<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<meta charset="utf-8">
<!--Import Google Icon Font-->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet" href="/resources/css/materialize.min.css"
	media="screen,projection" />

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<!--Import jQuery before materialize.js-->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="/resources/js/materialize.min.js"></script>

<!--Common Style-->
<link rel="stylesheet" type="text/css" href="/resources/css/style.css">
<link rel="stylesheet" type="text/css" href="/resources/css/navbar.css">

<!--common js-->
<script type="text/javascript" src="/resources/js/common.js"></script>
<script type="text/javascript" src="/resources/js/search.js"></script>
</head>
<body>
	<header>
		<div id="topnav">
			<a href="#" class="navbar-logo left">
				<img class="navbar-logo-img responsive-img" src="/resources/images/small_logo.png">
			</a>
			<div class="right">
				<div id="search-bar">
					<div id="search-input" class="left">
						<input type="text" id="search-auto-complete" placeholder="Tìm kiếm công việc, công ty, người dùng,...">
						<p class="search-hint">Từ khóa: Thông dịch viên, lập trình Java, lập trình PHP...</p>
						<div id="suggestion-box" class="z-depth-1">
							<div class="search-progress">
								<img src="/resources/images/loading.gif" />
								<p>Đang tìm kiếm kết quả</p>
							</div>
							<ul class="wrap-search-results">
								
							</ul>
						</div>
					</div>
					<a id="search-btn" class="circle-btn left blue lighten-2 noselect">
						<i class="material-icons white-text">search</i>
					</a>

					<div class="menu-group">
						<a id="menu-btn" class="circle-btn red lighten-2 noselect">
							<i class="material-icons white-text">menu</i>
						</a>
						<div id="dropdown-menu" class="z-depth-1">
							<div class="top-menu-box">
								<div id="login-box">
									<h1 class="title info center">Đăng nhập</h1>
									<div class="rectangle-input">
										<label for="email-login">
											Email:
										</label>
										<input id="email-login" type="text" class="validate"></input>
									</div>
									<div class="rectangle-input">
										<label for="email-login">
											Password:
										</label>
										<input id="password-login" type="text" class="validate"></input>
									</div>
									<p>
										<input type="checkbox" id="test5" />
										<label for="test5">Ghi nhớ đăng nhập</label>
									</p>
									<div class="margin-top-10 center">
										<a id="login-btn" href="#" class="btn">Đăng nhập</a>
									</div>
								</div>
								<div id="profile">
									<img src="/resources/images/profile_photo.jpg" class="circle profile-photo">
									<h5><a href="#">Võ Tấn Lộc</a></h5>
									<h6><a href="#">Thêm kỹ năng</a></h6>
								</div>
							</div>
							<ul class="menu-item">
								<li>
									<div class="menu-item-header"><a href="#"><i class="material-icons prefix-icon">account_box</i>Hồ sơ cá nhân</a></div>
									<div class="menu-item-body">
										<ul>
											<li><a href="#">Chỉnh sửa hồ sơ</a></li>
											<li><a href="#">Người xem hồ sơ</a></li>
											<li><a href="#">Nhật ký hoạt động</a></li>
											<li><a href="#">Hòm thư</a></li>
										</ul>
									</div>
								</li>
								<li>
									<div class="menu-item-header"><a href="#"><i class="material-icons prefix-icon">add_alert</i>Thông báo</a>
										<div class="chip red lighten-2 white-text noti-count">5</div>
									</div>
								</li>
								<li>
									<div class="menu-item-header"><a href="#"><i class="material-icons prefix-icon">donut_large</i>Theo dõi</a></div>
									<div class="menu-item-body">
										<ul>
											<li><a href="#">Người đang theo dõi</a></li>
											<li><a href="#">Công ty đang theo dõi</a></li>
										</ul>
									</div>
								</li>
								<li>
									<div class="menu-item-header"><a href="#"><i class="material-icons prefix-icon">bookmark</i>Quản lý nghề nghiệp</a></div>
									<div class="menu-item-body">
										<ul>
											<li><a href="#">Công việc đã lưu</a></li>
											<li><a href="#">Công việc đề xuất</a></li>
										</ul>
									</div>
								</li>
								<li>
									<div class="menu-item-header"><a href="#"><i class="material-icons prefix-icon">account_circle</i>Tài khoản</a></div>
								</li>
								<li>
									<div class="menu-item-header"><a href="#"><i class="material-icons prefix-icon">exit_to_app</i>Thoát</a></div>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>
</body>
</html>