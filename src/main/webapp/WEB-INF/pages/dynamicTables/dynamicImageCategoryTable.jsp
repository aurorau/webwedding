<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<display:table name="imageCategoryTable" class="tblDisplay display table table-bordered table-striped dynamic-table display_header_class" cellspacing="0" requestURI="./imageCategoryController/getImageCategoryTable" id="imageCategoryTable" sort="external" partialList="true" size="${size}" pagesize="${gridSize}" export="false">
	 <display:column title="Main Image" headerClass="text-left">	 
		<div class="col-md-12">
			<div class="col-md-2">
				<c:if test="${imageCategoryTable.icLogoUrl != 'No Logo'}">
					<img src="./fileUploadController/imageDownloader?fileName=${imageCategoryTable.icLogoUrl}" width="80" height="60" alt="Logo">
				</c:if>
				<c:if test="${imageCategoryTable.icLogoUrl == 'No Logo'}">
					<img width="80" height="60" alt="No Logo">
				</c:if>
			</div>
		</div>
	 </display:column>
	 <display:column property="icType" sortable="false" sortName="icType" headerClass="text-left sortable sorted order1" class="text-left" title="Type"/>
     <display:column property="icName" sortable="false" sortName="icName" headerClass="text-left sortable sorted order1" class="text-left" title="Name"/>
     <display:column  sortable="false" headerClass="text-center sortable sorted order1" title="Action" media="html">
		<div class="text-center">
			<button onclick="imageCategoryEdit(${imageCategoryTable.ICID})" class="edit-btn"><span class="fa fa-edit"> </span>Edit</button>
			<button  onclick="imageCategoryDelete(${imageCategoryTable.ICID})" class="delete-btn"><span class="fa fa-close"></span>Delete</button>
		</div>
	</display:column>
	<display:setProperty name="basic.empty.showtable" value="true" />
	<display:setProperty name="basic.msg.empty_list" value="" />
</display:table>