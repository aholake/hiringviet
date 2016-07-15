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
<title>Insert title here</title>
</head>
<body>
	<div id="introduce-slider">
		<div class="slider">
			<ul class="slides">
				<li><img
					src='<c:url value="/resources/common/images/slider/slider_img.jpg"></c:url>'></li>
				<li><img
					src="<c:url value="/resources/common/images/slider/slider_img-1.jpg"></c:url>"></li>
				<li><img
					src="<c:url value="/resources/common/images/slider/slider_img.jpg"></c:url>"></li>
				<li><img
					src="<c:url value="/resources/common/images/slider/slider_img-1.jpg"></c:url>"></li>
			</ul>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		$('.slider').slider({
			height : 200,
			indicators : false,
			transition : 1000
		});
	});
</script>
</html>