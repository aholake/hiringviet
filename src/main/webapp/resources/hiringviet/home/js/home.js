$(function() {
	$('#btn-load-more').on('click', function() {

		var firstItem = $('#first_item').val();
		var currentPage = $('#current_page').val();

		var url = $('#get_job_hot').val();

		callAPI(url, 'POST', {"firstItem" : firstItem, "currentPage" : currentPage}, "showResultJobHot", true);
	});
});

function showResultJobHot(response) {

	if (FAIL == response.result) {
		alert(response.message);
	} else {
		var jobList = $('#job-list');
		$('#first_item').val(parseInt($('#first_item').val()) + MAX_RECORED);
		$('#current_page').val(parseInt($('#current_page').val()) + 1);
		var html = "";
		var jobListResponse = response.jobList;
		for (var index = 0; index < jobListResponse.length; index++) {

			var tempItem = "";
			var skills = jobListResponse[index].skillSet;
			for (var i = 0; i < skills.length; i++) {
				tempItem += '<a class="chip">'+ skills[i].displayName + '</a>';
			}

			var nameClass = "";
			if (jobListResponse[index].company.isVip == VIP) {
				nameClass = HOT;
			} else {
				nameClass = NOT_HOT;
			}
			var item = '<div class="">\
							<div class="job-box">\
								<div class="location-sticky orange darken-1">' + jobListResponse[index].company.address.ward.district.province.provinceName + '</div>\
									<div class="row none-margin-bottom">\
									<div class="col m3 center hide-on-med-and-down">\
									<a href="/company/' + jobListResponse[index].company.id + '"><img src="' + jobListResponse[index].company.avatar + '" class="responsive-img company-logo"></a>\
										<a href="#" class="btn margin-top-10 orange darken-1 waves-effect waves-light">\
											' + $('#text_company_follow').val() + '\
										</a>\
									</div>\
									<div class="col m9">\
										<div class="col m12 p-0">\
											<h1 class="col m9 p-0 title block-with-text">\
												<a class="' + nameClass + '" href="/company/careers/' + jobListResponse[index].id + '">' + jobListResponse[index].title + '</a>\
											</h1>\
										</div>\
										<a href="#" class="company-name">' + jobListResponse[index].company.displayName + '</a>\
										<p class="work-location"><a href="#">' + jobListResponse[index].company.address.ward.district.province.provinceName + '</a></p>\
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
												<p class="col m12 none-padding-left text-justify block-with-text">\
													' + jobListResponse[index].description + '\
												</p>\
												<div class="col m12 none-padding-left margin-top-5">'
													+ tempItem +
												'</div>\
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
	}
}