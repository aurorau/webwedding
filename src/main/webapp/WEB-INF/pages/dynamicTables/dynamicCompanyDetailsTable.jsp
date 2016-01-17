<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<display:table name="companyDetailsTable" class="tblDisplay display table table-bordered table-striped dynamic-table display_header_class" cellspacing="0" requestURI="./companyDetailsController/getCompanyDetailsTable" id="companyDetailsTable" sort="external" partialList="true" size="${size}" pagesize="${gridSize}" export="false">

	 <display:column title="Image" headerClass="text-left">	 
		<div class="col-md-12">
			<div class="col-md-2">
				<c:if test="${companyDetailsTable.logoUrl != 'No Logo'}">
					<img src="./fileUploadController/imageDownloader?fileName=${companyDetailsTable.logoUrl}" width="80" height="60" alt="Logo">
				</c:if>
				<c:if test="${companyDetailsTable.logoUrl == 'No Logo'}">
					<img width="80" height="60" alt="No Logo">
				</c:if>
			</div>
		</div>
	 </display:column>

	 <display:column property="companyName" sortable="true" sortName="companyName" headerClass="text-left sortable sorted order1" class="text-left" title="Company Name"/>
     <display:column property="companyEmail" sortable="true" sortName="companyEmail" headerClass="text-left sortable sorted order1" class="text-left" title="Company Email"/>
     <display:column property="budget" sortable="true" sortName="budget" headerClass="text-left sortable sorted order1" class="text-left" title="Budget"/>
     <display:column property="status" sortable="true" sortName="status" headerClass="text-left sortable sorted order1" class="text-left" title="Status"/>
<%--      <display:column property="supplierTp2" sortable="true" sortName="supplierTp2" headerClass="text-left sortable sorted order1" class="text-left" title="TP 2"/>
     <display:column property="supplierSkypeAddress" sortable="true" sortName="supplierSkypeAddress" headerClass="text-left sortable sorted order1" class="text-left" title="Skype"/> --%>
     <display:column  sortable="false" headerClass="text-center sortable sorted order1" title="Action" media="html">
		<div class="text-center">
			<%-- <button  onclick="companyDetailsView(${companyDetailsTable.SCDID})" class="view-btn"><span class="fa fa-view"></span>View</button> --%>
			<button onclick="companyDetailsEdit(${companyDetailsTable.SCDID})" class="edit-btn"><span class="fa fa-edit"> </span>Edit</button>
			<button  onclick="companyDetailsDelete(${companyDetailsTable.SCDID})" class="delete-btn"><span class="fa fa-close"></span>Delete</button>
		</div>
	</display:column>
	<display:setProperty name="basic.empty.showtable" value="true" />
	<display:setProperty name="basic.msg.empty_list" value="" />
</display:table>