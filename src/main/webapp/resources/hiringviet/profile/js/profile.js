var FLAG_SUGGEST_SKILL = true;
var listSkill = new Array();
var listSkillNew = new Array();
var skillId = null;
var skillName = null;
var addingNumber = 0;
$(function() {

	$('.endorsers-action').on('click', '.endorseModal', function() {
		$('#list-member-endorse').html('');
		var parent = $(this).parents('.endorsers-pics');

		var html = "";
		$(parent).find('.avatar_image').each(function() {
			html += '<a href="/profile?memberId=' + $(this).parent().find('.member_id').val() + '"><img width="50px" height="50px" class="margin-right-5" alt="" src="' + $(this).val() + '" /></a>';
		});
		$('#list-member-endorse').append(html);
		$('#endorseModal').openModal();
	});

	$("#dialog-connect").dialog({
		autoOpen: false,
		resizable : false,
		height : "auto",
		width : 400,
		modal : true,
		buttons : {
			"Connect" : function() {
				callAPI($('#url_add_connect').val(), 'POST', $('#paramMemberId').val(), "processAddConnect", true);
			},
			Cancel : function() {
				$(this).dialog("close");
			}
		}
	});

	/* set current skill to list */
	$(".list-skill-chip .current_skill").each(function() {
		skillId = $(this).children('.temp').attr('id');
		skillName = $(this).children('.temp').attr('value');
		addingNumber = $(this).children('.addingCount').attr('value');
		listSkill.push({id: skillId, displayName: skillName, addingNumber: addingNumber});
	});

	/* Add event to Enter key after input new skill.*/
	$('#addNewSkill').keyup(function(event) {

		$('.chip').removeClass('border-error');

		if ($('#addNewSkill').val().length > 0) {
			FLAG_SUGGEST_SKILL = true;
			
		}

		if (FLAG_SUGGEST_SKILL && $('#addNewSkill').val().length > 0) {
			callAPI($('#url_suggest_skill').val(), 'POST', $('#addNewSkill').val(), 'processSuggestSkill', false);
		}

		//event Enter key
		if (event.keyCode === 13) {
			var newSkill = $('#addNewSkill').val();
			if (newSkill.length > 0) {
				if (checkSkill(newSkill)) {
					if (skillName === newSkill) {
						listSkill.push({id: skillId, displayName: skillName, addingNumber: (addingNumber + 1)});
						listSkillNew.push({id: skillId, displayName: skillName, addingNumber: (addingNumber + 1)});
					} else {
						listSkill.push({id: null, displayName: newSkill, addingNumber: 1});
						listSkillNew.push({id: null, displayName: newSkill, addingNumber: 1});
						skillName = newSkill;
					}
					var html = '<div class="chip chip_' + skillName + '">\
									' + newSkill + '\
									<i class="material-icons">close</i>\
								</div>';
					$('.chip-inputs .add-chip').before(html);
				} else {
					$('.chip_' + newSkill).addClass('border-error');
				}
				$('#addNewSkill').val('');
				$('.suggestSearch').hide();
				FLAG_SUGGEST_SKILL = false;
			}
			$('#addNewSkill').focus();
		}
	});

	$('.suggestSearch ul').on('click', 'li', function() {
		$('#addNewSkill').val($(this).html());
		$('.suggestSearch').hide();
		skillId = parseInt($(this).attr('id'));
		skillName = $(this).html();
		addingNumber = parseInt($(this).attr('class'));
		$('#addNewSkill').focus();
	});

	$('#btn_save_skill_list').on('click', function() {
		callAPI($('#url_add_skills').val(), 'POST', listSkillNew, 'processAddSkill', true);
	});

	$('#btn_skill_skill_list').on('click', function() {
		$("#card-panel-add-skill").hide();
	});

	$( "#saveEducation" ).submit(function( event ) {

		$('#universityName').val($('#txtUniversityName').val());
		$('#majorName').val($('#txtMajorName').val());
		$('#beginYear').val($('#cbxBeginYear').val());
		$('#endYear').val($('#cbxEndYear').val());
		$('#degree').val($('#cbxDegree').val());
		$('#socialActivity').val(CKEDITOR.instances['txtSocialActivity'].getData());
		
		if(!$("#txtUniversityName").checkValidity()){
			$("#txtUniversityName").setCustomValidity("Hello May Cung");
		} else {
			$("#txtUniversityName").setCustomValidity("");
		}
		return false;
	});

	$( "#saveSummary" ).submit(function( event ) {

		$('#summary').val(CKEDITOR.instances['txtSummary'].getData());
	});

	$('#btn-connect').on('click', function() {
		$("#dialog-connect").dialog('open');
	});

	$( "#saveEmployee" ).submit(function( event ) {

		$('#positionId').val($('#cbxPosition').val());
		$('#description').val(CKEDITOR.instances['txtEmployeeDescription'].getData());
	});
	
	$('#saveSummary ').on('click', '#btnSaveSummary', function() {
		
		var phoneNumber = $('#saveSummary #phoneNumber');
		var nationality = $('#saveSummary #nationality');
		
		var check = true;
		if (phoneNumber.val() == null || phoneNumber.val() == "" || !$.isNumeric(phoneNumber.val())) {
			phoneNumber.get(0).setCustomValidity($('#phoneNumberIsEmpty').val());
			check = false;
		}
		
		if (nationality.val() == null || nationality.val() == "") {
			nationality.get(0).setCustomValidity($('#notionalityIsEmpty').val());
			check = false;
		}
		
		if (check) {
			
			$('#saveSummary ').submit();
		}
	});
	
	$('#saveEmployee ').on('click', '#btnSaveEmployee', function() {
		
		var companyName = $('#saveEmployee #companyName');
		
		var check = true;
		
		if (companyName.val() == null || companyName.val() == "") {
			companyName.get(0).setCustomValidity($('#companyNameIsEmpty').val());
			check = false;
		}
		
		if (check) {
			
			$('#saveEmployee ').submit();
		}
	});

	$('#saveEducation ').on('click', '#btnSaveEducation', function() {
		
		var universityName = $('#saveEducation #universityName');
		
		var check = true;
		
		if (universityName.val() == null || universityName.val() == "") {
			universityName.get(0).setCustomValidity($('#universityNameIsEmpty').val());
			check = false;
		}
		
		if (check) {
			
			$('#saveEducation ').submit();
		}
	});
	
//	$('#saveProject ').on('click', '#btnSaveEducation', function() {
//		
//		var cbxCompany = $('#saveProject #cbxCompany');
//		
//		var check = true;
//		
//		if (cbxCompany.val() == null || cbxCompany.val() == "") {
//			cbxCompany.get(0).setCustomValidity($('#companyIsEmpty').val());
//			check = false;
//		}
//
//		if (check) {
//
//			$('#saveProject ').submit();
//		}
//	});
});

