var loginMemberId = null;
$(document).ready(function() {

	loginMemberId = parseInt($('#id_of_account').val());

	var jobId = $('#job_id').val();
	var data = {
			"jobId": jobId,
			"pagingDTO": {
				"firstItem" : $('#firstItem-comment').val(),
				"currentPage" : $('#currentPage-comment').val()
			}
	}
	callAPI($('#url_get_comments').val(), 'POST', data, 'showComments', true);

});

function showComments(response) {

	if (FAIL == response.result) {
		
	} else {
		var jobId = $('#job_id').val();
		var commentList = $('.commentList');

		var currentPage = $('#currentPage-comment').val();
		if (FIRST_PAGE == currentPage) {
			commentList.html("");
		}

		var commentDTOs = response.commentDTOs;
		var html = "";

		for (var index = 0; index < commentDTOs.length; index++) {
			if (FIRST_PAGE == currentPage) {
				if (index == 0) {
					html += '<li class="display-inline-flex" style="width: 100%;">\
								<a class="margin-left-5 small-text a-text-color" onclick="javascript:hideComment()">' + $('#hide_comment').val() + '</a>\
							</li>';
					html += '<li class="display-inline-flex" style="width: 100%;">\
								<a class="margin-left-5 small-text a-text-color show-more-comment" onclick="javascript:showComment(' + jobId + ');">' + $('#load_more_comment').val() + '</a>\
							</li>';
				}
			}
			html += '<li class="collection-item avatar comment-bg">\
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
						<div class="overflow-auto reply-comment-' + commentDTOs[index].commentId + '" style="display: none;">\
							<input type="hidden" id="firstItem-reply-' + commentDTOs[index].commentId + '" value="0" />\
							<input type="hidden" id="currentPage-reply-' + commentDTOs[index].commentId + '" value="1" />\
							<ul class="collection remove-border" id="replyCommentList-' + commentDTOs[index].commentId + '">\
							</ul>';
				if (!isNaN(loginMemberId)) {
					html += '<div class="input-field col m12 p-0">\
							<input onkeypress="javascript:checkReplyComment(event, ' + commentDTOs[index].commentId + ');" id="txtReplyComment-' + commentDTOs[index].commentId + '" type="text" class="validate txtReplyComment" placeholder="' + $('#write_comment').val() + '">\
							</div>';
					
				}
				html += '</div>\
						</li>';
		}

		commentList.append(html);
		$('#firstItem-comment').val(response.pagingDTO.firstItem);
		$('#currentPage-comment').val(response.pagingDTO.currentPage);
	}
//	$('.comments').show('Blind');
//	$('.comment').attr('onclick', 'javascript:hideComment()');
}

function processAddComment(response) {

	if (FAIL == response.result) {
		alert(FAIL);
	} else {
		var html = "";
		html += '<li class="collection-item avatar comment-bg">\
					<img src="' + response.avatarImage + '" alt="" class="circle"> \
					<p class="title"><a href="' + $('#url_redirect_member').val() + response.memberId + '">' + response.firstName + ' ' + response.lastName + '</a>\
						<i class="material-icons small-icon cursor right" onclick="javascript:removeComment(this);" style="border: 2px solid #b40000;border-radius: 50%;">delete_forever</i>\
						<span class="small-text right display-inline-flex"><i class="material-icons small-icon">date_range</i>' + new Date(response.now).toLocaleString() + '</span>\
						</p>\
					<p class="small-text">' + response.comment + '</p> \
				</li>';
		$('.commentList').append(html);
		$('#txtComment').val("");

	}
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
	callAPI($('#url_get_replyComments').val(), 'POST', data, 'showJobReplyComments', true);
	$('.reply-' + commentId).attr('onclick', 'javascript:hideReplyComment(' + commentId + ')');

}

