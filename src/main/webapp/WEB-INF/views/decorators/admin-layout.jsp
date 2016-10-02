<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>HOME</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/hiringviet/admin/css/style.css' />">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet"
	href="<c:url value='/resources/common/css/materialize.min.css' />"
	media="screen,projection" />
<!--Import jQuery before materialize.js-->
<script type="text/javascript"
	src="<c:url value='/resources/common/js/jquery-2.1.1.min.js' />"></script>
<script type="text/javascript"
	src="<c:url value='/resources/common/js/materialize.min.js' />"></script>
<!--Import Google Icon Font-->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet" href="/resources/common/css/font-awesome.min.css">
<!--Import materialize.css-->

<decorator:head />
</head>
<body>
	<div class="row">
		<div class="col m3 panel-left">
			<div class="welcome-box">
				<p>Welcome Administrator</p>

			</div>

			<div class="item-index-box">
				<ul>
					<li><a href="#" class="active"><i class="material-icons">home</i>Home</a></li>
					<li><a href="#"><i class="material-icons">notifications_paused</i>Notification</a></li>
					<li><a href="#"><i class="material-icons">contact_mail</i>Mail
							Box</a></li>
					<li><a href="#"><i class="material-icons">perm_data_setting</i>Data
							Management</a>
						<ul class="sub-item-index">
							<li><a href="#"><i class="material-icons">supervisor_account</i>Member</a></li>
							<li><a href="#"><i class="material-icons">account_balance</i>Company</a></li>
							<li><a href="#"><i class="material-icons">work</i>Job</a></li>
							<li><a href="#"><i class="material-icons">history</i>Log</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
		<div class="col m9 grey lighten-5 panel-right">
			<decorator:body />
		</div>
	</div>
</body>
</html>