/**
 * Account management
 */

var memberUrl = "/admin/api/members";
var companyUrl = "/admin/api/companies";

var memberColumns = [ {
	data : "id"
}, {
	data : "email",
	render: function(data, type, full, meta) {
		return '<a href="http://localhost:8888/profile?memberId=' + full.id +'">' + data + '</a>';
	}
}, {
	data : "firstName"
}, {
	data : "lastName"
}, {
	data : "active"
} ];

var companyColumns = [ {
	data : "id"
}, {
	data : "email"
}, {
	data : "displayName",
	render: function(data, type, full, meta) {
		return '<a href="/company/' + full.id + '">' + data + '</a>';
	}
}, {
	data : "businessField"
}, {
	data : "status"
} ];

$(document).ready(
		function() {
			var handleDataTableButtons = function() {
				if ($("#datatable-member").length) {
					$("#datatable-member").DataTable(
							initTable(memberUrl, memberColumns));
				}

				if ($("#datatable-company").length) {
					$("#datatable-company").DataTable(
							initTable(companyUrl, companyColumns));
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