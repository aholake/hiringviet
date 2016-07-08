
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

var ADMIN = 0;
var USER = 1;
var COMPANY = 2;

var FIRST_PAGE = 1;

/** Global Constant for CSS pop-up Progressing */
var popupCss = "background-color: #BCBCBC;\
	opacity: 0.8;\
	position: fixed;\
	top:0;\
	left:0;\
	width: 100%;\
	height: 100%;\
	z-index: 1001;";

var wrap = "width: 40%;\
    margin: 20% auto auto auto;\
    height: 10px;\
    background: #ffcdd2;";

var process = "background: #e65100;";

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

	var progressingHTML = "<div id='progressingPopupSelector' style='" + popupCss + "'>\
								<div class='progress' style='" + wrap + "'>\
								    <div class='indeterminate' style='" + process + "'></div>\
								</div>\
							</div>";
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