$(document).ready(function(){

	$('body').on('click', function() {
		$('.tooltil-show-member').hide();
	});
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
		callAPI($('#url_add_endorse').val(), 'POST', skillResumeId, 'processAddEndorse', false);
	} else {
		$('.endorse_account_' + $('#id_of_account').val() + value).remove();
		$('.icon_add_endorse_' + value).show();
		$('.icon_remove_endorse_' + value).hide();
		$('.num-endorsements-' + value).html(parseInt($('.num-endorsements-' + value).html()) - 1);
		callAPI($('#url_remove_endorse').val(), 'POST', skillResumeId, 'processRemoveEndorse', false);
	}
}

function onClickEndorsingDifferentEvent(isAdd, value, skillResumeId) {
	if (isAdd) {
		$('.num-endorsements-' + value).html(parseInt($('.num-endorsements-' + value).html()) + 1);
		callAPI($('#url_add_endorse').val(), 'POST', skillResumeId, 'processAddEndorse', false);
	} else {
		$('.num-endorsements-' + value).html(parseInt($('.num-endorsements-' + value).html()) - 1);
		callAPI($('#url_remove_endorse').val(), 'POST', skillResumeId, 'processRemoveEndorse', false);
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


function showTooltip(event, accountId) {
	var bodyRect = document.body.getBoundingClientRect(),
    elemRect = event.getBoundingClientRect(),
    offsetX   = elemRect.top - bodyRect.top;
    offsetY  = elemRect.left - bodyRect.left;

	$('.tooltil-show-member').css('top', (offsetX - 112));
	$('.tooltil-show-member').css('left', (offsetY - 113));
	$('.tooltil-show-member .btn-connect').prop('href', $('#redirect_member_page').val() + accountId);
	$('.tooltil-show-member .btn-profile').prop('href', $('#redirect_member_page').val() + accountId);
	$('.tooltil-show-member .endorse-item-name-text').prop('href', $('#redirect_member_page').val() + accountId);
	callAPI($('#url_count_member_of_follwer').val(), 'POST', accountId, 'processCountNumberOfFollower', false);
}

function processCountNumberOfFollower(responses) {

	$('.tooltil-show-member img').prop('src', responses.avatarImage);
	$('.tooltil-show-member .endorse-item-name-text').text(responses.firstName + ' ' + responses.lastName);
	$('.tooltil-show-member .number-followers').text(responses.numberFollower);
	$('.tooltil-show-member').show();
}