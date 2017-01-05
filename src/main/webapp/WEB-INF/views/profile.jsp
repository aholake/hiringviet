<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
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
	<input type="hidden" id="url_suggest_skill" value="<c:url value='/search/suggestSkill'/>"/>
	<input type="hidden" id="url_add_skills" value="<c:url value='/profile/addSkills'/>"/>
	<input type="hidden" id="url_delete_skill_of_resume" value="<c:url value='/profile/deleteSkillOfProfile'/>"/>
	<input type="hidden" id="url_add_endorse" value="<c:url value='/profile/endorse/add'/>"/>
	<input type="hidden" id="avatar_image_of_account" value="${memberLogin.account.avatarImage}"/>
	<input type="hidden" id="id_of_account" value="${memberLogin.account.id}"/>
	<input type="hidden" id="url_remove_endorse" value="<c:url value='/profile/endorse/remove'/>"/>
	<input type="hidden" id="url_count_member_of_follwer" value="<c:url value='/profile/countNumberOfFollower'/>"/>
	<input type="hidden" id="redirect_member_page" value="<c:url value='/profile?accountId='/>"/>
	<input type="hidden" id="url_add_connect" value="<c:url value='/profile/addConnect'/>"/>
	<input type="hidden" id="paramMemberId" value="${param.memberId}"/>
		<div class="row">
			<div class="col m8">
				<c:if test="${memberLogin.account.id == member.account.id}">
					<div class="card-panel padding-10 light-blue darken-3 hoverable display-none" id="card-panel-add-skill">
						<h1 class="title cl-white"><spring:message code="label.profile.title.addSkill"/></h1>
						<p class="cl-white small-text"><spring:message code="label.profile.title.value_statement"/></p>
						<div class="chip-inputs">
							<div class="chip-inputs-wrapper">
								<div class="list-skill-chip">
									<c:forEach items="${member.resume.skillResumeSet}" var="skillResume">
										<div class="chip current_skill chip_${skillResume.skill.displayName}">
											<input type="hidden" class="temp" id="${skillResume.skill.id}" value="${skillResume.skill.displayName}" />
											<input type="hidden" class="addingCount" value="${skillResume.skill.addingNumber}" />
										    ${skillResume.skill.displayName}
										    <i class="material-icons" onclick="javascript:deleteSkillOfResume(${member.account.id}, ${skillResume.id});">close</i>
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
						</div>
					</div>
					<!-- Begin form setting -->
					<div class="card-panel padding-10 light-blue darken-3 hoverable display-none" id="card-panel-setting-email">
						<form action="/profile/settingEmail" method="POST">
							<input type="hidden" name="memberId" value="${param.memberId}"/>
							<input type="hidden" name="accountId" value="${memberLogin.account.id}"/>
							<h1 class="title cl-white">Setting Email Address</h1>
							<p class="cl-white small-text">Please enter a valid email address</p>
							<div class="row chip-inputs">
								<div class="input-field col m12 mp0">
									<input id="newEmail" name="newEmail" type="email" class="validate" value="${memberLogin.account.email}">
								</div>
							</div>
							<div class="margin-top-5 p-0">
								<button id="btnSettingEmail" type="submit" class="waves-effect waves-light cl-black opacity-7 lime accent-2 btn"><spring:message code="label.profile.title.add_skill.save"/> </button>
								<a class="waves-effect waves-light cl-black opacity-7 grey lighten-2 btn" onclick="hideSettingEmailPanel()"><spring:message code="label.profile.title.add_skill.skill"/></a>
							</div>
						</form>
					</div>
					<div class="card-panel padding-10 light-blue darken-3 hoverable display-none" id="card-panel-setting-phone-number">
						<form action="/profile/settingPhoneNumber" method="POST">
							<input type="hidden" name="memberId" value="${param.memberId}"/>
							<input type="hidden" name="resumeId" value="${memberLogin.resume.id}"/>
							<h1 class="title cl-white">Setting Phone Numbers</h1>
							<p class="cl-white small-text">Please enter a valid phone number</p>
							<div class="row chip-inputs">
								<div class="input-field col m12 mp0">
									<input id="newPhoneNumber" name="newPhoneNumber" type="text" class="validate" value="${memberLogin.resume.phoneNumber}">
								</div>
							</div>
							<div class="margin-top-5 p-0">
								<button id="btnSettingPhoneNumber" type="submit" class="waves-effect waves-light cl-black opacity-7 lime accent-2 btn"><spring:message code="label.profile.title.add_skill.save"/> </button>
								<a class="waves-effect waves-light cl-black opacity-7 grey lighten-2 btn" onclick="hideSettingPhoneNumberPanel()"><spring:message code="label.profile.title.add_skill.skill"/></a>
							</div>
						</form>
					</div>
					<div class="card-panel padding-10 light-blue darken-3 hoverable" id="card-panel-setting-language">
						<form action="/profile/settingLanguage" method="POST">
							<input type="hidden" name="memberId" value="${param.memberId}"/>
							<input type="hidden" name="accountId" value="${memberLogin.account.id}"/>
							<h1 class="title cl-white">Setting Language</h1>
							<p class="cl-white small-text">Select a language you use on HiringViet</p>
							<div class="row chip-inputs">
								<div class="input-field col s12 mp0">
									<select name="locale">
										<c:choose>
											<c:when test="${memberLogin.account.locale == 'EN'}">
												<option value="VN">Vietnamese</option>
												<option value="EN" selected="selected">English</option>
											</c:when>
											<c:otherwise>
												<option value="VN" selected="selected">Vietnamese</option>
												<option value="EN">English</option>
											</c:otherwise>
										</c:choose>
										
									</select>
								</div>
							</div>
							<div class="margin-top-5 p-0">
								<button id="btnSettingLanguage" type="submit" class="waves-effect waves-light cl-black opacity-7 lime accent-2 btn"><spring:message code="label.profile.title.add_skill.save"/> </button>
								<a class="waves-effect waves-light cl-black opacity-7 grey lighten-2 btn" onclick="hideSettingLanguagePanel()"><spring:message code="label.profile.title.add_skill.skill"/></a>
							</div>
						</form>
					</div>
					<!-- End form setting -->
				</c:if>
				
				<!-- Begin resume -->
				<div class="card-panel padding-10 hoverable position-relative summary">
					<h1 class="title"><spring:message code="label.profile.title.summary.title"/></h1>
					<div class="panel-content content-summary">
						<c:choose>
							<c:when test="${memberLogin.account.id == member.account.id}">
								<div class="margin-top-30 position-relative summary-${member.resume.id}"
									onmouseover="showIconEdit('.summary-${member.resume.id}');"
									onmouseout="hideIconEdit('.summary-${member.resume.id}');">
									<div class="col m6 none-padding-left">
										<p class="edit">
											<i class="material-icons prefix-icon">date_range</i>
											<spring:message code="label.profile.title.summary.birth_date" />
											: <span class="info"><span class="birthDate">${member.resume.birthDate}</span></span>
											<i class="material-icons prefix-icon-r" onclick="javascript:setValueSettingSummary('#birthDate');">mode_edit</i>
										</p>
									</div>
									<div class="col m6 none-padding-left">
										<p class="edit">
											<i class="material-icons prefix-icon">contact_phone</i>
											<spring:message code="label.profile.title.summary.phone_number" />
											: <span class="info"><span class="phoneNumber">${member.resume.phoneNumber}</span></span>
											<i class="material-icons prefix-icon-r" onclick="javascript:setValueSettingSummary('#phoneNumber');">mode_edit</i>
										</p>
									</div>
									<div class="col m6 none-padding-left">
										<p class="edit">
											<i class="material-icons prefix-icon">people</i>
											<spring:message code="label.profile.title.summary.sex" />
											: <span class="info"><span class="maleGender">
												<c:choose>
													<c:when test="${member.resume.maleGender == true}">
														<spring:message code="label.profile.title.summary.sex.man"/>
													</c:when>
													<c:otherwise>
														<spring:message code="label.profile.title.summary.sex.woman"/>
													</c:otherwise>
												</c:choose>
											</span>
											</span>
											<i class="material-icons prefix-icon-r" onclick="javascript:setValueSettingSummary(null);">mode_edit</i>
										</p>
									</div>
									<div class="col m6 none-padding-left">
										<p class="edit">
											<i class="material-icons prefix-icon">flag</i>
											<spring:message code="label.profile.title.summary.nationality" />
											: <span class="info"><span class="nationality">${member.resume.nationality}</span></span>
											<i class="material-icons prefix-icon-r" onclick="javascript:setValueSettingSummary('#nationality');">mode_edit</i>
										</p>
									</div>
									<div class="div edit">
										<span class="txtSummary">${member.resume.summary}</span>
										<i class="material-icons prefix-icon-r" onclick="javascript:setValueSettingSummary('#txtSummary');">mode_edit</i>
									</div>
								</div>
							</c:when>
							<c:otherwise>
								<div class="margin-top-30 position-relative">
									<div class="col m6 none-padding-left">
										<p>
											<i class="material-icons prefix-icon">date_range</i>
											<spring:message code="label.profile.title.summary.birth_date" />
											: <span class="info"><span>${member.resume.birthDate}</span></span>
										</p>
									</div>
									<div class="col m6 none-padding-left">
										<p>
											<i class="material-icons prefix-icon">contact_phone</i>
											<spring:message code="label.profile.title.summary.phone_number" />
											: <span class="info"><span>${member.resume.phoneNumber}</span></span>
										</p>
									</div>
									<div class="col m6 none-padding-left">
										<p>
											<i class="material-icons prefix-icon">people</i>
											<spring:message code="label.profile.title.summary.sex" />
											: <span class="info"><span>
											<c:choose>
												<c:when test="${member.resume.maleGender == true}">
													<spring:message code="label.profile.title.summary.sex.man"/>
												</c:when>
												<c:otherwise>
													<spring:message code="label.profile.title.summary.sex.woman"/>
												</c:otherwise>
											</c:choose>
											</span></span>
										</p>
									</div>
									<div class="col m6 none-padding-left">
										<p>
											<i class="material-icons prefix-icon">flag</i>
											<spring:message code="label.profile.title.summary.nationality" />
											: <span class="info"><span>${member.resume.nationality}</span></span>
										</p>
									</div>
									<p>
										<span>${member.resume.summary}</span>
									</p>
								</div>
							</c:otherwise>
						</c:choose>
					</div>
					<!-- Setting Project -->
					<div class="panel-content panel-setting-summary display-none">
						<div class="row">
							<form:form id="saveSummary" action="/profile/saveSummary" method="POST" modelAttribute="resume">
								<input type="hidden" id="filterMemberId" name="filterMemberId" value="${param.memberId}"/>
								<input type="hidden" id="phoneNumberIsEmpty" value='<spring:message code="message.error.profile.summary.phoneNumber.is_empty"></spring:message>'/>
								<input type="hidden" id="notionalityIsEmpty" value='<spring:message code="message.error.profile.summary.notionality.is_empty"></spring:message>'/>
								<div class="input-field col m5 p-0">
									<form:input type="date" class="display-none" id="birthDate" path="birthDate" cssClass="datepicker"/>
									<label><spring:message code="label.profile.title.summary.birth_date"/></label>
								</div>
								<div class="input-field col m5 p-0 offset-m2">
									<form:input placeholder="Phone number" type="text" id="phoneNumber" path="phoneNumber" cssClass="validate"/>
									<label for="phoneNumber">
										<spring:message code="label.profile.title.summary.phone_number"/>
									</label>
								</div>
								<div class="input-field col m5 p-0">
									<input class="with-gap" name="maleGender" type="radio" id="r_man" value="true"/>
      								<label for="r_man">
      									<spring:message code="label.profile.title.summary.sex.man"/>
									</label>
									<span class="margin-right-30"></span>
									<input class="with-gap" name="maleGender" type="radio" id="r_woman" value="false" />
      								<label for="r_woman">
      									<spring:message code="label.profile.title.summary.sex.woman"/>
									</label>
								</div>
								<div class="input-field col m5 p-0 offset-m2">
									<form:input placeholder="Nationality"  type="text" id="nationality" path="nationality" cssClass="validate"/>
									<label for="nationality">
										<spring:message code="label.profile.title.summary.placeholder.nationality"/>
									</label>
								</div>
								<div class="input-field col m12 p-0">
									<form:input type="hidden" id="summary" path="summary"/>
									<textarea  id="txtSummary" class="materialize-textarea"></textarea>
								</div>
								<div class="col m12 p-0 margin-top-10">
									<button type="submit" id="btnSaveSummary" class="waves-effect waves-light btn margin-right-5"><spring:message code="label.profile.title.summary.save"/></button>
									<a class="waves-effect waves-light grey darken-2 btn margin-right-5" href="javascript:cancelSettingSummary();">
										<spring:message code="label.profile.title.summary.cancel"/>
									</a>
								</div>
							</form:form>
						</div>
					</div>
				</div>
				<div class="card-panel padding-10 hoverable position-relative experience-history">
					<h1 class="title"><spring:message code="label.profile.title.exp_history.title"/></h1>
					<div class="panel-content list-experience">
						<c:choose>
							<c:when test="${memberLogin.account.id == member.account.id}">
								<c:forEach items="${member.resume.employeeHistorySet}" var="employeeHistory">
									<div class="margin-top-30 position-relative edu-his-item emp-his-item-${employeeHistory.id}"
										onmouseover="showIconEdit('.emp-his-item-${employeeHistory.id}');"
										onmouseout="hideIconEdit('.emp-his-item-${employeeHistory.id}');">
										<h1 class="big-text mp0 edit">
											<span class="company-name-${employeeHistory.id}" onclick="javascript:setValueSettingEmployee('${employeeHistory.id}', '#txtCompanyName');">${employeeHistory.companyName}</span>
											<i class="material-icons prefix-icon-r" onclick="javascript:setValueSettingEmployee('${employeeHistory.id}', '#txtCompanyName');">mode_edit</i>
										</h1>
										<p class="edit">
											<span class="position-name-${employeeHistory.id}" id="${employeeHistory.position.positionID}" onclick="javascript:setValueSettingEmployee('${employeeHistory.id}', '#txtPositionName');">${employeeHistory.position.displayName}</span>
											<i class="material-icons prefix-icon-r" onclick="javascript:setValueSettingEmployee('${employeeHistory.id}', '#txtPositionName');">mode_edit</i>
										</p>
										<c:if test="${not empty employeeHistory.beginDate && not empty employeeHistory.endDate}">
											<p class="edit">
												<span class="begin-date-${employeeHistory.id}" onclick="javascript:setValueSettingEmployee('${employeeHistory.id}', null);">${employeeHistory.beginDate}</span><span>
												&nbsp;-&nbsp;</span> <span class="end-date-${employeeHistory.id}" onclick="javascript:setValueSettingEmployee('${employeeHistory.id}', null);">${employeeHistory.endDate}</span>
												<i class="material-icons prefix-icon-r" onclick="javascript:setValueSettingEmployee('${employeeHistory.id}', null);">mode_edit</i>
											</p>
										</c:if>
										<c:if test="${not empty employeeHistory.description}">
											<div class="div edit">
												<span class="description-${employeeHistory.id}" onclick="javascript:setValueSettingEmployee('${employeeHistory.id}', '#txtDescription');">${employeeHistory.description}</span>
												<i class="material-icons prefix-icon-r" onclick="javascript:setValueSettingEmployee('${employeeHistory.id}', null);">mode_edit</i>
											</div>
										</c:if>
										<c:if test="${not empty employeeHistory.projects}">
											<div class="row margin-top-10">
												<c:forEach items="${employeeHistory.projects}" var="projects">
													<div class="col m6">
														<h1 class="big-text mp0 edit">
															<i class="material-icons prefix-icon">subdirectory_arrow_right</i>
															<span class="project-name-${projects.id}">${projects.name}</span>
															<i class="material-icons prefix-icon-r" onclick="javascript:setValueSettingProject('${employeeHistory.id}', '${projects.id}')">mode_edit</i>
														</h1>
														<p>
															<span class="project-description-${projects.id}">${projects.description}</span>
														</p>
														<p>
															<i class="material-icons prefix-icon">link</i>
															<span>
																<a href="${projects.url}" class="project-url-${projects.id}">${projects.url}</a>
															</span>
														</p>
													</div>
												</c:forEach>
											</div>
										</c:if>
									</div>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<c:forEach items="${member.resume.employeeHistorySet}" var="employeeHistory">
									<div class="margin-top-30 position-relative emp-his-item">
										<h1 class="big-text mp0 edit">
											<span>${employeeHistory.companyName}</span>
										</h1>
										<p class="edit">
											<span>${employeeHistory.position.displayName}</span>
										</p>
										<c:if test="${not empty employeeHistory.beginDate && not empty employeeHistory.endDate}">
											<p class="edit">
												<span>${employeeHistory.beginDate}</span><span>&nbsp;-&nbsp;</span><span>${employeeHistory.endDate}</span>
											</p>
										</c:if>
										<c:if test="${not empty employeeHistory.description}">
											<p class="edit">
												<span>${employeeHistory.description}</span>
											</p>
										</c:if>
										<c:if test="${not empty employeeHistory.projects}">
											<div class="row margin-top-10">
												<c:forEach items="${employeeHistory.projects}" var="projects">
													<div class="col m6">
														<h1 class="big-text mp0 edit">
															<i class="material-icons prefix-icon">subdirectory_arrow_right</i><span>${projects.name}</span>
														</h1>
														<p class="edit">
															<span>${projects.description}</span>
														</p>
														<p class="edit">
															<i class="material-icons prefix-icon">link</i><span><a href="${projects.url}">${projects.url}</a></span>
														</p>
													</div>
												</c:forEach>
											</div>
										</c:if>
									</div>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</div>
					<div class="panel-content panel-setting-employee display-none">
						<div class="row">
							<form:form id="saveEmployee" action="/profile/createEmployee" method="POST" modelAttribute="employeeHistory">
								<input type="hidden" name="filterMemberId" value="${param.memberId}"/>
								<input type="hidden" id="companyNameIsEmpty" value='<spring:message code="message.error.profile.experience.companyName.is_empty"></spring:message>'/>
								<form:input type="hidden" id="employee-id" path="id"/>
								<div class="input-field col m12 p-0">
									<form:input placeholder='<spring:message code="label.register.company.input.company_name"/>' type="text" id="companyName" path="companyName" cssClass="validate"/>
									<label for="companyName">
										<spring:message code="label.profile.title.emp_history.company_name"/>
									</label>
								</div>
								<div class="input-field col m12 p-0">
									<input type="hidden" id="positionId" name="positionId"/>
									<select id="cbxPosition">
										<option value="" disabled selected>Choose your option</option>
										<c:forEach items="${positions}" var="position">
											<option value="${position.positionID}">${position.displayName}</option>
										</c:forEach>
									</select> 
									<label><spring:message code="label.profile.title.emp_history.position_name"/></label>
								</div>
								<div class="input-field col m5 p-0">
									<form:input type="date" class="display-none" id="beginDate" path="beginDate" cssClass="datepicker"/>
									<label><spring:message code="label.profile.title.emp_history.begin_date"/></label>
								</div>
								<div class="input-field col m5 p-0 offset-m2">
									<form:input type="date" class="display-none" id="endDate" path="endDate" cssClass="datepicker"/>
									<label><spring:message code="label.profile.title.emp_history.end_date"/></label>
								</div>
								<div class="input-field col m12 p-0">
									<form:input type="hidden" id="description" path="description"/>
									<textarea placeholder="<spring:message code='label.profile.title.emp_history.placeholder.description'/>" id="txtEmployeeDescription" class="materialize-textarea"></textarea>
									<label for="txtEmployeeDescription"><spring:message code="label.profile.title.emp_history.description"/></label>
								</div>
								<div class="col m12 p-0 margin-top-10">
									<button type="submit" id="btnSaveEmployee" class="waves-effect waves-light btn margin-right-5"><spring:message code="label.profile.title.emp_history.save"/></button>
									<a class="waves-effect waves-light grey darken-2 btn margin-right-5" href="javascript:cancelSettingEmployee();">
										<spring:message code="label.profile.title.emp_history.cancel"/>
									</a>
									<a href="" class="cl-white a-text-color margin-right-5">
										<spring:message code="label.profile.title.emp_history.remove"/>
									</a>
								</div>
							</form:form>
						</div>
					</div>

					<!-- Setting Project -->
					<div class="panel-content panel-setting-project display-none">
						<div class="row">
							<form:form id="saveProject" action="/profile/createProject" method="POST" modelAttribute="project">
								<input type="hidden" id="filterMemberId" name="filterMemberId" value="${param.memberId}"/>
								<input type="hidden" id="companyIsEmpty" value='<spring:message code="message.error.profile.project.company.is_empty"></spring:message>'/>
								<div class="input-field col m12 p-0">
									<select id="cbxCompany">
										<option value="" disabled selected>Choose your option</option>
										<c:forEach items="${member.resume.employeeHistorySet}" var="employeeHistory">
											<option value="${employeeHistory.id}">${employeeHistory.companyName}</option>
										</c:forEach>
									</select>
									<label><spring:message code="label.profile.title.emp_history.company_name"/></label>
								</div>
								<div class="input-field col m12 p-0">
									<form:input type="hidden" id="txtName" path="name"/>
									<input placeholder="<spring:message code='label.profile.title.emp_history.placeholder.project_name'/>" id="txtProjectName" type="text" class="validate">
									<label for="txtProjectName">
										<spring:message code="label.profile.title.emp_history.project_name"/>
									</label>
								</div>
								<div class="input-field col m12 p-0">
									<form:input type="hidden" id="url" path="url"/>
									<input placeholder="<spring:message code='label.profile.title.emp_history.placeholder.url'/>" id="txtUrl" type="text" class="validate">
									<label for="txtUrl">
										<spring:message code="label.profile.title.emp_history.url"/>
									</label>
								</div>
								<div class="input-field col m12 p-0">
									<form:input type="hidden" id="description" path="description"/>
									<textarea placeholder="<spring:message code='label.profile.title.emp_history.placeholder.description'/>" id="txtProjectDescription" class="materialize-textarea"></textarea>
									<label for="txtProjectDescription"><spring:message code="label.profile.title.emp_history.description"/></label>
								</div>
								<div class="col m12 p-0 margin-top-10">
									<button type="submit" class="waves-effect waves-light btn margin-right-5"><spring:message code="label.profile.title.emp_history.save"/></button>
									<a class="waves-effect waves-light grey darken-2 btn margin-right-5" href="javascript:cancelSettingProject();">
										<spring:message code="label.profile.title.emp_history.cancel"/>
									</a>
									<a href="" class="cl-white a-text-color margin-right-5">
										<spring:message code="label.profile.title.emp_history.remove.project"/>
									</a>
								</div>
							</form:form>
						</div>
					</div>
					<c:if test="${memberLogin.account.id == member.account.id}">
						<div class="btn-add-footer margin-top-30" onclick="javascript:showPopupAddExperience();">
							<spring:message code="label.profile.title.edu_history.add_experience" />
						</div>
					</c:if>
				</div>
				<div class="card-panel padding-10 hoverable position-relative education-history">
					<h1 class="title"><spring:message code="label.profile.title.edu_history.title"/></h1>
					<div class="panel-content list-education">
						<c:choose>
						<c:when test="${memberLogin.account.id == member.account.id}">
							<c:forEach items="${member.resume.educationHistorySet}" var="educationHistory">
								<div class="margin-top-30 position-relative edu-his-item edu-his-item-${educationHistory.id}"
									onmouseover="showIconEdit('.edu-his-item-${educationHistory.id}');"
									onmouseout="hideIconEdit('.edu-his-item-${educationHistory.id}');">
									<h1 class="big-text mp0 edit">
										<span class="university-name-${educationHistory.id}" onclick="javascript:setValueSettingEducation('${educationHistory.id}', '#txtUniversityName');">${educationHistory.universityName}</span>
										<i class="material-icons prefix-icon-r" onclick="javascript:setValueSettingEducation('${educationHistory.id}', '#txtUniversityName');">mode_edit</i>
									</h1>
									<p class="edit">
										<span class="major-name-${educationHistory.id}" onclick="javascript:setValueSettingEducation('${educationHistory.id}', '#txtMajorName');">${educationHistory.majorName}</span>
										<i class="material-icons prefix-icon-r" onclick="javascript:setValueSettingEducation('${educationHistory.id}', '#txtMajorName');">mode_edit</i>
									</p>
									<c:if test="${not empty educationHistory.beginYear && not empty educationHistory.endYear}">
									<p class="edit">
										<span class="begin-year-${educationHistory.id}" onclick="javascript:setValueSettingEducation('${educationHistory.id}', null);">${educationHistory.beginYear}</span><span>
											- </span> <span class="end-year-${educationHistory.id}" onclick="javascript:setValueSettingEducation('${educationHistory.id}', null);">${educationHistory.endYear}</span>
										<i class="material-icons prefix-icon-r" onclick="javascript:setValueSettingEducation('${educationHistory.id}', null);">mode_edit</i>
									</p>
									</c:if>
									<c:if test="${not empty educationHistory.degree}">
									<p class="edit">
										<c:forEach items="${degreeMap}" var="degree">
												<c:if test="${degree.key == educationHistory.degree}">
													<span class="degree-${educationHistory.id}" id="${degree.key}" onclick="javascript:setValueSettingEducation('${educationHistory.id}', null);">${degree.value}</span>
												</c:if>
										</c:forEach>
										<i class="material-icons prefix-icon-r">mode_edit</i>
									</p>
									</c:if>
									<c:if test="${not empty educationHistory.socialActivity}">
									<div class="div edit">
										<span><spring:message code="label.profile.title.edu_history.social_activity" />:&nbsp;</span> 
										<span class="social-activity-${educationHistory.id}" onclick="javascript:setValueSettingEducation('${educationHistory.id}', '#txtSocialActivity');"> ${educationHistory.socialActivity}</span>
										<i class="material-icons prefix-icon-r" onclick="javascript:setValueSettingEducation('${educationHistory.id}', '#txtSocialActivity');">mode_edit</i>
									</div>
									</c:if>
								</div>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<c:forEach items="${member.resume.educationHistorySet}" var="educationHistory">
								<div class="margin-top-30 position-relative edu-his-item">
									<h1 class="big-text mp0 edit">
										<span>${educationHistory.universityName}</span>
									</h1>
									<p class="edit">
										<span>${educationHistory.majorName}</span>
									</p>
									<c:if test="${not empty educationHistory.beginYear && not empty educationHistory.endYear}">
									<p class="edit">
										<span>${educationHistory.beginYear}</span><span>&nbsp;-&nbsp;</span> <span>${educationHistory.endYear}</span>
									</p>
									</c:if>
									<c:if test="${not empty educationHistory.degree}">
									<p class="edit">
										<c:forEach items="${degreeMap}" var="degree">
												<c:if test="${degree.key == educationHistory.degree}">
													<span>${degree.value}</span>
												</c:if>
										</c:forEach>
									</p>
									</c:if>
									<c:if test="${not empty educationHistory.socialActivity}">
									<p class="edit">
										<span><spring:message code="label.profile.title.edu_history.social_activity" />:&nbsp;</span> 
										<span> ${educationHistory.socialActivity}</span>
									</p>
									</c:if>
								</div>
							</c:forEach>
						</c:otherwise>
						</c:choose>
							<c:if test="${memberLogin.account.id == member.account.id}">
								<hr class="margin-top-10" />
								<p class="opacity-7 margin-top-10">Add media</p>
								<ul class="education-media display-inline-flex margin-top-5">
									<li onclick="javascript:addEducationDocument();"><i class="material-icons">description</i>
										<span><spring:message code="label.profile.title.edu_history.document" /></span></li>
									<li><i class="material-icons">photo_camera</i>
										<span><spring:message code="label.profile.title.edu_history.photo" /></span></li>
									<li><i class="material-icons">link</i>
										<span><spring:message code="label.profile.title.edu_history.link" /></span></li>
								</ul>
								<!-- add document -->
								<div class="add-media-education display-none overflow-auto">
									<div class="input-field col m12 p-0">
										<select>
											<option value="" disabled selected>Choose your option</option>
											<c:forEach items="${member.resume.educationHistorySet}" var="educationHistory">
												<option value="${educationHistory.id}">${educationHistory.universityName}</option>
											</c:forEach>
										</select> 
										<label><spring:message code="label.profile.title.edu_history.add_to_education"/></label>
									</div>
									<div class="input-field col m12 p-0">
										<form action="#">
											<div class="file-field input-field">
												<div class="btn grey">
													<span class="cl-white">File</span> <input type="file">
												</div>
												<div class="file-path-wrapper">
													<input class="file-path validate" type="text">
												</div>
											</div>
										</form>
									</div>
									<div class="col m12 p-0 margin-top-10">
										<a class="waves-effect waves-light btn margin-right-5"><spring:message code="label.profile.title.edu_history.upload"/></a>
										<a class="waves-effect waves-light grey darken-2 btn margin-right-5" href="javascript:cancelEducationDocument();"><spring:message code="label.profile.title.edu_history.cancel"/></a>
									</div>
								</div>
							</c:if>
						<c:if test="${memberLogin.account.id == member.account.id}">
							<div class="btn-add-footer margin-top-30" onclick="javascript:showPopupAddEducation();">
								<spring:message code="label.profile.title.edu_history.add_education" />
							</div>
						</c:if>
					</div>
					<div class="panel-content panel-setting-education display-none">
						<div class="row">
							<form:form id="saveEducation" action="/profile/createEducation" method="POST" modelAttribute="educationHistory">
								<input type="hidden" id="filterMemberId" name="filterMemberId" value="${param.memberId}"/>
								<input type="hidden" id="universityNameIsEmpty" value='<spring:message code="message.error.profile.education.universityName.is_empty"></spring:message>'/>
								<form:input type="hidden" id="education-id" path="id"/>
								<div class="input-field col m12 p-0">
									<form:input type="hidden" id="universityName" path="universityName"/>
								<input oninvalid="this.setCustomValidity('<spring:message code='label.profile.error.edu_history.university_name.required'/>')"
									required oninput="setCustomValidity('')"
									placeholder="<spring:message code='label.profile.title.edu_history.placeholder.university_name'/>"
									id="txtUniversityName" type="text" class="validate"> <label for="txtUniversityName"><spring:message code="label.profile.title.edu_history.university_name"/></label>
								</div>
								<div class="input-field col m12 p-0">
									<form:input type="hidden" id="majorName" path="majorName"/>
								<input oninvalid="this.setCustomValidity('<spring:message code='label.profile.error.edu_history.major.required'/>')"
									required oninput="setCustomValidity('')"
									placeholder="<spring:message code='label.profile.title.edu_history.placeholder.major'/>"
									id="txtMajorName" type="text" class="validate"> <label for="txtMajorName"><spring:message code="label.profile.title.edu_history.major"/></label>
								</div>
								<div class="input-field col m5 p-0">
									<form:input type="hidden" id="beginYear" path="beginYear"/>
									<select id="cbxBeginYear">
										<option value="" disabled selected>Choose your option</option>
										<c:forEach items="${years}" var="year">
											<option value="${year}">${year}</option>
										</c:forEach>
									</select> 
									<label><spring:message code="label.profile.title.edu_history.begin_year"/></label>
								</div>
								<div class="input-field col m5 p-0 offset-m2">
									<form:input type="hidden" id="endYear" path="endYear"/>
									<select id="cbxEndYear">
										<option value="" disabled selected>Choose your option</option>
										<c:forEach items="${years}" var="year">
											<option value="${year}">${year}</option>
										</c:forEach>
									</select> 
									<label><spring:message code="label.profile.title.edu_history.end_year"/></label>
								</div>
								<div class="input-field col m12 p-0">
									<form:input type="hidden" id="degree" path="degree"/>
									<select id="cbxDegree">
										<option value="" disabled selected>Choose your option</option>
										<c:forEach items="${degreeMap}" var="degree">
											<option value="${degree.key}">${degree.value}</option>
										</c:forEach>
									</select> 
									<label><spring:message code="label.profile.title.edu_history.degree"/></label>
								</div>
								<div class="input-field col m12 p-0">
									<form:input type="hidden" id="socialActivity" path="socialActivity"/>
									<textarea placeholder="<spring:message code='label.profile.title.edu_history.placeholder.social_activity'/>" id="txtSocialActivity" class="materialize-textarea"></textarea>
									<label for="txtSocialActivity"><spring:message code="label.profile.title.edu_history.social_activity"/></label>
								</div>
								<div class="col m12 p-0 margin-top-10">
									<button type="submit" id="btnSaveEducation" class="waves-effect waves-light btn margin-right-5"><spring:message code="label.profile.title.edu_history.save"/></button>
									<a class="waves-effect waves-light grey darken-2 btn margin-right-5" href="javascript:cancelSettingEducation();"><spring:message code="label.profile.title.edu_history.cancel"/></a>
									<a href="" class="cl-white a-text-color margin-right-5"><spring:message code="label.profile.title.edu_history.remove"/></a>
								</div>
							</form:form>
						</div>
					</div>
				</div>
				<!-- End resume -->
				<div class="card-panel padding-10 hoverable">
					<h1 class="title"><spring:message code="label.profile.endorse.title.skills"/></h1>
					<p class="small-text"><spring:message code="label.profile.endorse.title.top_skills"/></p>
					<div class="profile-skills">
		    		<ul class="skills-section">
		    			<c:forEach items="${member.resume.skillResumeSet}" var="skillResume">
		    				<c:if test="${skillResume.skill.type == 1 && fn:length(skillResume.endorseSet) > 0}">
				    			<li class="endorse-item">
				    				<span class="skill-pill">
				    					<a href="javascript:void(0)" class="endorse-count">
				    						<span class="num-endorsements num-endorsements-${skillResume.skill.id} cl-white">${fn:length(skillResume.endorseSet)}</span>
				    					</a>
				    					<span class="endorse-item-name">
				    						<a href="" class="endorse-item-name-text">${skillResume.skill.displayName}</a>
				    					</span>
				    				</span>
				    				<div class="endorsers-container">
				    					<a class="endorse-button">
				    						<c:if test="${not empty memberLogin.account && memberLogin.account.id != member.account.id && checkConnect == true}">
					    						<span class="endorsing">
					    							<i class="material-icons small-icon margin-top-3px icon_add_endorse_${skillResume.skill.id}"
														onmouseover="onMouseOverEndorsingEvent('add_endorse_title_${skillResume.skill.id}', '${skillResume.skill.id}');"
														onmouseout="onMouseOutEndorsingEvent('add_endorse_title_${skillResume.skill.id}', '${skillResume.skill.id}');"
														onclick="onClickEndorsingEvent(true, '${skillResume.skill.id}', '${skillResume.id}');">add</i>
													<i style="display: none;"
														class="material-icons small-icon margin-top-3px icon_remove_endorse_${skillResume.skill.id}"
														onmouseover="onMouseOverEndorsingEvent('remove_endorse_title_${skillResume.skill.id}', '${skillResume.skill.id}');"
														onmouseout="onMouseOutEndorsingEvent('remove_endorse_title_${skillResume.skill.id}', '${skillResume.id}');"
														onclick="onClickEndorsingEvent(false, '${skillResume.skill.id}', '${skillResume.id}');">remove</i>
													<span id="add_endorse_title_${skillResume.skill.id}" class="display-none">Endorse</span>
					    							<span id="remove_endorse_title_${skillResume.skill.id}" class="display-none">Remove Endorse</span>
					    						</span>
				    						</c:if>
				    						<span class="line-container">
				    							<hr />
				    						</span>
				    					</a>
				    					<ul class="endorsers-pics endorsers-pics-${skillResume.skill.id}">
				    						<c:forEach items="${skillResume.endorseSet}" var="endorse" varStatus="theCount">
				    							<input type="hidden" class="skill_resume_${skillResume.skill.id}" value="${skillResume.skill.id}"/>
					    						<c:choose>
					    							<c:when test="${not empty memberLogin.account && memberLogin.account.id == endorse.account.id && checkConnect == true}">
														<li class="special endorse_${endorse.id} endorse_account_${endorse.account.id}_${skillResume.skill.id}"
															onmouseenter="javascript:showMemberTooltip(this, ${endorse.account.id});"
															onmouseout="javascript:hideMemberToolTip()">
														<a href="/profile?memberId=${endorse.account.id}">
															<input type="hidden" class="avatar_image" value="${endorse.account.avatarImage}"/>
															<img class="img-full" src="${endorse.account.avatarImage}">
														</a>
														</li>
														<script type="text/javascript">
						    								var skillResumeId = $('.skill_resume_' + ${skillResume.skill.id}).val();
						    								$('.icon_add_endorse_' + skillResumeId).hide();
						    								$('.icon_remove_endorse_' + skillResumeId).show();
						    								var first = $('ul.endorsers-pics-' + skillResumeId + ' li').first().html();    
						    							    var special = $('ul.endorsers-pics-' + skillResumeId + ' li.special').html(); 
						    							    $('ul.endorsers-pics-' + skillResumeId + ' li').first().html(special);
						    							    $('ul.endorsers-pics-' + skillResumeId + ' li.special').html(first);
						    							</script>
					    							</c:when>
					    							<c:otherwise>
					    								<c:if test="${theCount.count <= 9}">
						    								<li class="endorse_${endorse.id}" 
						    									onmouseenter="javascript:showMemberTooltip(this, ${endorse.account.id});"
						    									onmouseout="javascript:hideMemberToolTip()">
								    							<a href="#">
								    								<input type="hidden" class="avatar_image" value="${endorse.account.avatarImage}"/>
								    								<img class="img-full" src="${endorse.account.avatarImage}">
								    							</a>
							    							</li>
						    							</c:if>
					    							</c:otherwise>
					    						</c:choose>
				    						</c:forEach>
				    						<li class="endorsers-action">
				    							<a class="endorseModal"><i class="material-icons padding-top-4">keyboard_arrow_right</i></a>
				    						</li>
				    					</ul>
				    				</div>
				    			</li>
			    			</c:if>
		    			</c:forEach>
		    		</ul>
		    		<!-- Skill different -->
		    		<p class="small-text margin-top-30"><spring:message code="label.profile.endorse.title.diffrent_skills"/></p>
		    		<ul class="skill-selection-different">
		    			<c:forEach items="${member.resume.skillResumeSet}" var="skillResume">
		    				<c:if test="${skillResume.skill.type == 0 || fn:length(skillResume.endorseSet) == 0}">
					    		<li>
					    			<span class="skill-pill">
				    					<a href="javascript:void(0)" class="endorse-count">
				    						<span class="num-endorsements num-endorsements-${skillResume.skill.id} cl-white">${fn:length(skillResume.endorseSet)}</span>
				    					</a>
				    					<span class="endorse-item-name">
				    						<a href="" class="endorse-item-name-text">${skillResume.skill.displayName}</a>
				    					</span>
				    					<c:if test="${not empty memberLogin.account && memberLogin.account.id != member.account.id}">
			    							<input type="hidden" class="skill_resume_${skillResume.skill.id}" value="${skillResume.skill.id}"/>
							    			<a class="icon-endorse">
							    				<i class="material-icons small-icon icon_add_endorse_${skillResume.skill.id}"
												onclick="onClickEndorsingDifferentEvent(true, '${skillResume.skill.id}', '${skillResume.id}');">add</i>
											</a>
							    			<a class="icon-endorse">
							    				<i style="display: none;" class="material-icons small-icon icon_remove_endorse_${skillResume.skill.id}"
												onclick="onClickEndorsingDifferentEvent(false, '${skillResume.skill.id}', '${skillResume.id}');">remove</i>
											</a>
				    						<c:forEach items="${skillResume.endorseSet}" var="endorse" varStatus="theCount">
					    						<c:if test="${memberLogin.account.id == endorse.account.id}">
					    							<script type="text/javascript">
						    							var skillResumeId = $('.skill_resume_' + ${skillResume.skill.id}).val();
						    							
						    							$('.icon_add_endorse_' + skillResumeId).hide();
						    							$('.icon_remove_endorse_' + skillResumeId).show();
						    						</script>
						    					</c:if>
					    					</c:forEach>
				    					</c:if>
				    				</span>
					    		</li>
				    		</c:if>
			    		</c:forEach>
			    	</ul>
		    		</div>
				</div>
				<div class="card-panel padding-10 hoverable">
					<h1 class="title">Following</h1>
					<p class="small-text">Companies</p>
				</div>
			</div>
			<div class="col m4">
				<c:if test="${memberLogin.account.id == member.account.id}">
					<div class="row">
						<div class="col m12 mp0">
							<ul class="collapsible" data-collapsible="accordion">
								<li>
									<div class="collapsible-header">
										<i class="material-icons">filter_drama</i>Customize Your Public Profile
									</div>
									<div class="collapsible-body bg-white">
										<div class="row">
											<div class="col m12">
												<p class="small-text">Public Profile</p>
												<div class="switch margin-left-1em">
													<label> Off <input type="checkbox" checked="checked" /> <span class="lever"></span> On </label>
												</div>
												<p class="small-text margin-top-10">Customize Your Public Profile</p>
												<div class="margin-left-1em">
													<input class="with-gap" name="isPublicProfile" type="radio" id="r_isPublicProfile" value="true"/>
													<label for="r_isPublicProfile">Make my public profile visible to no one</label>
												</div>
												<div class="margin-left-1em">
													<input class="with-gap" name="isPublicProfile" type="radio" id="r_notPublicProfile" value="false" checked="checked"/>
													<label for="r_notPublicProfile">Make my public profile visible to everyone</label>
												</div>
												<div class="row">
													<div class="col m12 margin-left-1em">
														<ul class="make-public margin-left-23">
															<li>
																<input type="checkbox" class="filled-in" name="chkHeadline" id="chk-headline" checked="checked" />
																<label for="chk-headline">Headline</label>
															</li>
															<li>
																<input type="checkbox" class="filled-in" name="chkEducation" id="chk-eduation" checked="checked"/>
																<label for="chk-eduation">Education</label>
																<ul class="margin-left-35">
																	<li>
																		<input type="checkbox" class="filled-in" name="chkEducationDetails" id="chk-edu-details" checked="checked"/>
																		<label for="chk-edu-details">Details</label>
																	</li>
																</ul>
															</li>
															<li>
																<input type="checkbox" class="filled-in" name="chkCurrentPosition" id="chk-current-position" checked="checked"/>
																<label for="chk-current-position">Current Positions</label>
																<ul class="margin-left-35">
																	<li>
																		<input type="checkbox" class="filled-in" name="chkCurrentPositionDetails" id="chk-current-position-details" checked="checked"/>
																		<label for="chk-current-position-details">Details</label>
																	</li>
																</ul>
															</li>
														</ul>
														<button type="button" class="waves-effect waves-light btn right margin-right-10">Save</button>
													</div>
												</div>
											</div>
										</div>
									</div>
								</li>
								<li>
									<div class="collapsible-header">
										<i class="material-icons"><i class="material-icons">insert_drive_file</i></i>View file as
									</div>
									<div class="collapsible-body">
										<div class="collection">
											<a href="#" class="collection-item"><i class="material-icons prefix-icon">file_download</i>Save to PDF</a>
											<a href="#" class="collection-item"><i class="material-icons prefix-icon">file_download</i>Save to Docx</a>
											<a href="#" class="collection-item"><i class="material-icons prefix-icon">file_upload</i>Import resume</a>
										</div>
									</div>
								</li>
								<li>
									<div class="collapsible-header">
										<i class="material-icons">settings</i>Account settings
									</div>
									<div class="collapsible-body bg-white">
										<div class="collection">
											<a class="collection-item" onclick="showSettingEmailPanel()">
												<b>Email address</b><br/>
												<i class="small-text">Add or remove email addresses on your account</i>
											</a>
											<a class="collection-item" onclick="showSettingPhoneNumberPanel()">
												<b>Phone numbers</b><br/>
												<i class="small-text">Add a phone number in case you have trouble signing in</i>
											</a>
											<a class="collection-item" onclick="showSettingLanguagePanel()">
												<b>Language</b><br/>
												<i class="small-text">Select the language you use on HiringViet</i>
											</a>
											<a href="#" class="collection-item">
												<b>Showing profile photos</b><br/>
												<i class="small-text">Choose whether to show or hide profile photos of other members</i>
											</a>
										</div>
									</div>
								</li>
							</ul>
						</div>
					</div>
				</c:if>
				<div class="card-panel">
					<div class="panel-title">Profile Management</div>
					<div class="panel-content">
						<div class="row">
							<div class="col m12">
								
							</div>
						</div>
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
			<a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat">Close</a>
		</div>
	</div>
	<div class="tooltil-show-member">
    	<div class="row">
    		<div class="col m4 mp0">
    			<a href="#">
		    		<img src="">
		    	</a>
    		</div>
    		<div class="col m8" style="text-align: left;">
    			<a href="" class="endorse-item-name-text"></a>
    			<p class="mp0 small-text"><span class="number-followers"></span> follower</p>
    		</div>
    		<div class="col m12 margin-top-5">
	    		<a href="" class="btn-connect waves-effect waves-light btn margin-right-5"><spring:message code="label.profile.tooltip.title.connect"/></a>
	    		<a class="btn-profile waves-effect waves-light btn grey"><spring:message code="label.profile.tooltip.title.profile"/></a>
    		</div>
    		<div class="triangle">
    		</div>
    	</div>
    </div>

	<div id="dialog-connect" title="Notification">
		<p>
			<span class="ui-icon ui-icon-alert" style="float: left; margin: 12px 12px 20px 0;"></span>
			Are you sure?
		</p>
	</div>
	
	<!-- Modal Structure -->
	<div id="endorseModal" class="modal modal-fixed-footer">
		<div class="modal-content">
			<h4>Endorse List</h4>
			<div class="row">
				<div class="col m12 mp0" id="list-member-endorse">
				</div>
			</div>
		</div>
		<div class="modal-footer">
			<a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat ">Close</a>
		</div>
	</div>
	
	<script src="<c:url value='/resources/hiringviet/profile/js/profile.js'/>"></script>
	<script src="<c:url value='/resources/hiringviet/profile/js/endorse.js'/>"></script>
	<script type="text/javascript" src="/resources/common/js/ckeditor/ckeditor.js"></script>
	<script type="text/javascript">
		$(function() {
			/*$('.endorseModal').leanModal({
				ready: function(modal, trigger) {

				}
			});*/
		});

		function showSettingEmailPanel() {
			
			$('#card-panel-setting-email').show();
		}
		
		function hideSettingEmailPanel() {

			$('#card-panel-setting-email').hide();
		}

		function showSettingPhoneNumberPanel() {

			$('#card-panel-setting-phone-number').show();
		}
	
		function hideSettingPhoneNumberPanel() {

			$('#card-panel-setting-phone-number').hide();
		}

		function showSettingLanguagePanel() {
			
			$('#card-panel-setting-language').show();
		}

		function hideSettingLanguagePanel() {
			
			$('#card-panel-setting-language').hide();
		}

		$('.datepicker').pickadate({
		    selectMonths: true, // Creates a dropdown to control month
		    selectYears: 15, // Creates a dropdown of 15 years to control year
		    format: 'dd/mm/yyyy',
		    formatSubmit: 'dd/mm/yyyy'
		});
		CKEDITOR.replace("txtProjectDescription");
		CKEDITOR.replace("txtEmployeeDescription");
		CKEDITOR.replace("txtSocialActivity");
		CKEDITOR.replace("txtSummary");
		
		$('.collapsible').collapsible();
		
	</script>
</body>
</html>