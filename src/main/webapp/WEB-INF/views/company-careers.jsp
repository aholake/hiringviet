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
		<div class="row">
			<div class="col m8">
				<div class="card-panel">
					<div class="panel-title"><spring:message code="label.company.title.active"/></div>
						<div class="panel-content">
							<div id="job-list">
							<c:forEach items="${jobList}" var="job">
								<div class="job-box">
									<div class="location-action">
										<a class="btn-menu btn-floating btn-small grey lighten-3 dropdown-button" data-activates='item${job.id}'>
											<i class="large material-icons">menu</i>
										</a>
									<!-- Dropdown Structure -->
									<ul id='item${job.id}' class='dropdown-content'>
										<li><a href="#modal1" class="modal-trigger"><spring:message code="label.company.title.edit" /></a></li>
										<li><a href="#!"><spring:message code="label.company.title.delete" /></a></li>
										<li class="divider"></li>
										<li><a href="#!"><spring:message code="label.company.title.publish" /></a></li>
									</ul>
								</div>
									<div class="row none-margin-bottom">
										<div class="col m12">
											<div class="col m12 p-0">
												<h1 class="col m9 p-0 title block-with-text">
													<a class="not-hot" href="<c:url value='/company/${company.id}/careers/${job.id}' />">${job.title}</a>
												</h1>
											</div>
											<a href="#" class="company-name">${job.company.displayName}</a>
											<p class="work-location">
												<a href="#">${job.company.address.district.province.provinceName}</a>
											</p>
	
											<div class="job-info">
												<div class="row">
													<div class="col m6 none-padding-left">
														<p>
															<i class="material-icons prefix-icon">attach_money</i>
															<spring:message code="label.home.title.salary" />
															: <span class="info">${job.minSalary} - ${job.maxSalary}</span>
														</p>
													</div>
													<div class="col m6 none-padding-left">
														<p class="right">
															<i class="material-icons prefix-icon">date_range</i>
															<spring:message code="label.home.title.post_date" />: 
															<span class="info">${job.postDate}</span>
														</p>
													</div>
													<div class="col m6 none-padding-left">
														<p>
															<i class="material-icons prefix-icon">loyalty</i>
															<spring:message code="label.home.title.major" />
															: <span class="info">${job.position.displayName}</span>
														</p>
													</div>
													<div class="col m6 none-padding-left">
														<p class="right">
															<i class="material-icons prefix-icon">people</i>
															<spring:message code="label.home.title.total_employee" />: 
															<span class="info">${job.size} 
															<spring:message code="label.home.title.people" /></span> 
														</p>
													</div>
												</div>
												<div class="row">
													<p class="col m12 none-padding-left text-justify block-with-text">
														${job.description}
													</p>
													<div class="col m12 none-padding-left margin-top-5">
														<c:forEach items="${job.skillSet}" var="skill">
															<a class="chip">${skill.displayName}</a>
														</c:forEach>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
			<div class="col m4">
				<div class="card-panel">
					<div class="panel-title"><spring:message code="label.company.title.company_information"/></div>
					<div class="panel-content">
						<div class="company-box overflow-auto">
							<div class="row">
								<div class="col m9">
									<h1 class="title">${company.displayName}</h1>
									<div class="small-text">
										<p class="col s12 none-padding-left">
											<i class="material-icons prefix-icon">flag</i>
											<spring:message code="label.home.title.country" />
											: <span class="info">${company.hostCountry.countryName}</span>
										</p>
										<p class="col s12 none-padding-left">
											<i class="material-icons prefix-icon">equalizer</i>
											<spring:message code="label.home.title.company_size" />
											: <span class="info">${company.companySize} 
											<spring:message code="label.home.title.people" /></span>
										</p>
										<p class="col s12 none-padding-left">
											<i class="material-icons prefix-icon">web</i>
											<spring:message code="label.home.title.website" />
											: <span class="info">${company.website}</span>
										</p>
										<p class="col s12 none-padding-left">
											<i class="material-icons prefix-icon">location_on</i>
											<spring:message code="label.home.title.address" />
											: <span class="info">${company.address.district.province.provinceName}</span>
										</p>
									</div>
								</div>
								<div class="col m3 hide-on-med-and-down">
									<img src="${company.avatar}" class="right responsive-img img-full">
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