function showJobReplyComments(response) {

	if (FAIL == response.result) {

		$('.reply-comment-' + currentCommentId).html("");
		var html = '<input type="hidden" id="firstItem-reply-' + currentCommentId + '" value="0" />\
					<input type="hidden" id="currentPage-reply-' + currentCommentId + '" value="1" />\
					<ul class="collection remove-border" id="replyCommentList-' + currentCommentId + '">\
					</ul>';
		if (!isNaN(loginMemberId)) {
			html += '<div class="input-field col m12 p-0">\
							<input onkeypress="javascript:checkReplyComment(event, ' + currentCommentId + ');" id="txtReplyComment-' + currentCommentId + '" type="text" class="validate txtReplyComment" placeholder="' + $('#write_comment').val() + '">\
						</div>';
		}
		$('.reply-comment-' + currentCommentId).append(html);
		$('.reply-comment-' + currentCommentId).show('Blind');
	} else {

		var replyCommentList = $('#replyCommentList-' + currentCommentId);
		var companyPhoto = $('.company-logo img').attr('src');
		var companyName = $('.company-name a').html();

		var currentPage = $('#currentPage-reply-' + currentCommentId).val();
		if (FIRST_PAGE == currentPage) {
			replyCommentList.html("");
		}

		var replyCommentDTOs = response.replyCommentDTOs;
		var html = "";

		var numberReplyComment = parseInt($('.numberReplyComment-' + currentCommentId).text());
		var currentNumberReplyComment = parseInt($('.currentNumberReplyComment-' + currentCommentId).val());
		$('.currentNumberReplyComment-' + currentCommentId).val(currentNumberReplyComment + replyCommentDTOs.length);
		var currentNumberReplyComment = parseInt($('.currentNumberReplyComment-' + currentCommentId).val());

		for (var index = 0; index < replyCommentDTOs.length; index++) {

			if (FIRST_PAGE == currentPage) {
				if (index == 0) {
					html += '<li class="display-inline-flex" style="width: 100%;">\
								<a class="margin-left-5 small-text a-text-color" onclick="javascript:hideReplyComment(' + currentCommentId + ')">' + $('#hide_comment').val() + '</a>\
							</li>';
					if (numberReplyComment > currentNumberReplyComment) {
						html += '<li class="display-inline-flex">\
									<a class="margin-left-5 small-text a-text-color show-more-reply-' + currentCommentId + '" onclick="javascript:showReplyComment(' + currentCommentId + ')">' + $('#load_more_comment').val() + '</a>\
								</li>';
					}
				}
			}
			if (replyCommentDTOs[index].memberId != null) {
				html += '<li class="collection-item avatar comment-bg" style="padding-right: 0px;">\
							<img src="' + replyCommentDTOs[index].avatarImage + '" alt="" class="circle"> \
							<p class="title"><a href="' + $('#url_redirect_member').val() + replyCommentDTOs[index].memberId + '">' + replyCommentDTOs[index].firstName + ' ' + replyCommentDTOs[index].lastName + '</a>';
				if (!isNaN(loginMemberId)) {
					html += '<i class="material-icons small-icon cursor right" onclick="javascript:removeComment(' + replyCommentDTOs[index].replyCommentId + ');" style="border: 2px solid #b40000;border-radius: 50%;">delete_forever</i>';
				}
				html += '<span class="small-text right display-inline-flex"><i class="material-icons small-icon">date_range</i>' + new Date(replyCommentDTOs[index].changeLog.createdDate).toLocaleString() + '</span></p>\
							<p class="small-text">' + replyCommentDTOs[index].replyComment + '</p> \
						</li>';
			} else {
				html += '<li class="collection-item avatar comment-bg" style="padding-right: 0px;">\
							<img src="' + companyPhoto + '" alt="" class="circle"> \
							<p class="title"><a href="#">' + companyName + '</a>\
							<span class="small-text right display-inline-flex"><i class="material-icons small-icon">date_range</i>' + new Date(replyCommentDTOs[index].changeLog.createdDate).toLocaleString() + '</span>';
				html += '</p>\
							<p class="small-text">' + replyCommentDTOs[index].replyComment + '</p> \
						</li>';
			}
		}

		if (numberReplyComment <= currentNumberReplyComment) {
			$('.show-more-reply-' + currentCommentId).hide();
		}

		replyCommentList.append(html);
		$('.reply-comment-' + currentCommentId).show('Blind');
		$('#firstItem-reply-' + currentCommentId).val(response.pagingDTO.firstItem);
		$('#currentPage-reply-' + currentCommentId).val(response.pagingDTO.currentPage);
	}
}

