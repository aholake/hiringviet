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
});

function showCompanyList(companyList) {
	$.each( companyList, function( i, val ) {
		var html = '<li>\
						<input type="checkbox" class="filled-in" id="company-' + val + '"/>\
						<label for="company-' + val + '">' + val + '</label>\
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
						<input type="checkbox" class="filled-in" id="skill-' + val + '"/>\
						<label for="skill-' + val + '">' + val + '</label>\
					</li>';
		$('.filter-skill-list').append(html);
	});
}

function showCategoryList(categoryList) {
	$.each( categoryList, function( i, val ) {
		var html = '<li>\
						<input type="checkbox" class="filled-in" id="category-' + val + '"/>\
						<label for="category-' + val + '">' + val + '</label>\
					</li>';
		$('.filter-category-list').append(html);
	});
}

function showProvinceList(provinceList) {
	$.each( provinceList, function( i, val ) {
		var html = '<li>\
						<input type="checkbox" class="filled-in" id="province-' + val + '"/>\
						<label for="province-' + val + '">' + val + '</label>\
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
		var jobList = $('#job-list');
		$('#first_item').val(parseInt($('#first_item').val()) + MAX_RECORED);
		$('#current_page').val(parseInt($('#current_page').val()) + 1);
		var html = "";
		var jobListResponse = response.jobList;
		for (var index = 0; index < jobListResponse.length; index++) {

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
				tempItem += '<a class="chip">' + skills[i].displayName + '</a>';
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
			var item = '<div class="">\
							<div class="job-box">\
								<div class="location-sticky orange darken-1">' + jobListResponse[index].company.address.district.province.provinceName + '</div>\
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
										<a href="#" class="company-name">' + jobListResponse[index].company.displayName + '</a>\
										<p class="work-location"><a href="#">' + jobListResponse[index].company.address.district.province.provinceName + '</a></p>\
										<div class="job-info">\
											<div class="row">\
												<div class="col m6 none-padding-left">\
													<p><i class="material-icons prefix-icon">attach_money</i>' + $('#text_title_salary').val() + ': \
														<span class="info">' + jobListResponse[index].minSalary + ' - ' + jobListResponse[index].maxSalary + '</span>\
													</p>\
												</div>\
												<div class="col m6 none-padding-left">\
													<p class="right"><i class="material-icons prefix-icon">date_range</i>' + $('#text_title_post_date').val() + ': \
														<span class="info">' + jobListResponse[index].postDate + '</span>\
													</p>\
												</div>\
												<div class="col m6 none-padding-left">\
													<p><i class="material-icons prefix-icon">loyalty</i>' + $('#text_title_major').val() + ': \
														<span class="info">' + jobListResponse[index].position.displayName + '</span>\
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
		jobList.append(html);

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