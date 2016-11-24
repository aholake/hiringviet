$(document).ready(function(){

});

function onMouseOverEndorsingEvent(select, value) {
	$('#' + select).show();
}

function onMouseOutEndorsingEvent(select, value) {
	$('#' + select).hide();
}

function onClickEndorsingEvent(isAdd, value, skillResumeId) {

	if (isAdd) {
		var html = '<li class="addEndord">\
    		<a href="#">\
    			<img class="img-full" src="' + $('#avatar_image_of_account').val() + '">\
    		</a>\
    	</li>';
		$('.endorsers-pics-' + value).prepend(html);
		$('.icon_add_endorse_' + value).hide();
		$('.icon_remove_endorse_' + value).show();
		$('.num-endorsements-' + value).html(parseInt($('.num-endorsements-' + value).html()) + 1);
		callAPI($('#url_add_endorse').val(), 'POST', skillResumeId, 'processAddEndorse', true);
	} else {

		$('.endorsers-pics-' + value + ' li:first').remove();
//		$('.endorse_account_' + $('#id_of_account').val() + '+' + value).remove();
		$('.icon_add_endorse_' + value).show();
		$('.icon_remove_endorse_' + value).hide();
		$('.num-endorsements-' + value).html(parseInt($('.num-endorsements-' + value).html()) - 1);
		callAPI($('#url_remove_endorse').val(), 'POST', skillResumeId, 'processRemoveEndorse', true);
	}
}

function onClickEndorsingDifferentEvent(isAdd, value, skillResumeId) {
	if (isAdd) {
		$('.num-endorsements-' + value).html(parseInt($('.num-endorsements-' + value).html()) + 1);
		$('.icon_add_endorse_' + value).hide();
		$('.icon_remove_endorse_' + value).show();
		callAPI($('#url_add_endorse').val(), 'POST', skillResumeId, 'processAddEndorse', true);
	} else {
		$('.num-endorsements-' + value).html(parseInt($('.num-endorsements-' + value).html()) - 1);
		$('.icon_add_endorse_' + value).show();
		$('.icon_remove_endorse_' + value).hide();
		callAPI($('#url_remove_endorse').val(), 'POST', skillResumeId, 'processRemoveEndorse', true);
	}
}


function processAddEndorse(responses) {
	if (SUCCESS == responses.result) {

	} else {
		alert('Endorse fail!');
	}
}

function processRemoveEndorse(responses) {
	if (SUCCESS == responses.result) {

	} else {
		alert('Endorse fail!');
	}
}