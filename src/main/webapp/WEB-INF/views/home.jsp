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

	<input type="hidden" id="get_job_hot" value="<c:url value='/job/hot' />" />
	<input type="hidden" id="first_item" value="${firstItem}" />
	<input type="hidden" id="max_item" value="${maxItem}" />
	<input type="hidden" id="current_page" value="${currentPage}" />

	<input type="hidden" id="text_company_follow" value="<spring:message code="label.home.button.follow_company" />" />
	<input type="hidden" id="text_title_salary" value="<spring:message code="label.home.title.salary" />" />
	<input type="hidden" id="text_title_post_date" value="<spring:message code="label.home.title.post_date"/>" />
	<input type="hidden" id="text_title_major" value="<spring:message code="label.home.title.major"/>" />
	<input type="hidden" id="text_total_employee" value="<spring:message code="label.home.title.total_employee"/>" />
	<input type="hidden" id="text_title_people" value="<spring:message code="label.home.title.people"/>" />
	<div id="main-container">
		<div class="row">
			<div class="col m8 no-padding-on-med-and-down">
				<div class="card-panel">
					<div class="panel-title">
						<spring:message code="label.home.title.hot_career" />
					</div>
					<div id="job-list">
						<c:forEach items="${jobList}" var="job">
							<div class="">
								<div class="job-box">
									<div class="location-sticky orange darken-1">${job.company.address.province.provinceName}</div>
									<div class="row none-margin-bottom">
										<div class="col m3 center hide-on-med-and-down">
											<a href="/company/${job.company.id}"><img src="${job.company.avatar}" class="responsive-img company-logo"></a>
											<a href="#" class="btn margin-top-10 orange darken-1 waves-effect waves-light">
												<spring:message code="label.home.button.follow_company" />
											</a>
										</div>
										<div class="col m9">
											<div class="col m12 p-0">
												<h1 class="col m9 p-0 title block-with-text">
													<c:choose>
														<c:when test="${job.company.isVip == 1}">
															<a class="hot" href="<c:url value='/company/careers/${job.id}' />">${job.title}</a>
														</c:when>
														<c:otherwise>
															<a class="not-hot" href="<c:url value='/company/careers/${job.id}' />">${job.title}</a>
														</c:otherwise>
													</c:choose>
												</h1>
											</div>
											<a href="#" class="company-name">${job.company.displayName}</a>
											<p class="work-location"><a href="#">${job.company.address.province.provinceName}</a></p>
		
											<div class="job-info">
												<div class="row">
													<div class="col m6 none-padding-left">
														<p><i class="material-icons prefix-icon">attach_money</i><spring:message code="label.home.title.salary" />: 
															<span class="info">${job.minSalary} - ${job.maxSalary}</span>
														</p>
													</div>
													<div class="col m6 none-padding-left">
														<p class="right"><i class="material-icons prefix-icon">date_range</i><spring:message code="label.home.title.post_date"/>: 
															<span class="info">${job.postDate}</span>
														</p>
													</div>
													<div class="col m6 none-padding-left">
														<p><i class="material-icons prefix-icon">loyalty</i><spring:message code="label.home.title.major"/>: 
															<span class="info">${job.position.displayName}</span>
														</p>
													</div>
													<div class="col m6 none-padding-left">
														<p class="right"><i class="material-icons prefix-icon">people</i><spring:message code="label.home.title.total_employee"/>: 
															<span class="info">${job.size} <spring:message code="label.home.title.people"/></span>
														</p>
													</div>
												</div>
												<div class="row">
													<p class="col m12 none-padding-left text-justify block-with-text">
														${job.description}
													</p>
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
					<div class="text-align-center margin-top-10">
						<c:choose>
							<c:when test="${isDisabledLoadJob == true}">
								<a id="btn-load-more" class="btn-floating btn-large waves-effect waves-light red disabled" disabled="disabled">
									<i class="material-icons">add</i>
								</a>
							</c:when>
							<c:otherwise>
								<a id="btn-load-more" class="btn-floating btn-large waves-effect waves-light red">
									<i class="material-icons">add</i>
								</a>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
			<div class="col m4">
				<div class="card-panel">
					<div class="panel-title">
						<spring:message code="label.home.title.hot_company"/>
					</div>
					<c:forEach items="${companyList}" var="company">
						<div class="panel-content">
							<div class="company-box padding-bottom-10">
								<a href="#" class="follow-sticky">
									<spring:message code="label.home.button.follow_company"/>
								</a>
								<div class="row">
									<div class="col m9">
										<h1 class="title">${company.displayName}</h1>
										<div class="small-text">
											<p class="col s12 none-padding-left">
												<i class="material-icons prefix-icon">flag</i><spring:message code="label.home.title.country"/>: 
												<span class="info">${company.country}</span>
											</p>
											<p class="col s12 none-padding-left">
												<i class="material-icons prefix-icon">equalizer</i><spring:message code="label.home.title.company_size"/>: 
												<span class="info">${company.companySize} <spring:message code="label.home.title.people" /></span>
											</p>
											<p class="col s12 none-padding-left">
												<i class="material-icons prefix-icon">web</i><spring:message code="label.home.title.website" />: 
												<span class="info">${company.website}</span>
											</p>
											<p class="col s12 none-padding-left">
												<i class="material-icons prefix-icon">location_on</i><spring:message code="label.home.title.address" />: 
												<span class="info">${company.address.streetName}, ${company.address.ward.wardName}, ${company.address.district.districtName}, ${company.address.province.provinceName}</span>
											</p>
										</div>
									</div>
									<div class="col m3 hide-on-med-and-down">
										<img src="${company.avatar}" class="right responsive-img company-logo-1">
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>		
		</div>
	</div>

	<jsp:include page="/layouts/footer"></jsp:include>
	<!-- Local js -->
	<script type="text/javascript" src="<c:url value='/resources/hiringviet/home/js/home.js'/>"></script>
</body>
</html>