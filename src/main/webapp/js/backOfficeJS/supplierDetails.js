$(document).ready(function() {
	$('#supplierPDFormDivId').hide();
	clearValues();
	loadSupplierPDTable();
})


function loadSupplierPDTable() {
	var q =$('#supplierPDSearchId').val();
	
	var formdata = 'ajax=true&q='+encodeURIComponent(q).replace("'", "%27");
	$.ajax({
        type: "GET",
        url: "supplierDetailsController/getSupplierDetailsTable",
        data: formdata,
        success: function(data) {
          $("#supplierPDDynamicTable").html(data);
       	  $("#supplierPDDynamicTable").displayTagAjax();
       	  removeTableText('supplierPDDynamicTable');
        }
	});
}

function newSupplierPD() {
	$('#supplierPDFormDivId').show();
	clearValues();
}

function clearValues() {
	$('#hiddenSPDID').val('');
	$('#supplierPDFNameId').val('');
	$('#supplierPDLNameId').val('');
	$('#supplierPDEmailId').val('');
	$('#supplierPDTp1Id').val('');
	$('#supplierPDTp2Id').val('');
	$('#supplierPDSkypeId').val('');
	
}

function supplierPDSave() {
	var hiddenSPDID = $('#hiddenSPDID').val();
	var fname = $('#supplierPDFNameId').val();
	var lname = $('#supplierPDLNameId').val();
	var tp1 = $('#supplierPDTp1Id').val();
	var tp2 = $('#supplierPDTp2Id').val();
	var email = $('#supplierPDEmailId').val();
	var skype = $('#supplierPDSkypeId').val();
	
	if(fname != null && fname != '') {
		$.post('supplierDetailsController/saveSupplierDetails', {
			hiddenSPDID : hiddenSPDID,
			fname : fname,
			lname : lname,
			tp1 : tp1,
			tp2 : tp2,
			email : email,
			skype : skype
		}, function(data) {
			if (data.status == 'saved' ||data.status == 'updated') {
				$('#supplierPDFormDivId').hide();
				loadSupplierPDTable();
				clearValues();
			} else {
				console.log(data.status);
			}
		});
	} else {
		alert("Fill at least first name ");
	}
}

function supplierDetailsEdit(spdid) {
	newSupplierPD();
	var hiddenSPDID = spdid;
	$('#hiddenSPDID').val(spdid);
	
	$.get('supplierDetailsController/getSupplierPersonalDetailsBySPDID', {
		hiddenSPDID : hiddenSPDID
	}, function(data) {
		if (data.status == 'success') {
			if(data.result != null) {
				$('#supplierPDFNameId').val(data.result.supplierFirstName);
				$('#supplierPDLNameId').val(data.result.supplierLastName);
				$('#supplierPDTp1Id').val(data.result.supplierTp1);
				$('#supplierPDTp2Id').val(data.result.supplierTp2);
				$('#supplierPDEmailId').val(data.result.supplierEmail);
				$('#supplierPDSkypeId').val(data.result.supplierSkypeAddress);
			}
		} else {
			console.log(data.status);
		}
	});
}

function supplierDetailsDelete(spdid) {
	var hiddenSPDID = spdid;
	$('#hiddenSPDID').val(spdid);
	
	$.get('supplierDetailsController/supplierDetailsDelete', {
		hiddenSPDID : hiddenSPDID
	}, function(data) {
		if(data.status == 'success') {
			loadSupplierPDTable();
		}else if(data.status == 'fail') {
			alert("Record in used, Unable to delete");
		}
	});
}