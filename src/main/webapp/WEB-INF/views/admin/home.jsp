<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>HOME</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/hiringviet/admin/css/style.css' />">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/common/css/materialize.min.css' />" media="screen,projection" />
<!--Import jQuery before materialize.js-->
<script type="text/javascript" src="<c:url value='/resources/common/js/jquery-2.1.1.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/resources/common/js/materialize.min.js' />"></script>
<!--Import Google Icon Font-->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet" href="/resources/common/css/font-awesome.min.css">
<!--Import materialize.css-->
</head>
<body>
	<nav>
	    <div class="nav-wrapper teal">
	      <a href="#!" class="brand-logo">
	      	<img src="http://img.v3.news.zdn.vn/w660/Uploaded/Yfrur/2016_06_03/chipu_8.jpg" alt="" class="circle">
	      	<span>Nguyen Tuan Anh</span>
	      </a>
	      <ul class="right hide-on-med-and-down">
	        <li><a href="#"><i class="material-icons">search</i></a></li>
	        <li><a href="#"><i class="material-icons">view_module</i></a></li>
	        <li><a href="#"><i class="material-icons">refresh</i></a></li>
	        <li><a href="#!" class="dropdown-button" data-activates="dropdown1"><i class="material-icons">more_vert</i></a></li>
	      </ul>
	    </div>
    </nav>
    <div class="row">
    	<div class="col m2 mp0 menu-left bg">
    		<div class="collection mp0 border-none">
			   <a href="#!" class="collection-item bg-black"><i class="material-icons">home</i><b>Home</b></a>
			   <a href="#!" class="collection-item bg-black"><i class="material-icons">notifications_paused</i><b>Notifications</b></a>
			   <a href="#!" class="collection-item bg-black"><i class="material-icons">schedule</i><b>Schedule</b></a>
			   <a href="#!" class="collection-item bg-black"><i class="material-icons">verified_user</i><b>Active User</b></a>
			   <a href="#!" class="collection-item bg-black"><i class="material-icons">contact_mail</i><b>Contact Mail</b><span class="new badge">4</span></a>
			   <a href="#!" class="collection-item bg-black"><i class="material-icons">perm_data_setting</i><b>Data Setting</b></a>
			   <a href="#!" class="collection-item bg-black"><i class="material-icons">perm_data_setting</i><b>Data Setting</b></a>
			</div>
    	</div>
    	<div class="col m10 content mp0">
    	
    	</div>
    </div>
</body>
</html>