$(document).ready(function() {

	$('.chkPublishJob').on('change', function(event) {
		var jobId = parseInt($(this).parent('div').find('input[type=hidden]').val());
		var isPublish = 0;
		if ($(this).is( ":checked" )) {
			isPublish = 1;
		}
		var data = {
			jobId: jobId,
			isPublish: isPublish
		}
		callAPI($('#url_delete_reply_comment').val(), 'POST', data, 'showResults', true);
	});
});

function showResults(response) {

	if (FAIL == response.result) {
		Materialize.toast($('#message_publish_fail').val(), 4000);
	} else {
		Materialize.toast($('#message_publish_success').val(), 4000);
	}
}