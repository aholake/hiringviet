<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<head>
	<title>Dashboard</title>
</head>
<body>
	<!-- top tiles -->
	<div class="row tile_count" ng-controller="statController">
		<div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
			<span class="count_top"><i class="fa fa-user"></i> Total Members</span>
			<div class="count">{{data.stat.totalMember}}</div>
			<span class="count_bottom"><i class="green">4% </i> From last Week</span>
		</div>
		<div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
			<span class="count_top"><i class="fa fa-clock-o"></i> Total Companies</span>
			<div class="count">{{data.stat.totalCompany}}</div>
			<span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i>3% </i> From last Week</span>
		</div>
		<div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
			<span class="count_top"><i class="fa fa-user"></i> Total Connections</span>
			<div class="count green">{{data.stat.totalConnect}}</div>
			<span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i>34% </i> From last Week</span>
		</div>
		<div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
			<span class="count_top"><i class="fa fa-user"></i> Total Posts</span>
			<div class="count">{{data.stat.totalPost}}</div>
			<span class="count_bottom"><i class="red"><i class="fa fa-sort-desc"></i>12% </i> From last Week</span>
		</div>
		<div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
			<span class="count_top"><i class="fa fa-user"></i> Total Inbox</span>
			<div class="count">{{data.stat.totalInbox}}</div>
			<span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i>34% </i> From last Week</span>
		</div>
	</div>
	<div class="col-md-4 col-sm-4 col-xs-12">
		<div class="x_panel tile fixed_height_320 overflow_hidden">
			<div class="x_title">
				<h2>Device Usage</h2>
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
			<table class="" style="width: 100%">
				<tr>
					<th style="width: 37%;">
						<p>Top 5</p>
					</th>
					<th>
						<div class="col-lg-7 col-md-7 col-sm-7 col-xs-7">
							<p class="">Device</p>
						</div>
						<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
							<p class="">Progress</p>
						</div>
					</th>
				</tr>
				<tr>
					<td>
						<canvas id="canvas1" height="140" width="140"
						style="margin: 15px 10px 10px 0"></canvas>
					</td>
					<td>
						<table class="tile_info">
							<tr>
								<td>
									<p>
										<i class="fa fa-square blue"></i>IOS
									</p>
								</td>
								<td>30%</td>
							</tr>
							<tr>
								<td>
									<p>
										<i class="fa fa-square green"></i>Android
									</p>
								</td>
								<td>10%</td>
							</tr>
							<tr>
								<td>
									<p>
										<i class="fa fa-square purple"></i>Blackberry
									</p>
								</td>
								<td>20%</td>
							</tr>
							<tr>
								<td>
									<p>
										<i class="fa fa-square aero"></i>Symbian
									</p>
								</td>
								<td>15%</td>
							</tr>
							<tr>
								<td>
									<p>
										<i class="fa fa-square red"></i>Others
									</p>
								</td>
								<td>30%</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>
	</div>
</div>
<div class="col-md-4 col-sm-4 col-xs-12">
	<div class="x_panel tile fixed_height_320">
		<div class="x_title">
			<h2>Quick Settings</h2>
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
		<div class="dashboard-widget-content">
			<ul class="quick-list">
				<li><i class="fa fa-calendar-o"></i><a href="#">Settings</a>
			</li>
			<li><i class="fa fa-bars"></i><a href="#">Subscription</a></li>
			<li><i class="fa fa-bar-chart"></i><a href="#">Auto
			Renewal</a></li>
			<li><i class="fa fa-line-chart"></i><a href="#">Achievements</a>
		</li>
		<li><i class="fa fa-bar-chart"></i><a href="#">Auto
		Renewal</a></li>
		<li><i class="fa fa-line-chart"></i><a href="#">Achievements</a>
	</li>
	<li><i class="fa fa-area-chart"></i><a href="#">Logout</a></li>
