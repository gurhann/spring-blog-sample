$(document).ready(function() {
	$("#summernote").summernote({
		height : 600, // set editor height
		minHeight : 600, // set minimum height of editor
		maxHeight : null, // set maximum height of editor
		focus : true
	// set focus to editable area after initializing summernote
	});
	
	$("#createPostButton").click(function() {
		var markupStr = $('#summernote').summernote('code');
		$("#postTextStr").val(markupStr);
	});
});