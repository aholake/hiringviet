var VALUE_SEARCH = "";
var CURRENT_VALUE_SEARCH = "";
var MAX_RECORED = 10;
var HEIGHT_LI_ITEM = 40;
var COUNT_LI_ITEM = 1;
var checked = false;
var searchCompanyFlag = true;
var searchJobFlag = true;
var searchMemberFlag = true;
var searchSkillFlag = true;
var cachedListMember = new Array();
var cachedListCompany = new Array();
var cachedListJob = new Array();
var cachedListSkill = new Array();
var isEmpty = true;
$(function() {

	var timer;
	$('#search-auto-complete').keyup(function(event) {
		clearTimeout(timer);
		VALUE_SEARCH = $('#search-auto-complete').val();
		timer = setTimeout(function (event){
			switch ($('.menu-drop-icon').text()){
			case "menu":
				searchCompanyFlag = true;
				searchJobFlag = true;
				searchMemberFlag = true;
				searchSkillFlag = true;
				break;
			case "account_balance":
				searchCompanyFlag = true;
				searchJobFlag = false;
				searchMemberFlag = false;
				searchSkillFlag = false;
				break;
			case "people":
				searchCompanyFlag = false;
				searchJobFlag = false;
				searchMemberFlag = true;
				searchSkillFlag = false;
				break;
			case "loyalty":
				searchCompanyFlag = false;
				searchJobFlag = false;
				searchMemberFlag = false;
				searchSkillFlag = true;
				break;
			case "share":
				searchCompanyFlag = false;
				searchJobFlag = true;
				searchMemberFlag = false;
				searchSkillFlag = false;
				break;
			}
			var data = {
				keyWord: VALUE_SEARCH,
				searchCompany: searchCompanyFlag,
				searchJob: searchJobFlag,
				searchMember: searchMemberFlag,
				searchSkill: searchSkillFlag
			}
			if (VALUE_SEARCH.length > 0) {
				filter(VALUE_SEARCH);
				if (isEmpty) {
					callSearchAPI($('#url_search').val(), "POST", data, "showResult", true);
				}
				CURRENT_VALUE_SEARCH = VALUE_SEARCH;
			} else {
				$('#suggestion-box').hide();
			}
		}, 1000);
	});
});

