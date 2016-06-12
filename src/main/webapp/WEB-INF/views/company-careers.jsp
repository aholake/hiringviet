<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="label.company.title"/></title>
<!-- Local style -->
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/hiringviet/home/css/home.css'/>">
<!-- CSS media query on a link element -->
<link rel="stylesheet" href="/resources/hiringviet/home/css/smart-home.css" />
<link rel="stylesheet" href="/resources/hiringviet/company/css/company.css" />
<script src="<c:url value='/resources/common/js/ckeditor/ckeditor.js'/>"></script>
</head>
<body>
	<jsp:include page="/layouts/navbar"></jsp:include>

	<jsp:include page="/layouts/companyBanner"></jsp:include>

	<div id="main-container">

		<jsp:include page="/layouts/companyHeader"></jsp:include>

		<div class="row">
			<div class="col m8">
				<div class="card-panel">
					<div class="panel-title"><spring:message code="label.company.title.active"/></div>
					<div class="panel-content">
							<div class="job-box">
								<div class="location-action">
									<a class="btn-menu btn-floating btn-small grey lighten-3 dropdown-button" data-activates='item1'>
										<i class="large material-icons">menu</i>
									</a>
								<!-- Dropdown Structure -->
								<ul id='item1' class='dropdown-content'>
									<li><a href="#modal1" class="modal-trigger">Edit</a></li>
									<li><a href="#!">Delete</a></li>
									<li class="divider"></li>
									<li><a href="#!">Publish</a></li>
								</ul>
							</div>
								<div class="row none-margin-bottom">
									<div class="col m12">
										<div class="col m12 p-0">
											<h1 class="col m9 p-0 title block-with-text">10 PHP Developers / Team Leader (Tuyển Gấp)</h1>
										</div>
										<a href="#" class="company-name">GMO Runsystem</a>
										<p class="work-location">
											<a href="#">TP. Hồ Chí Minh</a>
										</p>

										<div class="job-info">
											<div class="row">
												<div class="col m6 none-padding-left">
													<p>
														<spring:message code="label.home.title.salary" />
														: <span class="info">100.0 - 600.0</span>
													</p>
												</div>
												<div class="col m6 none-padding-left">
													<span class="right"><spring:message
															code="label.home.title.post_date" />: <span class="info">2016-06-01</span>
													</span>
												</div>
												<div class="col m6 none-padding-left">
													<p>
														<spring:message code="label.home.title.major" />
														: <span class="info">Developer</span>
													</p>
												</div>
												<div class="col m6 none-padding-left">
													<span class="right"><spring:message
															code="label.home.title.total_employee" />: <span
														class="info">100 <spring:message
																code="label.home.title.people" /></span> </span>
												</div>
											</div>
											<div class="row">
												<p class="col m12 none-padding-left text-justify block-with-text">• Chịu trách nhiệm phát triển các ứng dụng web bằng ngôn ngữ PHP. • Tham gia thiết kế, lập trình và phát triển các dự án theo yêu cầu của công ty. • Quản lý team (~5 người) nếu là Team Leader. </p>
												<div class="col m12 none-padding-left margin-top-5">
													<a class="chip">Test ABC</a>
													<a class="chip">Test ABC</a>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="job-box">
								<div class="location-action">
									<a class="btn-menu btn-floating btn-small grey lighten-3 dropdown-button" data-activates='item2'>
										<i class="large material-icons">menu</i>
									</a>
								<!-- Dropdown Structure -->
								<ul id='item2' class='dropdown-content'>
									<li><a href="#modal1" class="modal-trigger">Edit</a></li>
									<li><a href="#!">Delete</a></li>
									<li class="divider"></li>
									<li><a href="#!">Publish</a></li>
								</ul>
							</div>
								<div class="row none-margin-bottom">
									<div class="col m12">
										<div class="col m12 p-0">
											<h1 class="col m9 p-0 title block-with-text">10 PHP Developers / Team Leader (Tuyển Gấp)</h1>
										</div>
										<a href="#" class="company-name">GMO Runsystem</a>
										<p class="work-location">
											<a href="#">TP. Hồ Chí Minh</a>
										</p>

										<div class="job-info">
											<div class="row">
												<div class="col m6 none-padding-left">
													<p>
														<spring:message code="label.home.title.salary" />
														: <span class="info">100.0 - 600.0</span>
													</p>
												</div>
												<div class="col m6 none-padding-left">
													<span class="right"><spring:message
															code="label.home.title.post_date" />: <span class="info">2016-06-01</span>
													</span>
												</div>
												<div class="col m6 none-padding-left">
													<p>
														<spring:message code="label.home.title.major" />
														: <span class="info">Developer</span>
													</p>
												</div>
												<div class="col m6 none-padding-left">
													<span class="right"><spring:message
															code="label.home.title.total_employee" />: <span
														class="info">100 <spring:message
																code="label.home.title.people" /></span> </span>
												</div>
											</div>
											<div class="row">
												<p class="col m12 none-padding-left text-justify block-with-text">• Chịu trách nhiệm phát triển các ứng dụng web bằng ngôn ngữ PHP. • Tham gia thiết kế, lập trình và phát triển các dự án theo yêu cầu của công ty. • Quản lý team (~5 người) nếu là Team Leader. </p>
												<div class="col m12 none-padding-left margin-top-5">
													<a class="chip">Test ABC</a>
													<a class="chip">Test ABC</a>
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
					<div class="panel-title">THÔNG TIN CÔNG TY</div>
					<div class="panel-content">
						<div class="company-box overflow-auto">
							<div class="row">
								<div class="col m9">
									<h1 class="title">Tan Hiep Phat</h1>
									<div class="small-text">
										<p class="col s12 none-padding-left">
											<i class="material-icons prefix-icon">flag</i>
											<spring:message code="label.home.title.country" />
											: <span class="info">My</span>
										</p>
										<p class="col s12 none-padding-left">
											<i class="material-icons prefix-icon">equalizer</i>
											<spring:message code="label.home.title.company_size" />
											: <span class="info">500 <spring:message
													code="label.home.title.people" /></span>
										</p>
										<p class="col s12 none-padding-left">
											<i class="material-icons prefix-icon">web</i>
											<spring:message code="label.home.title.website" />
											: <span class="info">www.google.com</span>
										</p>
										<p class="col s12 none-padding-left">
											<i class="material-icons prefix-icon">location_on</i>
											<spring:message code="label.home.title.address" />
											: <span class="info">TP.HCHCM</span>
										</p>
									</div>
								</div>
								<div class="col m3 hide-on-med-and-down">
									<img src="/resources/images/profile_photo.jpg" class="right responsive-img">
								</div>
							</div>
							<div class="col m12">
								<div class="center-align">
									<a class="waves-effect waves-light btn orange">
										<spring:message code="label.home.button.follow_company" />
									</a>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="card-panel">
					<div class="panel-title">Công việc mới nhất</div>
					<div class="panel-content">
						<div class="new-job">
							<a href="#">02 Senior QA/QC Needed!!!</a>
							<p class="small-text">Quận 1, TP.HCM</p>
							<p class="small-text">12-06-2016</p>
						</div>
						<div class="new-job">
							<a href="#">02 Senior QA/QC Needed!!!</a>
							<p class="small-text">Quận 1, TP.HCM</p>
							<p class="small-text">12-06-2016</p>
						</div>
						<div class="new-job">
							<a href="#">02 Senior QA/QC Needed!!!</a>
							<p class="small-text">Quận 1, TP.HCM</p>
							<p class="small-text">12-06-2016</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal Structure -->
	<div id="modal1" class="modal bottom-sheet">
		<div class="modal-content">
			<h4>Modal Header</h4>
			<p>A bunch of text</p>
		</div>
		<div class="modal-footer">
			<a href="#!"
				class=" modal-action modal-close waves-effect waves-green btn-flat">Agree</a>
		</div>
	</div>
	<script type="text/javascript">
		
		CKEDITOR.replace('txtTitle');
		CKEDITOR.replace('txtDescription');
		CKEDITOR.addCss('textarea{display:block}');
		CKEDITOR.addCss('code{border:solid 1px #fb8c00 !important}');

		$(document).ready(function() {
			$('.slider').slider({
				full_width : true
			});

			$('ul.tabs').tabs('select_tab', 'tab_id');
		});
	</script>
	<script src="<c:url value='/resources/hiringviet/company/js/company.js'/>"></script>
</body>
</html>