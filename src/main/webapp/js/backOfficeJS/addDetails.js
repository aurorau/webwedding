
var globalEdit;

$(document).ready(function() {
	$('#addDetailsFormDivId').hide();
	clearValues();
	loadAddDetailsTable();
	
	$('#addDetailsClearBtn').on('click', function(){
		clearValues();
	});
	globalEdit = false;
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
	$('#fileupload').val('');
	globalEdit = false;
}

function addDetailsSave() {
	var saveStatus = false;
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
	var fileName = $('#fileupload').val();
	
/*	if(supplierName != '' && registeredDate != '' && activeDate != '' ) {

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
	}*/
	
	var formdata = new FormData();
	formdata.append("file", fileupload.files[0]);
	formdata.append("hiddenAID", hiddenAID);
	formdata.append("supplierName", supplierName);
	formdata.append("registeredDate", registeredDate);
	formdata.append("supplierTp", supplierTp);
	formdata.append("supplierAddress", supplierAddress);
	formdata.append("supplierEmail", supplierEmail);
	formdata.append("addLink", addLink);
	formdata.append("activeDate", activeDate);
	formdata.append("status", status);
	formdata.append("activePeriod", activePeriod);
	formdata.append("addDescription", addDescription);

	if(supplierName != '' && registeredDate != '' && activeDate != '' && globalEdit == true){
		saveStatus = true;
	} 
	if(supplierName != '' && registeredDate != '' && activeDate != '' && globalEdit == false && fileName != '') {
		saveStatus = true;
	}
	
	if(saveStatus){
		$.ajax({
	        type: "POST",
	        url: "addDetailsController/saveAddDetails",
	        data: formdata,
	        dataType: 'json',
	        contentType: false,
	        processData: false,
	        success: function(data) {
				loadAddDetailsTable();
				clearValues();
				$('#addDetailsFormDivId').hide();
	        },
	        error: function(){
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
function addDetailsDelete(aid,itid) {
	var hiddenAID = aid;
	var ITID = itid;
	$('#hiddenAID').val(aid);
	
	$.get('addDetailsController/addDetailsDelete', {
		hiddenAID : hiddenAID,
		ITID : ITID
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
	globalEdit = true;
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
			}
		} else {
			console.log(data.status);
		}
	});
}

/*$(function () {
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
});*/