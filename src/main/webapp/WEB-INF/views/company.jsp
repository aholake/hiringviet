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
<link rel="stylesheet" href="/resources/hiringviet/company/css/company.css" />
<script src="<c:url value='/resources/common/js/ckeditor/ckeditor.js'/>"></script>
</head>
<body>

	<input type="hidden" id="url_get_post_comments" value="<c:url value='/company/post/comments' />" />
	<input type="hidden" id="url_get_post_replyComments" value="<c:url value='/company/post/replyComments' />" />
	<input type="hidden" id="url_redirect_member" value="<c:url value='/member/' />" />
	<input type="hidden" id="reply_comment" value='<spring:message code="label.company.title.reply_comment"/>' />
	<input type="hidden" id="write_comment" value='<spring:message code="label.company.title.write_comment"/>' />
	<input type="hidden" id="load_more_comment" value='<spring:message code="label.company.title.load_more_comment"/>' />
	<input type="hidden" id="url_post_comment" value="<c:url value='/company/post/addComment' />" />

		<div class="row">
			<div class="col m8">
				<div class="card-panel">
					<div class="slider">
						<ul class="slides">
							<c:forEach items="${company.companyPhotoSet}" var="companyPhotoSet">
								<li><img class="materialboxed" data-caption="${companyPhotoSet.photo}" src="${companyPhotoSet.photo}">
									<!-- random image -->
									<div class="caption center-align">
										<h3>${companyPhotoSet.title}</h3>
										<h5 class="light grey-text text-lighten-3">${companyPhotoSet.description}</h5>
									</div>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
				<c:forEach items="${postList}" var="post">
					<div class="card-panel padding-10">
					<input type="hidden" id="firstItem-comment-${post.id}" value="0" />
					<input type="hidden" id="currentPage-comment-${post.id}" value="1" />
						<div class="row mp0">
							<div class="col m12">
								<h1 class="title">
									${post.title}
								</h1>
							</div>
							<div class="col m12 small-text">
								${post.description}
							</div>
							<div class="col m12">
								<div class="feed-item-meta">
									<ul class="feed-actions">
										<li class="feed-comment comment-${post.id}" onclick="javascript:showComment(${post.id});">
										<a class="a-text-color small-text display-inline-flex"><i class="material-icons small-icon">comment</i><spring:message code="label.company.title.comment"/> (6)</a>
										</li>
										<li class="feed-postDate small-text display-inline-flex"><i class="material-icons small-icon">date_range</i>${post.changeLog.createdDate}</li>
									</ul>
								</div>
								<div class="comments comments-${post.id} comment-bg"  style="display: none;">
									<ul class="collection commentList-${post.id} remove-border">
										<li class="display-inline-flex">
											<a class="margin-left-5 small-text a-text-color"><spring:message code="label.company.title.load_more_comment"/></a>
										</li>
									</ul>
									<div class="post-comment">
										<div class="input-field col m12">
											<input id="${post.id}" type="text" class="validate txtComment" placeholder="<spring:message code='label.company.title.write_comment'/>">
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
				<!-- End row activity -->
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
	<script type="text/javascript">

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