var careersShow = new Array();
var companysShow = new Array();
var datePostShow = new Array();
var jobFunctionsShow = new Array();
var skillsShow = new Array();
var experiencesShow = new Array();
var salarysShow = new Array();
var provincesShow = new Array();

var FILTER_COMPANY_LIST = "filter-company-list";
var FILTER_SKILL_LIST = "filter-skill-list";
var FILTER_JOB_FUNCTION_LIST = "filter-position-list";
var FILTER_PROVINCE_LIST = "filter-province-list";
var FILTER_SALARY_LIST = "filter-salary-list";
var FILTER_DATE_POST_LIST = "filter-date-post-list";
	
$(function() {
	$('.slider').slider({
		height : 200,
		indicators : false,
		transition : 1000
	});

	$('#btn-load-more').on('click', function() {

		var firstItem = $('#first_item').val();
		var currentPage = $('#current_page').val();

		var url = $('#get_job_hot').val();

		callAPI(url, 'POST', {
			"firstItem" : firstItem,
			"currentPage" : currentPage
		}, "showResultJobHot", true);
	});

	showCompanyList(companyList);
	showPositionList(positionList);
	showSkillList(skillList);
	showCategoryList(categoryList);
	showProvinceList(provinceList);

	$('.data-post-radio').on('click', function() {

		var ulIdValue = $(this).parents('.filter-list').attr('id');

		var datePostValue = $(this).val();
		switch(datePostValue) {
		case '0':
			break;
		case '1':
			checkDatePort(ulIdValue, 1);
			break;
		case '2':
			checkDatePort(ulIdValue, 3);
			break;
		case '3':
			checkDatePort(ulIdValue, 5);
			break;
		case '4':
			checkDatePort(ulIdValue, 7);
			break;
		}

		// invisible all job
		$.each( jobList, function( i, val ) {
			$('#' + val).hide();
		});

		// show all job visible
		loadJobVisible();
	});

	$('.salary-radio').on('click', function() {

		var ulIdValue = $(this).parents('.filter-list').attr('id');

		var salaryValue = $(this).val();
		switch(salaryValue) {
		case '0':

			break;
		case '1':
			checkMinMaxSalary(ulIdValue, 0, 500);
			break;
		case '2':
			checkMinMaxSalary(ulIdValue, 500, 1000);
			break;
		case '3':
			checkMinMaxSalary(ulIdValue, 1000, 2000);
			break;
		case '4':
			checkMinMaxSalary(ulIdValue, 2000, 3000);
			break;
		case '5':
			checkMinMaxSalary(ulIdValue, 3000, Number.MAX_SAFE_INTEGER);
			break;
		}

		// invisible all job
		$.each( jobList, function( i, val ) {
			$('#' + val).hide();
		});

		// show all job visible
		loadJobVisible();
	});

	$('.filter-list').on('change', '.filled-in', function(e) {
		var idValue = $(this).attr('id');
		var ulIdValue = $(this).parents('.filter-list').attr('id');
		var currentListShow = checkedTypeFilter(ulIdValue);

		if ($(this).is(':checked')) {
			if ($(this).parent('li').find('label').text() == All) {
				var ul = $(this).parent('li').parent('ul').attr('id');

				$('#' + ul + ' li').not(':first').each(function() {
					$(this).find('.filled-in').attr('checked', false);
				});

				// visible all job
				$.each( jobList, function( i, val ) {
					$('#' + val).show();
				});

				for(var i = currentListShow.length; i--;) {
					currentListShow.splice(i, 1);
				}

			} else {

				$.each( jobList, function( i, idJob) {
					if ($('#' + idJob).find('.' + idValue).length > 0) {
						var checkContain = $.inArray(idJob, currentListShow);
						if (checkContain < 0) {
							currentListShow.push(idJob);
						}
					}
				});

				// unchecked All
				$(this).parent('li').parent('ul').find('li:first-child').find('.filled-in').attr('checked', false);

				// invisible all job
				$.each( jobList, function( i, val ) {
					$('#' + val).hide();
				});

				// show all job visible
				loadJobVisible();

			}  
		} else {

			$.each( jobList, function( i, idJob) {
				if ($('#' + idJob).find('.' + idValue).length > 0) {
					// remove value in list
					$.each( currentListShow, function( i, val ) {
						if (val == idJob) {
							currentListShow.splice(i, 1);
						}
					});
				}
			});

			// invisible all job
			$.each( jobList, function( i, val ) {
				$('#' + val).hide();
			});

			// show all job visible
			loadJobVisible();

			if (isEmptyJob()) {
				// visible all job
				$.each( jobList, function( i, val ) {
					$('#' + val).show();
				});
			}
		};
	});
});

