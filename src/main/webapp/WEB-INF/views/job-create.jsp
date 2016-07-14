
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tạo việc làm</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value='/resources/hiringviet/jobcreate/jobcreate.css'/>" />
<link type="text/css" rel="stylesheet"
	href="<c:url value='/resources/common/css/materialize-tags.css'/>" />
<link type="text/css" rel="stylesheet"
	href="<c:url value='/resources/common/css/nouislider.min.css'/>" />
<link type="text/css" rel="stylesheet"
	href="<c:url value='/resources/common/css/nouislider.tooltips.css'/>" />
</head>
<body>
	<div class="card-panel">
		<div class="panel-title">ĐĂNG CÔNG VIỆC</div>
		<div class="panel-content">
			<form:form modelAttribute="newJob" action="/rest/job/add">
				<div class="row margin-10">
					<div class="input-field col m8 p-0">
						<form:input path="title" type="text" id="title" />
						<label for="title">Tiêu đề công việc</label>
					</div>
					<div class="input-field col m4">
						<form:select path="jobCategory.id" items="${jobCategories }"
							itemValue="id" itemLabel="categoryName"></form:select>
						<label>Nhóm công việc</label>
					</div>

					<div class="input-field col m12 p-0">
						<label for="tags">Các kỹ năng</label>
						<form:input path="skillListId" type="text" id="skills"
							data-role="materialtags" />
					</div>

					<div class="input-field col m6 p-0">
						<form:input path="workAddress.explicitAddress" type="text" />
						<label for="title">Nơi làm việc</label>
					</div>

					<div class="input-field col m3">
						<form:input path="size" type="number" min="1" max="500" />
						<label for="title">Số lượng cần tuyển</label>
					</div>

					<div class="input-field col m3">
						<form:select path="position.positionID" items="${positions }"
							itemValue="positionID" itemLabel="displayName"></form:select>
						<label>Vị trí công việc</label>
					</div>

					<div class="input-field col m4 p-0">
						<select id="countryAddress">
							<option value="-1" disabled selected><spring:message
									code="label.default.dropdown.none_value"></spring:message></option>
							<c:if test="${not empty countries }">
								<c:forEach items="${countries }" var="country">
									<option value="${country.id }">${country.countryName }</option>
								</c:forEach>
							</c:if>
						</select><label><spring:message
								code="label.register.company.input.country"></spring:message></label>
					</div>
					<div class="input-field col m4">
						<select id="provinceAddress">
							<option value="-1" disabled selected><spring:message
									code="label.default.dropdown.none_value"></spring:message></option>
						</select> <label><spring:message
								code="label.register.company.input.province"></spring:message></label>
					</div>

					<div class="input-field col m4">
						<spring:message code="label.default.dropdown.none_value"
							var="dropdown_none_value"></spring:message>
						<form:select id="districtAddress" path="workAddress.district.id">
							<form:option value="-1" label="${dropdown_none_value}"
								disabled="true"></form:option>
						</form:select>
						<label><spring:message
								code="label.register.company.input.district"></spring:message></label>
					</div>
					<form:input id="minSalary" type="hidden" path="minSalary" value="0" />
					<form:input id="maxSalary" type="hidden" path="maxSalary" value="0" />
					<div class="input field col m12 p-0">
						<p>Lương</p>
						<p>
							<input name="salary" type="radio" id="deal" checked="checked" />
							<label for="deal">Thỏa thuận</label>
						</p>
						<p>
							<input name="salary" type="radio" id="custom" /> <label
								for="custom">Tùy chọn(USD)</label>
						</p>
						<p id="salaryRange" class="range-field"></p>
					</div>


					<h5 class="center">Mô tả công việc</h5>
					<div class="input-field col m12 p-0">
						<form:textarea path="description" rows="10" cols="80"
							id="description" />
					</div>

					<h5 class="center">Yêu cầu</h5>
					<div class="input-field col m12 p-0">
						<form:textarea path="requirement" rows="10" cols="80"
							id="requirement" />
					</div>

					<div class="input-field col m3 p-0">
						<form:input path="expiredDate" type="date" class="datepicker" />
						<label for="expiredDate">Ngày hết hạn</label>
					</div>

					<div class="input-field col m3">
						<p>
							<input id="isPublish" type="checkbox" name="publish" checked="checked">
							<label for="isPublish">Đăng ngay</label>
						</p>
					</div>
					<div class="input-field col m12 center">
						<button type="submit" class="btn waves-effect waves-light orange">Đăng
							việc</button>
					</div>
				</div>
			</form:form>
		</div>
	</div>
	<script type="text/javascript"
		src="/resources/hiringviet/register/js/address_auto_fill.js"></script>
	<script type="text/javascript"
		src="/resources/common/js/materialize-tags.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/typeahead.js/0.10.4/typeahead.bundle.min.js"></script>
	<script type="text/javascript"
		src="/resources/common/js/ckeditor/ckeditor.js"></script>
	<script type="text/javascript"
		src="/resources/common/js/nouislider.min.js"></script>
	<script type="text/javascript" src="/resources/common/js/wNumb.js"></script>
	<script type="text/javascript">
		var skills = new Bloodhound({
			datumTokenizer : Bloodhound.tokenizers.obj
					.whitespace('displayName'),
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
		$('.datepicker').pickadate({
			selectMonths : true, // Creates a dropdown to control month
			selectYears : 15,
			formatSubmit : 'yyyy/mm/dd'
		// Creates a dropdown of 15 years to control year
		});
	</script>
</body>
</html>