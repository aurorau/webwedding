<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href='css/common-style.css' rel='stylesheet' type='text/css'>

<!-- Date Picker -->
<link rel="stylesheet" href="https://code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">
<!-- <script src="https://code.jquery.com/jquery-1.10.2.js"></script> -->


<script src="js/jquery.js"></script>
<script src="js/common.js"></script>
<script src="js/jquery.displaytag-ajax-1.2.js"></script>
<script src="https://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<script src="js/fileUpload/jquery.iframe-transport.js"></script>
<script src="js/fileUpload/jquery.fileupload.js"></script>
<script src="js/backOfficeJS/addDetails.js"></script>
<html>
<head>
<title>Add Details</title>
</head>
<body>
	<div>
		<div style="width:20%;float: left">
		<h3><a href="backOffice">W2-Back Office</a></h3>
			<div>
				<ul><a href="#">Article Details</a></ul>
				<ul><a href="districtSetUp">District Details</a></ul>
				<ul><a href="#">Company Comments</a></ul>
				<ul><a href="supplierCategorySetUp">Supplier Category</a></ul>
				<ul><a href="imageCategoryController">Image Category</a></ul>
				<ul><b>Add Details</b></ul>
				<ul><a href="companyDetailsController">Supplier Company Details</a></ul>
				<ul><a href="supplierDetailsController">Supplier Personal Details</a></ul>
				<ul><a href="fileUploadController">File Image Upload</a></ul>
			</div>
		</div>
				
		<div style="width:80%;float: right" id="content">
			<div style="float: left; width:100%">
			<h3>Add Details</h3>	
				<table style="float: right">
					<tr>
						<td><input type="text" id="addDetailsSearchId" placeholder="Search and Filter"/></td>
						<td><button onclick="loadAddDetailsTable()">Search</button></td>
					</tr>
				</table>
			</div>
			
			<div id="addDetailsTableDivId" >
				<button id="addNewAddDetails" onclick="newAddDetails()">Add new</button>
					<table id="addDetailsDynamicTable">
				
					</table>
			</div>
			<div id="addDetailsFormDivId">
			<input type="hidden" id="hiddenAID" />
			<table>
				<tr>
					<td>
						<table>
							<tr>
								<td>Add Owner Name :</td>
								<td><input type="text" id="ownerNameId" placeholder="Owner Name"></td>
							</tr>
							<tr>
								<td>Add Registered Date :</td>
								<td><input type="text" class="datepicker" id="regDateId" placeholder="Add Registration date"></td>
							</tr>
							<tr>
								<td>Owner TP :</td>
								<td><input type="text" id="ownerTpId" placeholder="Owner TP"></td>
							</tr>
							<tr>
								<td>Owner Address :</td>
								<td><input type="text" id="ownerAddressId" placeholder="Owner Address"></td>
							</tr>
							<tr>
								<td>Owner Email :</td>
								<td><input type="text" id="ownerEmailId" placeholder="Owner Email"></td>
							</tr>
							<tr>
								<td>Web URL :</td>
								<td><input type="text" id="webUrlId" placeholder="Web URL"></td>
							</tr>
							<tr>
								<td>Upload Logo :</td>
									<td><input id="fileupload" type="file" name="files[]" multiple>
								</td>
							</tr>	
							<tr>
								<td></td>
								<td><input type="hidden" id="fileHiddenUrl"></td>
							</tr>
						</table>
					</td>
					
					<td>
						<table>		
							<tr>
								<td>Add Active Date :</td>
								<td><input type="text" class="datepicker" id="addDetailsActiveDateId" placeholder="Add Active Date"></td>
							</tr>
							<tr>
								<td>Add Status :</td>
								<td><select id="addDetailsStatusId">
									<option value="">Select Status</option>
									<option value="1">Active</option>
									<option value="2">Inactive</option>
									<option value="3">Pending</option>
									<option value="4">Suspend</option>
								</select></td>
							</tr>
							<tr>
								<td>Add Active Period :</td>
								<td><select id="addDetailsActivePeriodId">
									<option value="">Select Period</option>
									<option value="1">4 months</option>
									<option value="2"> 1 year</option>
								</select></td>
							</tr>	
							<tr>
								<td>Add Description :</td>
								<td><textarea id="addDescriptionId" placeholder="Add Description"></textarea></td>
							</tr>
						</table>
					</td>
				</tr>
				
			</table>
				<table>	
					<tr>
						<td></td>
						<td>
							<button id="addDetailsClearBtn" >Clear</button>
							<button id="addDetailsSaveBtn" onclick="addDetailsSave()">Save</button>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
  <script>
	  $(function() {
	    $( ".datepicker" ).datepicker({ dateFormat: 'yy-mm-dd' });
	  });
  </script>
</html>