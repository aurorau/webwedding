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
</head>
<body>
	<div>
		<div style="width:20%;float: left">
		<h3>W2-Back Office</h3>
			<div>
				<ul><a href="#">Article Set up</a></ul>
				<ul><a href="districtSetUp">District Details</a></ul>
				<ul><a href="#">Category Gallery</a></ul>
				<!-- <ul><a href="#">Company Category</a></ul> -->
				<ul><a href="#">Company Comments</a></ul>
				<ul><a href="supplierCategorySetUp">Supplier Category</a></ul>
				<ul><a href="companyDetailsController">Supplier Company Details</a></ul>
				<ul><b>Supplier Personal Details</b></ul>
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