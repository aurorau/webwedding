
var arr;

$(document).ready(function() {
	loadCategoryDetails();
	loadImageCategoryDetails();
	$('#fileTableDivId').hide();
	$('#fileFormDivId').hide();
	$('#searchTableId').hide();
	$('#fileClearBtn').on('click', function(){
		clearValues();
	});
	radioDefault();
});

function hidePanel(){
	$('#searchTableId').hide();
	$('#fileFormDivId').hide();
	$('#fileTableDivId').hide();
}

function selectCategory(){
	var supplierRadioBtn = $('#supplierRadioBtn').is(':checked');
	var imageRadioBtn = $('#imageRadioBtn').is(':checked');
	
	if(supplierRadioBtn || imageRadioBtn) {
		$('#searchTableId').show();
		$('#fileImageCategoryId').val('');
		$('#fileCategoryId').val('');
		$('#fileCompanyId').val('');
		$('#fileTableDivId').hide();
		if(supplierRadioBtn) {
			$('#fileCategoryId').prop('disabled',false);
			$('#fileCompanyId').prop('disabled',false);
			$('#fileImageCategoryId').prop('disabled',true);
		} else {
			$('#fileImageCategoryId').prop('disabled',false);
			$('#fileCategoryId').prop('disabled',true);
			$('#fileCompanyId').prop('disabled',true);
		}
	} else {
		alert("Select a option");
	}
}
function radioDefault(){
	$('#supplierRadioBtn').prop('checked', false);
	$('#imageRadioBtn').prop('checked', false);
}
function loadImageCategoryDetails() {
	$.ajax({
        type: "GET",
        url: "imageCategoryController/getAllImageCategories",
        success: function(data) {
        	if(data.result != null) {
        		for(var x=0 ; x< data.result.length ; x++ ){
        			$('#fileImageCategoryId').append(new Option(''+data.result[x].icName+'',''+data.result[x].icid+''));
        			//$('#fileSearchCategoryId').append(new Option(''+data.result[x].scName+'',''+data.result[x].scid+''));
        		}
        	}
        }
	});
}

function categoryChange() {
	loadCompanyDetails();
}

function loadCategoryDetails() {
	$.ajax({
        type: "GET",
        url: "supplierCategorySetUp/getAllCategories",
        success: function(data) {
        	if(data.result != null) {
        		for(var x=0 ; x< data.result.length ; x++ ){
        			$('#fileCategoryId').append(new Option(''+data.result[x].scName+'',''+data.result[x].scid+''));
        			//$('#fileSearchCategoryId').append(new Option(''+data.result[x].scName+'',''+data.result[x].scid+''));
        		}
        	}
        }
	});
}
function loadCompanyDetails(){
	var categoryId =$('#fileCategoryId').val();
	var formdata = 'ajax=true&fileCategoryId='+categoryId;
	
	$.ajax({
        type: "GET",
        url: "companyDetailsController/getAllCompaniesByCategory",
        data: formdata,
        success: function(data) {
        	if(data.result != null) {
    			$('#fileCompanyId').html('');
    			$('#fileCompanyId').append(new Option('Select Company',''));
        		for(var x=0 ; x< data.result.length ; x++ ){
        			$('#fileCompanyId').append(new Option(''+data.result[x].companyName+'',''+data.result[x].scdid+''))
        		}
        	}
        }
	});
}
function loadFileDetailsTable() {
	var q =$('#fileSearchId').val();
	var fileCategoryId = $('#fileCategoryId').val();
	var fileCompanyId = $('#fileCompanyId').val();
	var fileImageCategoryId = $('#fileImageCategoryId').val();
	
	if(fileCompanyId ==  '') {
		fileCompanyId = 0;
	}
	
	if(fileCategoryId != '' || fileImageCategoryId !='') {
		$('#fileTableDivId').show();
		var formdata = 'ajax=true&q='+q+'&fileCategoryId='+fileCategoryId+'&fileCompanyId='+fileCompanyId+'&fileImageCategoryId='+fileImageCategoryId;
		$.ajax({
	        type: "GET",
	        url: "fileUploadController/getFileDetailsTable",
	        data: formdata,
	        success: function(data) {
	          $("#fileDynamicTable").html(data);
	       	  $("#fileDynamicTable").displayTagAjax();
	       	  removeTableText('fileDynamicTable');
	        }
		});
	} else {
		alert("Select at least a Category");
	}
	

}

