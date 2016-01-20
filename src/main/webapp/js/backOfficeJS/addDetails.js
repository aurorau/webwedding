
var arr;

$(document).ready(function() {
	$('#addDetailsFormDivId').hide();
	clearValues();
	loadAddDetailsTable();
	
	$('#addDetailsClearBtn').on('click', function(){
		clearValues();
	});
	
});

function loadAddDetailsTable() {
	var q =$('#addDetailsSearchId').val();
	
	var formdata = 'ajax=true&q='+q;
	$.ajax({
        type: "GET",
        url: "addDetailsController/getAddDetailTable",
        data: formdata,
        success: function(data) {
          $("#addDetailsDynamicTable").html(data);
       	  $("#addDetailsDynamicTable").displayTagAjax();
       	  removeTableText('addDetailsDynamicTable');
        }
	});
}

function newAddDetails() {
	$('#addDetailsFormDivId').show();
	clearValues();
}

function clearValues() {
	$('#hiddenAID').val('');
	$('#ownerNameId').val('');
	$('#regDateId').val('');
	$('#ownerTpId').val('');
	$('#ownerAddressId').val('');
	$('#ownerEmailId').val('');
	$('#webUrlId').val('');
	$('#addDetailsActiveDateId').val('');
	$('#addDetailsStatusId').val('');
	$('#addDetailsActivePeriodId').val('');
	$('#addDescriptionId').val('');
	$('#fileHiddenUrl').val('');
	arr = new Array();
}

function addDetailsSave() {
	var addUrl ;
	if(arr[0] != null && arr[0] !=''){
		addUrl = arr[0];
	} else if($('#fileHiddenUrl').val() !='') {
		ar = $('#fileHiddenUrl').val();
	} else {
		addUrl = 'No Logo';
	}

	
	var hiddenAID = $('#hiddenAID').val();
	var supplierName= $('#ownerNameId').val();
	var registeredDate = $('#regDateId').val();
	var supplierTp = $('#ownerTpId').val();
	var supplierAddress = $('#ownerAddressId').val();
	var supplierEmail = $('#ownerEmailId').val();
	var addLink = $('#webUrlId').val();
	var activeDate = $('#addDetailsActiveDateId').val();
	var status = $('#addDetailsStatusId').val();
	var activePeriod = $('#addDetailsActivePeriodId').val();
	var addDescription = $('#addDescriptionId').val();
	
	if(supplierName != '' && registeredDate != '' && activeDate != '' ) {

		$.post('addDetailsController/saveAddDetails', {
			hiddenAID : hiddenAID,
			supplierName : supplierName,
			registeredDate : registeredDate,
			supplierTp : supplierTp,
			supplierAddress : supplierAddress,
			supplierEmail : supplierEmail,
			addLink : addLink,
			activeDate : activeDate,
			status : status,
			activePeriod : activePeriod,
			addDescription : addDescription,
			addUrl : addUrl
		}, function(data) {
			if (data.status == 'saved' ||data.status == 'updated') {
				loadAddDetailsTable();
				clearValues();
				$('#addDetailsFormDivId').hide();
			} else {
				console.log(data.status);
			}
		});
	} else {
		alert("Fill required fieds");
	}
}

function addDetailsEdit(aid){
	getAddDetails(aid);
}
function addDetailsDelete(aid) {
	var hiddenAID = aid;
	$('#hiddenAID').val(aid);
	
	$.get('addDetailsController/addDetailsDelete', {
		hiddenAID : hiddenAID
	}, function(data) {
		if(data.status == 'success') {
			loadAddDetailsTable();
			clearValues();
			$('#addDetailsFormDivId').hide();
		} else if(data.status == 'fail') {
			alert("Record in used, Unable to delete");
		}
	});
}
function getAddDetails(aid) {
	newAddDetails();
	var hiddenAID = aid;
	$('#hiddenAID').val(aid);
	
	$.get('addDetailsController/getAddDetailsByAID', {
		hiddenAID : hiddenAID
	}, function(data) {
		if (data.status == 'success') {
			if(data.result != null) {
				$('#hiddenAID').val(data.result.aid);
				$('#ownerNameId').val(data.result.addSupplierName);
				$('#regDateId').val(data.result.addRegisteredDate);
				$('#ownerTpId').val(data.result.addSupplierTp);
				$('#ownerAddressId').val(data.result.addSupplierAddress);
				$('#ownerEmailId').val(data.result.addSupplierEmail);
				$('#webUrlId').val(data.result.addLink);
				$('#addDetailsActiveDateId').val(data.result.addActiveDate);
				$('#addDetailsStatusId').val(data.result.addStatus);
				$('#addDetailsActivePeriodId').val(data.result.addActivePeriod);
				$('#addDescriptionId').val(data.result.addDescription);
				$('#fileHiddenUrl').val(data.result.addUrl);
			}
		} else {
			console.log(data.status);
		}
	});
}

$(function () {
	var prefix = 'add';
    $('#fileupload').fileupload({
        dataType: 'json',
        url : "fileUploadController/upload?prefix="+prefix,
        done: function (e, data) {
            $.each(data.result, function (index, file) {
            		console.log("File Name :"+file.fileName);
            		arr.push(file.fileName);
           }); 
        },
 
        progressall: function (e, data) {
            var progress = parseInt(data.loaded / data.total * 100, 10);
        },
    });
});