function processSuggestSkill(responses) {

	if (FLAG_SUGGEST_SKILL) {
		var suggestSearch =  $('.suggestSearch ul');
		suggestSearch.html("");
		var html = "";
		$.each(responses, function(i, skill) {
			html += '<li id="' + skill.id + '" class="' + skill.addingNumber + '">' + skill.displayName + '</li>';
		});
		suggestSearch.append(html);
		$('.suggestSearch').show();
	}
}

function processAddSkill(responses) {
	location.reload();
}
function checkSkill(value) {
	var result = true;
	$.each(listSkill, function(i, skill) {
		if (skill.displayName === value) {
			result = false;
			return result;
		}
	});
	return result;
}

function deleteSkillOfResume(accountId, resumeSkillId) {

	var data = {
		accountId: accountId,
		resumeSkillId: resumeSkillId
	}

	callAPI($('#url_delete_skill_of_resume').val(), 'POST', data, 'processDeleteSkillOfResume', true);
}

function processDeleteSkillOfResume(responses) {
	console.log(responses);
}

function setValueSettingEducation(value, select) {
	var universityName = $('.university-name-' + value).text();
	var majorName = $('.major-name-' + value).text();
	var beginYear = $('.begin-year-' + value).text();
	var endYear = $('.end-year-' + value).text();
	var degree = $('.degree-' + value).prop('id');
	var socialActivity = $('.social-activity-' + value).text();

	$('#education-id').val(value);
	$('#txtUniversityName').val(universityName);
	$('#txtMajorName').val(majorName);
	CKEDITOR.instances['txtSocialActivity'].setData(description);
	$('#cbxDegree').val(degree);
	$('#cbxDegree').material_select();
	$('#cbxBeginYear').val(beginYear);
	$('#cbxBeginYear').material_select();
	$('#cbxEndYear').val(endYear);
	$('#cbxEndYear').material_select();

	$('.panel-setting-education').show();
	$('.list-education').hide();
	$(select).focus();

}

function cancelSettingEducation() {

	$('#education-id').val('');
	$('#txtUniversityName').val('');
	$('#txtMajorName').val('');
	$('#txtSocialActivity').val('');
	$('#cbxDegree').val('');
	$('#cbxDegree').material_select();
	$('#cbxBeginYear').val('');
	$('#cbxBeginYear').material_select();
	$('#cbxEndYear').val('');
	$('#cbxEndYear').material_select();

	$('.panel-setting-education input').removeClass('valid');
	$('.panel-setting-education').hide();
	$('.list-education').show();
}

function showPopupAddEducation() {
	$('.panel-setting-education').show();
	$('.list-education').hide();
	$('#txtUniversityName').focus();
}