function newFile() {
	$('#fileFormDivId').show();
	clearValues();
}

function clearValues() {
	$('#hiddenUFID').val('');
	$('#fileUploadDateId').val('');
	$('#fileTypeId').val('');
	//$('#fileCategoryId').val('');
	//$('#fileCompanyId').val('');
	$('#fileHiddenUrl').val('');
	arr = new Array();
	
}

function fileSave() {
	var hiddenUFID = $('#hiddenUFID').val();
	var fileUploadDateId= $('#fileUploadDateId').val();
	var fileTypeId = $('#fileTypeId').val();
	var fileCategoryId = $('#fileCategoryId').val();
	var fileCompanyId = $('#fileCompanyId').val();
	var fileHiddenUrl = $('#fileHiddenUrl').val();
	var fileImageCategoryId = $('#fileImageCategoryId').val();
	var ar = arr[0];

	if((fileCategoryId != '' || fileImageCategoryId !='') && arr.length>0) {
		
		
		var formdata = 'ajax=true&hiddenUFID='+hiddenUFID+'&fileUploadDateId='+fileUploadDateId+'&fileTypeId='+fileTypeId+'&fileCategoryId='+fileCategoryId+'&fileCompanyId='+fileCompanyId+'&ar='+ar+'&fileImageCategoryId='+fileImageCategoryId;
		$.ajax({
	        type: "POST",
	        url: "fileUploadController/saveFile",
	        data: formdata,
	        success: function(data) {
	        	
	        	if(data.status =='exist') {
	        		alert("File already uploaded");
	        	}
	        	loadFileDetailsTable();
	        	$('#fileFormDivId').hide();
	        	clearValues();
	        }
		});
	} else {
		alert("Fill required fieds");
	}
}

function fileDetailsDelete(ufid, url1) {
	var fileId = ufid;
	var fileUrl = url1;
	
	$.get('fileUploadController/deleteFile', {
		fileId : fileId,
		fileUrl : fileUrl
	}, function(data) {
		if(data.status == 'success') {
			loadFileDetailsTable();
		}else if(data.status == 'fail') {
			alert("Record in used, Unable to delete");
		}
	});
}

$(function () {
	var prefix = 'fiu';
    $('#fileupload').fileupload({
        dataType: 'json',
        url : "fileUploadController/upload?prefix="+prefix,
        done: function (e, data) {
            //$("tr:has(td)").remove();
            $.each(data.result, function (index, file) {
            		//$('#hiddenUFID').val(file.fileName);
            		console.log("File Name :"+file.fileName);
            		arr.push(file.fileName);
            		//$('#hiddenUFID').val(file.fileName);
/*                $("#uploaded-files").append(
                        $('<tr/>')
                        .append($('<td/>').text(file.fileName))
                        .append($('<td/>').text(file.fileSize))
                        .append($('<td/>').text(file.fileType))
                        .append($('<td/>').html("<a href='fileUploadController/get/"+index+"'>Download</a>"))
                        .append($('<td/>').html("<a href='fileUploadController/deleteFile/"+index+"'>Delete</a>"))
                        )//end $("#uploaded-files").append()
*/            }); 
        },
 
        progressall: function (e, data) {
            var progress = parseInt(data.loaded / data.total * 100, 10);
/*            $('#progress .bar').css(
                'width',
                progress + '%'
            );*/
        },
 
        //dropZone: $('#dropzone')
    });
});