function showCompanyList(companyList) {
	$.each( companyList, function( i, val ) {
		var html = '<li>\
						<input type="checkbox" class="filled-in" id="company-' + val.replace(' ', '') + '" />\
						<label for="company-' + val.replace(' ', '') + '">' + val + '</label>\
					</li>';
		$('.filter-company-list').append(html);
	});
}

function showPositionList(positionList) {
	$.each( positionList, function( i, val ) {
		var html = '<li>\
						<input type="checkbox" class="filled-in" id="position-' + val.replace(' ', '') + '"/>\
						<label for="position-' + val.replace(' ', '') + '">' + val + '</label>\
					</li>';
		$('.filter-position-list').append(html);
	});
}

function showSkillList(skillList) {
	$.each( skillList, function( i, val ) {
		var html = '<li>\
						<input type="checkbox" class="filled-in" id="skill-' + val.replace(' ', '') + '"/>\
						<label for="skill-' + val.replace(' ', '') + '">' + val + '</label>\
					</li>';
		$('.filter-skill-list').append(html);
	});
}

function showCategoryList(categoryList) {
	$.each( categoryList, function( i, val ) {
		var html = '<li>\
						<input type="checkbox" class="filled-in" id="category-' + val.replace(' ', '') + '"/>\
						<label for="category-' + val.replace(' ', '') + '">' + val + '</label>\
					</li>';
		$('.filter-category-list').append(html);
	});
}

function showProvinceList(provinceList) {
	$.each( provinceList, function( i, val ) {
		var html = '<li>\
						<input type="checkbox" class="filled-in" id="province-' + val.replace(' ', '') + '"/>\
						<label for="province-' + val.replace(' ', '') + '">' + val + '</label>\
					</li>';
		$('.filter-province-list').append(html);
	});
}

