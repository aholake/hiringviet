<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title><spring:message code="label.home.title"/></title>
<!-- Local style -->
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/hiringviet/home/css/home.css'/>">

<!-- CSS media query on a link element -->
<link rel="stylesheet" href="/resources/hiringviet/home/css/smart-home.css" />


</head>
<body>
	<jsp:include page="/layouts/navbar"></jsp:include>

	<div id="introduce-slider"></div>

	<div id="main-container">
		<div class="row">
			<div class="col m8 no-padding-on-med-and-down">
				<div class="card-panel">
					<div class="panel-title">
						<spring:message code="label.home.title.hot_career" />
					</div>
					<c:forEach items="${jobDTOList}" var="jobDTO">
						<div class="panel-content">
							<div class="job-box">
								<div class="location-sticky">${jobDTO}</div>
								<div class="row none-margin-bottom">
									<div class="col m3 center hide-on-med-and-down">
										<img src="images/Hewlett-Packard-Logo-200x200.png" class="responsive-img company-logo">
										<a href="#" class="btn wave-effect wave-light">
											<spring:message code="label.home.button.follow_company" />
										</a>
									</div>
	
									<div class="col m9">
										<h1 class="title">Tuyển 5 .NET Developer</h1>
										<a href="#" class="company-name">Công ty cổ phần HP Computer</a>
										<p class="work-location"><a href="#">Hồ Chí Minh</a></p>
	
										<div class="job-info">
											<div class="row">
												<div class="col m6 none-padding-left">
													<p><spring:message code="label.home.title.salary" />: 
														<span class="info">Thỏa thuận</span>
													</p>
												</div>
												<div class="col m6 none-padding-left">
													<span class="right"><spring:message code="label.home.title.post_date"/>: 
														<span class="info">20/12/2016</span>
													</span>
												</div>
												<div class="col m6 none-padding-left">
													<p><spring:message code="label.home.title.major"/>: 
														<span class="info">Developer</span>
													</p>
												</div>
												<div class="col m6 none-padding-left">
													<span class="right"><spring:message code="label.home.title.total_employee"/>: 
														<span class="info">5 <spring:message code="label.home.title.people"/></span>
													</span>
												</div>
											</div>
											<div class="row">
												<p class="col m12 none-padding-left">
													Xây dựng các ứng dụng trên Android cho các hệ thống tài chính, Ngân hàng.Nghiên cứu, tìm kiếm giải pháp...
												</p>
												<div class="col m12 none-padding-left">
													<a class="chip">Java</a>
													<a class="chip">ASP.NET</a>
													<a class="chip">SQL</a>
													<a class="chip">English</a>
													<a class="chip">University</a>
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
			<div class="col m4">
				<div class="card-panel">
					<div class="panel-title">
						<spring:message code="label.home.title.hot_company"/>
					</div>
					<div class="panel-content">
						<div class="company-box">
							<a href="#" class="follow-sticky">
								<spring:message code="label.home.button.follow_company"/>
							</a>
							<div class="row">
								<div class="col m9">
									<h1 class="title">Công ty Tân Hiệp phát</h1>
									<div class="small-text">
										<p class="col s12 none-padding-left">
											<i class="material-icons prefix-icon">flag</i><spring:message code="label.home.title.country"/>: 
											<span class="info">Mỹ</span>
										</p>
										<p class="col s12 none-padding-left">
											<i class="material-icons prefix-icon">equalizer</i><spring:message code="label.home.title.company_size"/>: 
											<span class="info">200-500 <spring:message code="label.home.title.people" /></span>
										</p>
										<p class="col s12 none-padding-left">
											<i class="material-icons prefix-icon">web</i><spring:message code="label.home.title.website" />: 
											<span class="info">www.materialize.com</span>
										</p>
										<p class="col s12 none-padding-left">
											<i class="material-icons prefix-icon">location_on</i><spring:message code="label.home.title.address" />: 
											<span class="info">4/3 Đồ Sơn, P. 13, Quận Tân Bình, TP.HCM</span>
										</p>
									</div>
								</div>
								<div class="col m3 hide-on-med-and-down">
									<img src="images/Hewlett-Packard-Logo-200x200.png" class="right responsive-img">
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
	<script type="text/javascript" src="<c:url value='/resources/hiringviet/home/js/home.js'/>"></script>
</body>
</html>