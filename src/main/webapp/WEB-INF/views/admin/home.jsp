<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="/resources/common/css/select.dataTables.min.css" />
<link rel="stylesheet"
	href="/resources/common/css/buttons.dataTables.min.css" />	
<script type="text/javascript"
	src="<c:url value='/resources/common/js/jquery.dataTables.min.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/resources/common/js/dataTables.select.min.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/resources/common/js/dataTables.buttons.min.js'/>"></script>
</head>
<body>
	<div class="light-green title-panel">
		<span>User Manager</span>
	</div>

	<div class="content">
		<table id="memberDataTable" class="mdl-data-table" cellspacing="0"
			width="100%">
			<thead>
				<tr>
					<th>Id</th>
					<th>Email</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Status</th>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<th>Id</th>
					<th>Email</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Status</th>
				</tr>
			</tfoot>
		</table>
	</div>

	<script type="text/javascript">
		console.log("init datatable");
		$(function() {
			$('#memberDataTable').DataTable({
				buttons: ['copy','pdf','excel'],
				ajax : {
					url : 'members',
					dataSrc : ''
				},
				select: true,
				serverSide : true,
				processing: true,
				aoColumns : [ {
					"mData" : "id"
				}, {
					"mData" : "email"
				}, {
					"mData" : "firstName"
				}, {
					"mData" : "lastName"
				}, {
					"mData" : "active"
				} ],
				columnDefs : [ {
					"defaultContent" : "-",
					"targets" : "_all"
				} ]
			});
		})
	</script>
</body>
</html>