var strings = new Array();
strings['label.default.dropdown.none_value'] = "<spring:message code='label.default.dropdown.none_value' javaScriptEscape='true'>";

$("#countryAddress").change(
		function() {
			var data = $(this).val();
			callAPI('/rest/getProvincesByCountry', 'POST', data,
					'processGetProvinces', false);
		});

$("#provinceAddress").change(
		function() {
			var data = $(this).val();
			callAPI('/rest/getDistrictsByProvince', 'POST', data,
					'processGetDistricts', false);
		});

function processGetProvinces(response) {
	console.log(response);
	$("#provinceAddress").empty().append(
			"<option value='-1' disabled selected></option>");
	$.each(response, function(i, province) {
		console.log("Province: " + province);
		$("#provinceAddress").append($('<option>', {
			value : province.id,
			text : province.provinceName
		}));
	});
	$('#provinceAddress').material_select();
}

function processGetDistricts(response) {
	console.log(response);
	$("#districtAddress").empty().append(
			strings["label.default.dropdown.none_value"]);
	$.each(response, function(i, district) {
		console.log("District: " + district);
		$("#districtAddress").append($('<option>', {
			value : district.id,
			text : district.districtName
		}));
	});
	$('#districtAddress').material_select();
}