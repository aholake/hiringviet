<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Company Header</title>
</head>
<body>
	<c:if test="${company != null}">
		<input type="hidden" id="company_account_id" value="${company.account.id}" />
	</c:if>
	<c:if test="${job != null}">
		<input type="hidden" id="company_account_id" value="${job.company.account.id}" />
	</c:if>
	<input type="hidden" id="url_get_owner_message_list" value="/search/message/owner"/>
	<sec:authorize access="hasAuthority('COMPANY') and isAuthenticated()">
		<sec:authentication property="principal" var="principal" />
		<input type="hidden" id="account_id" value="${principal.id}" />
	</sec:authorize>
	<div class="row company-header">
		<div class="col m6 offset-m2">
			<c:if test="${company != null}">
				<p class="company-name"><a href="/company?companyId=${company.id}&mode=HOME">${company.displayName}</a></p>
			</c:if>
			<c:if test="${job != null && company == null}">
				<p class="company-name"><a href="/company?companyId=${job.company.id}&mode=HOME">${job.company.displayName}</a></p>
			</c:if>
			<span id="btn-follow-company"><a href="#followModal" class="followModal"><p>${numberFollower} <spring:message code="label.company.header.title.count_follow"/></p></a></span>
			<ul class="menu-banner">
				<c:if test="${company != null}">
					<li>
						<c:choose>
							<c:when test="${param.mode == 'HOME'}">
								<a href="/company?companyId=${company.id}&mode=HOME" class="active">
									<spring:message code="label.company.title.home"/>
								</a>
							</c:when>
							<c:otherwise>
								<a href="/company?companyId=${company.id}&mode=HOME">
									<spring:message code="label.company.title.home"/>
								</a>
							</c:otherwise>
						</c:choose>
					</li>
					<li>
						<c:choose>
							<c:when test="${param.mode == 'CAREER'}">
								<a href="/company?companyId=${company.id}&mode=CAREER" class="active">
									<spring:message code="label.company.title.careers"/>
								</a>
							</c:when>
							<c:otherwise>
								<a href="/company?companyId=${company.id}&mode=CAREER">
									<spring:message code="label.company.title.careers"/>
								</a>
							</c:otherwise>
						</c:choose>
						
					</li>
				</c:if>
				<c:if test="${job != null && company == null}">
					<li>
						<a href="/company?companyId=${job.company.id}&mode=HOME">
							<spring:message code="label.company.title.home"/>
						</a>
					</li>
					<li>
						<a href="/company?companyId=${job.company.id}&mode=CAREER">
							<spring:message code="label.company.title.careers"/>
						</a>
					</li>
				</c:if>
			</ul>
		</div>
		<div class="col m4 margin-top-10 right-align">
			<sec:authorize access="hasAuthority('USER') and isAuthenticated()">
			<a href="#messageModal" class="messageModal btn waves-effect waves-light">
				<spring:message code="label.profile.title.message"/>
			</a>
			</sec:authorize>
			<c:if test="${hasFollow != true}">
				<c:if test="${param.companyId != null}">
					<sec:authorize access="hasAuthority('USER') and isAuthenticated()">
						<a href="#subscribeModal" class="subscribeModal btn waves-effect waves-light orange">
							<spring:message code="label.company.title.subscribe"/>
						</a>
					</sec:authorize>
				</c:if>
			</c:if>
		</div>
	</div>
	<!-- Modal Structure -->
	<div id="messageModal" class="modal modal-fixed-footer">
		<div class="modal-content">
			<h4><spring:message code="label.company.message.title"></spring:message> </h4>
			<div class="row">
				<div class="col m12 mp0">
					<table class="bordered messageTable">
						<thead>
							<tr>
								<th width="5%" data-field="stt"><spring:message code="label.company.message.no"></spring:message> </th>
								<th width="70%" data-field="title"><spring:message code="label.company.message.title"></spring:message> </th>
								<th width="25%" data-field="dateTime"><spring:message code="label.company.message.date_time"></spring:message> </th>
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
			<a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat "><spring:message code="label.common.cancel"></spring:message> </a>
		</div>
	</div>
	<div id="messageDetailModal" class="modal modal-fixed-footer">
		<div class="modal-content">
			<h4><spring:message code="label.company.message.detail.title"></spring:message> </h4>
			<div class="row">
				<div class="col m12 mp0">
					<p><spring:message code="label.company.message.detail.from"></spring:message>: <b class="messateSender"></b></p>
					<p><spring:message code="label.company.message.date_time"></spring:message>: <b class="dateTime"></b></p>
					<h6 class="messateTitle"></h6>
					<div class="messateContent">
					</div>
				</div>
			</div>
		</div>
		<div class="modal-footer">
			<a href="#sendMessageModal" class="modal-action modal-close waves-effect waves-green btn-flat sendMessageModal"><spring:message code="label.company.message.detail.reply"></spring:message></a>
			<a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat "><spring:message code="label.common.cancel"></spring:message></a>
		</div>
	</div>
	
	<form action="/api/message/send" method="post" id="sendMessageModal" class="modal modal-fixed-footer">
			<div class="modal-content">
				<h4><spring:message code="label.company.message.send.title"></spring:message></h4>
				<div class="row">
					<div class="col m12 mp0">
						<div class="input-field col m12 p-0">
							<input id="toAccount" type="text" class="validate" name="emailReceiver"> <label
								for="toAccount"><spring:message code="label.company.message.send.to"></spring:message></label>
						</div>
						<div class="input-field col m12 p-0">
							<input id="title" type="text" class="validate" name="title"> <label
								for="title"><spring:message code="label.company.message.title"></spring:message></label>
						</div>
						<div class="input-field col m12 p-0">
							<textarea id="txtContent" class="materialize-textarea" name="content"></textarea>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="submit"
					class="modal-action waves-effect waves-green btn-flat"><spring:message code="label.company.message.send.submit"></spring:message></button>
				<a href="#!"
					class="modal-action modal-close waves-effect waves-green btn-flat "><spring:message code="label.common.cancel"></spring:message></a>
			</div>
	</form>

	<form action="/apply/sendApprovalMessage" method="post"
		id="sendApprovalMessageModal" class="modal modal-fixed-footer">
		<div class="modal-content">
			<h4><spring:message code="label.company.message.send.title"></spring:message></h4>
			<div class="row">
				<input id="approvalApplyId" type="hidden" name="applyId">
				<input id="approvalJobId" type="hidden" name="jobId">
				<input id="approvalCompanyId" type="hidden" name="companyId">
				<div class="col m12 mp0">
					<div class="input-field col m12 p-0">
						<input id="confirmTitle" type="text" class="validate" name="title" value="XÁC NHẬN HỒ SƠ ỨNG TUYỂN" required>
						<label for="title"><spring:message code="label.company.message.title "></spring:message></label>
					</div>
					<div class="input-field col m12 p-0">
						<textarea id="approvalContent" class="materialize-textarea" name="content" required></textarea>
					</div>
				</div>
			</div>
		</div>
		<div class="modal-footer">
			<button type="submit"
				class="modal-action waves-effect waves-green btn-flat"><spring:message code="label.company.message.send.submit"></spring:message></button>
			<a href="#!"
				class="modal-action modal-close waves-effect waves-green btn-flat "><spring:message code="label.common.cancel"></spring:message></a>
		</div>
	</form>

	<!-- Modal Structure -->
	<div id="subscribeModal" class="modal">
		<form action="/company/subscribe" method="POST">
			<input type="hidden" name="companyId" value="${param.companyId}"/>
			<input type="hidden" name="mode" value="${param.mode}"/>
			<input type="hidden" name="accountId" value="${company.account.id}"/>
			<div class="modal-content">
				<h4><spring:message code="label.company.subscribe.title"></spring:message></h4>
				<p>Sau khi Subscribe bạn sẽ nhận đc thông báo toàn bộ hoạt động của công ty đã Subscribe.</p>
			</div>
			<div class="modal-footer">
				<button type="submit" class="modal-action modal-close waves-effect waves-green btn-flat"><spring:message code="label.common.agree"></spring:message></button>
				<a href="javascript:void();" class="modal-action modal-close waves-effect waves-green btn-flat"><spring:message code="label.common.cancel"></spring:message></a>
			</div>
		</form>
	</div>
	<!-- Modal Structure -->
	<div id="followModal" class="modal modal-fixed-footer">
		<div class="modal-content">
			<h4><spring:message code="label.company.follow.title"></spring:message></h4>
			<p>${numberFollower} <spring:message code="label.company.follow.info"></spring:message></p>
			<div class="row">
				<div class="col m12 mp0" id="company_follow_list">
				</div>
			</div>
		</div>
		<div class="modal-footer">
			<a href="javascript:void()" class="modal-action modal-close waves-effect waves-green btn-flat "><spring:message code="label.common.cancel"></spring:message></a>
		</div>
	</div>
	<script type="text/javascript" src="<c:url value='/resources/hiringviet/profile/js/message.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/hiringviet/home/js/follow.js'/>"></script>
	<script type="text/javascript">
		$(function() {
			$('.followModal').leanModal();
			$('.messageModal').leanModal();
			$('.messageDetailModal').leanModal();
			$('.sendMessageModal').leanModal();
			$('.subscribeModal').leanModal();
			$(".sendApprovalMessageModal").leanModal();
			CKEDITOR.replace("txtContent");
			CKEDITOR.replace("approvalContent");
		})
	</script>
</body>
</html>