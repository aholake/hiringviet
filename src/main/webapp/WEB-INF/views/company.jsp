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
<title>Company</title>
<!-- Local style -->
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/hiringviet/home/css/home.css'/>">
<!-- CSS media query on a link element -->
<link rel="stylesheet"
	href="/resources/hiringviet/home/css/smart-home.css" />
<link rel="stylesheet"
	href="/resources/hiringviet/company/css/company.css" />
</head>
<body>
	<jsp:include page="/layouts/navbar"></jsp:include>

	<jsp:include page="/layouts/companyBanner"></jsp:include>

	<div id="main-container">

		<jsp:include page="/layouts/companyHeader"></jsp:include>

		<div class="row">
			<div class="col m8">
				<div class="card-panel">
					<div class="panel-title">Hoạt động</div>
					<div class="row">
						<div class="input-field col m12">
							<i class="material-icons prefix">mode_edit</i>
							<textarea id="icon_prefix2" class="materialize-textarea"></textarea>
							<label for="icon_prefix2">Có gì mới?</label>
						</div>
						<div class="col m12 right-align">
							<a href="#" class="btn">Post</a>
						</div>
					</div>
					<div class="row activity">
						<div class="col m1 offset-m1">
							<img class="responsive-img circle" src="images/logofsoft.png" />
						</div>
						<div class="col m10">
							<span>If you have a fixed height in your container, you
								can set line-height to be the same as height, and it will center
								vertically. Then just add text-align to center horizontally.</span>
						</div>
						<div class="col m10 offset-m2">
							<a href="#"><i class="material-icons prefix-icon">thumb_up</i></a>
							<span class="small-text">30 người thích</span>
						</div>
					</div>
					<div class="row activity">
						<div class="col m1 offset-m1">
							<img class="responsive-img circle" src="images/logofsoft.png" />
						</div>
						<div class="col m10">
							<span>If you have a fixed height in your container, you
								can set line-height to be the same as height, and it will center
								vertically. Then just add text-align to center horizontally.</span>
						</div>
						<div class="col m10 offset-m2">
							<a href="#"><i class="material-icons prefix-icon">thumb_up</i></a>
							<span class="small-text">30 người thích</span>
						</div>
					</div>
					<div class="row activity">
						<div class="col m1 offset-m1">
							<img class="responsive-img circle" src="images/logofsoft.png" />
						</div>
						<div class="col m10">
							<span>If you have a fixed height in your container, you
								can set line-height to be the same as height, and it will center
								vertically. Then just add text-align to center horizontally.</span>
						</div>
						<div class="col m10 offset-m2">
							<a href="#"><i class="material-icons prefix-icon">thumb_up</i></a>
							<span class="small-text">30 người thích</span>
						</div>
					</div>
					<div class="row activity">
						<div class="col m1 offset-m1">
							<img class="responsive-img circle" src="images/logofsoft.png" />
						</div>
						<div class="col m10">
							<span>If you have a fixed height in your container, you
								can set line-height to be the same as height, and it will center
								vertically. Then just add text-align to center horizontally.</span>
						</div>
						<div class="col m10 offset-m2">
							<a href="#"><i class="material-icons prefix-icon">thumb_up</i></a>
							<span class="small-text">30 người thích</span>
						</div>
					</div>
					<div class="row activity">
						<div class="col m1 offset-m1">
							<img class="responsive-img circle" src="images/logofsoft.png" />
						</div>
						<div class="col m10">
							<span>If you have a fixed height in your container, you
								can set line-height to be the same as height, and it will center
								vertically. Then just add text-align to center horizontally.</span>
						</div>
						<div class="col m10 offset-m2">
							<a href="#"><i class="material-icons prefix-icon">thumb_up</i></a>
							<span class="small-text">30 người thích</span>
						</div>
					</div>
					<div class="row activity">
						<div class="col m1 offset-m1">
							<img class="responsive-img circle" src="images/logofsoft.png" />
						</div>
						<div class="col m10">
							<span>If you have a fixed height in your container, you
								can set line-height to be the same as height, and it will center
								vertically. Then just add text-align to center horizontally.</span>
						</div>
						<div class="col m10 offset-m2">
							<a href="#"><i class="material-icons prefix-icon">thumb_up</i></a>
							<span class="small-text">30 người thích</span>
						</div>
					</div>
					<div class="row activity">
						<div class="col m1 offset-m1">
							<img class="responsive-img circle" src="images/logofsoft.png" />
						</div>
						<div class="col m10">
							<span>If you have a fixed height in your container, you
								can set line-height to be the same as height, and it will center
								vertically. Then just add text-align to center horizontally.</span>
						</div>
						<div class="col m10 offset-m2">
							<a href="#"><i class="material-icons prefix-icon">thumb_up</i></a>
							<span class="small-text">30 người thích</span>
						</div>
					</div>
				</div>
			</div>
			<div class="col m4">
				<div class="card-panel">
					<div class="panel-title">THÔNG TIN CÔNG TY</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>