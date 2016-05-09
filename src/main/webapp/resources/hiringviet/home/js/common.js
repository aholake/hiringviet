
var MAX_TOTAL_ITEM_7 = 7;


/* Close all dialog and navbar */
function onClickToBody() {
	$('#suggestion-box').hide();
}


$(function() {
	$('.carousel').carousel();/* Enable Carousel */
	$("#top-company").scrollToFixed();

	addCommonCss();

	/* Add event on click */
	addCLickListener();

});


function addCLickListener() {

	/* begin cover image */
	$('.update-cover-image').on('mouseover', function(event) {
		$('.update-cover-image span').show();
		$('.update-cover-image').css('background', "#000");
		$('.update-cover-image').css('border', "1px solid #CCCCCC");
		event.preventDefault();
	});

	$('.update-cover-image').on('mouseout', function(event) {
		cleanUpdateCoverImage();
		event.preventDefault();
	});

	$('.update-cover-image').on('click', function(event) {

	});
	/* end cover image */

	$('body').on('click', function(event) {
		event.preventDefault();
	});

	/* begin avatar image */
	$('.avatar-image').on('mouseover', function(event) {
		$('.update-avatar-image span').show();
		$('.update-avatar-image i').css('color', '#8a8a8a');
		$('.update-avatar-image').css('background','#000');
	});

	$('.avatar-image').on('mouseout', function(event) {
		cleanUpdateAvatarImage();
	});

	$('.avatar-image').on('click', function(event) {
	});
	/* end avatar image */
}

function addCommonCss() {

	/* begin cover image */
	cleanUpdateCoverImage();
	/* end cover image */

	cleanUpdateAvatarImage();
}

function cleanUpdateCoverImage() {
	$('.update-cover-image span').hide();
	$('.update-cover-image').css('background', "none");
	$('.update-cover-image').css('border', "none");
}

function cleanUpdateAvatarImage() {
	$('.update-avatar-image span').hide();
	$('.update-avatar-image').css('background','none');
	$('.update-avatar-image i').css('color','white');
}


function generateHoverListener(divWrap) {
	var $profileCarrerCurrentEdit = $(divWrap);
	$profileCarrerCurrentEdit.on('mouseover', function() {
		$profileCarrerCurrentEdit.find('.edit-field-icon').show();
		$profileCarrerCurrentEdit.find('.edit-field-icon i').addClass('color-white');
		$profileCarrerCurrentEdit.css('cursor', 'pointer');
	});

	$profileCarrerCurrentEdit.on('mouseout', function() {
		$profileCarrerCurrentEdit.find('.edit-field-icon').hide();
		$profileCarrerCurrentEdit.find('.edit-field-icon i').removeClass('color-white');
	});
}
