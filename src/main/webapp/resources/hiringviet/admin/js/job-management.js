/**
 * 
 */
var jobUrl = '/admin/api/jobs';

var jobColumns = [ {
	data : "id"
}, {
	data : "title",
	render : function(data, type, full, meta) {
		return '<a target="_blank" href="/company/careers?jobId=' + full.id + '">' + data + '</a>';
	}
}, {
	data : "company.displayName",
	render : function(data, type, full, meta) {
		return '<a target="_blank" href="/company/'+ full.company.id +'">' + data + '</a>';
	}
}, {
	data : "postDate"
}, {
	data : "province.provinceName"
}, {
	data : "jobCategory"
} ];

$(document).ready(function() {
	var handleDataTableButtons = function() {
		if ($("#datatable-job").length) {
			$("#datatable-job").DataTable(initTable(jobUrl, jobColumns));
		}
	};

	TableManageButtons = function() {
		"use strict";
		return {
			init : function() {
				handleDataTableButtons();
			}
		};
	}();

	TableManageButtons.init();
});