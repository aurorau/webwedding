<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href='css/common-style.css' rel='stylesheet' type='text/css'>

<script src="js/jquery.js"></script>
<script src="js/common.js"></script>
<script src="js/jquery.displaytag-ajax-1.2.js"></script>
<script src="js/backOfficeJS/supplierDetails.js"></script>
<html>
<head>
<title>Supplier Personal Details</title>
</head>
<body>
	<div>
		<div style="width:20%;float: left">
		<h3><a href="backOffice">W2-Back Office</a></h3>
			<div>
				<ul><a href="#">Article Details</a></ul>
				<ul><a href="districtSetUp">District Details</a></ul>
				<ul><a href="supplierCategorySetUp">Supplier Category</a></ul>
				<ul><a href="imageCategoryController">Image Category</a></ul>
				<ul><a href="addDetailsController">Add Details</a></ul>
				<ul><a href="companyDetailsController">Supplier Company Details</a></ul>
				<ul><a href="companyPackageDetailsController">Company Package Details</a></ul>
				<ul><a href="companyOfferDetailsController">Company Offers Details</a></ul>
				<ul><b>Supplier Personal Details</b></ul>
				<ul><a href="fileUploadController">File Image Upload</a></ul>
			</div>
		</div>
				
		<div style="width:80%;float: right" id="content">
			<div style="float: left; width:100%">
			<h3>Supplier Personal Details</h3>	
				<table style="float: right">
					<tr>
						<td><input type="text" id="supplierPDSearchId" placeholder="Search and Filter"/></td>
						<td><button onclick="loadSupplierPDTable()">Search</button></td>
					</tr>
				</table>
			</div>
			
			<div id="supplierPDTableDivId" >
				<button id="addNewSupplierPD" onclick="newSupplierPD()">Add new</button>
					<table id="supplierPDDynamicTable">
				
					</table>
			</div>
			<div id="supplierPDFormDivId">
			<input type="hidden" id="hiddenSPDID" />
				<table>
					<tr>
						<td>First Name :</td>
						<td><input type="text" id="supplierPDFNameId" placeholder="First Name"></td>
					</tr>
					<tr>
						<td>Last Name :</td>
						<td><input type="text" id="supplierPDLNameId" placeholder="Last Name"></td>
					</tr>
					<tr>
						<td>E mail :</td>
						<td><input type="text" id="supplierPDEmailId" placeholder="E mail"></td>
					</tr>
					<tr>
						<td>TP 1 :</td>
						<td><input type="text" id="supplierPDTp1Id" placeholder="Mobile Number"></td>
					</tr>
					<tr>
						<td>TP 2 :</td>
						<td><input type="text" id="supplierPDTp2Id" placeholder="Land Number"></td>
					</tr>
					<tr>
						<td>Skype :</td>
						<td><input type="text" id="supplierPDSkypeId" placeholder="Skype"></td>
					</tr>
					<tr>
						<td>Status :</td>
						<td><select id="supplierPDStatusId">
							<option value="">Select Status</option>
							<option value="1">Active</option>
							<option value="2">Inactive</option>
						</select></td>
					</tr>	
					<tr>
						<td>Address :</td>
						<td>
							<textarea rows="5" cols="20" id="supplierPDAddressId" placeholder="Address">
							</textarea>
						</td>
					</tr>	
					<tr>
						<td>Description :</td>
						<td><textarea rows="5" cols="20" id="supplierPDDescriptionId" placeholder="Description"></textarea></td>
					</tr>			
					<tr>
						<td></td>
						<td>
							<button id="supplierPDClearBtn" >Clear</button>
							<button id="supplierPDSaveBtn" onclick="supplierPDSave()">Save</button>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>