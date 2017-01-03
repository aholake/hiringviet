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
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/hiringviet/home/css/home.css'/>">
<link rel="stylesheet" href="/resources/hiringviet/company/css/company.css" />
</head>
<body>

	<input type="hidden" id="url_get_comments" value="<c:url value='/company/post/comments' />" />
	<input type="hidden" id="url_get_replyComments" value="<c:url value='/company/post/replyComments' />" />
	<input type="hidden" id="url_redirect_member" value="<c:url value='/member/' />" />
	<input type="hidden" id="reply_comment" value='<spring:message code="label.company.title.reply_comment"/>' />
	<input type="hidden" id="write_comment" value='<spring:message code="label.company.title.write_comment"/>' />
	<input type="hidden" id="load_more_comment" value='<spring:message code="label.company.title.load_more_comment"/>' />
	<input type="hidden" id="hide_comment" value='<spring:message code="label.company.title.hide_comment"/>' />
	<input type="hidden" id="url_add_comment" value="<c:url value='/company/addComment' />" />
	<input type="hidden" id="url_add_reply_comment" value="<c:url value='/company/addReplyComment' />" />
	<input type="hidden" id="url_count_member_of_follwer" value="<c:url value='/profile/countNumberOfFollower'/>"/>
	<input type="hidden" id="id_of_account" value="${memberLogin.id}"/>
	<input type="hidden" id="is_owner" value="${isOwner}"/>
		<div class="row">
			<c:choose>
				<c:when test="${param.mode == 'CAREER'}">
				<div class="col m8">
					<div class="card-panel">
						<div class="panel-title"><spring:message code="label.company.title.active"/></div>
							<div class="panel-content">
								<div id="job-list">
								<c:forEach items="${jobList}" var="job">
									<div class="job-box">
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
														<div class="col m12 none-padding-left text-justify block-with-text edit-text-ellipsis">
															${job.description}
														</div>
														<div class="col m12 none-padding-left margin-top-5">
															<c:forEach items="${job.skillSet}" var="skill">
																<a class="chip">${skill.displayName}</a>
															</c:forEach>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="apply-number">
											<div class="label">Applied CV: </div>
											<div class="value">${applyNumbers[job] }</div>
										</div>
									</div>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>	
				</c:when>
				<c:otherwise>
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
					<c:if test="${param.companyId == companyLogin.id}">
						<form action="/company/addPosts" method="POST">
							<div class="card-panel padding-10">
								<h1 class="title">Trạng thái</h1>
								<h6 class="title">Title</h6>
								<div class="input-field col m12 p-0">
							    	<input id="title" type="text" class="validate" name="title" />
							    </div>
							    <h6 class="title">Content</h6>
								<div class="input-field col m12 p-0">
									<textarea rows="10" cols="80" id="content" name="description"></textarea>
								</div>
								<div class="text-right">
									<button class="btn waves-effect waves-light margin-top-10" type="submit" name="action">Submit</button>
								</div>
							</div>
						</form>
					</c:if>
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
												<a class="a-text-color small-text display-inline-flex">
													<i class="material-icons small-icon">comment</i>
													<spring:message code="label.company.title.comment"/>
													<c:if test="${post.numberComment > 0}">
													 (<span class="a-text-color numberComment-${post.id}">${post.numberComment}</span>)
													</c:if>
												 </a>
												 <input type="hidden" class="currentNumberComment-${post.id}" value="0"/>
											</li>
											<li class="feed-postDate small-text display-inline-flex"><i
												class="material-icons small-icon">date_range</i>
												<fmt:formatDate pattern="yyyy-MM-dd, hh:mm:ss a" value="${post.changeLog.createdDate}" />
											</li>
										</ul>
									</div>
									<div class="comments comments-${post.id} comment-bg"  style="display: none;">
										<ul class="collection commentList-${post.id} remove-border">
											
										</ul>
										<c:if test="${memberLogin != null}">
											<div class="post-comment">
												<div class="input-field col m12">
													<input id="${post.id}" type="text" onkeypress="javascript:checkComment(event, ${post.id});" class="validate txtComment txtComment-${post.id}" placeholder="<spring:message code='label.company.title.write_comment'/>">
												</div>
											</div>
										</c:if>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
					<!-- End row activity -->
				</div>
				</c:otherwise>
			</c:choose>
			<div class="col m4">
				<div class="card-panel">
					<div class="panel-title"><spring:message code="label.company.title.company_information"/></div>
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
											: <span class="info">${company.companySize} 
											<spring:message code="label.home.title.people" /></span>
										</p>
										<p class="col s12 none-padding-left">
											<i class="material-icons prefix-icon">web</i>
											<spring:message code="label.home.title.website" />
											: <span class="info"><a target="_blank" href="${company.website}">${company.website}</a></span>
										</p>
									</div>
								</div>
								<div class="col m3 hide-on-med-and-down">
									<img src="${company.avatar}" class="right responsive-img img-full">
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
								<p class="small-text">
									${job.address.explicitAddress},&nbsp;
									${job.address.district.type}&nbsp;${job.address.district.districtName},&nbsp;
									${job.address.district.province.type}&nbsp;${job.address.district.province.provinceName},
								</p>
								<p class="small-text display-inline-flex">
									<i class="material-icons small-icon">date_range</i>
									<fmt:formatDate pattern="yyyy-MM-dd, hh:mm:ss a" value="${job.postDate}" />
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
    			<a href="#">
		    		<img src="">
		    	</a>
    		</div>
    		<div class="col m8" style="text-align: left;">
    			<a href="" class="endorse-item-name-text"></a>
    			<p class="mp0 small-text"><span class="number-followers"></span> follower</p>
    		</div>
    		<div class="col m12 margin-top-5">
	    		<a href="" class="btn-connect waves-effect waves-light btn margin-right-5"><spring:message code="label.profile.tooltip.title.connect"/></a>
	    		<a class="btn-profile waves-effect waves-light btn grey"><spring:message code="label.profile.tooltip.title.profile"/></a>
    		</div>
    		<div class="triangle">
    		</div>
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
	<script src="<c:url value='/resources/hiringviet/company/js/company.js'/>"></script>
	<script type="text/javascript" src="/resources/common/js/ckeditor/ckeditor.js"></script>
</body>
</html>