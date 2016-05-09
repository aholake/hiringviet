$(function() {
	$('#menu-btn').click(function() {
		$('#dropdown-menu').toggle();
	});

	$(".menu-item-header").click(function() {
		$(this).next().toggle();
	});

	$('select').material_select();

	$("#job_invalidate").pickadate({
		selectMonths: true,
		selectYears: 15
	});
});

