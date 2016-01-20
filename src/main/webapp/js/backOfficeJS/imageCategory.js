
var arr;

$(document).ready(function() {
	$('#imageCategoryFormDivId').hide();
	clearValues();
	loadImageCategoryTable();
})


function loadImageCategoryTable() {
	var q =$('#imageCategorySearchId').val();
	
	var formdata = 'ajax=true&q='+q;
	$.ajax({
        type: "GET",
        url: "imageCategoryController/getImageCategoryTable",
        data: formdata,
        success: function(data) {
          $("#imageCategoryDynamicTable").html(data);
       	  $("#imageCategoryDynamicTable").displayTagAjax();
       	  removeTableText('imageCategoryDynamicTable');
        }
	});
}

function newImageCategory() {
	$('#imageCategoryFormDivId').show();
	clearValues();
}

function clearValues() {
	$('#hiddenICID').val('');
	$('#imageCategoryTypeId').val('');
	$('#imageCategoryNameId').val('');
	$('#imageCategorySearchId').val('');
	$('#fileHiddenUrl').val('');
	arr = new Array();
}

function imageCategorySave() {
	var imageLogoUrl ;
	if(arr[0] != null && arr[0] !=''){
		imageLogoUrl = arr[0];
	} else if($('#fileHiddenUrl').val() !='') {
		imageLogoUrl = $('#fileHiddenUrl').val();
	} else {
		imageLogoUrl = 'No Logo';
	}
	console.log(imageLogoUrl);
	var hiddenICID = $('#hiddenICID').val();
	var imageCategoryType = $('#imageCategoryTypeId').val();
	var imageCategoryName = $('#imageCategoryNameId').val();
	
	$.post('imageCategoryController/saveImageCategory', {
		hiddenICID : hiddenICID,
		imageCategoryType : imageCategoryType,
		imageCategoryName : imageCategoryName,
		imageLogoUrl : imageLogoUrl
	}, function(data) {
		if (data.status == 'saved' ||data.status == 'updated') {
			$('#imageCategoryFormDivId').hide();
			loadImageCategoryTable();
			clearValues();
		} else {
			console.log(data.status);
		}
	});
}

function imageCategoryEdit(icid) {
	newImageCategory();
	var hiddenICID = icid;
	$('#hiddenICID').val(icid);
	
	$.get('imageCategoryController/getImageCategoryByICID', {
		hiddenICID : hiddenICID
	}, function(data) {
		if (data.status == 'success') {
			if(data.result != null) {
				$('#imageCategoryTypeId').val(data.result.icType);
				$('#imageCategoryNameId').val(data.result.icName);
				$('#fileHiddenUrl').val(data.result.icLogoUrl);
			}
		} else {
			console.log(data.status);
		}
	});
}

function imageCategoryDelete(icid){
	var hiddenICID = icid;
	$('#hiddenICID').val(icid);
	
	$.get('imageCategoryController/imageCategoryDelete', {
		hiddenICID : hiddenICID
	}, function(data) {
		if(data.status == 'success') {
			$('#imageCategoryFormDivId').hide();
			loadImageCategoryTable();
			clearValues();
		}else if(data.status == 'fail') {
			alert("Record in used, Unable to delete");
		}
	});
}
$(function () {
	var prefix = 'icu';
    $('#fileupload').fileupload({
        dataType: 'json',
        url : "fileUploadController/upload?prefix="+prefix,
        done: function (e, data) {
            $.each(data.result, function (index, file) {
            		arr.push(file.fileName);
           }); 
        },
 
        progressall: function (e, data) {
            var progress = parseInt(data.loaded / data.total * 100, 10);
        },
    });
});