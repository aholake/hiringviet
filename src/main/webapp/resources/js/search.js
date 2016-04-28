var VALUE_SEARCH = null;
var MAX_RECORED = 7;
var HEIGHT_LI_ITEM = 40;
var COUNT_LI_ITEM = 0;

$(function() {

	$('#search-auto-complete').keyup(function(event) {
		COUNT_RECORED = 0;
		COUNT_LI_ITEM = 0;
		VALUE_SEARCH = $('#search-auto-complete').val();
		if (VALUE_SEARCH.length > 0) {
			callSearchAPI("http://localhost:8080/Project-gui/text.txt", "GET", VALUE_SEARCH, "showResult", true);
		}
		if (VALUE_SEARCH.length == 0 ) {
			$('#suggestion-box').hide();
		}
	});
});

/* Show search results */
function showResult(result) {

	COUNT_RECORED++;
	$('#suggestion-box ul').html("");
	for (var index = 0; index < result.data.length; index++) {
		if (result.data[index].title.includes(VALUE_SEARCH)) {
			$('#suggestion-box ul').append("<li>" + result.data[index].title + "</li>");
			COUNT_LI_ITEM++;
		}
	}
	if (COUNT_LI_ITEM > MAX_RECORED) {
		$('#suggestion-box').attr("style", "height: " + (MAX_RECORED * HEIGHT_LI_ITEM) + "px !important");
	} else {
		$('#suggestion-box').attr("style", "height: " + (COUNT_LI_ITEM * HEIGHT_LI_ITEM) + "px !important");
	}
	$('#suggestion-box').slideDown(50);
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
		//data: JSON.stringify(data),
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