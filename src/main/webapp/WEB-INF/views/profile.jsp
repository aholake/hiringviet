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
<link rel="stylesheet" href="/resources/hiringviet/profile/css/profile.css" />
</head>
<body>
	<jsp:include page="/layouts/navbar"></jsp:include>

	<jsp:include page="/layouts/companyBanner"></jsp:include>

	<div id="main-container">

		<jsp:include page="/layouts/companyHeader"></jsp:include>

		<div class="row">
			<div class="col m8">
				<!--GENERAL JOB INFO-->
				<div class="card-panel job-detail">
					<div class="row">
						<div class="row">
							<div class="col m12">
								<p class="title blue-text">Nhân Viên Kinh Doanh Cho CN Mới
									Thành Lập Tại Nha Trang - Thu Nhập Hấp Dẫn</p>
							</div>
							<div class="col m7 offset-m5 date-and-view right-align">
								<span>Đăng ngày: 20/10/2015 | </span> <span>Lượt xem:
									7,787</span>
							</div>
							<div class="col m12">
								<hr class="fancy-hr">
							</div>
						</div>
						<div class="row">
							<div class="col m8 p-0">
								<div class="row">
									<div class="col m12">
										<span class="bold-text">ALMA Chi Nhánh Nha Trang</span>
									</div>
									<div class="col m12">
										<span class="bold-text">Nơi làm việc: </span><span>Tân
											Bình, TP. Hồ Chí Minh</span>
									</div>
									<div class="col m12">
										<span class="bold-text">Lương: </span><span
											class="orange-text">500-1000$</span>
									</div>
									<div class="col m12">
										<span class="bold-text">Kỹ năng: </span>
										<div class="chip">Java</div>
										<div class="chip">English</div>
										<div class="chip">Spring</div>
										<div class="chip">Hibernate</div>
									</div>
								</div>
							</div>
							<div class="col m4">
								<div class="row">
									<a
										class="waves-effect waves-light btn col m9 offset-m2 favourite-btn red lighten-2"><i
										class="material-icons left white-text">bookmark</i>Yêu thích</a> <a
										class="waves-effect waves-light btn col m9 offset-m2 margin-top-10"><i
										class="material-icons left white-text">note_add</i>Ứng tuyển</a>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- JOB DESCRIBE -->
				<div class="card-panel">
					<div class="row">
						<div class="col m12">
							<h5>Công việc của bạn</h5>
							<hr>
							<div class="higher-line">
								- Website and desktop application development in .NET framework <br>
								- Communicate directly with our overseas staff and clients to get
								software development requirements. <br> (More details to be
								discussed in the interview) <br>
							</div>
						</div>
					</div>
				</div>
				<div class="card-panel">
					<div class="row">
						<div class="col m12">
							<h5>Yêu cầu</h5>
							<hr>
							<div class="higher-line">
								- At least 5 years’ experience in .NET application development and
								ASP.NET, both front end and back end. <br> - Experience in
								Subsonic, entity framework. <br> - Competence in .HTML,
								JavaScript, JQuery, CSS (3.0 - bootstrap), Ajax and client-based
								technologies <br> - Competence in SQL, in particular SQL
								2012. <br> - Experience in version control tools such as
								Subversion. <br> - Skills in Android, iOS is an advantage. <br>
								- Motivation and ability to do research on new technologies. <br>
								- Soft skills in working in a team, good communication,
								problem-solving.<br> - Degree in Computer Science,
								Information Technology or equivalent. <br> - Strong English
								speaking and writing skills a must. <br> - The application
								must be written in English<br>
							</div>
						</div>
					</div>
				</div>
				<div class="card-panel">
				<div class="row">
					<div class="col m12">
						<h5>Bình luận</h5>
						<hr>
						<ul class="collection commentList-1 remove-border">
							<li class="display-inline-flex">
								<a class="margin-left-5 small-text a-text-color"><spring:message code="label.company.title.load_more_comment"/></a>
							</li>
							<li class="collection-item avatar">
								<img src="/resources/images/profile_photo.jpg" alt="" class="circle">
								<span class="title"><a href="#">Võ Tấn Lộc</a> I just
									keen on having an invitation to start my Internship with you
									that will be very kick off on my family life.</span>
								<p class="small-text">12-06-2016</p></li>
						</ul>
						<div class="post-comment">
							<div class="input-field col m12">
								<input id="last_name" type="text" class="validate" placeholder="<spring:message code='label.company.title.write_comment'/>">
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
	<script src="<c:url value='/resources/hiringviet/profile/js/profile.js'/>"></script>
</body>
</html>