</ul>
<div class="sidebar-widget">
	<h4>Profile Completion</h4>
	<canvas width="150" height="80" id="foo" class=""
	style="width: 160px; height: 100px;"></canvas>
	<div class="goal-wrapper">
		<span class="gauge-value pull-left">$</span> <span
	id="gauge-text" class="gauge-value pull-left">3,200</span> <span
id="goal-text" class="goal-value pull-right">$5,000</span>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
<div class="row">
<div class="col-md-4 col-sm-4 col-xs-12">
<div class="x_panel">
<div class="x_title">
<h2>
Recent Activities <small>Sessions</small>
</h2>
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
<div class="dashboard-widget-content">
<ul class="list-unstyled timeline widget">
<li>
<div class="block">
<div class="block_content">
	<h2 class="title">
	<a>Who Needs Sundance When You’ve Got&nbsp;Crowdfunding?</a>
	</h2>
	<div class="byline">
		<span>13 hours ago</span> by <a>Jane Smith</a>
	</div>
	<p class="excerpt">
		Film festivals used to be do-or-die moments for movie makers.
		They were where you met the producers that could fund your
		project, and if the buyers liked your flick, they’d pay to
		Fast-forward and… <a>Read&nbsp;More</a>
	</p>
</div>
</div>
</li>
<li>
<div class="block">
<div class="block_content">
	<h2 class="title">
	<a>Who Needs Sundance When You’ve Got&nbsp;Crowdfunding?</a>
	</h2>
	<div class="byline">
		<span>13 hours ago</span> by <a>Jane Smith</a>
	</div>
	<p class="excerpt">
		Film festivals used to be do-or-die moments for movie makers.
		They were where you met the producers that could fund your
		project, and if the buyers liked your flick, they’d pay to
		Fast-forward and… <a>Read&nbsp;More</a>
	</p>
</div>
</div>
</li>
<li>
<div class="block">
<div class="block_content">
	<h2 class="title">
	<a>Who Needs Sundance When You’ve Got&nbsp;Crowdfunding?</a>
	</h2>
	<div class="byline">
		<span>13 hours ago</span> by <a>Jane Smith</a>
	</div>
	<p class="excerpt">
		Film festivals used to be do-or-die moments for movie makers.
		They were where you met the producers that could fund your
		project, and if the buyers liked your flick, they’d pay to
		Fast-forward and… <a>Read&nbsp;More</a>
	</p>
</div>
</div>
</li>
<li>
<div class="block">
<div class="block_content">
	<h2 class="title">
	<a>Who Needs Sundance When You’ve Got&nbsp;Crowdfunding?</a>
	</h2>
	<div class="byline">
		<span>13 hours ago</span> by <a>Jane Smith</a>
	</div>
	<p class="excerpt">
		Film festivals used to be do-or-die moments for movie makers.
		They were where you met the producers that could fund your
		project, and if the buyers liked your flick, they’d pay to
		Fast-forward and… <a>Read&nbsp;More</a>
	</p>
</div>
</div>
</li>
</ul>
</div>
</div>
</div>
</div>
<div class="col-md-8 col-sm-8 col-xs-12">
<div class="row">
<div class="col-md-12 col-sm-12 col-xs-12">
<div class="x_panel">
<div class="x_title">
<h2>
Visitors location <small>geo-presentation</small>
</h2>
<ul class="nav navbar-right panel_toolbox">
<li><a class="collapse-link"><i
class="fa fa-chevron-up"></i></a></li>
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
<div class="dashboard-widget-content">
<div class="col-md-4 hidden-small">
<h2 class="line_30">125.7k Views from 60 countries</h2>
<table class="countries_list">
	<tbody>
		<tr>
			<td>United States</td>
			<td class="fs15 fw700 text-right">33%</td>
		</tr>
		<tr>
			<td>France</td>
			<td class="fs15 fw700 text-right">27%</td>
		</tr>
		<tr>
			<td>Germany</td>
			<td class="fs15 fw700 text-right">16%</td>
		</tr>
		<tr>
			<td>Spain</td>
			<td class="fs15 fw700 text-right">11%</td>
		</tr>
		<tr>
			<td>Britain</td>
			<td class="fs15 fw700 text-right">10%</td>
		</tr>
	</tbody>
