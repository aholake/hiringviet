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
<title><spring:message code="label.profile.title"/></title>
<!-- Local style -->
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/hiringviet/home/css/home.css'/>">
<!-- CSS media query on a link element -->
<link rel="stylesheet" href="/resources/hiringviet/home/css/smart-home.css" />
<link rel="stylesheet" href="/resources/hiringviet/profile/css/profile.css" />
</head>
<body>
	<jsp:include page="/layouts/navbar"></jsp:include>

	<jsp:include page="/layouts/profileBanner"></jsp:include>

	<div id="main-container">

	<jsp:include page="/layouts/profileHeader"></jsp:include>

	<input type="hidden" id="url_suggest_skill" value="<c:url value='/search/suggestSkill'/>"/>
	<input type="hidden" id="url_add_skills" value="<c:url value='/profile/addSkills'/>"/>
	<input type="hidden" id="url_delete_skill_of_resume" value="<c:url value='/profile/deleteSkillOfProfile'/>"/>

		<div class="row">
			<div class="col m8">
				<div class="card-panel padding-10 light-blue darken-3 hoverable">
					<h1 class="title cl-white"><spring:message code="label.profile.title.addSkill"/></h1>
					<p class="cl-white small-text"><spring:message code="label.profile.title.value_statement"/></p>
					<div class="chip-inputs">
						<div class="chip-inputs-wrapper">
							<div class="list-skill-chip">
								<c:forEach items="${member.resume.skillResumeSet}" var="skillResume">
									<div class="chip current_skill chip_${skillResume.skill.displayName}">
										<input type="hidden" class="temp" id="${skillResume.skill.id}" value="${skillResume.skill.displayName}" />
									    ${skillResume.skill.displayName}
									    <i class="material-icons" onclick="javascript:deleteSkillOfResume(${member.account.id}, ${member.resume.id}, ${skillResume.skill.id});">close</i>
									</div>
								</c:forEach>
								<div class="chip add-chip">
								    <input type="text" class="margin-0" id="addNewSkill" placeHolder="<spring:message  code='label.profile.title.add_skill' />"/>
								    <div class="suggestSearch">
								    	<ul></ul>
								    </div>
								</div>
							</div>
						</div>
					</div>
					<div class="margin-top-5 p-0">
						<a id="btn_save_skill_list" class="waves-effect waves-light cl-black opacity-7 lime accent-2 btn"><spring:message code="label.profile.title.add_skill.save"/> </a>
						<a class="waves-effect waves-light cl-black opacity-7 grey lighten-2 btn"><spring:message code="label.profile.title.add_skill.skill"/></a>
						<a href="" class="cl-white a-text-color"><spring:message code="label.profile.title.add_skill.done_add"/></a>
					</div>
				</div>
				<div class="card-panel padding-10 hoverable">
					<h1 class="title"><spring:message code="label.profile.endorse.title.skills"/></h1>
					<p class="small-text"><spring:message code="label.profile.endorse.title.top_skills"/></p>
					<div class="profile-skills">
		    		<ul class="skills-section">
		    			<c:forEach items="${member.resume.skillResumeSet}" var="skillResume">
			    			<li class="endorse-item">
			    				<span class="skill-pill">
			    					<a href="javascript:void(0)" class="endorse-count">
			    						<span class="num-endorsements num-endorsements-${skillResume.skill.id} cl-white">${skillResume.numberEndorse}</span>
			    					</a>
			    					<span class="endorse-item-name">
			    						<a href="" class="endorse-item-name-text">${skillResume.skill.displayName}</a>
			    					</span>
			    				</span>
			    				<div class="endorsers-container">
			    					<a class="endorse-button">
			    						<span class="endorsing"> 
			    							<i class="material-icons small-icon margin-top-3px icon_add_endorse_${skillResume.skill.id}"
												onmouseover="onMouseOverEndorsingEvent('add_endorse_title_${skillResume.skill.id}', '${skillResume.skill.id}');"
												onmouseout="onMouseOutEndorsingEvent('add_endorse_title_${skillResume.skill.id}', '${skillResume.skill.id}');"
												onclick="onClickEndorsingEvent(true, '${skillResume.skill.id}');">add</i>
											<i style="display: none;"
												class="material-icons small-icon margin-top-3px icon_remove_endorse_${skillResume.skill.id} display-none"
												onmouseover="onMouseOverEndorsingEvent('remove_endorse_title_${skillResume.skill.id}', '${skillResume.skill.id}');"
												onmouseout="onMouseOutEndorsingEvent('remove_endorse_title_${skillResume.skill.id}', '${skillResume.skill.id}');"
												onclick="onClickEndorsingEvent(false, '${skillResume.skill.id}');">remove</i>
											<span id="add_endorse_title_${skillResume.skill.id}" class="display-none">Endorse</span>
			    							<span id="remove_endorse_title_${skillResume.skill.id}" class="display-none">Remove Endorse</span>
			    						</span>
			    						<span class="line-container">
			    							<hr />
			    						</span>
			    					</a>
			    					<ul class="endorsers-pics endorsers-pics-${skillResume.skill.id}">
			    						<c:forEach items="${skillResume.endorseSet}" var="endorse" varStatus="item">
			    							<li class="endorse_${endorse.id}">
				    							<a href="#">
				    								<img class="img-full" src="${endorse.account.avatarImage}">
				    							</a>
			    							</li>
			    						</c:forEach>
			    						<li class="endorsers-action">
			    							<i class="material-icons">keyboard_arrow_right</i>
			    						</li>
			    					</ul>
			    				</div>
			    			</li>
		    			</c:forEach>
		    		</ul>
		    		<!-- Skill different -->
		    	</div>
				</div>
			</div>
			<div class="col m4">
				<div class="card-panel">
				</div>
			</div>
		</div>
	</div>
	<!-- Modal Structure -->
	<div id="modal1" class="modal bottom-sheet">
		<div class="modal-content">
			<h4>Modal Header</h4>
			<p>A bunch of text</p>
		</div>
		<div class="modal-footer">
			<a href="#!"
				class=" modal-action modal-close waves-effect waves-green btn-flat">Agree</a>
		</div>
	</div>
	<script src="<c:url value='/resources/hiringviet/profile/js/profile.js'/>"></script>
	<script src="<c:url value='/resources/hiringviet/profile/js/endorse.js'/>"></script>
</body>
</html>