function showResultJobHot(response) {

	var newCategoryList = new Array();
	var newCompanyList = new Array();
	var newPositionList = new Array();
	var newSkillList = new Array();
	var newProvinceList = new Array();

	if (FAIL == response.result) {
		alert(response.message);
	} else {
		var jobListDiv = $('#job-list');
		$('#first_item').val(parseInt($('#first_item').val()) + MAX_RECORED);
		$('#current_page').val(parseInt($('#current_page').val()) + 1);
		var html = "";
		var jobListResponse = response.jobList;
		for (var index = 0; index < jobListResponse.length; index++) {

			var checkContain = $.inArray(jobListResponse[index].id, jobList);
			if (checkContain < 0) {
				jobList.push(jobListResponse[index].id);
			}

			var checkContain = $.inArray(jobListResponse[index].jobCategory.categoryName, categoryList);
			if (checkContain < 0) {
				newCategoryList.push(jobListResponse[index].jobCategory.categoryName);
				categoryList.push(jobListResponse[index].jobCategory.categoryName);
			}

			var checkContain = $.inArray(jobListResponse[index].company.displayName, companyList);
			if (checkContain < 0) {
				newCompanyList.push(jobListResponse[index].company.displayName);
				companyList.push(jobListResponse[index].company.displayName);
			}

			var checkContain = $.inArray(jobListResponse[index].position.displayName, positionList);
			if (checkContain < 0) {
				newPositionList.push(jobListResponse[index].position.displayName);
				positionList.push(jobListResponse[index].position.displayName);
			}

			var checkContain = $.inArray(jobListResponse[index].workAddress.district.province.provinceName, provinceList);
			if (checkContain < 0) {
				newProvinceList.push(jobListResponse[index].workAddress.district.province.provinceName);
				provinceList.push(jobListResponse[index].workAddress.district.province.provinceName);
			}

			var tempItem = "";
			var skills = jobListResponse[index].skillSet;
			for (var i = 0; i < skills.length; i++) {
				tempItem += '<a class="chip skill-' + skills[i].displayName.replace(' ', '') + '">' + skills[i].displayName + '</a>';
				var checkContain = $.inArray(skills[i].displayName, skillList);
				if (checkContain < 0) {
					newSkillList.push(skills[i].displayName);
					skillList.push(skills[i].displayName);
				}
			}

			var nameClass = "";
			if (jobListResponse[index].company.isVip == VIP) {
				nameClass = HOT;
			} else {
				nameClass = NOT_HOT;
			}
			var item = '<div class="job-item">\
							<div class="job-box" id="' + jobListResponse[index].id + '">\
								<div class="location-sticky orange darken-1 position-' + jobListResponse[index].workAddress.district.province.provinceName.replace(' ', '') + '">' + jobListResponse[index].workAddress.district.province.provinceName + '</div>\
									<div class="row none-margin-bottom">\
									<div class="col m3 center hide-on-med-and-down">\
									<a href="/company/' + jobListResponse[index].company.id + '"><img src="' + jobListResponse[index].company.avatar + '" class="responsive-img company-logo"></a>\
										<a href="#" class="btn margin-top-10 orange darken-1 waves-effect waves-light">'+ $('#text_company_follow').val() + '\
										</a>\
									</div>\
									<div class="col m9">\
										<div class="col m12 p-0">\
											<h1 class="col m9 p-0 title block-with-text">\
												<a class="' + nameClass + '" href="/company/careers/' + jobListResponse[index].id + '">' + jobListResponse[index].title + '</a>\
											</h1>\
										</div>\
										<a href="#" class="company-name company-' + jobListResponse[index].company.displayName.replace(' ', '') + '">' + jobListResponse[index].company.displayName + '</a>\
										<p class="work-location"><a href="#">' + jobListResponse[index].workAddress.district.province.provinceName + '</a></p>\
										<div class="job-info">\
											<div class="row">\
												<div class="col m6 none-padding-left">\
													<p><i class="material-icons prefix-icon">attach_money</i>' + $('#text_title_salary').val() + ': \
														<span class="info">' + jobListResponse[index].minSalary + ' - ' + jobListResponse[index].maxSalary + '</span>\
													</p>\
												</div>\
												<div class="col m6 none-padding-left">\
													<p class="right"><i class="material-icons prefix-icon">date_range</i>' + $('#text_title_post_date').val() + ': \
														<span class="info datePost">' + jobListResponse[index].postDate + '</span>\
													</p>\
												</div>\
												<div class="col m6 none-padding-left">\
													<p><i class="material-icons prefix-icon">loyalty</i>' + $('#text_title_major').val() + ': \
														<span class="info position-' + jobListResponse[index].position.displayName.replace(' ', '') + '">' + jobListResponse[index].position.displayName + '</span>\
													</p>\
												</div>\
												<div class="col m6 none-padding-left">\
													<p class="right"><i class="material-icons prefix-icon">people</i>' + $('#text_total_employee').val() + ': \
														<span class="info">' + jobListResponse[index].size + $('#text_title_people').val() + '</span>\
													</p>\
												</div>\
											</div>\
											<div class="row">\
												<p class="col m12 none-padding-left text-justify block-with-text">' + jobListResponse[index].description + '\
												</p>\
												<div class="col m12 none-padding-left margin-top-5">' + tempItem + '</div>\
											</div>\
										</div>\
									</div>\
								</div>\
							</div>\
						</div>';
			html += item;
		}
		jobListDiv.append(html);

		if (parseInt($('#max_item').val()) > jobListResponse.length) {
			$('#btn-load-more').attr('disabled', 'disabled');
			$('#btn-load-more').addClass('disabled');
		}

		showCompanyList(newCompanyList);
		showPositionList(newPositionList);
		showSkillList(newSkillList);
		showCategoryList(newCategoryList);
		showProvinceList(newProvinceList);
	}
}

