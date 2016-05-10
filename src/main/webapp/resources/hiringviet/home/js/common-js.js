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
/**
 *  refresh page
 */
function refreshPage() {
	location.reload();
}