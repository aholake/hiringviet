$(document).ready(function() {

	$('.dropdown-button').dropdown({
		inDuration : 300,
		outDuration : 225,
		constrain_width : false, // Does not change width of dropdown to that of the activator
		hover : true, // Activate on hover
		gutter : 0, // Spacing from edge
		belowOrigin : false, // Displays dropdown below the button
		alignment : 'right' // Displays dropdown with edge aligned to the left of button
	});

	$('.modal.bottom-sheet').css('max-height', '70%');
	$('.modal-trigger').leanModal({
		dismissible : true, // Modal can be dismissed by clicking outside of the modal
		opacity : 0.5, // Opacity of modal background
		in_duration : 300, // Transition in duration
		out_duration : 200, // Transition out duration
		ready : function() {
		}, // Callback for Modal open
		complete : function() {
		} // Callback for Modal close
	});

});

function showComment(id) {
	$('.comments-' + id).show('Blind');
	$('.comment-' + id).attr('onclick', 'javascript:hideComment(' + id + ')');
}

function hideComment(id) {
	$('.comments-' + id).hide('Blind');
	$('.comment-' + id).attr('onclick', 'javascript:showComment(' + id + ')');
}