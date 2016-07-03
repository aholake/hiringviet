
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
</head>
<body>
	<div class="card-panel">
		<div class="panel-title">ĐĂNG CÔNG VIỆC</div>
		<div class="panel-content">
			<form:form>
				<div class="row margin-10">
					<div class="input-field col m8 p-0">
						<input id="title" type="text" /> <label for="title">Tiêu
							đề công việc</label>
					</div>
					<div class="input-field col m4">
						<select>
							<option value="" disabled selected>Choose your option</option>
							<option value="1">Option 1</option>
							<option value="2">Option 2</option>
							<option value="3">Option 3</option>
						</select> <label>Nhóm công việc</label>
					</div>
					<div class="input-field col m12 p-0">
						<label for="tags">Các kỹ năng</label><input type="text"
							name="tags" id="skills" value="" data-role="materialtags" />
					</div>
					<div class="input-field col s12">
						<textarea id="description" class="materialize-textarea"></textarea>
						<label for="description">Mô tả công việc</label>
					</div>
				</div>
			</form:form>
		</div>
	</div>

	<script type="text/javascript"
		src="/resources/common/js/materialize-tags.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/typeahead.js/0.10.4/typeahead.bundle.min.js"></script>

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
	</script>
</body>
</html>