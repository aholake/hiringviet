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