<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href='css/backoffice.css' rel='stylesheet' type='text/css'>

<script src="js/jquery.js"></script>
<script src="js/common.js"></script>
<script src="js/jquery.displaytag-ajax-1.2.js"></script>
<script src="https://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<script src="js/backOfficeJS/companyPackageDetails.js"></script>
<html>
<head>
<title>Company Package Details</title>
</head>
<body>
	<div>
		<div style="width:20%;float: left">
		<h3><a href="backOffice">W2-Back Office</a></h3>
			<div class="menu">
				<ul><a href="#">Article Details</a></ul>
				<ul><a href="districtSetUp">District Details</a></ul>
				<ul><a href="supplierCategorySetUp">Supplier Category</a></ul>
				<ul><a href="imageCategoryController">Image Category</a></ul>
				<ul><a href="addDetailsController">Add Details</a></ul>
				<ul><a href="companyDetailsController">Supplier Company Details</a></ul>
				<ul><b>Company Package Details</b></ul>
				<ul><a href="companyOfferDetailsController">Company Offers Details</a></ul>
				<ul><a href="supplierDetailsController">Supplier Personal Details</a></ul>
				<ul><a href="fileUploadController">File Image Upload</a></ul>
			</div>
		</div>
				
		<div style="width:80%;float: right" id="content">
			<div style="float: left; width:100%">
			<h3>Company Package Details</h3>	
				<table style="float: left">
					<tbody class="search-body">
						<tr>			
						<td>
							<select id="companyDetailsId" onchange="hideBelow()"  class="search-input">
								<option value="">Select Company</option>
							</select>
						</td>
						<td><button onclick="loadCompanyPackageTable()" class="search-btn">Search</button></td>
						</tr>
					</tbody>
				</table>
			</div>
			
			<div id="companyPackageTableDivId" >
				<table id="companyPackageDynamicTable">
				</table>
				<button id="addNewCompanyPackage" onclick="newCompanyPackage()">Add new</button>
			</div>
			<div id="companyPackageFormDivId">
			<input type="hidden" id="hiddenCPDID" />
			<table>
				<tr>
					<td>
						<table>
							<tr>
								<td>Package Name :</td>
								<td><input type="text" id="packageNameId" placeholder="Package Name"></td>
							</tr>
							<tr>
								<td>Package Description :</td>
								<td><input type="text" id="packageDescriptionId" placeholder="Package Desiption"></td>
							</tr>
							<tr>
								<td>Package Status :</td>
								<td><select id="companyPackageStatusId">
									<option value="">Select Status</option>
									<option value="1">Active</option>
									<option value="2">Inactive</option>
								</select></td>
							</tr>	
<!-- 							<tr>
								<td>Company:</td>
								<td>
									<select id="companyDetailsId">
										<option value="">Select Company</option>
									</select>
								</td>
							</tr> -->
						</table>
					</td>
				</tr>
				
			</table>
				<table>	
					<tr>
						<td></td>
						<td>
							<button id="companyPackageClearBtn" >Clear</button>
							<button id="companyPackageDetailsSaveBtn" onclick="companyPackageSave()">Save</button>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>