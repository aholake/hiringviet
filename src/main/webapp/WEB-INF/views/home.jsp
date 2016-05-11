<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>Home</title>
<!-- Local style -->
<link rel="stylesheet" type="text/css" href="/resources/css/home.css">
</head>
<body>
	<jsp:include page="/layouts/navbar"></jsp:include>

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

	<jsp:include page="/layouts/footer"></jsp:include>
	<!-- Local js -->
	<script type="text/javascript" src="/resources/js/home.js"></script>
</body>
</html>