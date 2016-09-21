$(document).ready(function() {

	var jobId = $('#job_id').val();
	var data = {
			"jobId": jobId,
			"pagingDTO": {
				"firstItem" : $('#firstItem-comment').val(),
				"currentPage" : $('#currentPage-comment').val()
			}
	}
	callAPI($('#url_get_comments').val(), 'POST', data, 'showComments', false);
});

function showComments(response) {

	if (FAIL == response.result) {
		
	} else {
		var commentList = $('.commentList');

		var currentPage = $('#currentPage-comment').val();
		if (FIRST_PAGE == currentPage) {
			commentList.html("");
		}

		var commentDTOs = response.commentDTOs;
		var html = "";
//		var numberComment = parseInt($('.numberComment-' + currentPostId).text());
//		var currentNumberComment = parseInt($('.currentNumberComment-' + currentPostId).val());
//		$('.currentNumberComment-' + currentPostId).val(currentNumberComment + commentDTOs.length);
//		var currentNumberComment = parseInt($('.currentNumberComment-' + currentPostId).val());

//		if (numberComment <= currentNumberComment) {
//			$('.show-more-comment-' + currentPostId).hide();
//		}

		for (var index = 0; index < commentDTOs.length; index++) {
			if (FIRST_PAGE == currentPage) {
				if (index == 0) {
					html += '<li class="display-inline-flex" style="width: 100%;">\
								<a class="margin-left-5 small-text a-text-color" onclick="javascript:hideComment()">' + $('#hide_comment').val() + '</a>\
							</li>';
//					if (numberComment > currentNumberComment) {
//						html += '<li class="display-inline-flex" style="width: 100%;">\
//									<a class="margin-left-5 small-text a-text-color show-more-comment-' + currentPostId + '" onclick="javascript:showComment(' + currentPostId + ');">' + $('#load_more_comment').val() + '</a>\
//								</li>';
//					}
				}
			}
			html += '<li class="collection-item avatar">\
						<img src="' + commentDTOs[index].avatarImage + '" alt="" class="circle"> \
						<p class="title"><a href="' + $('#url_redirect_member').val() + commentDTOs[index].memberId + '" onmouseenter="javascript:showMemberTooltip(this, 1);" onmouseout="javascript:hideMemberToolTip()">' + commentDTOs[index].firstName + ' ' + commentDTOs[index].lastName + '</a>\
						<span class="small-text right display-inline-flex"><i class="material-icons small-icon">date_range</i>' + new Date(commentDTOs[index].changeLog.createdDate).toLocaleString() + '</span></p>\
						<p class="small-text">' + commentDTOs[index].comment + '</p> \
						<p class="small-text display-inline-flex"><i class="material-icons small-icon">subdirectory_arrow_right</i>\
							<a class="a-text-color reply-' + commentDTOs[index].commentId + '" \
							onclick="showReplyComment(' + commentDTOs[index].commentId + ');">' + $('#reply_comment').val() + ' \
							(<span class="a-text-color numberReplyComment-' + commentDTOs[index].commentId + '">' + commentDTOs[index].numberReplyComment + '</span>)</a>\
							<input type="hidden" class="currentNumberReplyComment-' + commentDTOs[index].commentId + '" value="0"/>\
						</p>\
						<div class="reply-comment-' + commentDTOs[index].commentId + '" style="display: none;">\
							<input type="hidden" id="firstItem-reply-' + commentDTOs[index].commentId + '" value="0" />\
							<input type="hidden" id="currentPage-reply-' + commentDTOs[index].commentId + '" value="1" />\
							<ul class="collection remove-border" id="replyCommentList-' + commentDTOs[index].commentId + '">\
							</ul>\
							<div class="input-field col m12 p-0">\
								<input onkeypress="javascript:checkReplyComment(event, ' + commentDTOs[index].commentId + ');" id="txtReplyComment-' + commentDTOs[index].commentId + '" type="text" class="validate txtReplyComment" placeholder="' + $('#write_comment').val() + '">\
							</div>\
						</div>\
					</li>';
		}

		commentList.append(html);
		$('#firstItem-comment').val(response.pagingDTO.firstItem);
		$('#currentPage-comment').val(response.pagingDTO.currentPage);
	}
//	$('.comments').show('Blind');
//	$('.comment').attr('onclick', 'javascript:hideComment()');
}

