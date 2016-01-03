<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<script src="js/jquery.js"></script>
<script src="js/backOfficeJS/supplierCategorySetUp.js"></script>
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
				<ul><a href="#">Company Category</a></ul>
				<ul><a href="#">Company Comments</a></ul>
				<ul><a >Supplier Category</a></ul>
				<ul><a href="#">Supplier Company Details</a></ul>
				<ul><a href="#">Supplier Personal Details</a></ul>
			</div>
		</div>
				
		<div style="width:80%;float: right" id="content">
			<div style="float: left; width:100%">
			<h3>Supplier Category</h3>	
				<table style="float: right">
					<tr>
						<td><input type="text" id="supplierCategorySearchId" placeholder="Search and Filter"/></td>
						<td><button onclick="supplierCategoryTable()">Search</button></td>
					</tr>
				</table>
			</div>
			
			<div id="supplierCategoryTableDivId" >
				<button id="addNewsupplierCategory" onclick="newsupplierCategory()">Add new</button>
					<table id="supplierCategoryDynamicTable">
				
					</table>
			</div>
			<div id="supplierCategoryFormDivId">
			<input type="hidden" id="hiddenSCID" />
				<table>
					<tr>
						<td>Supplier Category Type :</td>
						<td><input type="text" id="supplierCategoryTypeId" placeholder="Supplier Category Type"></td>
					</tr>
					<tr>
						<td>Supplier Category Name :</td>
						<td><input type="text" id="supplierCategoryNameId" placeholder="Supplier Category Name"></td>
					</tr>
					<tr>
						<td></td>
						<td>
							<button id="supplierCategoryClearBtn" >Clear</button>
							<button id="supplierCategorySaveBtn" onclick="supplierCategorySave()">Save</button>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>