
var MAX_TOTAL_ITEM_7 = 7;
var MAX_LENGTH_VALUE_100 = 100;
var BORDER_INPUT = '#f44336';
var SUCCESS = 'success';
var FAIL = 'fail';
var VIP = 1;
var NORMAL = 0;
var HOT = "hot";
var NOT_HOT = "not-hot";
var BACKGROUND_EDIT = '#9e9e9e';
var COLOR_EDIT = '#FFF';
var BACKGROUND_DEFAULT = '#FFF';
var COLOR_DEFAULT = '#333333';
var MAX_RECORD_COUNT = 5;

var ADMIN = 0;
var USER = 1;
var COMPANY = 2;

var FIRST_PAGE = 1;

var ICON_ARROW_UP = "keyboard_arrow_up";
var ICON_ARROW_DOWN = "keyboard_arrow_down";

/** filter value **/
var All = "All";

var checkMemberTooltip = true;
var isBeta = false;

/** Global Constant for CSS pop-up Progressing */
var popupCss = "opacity: 0.5;\
	position: fixed;\
	top:0;\
	left:0;\
	width: 100%;\
	height: 100%;\
	z-index: 1001;\
    background: url(../resources/images/icon/loading.gif) no-repeat 50% 50% #ffffff;";

$(function() {
	/* Close all dialog and navbar */
	$("body").click(function() {
		$('#suggestion-box').hide();
	});
	/*
	* Show dropdown-menu
	*/
	// toggle profile box
	$("body").click(function(e) {

		if(e.target.id == "menu-btn" || $(e.target).closest("#menu-btn").length){
			$("#dropdown-menu").toggle();
   			//console.log("1");
   		}
   		else if( e.target.id == "dropdown-menu" || $(e.target).closest("#dropdown-menu").length) {
   			$("#dropdown-menu").show();
   			//console.log("2");
   		}else{
   			$("#dropdown-menu").hide();
   			//console.log("3");
   		}

		$('.tooltil-show-member').hide();
   	});



	// Enable materialize select 
	$('select').material_select();

	// initialize datepicker
	$("#job_invalidate").pickadate({
		selectMonths: true,
		selectYears: 15
	});

	// Initialize collapse button
	$(".button-collapse").sideNav();

	$('.tooltil-show-member').hover(function(){
		$('.tooltil-show-member').show();
		checkMemberTooltip = true;
	}, function() {
		$('.tooltil-show-member').hide();
		checkMemberTooltip = true;
	});

	$("#countryAddress").change(function() {
		var data = $(this).val();
		callAPI('/rest/getProvincesByCountry', 'POST', data, 'processGetProvinces', false);
	});

	$("#provinceAddress").change(function() {
		var data = $(this).val();
		callAPI('/rest/getDistrictsByProvince', 'POST', data, 'processGetDistricts', false);
	});

	if (isBeta) {
		$("#districtAddress").change(function() {
			var data = $(this).val();
			callAPI('/rest/getWardsByDistrict', 'POST', data, 'processGetWards', false);
		});
	}

	$('.fillter-wrapper').on('click', '.collection-item', function(e) {
		if ($(this).find('ul').is(":visible")) {
			$(this).find('ul').hide();
			$(this).find('.icon-arrow').text(ICON_ARROW_DOWN);
		} else {
			$(this).find('ul').show();
			$(this).find('.icon-arrow').text(ICON_ARROW_UP);
		}
	});
	
	
	//$('#card-panel-add-skill').hide();
	$('#card-panel-setting-email').hide();
	$('#card-panel-setting-phone-number').hide();
	$('#card-panel-setting-language').hide();
	// random
	var random = Math.floor((Math.random() * 10) + 1);
	switch(random) {
	case 1:
		$('#card-panel-add-skill').show();
		break;
	case 2:
		$('#card-panel-setting-email').show();
		break;
	case 3:
		$('#card-panel-setting-phone-number').show();
		break;
	case 4:
		$('#card-panel-setting-language').show();
		break;
	}
})

/**
 * Call API function
 */
function callAPI(url, method, data, callback, isProgressing, isMobile) {

	if (url == undefined || url == null) return;
	if (method == undefined || method == null) return;
	if (data == undefined || data == null) return;
	if (isProgressing == undefined || isProgressing == null) isProgressing = false;
	if (isMobile == undefined || isMobile == null) isMobile = false;

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
				enableProgressing(isMobile);
			}
		},
		success: function (result) {
			if (isProgressing == true) {
				disableProgressing();
			}
			if (callback != undefined && callback != null) {
				window[callback](result);
			}
		},
		error: function(res, xhr, status) {
		}
	});
}

function enableProgressing(isMobile) {

	var progressingHTML = "<div id='progressingPopupSelector' style='" + popupCss + "'></div>";
	// Append to screen
	$("body").append(progressingHTML);
}

function disableProgressing() {
	$("body").find("#progressingPopupSelector").remove();
}

function resetErrorMessage(arrs) {
	if (arrs != null && arrs.length > 0) {
		var index = 0;
		var len = arrs.length;
		for (;index < len; index++) {
			if (typeof arrs[index]  === "string") {
				$(arrs[index]).hide();
			}
		}
	}
}

