$(document).ready(function() {

});

function showComment(id) {
	$('.comments-' + id).show('Blind');
	$('.comment-' + id).attr('onclick', 'javascript:hideComment(' + id + ')');
}

function hideComment(id) {
	$('.comments-' + id).hide('Blind');
	$('.comment-' + id).attr('onclick', 'javascript:showComment(' + id + ')');
}