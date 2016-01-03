$(document).ready(function() {
	$('#supplierCategoryFormDivId').hide();
	//loadDistrictDetailsTable();
})

function newsupplierCategory() {
	$('#supplierCategoryFormDivId').show();
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
		if (data.status == 'success') {
			console.log(data.status);
		} else {
			console.log(data.status);
		}
	});
}