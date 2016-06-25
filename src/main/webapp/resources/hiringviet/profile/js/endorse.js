$(document).ready(function(){
    $('.endorse-count').tooltip({delay: 50});

});

function onMouseOverEndorsingEvent(select, value) {
	$('#' + select).show();
}

function onMouseOutEndorsingEvent(select, value) {
	$('#' + select).hide();
}

function onClickEndorsingEvent(isAdd, value) {

	if (isAdd) {
		var html = '<li class="addEndord">\
			    		<a href="#">\
			    			<img class="img-full" src="http://cms.kienthuc.net.vn/zoomh/500/uploaded/nguyenanhson/2016_03_29/9/bo-ban-gao-hot-girl-xinh-dep-sang-my-kiem-tien-ty.jpg">\
			    		</a>\
			    	</li>';
		$('.endorsers-pics-' + value).prepend(html);
		$('.icon_add_endorse_' + value).hide();
		$('.icon_remove_endorse_' + value).show();
		$('.num-endorsements-' + value).html(parseInt($('.num-endorsements-' + value).html()) + 1);
	} else {
		$('.endorsers-pics-' + value + ' li:first-child').remove();
		$('.icon_add_endorse_' + value).show();
		$('.icon_remove_endorse_' + value).hide();
		$('.num-endorsements-' + value).html(parseInt($('.num-endorsements-' + value).html()) - 1);
	}
}