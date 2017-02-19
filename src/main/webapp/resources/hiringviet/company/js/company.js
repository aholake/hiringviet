var loginMemberId = null;
var isOwner = null;
$(function() {

	loginMemberId = parseInt($('#id_of_account').val());
	isOwner = parseInt($('#is_owner').val());
		
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

	$('#btn-load-more-job').on('click', function() {

		var firstItem = $('#first_item').val();
		var currentPage = $('#current_page').val();

		var url = $('#url_load_more_job').val();

		var data = {
			pagingDTO: {"firstItem" : firstItem,
						"currentPage" : currentPage
			},
			companyId: $("#company-id").val()
		}
		callAPI(url, 'POST', data, "showResultLoadMore", true);
	});

	$(document).on('click', '.icon-arrow', function(event) {
		var iconArrowText = $(this).text();
		var jobBox = $(this).parents('.job-box');
		if (ICON_ARROW_DOWN === iconArrowText) {
			showJobBox(jobBox);
		} else {
			hideJobBox(jobBox);
		}
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
	callAPI($('#url_get_comments').val(), 'POST', data, 'showPostComments', true);
}

function hideComment(postId) {
	$('.comments-' + postId).hide('Blind');
	$('.comment-' + postId).attr('onclick', 'javascript:blockComment(' + postId + ')');
}

function blockComment(postId) {
	$('.comments-' + postId).show('Blind');
	$('.comment-' + postId).attr('onclick', 'javascript:hideComment(' + postId + ')');
}

function showPostComments(response) {

	if (FAIL == response.result) {
		$('.show-more-comment-' + currentPostId).hide();
	} else {
		var commentList = $('.commentList-' + currentPostId);

		var currentPage = $('#currentPage-comment-' + currentPostId).val();
		if (FIRST_PAGE == currentPage) {
			commentList.html("");
		}

		var commentDTOs = response.commentDTOs;
		if (commentDTOs.length > 0) {
			var html = "";
			var numberComment = parseInt($('.numberComment-' + currentPostId).text());
			var currentNumberComment = parseInt($('.currentNumberComment-' + currentPostId).val()) + commentDTOs.length;
			$('.currentNumberComment-' + currentPostId).val(currentNumberComment);
	
			if (numberComment <= currentNumberComment) {
				$('.show-more-comment-' + currentPostId).hide();
			}
	
			for (var index = 0; index < commentDTOs.length; index++) {
				if (FIRST_PAGE == currentPage) {
					if (index == 0) {
						html += '<li class="display-inline-flex" style="width: 100%;">\
									<a class="margin-left-5 small-text a-text-color" onclick="javascript:hideComment(' + currentPostId + ')">' + $('#hide_comment').val() + '</a>\
								</li>';
						if (numberComment > currentNumberComment) {
							html += '<li class="display-inline-flex" style="width: 100%;">\
										<a class="margin-left-5 small-text a-text-color show-more-comment-' + currentPostId + '" onclick="javascript:showComment(' + currentPostId + ');">' + $('#load_more_comment').val() + '</a>\
									</li>';
						}
					}
				}
				html += '<li class="collection-item avatar comment-bg">\
							<img src="' + commentDTOs[index].avatarImage + '" alt="" class="circle"> \
							<p class="title"><a href="' + $('#url_redirect_member').val() + commentDTOs[index].memberId + '" onmouseenter="javascript:showMemberTooltip(this, 1);" onmouseout="javascript:hideMemberToolTip()">' + commentDTOs[index].firstName + ' ' + commentDTOs[index].lastName + '</a>';
	
				if (commentDTOs[index].memberId == loginMemberId) {
					html += '<i class="material-icons small-icon cursor right" onclick="javascript:removeComment(' + commentDTOs[index].commentId + ');" style="border: 2px solid #b40000;border-radius: 50%;">delete_forever</i>';
				}
	
				html += '<span class="small-text right display-inline-flex"><i class="material-icons small-icon">date_range</i>' + new Date(commentDTOs[index].changeLog.createdDate).toLocaleString() + '</span></p>\
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
								</ul>';
				if ( (loginMemberId != null && !isNaN(loginMemberId)) || (isOwner != null && !isNaN(isOwner))) {
					html += '<div class="input-field col m12 p-0 reply-test">\
						        <input type="hidden" value="' + commentDTOs[index].accountId + '"/>\
								<input onkeypress="javascript:checkReplyComment(event, ' + commentDTOs[index].commentId + ', ' + commentDTOs[index].accountId + ');" id="txtReplyComment-' + commentDTOs[index].commentId + '" type="text" class="validate txtReplyComment" placeholder="' + $('#write_comment').val() + '">\
							</div>';
				}
				html += '</div>\
						</li>';
			}
	
			commentList.append(html);
			$('#firstItem-comment-' + currentPostId).val(response.pagingDTO.firstItem);
			$('#currentPage-comment-' + currentPostId).val(response.pagingDTO.currentPage);
		} else {

			if ((loginMemberId != null && !isNaN(loginMemberId)) || (isOwner != null && !isNaN(isOwner))) {
				commentList.append("<p>Hãy là người đầu tiên bình luận</p>");
			} else {
				commentList.append("<p>Chưa có bình luận nào!</p>");
			}
		}
	}
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
	callAPI($('#url_get_replyComments').val(), 'POST', data, 'showPostReplyComments', true);
	$('.reply-' + commentId).attr('onclick', 'javascript:hideReplyComment(' + commentId + ')');

}

function showPostReplyComments(response) {

	if (FAIL == response.result) {
		$('.reply-comment-' + currentCommentId).html("");
		var html = '<input type="hidden" id="firstItem-reply-' + currentCommentId + '" value="0" />\
					<input type="hidden" id="currentPage-reply-' + currentCommentId + '" value="1" />\
					<ul class="collection remove-border" id="replyCommentList-' + currentCommentId + '">\
					</ul>';
		if ((loginMemberId != null && !isNaN(loginMemberId)) || (isOwner != null && !isNaN(isOwner))) {
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

		if (numberReplyComment <= currentNumberReplyComment) {
			$('.show-more-reply-' + currentCommentId).hide();
		}

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
				if (loginMemberId != null && !isNaN(loginMemberId)) {
					html += '<i class="material-icons small-icon cursor right" onclick="javascript:removeReplyComment(' + replyCommentDTOs[index].replyCommentId + ');" style="border: 2px solid #b40000;border-radius: 50%;">delete_forever</i>';
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

function addPostComment(event, value) {

}

function processAddComment(response) {

	if (FAIL == response.result) {
		alert(FAIL);
	} else {
		var html = "";
		html += '<li class="collection-item avatar comment-bg">\
					<img src="' + response.avatarImage + '" alt="" class="circle"> \
					<p class="title"><a href="' + $('#url_redirect_member').val() + response.memberId + '">' + response.firstName + ' ' + response.lastName + '</a>\
						<i class="material-icons small-icon cursor right" onclick="javascript:void(0);" style="border: 2px solid #b40000;border-radius: 50%;">delete_forever</i>\
						<span class="small-text right display-inline-flex"><i class="material-icons small-icon">date_range</i>' + new Date(response.now).toLocaleString() + '</span>\
						</p>\
					<p class="small-text">' + response.comment + '</p> \
				</li>';
		$('.commentList-' + response.postId).append(html);
		$('.txtComment-' + response.postId).val("");
		var numberComment = parseInt($('.numberComment-' + response.postId).text()) + 1;
		$('.numberComment-' + response.postId).text(numberComment);
		
	}
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
						<i class="material-icons small-icon cursor right" onclick="javascript:void(0);" style="border: 2px solid #b40000;border-radius: 50%;">delete_forever</i>\
						<span class="small-text right display-inline-flex"><i class="material-icons small-icon">date_range</i>' + new Date(response.now).toLocaleString() + '</span></p>\
						<p class="small-text">' + response.comment + '</p> \
					</li>';
			break;
		case COMPANY:
			html += '<li class="collection-item avatar comment-bg" style="padding-right: 0px;">\
						<img src="' + response.avatarImage + '" alt="" class="circle"> \
						<p class="title"><a href="' + $('#url_redirect_member').val() + response.memberId + '">' + response.firstName + '</a>\
						<i class="material-icons small-icon cursor right" onclick="javascript:void(0);" style="border: 2px solid #b40000;border-radius: 50%;">delete_forever</i>\
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

function checkComment(event, value) {

	if (event.keyCode === 13) {

		var postId = value;
		var commentValue = $('.txtComment-' + value).val();
		if (commentValue != null || commentValue != "" || commentValue != undefined) {
			var data = {
				comment: commentValue,
				postId: postId
			}
			callAPI($('#url_add_comment').val(), 'POST', data, 'processAddComment', true);
		}
	}
}

function checkReplyComment(event, value, accountId) {
	if (event.keyCode === 13) {
		var commentValue = $('#txtReplyComment-' + value).val();
		if (commentValue != null || commentValue != "") {
			var data = {
				"commentId": value,
				"replyComment": commentValue,
				"accountId": accountId
			}
			callAPI($('#url_add_reply_comment').val(), 'POST', data, 'processAddReplyComment', true);
		}
	}
}

function removeComment(commentId) {

	if (commentId != null) {

		var data = {
				commentId: commentId
		}
		callAPI($('#url_delete_comment').val(), 'POST', data, 'commentShowResults', true);
	}
}

function removeReplyComment(replyCommentId) {

	if (replyCommentId != null) {

		var data = {
				replyCommentId: replyCommentId
		}
		callAPI($('#url_delete_reply_comment').val(), 'POST', data, 'commentShowResults', true);
	}
}

function commentShowResults(response) {

	if (FAIL == response.result) {
		Materialize.toast($('#message_delete_fail').val(), 4000);
	} else {
		Materialize.toast($('#message_delete_success').val(), 4000);
	}
	setTimeout(function(){ location.reload(); }, 1000);
}

function showResultLoadMore(response) {

	if (FAIL == response.result) {
		alert(response.message);
	} else {

		hideJobBox('.job-box');

		var jobListDiv = $('#job-list');
		var jobListResponse = response.jobList;
		if (MAX_RECORD_COUNT > jobListResponse.length) {
			$('#first_item').val(parseInt($('#first_item').val()) + jobListResponse.length);
		} else {
			$('#first_item').val(parseInt($('#first_item').val()) + MAX_RECORD_COUNT);
		}
		$('#current_page').val(parseInt($('#current_page').val()) + 1);
		var html = "";

		for (var index = 0; index < jobListResponse.length; index++) {

			var tempItem = "";
			var skills = jobListResponse[index].skillSet;
			for (var i = 0; i < skills.length; i++) {
				tempItem += '<a class="chip skill-' + skills[i].displayName.replace(' ', '') + '">' + skills[i].displayName + '</a>';
			}

			var nameClass = "";
			if (jobListResponse[index].company.isVip == VIP) {
				nameClass = HOT;
			} else {
				nameClass = NOT_HOT;
			}

			

			var publishHtml = "";
			var applyHtml = "";
			if ($("#isOwner").length > 0) {
				publishHtml += '<div class="col m3" style="text-align: right;">\
									<input type="hidden" value="' + jobListResponse[index].id + '"/>';
				if (jobListResponse[index].publish == 1) {

					publishHtml += '<input type="checkbox" class="filled-in chkPublishJob" id="publishJob' + jobListResponse[index].id + '" checked="checked" />';
				} else {

					publishHtml += '<input type="checkbox" class="filled-in chkPublishJob" id="publishJob' + jobListResponse[index].id + '"/>';
				}

				publishHtml += '<label for="publishJob' + jobListResponse[index].id + '" style="margin-left: -12px;">Publish</label>\
								</div>';

				applyHtml += '<a target="_blank" href="/company/apply?companyId=' + $("#company-id").val() + '&jobId=' + jobListResponse[index].id + '" class="right margin-right-10">\
								<span class="label">Applied people: </span>\
								<span class="value">' + response.applyNumbers[jobListResponse[index].id] + ' people</span>\
							</a>';
			}
			
			var item = '<div class="job-item">\
							<div class="job-box" id="' + jobListResponse[index].id + '">\
								<!--<div class="location-sticky orange darken-1 position-' + jobListResponse[index].workAddress.district.province.provinceName.replace(' ', '') + '">' + jobListResponse[index].workAddress.district.province.provinceName + '</div>-->\
									<div class="row none-margin-bottom">\
										<div class="col m12">\
											<h1 class="col m9 p-0 title block-with-text">\
												<a class="job-title not-hot" href="/company/careers?jobId=' + jobListResponse[index].id + '">' + jobListResponse[index].title + '</a>\
											</h1>\
											' + publishHtml + '\
											<!--<a href="#" class="company-name company-' + jobListResponse[index].company.displayName.replace(' ', '') + '">' + jobListResponse[index].company.displayName + '</a>-->\
											<!--<p class="work-location"><a href="#">' + jobListResponse[index].workAddress.district.province.provinceName + '</a></p>-->\
											<div class="job-info">\
												<div class="row">\
													<div class="col m6 none-padding-left">\
														<p><i class="material-icons prefix-icon">attach_money</i>' + $('#text_title_salary').val() + ': \
															<span class="info">' + jobListResponse[index].minSalary + ' - ' + jobListResponse[index].maxSalary + '</span>\
														</p>\
													</div>\
													<div class="col m6 none-padding-left">\
														<p class="right"><i class="material-icons prefix-icon">date_range</i>' + $('#text_title_post_date').val() + ': \
															<span class="info datePost">' + jobListResponse[index].postDate + '</span>\
														</p>\
													</div>\
													<div class="col m6 none-padding-left">\
														<p><i class="material-icons prefix-icon">loyalty</i>' + $('#text_title_major').val() + ': \
															<span class="info position-' + jobListResponse[index].position.displayName.replace(' ', '') + '">' + jobListResponse[index].position.displayName + '</span>\
														</p>\
													</div>\
													<div class="col m6 none-padding-left">\
														<p class="right"><i class="material-icons prefix-icon">people</i>' + $('#text_total_employee').val() + ': \
															<span class="info">' + jobListResponse[index].size + $('#text_title_people').val() + '</span>\
														</p>\
													</div>\
												</div>\
												<div class="row">\
													<div class="col m12 none-padding-left text-justify block-with-text edit-text-ellipsis">' + jobListResponse[index].description + '\
													</div>\
													<div class="col m12 none-padding-left margin-top-5">' + tempItem + '</div>\
												</div>\
											</div>\
											<i class="material-icons right icon-arrow margin-right-5 cursor mp0">keyboard_arrow_up</i>\
											' + applyHtml + '\
										</div>\
									</div>\
								</div>\
							</div>\
						</div>';
			html += item;
		}
		jobListDiv.append(html);

		if (parseInt($('#max_item').val()) > jobListResponse.length) {
			$('#btn-load-more-job').prop('disabled', true);
			$('#btn-load-more-job').addClass('disabled');
		}
		caller();
	}
}