function checkDatePort(ulIdValue, numberDate) {

	var currentListShow = checkedTypeFilter(ulIdValue);

	for(var i = currentListShow.length; i--;) {
		currentListShow.splice(i, 1);
	}

	$.each( jobList, function( i, idJob) {
		var datePost = $('#' + idJob).find('.datePost').text()
		if (parseInt(days_between(parseDate(datePost), getNow())) <= numberDate) {
			var checkContain = $.inArray(idJob, currentListShow);
			if (checkContain < 0) {
				currentListShow.push(idJob);
			}
		}
	});
}

function checkMinMaxSalary(ulIdValue, minSalary, maxSalary) {

	var currentListShow = checkedTypeFilter(ulIdValue);

	for(var i = currentListShow.length; i--;) {
		currentListShow.splice(i, 1);
	}

	$.each( jobList, function( i, idJob) {
		if (parseInt($('#' + idJob).find('.maxSalary').text()) >= minSalary && parseInt($('#' + idJob).find('.maxSalary').text()) <= maxSalary) {
			var checkContain = $.inArray(idJob, currentListShow);
			if (checkContain < 0) {
				currentListShow.push(idJob);
			}
		}
	});
}

function checkedTypeFilter(value) {

	switch(value) {
	case FILTER_COMPANY_LIST:
		return companysShow;
	case FILTER_SKILL_LIST:
		return skillsShow;
	case FILTER_JOB_FUNCTION_LIST:
		return jobFunctionsShow;
	case FILTER_PROVINCE_LIST:
		return provincesShow;
	case FILTER_SALARY_LIST:
		return salarysShow;
	case FILTER_DATE_POST_LIST:
		return datePostShow;
	}
}

function isEmptyJob() {

	if (companysShow.length == 0 && skillsShow.length == 0
			&& jobFunctionsShow.length == 0 && provincesShow.length == 0
			&& salarysShow.length == 0 && datePostShow.length == 0) {
		return true;
	}

	return false;
}

