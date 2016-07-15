/**
 * 
 */
$("#account-info").hide();

$("#nextButton").click(
		function() {
			if (checkCompanyInfoValidate()) {
				if ($("#company-info").is(":visible")
						&& !$("#account-info").is(":visible")) {
					$("#company-info").hide();
					$("#account-info").show();
				}
			} else {
				$("#newCompany").find(":submit").click();
			}
		});

function checkCompanyInfoValidate() {
	var displayNameValidate = $("#displayName")[0].checkValidity();
	var businessFieldValidate = $("#businessField")[0].checkValidity();
	var explicitAddressValidate = $("#explicitAddress")[0].checkValidity();
	var checkDropdownList = validateAllDropdownList();

	// console.log(validateAllDropdownList());

	if (!displayNameValidate || !businessFieldValidate
			|| !explicitAddressValidate || !checkDropdownList) {
		return false;
	}
	return true;
}

$("#backButton").click(
		function() {
			if ($("#account-info").is(":visible")
					&& !$("#company-info").is(":visible")) {
				$("#account-info").hide();
				$("#company-info").show();
			}
		});

function validateAllDropdownList() {
	var check = true;
	$("select").each(function(index, element) {
		console.log(index + " | " + element.value);
		if (element.value == null || element.value == -1) {
			check = false;
			return;
		}
	});
	console.log("To here");
	return check;
}