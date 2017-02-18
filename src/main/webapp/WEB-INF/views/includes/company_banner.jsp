<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
.wrap-avatar-img {
	position: absolute;
    bottom: 5px;
    left: 5px;
}

.new-avatar-img {
	width: 200px !important;
	height: 200px !important;
}

.wrap-new-avatar-img {
	border-radius: 5px;
	background: #fff;
	border: 1px solid #d3d3d3;
	padding: 5px;
}
</style>
</head>
<body>
	<div class="company-banner">
		<img class="company-cover responsive-img img-full" src="/resources/images/company_background.jpg" alt="company cover" />
		<div class="social-connect-box" style="text-align: right;">
			<!-- <span class="social-company-name">
				<c:if test="${company != null}">
					${company.displayName}
				</c:if>
				<c:if test="${job != null}">
					${job.company.displayName}
				</c:if>
			</span>  -->
			<a href="#">
				<img src="/resources/images/facebook.png" />
			</a> 
			<a href="#">
				<img src="/resources/images/linkedin.png" />
			</a> 
			<a href="#">
				<img src="/resources/images/twitter.png" />
			</a>
		</div>
		<div class="company-logo">
			<div class="position-relative" style="width: 140px; height: 140px;">
				<img class="responsive-img img-full" src="${company.account.avatarImage}" alt="company logo" />
				<c:if test="${showUpdate == 1 || (companyLogin != null && param.companyId == companyLogin.id)}">
					<a class="wrap-avatar-img" href="#avatar-image-modal">
						<i class="avatar-img material-icons small-font cursor" 
						onmouseover="bigImg(this)" 
						onmouseout="smallImg(this)">photo_camera</i>
					</a>
				</c:if>
			</div>
		</div>
	</div>
	<!-- Modal Structure -->
	<div id="avatar-image-modal" class="modal modal-fixed-footer">
		<form action="${fileUpload}" method="post" enctype="multipart/form-data">
			<input type="hidden" name="mode" value="${mode}"/>
			<div class="modal-content">
				<h4>Update Avatar Image</h4>
				<div class="row">
					<div class="col m8 mp0">
						<p>Upload a picture from your computer</p>
						<div class="file-field input-field">
							<div class="file-field input-field">
								<input type="hidden" name="mode" value="AI"/>
								<div class="btn">
									<span>File</span> <input id="new-avatar-image" type="file" name="multipartFile" />
								</div>
								<div class="file-path-wrapper">
									<input class="file-path validate" type="text" placeholder="Upload one or more files" />
								</div>
							</div>
						</div>
						<p class="color-red">Chọn file có dung lượng nhỏ hơn 10MB!</p>
					</div>
					<div class="col m4">
						<div class="wrap-new-avatar-img text-align-center" ondrop="drop(event)" ondragover="allowDrop(event)">
							<img id="current-avatar-image" class="responsive-img new-avatar-img" src="${company.account.avatarImage}" alt="profile logo" />
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" onclick="javascript:void(0);" class="modal-action modal-close waves-effect waves-green btn-flat">Close</button>
				<button type="submit" class=" modal-action modal-close waves-effect waves-green btn-flat">Submit</button>
			</div>
		</form>
	</div>
	<script type="text/javascript">
		function bigImg() {
			$('.avatar-img').removeClass('small-font');
			$('.avatar-img').addClass('big-font');
		}
		
		function smallImg() {
			$('.avatar-img').removeClass('big-font');
			$('.avatar-img').addClass('small-font');
		}
		
		$(function() {
			$('.wrap-avatar-img').leanModal();
		})
	</script>
	<script src="<c:url value='/resources/common/js/file.js'/>"></script>
</body>
</html>