$(function() { 
	
	$('#addNewSkill').keyup(function(event) {
		if (event.keyCode === 13) {
			var html = '<div class="chip">\
							' + $('#addNewSkill').val() + '\
							<i class="material-icons">close</i>\
						</div>';
			$('.chip-inputs .add-chip').before(html);
			$('#addNewSkill').val("");
			$('#addNewSkill').focus();
		}
	});
});