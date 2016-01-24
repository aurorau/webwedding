
var globalEdit;

$(document).ready(function() {
	$('#imageCategoryFormDivId').hide();
	clearValues();
	loadImageCategoryTable();
	globalEdit = false;
})


function loadImageCategoryTable() {
	var q =$('#imageCategorySearchId').val();
	
	var formdata = 'ajax=true&q='+q;
    $("#imageCategoryDynamicTable").html('');
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
	$('#fileupload').val('');
	globalEdit = false;

}

function imageCategorySave() {

	var saveStatus = false;
	var hiddenICID = $('#hiddenICID').val();
	var imageCategoryType = $('#imageCategoryTypeId').val();
	var imageCategoryName = $('#imageCategoryNameId').val();
	var fileName = $('#fileupload').val();

	var formdata = new FormData();
	formdata.append("file", fileupload.files[0]);
	formdata.append("hiddenICID", hiddenICID);
	formdata.append("imageCategoryType", imageCategoryType);
	formdata.append("imageCategoryName", imageCategoryName);

	if(imageCategoryType != '' && imageCategoryName != '' && globalEdit == true){
		saveStatus = true;
	} 
	if(imageCategoryType != '' && imageCategoryName != '' && globalEdit == false && fileName != '') {
		saveStatus = true;
	}
	
	if(saveStatus){
		$.ajax({
	        type: "POST",
	        url: "imageCategoryController/saveImageCategory",
	        data: formdata,
	        dataType: 'json',
	        contentType: false,
	        processData: false,
	        success: function(data) {
				$('#imageCategoryFormDivId').hide();
				loadImageCategoryTable();
				clearValues();
	        },
	        error: function(){
	        	console.log(data.status);
	        }
		});
	} else {
		alert("Fill required fieds");
	}
}

function imageCategoryEdit(icid, itid) {
	newImageCategory();
	globalEdit = true;
	var hiddenICID = icid;
	$('#hiddenICID').val(icid);
	
	$.get('imageCategoryController/getImageCategoryByICID', {
		hiddenICID : hiddenICID,
	}, function(data) {
		if (data.status == 'success') {
			if(data.result != null) {
				$('#imageCategoryTypeId').val(data.result.icType);
				$('#imageCategoryNameId').val(data.result.icName);
			}
		} else {
			console.log(data.status);
		}
	});
}

function imageCategoryDelete(icid, itid){
	var hiddenICID = icid;
	$('#hiddenICID').val(icid);
	var ITID = itid;
	$.get('imageCategoryController/imageCategoryDelete', {
		hiddenICID : hiddenICID,
		ITID : ITID
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
