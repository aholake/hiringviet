$(function() {

	$('#btn-follow').on('click', function(event) {

		callAPI($('#url_search_follow_list').val(), 'POST', {id: $("#account_id").val()}, "showFollowList", false);
	});
})

function showFollowList(response) {

	$('.image-item').html("");
	var html = "";
	$.each(response, function(index, item) {
		html += '<a href="/profile?memberId=' + item.id + '"><img width="50px" height="50px" alt="avatar-image" src="' + item.avatarImage + '" /></a>';
	});
	$('.image-item').append(html);
}