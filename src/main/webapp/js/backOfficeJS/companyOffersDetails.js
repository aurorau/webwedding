
$(document).ready(function() {
	$('#companyOfferFormDivId').hide();
	$('#companyOfferTableDivId').hide();
	$('#companyDetailsId').val('');
	clearValues();
	loadCompanyDetails();
	//loadCompanyPackageTable();
	
	$('#companyOfferClearBtn').on('click', function(){
		clearValues();
	});
});

function hideBelow(){
	$('#companyOfferTableDivId').hide();
	$('#companyOfferFormDivId').hide();
	
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

function loadCompanyOfferTable() {
	var q =$('#companyDetailsId').val();
	if(q == ''){
		alert("Select Company");
	} else {
		var formdata = 'ajax=true&q='+encodeURIComponent(q).replace("'", "%27");
		$.ajax({
	        type: "GET",
	        url: "companyOfferDetailsController/getCompanyOfferTable",
	        data: formdata,
	        success: function(data) {
	          $('#companyOfferTableDivId').show();
	          $("#companyOfferDynamicTable").html(data);
	       	  $("#companyOfferDynamicTable").displayTagAjax();
	       	  removeTableText('companyOfferDynamicTable');
	        }
		});
	}
}

function newCompanyOffer() {
	$('#companyOfferFormDivId').show();
	//clearValues();
}

function clearValues() {
	$('#hiddenCODID').val('');
	$('#offerNameId').val('');
	$('#offerDescriptionId').val('');
	$('#companyOfferStatusId').val('');
	$('#offerStartDateId').val('');
	$('#offerEndDateId').val('');
}

function companyOfferSave() {

	var hiddenCODID = $('#hiddenCODID').val();
	var offerName= $('#offerNameId').val();
	var offerDescription = $('#offerDescriptionId').val();
	var status = $('#companyOfferStatusId').val();
	var offerStartDate = $('#offerStartDateId').val();
	var offerEndDate = $('#offerEndDateId').val();
	var company = $('#companyDetailsId').val();

	
	if(offerName != '' && status != '') {

		$.post('companyOfferDetailsController/saveCompanyOffer', {
			hiddenCODID : hiddenCODID,
			offerName : offerName,
			offerDescription : offerDescription,
			status : status,
			offerStartDate : offerStartDate,
			offerEndDate : offerEndDate,
			company : company
		}, function(data) {
			if (data.status == 'saved' ||data.status == 'updated') {
				loadCompanyOfferTable();
				clearValues();
				$('#companyOfferFormDivId').hide();
			} else {
				console.log(data.status);
			}
		});
	} else {
		alert("Fill required fieds");
	}
}

function companyOfferEdit(codid){
	getCompanyOffer(codid);
}
function companyOfferDelete(codid) {
	var hiddenCODID = codid;
	$('#hiddenCODID').val(codid);
	
	$.get('companyOfferDetailsController/companyOfferDelete', {
		hiddenCODID : hiddenCODID
	}, function(data) {
		if(data.status == 'success') {
			loadCompanyOfferTable();
			clearValues();
			$('#companyOfferFormDivId').hide();
		} else if(data.status == 'fail') {
			alert("Record in used, Unable to delete");
		}
	});
}
function getCompanyOffer(codid) {
	newCompanyOffer();
	var hiddenCODID = codid;
	$('#hiddenCODID').val(codid);
	
	$.get('companyOfferDetailsController/getOfferByCODID', {
		hiddenCODID : hiddenCODID
	}, function(data) {
		if (data.status == 'success') {
			if(data.result != null) {
				$('#hiddenCODID').val(data.result.codid);
				$('#offerNameId').val(data.result.offerName);
				$('#offerDescriptionId').val(data.result.offerDescription);
				$('#companyOfferStatusId').val(data.result.status);
				$('#offerStartDateId').val(data.result.offerStartDate);
				$('#offerEndDateId').val(data.result.offerEndDate);
			}
		} else {
			console.log(data.status);
		}
	});
}