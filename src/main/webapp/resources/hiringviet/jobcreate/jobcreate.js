var skills = new Bloodhound({
	datumTokenizer : Bloodhound.tokenizers.obj.whitespace('displayName'),
	queryTokenizer : Bloodhound.tokenizers.whitespace,
	prefetch : '/rest/getSkillList'
});
skills.initialize();

var elt = $('#skills');
elt.materialtags({
	itemValue : 'id',
	itemText : 'displayName',
	typeaheadjs : {
		name : 'skills',
		displayKey : 'displayName',
		source : skills.ttAdapter()
	}
});
CKEDITOR.replace("description");
CKEDITOR.replace("requirement");

var slider = document.getElementById('salaryRange');

noUiSlider.create(slider, {
	start : [ 500, 4000 ],
	tooltips : [ true, wNumb({
		decimals : 0
	}) ],
	range : {
		'min' : [ 0 ],
		'10%' : [ 500, 500 ],
		'50%' : [ 4000, 1000 ],
		'max' : [ 10000 ]
	}
});

slider.noUiSlider.on('update', function() {
	var values = slider.noUiSlider.get();
	console.log("Update" + values);
	$("#minSalary").val(values[0]);
	$("#maxSalary").val(values[1]);
});

$("#salaryRange").hide();

$("input[type='radio'][name='salary']").change(function() {
	var option = $(this).attr("id");
	console.log(option);
	if (option == "deal") {
		$("#salaryRange").hide();
		$("#minSalary").val(0);
		$("#maxSalary").val(0);
	} else {
		$("#salaryRange").show();
	}
});