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
		if (markupStr == "<p><br></p>") {
			$("#postTextStr").val("");
		}else {
			$("#postTextStr").val(markupStr);
		}
	});
	$("#postUpdateButton").click(function() {
		$("#summernotePostUpdate").summernote({
			dialogsInBody : true,
			dialogsFade : true,
			height : 600, // set editor height
			minHeight : 600, // set minimum height of editor
			maxHeight : null, // set maximum height of editor
			focus : true
		// Add fade effect on dialogs

		// set focus to editable area after initializing summernote
		});

		var val = $("#updatePostTextStr").val();
		$("#summernotePostUpdate").summernote("code", val);
	});
	$("#updatePostButton").click(function() {
		var markupStr = $("#summernotePostUpdate").summernote('code');
		if (markupStr == "<p><br></p>") {
			$("#postTextStr").val("");
		} else {
			$("#updatePostTextStr").val(markupStr);
		}
	});
});