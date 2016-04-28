$(function() {
	$("#job-info").hide();
})
function goToJob() {
	if(!$("#job-info").is(":visible")) {
		$("#company-info").hide();
		$("#job-info").show();
	}
}
function backToCompany() {
	if($("#job-info").is(":visible")) {
		$("#company-info").show();
		$("#job-info").hide();
	}
}