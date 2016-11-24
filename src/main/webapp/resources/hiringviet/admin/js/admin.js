/**
 * 
 */
function initTable(apiUrl, columns) {
	var buttons = [ {
		extend : "copy",
		className : "btn-sm"
	}, {
		extend : "csv",
		className : "btn-sm"
	}, {
		extend : "excel",
		className : "btn-sm"
	}, {
		extend : "pdfHtml5",
		className : "btn-sm"
	}, {
		extend : "print",
		className : "btn-sm"
	} ];

	var obj = {
		ajax : {
			url : apiUrl,
			dataSrc : ''
		},
		columns : columns,
		dom : "Bfrtip",
		buttons : buttons,
		responsive : true
	};
	return obj;
}