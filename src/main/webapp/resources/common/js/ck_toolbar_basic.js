/**
 * 
 */
CKEDITOR.editorConfig = function(config) {
	config.toolbarGroups = [ {
		name : 'paragraph',
		groups : [ 'list', 'indent', 'blocks', 'align', 'bidi', 'paragraph' ]
	}, {
		name : 'basicstyles',
		groups : [ 'basicstyles', 'cleanup' ]
	}, {
		name : 'document',
		groups : [ 'mode', 'document', 'doctools' ]
	}, {
		name : 'clipboard',
		groups : [ 'clipboard', 'undo' ]
	}, {
		name : 'editing',
		groups : [ 'find', 'selection', 'spellchecker', 'editing' ]
	}, {
		name : 'forms',
		groups : [ 'forms' ]
	}, {
		name : 'links',
		groups : [ 'links' ]
	}, {
		name : 'tools',
		groups : [ 'tools' ]
	}, '/', {
		name : 'insert',
		groups : [ 'insert' ]
	}, '/', {
		name : 'colors',
		groups : [ 'colors' ]
	}, {
		name : 'styles',
		groups : [ 'styles' ]
	}, {
		name : 'others',
		groups : [ 'others' ]
	}, {
		name : 'about',
		groups : [ 'about' ]
	} ];

	config.removeButtons = 'Source,Save,Templates,Cut,Form,Checkbox,Radio,TextField,Textarea,Select,Button,ImageButton,HiddenField,Strike,BidiLtr,BidiRtl,Language,Anchor,Image,Flash,Table,HorizontalRule,Smiley,SpecialChar,PageBreak,Iframe,About,FontSize,Font,Format,Styles,NewPage,Replace,Find,SelectAll,Scayt,TextColor,BGColor';
};