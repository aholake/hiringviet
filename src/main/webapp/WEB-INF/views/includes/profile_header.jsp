<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Profile Header</title>
</head>
<body>
	<input type="hidden" id="url_get_owner_message_list" value="/search/message/owner"/>
	
	<sec:authorize access="hasAuthority('USER') and isAuthenticated()">
		<sec:authentication property="principal" var="principal" />
		<input type="hidden" id="account_id" value="${principal.id}" />
	</sec:authorize>

	<sec:authorize access="hasAuthority('COMPANY') and isAuthenticated()">
		<sec:authentication property="principal" var="principal" />
		<input type="hidden" id="account_id" value="${principal.id}" />
	</sec:authorize>
	
	<div class="row profile-header">
		<div class="col m6 offset-m2">
			<p class="profile-name"><a href="<c:url value='/profile/${member.id}' />">${member.firstName}  ${member.lastName}</a></p>
			<p>100 <spring:message code="label.profile.header.title.count_follow"/></p>
		</div>
		<div class="col m4 margin-top-10 right-align">
			<a href="#messageModal" class="messageModal btn waves-effect waves-light">
				<spring:message code="label.profile.title.message"/>
			</a>
			<c:choose>
				<c:when test="${checkConnect == false}">
					<a class="btn waves-effect waves-light orange" id="btn-connect">
						<spring:message code="label.profile.title.connect"/>
					</a>
				</c:when>
				<c:otherwise>
					
				</c:otherwise>
			</c:choose>
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
			<a href="#!"
				class="modal-action modal-close waves-effect waves-green btn-flat ">Close</a>
		</div>
	</div>
	<script type="text/javascript" src="<c:url value='/resources/hiringviet/profile/js/message.js'/>"></script>
	<script type="text/javascript">
		$(function() {
			$('.messageModal').leanModal();
			$('.messageDetailModal').leanModal();
		})
	</script>
</body>
</html>