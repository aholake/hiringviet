<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/taglibs.jsp" %>

<!DOCTYPE html>
<html>
  <head>
    <!-- Meta, title, CSS, favicons, etc. -->
    <title>Gentallela Alela! | </title>

    <!-- Bootstrap -->
    <link href="/resources/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="/resources/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    
    <!-- Custom styling plus plugins -->
    <link href="/resources/hiringviet/admin/css/custom.min.css" rel="stylesheet">
    <decorator:head/>
  </head>

  <body class="nav-md">
    <div class="container body">
      <div class="main_container">
        
        <!-- side menu -->
		<%@ include file="/WEB-INF/views/includes/admin-sidemenu.jsp" %>
        <!-- /side menu -->

        <!-- top navigation -->
        <%@ include file="/WEB-INF/views/includes/admin-top-nav.jsp" %>
        <!-- /top navigation -->

        <!-- page content -->
        <div class="right_col" role="main">
            <!--
            ............................
            ............................
            ............................
            ............................
            PUT THE MAIN CONTENT HERE-->
            <decorator:body />
        </div>
        <!-- /page content -->

        <!-- footer content -->
        <footer>
          <div class="pull-right">
            Gentelella - Bootstrap Admin Template by <a href="https://colorlib.com">Colorlib</a>
          </div>
          <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->
      </div>
    </div>

    <!-- jQuery -->
    <script src="/resources/vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="/resources/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="/resources/vendors/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="/resources/vendors/nprogress/nprogress.js"></script>

    <!-- Custom Theme Scripts -->
    <script src="/resources/hiringviet/admin/js/custom.min.js"></script>
    <decorator:getProperty property="page.js_lib"></decorator:getProperty>
  </body>
</html>