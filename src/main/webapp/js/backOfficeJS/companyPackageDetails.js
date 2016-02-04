
$(document).ready(function() {
	$('#companyPackageFormDivId').hide();
	$('#companyPackageTableDivId').hide();
	$('#companyDetailsId').val('');
	clearValues();
	loadCompanyDetails();
	//loadCompanyPackageTable();
	
	$('#companyPackageClearBtn').on('click', function(){
		clearValues();
	});
});

function hideBelow(){
	$('#companyPackageTableDivId').hide();
	$('#companyPackageFormDivId').hide();
	
}

function loadCompanyDetails(){
	$.ajax({
        type: "GET",
        url: "companyDetailsController/getAllCompanies",
        success: function(data) {
        	if(data.result != null) {
    			$('#companyDetailsId').html('');
    			$('#companyDetailsId').append(new Option('Select Company',''));
        		for(var x=0 ; x< data.result.length ; x++ ){
        			$('#companyDetailsId').append(new Option(''+data.result[x].companyName+'',''+data.result[x].scdid+''))
        		}
        	}
        }
	});
}

function loadCompanyPackageTable() {
	var q =$('#companyDetailsId').val();
	if(q == ''){
		alert("Select Company");
	} else {
		var formdata = 'ajax=true&q='+encodeURIComponent(q).replace("'", "%27");
		$.ajax({
	        type: "GET",
	        url: "companyPackageDetailsController/getCompanyPackageTable",
	        data: formdata,
	        success: function(data) {
	          $('#companyPackageTableDivId').show();
	          $("#companyPackageDynamicTable").html(data);
	       	  $("#companyPackageDynamicTable").displayTagAjax();
	       	  removeTableText('companyPackageDynamicTable');
	        }
		});
	}
}

function newCompanyPackage() {
	$('#companyPackageFormDivId').show();
	//clearValues();
}

function clearValues() {
	$('#hiddenCPDID').val('');
	$('#packageNameId').val('');
	$('#packageDescriptionId').val('');
	$('#companyPackageStatusId').val('');
	//$('#companyDetailsId').val('');
}

function companyPackageSave() {

	var hiddenCPDID = $('#hiddenCPDID').val();
	var packageName= $('#packageNameId').val();
	var packageDescription = $('#packageDescriptionId').val();
	var status = $('#companyPackageStatusId').val();
	var company = $('#companyDetailsId').val();

	
	if(packageName != '' && status != '') {

		$.post('companyPackageDetailsController/saveCompanyPackage', {
			hiddenCPDID : hiddenCPDID,
			packageName : packageName,
			packageDescription : packageDescription,
			status : status,
			company : company
		}, function(data) {
			if (data.status == 'saved' ||data.status == 'updated') {
				loadCompanyPackageTable();
				clearValues();
				$('#companyPackageFormDivId').hide();
			} else {
				console.log(data.status);
			}
		});
	} else {
		alert("Fill required fieds");
	}
}

function companyPackageEdit(cpdid){
	getCompanyPackage(cpdid);
}
function companyPackageDelete(cpdid) {
	var hiddenCPDID = cpdid;
	$('#hiddenCPDID').val(cpdid);
	
	$.get('companyPackageDetailsController/companyPackageDelete', {
		hiddenCPDID : hiddenCPDID
	}, function(data) {
		if(data.status == 'success') {
			loadCompanyPackageTable();
			clearValues();
			$('#companyPackageFormDivId').hide();
		} else if(data.status == 'fail') {
			alert("Record in used, Unable to delete");
		}
	});
}
function getCompanyPackage(cpdid) {
	newCompanyPackage();
	var hiddenCPDID = cpdid;
	$('#hiddenCPDID').val(cpdid);
	
	$.get('companyPackageDetailsController/getPackageByCPDID', {
		hiddenCPDID : hiddenCPDID
	}, function(data) {
		if (data.status == 'success') {
			if(data.result != null) {
				$('#hiddenCPDID').val(data.result.cpdid);
				$('#packageNameId').val(data.result.packageName);
				$('#packageDescriptionId').val(data.result.packageDescription);
				$('#companyPackageStatusId').val(data.result.status);
			}
		} else {
			console.log(data.status);
		}
	});
}