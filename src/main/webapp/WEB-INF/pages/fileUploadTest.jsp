<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>jQuery File Upload Example</title>
<!-- <script src="js/jquery.1.9.1.min.js"></script> -->
<script src="js/jquery.js"></script>
 
<script src="js/vendor/jquery.ui.widget.js"></script>
<script src="js/fileUpload/jquery.iframe-transport.js"></script>
<script src="js/fileUpload/jquery.fileupload.js"></script>
 
<!-- bootstrap just to have good looking page -->
<script src="js/bootstrap.min.js"></script>
<link href="css/bootstrap.css" type="text/css" rel="stylesheet" />
 
<!-- we code these -->
<link href="css/dropzone.css" type="text/css" rel="stylesheet" />
<script src="js/fileUpload/myuploadfunction.js"></script>
</head>
 
<body>
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
        </tr>
    </table>
 
</div>
</body> 
</html>