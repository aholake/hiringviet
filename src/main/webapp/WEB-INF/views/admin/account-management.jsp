<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Account Management</title>
<!-- iCheck -->
<link href="/resources/vendors/iCheck/skins/flat/green.css"
	rel="stylesheet">
<!-- Datatables -->
<link
	href="/resources/vendors/datatables.net-bs/css/dataTables.bootstrap.min.css"
	rel="stylesheet">
<link
	href="/resources/vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css"
	rel="stylesheet">
<link
	href="/resources/vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css"
	rel="stylesheet">
<link
	href="/resources/vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css"
	rel="stylesheet">
<link
	href="/resources/vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="col-md-12 col-sm-12 col-xs-12">
		<div class="x_panel">
			<div class="x_title">
				<h2>Member Table</h2>
				<ul class="nav navbar-right panel_toolbox">
					<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
					</li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false"><i
							class="fa fa-wrench"></i></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#">Settings 1</a></li>
							<li><a href="#">Settings 2</a></li>
						</ul></li>
					<li><a class="close-link"><i class="fa fa-close"></i></a></li>
				</ul>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<p class="text-muted font-13 m-b-30">The Buttons extension for
					DataTables provides a common set of options, API methods and
					styling to display buttons on a page that will interact with a
					DataTable. The core library provides the based framework upon which
					plug-ins can built.</p>
				<table id="datatable-member"
					class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>ID</th>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Email</th>
							<th>Status</th>
						</tr>
					</thead>
				</table>
			</div>
		</div>
	</div>

	<div class="col-md-12 col-sm-12 col-xs-12">
		<div class="x_panel">
			<div class="x_title">
				<h2>Company Table</h2>
				<ul class="nav navbar-right panel_toolbox">
					<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
					</li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false"><i
							class="fa fa-wrench"></i></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#">Settings 1</a></li>
							<li><a href="#">Settings 2</a></li>
						</ul></li>
					<li><a class="close-link"><i class="fa fa-close"></i></a></li>
				</ul>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<p class="text-muted font-13 m-b-30">The Buttons extension for
					DataTables provides a common set of options, API methods and
					styling to display buttons on a page that will interact with a
					DataTable. The core library provides the based framework upon which
					plug-ins can built.</p>
				<table id="datatable-company"
					class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>ID</th>
							<th>Owner</th>
							<th>Company Name</th>
							<th>Business Field</th>
							<th>Status</th>
						</tr>
					</thead>
				</table>
			</div>
		</div>
	</div>
</body>
</html>

<content tag="js_lib"> <!-- Datatables --> <script
	src="/resources/vendors/datatables.net/js/jquery.dataTables.min.js"></script>
<script
	src="/resources/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<script
	src="/resources/vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
<script
	src="/resources/vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
<script
	src="/resources/vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
<script
	src="/resources/vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
<script
	src="/resources/vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
<script
	src="/resources/vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
<script
	src="/resources/vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
<script
	src="/resources/vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
<script
	src="/resources/vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
<script
	src="/resources/vendors/datatables.net-scroller/js/datatables.scroller.min.js"></script>
<script src="/resources/vendors/jszip/dist/jszip.min.js" ></script> 
<script src="/resources/vendors/pdfmake/build/pdfmake.min.js"></script> 
<script src="/resources/vendors/pdfmake/build/vfs_fonts.js"></script> 
<script src="/resources/hiringviet/admin/js/admin.js"></script>
<script src="/resources/hiringviet/admin/js/account-management.js"></script> <!-- /Datatables -->
</content>