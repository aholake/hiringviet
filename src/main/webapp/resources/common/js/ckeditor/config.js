/**
 * @license Copyright (c) 2003-2015, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here. For example:
	config.language = 'fr';
	config.uiColor = '#AADC6E';
	config.toolbar = [
                      ['Source','Preview','Templates'],
                      ['Cut','Copy','Paste','PasteText','PasteFromWord','-','Print', 'SpellChecker', 'Scayt'],
                      ['Undo','Redo','-','Find','Replace','-','SelectAll','RemoveFormat'],
                      '/',
                      ['Bold','Italic','Underline','Strike','-','Subscript','Superscript'],
                      ['NumberedList','BulletedList','-','Outdent','Indent','Blockquote','CreateDiv'],
                      ['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock'],
                      ['BidiLtr', 'BidiRtl' ],
                      ['Link','Unlink','Anchor'],
                      ['Image','Flash','Table','HorizontalRule','Smiley','SpecialChar','PageBreak','Iframe'],
                      '/',
                      ['Styles','Format','Font','FontSize'],
                      ['TextColor','BGColor'],
                      ['Maximize','ShowBlocks','Syntaxhighlight']
         ];
	config.filebrowserBrowseUrl = 'http://localhost:8080/ckfinder/ckfinder.html';
	config.filebrowserImageBrowseUrl = 'http://localhost:8080/ckfinder/ckfinder.html?type=Images';
	config.filebrowserFlashBrowseUrl = 'http://localhost:8080/ckfinder/ckfinder.html?type=Flash';
	config.filebrowserUploadUrl = 'http://localhost:8080/ckfinder/core/connector/php/connector.php?command=QuickUpload&type=Files';
	config.filebrowserImageUploadUrl = 'http://localhost:8080/ckfinder/core/connector/php/connector.php?command=QuickUpload&type=Images';
	config.filebrowserFlashUploadUrl = 'http://localhost:8080/ckfinder/core/connector/php/connector.php?command=QuickUpload&type=Flash';

};
