<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Company Header</title>
</head>
<body>
	<input type="hidden" id="url_get_owner_message_list" value="/search/message/owner"/>
	<sec:authorize access="hasAuthority('COMPANY') and isAuthenticated()">
		<sec:authentication property="principal" var="principal" />
		<input type="hidden" id="account_id" value="${principal.id}" />
	</sec:authorize>
	<div class="row company-header">
		<div class="col m6 offset-m2">
			<c:if test="${company != null}">
				<p class="company-name"><a href="<c:url value='/company?companyId=${company.id}&mode=HOME' />">${company.displayName}</a></p>
			</c:if>
			<c:if test="${job != null}">
				<p class="company-name"><a href="<c:url value='/company?companyId=${company.id}&mode=HOME' />">${job.company.displayName}</a></p>
			</c:if>
			<p>${numberFollower} <spring:message code="label.company.header.title.count_follow"/></p>
			<ul class="menu-banner">
				<c:if test="${company != null}">
					<li>
						<c:choose>
							<c:when test="${param.mode == 'HOME'}">
								<a href="<c:url value='/company?companyId=${company.id}&mode=HOME' />" class="active">
									<spring:message code="label.company.title.home"/>
								</a>
							</c:when>
							<c:otherwise>
								<a href="<c:url value='/company?companyId=${company.id}&mode=HOME' />">
									<spring:message code="label.company.title.home"/>
								</a>
							</c:otherwise>
						</c:choose>
					</li>
					<li>
						<c:choose>
							<c:when test="${param.mode == 'CAREER'}">
								<a href="<c:url value='/company?companyId=${company.id}&mode=CAREER' />" class="active">
									<spring:message code="label.company.title.careers"/>
								</a>
							</c:when>
							<c:otherwise>
								<a href="<c:url value='/company?companyId=${company.id}&mode=CAREER' />">
									<spring:message code="label.company.title.careers"/>
								</a>
							</c:otherwise>
						</c:choose>
						
					</li>
				</c:if>
				<c:if test="${job != null}">
					<li>
						<a href="/company?companyId=${job.company.id}&mode=HOME'" class="active">
							<spring:message code="label.company.title.home"/>
						</a>
					</li>
					<li>
						<a href="/company/${job.company.id}&mode=CAREER'">
							<spring:message code="label.company.title.careers"/>
						</a>
					</li>
				</c:if>
			</ul>
		</div>
		<div class="col m4 margin-top-10 right-align">
			<a href="#messageModal" class="messageModal btn waves-effect waves-light">
				<spring:message code="label.profile.title.message"/>
			</a>
			<a class="btn waves-effect waves-light orange">
				<spring:message code="label.company.title.subscribe"/>
			</a>
		</div>
	</div>
	<!-- Modal Structure -->
	<div id="messageModal" class="modal modal-fixed-footer">
		<div class="modal-content">
			<h4>Message Management</h4>
			<div class="row">
				<div class="col m12 mp0">
					<table class="bordered messageTable">
						<thead>
							<tr>
								<th width="5%" data-field="stt">STT</th>
								<th width="70%" data-field="title">Title</th>
								<th width="25%" data-field="dateTime">Date Time</th>
							</tr>
						</thead>
						<tbody class="body">
							<!-- <tr>
								<td>
									<input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" />
									 <label for="filled-in-box"></label>
								</td>
								<td>
									<a href="#messageDetailModal" class="messageDetailModal">Title</a>
								</td>
								<td><span class="dateTime"></span></td>
							</tr> -->
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="modal-footer">
			<a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat ">Close</a>
		</div>
	</div>
	<div id="messageDetailModal" class="modal modal-fixed-footer">
		<div class="modal-content">
			<h4>Message Detail</h4>
			<div class="row">
				<div class="col m12 mp0">
					<p>From: <b class="messateSender"></b></p>
					<p>Date time: <b class="dateTime"></b></p>
					<h6 class="messateTitle"></h6>
					<div class="messateContent">
					</div>
				</div>
			</div>
		</div>
		<div class="modal-footer">
			<a href="#sendMessageModal" class="modal-action modal-close waves-effect waves-green btn-flat sendMessageModal">Reply</a>
			<a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat ">Close</a>
		</div>
	</div>
	<div id="sendMessageModal" class="modal modal-fixed-footer">
		<div class="modal-content">
			<h4>Send Message</h4>
			<div class="row">
				<div class="col m12 mp0">
					<div class="input-field col m12 p-0">
						<input id="toAccount" type="text" class="validate">
						<label for="toAccount">To</label>
					</div>
					<div class="input-field col m12 p-0">
						<input id="title" type="text" class="validate">
						<label for="title">Title</label>
					</div>
					<div class="input-field col m12 p-0">
						<textarea id="txtContent" class="materialize-textarea"></textarea>
					</div>
				</div>
			</div>
		</div>
		<div class="modal-footer">
			<a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat ">Close</a>
		</div>
	</div>
	<script type="text/javascript" src="<c:url value='/resources/hiringviet/profile/js/message.js'/>"></script>
	<script type="text/javascript">
		$(function() {
			$('.messageModal').leanModal();
			$('.messageDetailModal').leanModal();
			$('.sendMessageModal').leanModal();
			CKEDITOR.replace("txtContent");
		})
	</script>
</body>
</html>