<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>
		Welcome ${account.member.firstName} ${account.member.lastName} </br>
		<sec:authorize access="hasAuthority('ADMIN')">
 This content will only be visible to users who have
 the "supervisor" authority in their list of <tt>GrantedAuthority</tt>s.
</sec:authorize>
	</h1>
</body>
</html>