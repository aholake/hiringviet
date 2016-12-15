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
			<a class="btn waves-effect waves-light">
				<spring:message code="label.company.title.message"/>
			</a> 
			<a class="btn waves-effect waves-light orange">
				<spring:message code="label.company.title.subscribe"/>
			</a>
		</div>
	</div>
</body>
</html>