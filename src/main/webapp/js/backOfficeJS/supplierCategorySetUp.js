$(document).ready(function() {
	$('#supplierCategoryFormDivId').hide();
	clearValues();
	loadSupplierCategoryTable();
})


function loadSupplierCategoryTable() {
	var q =$('#supplierCategorySearchId').val();
	
	var formdata = 'ajax=true&q='+encodeURIComponent(q).replace("'", "%27");
	$.ajax({
        type: "GET",
        url: "supplierCategorySetUp/getSupplierCategoryTable",
        data: formdata,
        success: function(data) {
          $("#supplierCategoryDynamicTable").html(data);
       	  $("#supplierCategoryDynamicTable").displayTagAjax();
       	  removeTableText('supplierCategoryDynamicTable');
        }
	});
}

function newsupplierCategory() {
	$('#supplierCategoryFormDivId').show();
	clearValues();
}

function clearValues() {
	$('#hiddenSCID').val('');
	$('#supplierCategoryTypeId').val('');
	$('#supplierCategoryNameId').val('');
	$('#supplierCategorySearchId').val('');
	
}

function supplierCategorySave() {
	var hiddenSCID = $('#hiddenSCID').val();
	var supplierCategoryType = $('#supplierCategoryTypeId').val();
	var supplierCategoryName = $('#supplierCategoryNameId').val();
	
	$.post('supplierCategorySetUp/saveSupplierCategory', {
		hiddenSCID : hiddenSCID,
		supplierCategoryType : supplierCategoryType,
		supplierCategoryName : supplierCategoryName
	}, function(data) {
		if (data.status == 'saved' ||data.status == 'updated') {
			$('#supplierCategoryFormDivId').hide();
			loadSupplierCategoryTable();
			clearValues();
		} else {
			console.log(data.status);
		}
	});
}

function supplierCategoryEdit(scid) {
	newsupplierCategory();
	var hiddenSCID = scid;
	$('#hiddenSCID').val(scid);
	
	$.get('supplierCategorySetUp/getSupplierCategoryBySCID', {
		hiddenSCID : hiddenSCID
	}, function(data) {
		if (data.status == 'success') {
			if(data.result != null) {
				$('#supplierCategoryTypeId').val(data.result.scType);
				$('#supplierCategoryNameId').val(data.result.scName);
			}
		} else {
			console.log(data.status);
		}
	});
}

function supplierCategoryDelete(scid){
	var hiddenSCID = scid;
	$('#hiddenSCID').val(scid);
	
	$.get('supplierCategorySetUp/supplierCategoryDelete', {
		hiddenSCID : hiddenSCID
	}, function(data) {
		if(data.status == 'success') {
			loadSupplierCategoryTable();
		}else if(data.status == 'fail') {
			alert("Record in used, Unable to delete");
		}
	});
}