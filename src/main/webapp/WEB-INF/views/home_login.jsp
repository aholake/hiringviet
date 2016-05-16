<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>Home</title>
<!-- Local style -->
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/hiringviet/home/css/home.css'/>">
<!-- CSS media query on a link element -->
<link rel="stylesheet"
	href="/resources/hiringviet/home/css/smart-home.css" />

</head>
<body>
	<jsp:include page="/layouts/navbar"></jsp:include>

	<div id="introduce-slider"></div>

	<div id="main-container">
		<div class="row">
			<div class="col m8 no-padding-on-med-and-down">
				<div class="card-panel">
					<div class="panel-title">Công việc đề xuất</div>
					<div class="panel-content">
						<div class="job-box">
							<div class="location-sticky">Hồ Chí Minh</div>
							<div class="row none-margin-bottom">
								<div class="col m3 center hide-on-med-and-down">
									<img src="images/Hewlett-Packard-Logo-200x200.png"
										class="responsive-img company-logo"> <a href="#"
										class="btn wave-effect wave-light">Follow</a>
								</div>

								<div class="col m9">
									<h1 class="title">Tuyển 5 .NET Developer</h1>
									<a href="#" class="company-name">Công ty cổ phần HP
										Computer</a>
									<p class="work-location">
										<a href="#">Hồ Chí Minh</a>
									</p>

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
								<div class="col m3 center hide-on-med-and-down">
									<img src="images/Hewlett-Packard-Logo-200x200.png"
										class="responsive-img company-logo"> <a href="#"
										class="btn wave-effect wave-light">Follow</a>
								</div>

								<div class="col m9">
									<h1 class="title">Tuyển 5 .NET Developer</h1>
									<a href="#" class="company-name">Công ty cổ phần HP
										Computer</a>
									<p class="work-location">
										<a href="#">Hồ Chí Minh</a>
									</p>

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
								<div class="col m3 center hide-on-med-and-down">
									<img src="images/Hewlett-Packard-Logo-200x200.png"
										class="responsive-img company-logo"> <a href="#"
										class="btn wave-effect wave-light">Follow</a>
								</div>

								<div class="col m9">
									<h1 class="title">Tuyển 5 .NET Developer</h1>
									<a href="#" class="company-name">Công ty cổ phần HP
										Computer</a>
									<p class="work-location">
										<a href="#">Hồ Chí Minh</a>
									</p>

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
								<div class="col m3 center hide-on-med-and-down">
									<img src="images/Hewlett-Packard-Logo-200x200.png"
										class="responsive-img company-logo"> <a href="#"
										class="btn wave-effect wave-light">Follow</a>
								</div>

								<div class="col m9">
									<h1 class="title">Tuyển 5 .NET Developer</h1>
									<a href="#" class="company-name">Công ty cổ phần HP
										Computer</a>
									<p class="work-location">
										<a href="#">Hồ Chí Minh</a>
									</p>

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
								<div class="col m3 center hide-on-med-and-down">
									<img src="images/Hewlett-Packard-Logo-200x200.png"
										class="responsive-img company-logo"> <a href="#"
										class="btn wave-effect wave-light">Follow</a>
								</div>

								<div class="col m9">
									<h1 class="title">Tuyển 5 .NET Developer</h1>
									<a href="#" class="company-name">Công ty cổ phần HP
										Computer</a>
									<p class="work-location">
										<a href="#">Hồ Chí Minh</a>
									</p>

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
								<div class="col m3 center hide-on-med-and-down">
									<img src="images/Hewlett-Packard-Logo-200x200.png"
										class="responsive-img company-logo"> <a href="#"
										class="btn wave-effect wave-light">Follow</a>
								</div>

								<div class="col m9">
									<h1 class="title">Tuyển 5 .NET Developer</h1>
									<a href="#" class="company-name">Công ty cổ phần HP
										Computer</a>
									<p class="work-location">
										<a href="#">Hồ Chí Minh</a>
									</p>

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
								<div class="col m3 center hide-on-med-and-down">
									<img src="images/Hewlett-Packard-Logo-200x200.png"
										class="responsive-img company-logo"> <a href="#"
										class="btn wave-effect wave-light">Follow</a>
								</div>

								<div class="col m9">
									<h1 class="title">Tuyển 5 .NET Developer</h1>
									<a href="#" class="company-name">Công ty cổ phần HP
										Computer</a>
									<p class="work-location">
										<a href="#">Hồ Chí Minh</a>
									</p>

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
			<div class="col m4 no-padding-on-med-and-down">
				<div class="card-panel center">
					<div class="panel-title">HOẠT ĐỘNG</div>
					<div class="panel-content">
						<div class="activity-box">
							<p>
								<a href="#">Công ty TNHH MTV</a> vừa đăng 1 <a href="">công
									việc</a> mới
							</p>
							<p class="small-text">
								Xây dựng các ứng dụng trên Android cho các hệ thống tài
								chính, Ngân hàng.Nghiên cứu, tìm kiếm giải pháp <a href="">xem
									thêm...</a>
							</p>
							<div class="row none-margin-bottom margin-top-5">
								<i class="material-icons left warning-text">favorite</i> <span
									class="small-text right">Hôm qua</span>
							</div>
						</div>
						<div class="activity-box">
							<p>
								<a href="#">Công ty TNHH MTV</a> vừa đăng 1 hoạt động mới
							</p>
							<p class="small-text">
								Ngày hội việc làm sẽ được tổ chức ngày 20/4/2014, đăng ký tại <a
									href="#">www.abc.com</a>
							</p>
							<div class="row none-margin-bottom margin-top-5">
								<i class="material-icons left warning-text">favorite</i> <span
									class="small-text right">Hôm qua</span>
							</div>
						</div>
						<div class="activity-box">
							<p>
								<a href="#">Công ty TNHH MTV</a> vừa đăng 1 hoạt động mới
							</p>
							<p class="small-text">
								Ngày hội việc làm sẽ được tổ chức ngày 20/4/2014, đăng ký tại <a
									href="#">www.abc.com</a>
							</p>
							<div class="row none-margin-bottom margin-top-5">
								<i class="material-icons left warning-text">favorite</i> <span
									class="small-text right">Hôm qua</span>
							</div>
						</div>
						<div class="activity-box">
							<p>
								<a href="#">Công ty TNHH MTV</a> vừa đăng 1 hoạt động mới
							</p>
							<p class="small-text">
								Ngày hội việc làm sẽ được tổ chức ngày 20/4/2014, đăng ký tại <a
									href="#">www.abc.com</a>
							</p>
							<div class="row none-margin-bottom margin-top-5">
								<i class="material-icons left warning-text">favorite</i> <span
									class="small-text right">Hôm qua</span>
							</div>
						</div>
						<div class="activity-box">
							<p>
								<a href="#">Công ty TNHH MTV</a> vừa đăng 1 hoạt động mới
							</p>
							<p class="small-text">
								Ngày hội việc làm sẽ được tổ chức ngày 20/4/2014, đăng ký tại <a
									href="#">www.abc.com</a>
							</p>
							<div class="row none-margin-bottom margin-top-5">
								<i class="material-icons left warning-text">favorite</i> <span
									class="small-text right">Hôm qua</span>
							</div>
						</div>
						<div class="activity-box">
							<p>
								<a href="#">Công ty TNHH MTV</a> vừa đăng 1 hoạt động mới
							</p>
							<p class="small-text">
								Ngày hội việc làm sẽ được tổ chức ngày 20/4/2014, đăng ký tại <a
									href="#">www.abc.com</a>
							</p>
							<div class="row none-margin-bottom margin-top-5">
								<i class="material-icons left warning-text">favorite</i> <span
									class="small-text right">Hôm qua</span>
							</div>
						</div>
					</div>
					<a class="btn waves-effect waves-light">Tải thêm</a>
				</div>
				<div class="card-panel"></div>
			</div>
		</div>
	</div>
	<div id="footer">Copyright 2016 by Nong Lam University, all right
		reserved.</div>

	<!-- Local js -->
	<script type="text/javascript" src="/resources/js/home.js"></script>
</body>
</html>