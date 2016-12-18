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
<title>Apply</title>
</head>
<body>
	<div id="main-container">
		<div class="row">
			<div class="col m12">
				<div class="card-panel padding-10 overflow-auto">
					<h3 class="title">Prepare for Launch!</h3>
					<h5>
						<div class="ja-info">
							<span class="job-title">PHP Developer - Up to $800
								(Magento is a plus)</span> at <span class="company">Magestore</span>
						</div>
					</h5>
					<a href="javascript:void(0)" class="">Create account now to save CV</a>
					<div class="apply-form">
						<div class="form-content col m6 mp0">
							<form action="${applyFormURL}" method="post" enctype="multipart/form-data">
								<input id="jobList" name="jobList" type="hidden" value="${applyDTO.jobList }" />
								<div class="row">
									<div class="file-field input-field">
										<div class="btn">
											<span>Upload CV</span> <input type="file" id="fileCV" name="curriculumVitae">
										</div>
										<div class="file-path-wrapper">
											<!-- <input class="file-path validate" type="text"
												placeholder="Select your CV..."> -->
										</div>
									</div>
								</div>
								<p class="center">We accept .doc .docx, .pdf and .txt files
									up to 1MB</p>
								<br />
								<p>List 1-2 projects you have done or taken part in (using
									PHP or Magento) that you like the most and why?</p>
								<div class="row">
									<div class="input-field col m12 p-0">
										<textarea rows="10" cols="30" id="description" name="description"></textarea>
									</div>
								</div>
								<div class="row">
									<div class="col m12 p-0">
										<button type="submit"
											class="waves-effect waves-light btn long-btn">Send</button>
									</div>
								</div>
							</form>
						</div>
						<div class="apply-image col m4">
							<img alt=""
								src="http://www.youthaward.org/sites/youthaward.org/files/Apply%20Now_Visual.png">
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="/resources/common/js/ckeditor/ckeditor.js"></script>
	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							var config = {};
							config.placeholder = 'Details and specific examples will make your application stronger...';
							CKEDITOR.replace("description", config);
						});
	</script>
</body>
</html>