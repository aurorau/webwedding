
var arr;

$(document).ready(function() {
	loadCategoryDetails();
	$('#fileTableDivId').hide();
	$('#fileFormDivId').hide();
	$('#fileClearBtn').on('click', function(){
		clearValues();
	});
	
});
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
        			$('#fileSearchCategoryId').append(new Option(''+data.result[x].scName+'',''+data.result[x].scid+''));
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
	
	if(fileCompanyId ==  '') {
		fileCompanyId = 0;
	}
	
	if(fileCategoryId != '') {
		$('#fileTableDivId').show();
		var formdata = 'ajax=true&q='+q+'&fileCategoryId='+fileCategoryId+'&fileCompanyId='+fileCompanyId;
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
	
}

function fileSave() {
	var hiddenUFID = $('#hiddenUFID').val();
	var fileUploadDateId= $('#fileUploadDateId').val();
	var fileTypeId = $('#fileTypeId').val();
	var fileCategoryId = $('#fileCategoryId').val();
	var fileCompanyId = $('#fileCompanyId').val();
	var fileHiddenUrl = $('#fileHiddenUrl').val();
	var ar = arr;

	if(fileCategoryId != '' && arr.length>0) {
		
		
		var formdata = 'ajax=true&hiddenUFID='+hiddenUFID+'&fileUploadDateId='+fileUploadDateId+'&fileTypeId='+fileTypeId+'&fileCategoryId='+fileCategoryId+'&fileCompanyId='+fileCompanyId+'&ar='+ar;
		$.ajax({
	        type: "POST",
	        url: "fileUploadController/saveFile",
	        data: formdata,
	        success: function(data) {
	        	loadFileDetailsTable();
	        	$('#fileFormDivId').hide();
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
			
		}
	});
}

$(function () {
	arr = new Array();
    $('#fileupload').fileupload({
        dataType: 'json',
 
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