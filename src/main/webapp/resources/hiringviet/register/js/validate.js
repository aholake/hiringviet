/**
 * 
 */

function checkEmail() {
	var data = $("#email").val();
	$.ajax({
		url : "/rest/checkExistedEmail",
		type : "POST",
		contentType : "text/plain",
		data : data,
		dataType : "text",
		success : function(data) {
			if (data == "true") {
				console.log("Email Existed");
				$("#email").get(0).setCustomValidity(
						"Email has already existed");
			} else {
				console.log("Email not existed");
				$("#email").get(0).setCustomValidity("");
			}
		}
	});
};

$("#email").change(function() {
	if ($("#email").val().length > 0) {
		checkEmail();
	}
});

var password = $("#password");
var confirm_password = $("#rePassword");

function validatePassword() {
	if (password.val() != confirm_password.val()) {
		confirm_password.get(0).setCustomValidity("Password doesn't match");
	} else {
		confirm_password.get(0).setCustomValidity('');
	}
}

password.change(function() {
	validatePassword();
});

confirm_password.keyup(function() {
	validatePassword();
});