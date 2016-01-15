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
<script src="js/backOfficeJS/companyDetails.js"></script>
<html>
<head>
<title>Supplier Company Details</title>
</head>
<body>
	<div>
		<div style="width:20%;float: left">
		<h3><a href="backOffice">W2-Back Office</a></h3>
			<div>
				<ul><a href="#">Article Details</a></ul>
				<ul><a href="districtSetUp">District Details</a></ul>
				<!-- <ul><a href="#">Category Gallery</a></ul> -->
				<!-- <ul><a href="#">Company Category</a></ul> -->
				<ul><a href="#">Company Comments</a></ul>
				<ul><a href="supplierCategorySetUp">Supplier Category</a></ul>
				<ul><b>Supplier Company Details</b></ul>
				<ul><a href="supplierDetailsController">Supplier Personal Details</a></ul>
				<ul><a href="fileUploadController">File Image Upload</a></ul>
			</div>
		</div>
				
		<div style="width:80%;float: right" id="content">
			<div style="float: left; width:100%">
			<h3>Supplier Company Details</h3>	
				<table style="float: right">
					<tr>
						<td><input type="text" id="companyDetailsSearchId" placeholder="Search and Filter"/></td>
						<td><button onclick="loadCompanyDetailsTable()">Search</button></td>
					</tr>
				</table>
			</div>
			
			<div id="companyDetailsTableDivId" >
				<button id="addNewCompanyDetails" onclick="newCompanyDetails()">Add new</button>
					<table id="companyDetailsDynamicTable">
				
					</table>
			</div>
			<div id="companyDetailsFormDivId">
			<input type="hidden" id="hiddenSCDID" />
			<table>
				<tr>
					<td>
						<table>
							<tr>
								<td>Company Registration Number :</td>
								<td><input type="text" id="companyDetailsRegId" placeholder="Company Registration Number"></td>
							</tr>
							<tr>
								<td>Company Registered Date :</td>
								<td><input type="text" class="datepicker" id="companyDetailsRegdateId" placeholder="Company Registration date"></td>
							</tr>
							<tr>
								<td>Company Name :</td>
								<td><input type="text" id="companyDetailsNameId" placeholder="Company Name"></td>
							</tr>
							<tr>
								<td>Company Land Number :</td>
								<td><input type="text" id="companyDetailsLandId" placeholder="Company Land Number"></td>
							</tr>
							<tr>
								<td>Company Mobile Number :</td>
								<td><input type="text" id="companyDetailsMobileId" placeholder="Company Mobile Number"></td>
							</tr>
							<tr>
								<td>Company Email :</td>
								<td><input type="text" id="companyDetailsEmailId" placeholder="Company Email"></td>
							</tr>
							<tr>
								<td>Company Address :</td>
								<td><textarea rows="5" cols="" id="companyDetailsAddressId" placeholder="Company Address"></textarea></td>
							</tr>
						</table>
					</td>
					
					<td>
						<table>
							<tr>
								<td>Company Fax Number :</td>
								<td><input type="text" id="companyDetailsFaxId" placeholder="Company Fax Number"></td>
							</tr>		
							<tr>
								<td>Company Web URL :</td>
								<td><input type="text" id="companyDetailsWebId" placeholder="Company Web URL"></td>
							</tr>	
							<tr>
								<td>Company fb Page :</td>
								<td><input type="text" id="companyDetailsFbId" placeholder="Company fb Page"></td>
							</tr>	
		
							<tr>
								<td>Company Budget :</td>
								<td><input type="text" id="companyDetailsBudgetId" placeholder="Company Budget"></td>
							</tr>		
							<tr>
								<td>Company Active Date :</td>
								<td><input type="text" class="datepicker" id="companyDetailsActiveDateId" placeholder="Company Active Date"></td>
							</tr>
							<tr>
								<td>Company Status :</td>
								<td><select id="companyDetailsStatusId">
									<option value="">Select Status</option>
									<option value="1">Active</option>
									<option value="2">Inactive</option>
									<option value="3">Pending</option>
									<option value="4">Suspend</option>
								</select></td>
							</tr>
							<tr>
								<td>Company Active Period :</td>
								<td><select id="companyDetailsActivePeriodId">
									<option value="">Select Period</option>
									<option value="1">4 months</option>
									<option value="2"> 1 year</option>
								</select></td>
							</tr>						
							<tr>
								<td>Owner:</td>
								<td><select id="companyDetailsOwnerId">
									<option value="">Select Owner</option>
								</select></td>
							</tr>
							<tr>
								<td>Category:</td>
								<td><select id="companyDetailsCategoryId">
									<option value="">Select Category</option>
								</select></td>
							</tr>
							<tr>
								<td>District:</td>
								<td><select id="companyDetailsDistrictId">
									<option value="">Select District</option>
								</select></td>
							</tr>
						</table>
					</td>
				</tr>
				
			</table>
				<table>	
					<tr>
						<td></td>
						<td>
							<button id="companyDetailsClearBtn" >Clear</button>
							<button id="companyDetailsSaveBtn" onclick="companyDetailsSave()">Save</button>
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