</table>
</div>
<div id="world-map-gdp" class="col-md-8 col-sm-12 col-xs-12"
style="height: 230px;"></div>
</div>
</div>
</div>
</div>
</div>
<div class="row">
<!-- Start to do list -->
<div class="col-md-6 col-sm-6 col-xs-12">
<div class="x_panel">
<div class="x_title">
<h2>
To Do List <small>Sample tasks</small>
</h2>
<ul class="nav navbar-right panel_toolbox">
<li><a class="collapse-link"><i
class="fa fa-chevron-up"></i></a></li>
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
<div class="">
<ul class="to_do">
<li>
	<p>
		<input type="checkbox" class="flat"> Schedule meeting
		with new client
	</p>
</li>
<li>
	<p>
		<input type="checkbox" class="flat"> Create email
		address for new intern
	</p>
</li>
<li>
	<p>
		<input type="checkbox" class="flat"> Have IT fix the
		network printer
	</p>
</li>
<li>
	<p>
		<input type="checkbox" class="flat"> Copy backups to
		offsite location
	</p>
</li>
<li>
	<p>
		<input type="checkbox" class="flat"> Food truck fixie
		locavors mcsweeney
	</p>
</li>
<li>
	<p>
		<input type="checkbox" class="flat"> Food truck fixie
		locavors mcsweeney
	</p>
</li>
<li>
	<p>
		<input type="checkbox" class="flat"> Create email
		address for new intern
	</p>
</li>
<li>
	<p>
		<input type="checkbox" class="flat"> Have IT fix the
		network printer
	</p>
</li>
<li>
	<p>
		<input type="checkbox" class="flat"> Copy backups to
		offsite location
	</p>
</li>
</ul>
</div>
</div>
</div>
</div>
<!-- End to do list -->
<!-- start of weather widget -->
<div class="col-md-6 col-sm-6 col-xs-12">
<div class="x_panel">
<div class="x_title">
<h2>
Daily active users <small>Sessions</small>
</h2>
<ul class="nav navbar-right panel_toolbox">
<li><a class="collapse-link"><i
class="fa fa-chevron-up"></i></a></li>
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
<div class="row">
<div class="col-sm-12">
<div class="temperature">
	<b>Monday</b>, 07:30 AM <span>F</span> <span><b>C</b></span>
</div>
</div>
</div>
<div class="row">
<div class="col-sm-4">
<div class="weather-icon">
	<canvas height="84" width="84" id="partly-cloudy-day"></canvas>
</div>
</div>
<div class="col-sm-8">
<div class="weather-text">
	<h2>
	Texas <br>
	<i>Partly Cloudy Day</i>
	</h2>
</div>
</div>
</div>
<div class="col-sm-12">
<div class="weather-text pull-right">
<h3 class="degrees">23</h3>
</div>
</div>
<div class="clearfix"></div>
<div class="row weather-days">
<div class="col-sm-2">
<div class="daily-weather">
	<h2 class="day">Mon</h2>
	<h3 class="degrees">25</h3>
	<canvas id="clear-day" width="32" height="32"></canvas>
	<h5>
	15 <i>km/h</i>
	</h5>
</div>
</div>
<div class="col-sm-2">
<div class="daily-weather">
	<h2 class="day">Tue</h2>
	<h3 class="degrees">25</h3>
	<canvas height="32" width="32" id="rain"></canvas>
	<h5>
	12 <i>km/h</i>
	</h5>
