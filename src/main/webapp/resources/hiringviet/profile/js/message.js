$(function() {

	$('.messageModal').on('click', function(event) {

		callAPI($('#url_get_owner_message_list').val(), 'POST', {id: $("#account_id").val()}, "showMessageList", true);
	});
	
	$('.messageTable .body').on('click', '.messageDetailModal', function() {

		var parent = $('.messageDetailModal').parents('tr');
		var messageId = $(parent).find('#messageId').val();
		var messateTitle = $(parent).find('#messateTitle').val();
		var messateSender = $(parent).find('#messateSender').val();
		var messateContent = $(parent).find('#messateContent').val();
		var dateTime = $(parent).find('#dateTime').val();
		$('#messageDetailModal .messateTitle').html(messateTitle);
		$('#messageDetailModal .messateContent').html(messateContent);
		$('#messageDetailModal .dateTime').html(dateTime);
		$('#messageDetailModal .messateSender').html(messateSender);
	});
})

function showMessageList(response) {

	console.log(response);
	var html = "";
	$.each(response, function(index, item) {
		html += '<tr>\
					<td>\
						<input type="hidden" id="messageId" value="' + item.id + '"/>\
						<input type="hidden" id="messateTitle" value="' + item.title + '"/>\
						<input type="hidden" id="messateSender" value="' + item.emailSender + '"/>\
						<input type="hidden" id="messateContent" value="' + item.content + '"/>\
						<input type="hidden" id="dateTime" value="' + item.dateTime + '"/>\
						<input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" />\
						 <label for="filled-in-box"></label>\
					</td>\
					<td>\
						<a href="#messageDetailModal" class="messageDetailModal">' + item.title + '</a>\
					</td>\
					<td><span class="dateTime">' + item.dateTime + '</span></td>\
				</tr>';
	});
	$('.messageTable .body').html('');
	$('.messageTable .body').append(html);
	$('.messageDetailModal').leanModal();
}