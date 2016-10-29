<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>



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
					<th>Action</th>
				</tr>
			</thead>
			<tbody></tbody>
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
			var table = $('#memberDataTable').DataTable({
				ajax : {
					url : '/admin/api/members',
					dataSrc : ''
				},
				processing : true,
				columns : [ {
					data : "id"
				}, {
					data : "email"
				}, {
					data : "firstName"
				}, {
					data : "lastName"
				}, {
					data : "active"
				}],
				columnDefs: [{
					targets: 5,
					data: null,
					defaultContent: "<button id='delete'>Delete</button>"
				}]
			});
			
			function removeRow(response) {
				alert(response);
			}
			
			$('#memberDataTable tbody').on( "click", "#delete", function () {
		        var data = table.row( $(this).parents('tr') ).data();
		        var id = data.id;
		        console.log(id);
		        callAPI("/admin/api/members","DELETE", id, "removeRow");
		    } );
			
		})
	</script>
</body>
</html>