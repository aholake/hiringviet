<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title><decorator:title default="HiringViet"></decorator:title></title>

<!--Import Google Icon Font-->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet"
	href="<c:url value='/resources/common/css/materialize.min.css'/>"
	media="screen,projection" />

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<!--Import jQuery before materialize.js-->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript"
	src="<c:url value='/resources/common/js/materialize.min.js'/>"></script>

<!--Common Style-->
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/common/css/style.css'/>">
<decorator:head></decorator:head>
</head>
<body>
	<%@ include file="/WEB-INF/views/includes/header.jsp"%>
	<jsp:include page="/WEB-INF/views/layouts/company_banner.jsp" />
	<div id="main-container">
		<jsp:include page="/WEB-INF/views/layouts/company_header.jsp" />
		<decorator:body />
	</div>
	<%@ include file="/WEB-INF/views/includes/footer.jsp"%>
</body>
</html>