function resetFocusInput(arrs, borderClass) {
	if (arrs != null && arrs.length > 0) {
		var index = 0;
		var len = arrs.length;
		for (;index < len; index++) {
			if (typeof arrs[index]  === "string") {
				resetForcusInput(arrs[index], borderClass);
			}
		}
	}
}

function resetForcusInput(selector, oldClass) {
	$(selector).css("border", "");
	if (!$(selector).hasClass(oldClass)) {
		$(selector).addClass(oldClass);
	}
}

function isInValidRequired(input, error, borderInput) {
	if ($(input).val() == "" || $(input).val() == null) {
		$(error).show();
		$(input).css('border-bottom-color', borderInput);
		return true;
	}
	return false;
}

function isInMaxLength(input, error, borderInput, maxLength) {
	if ($(input).val().length > maxLength) {
		$(error).show();
		$(input).css('border-bottom-color', borderInput);
		return true;
	}
	return false;
}

/* Refresh page */
function refreshPage() {
	location.reload();
}

/* redirect to page */
function redirectTo(location) {
	window.location = location;
}

function isPotraitMobileMode() {

	if ($(window).width() >= 500) {
		return false;
	}
	return true;
}

function showIconEdit(select) {

	$(select + ' .edit span').css({'background-color': BACKGROUND_EDIT, 'color': COLOR_EDIT, 'opacity': 0.5});
	$(select + ' .edit .prefix-icon-r').css({'background-color': BACKGROUND_EDIT, 'color': COLOR_EDIT});
	$(select + ' .edit .prefix-icon-r').show();
}

function hideIconEdit(select) {

	$(select + ' .edit span').css({'background-color': BACKGROUND_DEFAULT, 'color': COLOR_DEFAULT, 'opacity': 1});
	$(select + ' .edit .prefix-icon-r').css({'background-color': BACKGROUND_DEFAULT, 'color': COLOR_DEFAULT});
	$(select + ' .edit .prefix-icon-r').hide();
}


function showMemberTooltip(event, accountId) {
	if (checkMemberTooltip) {
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
		checkMemberTooltip = false;
	}
}

function hideMemberToolTip() {

	setTimeout(function() {
		if (!checkMemberTooltip) {
			$('.tooltil-show-member').hide();
			checkMemberTooltip = true;
		}
	}, 500);

}

function processCountNumberOfFollower(responses) {

	$('.tooltil-show-member img').prop('src', responses.avatarImage);
	$('.tooltil-show-member .endorse-item-name-text').text(responses.firstName + ' ' + responses.lastName);
	$('.tooltil-show-member .number-followers').text(responses.numberFollower);
	$('.tooltil-show-member').show();
}

function processGetProvinces(response) {

	$("#provinceAddress").empty().append("<option value='-1' disabled selected>" + $('#none_value').val() + "</option>");
	$.each(response, function(i, province) {

		$("#provinceAddress").append($('<option>', {
			value : province.id,
			text : province.type + " " + province.provinceName
		}));
	});
	$('#provinceAddress').material_select();
}

function processGetDistricts(response) {

	$("#districtAddress")
			.empty()
			.append("<option value='' disabled selected>" + $('#none_value').val() + "</option>");
	$.each(response, function(i, district) {

		$("#districtAddress").append($('<option>', {
			value : district.id,
			text : district.type + " " + district.districtName
		}));
	});
	$('#districtAddress').material_select();
}

function processGetWards(response) {

	$("#wardAddress")
			.empty()
			.append("<option value='' disabled selected>" + $('#none_value').val() + "</option>");
	$.each(response, function(i, ward) {

		$("#wardAddress").append($('<option>', {
			value : ward.id,
			text : ward.wardName
		}));
	});
	$('#wardAddress').material_select();
}

function hideJobBox(jobBox) {
	$(jobBox).find('.m3-div').hide();
	$(jobBox).find('.m9-div').removeClass('m9');
	$(jobBox).find('.m9-div').addClass('m12');
	$(jobBox).find('.job-info').find('.row').hide();
	$(jobBox).find('.job-info').find('.row:first-child').show();
	$(jobBox).find('.icon-arrow').text(ICON_ARROW_DOWN);
}

function showJobBox(jobBox) {
	$(jobBox).find('.m3-div').show();
	$(jobBox).find('.m9-div').removeClass('m12');
	$(jobBox).find('.m9-div').addClass('m9');
	$(jobBox).find('.job-info').find('.row').show();
	$(jobBox).find('.icon-arrow').text(ICON_ARROW_UP);
}

function bodauTiengViet(str) {
//    str = str.replace(/à|á|ạ|ả|ã|â|ầ|ấ|ậ|ẩ|ẫ|ă|ằ|ắ|ặ|ẳ|ẵ/g, "a");
//    str = str.replace(/è|é|ẹ|ẻ|ẽ|ê|ề|ế|ệ|ể|ễ/g, "e");
//    str = str.replace(/ì|í|ị|ỉ|ĩ/g, "i");
//    str = str.replace(/ò|ó|ọ|ỏ|õ|ô|ồ|ố|ộ|ổ|ỗ|ơ|ờ|ớ|ợ|ở|ỡ/g, "o");
//    str = str.replace(/ù|ú|ụ|ủ|ũ|ư|ừ|ứ|ự|ử|ữ/g, "u");
//    str = str.replace(/ỳ|ý|ỵ|ỷ|ỹ/g, "y");
//    str = str.replace(/đ/g, "d");
    return str;
}