
var globalEdit;

$(document).ready(function() {
	$('#companyDetailsFormDivId').hide();
	clearValues();
	loadCompanyDetailsTable();
	loadOwnerDetails();
	loadCategoryDetails();
	loadDistrictDetails();
	
	$('#companyDetailsClearBtn').on('click', function(){
		clearValues();
	});
	globalEdit = false;
});


function loadOwnerDetails() {
	$.ajax({
        type: "GET",
        url: "supplierDetailsController/getAllSuppliers",
        success: function(data) {
        	if(data.result != null) {
        		for(var x=0 ; x< data.result.length ; x++ ){
        			$('#companyDetailsOwnerId').append(new Option(''+data.result[x].supplierFirstName+' '+data.result[x].supplierLastName+'',''+data.result[x].spdid+''))
        		}
        	}
        }
	});
}
function loadCategoryDetails() {
	$.ajax({
        type: "GET",
        url: "supplierCategorySetUp/getAllCategories",
        success: function(data) {
        	if(data.result != null) {
        		for(var x=0 ; x< data.result.length ; x++ ){
        			$('#companyDetailsCategoryId').append(new Option(''+data.result[x].scName+'',''+data.result[x].scid+''))
        		}
        	}
        }
	});
}
function loadDistrictDetails(){
	$.ajax({
        type: "GET",
        url: "districtSetUp/getAllDistricts",
        success: function(data) {
        	if(data.result != null) {
        		for(var x=0 ; x< data.result.length ; x++ ){
        			$('#companyDetailsDistrictId').append(new Option(''+data.result[x].districtName+'',''+data.result[x].ddid+''))
        		}
        	}
        }
	});
}
function loadCompanyDetailsTable() {
	var q =$('#companyDetailsSearchId').val();
	
	var formdata = 'ajax=true&q='+encodeURIComponent(q).replace("'", "%27");
	$.ajax({
        type: "GET",
        url: "companyDetailsController/getCompanyDetailsTable",
        data: formdata,
        success: function(data) {
          $("#companyDetailsDynamicTable").html(data);
       	  $("#companyDetailsDynamicTable").displayTagAjax();
       	  removeTableText('companyDetailsDynamicTable');
        }
	});
}

function newCompanyDetails() {
	$('#companyDetailsFormDivId').show();
	clearValues();
}

function clearValues() {
	$('#hiddenSCDID').val('');
	$('#companyDetailsRegId').val('');
	$('#companyDetailsNameId').val('');
	$('#companyDetailsAddressId').val('');
	$('#companyDetailsEmailId').val('');
	$('#companyDetailsLandId').val('');
	$('#companyDetailsMobileId').val('');
	$('#companyDetailsFaxId').val('');
	$('#companyDetailsWebId').val('');
	$('#companyDetailsFbId').val('');
	$('#companyDetailsBudgetId').val('');
	$('#companyDetailsStatusId').val('');
	$('#companyDetailsActiveDateId').val('');
	$('#companyDetailsActivePeriodId').val('');
	$('#companyDetailsOwnerId').val('');
	$('#companyDetailsCategoryId').val('');
	$('#companyDetailsDistrictId').val('');
	$('#companyDetailsRegdateId').val('');
	$('#fileupload').val('');
	$('#companyDetailsDescriptionId').val('');
	globalEdit = false;
}

