var MAX_UPLOAD_FILE_SIZE = 10485760;

$(function() {
	var _URL = window.URL || window.webkitURL;
	$('#new-avatar-image').change(function(event) {
		
		var file = this.files[0];
		var name = file.name;
		var reader = new FileReader();
		var check = true;
		if (file.type.indexOf("image") == -1) {
			alert("File not supported");
			check = false;
		} else if (file.size > MAX_UPLOAD_FILE_SIZE) {
			alert("Image too big (max 10mb)");
			check = false;
		}

		if (check) {

			reader.onload = function(e) {
				var image = new Image();

				var width, height;
				image.onload = function() {
					width = this.width;
					height = this.height;
				};

				image.src = e.target.result;
			};
			reader.readAsDataURL(file);
		}
		
		if (reader != null) {
			addEventHandler(reader, 'loadend', function(e, file) {
				var bin = reader.result;
				$('#current-avatar-image').attr("src", bin);
				$('#current-avatar-image').attr("alt", name);
			});
		}
	});
});

function addEventHandler(obj, evt, handler) {
	if (obj.addEventListener) {
		obj.addEventListener(evt, handler, false);
	} else if (obj.attachEvent) {
		obj.attachEvent('on' + evt, handler);
	} else {
		obj['on' + evt] = handler;
	}
}