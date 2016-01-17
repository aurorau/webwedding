
var arr;

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
	$('#fileHiddenUrl').val('');
	arr = new Array();
}

function companyDetailsSave() {
	var ar ;
	if($('#fileHiddenUrl').val() != 'No Logo' && $('#fileHiddenUrl').val() !='') {
		ar = $('#fileHiddenUrl').val();
	} else if(arr[0] != null && arr[0] !=''){
		ar = arr[0];
	} else {
		ar = 'No Logo';
	}
	 
	
	console.log("ar :"+ar);
	
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
	
	if(districtDetails != '' && supplierCategory != '' && supplierPersonalDetails != '' && budget != '') {

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
	}
}

function companyDetailsEdit(scdid){
	getCompanyDetails(scdid);
}
function companyDetailsView(scdid) {
	getCompanyDetails(scdid);
}
function companyDetailsDelete(scdid) {
	var hiddenSCDID = scdid;
	$('#hiddenSCDID').val(scdid);
	
	$.get('companyDetailsController/companyDetailsDelete', {
		hiddenSCDID : hiddenSCDID
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
	var hiddenSCDID = scdid;
	$('#hiddenSCDID').val(scdid);
	
	$.get('companyDetailsController/getCompanyDetailsBySCDID', {
		hiddenSCDID : hiddenSCDID
	}, function(data) {
		if (data.status == 'success') {
			if(data.result != null) {
				$('#companyDetailsRegId').val(data.result.companyRegistrationNumber);
				$('#companyDetailsNameId').val(data.result.companyName);
				$('#companyDetailsAddressId').val(data.result.companyAddress);
				$('#companyDetailsEmailId').val(data.result.companyEmail);
				$('#companyDetailsLandId').val(data.result.companyTp1);
				$('#companyDetailsMobileId').val(data.result.companyTp2);
				$('#companyDetailsFaxId').val(data.result.companyFaxNo);
				$('#companyDetailsWebId').val(data.result.companyWebURl);
				$('#companyDetailsFbId').val(data.result.companyFbPage);
				$('#companyDetailsBudgetId').val(data.result.budget);
				$('#companyDetailsStatusId').val(data.result.status);
				$('#companyDetailsActiveDateId').val(data.result.activeDate);
				$('#companyDetailsActivePeriodId').val(data.result.activePeriod);
				$('#companyDetailsOwnerId').val(data.result.supplierPersonalDetails);
				$('#companyDetailsCategoryId').val(data.result.supplierCategory);
				$('#companyDetailsDistrictId').val(data.result.districtDetails);
				$('#companyDetailsRegdateId').val(data.result.companyRegisteredDate);
				$('#fileHiddenUrl').val(data.result.logoUrl);
			}
		} else {
			console.log(data.status);
		}
	});
}

$(function () {
	//arr = new Array();
    $('#fileupload').fileupload({
        dataType: 'json',
 
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