function addEducationDocument(value) {
	$('.add-media-education').show();
}

function cancelEducationDocument(value) {
	$('.add-media-education').hide();
}

function processAddConnect(response) {
	if (SUCCESS == response.result) {
		
	} else {
		alert('Please login to continue!');
	}
}

function setValueSettingEmployee(value, select) {
	var companyName = $('.company-name-' + value).text();
	var positionName = $('.position-name-' + value).prop('id');
	var beginDate = $('.begin-date-' + value).text();
	var endDate = $('.end-date-' + value).text();
	var description = $('.description-' + value).text();

	$('#saveEmployee  #employee-id').val(value);
	$('#saveEmployee  #companyName').val(companyName);
	CKEDITOR.instances['txtEmployeeDescription'].setData(description);
	$('#saveEmployee  #cbxPosition').val(positionName);
	$('#saveEmployee  #cbxPosition').material_select();
	var txtBeginDate = $('#saveEmployee  #beginDate').pickadate();
	var txtEndDate = $('#saveEmployee  #endDate').pickadate();
	
	var pickerBeginDate = txtBeginDate.pickadate('picker');
	var pickerEndDate = txtEndDate.pickadate('picker');

	pickerBeginDate.set('select', beginDate, { format: 'yyyy-mm-dd' });
	pickerEndDate.set('select', endDate, { format: 'yyyy-mm-dd' });

	$('.panel-setting-employee').show();
	$('.list-experience').hide();
	$(select).focus();
}

function cancelSettingEmployee() {

	$('#saveEmployee  #employee-id').val('');
	$('#saveEmployee  #companyName').val('');
	CKEDITOR.instances['txtEmployeeDescription'].setData('');
	$('#saveEmployee  #cbxPosition').val('');
	$('#saveEmployee  #cbxPosition').material_select();
	$('#saveEmployee  #beginDate').val('');
	$('#saveEmployee  #endDate').val('');

	$('.panel-setting-employee input').removeClass('valid');
	$('.panel-setting-employee').hide();
	$('.list-experience').show();
}

function setValueSettingProject(select, value) {

	var projectName = $('.project-name-' + value).text();
	var description = $('.project-description-' + value).text();
	var url = $('.project-url-' + value).text();

	$('#saveProject #txtProjectName').val(projectName);
	$('#saveProject #txtUrl').val(url);
	CKEDITOR.instances['txtProjectDescription'].setData(description);
	$('#saveProject #cbxCompany').val(select);
	$('#saveProject #cbxCompany').material_select();

	$('.panel-setting-project').show();
	$('.list-experience').hide();
}

function cancelSettingProject() {

	$('#saveProject #txtProjectName').val('');
	$('#saveProject #txtUrl').val('');
	CKEDITOR.instances['txtProjectDescription'].setData('');
	$('#saveProject #cbxCompany').val('');
	$('#saveProject #cbxCompany').material_select();

	$('.panel-setting-project input').removeClass('valid');
	$('.panel-setting-project').hide();
	$('.list-experience').show();
}

function showPopupAddExperience() {
	// $('.panel-setting-project').show();
	$('.panel-setting-employee').show();
	$('.list-experience').hide();
}

function setValueSettingSummary(select) {
	var birthDate = $('.content-summary .birthDate').text();
	var phoneNumber = $('.content-summary .phoneNumber').text();
	var maleGender = $('.content-summary .maleGender').text().trim();
	var nationality = $('.content-summary .nationality').text();
	var summary = $('.content-summary .txtSummary').text();

	var txtBirthDate = $('#saveSummary  #birthDate').pickadate();
	
	var pickerBirthDate = txtBirthDate.pickadate('picker');

	pickerBirthDate.set('select', birthDate, { format: 'yyyy-mm-dd' });

	$('#saveSummary #phoneNumber').val(phoneNumber);
	$('#saveSummary #nationality').val(nationality);

	if ('Man' == maleGender) {
		$('#saveSummary input:radio[name="maleGender"][value="true"]').prop('checked', true);
	} else {
		$('#saveSummary input:radio[name="maleGender"][value="false"]').prop('checked', true);
	}

	if (summary != undefined){
		
		CKEDITOR.instances['txtSummary'].setData(summary);
	}

	$('.panel-setting-summary').show();
	$('.content-summary').hide();
	if (select != null) {
		$(select).focus();
	}
}
function cancelSettingSummary() {

	$('#saveSummary #phoneNumber').val('');
	$('#saveSummary #nationality').val('');
	$('#saveSummary #birthDate').val('');
	$('#saveSummary #txtSummary').val('');

	$('.panel-setting-summary input').removeClass('valid');
	$('.panel-setting-summary').hide();
	$('.content-summary').show();
}