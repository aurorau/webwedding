<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<display:table name="fileDetailsTable" class="tblDisplay display table table-bordered table-striped dynamic-table display_header_class" cellspacing="0" requestURI="./fileUploadController/getFileDetailsTable" id="fileDetailsTable" sort="external" partialList="true" size="${size}" pagesize="${gridSize}" export="false">

	 <display:column title="Image" headerClass="text-center">	 
		<div class="col-md-12">
			<div class="col-md-2">
				<img src="./fileUploadController/fileDownloader?UFID=${fileDetailsTable.UFID}" width="80" height="60" alt="Profile image">
			</div>
		</div>
	 </display:column>
	 <display:column property="imageName"  headerClass="text-left " class="text-left" title="Image Name"/>
     <display:column property="fileUploadDate"  headerClass="text-left " class="text-left" title="Uploaded Date"/>
     <display:column property="imageSize" headerClass="text-left" class="text-left" title="Image Size"/>
     
     <display:column  sortable="false" headerClass="text-center sortable sorted order1" title="Action" media="html">
		<div class="text-center">
			<button onclick="fileDetailsDelete(${fileDetailsTable.UFID})" class="delete-btn btn btn-danger"><span class="fa fa-close"></span>Delete</button>
		</div>
	</display:column>
	<display:setProperty name="basic.empty.showtable" value="true" />
	<display:setProperty name="basic.msg.empty_list" value="" />
</display:table>