$(function() {
	$('#btn-sign-in').on('click', function(event) {
		reset_error_message();
		if (!checkValidate()) {
			var remember_cb = false;
			if($("#remember_cb").is(":checked")) {
				remember_cb = true;
			}
			var data = {
					email: $('#txtEmail').val(),
					password: $('#txtPassword').val(),
					isRemembered: remember_cb
			}
			callAPI($('#url_check_account').val(), 'POST', data, 'resultSignIn', true);
		}
		event.preventDefault();
	});
});

function resultSignIn(response) {
	if (response.result == FAIL) {
		$('#email_or_password_wrong').show();
		$('#txtEmail').css('border-bottom-color', BORDER_INPUT);
		$('#txtPassword').css('border-bottom-color', BORDER_INPUT);
	} else {
		redirectTo($('#url_redirect_page').val());
	}
}

/**
 * Reset validate message
 * 
 */
function reset_error_message() {

	var arrErrorMess = ["#email_requierd", "#password_requierd", "#email_max_length",
	                    "#password_max_length", "#email_or_password_wrong"];
	var arrErrorInput = ["#txtEmail", "#txtPassword"];

	resetErrorMessage(arrErrorMess);
	resetFocusInput(arrErrorInput, BORDER_INPUT);
}

function checkValidate() {
	// Check required field
	if (isInValidRequired("#txtEmail", "#email_requierd", BORDER_INPUT)){
		return true;
	} else {
		if (isInValidRequired("#txtPassword", "#password_requierd", BORDER_INPUT)) {
			return true;
		} else {
			if (isInMaxLength("#txtEmail", "#email_max_length", BORDER_INPUT, MAX_LENGTH_VALUE_100)) {
				return true;
			} else {
				if (isInMaxLength("#txtPassword", "#password_max_length", BORDER_INPUT, MAX_LENGTH_VALUE_100)) {
					return true;
				}
			}
		}
	}
	return false;
}