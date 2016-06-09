$(function() {
	$('#btn-load-more').on('click', function() {

		var firstItem = $('#first_item').val();
		var currentPage = $('#current_page').val();

		var url = $('#get_job_hot').val();

		callAPI(url, 'POST', {"firstItem" : firstItem, "currentPage" : currentPage}, "showResultJobHot", true);
	});
});

function showResultJobHot(response) {

	console.log(response);
	if (FAIL == response.result) {
		alert(response.message);
	} else {
		var jobList = $('#job-list');

		var html = "";
		var jobListResponse = response.jobList;
		for (var index = 0; index < jobListResponse.length; index++) {

			var tempItem = "";
			var skills = jobListResponse[index].skillList;
			for (var i = 0; i < skills.length; i++) {
				tempItem += '<a class="chip">'+ skills[i].displayName + '</a>';
			}
			var item = '<div class="panel-content">\
							<div class="job-box">\
								<div class="location-sticky orange darken-1">' + jobListResponse[index].company.address.province + '</div>\
									<div class="row none-margin-bottom">\
									<div class="col m3 center hide-on-med-and-down">\
										<img src="' + jobListResponse[index].company.avatar + '" class="responsive-img company-logo">\
										<a href="#" class="btn margin-top-10 orange darken-1 waves-effect waves-light">\
											' + $('#text_company_follow').val() + '\
										</a>\
									</div>\
									<div class="col m9">\
										<div class="col m12 p-0">\
											<h1 class="col m9 p-0 title block-with-text">' + jobListResponse[index].title + '</h1>\
										</div>\
										<a href="#" class="company-name">' + jobListResponse[index].company.displayName + '</a>\
										<p class="work-location"><a href="#">' + jobListResponse[index].company.address.province + '</a></p>\
										<div class="job-info">\
											<div class="row">\
												<div class="col m6 none-padding-left">\
													<p>' + $('#text_title_salary').val() + ': \
														<span class="info">' + jobListResponse[index].minSalary + ' - ' + jobListResponse[index].maxSalary + '</span>\
													</p>\
												</div>\
												<div class="col m6 none-padding-left">\
													<span class="right">' + $('#text_title_post_date').val() + ': \
														<span class="info">' + jobListResponse[index].postDate + '</span>\
													</span>\
												</div>\
												<div class="col m6 none-padding-left">\
													<p>' + $('#text_title_major').val() + ': \
														<span class="info">' + jobListResponse[index].position.displayName + '</span>\
													</p>\
												</div>\
												<div class="col m6 none-padding-left">\
													<span class="right">' + $('#text_total_employee').val() + ': \
														<span class="info">' + jobListResponse[index].size + $('#text_title_people').val() + '</span>\
													</span>\
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
	}
}