function hideReplyComment(commentId) {
	$('.reply-comment-' + commentId).hide('Blind');
	$('.reply-' + commentId).attr('onclick', 'javascript:blockReplyComment(' + commentId + ')');
}

function blockReplyComment(commentId) {
	$('.reply-comment-' + commentId).show('Blind');
	$('.reply-' + commentId).attr('onclick', 'javascript:hideReplyComment(' + commentId + ')');
}

function processAddReplyComment(response) {

	if (FAIL == response.result) {
		alert(response.message);
	} else {
		var html = "";
		var roleId = response.roleId;
	
		switch (roleId) {
		case USER:
			html += '<li class="collection-item avatar comment-bg" style="padding-right: 0px;">\
						<img src="' + response.avatarImage + '" alt="" class="circle"> \
						<p class="title"><a href="' + $('#url_redirect_member').val() + response.memberId + '">' + response.firstName + ' ' + response.lastName + '</a>\
						<i class="material-icons small-icon cursor right" onclick="javascript:removeComment(this);" style="border: 2px solid #b40000;border-radius: 50%;">delete_forever</i>\
						<span class="small-text right display-inline-flex"><i class="material-icons small-icon">date_range</i>' + new Date(response.now).toLocaleString() + '</span></p>\
						<p class="small-text">' + response.comment + '</p> \
					</li>';
			break;
		case COMPANY:
			html += '<li class="collection-item avatar comment-bg" style="padding-right: 0px;">\
						<img src="' + response.avatarImage + '" alt="" class="circle"> \
						<p class="title"><a href="' + $('#url_redirect_member').val() + response.memberId + '">' + response.firstName + '</a>\
						<i class="material-icons small-icon cursor right" onclick="javascript:removeComment(this);" style="border: 2px solid #b40000;border-radius: 50%;">delete_forever</i>\
						<span class="small-text right display-inline-flex"><i class="material-icons small-icon">date_range</i>' + new Date(response.now).toLocaleString() + '</span></p>\
						<p class="small-text">' + response.comment + '</p> \
					</li>';
			break;
		case ADMIN:
			//TODO: check admin 
			break;
		}
	
		var replyCommentList = $('#replyCommentList-' + response.commentId);
		replyCommentList.append(html);
		$('#txtReplyComment-' + response.commentId).val('');
		var numberReplyComment = parseInt($('.numberReplyComment-' +  response.commentId).text()) + 1;
		$('.numberReplyComment-' +  response.commentId).text(numberReplyComment);
	}
}

function checkComment(event) {

	if (event.keyCode === 13) {

		var jobId = $('#job_id').val();
		var commentValue = $('#txtComment').val();
		if (commentValue.length > 0) {
			var data = {
				comment: commentValue,
				jobId: jobId
			}
			callAPI($('#url_add_comment').val(), 'POST', data, 'processAddComment', true);
		}
	}
}

function checkReplyComment(event, value) {
	if (event.keyCode === 13) {
		var commentValue = $('#txtReplyComment-' + value).val();
		if (commentValue.length > 0) {
			var data = {
				"commentId": value,
				"replyComment": commentValue
			}
			callAPI($('#url_add_reply_comment').val(), 'POST', data, 'processAddReplyComment', true);
		}
	}
}

function removeComment(commentId) {
	alert("removeComment");
}
