<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>File Image Upload</title>
<!-- <script src="js/jquery.1.9.1.min.js"></script> -->
<script src="js/jquery.js"></script>
<script src="js/common.js"></script>
<script src="js/jquery.displaytag-ajax-1.2.js"></script>
<script src="https://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<script src="js/vendor/jquery.ui.widget.js"></script>
<script src="js/fileUpload/jquery.iframe-transport.js"></script>
<script src="js/fileUpload/jquery.fileupload.js"></script>
 
<!-- bootstrap just to have good looking page -->
<script src="js/bootstrap.min.js"></script>
<link href="css/bootstrap.css" type="text/css" rel="stylesheet" />
<link href='css/common-style.css' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">
 
<!-- we code these -->
<!-- <link href="css/dropzone.css" type="text/css" rel="stylesheet" /> -->
<script src="js/backOfficeJS/myuploadfunction.js"></script>
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
				<ul><a href="addDetailsController">Add Details</a></ul>
				<ul><a href="companyDetailsController">Supplier Company Details</a></ul>
				<ul><a href="supplierDetailsController">Supplier Personal Details</a></ul>
				<ul><b>File Image Upload</b></ul>
			</div>
		</div>
				
		<div style="width:80%;float: right" id="content">
			<div style="float: left; width:100%">
			<h3>File Image Upload</h3>	
				<div>
					<label>Search/ Upload :</label>
					<br><input type="radio" name ="seach" value="supplier" id="supplierRadioBtn" onclick="hidePanel()"> Supplier Category
					<br><input type="radio" name ="seach" value="image" id="imageRadioBtn" onclick="hidePanel()"> Image Category
					<br><button onclick="selectCategory()"> Go</button>
				</div>
				<table style="float: left" id="searchTableId">
					<tr>
						<td>
							<select id="fileCategoryId" onchange="categoryChange()">
								<option value="">Select Supplier Category</option>
							</select>
						</td>
						<td>
							<select id="fileCompanyId">
								<option value="">Select Company</option>
							</select>
						</td>
						<td>
							<select id="fileImageCategoryId">
								<option value="">Select Image Category</option>
							</select>
						</td>
						<td><button onclick="loadFileDetailsTable()">Search</button></td>
					</tr>
				</table>
<!-- 				<table style="float: right">
					<tr>
						<td><input type="text" id="fileSearchId" placeholder="Search and Filter"/></td>
						<td><button onclick="loadFileDetailsTable()">Search</button></td>
					</tr>
				</table> -->
			</div>
			
			<div id="fileTableDivId" >
				<table id="fileDynamicTable">
				</table>
				<button id="addNewFile" onclick="newFile()">Add new</button>
			</div>
			<div id="fileFormDivId">
			<input type="hidden" id="hiddenUFID" />
				<table>
					<tr>
						<td>File Upload Date :</td>
						<td><input type="text" class="datepicker" id="fileUploadDateId" placeholder="File Upload Date"></td>
					</tr>
					<tr>
						<td>File Type :</td>
							<td><select id="fileTypeId">
								<option value="">Select Type</option>
								<option value="1">Image</option>
								<option value="2">Logo</option>
								<!-- <option value="2">Article</option>
								<option value="3">Pending</option>
								<option value="4">Suspend</option> -->
							</select></td>
					</tr>
					<tr>
						<td>Upload File :</td>
							<td><input id="fileupload" type="file" name="files[]"  multiple>
							<!-- data-url="fileUploadController/upload" -->
						</td>
					</tr>	
					<tr>
						<td></td>
						<td><input type="hidden" id="fileHiddenUrl"></td>
					</tr>									
					<tr>
						<td></td>
						<td>
							<button id="fileClearBtn" >Clear</button>
							<button id="fileSaveBtn" onclick="fileSave()">Save</button>
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
 
 
 
 
 
 
<!-- <body>
<h1>Spring MVC - jQuery File Upload</h1>
<div style="width:500px;padding:20px">
 
    <input id="fileupload" type="file" name="files[]" data-url="fileUploadController/upload" multiple>
 
    <div id="dropzone">Drop files here</div>
 
    <div id="progress">
        <div style="width: 0%;"></div>
    </div>
 
    <table id="uploaded-files">
        <tr>
            <th>File Name</th>
            <th>File Size</th>
            <th>File Type</th>
            <th>Download</th>
            <th>Delete</th>
        </tr>
    </table>
 
</div>
</body>  -->
</html>