</div>
</div>
<div class="col-sm-2">
<div class="daily-weather">
	<h2 class="day">Wed</h2>
	<h3 class="degrees">27</h3>
	<canvas height="32" width="32" id="snow"></canvas>
	<h5>
	14 <i>km/h</i>
	</h5>
</div>
</div>
<div class="col-sm-2">
<div class="daily-weather">
	<h2 class="day">Thu</h2>
	<h3 class="degrees">28</h3>
	<canvas height="32" width="32" id="sleet"></canvas>
	<h5>
	15 <i>km/h</i>
	</h5>
</div>
</div>
<div class="col-sm-2">
<div class="daily-weather">
	<h2 class="day">Fri</h2>
	<h3 class="degrees">28</h3>
	<canvas height="32" width="32" id="wind"></canvas>
	<h5>
	11 <i>km/h</i>
	</h5>
</div>
</div>
<div class="col-sm-2">
<div class="daily-weather">
	<h2 class="day">Sat</h2>
	<h3 class="degrees">26</h3>
	<canvas height="32" width="32" id="cloudy"></canvas>
	<h5>
	10 <i>km/h</i>
	</h5>
</div>
</div>
<div class="clearfix"></div>
</div>
</div>
</div>
</div>
<!-- end of weather widget -->
</div>
</div>
</div>
</body>
<content tag="angular_script">
<script type="text/javascript">
	/* BEGIN ANGULAR JS */
angular.module('angularApp', [])
    .controller('statController',
        function($scope) {
            var data = {
                stat: {
                    totalMember: 200,
                    totalCompany: 1000,
                    totalConnect: 500,
                    totalPost: 1233,
                    totalInbox: 2122
                }
            }
            $scope.data = data;
        })

/* END ANGULAR JS */
</script>
</content>

<content tag="js_lib"> <!-- Chart.js --> 
<script src="/resources/vendors/Chart.js/dist/Chart.min.js"></script> <!-- gauge.js -->
<script src="/resources/vendors/bernii/gauge.js/dist/gauge.min.js"></script>
<!-- bootstrap-progressbar --> 
<script src="/resources/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
<!-- iCheck --> 
<script src="/resources/vendors/iCheck/icheck.min.js"></script>
<!-- Skycons --> 
<script src="/resources/vendors/skycons/skycons.js"></script>
<!-- Flot --> 
<script src="/resources/vendors/Flot/jquery.flot.js"></script>
<script src="/resources/vendors/Flot/jquery.flot.pie.js"></script> 
<script src="/resources/vendors/Flot/jquery.flot.time.js"></script> 
<script src="/resources/vendors/Flot/jquery.flot.stack.js"></script> 
<script src="/resources/vendors/Flot/jquery.flot.resize.js"></script> <!-- Flot plugins -->
<script src="/resources/hiringviet/admin/js/flot/jquery.flot.orderBars.js"></script>
<script src="/resources/hiringviet/admin/js/flot/date.js"></script> 
<script src="/resources/hiringviet/admin/js/flot/jquery.flot.spline.js"></script>
<script src="/resources/hiringviet/admin/js/flot/curvedLines.js"></script>
<!-- jVectorMap --> 
<script src="/resources/hiringviet/admin/js/maps/jquery-jvectormap-2.0.3.min.js"></script>
<!-- bootstrap-daterangepicker --> 
<script src="/resources/hiringviet/admin/js/moment/moment.min.js"></script> 
<script src="/resources/hiringviet/admin/js/datepicker/daterangepicker.js"></script>
<!-- jVectorMap --> 
<script src="/resources/hiringviet/admin/js/maps/jquery-jvectormap-world-mill-en.js"></script>
<script src="/resources/hiringviet/admin/js/maps/jquery-jvectormap-us-aea-en.js"></script>
<script src="/resources/hiringviet/admin/js/maps/gdp-data.js"></script>
<script src='/resources/hiringviet/admin/js/dashboard.js'></script>
</content>