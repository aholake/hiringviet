<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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
	<input type="hidden" id="url_load_more" value="<c:url value='/job/suggest' />" />
	<input type="hidden" id="first_item" value="${firstItem}" />
	<input type="hidden" id="max_item" value="${maxItem}" />
	<input type="hidden" id="current_page" value="${currentPage}" />

	<input type="hidden" id="text_company_follow"
		value="<spring:message code="label.home.button.follow_company" />" />
	<input type="hidden" id="text_title_salary"
		value="<spring:message code="label.home.title.salary" />" />
	<input type="hidden" id="text_title_post_date"
		value="<spring:message code="label.home.title.post_date"/>" />
	<input type="hidden" id="text_title_major"
		value="<spring:message code="label.home.title.major"/>" />
	<input type="hidden" id="text_total_employee"
		value="<spring:message code="label.home.title.total_employee"/>" />
	<input type="hidden" id="text_title_people"
		value="<spring:message code="label.home.title.people"/>" />
	<input type="hidden" id="none_value"
		value="<spring:message code='label.default.dropdown.none_value'></spring:message>">

	<div class="row">
		<div class="col m8 no-padding-on-med-and-down">
			<div class="card-panel">
				<div class="panel-title">
					<spring:message code="label.home.title.hot_career" />
				</div>
				<div id="job-list">
					<script type="text/javascript">
						var categoryList = new Array();
						var companyList = new Array();
						var positionList = new Array();
						var skillList = new Array();
						var provinceList = new Array();
						var jobList = new Array();
					</script>
					<c:forEach items="${jobList}" var="job">
						<input type="hidden" value="${job.jobCategory.categoryName}"
							class="category">
						<input type="hidden" value="${job.company.displayName}"
							class="company">
						<input type="hidden" value="${job.position.displayName}"
							class="position">
						<input type="hidden"
							value="${job.workAddress.district.province.provinceName}"
							class="address">
						<input type="hidden" value="${job.id}" class="jobId">

						<script type="text/javascript">
							var added = false;
							$
									.map(
											categoryList,
											function(elementOfArray,
													indexInArray) {
												if (elementOfArray.key == $(
														'.category').val()) {
													elementOfArray.value = elementOfArray.value + 1;
													added = true;
												}
											});
							if (!added) {
								categoryList.push({
									key : $('.category').val(),
									value : 1
								});
							}
							$('.category').remove();
							console.log(categoryList);

							// =======================
							var added = false;
							$
									.map(
											companyList,
											function(elementOfArray,
													indexInArray) {
												if (elementOfArray.key == $(
														'.company').val()) {
													elementOfArray.value = elementOfArray.value + 1;
													added = true;
												}
											});
							if (!added) {
								companyList.push({
									key : $('.company').val(),
									value : 1
								});
							}
							$('.company').remove();
							console.log(companyList);
							//=========================
							var added = false;
							$
									.map(
											positionList,
											function(elementOfArray,
													indexInArray) {
												if (elementOfArray.key == $(
														'.position').val()) {
													elementOfArray.value = elementOfArray.value + 1;
													added = true;
												}
											});
							if (!added) {
								positionList.push({
									key : $('.position').val(),
									value : 1
								});
							}
							$('.position').remove();
							console.log(positionList);
							//=========================
							var added = false;
							$
									.map(
											provinceList,
											function(elementOfArray,
													indexInArray) {
												if (elementOfArray.key == $(
														'.address').val()) {
													elementOfArray.value = elementOfArray.value + 1;
													added = true;
												}
											});
							if (!added) {
								provinceList.push({
									key : $('.address').val(),
									value : 1
								});
							}
							$('.address').remove();
							console.log(provinceList);
							//=========================
							var checkContain = $.inArray($('.jobId').val(),
									jobList);
							if (checkContain < 0) {
								jobList.push($('.jobId').val());
							}
							$('.jobId').remove();
						</script>
						<div class="job-item">
							<div class="job-box" id="${job.id}">
								<div
									class="location-sticky orange darken-1 province-${fn:replace(job.workAddress.district.province.provinceName, ' ','')}">${job.workAddress.district.province.provinceName}</div>
								<div class="row none-margin-bottom">
									<div class="col m3 center hide-on-med-and-down m3-div">
										<a href="/company?companyId=${job.company.id}"> 
										<img src="${job.company.avatar}" class="responsive-img company-logo"></a> 
										<!-- <a href="#"
											class="btn margin-top-10 orange darken-1 waves-effect waves-light">
											<spring:message code="label.home.button.follow_company" />
										</a> -->
									</div>
									<div class="col m9 m9-div">
										<div class="col m12 p-0">
											<h1 class="col m9 p-0 title block-with-text">
												<c:choose>
													<c:when test="${job.company.isVip == 1}">
														<a class="job-title hot"
															href="<c:url value='/company/careers?jobId=${job.id}' />">${job.title}</a>
													</c:when>
													<c:otherwise>
														<a class="job-title not-hot"
															href="<c:url value='/company/careers?jobId=${job.id}' />">${job.title}</a>
													</c:otherwise>
												</c:choose>
											</h1>
										</div>
										<a href="/company?companyId=${job.company.id}&mode=HOME" class="company-name company-${fn:replace(job.company.displayName, ' ','')}">${job.company.displayName}</a>
										<p class="work-location">
											<a href="#">${job.workAddress.district.province.provinceName}</a>
										</p>

										<div class="job-info">
											<div class="row">
												<div class="col m6 none-padding-left">
													<p>
														<i class="material-icons prefix-icon">attach_money</i>
														<spring:message code="label.home.title.salary" />
														: <span class="info"><span class="minSalary">${job.minSalary}</span>
															- <span class="maxSalary">${job.maxSalary}</span></span>
													</p>
												</div>
												<div class="col m6 none-padding-left">
													<p class="right">
														<i class="material-icons prefix-icon">date_range</i>
														<spring:message code="label.home.title.post_date" />
														: <span class="info datePost">${job.postDate}</span>
													</p>
												</div>
												<div class="col m6 none-padding-left">
													<p>
														<i class="material-icons prefix-icon">loyalty</i>
														<spring:message code="label.home.title.major" />
														: <span
															class="info position-${fn:replace(job.position.displayName, ' ','')}">${job.position.displayName}</span>
													</p>
												</div>
												<div class="col m6 none-padding-left">
													<p class="right">
														<i class="material-icons prefix-icon">people</i>
														<spring:message code="label.home.title.total_employee" />
														: <span class="info">${job.size} <spring:message
																code="label.home.title.people" /></span>
													</p>
												</div>
											</div>
											<div class="row">
												<div
													class="col m12 none-padding-left text-justify block-with-text edit-text-ellipsis">
													${job.description}</div>
												<div class="col m12 none-padding-left margin-top-5">
													<c:forEach items="${job.skillSet}" var="skill">
														<input hidden="" value="${skill.displayName}"
															class="skill">
														<script type="text/javascript">
															var added = false;
															$
																	.map(
																			skillList,
																			function(
																					elementOfArray,
																					indexInArray) {
																				if (elementOfArray.key == $(
																						'.skill')
																						.val()) {
																					elementOfArray.value = elementOfArray.value + 1;
																					added = true;
																				}
																			});
															if (!added) {
																skillList
																		.push({
																			key : $(
																					'.skill')
																					.val(),
																			value : 1
																		});
															}
															$('.skill')
																	.remove();
															console
																	.log(skillList);
														</script>
														<a
															class="chip skill-${fn:replace(skill.displayName, ' ','')}">${skill.displayName}</a>
													</c:forEach>
												</div>
											</div>
										</div>
									</div>
									<i
										class="material-icons right icon-arrow margin-right-5 cursor">keyboard_arrow_up</i>

									<c:if test="${empty applyMap[job.id] }">
										<input type="checkbox" class="filled-in right note-job"
											id="filled-in-box-${job.id}" />
										<label for="filled-in-box-${job.id}" class="right"></label>
									</c:if>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				<div class="text-align-center margin-top-10">
					<c:choose>
						<c:when test="${isDisabledLoadJob == true}">
							<a id="btn-load-more"
								class="btn-floating btn-large waves-effect waves-light red disabled"
								disabled="disabled"> <i class="material-icons">add</i>
							</a>
						</c:when>
						<c:otherwise>
							<a id="btn-load-more"
								class="btn-floating btn-large waves-effect waves-light red">
								<i class="material-icons">add</i>
							</a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
		<div class="col m4 no-padding-on-med-and-down">
			<div class="card-panel">
				<div class="panel-title">Điều kiện lọc</div>
				<div class="row">
					<div class="col m12">
						<ul class="wrap-filter" data-collapsible="accordion">
							<li>
								<div class="collapsible-header">
									<i class="material-icons">filter_drama</i><spring:message code="label.home.filter" />
								</div>
								<div class="collapsible-body">
									<ul class="collection fillter-wrapper">
										<li class="collection-item"><b>Career</b><i
											class="material-icons right icon-arrow">keyboard_arrow_down</i>
											<ul
												class="margin-top-10 display-none filter-list filter-category-list"
												id="filter-category-list">
											</ul></li>
										<li class="collection-item"><b>Company</b><i
											class="material-icons right icon-arrow">keyboard_arrow_down</i>
											<ul
												class="margin-top-10 display-none filter-list filter-company-list"
												id="filter-company-list">
											</ul></li>
										<li class="collection-item"><b>Date Posted</b><i
											class="material-icons right icon-arrow">keyboard_arrow_down</i>
											<ul
												class="margin-top-10 display-none filter-list filter-date-post-list"
												id="filter-date-post-list">
												<li><input class="with-gap data-post-radio"
													name="datePosts" value="0" type="radio" id="date-post-All" />
													<label for="date-post-All">All</label></li>
												<li><input class="with-gap data-post-radio"
													name="datePosts" value="1" type="radio" id="date-post-1" /> <label
													for="date-post-1">1 day ago</label></li>
												<li><input class="with-gap data-post-radio"
													name="datePosts" value="2" type="radio" id="date-post-3" /> <label
													for="date-post-3">3 day ago</label></li>
												<li><input class="with-gap data-post-radio"
													name="datePosts" value="3" type="radio" id="date-post-5" /> <label
													for="date-post-5">5 day ago</label></li>
												<li><input class="with-gap data-post-radio"
													name="datePosts" value="4" type="radio" id="date-post-7" /> <label
													for="date-post-7">7 day ago</label></li>
											</ul></li>
										<li class="collection-item"><b>Job Function</b><i
											class="material-icons right icon-arrow">keyboard_arrow_down</i>
											<ul
												class="margin-top-10 display-none filter-list filter-position-list"
												id="filter-position-list">
											</ul></li>
										<li class="collection-item"><b>Skill</b><i
											class="material-icons right icon-arrow">keyboard_arrow_down</i>
											<ul
												class="margin-top-10 display-none filter-list filter-skill-list"
												id="filter-skill-list">
											</ul></li>
										<li class="collection-item"><b>Salary</b><i
											class="material-icons right icon-arrow">keyboard_arrow_down</i>
											<ul
												class="margin-top-10 display-none filter-list filter-salary-list"
												id="filter-salary-list">
												<li><input class="with-gap salary-radio" name="salary"
													value="0" type="radio" id="salary-all" /> <label
													for="salary-all">All</label></li>
												<li><input class="with-gap salary-radio" name="salary"
													value="1" type="radio" id="salary-500" /> <label
													for="salary-500">Dưới 500$</label></li>
												<li><input class="with-gap salary-radio" name="salary"
													value="2" type="radio" id="salary-1000" /> <label
													for="salary-1000">500$ - 1000$</label></li>
												<li><input class="with-gap salary-radio" name="salary"
													value="3" type="radio" id="salary-2000" /> <label
													for="salary-2000">1000$ - 2000$</label></li>
												<li><input class="with-gap salary-radio" name="salary"
													value="4" type="radio" id="salary-3000" /> <label
													for="salary-3000">2000$ - 3000$</label></li>
												<li><input class="with-gap salary-radio" name="salary"
													value="5" type="radio" id="salary-4000" /> <label
													for="salary-4000">Trên 3000$</label></li>
											</ul></li>
										<li class="collection-item"><b>Province</b><i
											class="material-icons right icon-arrow">keyboard_arrow_down</i>
											<ul
												class="margin-top-10 display-none filter-list filter-province-list"
												id="filter-province-list">
											</ul>
										</li>
									</ul>
								</div>
							</li>
						</ul>
					</div>
				</div>
			</div>
			<c:if test="${not empty loggers}">
				<div class="card-panel">
					<div class="panel-title">HOẠT ĐỘNG</div>
					<div class="panel-content">
						<c:forEach items="${loggers}" var="logger">
							<div class="activity-box">
								${logger.info}
								<div class="row none-margin-bottom margin-top-5">
									<p class="right">
										<i class="material-icons prefix-icon small-text">date_range</i> 
										<span class="info small-text"><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${logger.dateTime}" /></span>
									</p>
								</div>
							</div>
						</c:forEach>
					</div>
					<!-- <a class="btn waves-effect waves-light">Tải thêm</a> -->
				</div>
			</c:if>
		</div>
	</div>
	<form id="applyForm" action="/job/apply" method="post">
		<input type="hidden" id="jobList" name="jobList" value="" />
		<div class="float-table-wrapper white">
			<div class="selected-table-wrapper">
				<table class="selected-job-table striped">
					<thead>
						<tr>
							<th>#</th>
							<th class="mp0">Selected Jobs <i
								class="material-icons cursor right arrow"
								onclick="hideSelectedJobTable();">keyboard_arrow_down</i>
							</th>
							<th><i class="material-icons cursor"
								onclick="closeSelectedJobTable();">close</i></th>
						</tr>
					</thead>
					<tbody class="tbody">
						<tr class="job">
						</tr>
					</tbody>
					<tfoot>
						<tr>
							<td colspan="3">
								<button type="submit" class="waves-effect waves-light btn btn-apply-job orange right">Apply All</button>
							</td>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
	</form>
	<!-- Local js -->
	<script type="text/javascript"
		src="<c:url value='/resources/hiringviet/home/js/home.js'/>"></script>
	<script type="text/javascript">
	$(document).ready(function() {
		$('.wrap-filter').collapsible();
	}
	</script>
</body>
</html>