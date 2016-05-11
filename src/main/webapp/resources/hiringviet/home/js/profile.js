$(function() { 

	profileAddCss();

	profileHoverListener();

	profileOnClick();

	$(document).ready(function() {
		$('select').material_select();
	});
});

function profileHoverListener() {

	/* profile infor header */
	generateHoverListener('#profile-name-edit');

	generateHoverListener('#profile-career-current-edit');

	generateHoverListener(".ul-infor>li");
}

function profileAddCss() {
	/* profile infor header */	
	$('#profile-name-edit').find('h4').addClass('color-white');
	$('#profile-career-current-edit').find('h5').addClass('color-white');	

	$('#profile-name-edit').find('.edit-field-icon').hide();
	$('#profile-career-current-edit').find('.edit-field-icon').hide();

	$('.endorse-plus').show();
	$('.endorse-plus').css('display', 'inline-flex');
	$('.endorsing').find('p').hide();
}

function profileOnClick() {

	/* Begin Endorse */

	/* End Endorse */
}

function generaterClickEndorse(idParent, classCurrent, classTarget, index){
	$('#' + idParent + index).find('.' + classTarget).css('display', 'inline-flex');
	$('#' + idParent + index).find('.' + classCurrent).hide();

	if(classCurrent === 'endorse-plus') {
		var totalIem = $('#endorsers-pics-' + index).find('li').length;
		if (totalIem <= MAX_TOTAL_ITEM_7) {
			var html = '<li>' 
			+ '<span>' 
			+ '<img class="endorsers-avatar" src="images/avatar-images/avatar.png">'
			+ '</span>'
			+ '</li>';
			$('#endorsers-pics-' + index).prepend(html);
		}
	} else {
		$('#endorsers-pics-' + index + ' li').first().remove();
	}
}

function generaterMouseOver(idParent) {
	$('#' + idParent).find('p').show();
}

function generaterMouseOut(idParent) {
	$('#' + idParent).find('p').hide();
}