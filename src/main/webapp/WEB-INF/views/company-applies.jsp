<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="time" uri="http://ocpsoft.org/prettytime/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="label.company.title" /></title>
<!-- Local style -->
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/hiringviet/home/css/home.css'/>">
<link rel="stylesheet"
	href="/resources/hiringviet/company/css/company.css" />
</head>
<body>
	<div class="row">
		<div class="col m8">
			<div class="card-panel">
				<div class="panel-title">Danh sách ứng tuyển cho vị trí này</div>
				<div id="jobWall" class="panel-content">
					<c:if test="${empty applies }">
						<h5 class="center">Chưa có đơn ứng tuyển cho công việc này</h5>
					</c:if>
					<c:forEach var="apply" items="${applies }">
						<div class="card blue-grey darken-1">
							<div class="card-content white-text">
								<p class="card-title apply-card-title">
									<a href="=/profile?memberId=${apply.member.id }"
										class="applier-name">${apply.member.firstName }
										${apply.member.lastName }</a> <span class="email small-text">&lt;${apply.member.account.email }&gt;</span>
									<span class="timestamp small-text">Hôm qua</span>
								</p>
								<p>${apply.disscription }</p>
							</div>
							<div class="card-action">
								<a href="#">Đồng ý</a> <a href="#">Từ chối</a>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
		<div class="col m4">
			<div class="card-panel">
				<div class="panel-title">
					<spring:message code="label.company.title.company_information" />
				</div>
				<div class="panel-content">
					<div class="overflow-auto">
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
										: <span class="info">${company.companySize} <spring:message
												code="label.home.title.people" /></span>
									</p>
									<p class="col s12 none-padding-left">
										<i class="material-icons prefix-icon">web</i>
										<spring:message code="label.home.title.website" />
										: <span class="info"><a target="_blank"
											href="${company.website}">${company.website}</a></span>
									</p>
								</div>
							</div>
							<div class="col m3 hide-on-med-and-down">
								<img src="${company.avatar}"
									class="right responsive-img img-full">
							</div>
							<div class="small-text col m12">
								<p class="none-padding-left">
									<i class="material-icons prefix-icon">location_on</i>
									<spring:message code="label.home.title.address" />
									:&nbsp;<span class="info">
										${company.address.explicitAddress},&nbsp;
										${company.address.district.type}&nbsp;
										${company.address.district.districtName},&nbsp;
										${company.address.district.province.type}&nbsp;
										${company.address.district.province.provinceName} </span>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="card-panel">
				<div class="panel-title">Công việc mới nhất</div>
				<div class="panel-content row">
					<c:forEach items="${newJobs}" var="job">
						<div class="new-job col m12">
							<a href="/company/careers?jobId=${job.id}">${job.title}</a>
							<p class="small-text">${job.address.explicitAddress},&nbsp;
								${job.address.district.type}&nbsp;${job.address.district.districtName},&nbsp;
								${job.address.district.province.type}&nbsp;${job.address.district.province.provinceName},
							</p>
							<p class="small-text display-inline-flex">
								<i class="material-icons small-icon">date_range</i>
								<fmt:formatDate pattern="yyyy-MM-dd, hh:mm:ss a"
									value="${job.postDate}" />
							</p>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<!-- member tooltip -->
	<div class="tooltil-show-member">
		<div class="row">
			<div class="col m4 mp0">
				<a href="#"> <img src="">
				</a>
			</div>
			<div class="col m8" style="text-align: left;">
				<a href="" class="endorse-item-name-text"></a>
				<p class="mp0 small-text">
					<span class="number-followers"></span> follower
				</p>
			</div>
			<div class="col m12 margin-top-5">
				<a href=""
					class="btn-connect waves-effect waves-light btn margin-right-5"><spring:message
						code="label.profile.tooltip.title.connect" /></a> <a
					class="btn-profile waves-effect waves-light btn grey"><spring:message
						code="label.profile.tooltip.title.profile" /></a>
			</div>
			<div class="triangle"></div>
		</div>
	</div>
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
	<div id="divLoading"></div>
	<script type="text/javascript">
		$(document).ready(function() {
			$('.slider').slider({
				full_width : true
			});

			$('ul.tabs').tabs('select_tab', 'tab_id');
			CKEDITOR.replace("content");
		});
	</script>
	<script
		src="<c:url value='/resources/hiringviet/company/js/company.js'/>"></script>
	<script type="text/javascript"
		src="/resources/common/js/ckeditor/ckeditor.js"></script>
	<script type="text/javascript" src="/resources/common/js/freewall.js"></script>
	<script type="text/javascript">
		$(function() {
			var wall = new Freewall("#jobWall");
			wall.fitWidth();
		})
	</script>
</body>
</html>