<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title><spring:message code="label.title.home" /></title>
<meta charset="utf-8">
<!--Import Google Icon Font-->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/common/css/materialize.min.css'/>" media="screen,projection" />

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<!--Import jQuery before materialize.js-->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="<c:url value='/resources/common/js/materialize.min.js'/>"></script>

<!--Custom Style-->
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/common/css/style.css'/>" >
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/hiringviet/home/css/home.css'/>" >
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/hiringviet/home/css/navbar.css'/>" >

<!--custom js-->
<script type="text/javascript" src="<c:url value='/resources/hiringviet/home/js/script.js'/>" ></script>
<script type="text/javascript" src="<c:url value='/resources/hiringviet/home/js/common.js'/>" ></script>
<script type="text/javascript" src="<c:url value='/resources/hiringviet/home/js/search.js'/>" ></script>
<script type="text/javascript" src="<c:url value='/resources/hiringviet/home/js/home.js'/>" ></script>

<!--JCarousel -->
<script type="text/javascript" src="<c:url value='/resources/common/js/jquery.jcarousel.min.js'/>" ></script>

<!--Scroll to Fixed-->
<script type="text/javascript" src="<c:url value='/resources/common/js/jquery-scrolltofixed-min.js'/>" ></script>
</head>
<body onclick="onClickToBody()">
	<header>
		<div id="topnav">
			<a href="#" class="navbar-logo left"> <img
				class="navbar-logo-img responsive-img" src="/resources/common/images/small_logo.png">
			</a>
			<div class="right">
				<div id="search-bar">
					<div id="search-input" class="left">
						<input type="text" id="search-auto-complete"
							placeholder="Tìm kiếm công việc, công ty, người dùng,...">
						<p class="search-hint">Từ khóa: Thông dịch viên, lập trình
							Java, lập trình PHP...</p>
						<div id="suggestion-box" class="z-depth-1">
							<div class="search-progress">
								<img src="images/loading.gif" />
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
						<a id="menu-btn" class="circle-btn red lighten-2 noselect"> <i
							class="material-icons white-text">menu</i>
						</a>
						<div id="dropdown-menu" class="z-depth-1">
							<div class="top-menu-box">
								<div id="login-box">
									<h1 class="title info center">Đăng nhập</h1>
									<div class="rectangle-input">
										<label for="email-login"> Email: </label> <input
											id="email-login" type="text" class="validate"></input>
									</div>
									<div class="rectangle-input">
										<label for="email-login"> Password: </label> <input
											id="password-login" type="text" class="validate"></input>
									</div>
									<p>
										<input type="checkbox" id="test5" /> <label for="test5">Ghi
											nhớ đăng nhập</label>
									</p>
									<div class="margin-top-10 center">
										<a id="login-btn" href="#" class="btn">Đăng nhập</a>
									</div>
								</div>
								<div id="profile">
									<img src="images/profile_photo.jpg"
										class="circle profile-photo">
									<h5>
										<a href="#">Võ Tấn Lộc</a>
									</h5>
									<h6>
										<a href="#">Thêm kỹ năng</a>
									</h6>
								</div>
							</div>
							<ul class="menu-item">
								<li>
									<div class="menu-item-header">
										<a href="#"><i class="material-icons prefix-icon">account_box</i>Hồ
											sơ cá nhân</a>
									</div>
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
									<div class="menu-item-header">
										<a href="#"><i class="material-icons prefix-icon">add_alert</i>Thông
											báo</a>
										<div class="chip red lighten-2 white-text noti-count">5</div>
									</div>
								</li>
								<li>
									<div class="menu-item-header">
										<a href="#"><i class="material-icons prefix-icon">donut_large</i>Theo
											dõi</a>
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
										<a href="#"><i class="material-icons prefix-icon">account_circle</i>Tài
											khoản</a>
									</div>
								</li>
								<li>
									<div class="menu-item-header">
										<a href="#"><i class="material-icons prefix-icon">exit_to_app</i>Thoát</a>
									</div>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>

	<div id="introduce-slider"></div>

	<div id="main-container">
		<div class="row">
			<div class="col m8">
				<div class="card-panel">
					<div class="panel-title">Công việc nổi bật</div>

					<div class="panel-content">
						<div class="job-box">
							<div class="location-sticky">Hồ Chí Minh</div>
							<div class="row none-margin-bottom">
								<div class="col s3 center">
									<img src="images/Hewlett-Packard-Logo-200x200.png"
										class="responsive-img company-logo"> <a href="#"
										class="btn wave-effect wave-light">Follow</a>
								</div>

								<div class="col s9">
									<h1 class="title">Tuyển 5 .NET Developer</h1>
									<a href="#" class="company-name">Công ty cổ phần HP
										Computer</a>

									<div class="job-info">
										<div class="row">
											<div class="col m6 none-padding-left">
												<p>
													Lương: <span class="info">Thỏa thuận</span>
												</p>
											</div>
											<div class="col m6 none-padding-left">
												<span class="right">Ngày đăng: <span class="info">20/12/2016</span>
												</span>
											</div>
											<div class="col m6 none-padding-left">
												<p>
													Chức vụ: <span class="info">Developer</span>
												</p>
											</div>
											<div class="col m6 none-padding-left">
												<span class="right">Số lượng: <span class="info">5
														người</span>
												</span>
											</div>
										</div>
										<div class="row">
											<p class="col m12 none-padding-left">Xây dựng các ứng
												dụng trên Android cho các hệ thống tài chính, Ngân
												hàng.Nghiên cứu, tìm kiếm giải pháp...</p>
											<div class="col m12 none-padding-left">
												<a class="chip">Java</a> <a class="chip">ASP.NET</a> <a
													class="chip">SQL</a> <a class="chip">English</a> <a
													class="chip">University</a>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="job-box">
							<div class="location-sticky">Hồ Chí Minh</div>
							<div class="row none-margin-bottom">
								<div class="col s3 center">
									<img src="images/Hewlett-Packard-Logo-200x200.png"
										class="responsive-img company-logo"> <a href="#"
										class="btn wave-effect wave-light">Follow</a>
								</div>

								<div class="col s9">
									<h1 class="title">Tuyển 5 .NET Developer</h1>
									<a href="#" class="company-name">Công ty cổ phần HP
										Computer</a>

									<div class="job-info">
										<div class="row">
											<div class="col m6 none-padding-left">
												<p>
													Lương: <span class="info">Thỏa thuận</span>
												</p>
											</div>
											<div class="col m6 none-padding-left">
												<span class="right">Ngày đăng: <span class="info">20/12/2016</span>
												</span>
											</div>
											<div class="col m6 none-padding-left">
												<p>
													Chức vụ: <span class="info">Developer</span>
												</p>
											</div>
											<div class="col m6 none-padding-left">
												<span class="right">Số lượng: <span class="info">5
														người</span>
												</span>
											</div>
										</div>
										<div class="row">
											<p class="col m12 none-padding-left">Xây dựng các ứng
												dụng trên Android cho các hệ thống tài chính, Ngân
												hàng.Nghiên cứu, tìm kiếm giải pháp...</p>
											<div class="col m12 none-padding-left">
												<a class="chip">Java</a> <a class="chip">ASP.NET</a> <a
													class="chip">SQL</a> <a class="chip">English</a> <a
													class="chip">University</a>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="job-box">
							<div class="location-sticky">Hồ Chí Minh</div>
							<div class="row none-margin-bottom">
								<div class="col s3 center">
									<img src="images/Hewlett-Packard-Logo-200x200.png"
										class="responsive-img company-logo"> <a href="#"
										class="btn wave-effect wave-light">Follow</a>
								</div>

								<div class="col s9">
									<h1 class="title">Tuyển 5 .NET Developer</h1>
									<a href="#" class="company-name">Công ty cổ phần HP
										Computer</a>

									<div class="job-info">
										<div class="row">
											<div class="col m6 none-padding-left">
												<p>
													Lương: <span class="info">Thỏa thuận</span>
												</p>
											</div>
											<div class="col m6 none-padding-left">
												<span class="right">Ngày đăng: <span class="info">20/12/2016</span>
												</span>
											</div>
											<div class="col m6 none-padding-left">
												<p>
													Chức vụ: <span class="info">Developer</span>
												</p>
											</div>
											<div class="col m6 none-padding-left">
												<span class="right">Số lượng: <span class="info">5
														người</span>
												</span>
											</div>
										</div>
										<div class="row">
											<p class="col m12 none-padding-left">Xây dựng các ứng
												dụng trên Android cho các hệ thống tài chính, Ngân
												hàng.Nghiên cứu, tìm kiếm giải pháp...</p>
											<div class="col m12 none-padding-left">
												<a class="chip">Java</a> <a class="chip">ASP.NET</a> <a
													class="chip">SQL</a> <a class="chip">English</a> <a
													class="chip">University</a>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="job-box">
							<div class="location-sticky">Hồ Chí Minh</div>
							<div class="row none-margin-bottom">
								<div class="col s3 center">
									<img src="images/Hewlett-Packard-Logo-200x200.png"
										class="responsive-img company-logo"> <a href="#"
										class="btn wave-effect wave-light">Follow</a>
								</div>

								<div class="col s9">
									<h1 class="title">Tuyển 5 .NET Developer</h1>
									<a href="#" class="company-name">Công ty cổ phần HP
										Computer</a>

									<div class="job-info">
										<div class="row">
											<div class="col m6 none-padding-left">
												<p>
													Lương: <span class="info">Thỏa thuận</span>
												</p>
											</div>
											<div class="col m6 none-padding-left">
												<span class="right">Ngày đăng: <span class="info">20/12/2016</span>
												</span>
											</div>
											<div class="col m6 none-padding-left">
												<p>
													Chức vụ: <span class="info">Developer</span>
												</p>
											</div>
											<div class="col m6 none-padding-left">
												<span class="right">Số lượng: <span class="info">5
														người</span>
												</span>
											</div>
										</div>
										<div class="row">
											<p class="col m12 none-padding-left">Xây dựng các ứng
												dụng trên Android cho các hệ thống tài chính, Ngân
												hàng.Nghiên cứu, tìm kiếm giải pháp...</p>
											<div class="col m12 none-padding-left">
												<a class="chip">Java</a> <a class="chip">ASP.NET</a> <a
													class="chip">SQL</a> <a class="chip">English</a> <a
													class="chip">University</a>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="job-box">
							<div class="location-sticky">Hồ Chí Minh</div>
							<div class="row none-margin-bottom">
								<div class="col s3 center">
									<img src="images/Hewlett-Packard-Logo-200x200.png"
										class="responsive-img company-logo"> <a href="#"
										class="btn wave-effect wave-light">Follow</a>
								</div>

								<div class="col s9">
									<h1 class="title">Tuyển 5 .NET Developer</h1>
									<a href="#" class="company-name">Công ty cổ phần HP
										Computer</a>

									<div class="job-info">
										<div class="row">
											<div class="col m6 none-padding-left">
												<p>
													Lương: <span class="info">Thỏa thuận</span>
												</p>
											</div>
											<div class="col m6 none-padding-left">
												<span class="right">Ngày đăng: <span class="info">20/12/2016</span>
												</span>
											</div>
											<div class="col m6 none-padding-left">
												<p>
													Chức vụ: <span class="info">Developer</span>
												</p>
											</div>
											<div class="col m6 none-padding-left">
												<span class="right">Số lượng: <span class="info">5
														người</span>
												</span>
											</div>
										</div>
										<div class="row">
											<p class="col m12 none-padding-left">Xây dựng các ứng
												dụng trên Android cho các hệ thống tài chính, Ngân
												hàng.Nghiên cứu, tìm kiếm giải pháp...</p>
											<div class="col m12 none-padding-left">
												<a class="chip">Java</a> <a class="chip">ASP.NET</a> <a
													class="chip">SQL</a> <a class="chip">English</a> <a
													class="chip">University</a>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="job-box">
							<div class="location-sticky">Hồ Chí Minh</div>
							<div class="row none-margin-bottom">
								<div class="col s3 center">
									<img src="images/Hewlett-Packard-Logo-200x200.png"
										class="responsive-img company-logo"> <a href="#"
										class="btn wave-effect wave-light">Follow</a>
								</div>

								<div class="col s9">
									<h1 class="title">Tuyển 5 .NET Developer</h1>
									<a href="#" class="company-name">Công ty cổ phần HP
										Computer</a>

									<div class="job-info">
										<div class="row">
											<div class="col m6 none-padding-left">
												<p>
													Lương: <span class="info">Thỏa thuận</span>
												</p>
											</div>
											<div class="col m6 none-padding-left">
												<span class="right">Ngày đăng: <span class="info">20/12/2016</span>
												</span>
											</div>
											<div class="col m6 none-padding-left">
												<p>
													Chức vụ: <span class="info">Developer</span>
												</p>
											</div>
											<div class="col m6 none-padding-left">
												<span class="right">Số lượng: <span class="info">5
														người</span>
												</span>
											</div>
										</div>
										<div class="row">
											<p class="col m12 none-padding-left">Xây dựng các ứng
												dụng trên Android cho các hệ thống tài chính, Ngân
												hàng.Nghiên cứu, tìm kiếm giải pháp...</p>
											<div class="col m12 none-padding-left">
												<a class="chip">Java</a> <a class="chip">ASP.NET</a> <a
													class="chip">SQL</a> <a class="chip">English</a> <a
													class="chip">University</a>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="job-box">
							<div class="location-sticky">Hồ Chí Minh</div>
							<div class="row none-margin-bottom">
								<div class="col s3 center">
									<img src="images/Hewlett-Packard-Logo-200x200.png"
										class="responsive-img company-logo"> <a href="#"
										class="btn wave-effect wave-light">Follow</a>
								</div>

								<div class="col s9">
									<h1 class="title">Tuyển 5 .NET Developer</h1>
									<a href="#" class="company-name">Công ty cổ phần HP
										Computer</a>

									<div class="job-info">
										<div class="row">
											<div class="col m6 none-padding-left">
												<p>
													Lương: <span class="info">Thỏa thuận</span>
												</p>
											</div>
											<div class="col m6 none-padding-left">
												<span class="right">Ngày đăng: <span class="info">20/12/2016</span>
												</span>
											</div>
											<div class="col m6 none-padding-left">
												<p>
													Chức vụ: <span class="info">Developer</span>
												</p>
											</div>
											<div class="col m6 none-padding-left">
												<span class="right">Số lượng: <span class="info">5
														người</span>
												</span>
											</div>
										</div>
										<div class="row">
											<p class="col m12 none-padding-left">Xây dựng các ứng
												dụng trên Android cho các hệ thống tài chính, Ngân
												hàng.Nghiên cứu, tìm kiếm giải pháp...</p>
											<div class="col m12 none-padding-left">
												<a class="chip">Java</a> <a class="chip">ASP.NET</a> <a
													class="chip">SQL</a> <a class="chip">English</a> <a
													class="chip">University</a>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col m4">
				<div class="card-panel">
					<div class="panel-title">Công ty nổi bật</div>
					<div class="panel-content">
						<div class="company-box">
							<a href="#" class="follow-sticky"> Theo dõi </a>
							<div class="row">
								<div class="col s9">
									<h1 class="title">Công ty Tân Hiệp phát</h1>
									<div class="small-text">
										<p class="col s12 none-padding-left">
											<i class="material-icons prefix-icon">flag</i>Quốc gia: <span
												class="info">Mỹ</span>
										</p>
										<p class="col s12 none-padding-left">
											<i class="material-icons prefix-icon">equalizer</i>Quy mô: <span
												class="info">200-500 người</span>
										</p>
										<p class="col s12 none-padding-left">
											<i class="material-icons prefix-icon">web</i>Website: <span
												class="info">www.materialize.com</span>
										</p>
										<p class="col s12 none-padding-left">
											<i class="material-icons prefix-icon">location_on</i>Địa chỉ:
											<span class="info">4/3 Đồ Sơn, P. 13, Quận Tân Bình,
												TP.HCM</span>
										</p>
									</div>
								</div>
								<div class="col s3">
									<img src="images/Hewlett-Packard-Logo-200x200.png"
										class="right responsive-img">
								</div>
							</div>
						</div>
						<div class="company-box">
							<a href="#" class="follow-sticky"> Theo dõi </a>
							<div class="row">
								<div class="col s9">
									<h1 class="title">Công ty Tân Hiệp phát</h1>
									<div class="small-text">
										<p class="col s12 none-padding-left">
											<i class="material-icons prefix-icon">flag</i>Quốc gia: <span
												class="info">Mỹ</span>
										</p>
										<p class="col s12 none-padding-left">
											<i class="material-icons prefix-icon">equalizer</i>Quy mô: <span
												class="info">200-500 người</span>
										</p>
										<p class="col s12 none-padding-left">
											<i class="material-icons prefix-icon">web</i>Website: <span
												class="info">www.materialize.com</span>
										</p>
										<p class="col s12 none-padding-left">
											<i class="material-icons prefix-icon">location_on</i>Địa chỉ:
											<span class="info">4/3 Đồ Sơn, P. 13, Quận Tân Bình,
												TP.HCM</span>
										</p>
									</div>
								</div>
								<div class="col s3">
									<img src="images/Hewlett-Packard-Logo-200x200.png"
										class="right responsive-img">
								</div>
							</div>
						</div>
						<div class="company-box">
							<a href="#" class="follow-sticky"> Theo dõi </a>
							<div class="row">
								<div class="col s9">
									<h1 class="title">Công ty Tân Hiệp phát</h1>
									<div class="small-text">
										<p class="col s12 none-padding-left">
											<i class="material-icons prefix-icon">flag</i>Quốc gia: <span
												class="info">Mỹ</span>
										</p>
										<p class="col s12 none-padding-left">
											<i class="material-icons prefix-icon">equalizer</i>Quy mô: <span
												class="info">200-500 người</span>
										</p>
										<p class="col s12 none-padding-left">
											<i class="material-icons prefix-icon">web</i>Website: <span
												class="info">www.materialize.com</span>
										</p>
										<p class="col s12 none-padding-left">
											<i class="material-icons prefix-icon">location_on</i>Địa chỉ:
											<span class="info">4/3 Đồ Sơn, P. 13, Quận Tân Bình,
												TP.HCM</span>
										</p>
									</div>
								</div>
								<div class="col s3">
									<img src="images/Hewlett-Packard-Logo-200x200.png"
										class="right responsive-img">
								</div>
							</div>
						</div>
						<div class="company-box">
							<a href="#" class="follow-sticky"> Theo dõi </a>
							<div class="row">
								<div class="col s9">
									<h1 class="title">Công ty Tân Hiệp phát</h1>
									<div class="small-text">
										<p class="col s12 none-padding-left">
											<i class="material-icons prefix-icon">flag</i>Quốc gia: <span
												class="info">Mỹ</span>
										</p>
										<p class="col s12 none-padding-left">
											<i class="material-icons prefix-icon">equalizer</i>Quy mô: <span
												class="info">200-500 người</span>
										</p>
										<p class="col s12 none-padding-left">
											<i class="material-icons prefix-icon">web</i>Website: <span
												class="info">www.materialize.com</span>
										</p>
										<p class="col s12 none-padding-left">
											<i class="material-icons prefix-icon">location_on</i>Địa chỉ:
											<span class="info">4/3 Đồ Sơn, P. 13, Quận Tân Bình,
												TP.HCM</span>
										</p>
									</div>
								</div>
								<div class="col s3">
									<img src="images/Hewlett-Packard-Logo-200x200.png"
										class="right responsive-img">
								</div>
							</div>
						</div>
						<div class="company-box">
							<a href="#" class="follow-sticky"> Theo dõi </a>
							<div class="row">
								<div class="col s9">
									<h1 class="title">Công ty Tân Hiệp phát</h1>
									<div class="small-text">
										<p class="col s12 none-padding-left">
											<i class="material-icons prefix-icon">flag</i>Quốc gia: <span
												class="info">Mỹ</span>
										</p>
										<p class="col s12 none-padding-left">
											<i class="material-icons prefix-icon">equalizer</i>Quy mô: <span
												class="info">200-500 người</span>
										</p>
										<p class="col s12 none-padding-left">
											<i class="material-icons prefix-icon">web</i>Website: <span
												class="info">www.materialize.com</span>
										</p>
										<p class="col s12 none-padding-left">
											<i class="material-icons prefix-icon">location_on</i>Địa chỉ:
											<span class="info">4/3 Đồ Sơn, P. 13, Quận Tân Bình,
												TP.HCM</span>
										</p>
									</div>
								</div>
								<div class="col s3">
									<img src="images/Hewlett-Packard-Logo-200x200.png"
										class="right responsive-img">
								</div>
							</div>
						</div>
						<div class="company-box">
							<a href="#" class="follow-sticky"> Theo dõi </a>
							<div class="row">
								<div class="col s9">
									<h1 class="title">Công ty Tân Hiệp phát</h1>
									<div class="small-text">
										<p class="col s12 none-padding-left">
											<i class="material-icons prefix-icon">flag</i>Quốc gia: <span
												class="info">Mỹ</span>
										</p>
										<p class="col s12 none-padding-left">
											<i class="material-icons prefix-icon">equalizer</i>Quy mô: <span
												class="info">200-500 người</span>
										</p>
										<p class="col s12 none-padding-left">
											<i class="material-icons prefix-icon">web</i>Website: <span
												class="info">www.materialize.com</span>
										</p>
										<p class="col s12 none-padding-left">
											<i class="material-icons prefix-icon">location_on</i>Địa chỉ:
											<span class="info">4/3 Đồ Sơn, P. 13, Quận Tân Bình,
												TP.HCM</span>
										</p>
									</div>
								</div>
								<div class="col s3">
									<img src="images/Hewlett-Packard-Logo-200x200.png"
										class="right responsive-img">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>