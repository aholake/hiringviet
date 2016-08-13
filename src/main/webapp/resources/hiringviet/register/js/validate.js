/**
 * 
 */

var emailInput = $("#register-panel #email");

function checkEmail() {
	var data = emailInput.val();
	$.ajax({
		url : "/rest/checkExistedEmail",
		type : "POST",
		contentType : "text/plain",
		data : data,
		dataType : "text",
		success : function(data) {
			if (data == "true") {
				console.log("Email Existed");
				emailInput.get(0).setCustomValidity(
						"Email has already existed");
			} else {
				console.log("Email not existed");
				emailInput.get(0).setCustomValidity("");
			}
		}
	});
};

emailInput.change(function() {
	if (emailInput.val().length > 0) {
		console.log("check email");
		checkEmail();
	}
});

var password = $("#register-panel #password");
var confirm_password = $("#register-panel #rePassword");

function validatePassword() {
	if (password.val() === confirm_password.val()) {
		confirm_password.get(0).setCustomValidity('');
	} else {
		confirm_password.get(0).setCustomValidity("Password doesn't match");
	}
}

password.change(function() {
	validatePassword();
});

confirm_password.keyup(function() {
	validatePassword();
});