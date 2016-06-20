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
var currentPostId = 0;
function showComment(postId) {

	currentPostId = postId;

	var data = {
			"postId": postId,
			"pagingDTO": {
				"firstItem" : $('#firstItem-comment-' + postId).val(),
				"currentPage" : $('#currentPage-comment-' + postId).val()
			}
	}
	callAPI($('#url_get_post_comments').val(), 'POST', data, 'showPostComments', true);
}

function hideComment(postId) {
	$('.comments-' + postId).hide('Blind');
	$('.comment-' + postId).attr('onclick', 'javascript:showComment(' + postId + ')');
}

function showPostComments(response) {

	if (FAIL == response.result) {
		alert(response.message);
	} else {
		var commentList = $('.commentList-' + currentPostId);

		var commentDTOs = response.commentDTOs;
		var html = "";
		for (var index = 0; index < commentDTOs.length; index++) {
			html += '<li class="collection-item avatar comment-bg">\
						<img src="' + commentDTOs[index].avatarImage + '" alt="" class="circle"> \
						<p class="title"><a href="' + $('#url_redirect_member').val() + commentDTOs[index].memberId + '">' + commentDTOs[index].firstName + ' ' + commentDTOs[index].lastName + '</a>\
						<span class="small-text right display-inline-flex"><i class="material-icons small-icon">date_range</i>' + new Date(commentDTOs[index].changeLog.createdDate).toLocaleString() + '</span></p>\
						<p class="small-text">' + commentDTOs[index].comment + '</p> \
						<p class="small-text display-inline-flex"><i class="material-icons small-icon">subdirectory_arrow_right</i><a class="a-text-color" onclick="showReplyComment(' + commentDTOs[index].commentId + ');">' + $('#reply_comment').val() + '</a></p>\
						<div class="reply-comment-' + commentDTOs[index].commentId + '" style="display: none;">\
							<input type="hidden" id="firstItem-reply-' + commentDTOs[index].commentId + '" value="0" />\
							<input type="hidden" id="currentPage-reply-' + commentDTOs[index].commentId + '" value="1" />\
							<ul class="collection remove-border" id="replyCommentList-' + commentDTOs[index].commentId + '">\
								<li class="display-inline-flex">\
									<a class="margin-left-5 small-text a-text-color">' + $('#load_more_comment').val() + '</a>\
								</li>\
							</ul>\
							<div class="input-field col m12">\
								<input id="last_name" type="text" class="validate" placeholder="' + $('#write_comment').val() + '">\
							</div>\
						</div>\
					</li>';
		}

		commentList.append(html);
	}
	$('#firstItem-comment-' + currentPostId).val(response.pagingDTO.firstItem);
	$('#currentPage-comment-' + currentPostId).val(response.pagingDTO.currentPage);
	$('.comments-' + currentPostId).show('Blind');
	$('.comment-' + currentPostId).attr('onclick', 'javascript:hideComment(' + currentPostId + ')');
}

var currentCommentId = 0;
function showReplyComment(commentId) {

	currentCommentId = commentId;
	var data = {
			"commentId": commentId,
			"pagingDTO": {
				"firstItem" : $('#firstItem-reply-' + commentId).val(),
				"currentPage" : $('#currentPage-reply-' + commentId).val()
			}
	}
	callAPI($('#url_get_post_replyComments').val(), 'POST', data, 'showPostReplyComments', true);
}

function showPostReplyComments(response) {

	if (FAIL == response.result) {
		alert(response.message);
	} else {

		var companyPhoto = $('.company-logo img').attr('src');
		var companyName = $('.company-name a').html();
		var replyCommentList = $('#replyCommentList-' + currentCommentId);

		var replyCommentDTOs = response.replyCommentDTOs;
		var html = "";
		for (var index = 0; index < replyCommentDTOs.length; index++) {

			if (replyCommentDTOs[index].memberId != null) {
				html += '<li class="collection-item avatar comment-bg">\
							<img src="' + replyCommentDTOs[index].avatarImage + '" alt="" class="circle"> \
							<p class="title"><a href="' + $('#url_redirect_member').val() + replyCommentDTOs[index].memberId + '">' + replyCommentDTOs[index].firstName + ' ' + replyCommentDTOs[index].lastName + '</a>\
							<span class="small-text right display-inline-flex"><i class="material-icons small-icon">date_range</i>' + new Date(replyCommentDTOs[index].changeLog.createdDate).toLocaleString() + '</span></p>\
							<p class="small-text">' + replyCommentDTOs[index].replyComment + '</p> \
						</li>';
			} else {
				html += '<li class="collection-item avatar comment-bg">\
					<img src="' + companyPhoto + '" alt="" class="circle"> \
					<p class="title"><a href="#">' + companyName + '</a>\
					<span class="small-text right display-inline-flex"><i class="material-icons small-icon">date_range</i>' + new Date(replyCommentDTOs[index].changeLog.createdDate).toLocaleString() + '</span></p>\
					<p class="small-text">' + replyCommentDTOs[index].replyComment + '</p> \
				</li>';
			}
		}

		replyCommentList.append(html);
		$('.reply-comment-' + currentCommentId).show();
		$('#firstItem-reply-' + currentCommentId).val(response.pagingDTO.firstItem);
		$('#currentPage-reply-' + currentCommentId).val(response.pagingDTO.currentPage);
	}
}