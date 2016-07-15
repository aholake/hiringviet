var VALUE_SEARCH = null;
var MAX_RECORED = 10;
var HEIGHT_LI_ITEM = 40;
var COUNT_LI_ITEM = 1;

$(function() {

	$('#search-auto-complete').keyup(function(event) {
		if (event.keyCode === 0 || (65 <= event.keyCode && event.keyCode <= 90) || (97 <= event.keyCode && event.keyCode <= 122)) {
			COUNT_LI_ITEM = 1;
			VALUE_SEARCH = $('#search-auto-complete').val();
			if (VALUE_SEARCH.length > 0) {
				callSearchAPI($('#url_search').val(), "POST", VALUE_SEARCH, "showResult", true);
			}
			if (VALUE_SEARCH.length == 0 ) {
				$('#suggestion-box').hide();
			}
		}
	});
});

/* Show search results */
function showResult(result) {

	if (FAIL == result.result) {
		alert(result.message);
	} else {

		$('#suggestion-box ul').html("");

		var listMember = result.memberResponseDTOs;
		if (listMember.length > 0) {
			$('#suggestion-box ul').append("<li class='disabled'><strong><b>Member</b></strong></li>");
			COUNT_LI_ITEM++;
			for (var index = 0; index < listMember.length; index++) {
				var item = "<a href='/profile?memberId=" + listMember[index].id + "'><li class='search-item'>\
								<img src='" + listMember[index].avatarImage + "' />\
								<div class='wrapper'>\
									<p>" + listMember[index].firstName + " " + listMember[index].lastName + "</p>\
									<i>"
										+ listMember[index].district + ", "
										+ listMember[index].province + ",  "
										+ listMember[index].country +
									"</i>\
								</div>\
							</li></a>";
				$('#suggestion-box ul').append(item);
				COUNT_LI_ITEM++;
			}
		}

		var listCompany = result.companyResponseDTOs;
		if (listCompany.length > 0) {
			$('#suggestion-box ul').append("<li class='disabled'><strong><b>Company</b></strong></li>");
			COUNT_LI_ITEM++;
			for (var index = 0; index < listCompany.length; index++) {
				var item = "<a href='/company/" + listCompany[index].id + "'><li class='search-item'>\
								<img src='" + listCompany[index].avatarImage + "' />\
								<div class='wrapper'>\
									<p>" + listCompany[index].displayName + "</p>\
									<i>"
										+ listCompany[index].businessField + "; "
										+ listCompany[index].companySize + "+ "
										+ $('#title_employee').val()
									+ "</i>\
								</div>\
							</li></a>";
				$('#suggestion-box ul').append(item);
				COUNT_LI_ITEM++;
			}
		}

		var listJob = result.jobSuggestDTOs;
		if (listJob.length > 0) {
			$('#suggestion-box ul').append("<li class='disabled'><strong><b>Job</b></strong></li>");
			COUNT_LI_ITEM++;
			for (var index = 0; index < listJob.length; index++) {
				var item = "<li class='search-item'>\
								<img src='' />\
								<div class='wrapper'>\
									<p style='line-height: 50px;'>" + listJob[index].displayName + "</p>\
								</div>\
							</li>";
				$('#suggestion-box ul').append(item);
				COUNT_LI_ITEM++;
			}
		}

		var listSkill = result.skills;
		if (listSkill.length > 0) {
			$('#suggestion-box ul').append("<li class='disabled'><strong><b>Skill</b></strong></li>");
			COUNT_LI_ITEM++;
			for (var index = 0; index < listSkill.length; index++) {
				var item = "<li class='search-item'>\
								<img src='' />\
								<div class='wrapper'>\
									<p style='line-height: 50px;'>" + listSkill[index].displayName + "</p>\
								</div>\
							</li>";
				$('#suggestion-box ul').append(item);
				COUNT_LI_ITEM++;
			}
		}
//		$('#suggestion-box ul').append("<li>" + result.data[index].title + "</li>");

		
		// set width
		if (COUNT_LI_ITEM > MAX_RECORED) {
			$('#suggestion-box').attr("style", "height: " + (MAX_RECORED * HEIGHT_LI_ITEM + 20) + "px !important");
		} else {
			$('#suggestion-box').attr("style", "height: " + (COUNT_LI_ITEM * HEIGHT_LI_ITEM + 20) + "px !important");
		}
		$('#suggestion-box').slideDown(50);
	}
	
}

/**
 * Call API function
 */
 function callSearchAPI(url, method, data, callback, isProgressing) {

 	if (url == undefined || url == null) return;
 	if (method == undefined || method == null) return;
 	if (data == undefined || data == null) return;
 	if (isProgressing == undefined || isProgressing == null) isProgressing = false;

 	$.ajax({
 		type: method,
 		url: url,
 		cache: false,
 		dataType: "json",
 		Accept : "application/json",
 		contentType: "application/json; charset=utf-8",
		data: JSON.stringify(data),
		beforeSend: function(xhr, settings) {
			if (isProgressing == true) {
				// enable progress
				$('#suggestion-box').attr("style", "height: 50px !important");
				$('#suggestion-box .search-progress').show();
				$('#suggestion-box ul').hide();
				$('#suggestion-box').show();
			}
		},
		success: function (result) {
			if (isProgressing == true) {
				// disable progress
				$('#suggestion-box .search-progress').hide();
				$('#suggestion-box ul').show();
			}
			if (callback != undefined && callback != null) {
				window[callback](result);
			}
		},
		error: function(res, xhr, status) {
			console.log("Error: " + res);
		}
	});
 }