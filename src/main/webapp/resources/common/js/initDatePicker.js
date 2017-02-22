$('.birthdate').pickadate({
	selectMonths : true, // Creates a dropdown to control month
	selectYears : 15,
	max: getMaxDate(),
	format : 'dd/mm/yyyy',
	formatSubmit : 'dd/mm/yyyy'
});

function getMaxDate() {
	var toYear = new Date().getYear() + 1900;
	return new Date(toYear - 18, 12, 31);
}