function filter(valueSearch) {

	isEmpty = true;

	if (CURRENT_VALUE_SEARCH.length < valueSearch.length && valueSearch.indexOf(CURRENT_VALUE_SEARCH) > 0) {

	// enable progress
		$('#suggestion-box').attr("style", "height: 50px !important");
		$('#suggestion-box .search-progress').show();
		$('#suggestion-box ul').hide();
		$('#suggestion-box').show();
	
		COUNT_LI_ITEM = 1;
		$('#suggestion-box ul').html("");
	
		addFirstItem();
		if (searchMemberFlag) {
			if (cachedListMember.length > 0) {
				$('#suggestion-box ul').append("<li class='disabled member-title'><strong><b>Member</b></strong></li>");
				$('.member-title').show();
				COUNT_LI_ITEM++;
				var contain = false;
				$.map(cachedListMember, function(elementOfArray, indexInArray) {
					var fullName = elementOfArray.value.firstName + " " + elementOfArray.value.lastName;
					if (fullName.toUpperCase().indexOf(VALUE_SEARCH.toUpperCase()) == 0) {
						isEmpty = false;
						contain = true;
						var item = "<a href='/profile?memberId=" + elementOfArray.value.id + "'><li class='search-item'>\
										<img src='" + elementOfArray.value.avatarImage + "' />\
										<div class='wrapper'>\
											<p>" + elementOfArray.value.firstName + " " + elementOfArray.value.lastName + "</p>\
											<i>"
												+ elementOfArray.value.district + ", "
												+ elementOfArray.value.province + ",  "
												+ elementOfArray.value.country +
											"</i>\
										</div>\
									</li></a>";
						$('#suggestion-box ul').append(item);
						COUNT_LI_ITEM++;
					}
				});
				if (!contain) {
					$('.member-title').hide();
				}
			}
		}
	
		if (searchCompanyFlag) {
			if (cachedListCompany.length > 0) {
				$('#suggestion-box ul').append("<li class='disabled company-title'><strong><b>Company</b></strong></li>");
				COUNT_LI_ITEM++;
				$('.company-title').show();
				var contain = false;
				$.map(cachedListCompany, function(elementOfArray, indexInArray) {
					if (elementOfArray.value.displayName.toUpperCase().indexOf(VALUE_SEARCH.toUpperCase()) == 0) {
						isEmpty = false;
						contain = true;
						var item = "<a href='/company?companyId=" + elementOfArray.value.id + "&mode=HOME'><li class='search-item'>\
										<img src='" + elementOfArray.value.avatarImage + "' />\
										<div class='wrapper'>\
											<p>" + elementOfArray.value.displayName + "</p>\
											<i>"
												+ elementOfArray.value.businessField + "; "
												+ elementOfArray.value.companySize + "+ "
												+ $('#title_employee').val()
											+ "</i>\
										</div>\
									</li></a>";
						$('#suggestion-box ul').append(item);
						COUNT_LI_ITEM++;
					}
				});
				if (!contain) {
					$('.company-title').hide();
				}
			}
		}
	
		if (searchJobFlag) {
			if (cachedListJob.length > 0) {
				$('#suggestion-box ul').append("<li class='disabled job-title'><strong><b>Job</b></strong></li>");
				COUNT_LI_ITEM++;
				$('.job-title').show();
				var contain = false;
				$.map(cachedListJob, function(elementOfArray, indexInArray) {
					isEmpty = false;
					contain = true;
					if (elementOfArray.value.title.toUpperCase().indexOf(VALUE_SEARCH.toUpperCase()) > -1) {
						var item = "<a href='/company/careers?jobId=" + elementOfArray.key + "'><li class='search-item'>\
										<i class='material-icons icon'>search</i>\
										<div class='wrapper'>\
											<p style='line-height: 50px;'>" + elementOfArray.value.title + "</p>\
										</div>\
									</li></a>";
						$('#suggestion-box ul').append(item);
						COUNT_LI_ITEM++;
					}
				});
				if (!contain) {
					$('.job-title').hide();
				}
			}
		}
	
		if (searchSkillFlag) {
			if (cachedListSkill.length > 0) {
				$('#suggestion-box ul').append("<li class='disabled skill-title'><strong><b>Skill</b></strong></li>");
				COUNT_LI_ITEM++;
				$('.skill-title').show();
				var contain = false;
				$.map(cachedListSkill, function(elementOfArray, indexInArray) {
					if (elementOfArray.value.displayName.toUpperCase().indexOf(VALUE_SEARCH.toUpperCase()) == 0) {
						isEmpty = false;
						contain = true;
						var item = "<li class='search-item' onclick='searchBySkillId(" + elementOfArray.key + ")'>\
										<i class='material-icons icon'>search</i>\
										<div class='wrapper'>\
											<p style='line-height: 50px;'>" + elementOfArray.value.displayName + "</p>\
										</div>\
									</li>";
						$('#suggestion-box ul').append(item);
						COUNT_LI_ITEM++;
					}
				});
				if (!contain) {
					$('.skill-title').hide();
				}
			}
		}
	
		// set width
		if (COUNT_LI_ITEM >= MAX_RECORED) {
			$('#suggestion-box').attr("style", "height: " + (MAX_RECORED * HEIGHT_LI_ITEM + 20) + "px !important");
		} else {
			$('#suggestion-box').attr("style", "height: " + (COUNT_LI_ITEM * HEIGHT_LI_ITEM + 20) + "px !important");
		}
	
		// disable progress
		$('#suggestion-box .search-progress').hide();
		$('#suggestion-box ul').show();
		$('#suggestion-box').slideDown(50);
	}
}

