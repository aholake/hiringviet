var FLAG_SUGGEST_SKILL = true;
var listSkill = new Array();
var listSkillNew = new Array();
var skillId = null;
var skillName = null;
$(function() { 

	/* set current skill to list */
	$(".list-skill-chip .current_skill").each(function() {
		skillId = $(this).children('.temp').attr('id');
		skillName = $(this).children('.temp').attr('value');
		listSkill.push({id: skillId, displayName: skillName});
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
						listSkill.push({id: skillId, displayName: skillName});
						listSkillNew.push({id: skillId, displayName: skillName});
					} else {
						listSkill.push({id: null, displayName: newSkill});
						listSkillNew.push({id: null, displayName: newSkill});
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
		$('#addNewSkill').focus();
	});

	$('#btn_save_skill_list').on('click', function() {
		callAPI($('#url_add_skills').val(), 'POST', listSkillNew, 'processAddSkill', true);
	});

	
});

function processSuggestSkill(responses) {

	if (FLAG_SUGGEST_SKILL) {
		var suggestSearch =  $('.suggestSearch ul');
		suggestSearch.html("");
		var html = "";
		$.each(responses, function(i, skill) {
			html += '<li id="' + skill.id + '">' + skill.displayName + '</li>';
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

function deleteSkillOfResume(accountId, resumeId, skillId) {

	var data = {
		accountId: accountId,
		resumeId: resumeId,
		skillId: skillId
	}

	callAPI($('#url_delete_skill_of_resume').val(), 'POST', data, 'processDeleteSkillOfResume', false);
}

function processDeleteSkillOfResume(responses) {
	console.log(responses);
}