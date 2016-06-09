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
					<div class="panel-title">
						<spring:message code="label.home.title.suggest_career" />
					</div>
					<c:forEach items="${jobList}" var="job">
						<div class="panel-content">
							<div class="job-box">
								<div class="location-sticky orange darken-1">${job.company.address.province}</div>
								<div class="row none-margin-bottom">
									<div class="col m3 center hide-on-med-and-down">
										<img src="${job.company.avatar}"
											class="responsive-img company-logo"> <a href="#"
											class="btn margin-top-10 orange darken-1"><spring:message
												code="label.home.button.follow_company" /></a>
									</div>

									<div class="col m9">
										<div class="col m12 p-0">
											<h1 class="col m9 p-0 title block-with-text">${job.title}</h1>
										</div>
										<a href="#" class="company-name">${job.company.displayName}</a>
										<p class="work-location">
											<a href="#">${job.company.address.province}</a>
										</p>

										<div class="job-info">
											<div class="row">
												<div class="col m6 none-padding-left">
													<p>
														<spring:message code="label.home.title.salary" />
														: <span class="info">${job.minSalary} -
															${job.maxSalary}</span>
													</p>
												</div>
												<div class="col m6 none-padding-left">
													<span class="right"><spring:message
															code="label.home.title.post_date" />: <span class="info">${job.postDate}</span>
													</span>
												</div>
												<div class="col m6 none-padding-left">
													<p>
														<spring:message code="label.home.title.major" />
														: <span class="info">${job.position.displayName}</span>
													</p>
												</div>
												<div class="col m6 none-padding-left">
													<span class="right"><spring:message
															code="label.home.title.total_employee" />: <span
														class="info">${job.size} <spring:message
																code="label.home.title.people" /></span> </span>
												</div>
											</div>
											<div class="row">
												<p class="col m12 none-padding-left text-justify block-with-text">${job.description}</p>
												<div class="col m12 none-padding-left margin-top-5">
													<c:forEach items="${job.skillList}" var="skill">
														<a class="chip">${skill.displayName}</a>
													</c:forEach>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
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