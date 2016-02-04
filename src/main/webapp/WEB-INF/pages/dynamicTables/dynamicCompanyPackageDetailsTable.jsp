<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<display:table name="companyPackageDetailsTable" class="tblDisplay display table table-bordered table-striped dynamic-table display_header_class" cellspacing="0" requestURI="./companyPackageDetailsController/getCompanyPackageTable" id="companyPackageDetailsTable" sort="external" partialList="true" size="${size}" pagesize="${gridSize}" export="false">

	 <display:column property="packageName"  headerClass="text-left sortable sorted order1" class="text-left" title="Package Name"/>
     <display:column property="packageDescription" headerClass="text-left sortable sorted order1" class="text-left" title="Package Description"/>
     <display:column property="status" headerClass="text-left sortable sorted order1" class="text-left" title="Status"/>
     <display:column  sortable="false" headerClass="text-center sortable sorted order1" title="Action" media="html">
		<div class="text-center">
			<button onclick="companyPackageEdit(${companyPackageDetailsTable.CPDID})" class="edit-btn btn btn-primary"><span class="fa fa-edit"> </span>Edit</button>
			<button  onclick="companyPackageDelete(${companyPackageDetailsTable.CPDID})" class="delete-btn btn btn-danger"><span class="fa fa-close"></span>Delete</button>
		</div>
	</display:column>
	<display:setProperty name="basic.empty.showtable" value="true" />
	<display:setProperty name="basic.msg.empty_list" value="" />
</display:table>
