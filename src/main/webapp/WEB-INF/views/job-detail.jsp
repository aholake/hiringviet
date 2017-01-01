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
</head>
<body>
	<input type="hidden" id="url_get_comments" value="<c:url value='/company/careers/comments' />" />
	<input type="hidden" id="url_get_replyComments" value="<c:url value='/company/post/replyComments' />" />
	<input type="hidden" id="url_redirect_member" value="<c:url value='/member/' />" />
	<input type="hidden" id="reply_comment" value='<spring:message code="label.company.title.reply_comment"/>' />
	<input type="hidden" id="write_comment" value='<spring:message code="label.company.title.write_comment"/>' />
	<input type="hidden" id="load_more_comment" value='<spring:message code="label.company.title.load_more_comment"/>' />
	<input type="hidden" id="hide_comment" value='<spring:message code="label.company.title.hide_comment"/>' />
	<input type="hidden" id="url_add_comment" value="<c:url value='/company/addComment' />" />
	<input type="hidden" id="url_add_reply_comment" value="<c:url value='/company/addReplyComment' />" />
	<input type="hidden" id="job_id" value="${param.jobId}" />
	<input type="hidden" id="firstItem-comment" value="0" />
	<input type="hidden" id="currentPage-comment" value="1" />
	<input type="hidden" id="id_of_account" value="${memberLogin.id}"/>

		<div class="row">
			<div class="col m8">
				<!--GENERAL JOB INFO-->
				<div class="card-panel job-detail">
					<div class="row">
						<div class="row">
							<div class="col m12">
								<p class="title blue-text">${job.title}</p>
							</div>
							<div class="col m7 offset-m5 date-and-view right-align">
								<span>
									<i class="material-icons prefix-icon small-icon">date_range</i>
									Đăng ngày: <fmt:formatDate pattern="yyyy-MM-dd, hh:mm:ss a" value="${job.postDate}" /> | 
								</span>
								<span><i class="material-icons prefix-icon small-icon">visibility</i> Lượt xem: ${job.numberVisited}</span>
							</div>
							<div class="col m12">
								<hr class="fancy-hr">
							</div>
						</div>
						<div class="row">
							<div class="col m8 p-0">
								<div class="row">
									<div class="col m12">
										<span class="bold-text"><i class="material-icons prefix-icon small-icon">location_on</i>Nơi làm việc: </span>
										<span>
										${job.company.address.district.districtName}, 
										${job.company.address.district.province.provinceName}
										</span>
									</div>
									<div class="col m12">
										<span class="bold-text"><i class="material-icons prefix-icon small-icon">loyalty</i>Chức vụ: </span><span
											class="orange-text">${job.position.displayName}</span>
									</div>
									<div class="col m12">
										<span class="bold-text"><i class="material-icons prefix-icon small-icon">attach_money</i>Lương: </span><span
											class="orange-text">${job.minSalary}$ - ${job.maxSalary}$</span>
									</div>
									<div class="col m12">
										<span class="bold-text"><i class="material-icons prefix-icon small-icon">people</i>Số lượng: </span><span
											class="orange-text">${job.size}</span>
									</div>
									<div class="col m12">
										<span class="bold-text"><i class="material-icons prefix-icon small-icon">list</i>Kỹ năng: </span>
										<c:forEach items="${job.skillSet}" var="skill">
											<div class="chip">${skill.displayName}</div>
										</c:forEach>
									</div>
								</div>
							</div>
							<div class="col m4">
								<div class="row">
									<c:if test="${memberLogin != null}">
										<a class="waves-effect waves-light btn col m9 offset-m2 favourite-btn red lighten-2">
										<i class="material-icons left white-text">bookmark</i>Yêu thích</a>
									</c:if>
									<form action="/job/apply" method="post">
										<input id="jobList" name="jobList" type="hidden" value="${job.id }">
										<button type="submit" class="waves-effect waves-light btn col m9 offset-m2 margin-top-10">
										<i class="material-icons left white-text">note_add</i>Ứng tuyển</button>
									</form>
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
								${job.description}
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
								${job.requirement}
							</div>
						</div>
					</div>
				</div>
				<div class="card-panel">
					<div class="row">
						<div class="col m12">
							<h5>Chính sách công ty</h5>
							<hr>
							<div class="higher-line">
								${job.company.companyPolicies}
							</div>
						</div>
					</div>
				</div>
				<div class="card-panel">
				<div class="row">
					<div class="col m12">
						<h5>Bình luận</h5>
						<hr>
						<ul class="collection commentList remove-border">
							<li class="display-inline-flex">
								<a class="margin-left-5 small-text a-text-color"><spring:message code="label.company.title.load_more_comment"/></a>
							</li>
						</ul>
						<c:if test="${memberLogin != null}">
							<div class="post-comment">
								<div class="input-field col m12 mp0">
									<input id="txtComment" type="text" onkeypress="javascript:checkComment(event);" class="validate" placeholder="<spring:message code='label.company.title.write_comment'/>">
								</div>
							</div>
						</c:if>
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
									<h1 class="title">${job.company.displayName}</h1>
									<div class="small-text">
										<p class="col s12 none-padding-left">
											<i class="material-icons prefix-icon">flag</i>
											<spring:message code="label.home.title.country" />
											: <span class="info">${job.company.hostCountry.countryName}</span>
										</p>
										<p class="col s12 none-padding-left">
											<i class="material-icons prefix-icon">equalizer</i>
											<spring:message code="label.home.title.company_size" />
											: <span class="info">${job.company.companySize}<spring:message
													code="label.home.title.people" /></span>
										</p>
										<p class="col s12 none-padding-left">
											<i class="material-icons prefix-icon">web</i>
											<spring:message code="label.home.title.website" />
											: <span class="info">${job.company.website}</span>
										</p>
										<p class="col s12 none-padding-left">
											<i class="material-icons prefix-icon">location_on</i>
											<spring:message code="label.home.title.address" />
											: <span class="info">${job.company.address.district.province.provinceName}</span>
										</p>
									</div>
								</div>
								<div class="col m3 hide-on-med-and-down">
									<img src="${job.company.avatar}" class="right responsive-img">
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
	<div id="divLoading"></div>
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
	<script src="<c:url value='/resources/hiringviet/job/js/job-details.js'/>"></script>
	<script src="<c:url value='/resources/common/js/ckeditor/ckeditor.js'/>"></script>
</body>
</html>