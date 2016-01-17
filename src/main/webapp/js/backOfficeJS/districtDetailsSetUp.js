$(document).ready(function() {
	$('#districtFormDivId').hide();
	clearValues();
	loadDistrictDetailsTable();
})

function loadDistrictDetailsTable() {
	var q =$('#districtDetailsSearchId').val();
	
	var formdata = 'ajax=true&q='+encodeURIComponent(q).replace("'", "%27");
	$.ajax({
        type: "GET",
        url: "districtSetUp/getDistrictDetailsTable",
        data: formdata,
        success: function(data) {
          $("#dristrictDynamicTable").html(data);
       	  $("#dristrictDynamicTable").displayTagAjax();
       	  removeTableText('dristrictDynamicTable');
        }
	});
}

function newDistrictDetails() {
	$('#districtFormDivId').show();
	clearValues();
}

function clearValues() {
	$('#hiddenDDID').val('');
	$('#districtCodeId').val('');
	$('#districtNameId').val('');
	$('#districtDetailsSearchId').val('');
	
}

function districtDetailsSave() {
	var hiddenDDID = $('#hiddenDDID').val();
	var districtCode = $('#districtCodeId').val();
	var districtName = $('#districtNameId').val();
	
	$.post('districtSetUp/saveDistrictDetails', {
		hiddenDDID : hiddenDDID,
		districtCode : districtCode,
		districtName : districtName
	}, function(data) {
		
		if (data.status == 'saved' ||data.status == 'updated') {
			$('#districtFormDivId').hide();
			loadDistrictDetailsTable();
			clearValues();
		} else {
			console.log(data.status);
		}
	});
}

function districtDetailsEdit(ddid) {
	newDistrictDetails();
	var hiddenDDID = ddid;
	$('#hiddenDDID').val(ddid);
	
	$.get('districtSetUp/getDistrictDetails', {
		hiddenDDID : hiddenDDID
	}, function(data) {
		if (data.status == 'success') {
			if(data.result != null) {
				$('#districtCodeId').val(data.result.districtCode);
				$('#districtNameId').val(data.result.districtName);
			}
		} else {
			console.log(data.status);
		}
	});
	
}

function districtDetailsDelete(ddid) {
	var hiddenDDID = ddid;
	$('#hiddenDDID').val(ddid);
	
	$.get('districtSetUp/districtDetailsDelete', {
		hiddenDDID : hiddenDDID
	}, function(data) {
		if(data.status == 'success') {
			loadDistrictDetailsTable();
		} else if(data.status == 'fail') {
			alert("Record in used, Unable to delete");
		}
	});
}