function loadJobVisible() {

	console.log(companysShow);
	console.log(skillsShow);
	console.log(jobFunctionsShow);
	console.log(provincesShow);
	console.log(salarysShow);
	console.log(datePostShow);

	if (companysShow.length > 0) {
		$.each( companysShow, function( i, companyJobId ) {
			$('#' + companyJobId).show();
			if (skillsShow.length > 0) {
				var checkContain = $.inArray(companyJobId, skillsShow);
				if (checkContain < 0) {
					$('#' + companyJobId).hide();
				}
			}

			if (jobFunctionsShow.length > 0) {
				var checkContain = $.inArray(companyJobId, jobFunctionsShow);
				if (checkContain < 0) {
					$('#' + companyJobId).hide();
				}
			}

			if (provincesShow.length > 0) {
				var checkContain = $.inArray(companyJobId, provincesShow);
				if (checkContain < 0) {
					$('#' + companyJobId).hide();
				}
			}

			if (salarysShow.length > 0) {
				var checkContain = $.inArray(companyJobId, salarysShow);
				if (checkContain < 0) {
					$('#' + companyJobId).hide();
				}
			}

			if (datePostShow.length > 0) {
				var checkContain = $.inArray(companyJobId, datePostShow);
				if (checkContain < 0) {
					$('#' + companyJobId).hide();
				}
			}
		});
	} else {
		if (skillsShow.length > 0 && jobFunctionsShow.length == 0 && provincesShow.length == 0 && salarysShow.length == 0 && datePostShow.length == 0) {
			$.each(skillsShow, function(i, skillJobId) {
				$('#' + skillJobId).show();
			});
		} else {
			if (skillsShow.length > 0) {
				filterByInvisible(skillsShow);

				if (jobFunctionsShow.length > 0) {
					filterByVisible(jobFunctionsShow);
				}

				if (provincesShow.length > 0) {
					filterByVisible(provincesShow);
				}

				if (salarysShow.length > 0) {
					filterByVisible(salarysShow);
				}

				if (datePostShow.length > 0) {
					filterByVisible(datePostShow);
				}
			}
		}

		if (jobFunctionsShow.length > 0 && skillsShow.length == 0 && provincesShow.length == 0 && salarysShow.length == 0 && datePostShow.length == 0) {
			$.each(jobFunctionsShow, function(i, functionJobId) {
				$('#' + functionJobId).show();
			});
		} else {
			if (jobFunctionsShow.length > 0 && skillsShow.length == 0) {
				filterByInvisible(jobFunctionsShow);

				if (provincesShow.length > 0) {
					filterByVisible(provincesShow);
				}

				if (salarysShow.length > 0) {
					filterByVisible(salarysShow);
				}

				if (datePostShow.length > 0) {
					filterByVisible(datePostShow);
				}
			}
		}

		if (provincesShow.length > 0 && skillsShow.length == 0 && jobFunctionsShow.length == 0 && salarysShow.length == 0 && datePostShow.length == 0) {
			$.each(provincesShow, function(i, provinceJobId) {
				$('#' + provinceJobId).show();
			});
		} else {
			if (provincesShow.length > 0 && skillsShow.length == 0 && jobFunctionsShow.length == 0) {
				filterByInvisible(provincesShow);

				if (salarysShow.length > 0) {
					filterByVisible(salarysShow);
				}

				if (datePostShow.length > 0) {
					filterByVisible(datePostShow);
				}
			}
		}

		if (salarysShow.length > 0 && skillsShow.length == 0 && jobFunctionsShow.length == 0 && provincesShow.length == 0 && datePostShow.length == 0) {
			$.each(salarysShow, function(i, salaryJobId) {
				$('#' + salaryJobId).show();
			});
		} else {
			if (salarysShow.length > 0 && skillsShow.length == 0 && jobFunctionsShow.length == 0 && provincesShow.length == 0) {
				filterByInvisible(provincesShow);

				if (datePostShow.length > 0) {
					filterByVisible(datePostShow);
				}
			}
		}

		if (datePostShow.length > 0 && skillsShow.length == 0 && jobFunctionsShow.length == 0 && provincesShow.length == 0 && salarysShow.length == 0) {
			$.each(datePostShow, function(i, datePostJobId) {
				$('#' + datePostJobId).show();
			});
		} else {
			if (datePostShow.length > 0 && skillsShow.length == 0 && jobFunctionsShow.length == 0 && provincesShow.length == 0 && salarysShow.length == 0) {
				filterByInvisible(datePostShow);

			}
		}
	}

}

function filterByVisible(list) {
	$.each( jobList, function( j, idJob) {
		if ($('#' + idJob).is(':visible')) {
			var checkContain = $.inArray(idJob, list);
			if (checkContain < 0) {
				$('#' + idJob).hide();
			} else {
				$('#' + idJob).show();
			}
		}
	});
}

function filterByInvisible(list) {
	$.each( jobList, function( j, idJob) {
		var checkContain = $.inArray(idJob, list);
		if (checkContain < 0) {
			$('#' + idJob).hide();
		} else {
			$('#' + idJob).show();
		}
	});
}

function parseDate(str) {

	var dateParts = str.split("-");

	if (dateParts.length != 3) {
		return null;
	}

	var year = dateParts[0];
	var month = dateParts[1];
	var day = dateParts[2];

	if (isNaN(day) || isNaN(month) || isNaN(year)) {
		return null;
	}

	var result = new Date(year, (month - 1), day);

	return result;
}

function getNow() {
	var today = new Date();
	var day = today.getDate();
	var month = today.getMonth() + 1;
	var year = today.getFullYear();

	var result = new Date(year, (month - 1), day);

	return result;
}

function days_between(date1, date2) {

    // The number of milliseconds in one day
    var ONE_DAY = 1000 * 60 * 60 * 24;

    // Convert both dates to milliseconds
    var date1_ms = date1.getTime();
    var date2_ms = date2.getTime();

    // Calculate the difference in milliseconds
    var difference_ms = Math.abs(date1_ms - date2_ms);

    // Convert back to days and return
    return Math.round(difference_ms/ONE_DAY);
}