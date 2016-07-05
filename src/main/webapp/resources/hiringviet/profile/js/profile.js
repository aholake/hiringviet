var FLAG_SUGGEST_SKILL = true;
var listSkill = new Array();
var listSkillNew = new Array();
var skillId = null;
var skillName = null;
var addingNumber = 0;
$(function() { 

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

	$( "#saveEducation" ).submit(function( event ) {

		$('#universityName').val($('#txtUniversityName').val());
		$('#majorName').val($('#txtMajorName').val());
		$('#beginYear').val($('#cbxBeginYear').val());
		$('#endYear').val($('#cbxEndYear').val());
		$('#degree').val($('#cbxDegree').val());
		$('#socialActivity').val($('#txtSocialActivity').val());
		
		if(!$("#txtUniversityName").checkValidity()){
			$("#txtUniversityName").setCustomValidity("Hello May Cung");
		} else {
			$("#txtUniversityName").setCustomValidity("");
		}
		return false;
	});
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
	console.log(responses);
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

	callAPI($('#url_delete_skill_of_resume').val(), 'POST', data, 'processDeleteSkillOfResume', false);
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
	$('#txtSocialActivity').val(socialActivity);
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