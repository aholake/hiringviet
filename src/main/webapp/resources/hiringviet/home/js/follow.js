$(function() {

	callAPI($('#url_search_follow_list').val(), 'POST', {id: $("#account_id").val()}, "showFollowList", false);

	callAPI($('#url_search_follow_list').val(), 'POST', {id: $("#company_account_id").val()}, "showCompanyFollowList", false);
})

function showFollowList(response) {

	$('#follow_list').html("");
	var html = "";
	$.each(response, function(index, item) {
		html += '<a href="/profile?memberId=' + item.id + '" class="margin-right-5"><img width="50px" height="50px" alt="avatar-image" src="' + item.avatarImage + '" /></a>';
	});
	$('#follow_list').append(html);
}

function showCompanyFollowList(response) {

	$('#company_follow_list').html("");
	var html = "";
	$.each(response, function(index, item) {
		html += '<a href="/profile?memberId=' + item.id + '" class="margin-right-5"><img width="50px" height="50px" alt="avatar-image" src="' + item.avatarImage + '" /></a>';
	});
	$('#company_follow_list').append(html);
}