function companyDetailsSave() {
	var saveStatus = false;
	var hiddenSCDID = $('#hiddenSCDID').val();
	var companyRegistrationNumber= $('#companyDetailsRegId').val();
	var companyName = $('#companyDetailsNameId').val();
	var companyAddress = $('#companyDetailsAddressId').val();
	var companyTp1 = $('#companyDetailsLandId').val();
	var companyTp2 = $('#companyDetailsMobileId').val();
	var companyEmail = $('#companyDetailsEmailId').val();
	var companyFaxNo = $('#companyDetailsFaxId').val();
	var companyWebURl = $('#companyDetailsWebId').val();
	var companyFbPage = $('#companyDetailsFbId').val();
	var budget = $('#companyDetailsBudgetId').val();
	var status = $('#companyDetailsStatusId').val();
	var companyRegisteredDate = $('#companyDetailsRegdateId').val();
	var activeDate = $('#companyDetailsActiveDateId').val();
	var activePeriod = $('#companyDetailsActivePeriodId').val();
	var supplierPersonalDetails = $('#companyDetailsOwnerId').val();
	var supplierCategory = $('#companyDetailsCategoryId').val();
	var districtDetails = $('#companyDetailsDistrictId').val();
	var fileName = $('#fileupload').val();
	var companyDescription = $('#companyDetailsDescriptionId').val().trim();
	
	var formdata = new FormData();
	formdata.append("file", fileupload.files[0]);
	formdata.append("hiddenSCDID", hiddenSCDID);
	formdata.append("companyRegistrationNumber", companyRegistrationNumber);
	formdata.append("companyName", companyName);
	formdata.append("companyAddress", companyAddress);
	formdata.append("companyTp1", companyTp1);
	formdata.append("companyTp2", companyTp2);
	formdata.append("companyEmail", companyEmail);
	formdata.append("companyFaxNo", companyFaxNo);
	formdata.append("companyWebURl", companyWebURl);
	formdata.append("companyFbPage", companyFbPage);
	formdata.append("budget", budget);
	formdata.append("status", status);
	formdata.append("companyRegisteredDate", companyRegisteredDate);
	formdata.append("activeDate", activeDate);
	formdata.append("activePeriod", activePeriod);
	formdata.append("supplierPersonalDetails", supplierPersonalDetails);
	formdata.append("supplierCategory", supplierCategory);
	formdata.append("districtDetails", districtDetails);
	formdata.append("companyDescription", companyDescription);
	
/*	if(districtDetails != '' && supplierCategory != '' && supplierPersonalDetails != '' && budget != '') {

		$.post('companyDetailsController/saveCompanyDetails', {
			hiddenSCDID : hiddenSCDID,
			companyRegistrationNumber : companyRegistrationNumber,
			companyName : companyName,
			companyAddress : companyAddress,
			companyTp1 : companyTp1,
			companyTp2 : companyTp2,
			companyEmail : companyEmail,
			companyFaxNo : companyFaxNo,
			companyWebURl : companyWebURl,
			companyFbPage : companyFbPage,
			budget : budget,
			status : status,
			companyRegisteredDate : companyRegisteredDate,
			activeDate : activeDate,
			activePeriod : activePeriod,
			supplierPersonalDetails : supplierPersonalDetails,
			supplierCategory : supplierCategory,
			districtDetails : districtDetails,
			ar : ar
		}, function(data) {
			if (data.status == 'saved' ||data.status == 'updated') {
				loadCompanyDetailsTable();
				clearValues();
				$('#companyDetailsFormDivId').hide();
			} else {
				console.log(data.status);
			}
		});
	} else {
		alert("Fill required fieds");
	}*/
	


	if(districtDetails != '' && supplierCategory != '' && supplierPersonalDetails != '' && budget != '' && globalEdit == true){
		saveStatus = true;
	} 
	if(districtDetails != '' && supplierCategory != '' && supplierPersonalDetails != '' && budget != '' && globalEdit == false && fileName != '') {
		saveStatus = true;
	}
	
	if(saveStatus){
		$.ajax({
	        type: "POST",
	        url: "companyDetailsController/saveCompanyDetails",
	        data: formdata,
	        dataType: 'json',
	        contentType: false,
	        processData: false,
	        success: function(data) {
				loadCompanyDetailsTable();
				clearValues();
				$('#companyDetailsFormDivId').hide();
	        },
	        error: function(){
	        	console.log(data.status);
	        }
		});
	} else {
		alert("Fill required fieds");
	}
}

function companyDetailsEdit(scdid){
	getCompanyDetails(scdid);
}
function companyDetailsView(scdid) {
	getCompanyDetails(scdid);
}
function companyDetailsDelete(scdid,itid) {
	var hiddenSCDID = scdid;
	var ITID = itid;
	$('#hiddenSCDID').val(scdid);
	
	$.get('companyDetailsController/companyDetailsDelete', {
		hiddenSCDID : hiddenSCDID,
		ITID : ITID
	}, function(data) {
		if(data.status == 'success') {
			loadCompanyDetailsTable();
		} else if(data.status == 'fail') {
			alert("Record in used, Unable to delete");
		}
	});
}
function getCompanyDetails(scdid) {
	newCompanyDetails();
	globalEdit = true;
	var hiddenSCDID = scdid;
	$('#hiddenSCDID').val(scdid);
	
	$.get('companyDetailsController/getCompanyDetailsBySCDID', {
		hiddenSCDID : hiddenSCDID
	}, function(data) {
		if (data.status == 'success') {
			if(data.result.companyDetails != null) {
				$('#companyDetailsRegId').val(data.result.companyDetails.companyRegistrationNumber);
				$('#companyDetailsNameId').val(data.result.companyDetails.companyName);
				$('#companyDetailsAddressId').val(data.result.companyDetails.companyAddress);
				$('#companyDetailsEmailId').val(data.result.companyDetails.companyEmail);
				$('#companyDetailsLandId').val(data.result.companyDetails.companyTp1);
				$('#companyDetailsMobileId').val(data.result.companyDetails.companyTp2);
				$('#companyDetailsFaxId').val(data.result.companyDetails.companyFaxNo);
				$('#companyDetailsWebId').val(data.result.companyDetails.companyWebURl);
				$('#companyDetailsFbId').val(data.result.companyDetails.companyFbPage);
				$('#companyDetailsBudgetId').val(data.result.companyDetails.budget);
				$('#companyDetailsStatusId').val(data.result.companyDetails.status);
				$('#companyDetailsActiveDateId').val(data.result.companyDetails.activeDate);
				$('#companyDetailsActivePeriodId').val(data.result.companyDetails.activePeriod);
				$('#companyDetailsOwnerId').val(data.result.companyDetails.supplierPersonalDetails);
				$('#companyDetailsCategoryId').val(data.result.companyDetails.supplierCategory);
				$('#companyDetailsDistrictId').val(data.result.companyDetails.districtDetails);
				$('#companyDetailsRegdateId').val(data.result.companyDetails.companyRegisteredDate);
				$('#fileHiddenUrl').val(data.result.companyDetails.logoUrl);
				$('#companyDetailsDescriptionId').val(data.result.companyDetails.companyDescription);
			}
		} else {
			console.log(data.status);
		}
	});
}
function limitedLength(fieldId, value){
	var text =$('#'+fieldId).val();
	if(text.length>value){
		$('#'+fieldId).val(text.substring(0, value));
	}
}
/*$(function () {
	var prefix = 'cd';
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