/* Show search results */
function showResult(result) {
	isEmpty = true;

	if (FAIL == result.result) {
		alert(result.message);
	} else {
		COUNT_LI_ITEM = 1;
		$('#suggestion-box ul').html("");

		addFirstItem();

		if (searchMemberFlag) {
			var listMember = result.memberResponseDTOs;
			if (listMember.length > 0) {
				$('#suggestion-box ul').append("<li class='disabled'><strong><b>Member</b></strong></li>");
				COUNT_LI_ITEM++;
				checked = false;
				for (var index = 0; index < listMember.length; index++) {
					$.map(cachedListMember, function(elementOfArray, indexInArray) {
						if (elementOfArray.key == listMember[index].id) {
							checked = true;
						}
					});
					if (!checked) {
						cachedListMember.push({
							key: listMember[index].id,
							value: listMember[index]
						});
					}
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
		}

		if (searchCompanyFlag) {
			var listCompany = result.companyResponseDTOs;
			if (listCompany.length > 0) {
				$('#suggestion-box ul').append("<li class='disabled'><strong><b>Company</b></strong></li>");
				COUNT_LI_ITEM++;
				checked = false;
				for (var index = 0; index < listCompany.length; index++) {
					$.map(cachedListCompany, function(elementOfArray, indexInArray) {
						if (elementOfArray.key == listCompany[index].id) {
							checked = true;
						}
					});
					if (!checked) {
						cachedListCompany.push({
							key: listCompany[index].id,
							value: listCompany[index]
						});
					}
					var item = "<a href='/company?companyId=" + listCompany[index].id + "&mode=HOME'><li class='search-item'>\
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
		}

		if (searchJobFlag) {
			var listJob = result.jobDTOs;
			if (listJob.length > 0) {
				$('#suggestion-box ul').append("<li class='disabled'><strong><b>Job</b></strong></li>");
				COUNT_LI_ITEM++;
				checked = false;
				for (var index = 0; index < listJob.length; index++) {
					$.map(cachedListJob, function(elementOfArray, indexInArray) {
						if (elementOfArray.key == listJob[index].id) {
							checked = true;
						}
					});
					if (!checked) {
						cachedListJob.push({
							key: listJob[index].id,
							value: listJob[index]
						});
					}
					var item = "<a href='/company/careers?jobId=" + listJob[index].id + "'><li class='search-item'>\
									<i class='material-icons icon'>search</i>\
									<div class='wrapper'>\
										<p style='line-height: 50px;'>" + listJob[index].title + "</p>\
									</div>\
								</li></a>";
					$('#suggestion-box ul').append(item);
					COUNT_LI_ITEM++;
				}
			}
		}

		if (searchSkillFlag) {
			var listSkill = result.skillDTOs;
			if (listSkill.length > 0) {
				$('#suggestion-box ul').append("<li class='disabled'><strong><b>Skill</b></strong></li>");
				COUNT_LI_ITEM++;
				checked = false;
				for (var index = 0; index < listSkill.length; index++) {
					$.map(cachedListSkill, function(elementOfArray, indexInArray) {
						if (elementOfArray.key == listSkill[index].id) {
							checked = true;
						}
					});
					if (!checked) {
						cachedListSkill.push({
							key: listSkill[index].id,
							value: listSkill[index]
						});
					}
					var item = "<li class='search-item' onclick='searchBySkillId(" + listSkill[index].id + ")'>\
									<i class='material-icons icon'>search</i>\
									<div class='wrapper'>\
										<p style='line-height: 50px;'>" + listSkill[index].displayName + "</p>\
									</div>\
								</li>";
					$('#suggestion-box ul').append(item);
					COUNT_LI_ITEM++;
				}
			}
		}

		
		// set width
		if (COUNT_LI_ITEM >= MAX_RECORED) {
			$('#suggestion-box').attr("style", "height: " + (MAX_RECORED * HEIGHT_LI_ITEM + 20) + "px !important");
		} else {
			$('#suggestion-box').attr("style", "height: " + (COUNT_LI_ITEM * HEIGHT_LI_ITEM + 20) + "px !important");
		}
		$('#suggestion-box').slideDown(50);
	}
	
}

function addFirstItem() {

	var item = "<li class='search-item' onclick='searchByCompanyName(&apos;" + VALUE_SEARCH.trim() + "&apos;)'>\
		<i class='material-icons icon'>work</i>\
		<div class='wrapper'>\
			<p style='line-height: 50px;'><a>Companies</a> requiring " + setTextColorBlue(VALUE_SEARCH)  + " name</p>\
		</div>\
		</li>";
	COUNT_LI_ITEM++;
	$('#suggestion-box ul').append(item);

	var item = "<li class='search-item' onclick='searchBySkill(&apos;" + VALUE_SEARCH.trim() + "&apos;)'>\
				<i class='material-icons icon'>work</i>\
				<div class='wrapper'>\
					<p style='line-height: 50px;'><a>Jobs</a> requiring " + setTextColorBlue(VALUE_SEARCH)  + " skills</p>\
				</div>\
				</li>";
	COUNT_LI_ITEM++;
	$('#suggestion-box ul').append(item);

	var item = "<li class='search-item' onclick='searchByJobTitle(&apos;" + VALUE_SEARCH.trim() + "&apos;)'>\
		<i class='material-icons icon'>work</i>\
		<div class='wrapper'>\
			<p style='line-height: 50px;'><a>Jobs</a> for " + setTextColorBlue(VALUE_SEARCH)  + " titles</p>\
		</div>\
		</li>";
	COUNT_LI_ITEM++;
	$('#suggestion-box ul').append(item);

//	var item = "<a href=''><li class='search-item'>\
//		<i class='material-icons icon'>supervisor_account</i>\
//		<div class='wrapper'>\
//			<p style='line-height: 50px;'><a>People</a> with " + setTextColorBlue(VALUE_SEARCH) + " skills</p>\
//		</div>\
//		</li></a>";
//	COUNT_LI_ITEM++;
//	$('#suggestion-box ul').append(item);
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
 
 function setTextColorBlue(value) {
	 return "<a>" + value + "</a>";
 }

 function searchByCompanyName(companyName) {
	$("#search-event #companyName").val(companyName);

	$("#search-event").submit();
}

function searchByJobTitle(jobTitle) {
	$("#search-event #jobTitle").val(jobTitle);

	$("#search-event").submit();
}

function searchBySkill(skill) {
	$("#search-event #skill").val(skill);

	$("#search-event").submit();
}

function searchBySkillId(skillId) {
	$("#search-event #skillId").val(skillId);

	$("#search-event").submit();
}