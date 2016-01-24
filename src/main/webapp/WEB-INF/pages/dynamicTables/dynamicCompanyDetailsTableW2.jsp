<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<display:table name="companyDetailsTableW2" class="tblDisplay display table table-bordered table-striped dynamic-table display_header_class" cellspacing="0" requestURI="./companyDetailsController/getCompanyDetailsTableW2" id="companyDetailsTableW2" sort="external" partialList="true" size="${size}" pagesize="${gridSize}" export="false">

	<display:column>
		 <div class="clearfix"></div>
		<!--  <div class="col-md-10 col-sm-12 category-box"> -->
			<div class="col-lg-10 col-sm-6 col-xs-12 portfolio-item">
                    <a href="#service1" class="portfolio-link" data-toggle="modal" onclick="getCompanyDetailsW2(${companyDetailsTableW2.SCDID})">
                        <div class="portfolio-hover">
                            <div class="portfolio-hover-content">
                                <i class="fa fa-plus fa-3x"></i>
                            </div>
                        </div>
                        <img src="./fileUploadController/imageDownloader1?ITID=${companyDetailsTableW2.ITID}" class="img-responsive" alt="" width="300">
                    </a>
                    <div class="portfolio-caption">
                    	<span>${companyDetailsTableW2.budget} upward</span>
                        	<a href="#portfolio" id="${companyDetailsTableW2.SCDID}" class="add-to-cart" data-toggle="tooltip" title="Add to Cart" onclick="addToCart('${companyDetailsTableW2.SCDID}','${companyDetailsTableW2.companyName}','${companyDetailsTableW2.budget}')"><span class="fa fa-shopping-cart fa-2x"></span></a>
                    </div>
                </div>
            <div class="clearfix"></div>
		<!-- </div> -->
	</display:column>
	<display:column>
		 <div class="clearfix"></div>
			<div class=".col-md-8">
                        <div>
                            <div class="contact-details">
                                <span class="fa fa-user"></span>${companyDetailsTableW2.supplierPersonalDetailsFName} ${companyDetailsTableW2.supplierPersonalDetailsFLName}
                                <div class="clearfix"></div>
                                <span class="fa fa-map-marker"></span>${companyDetailsTableW2.companyAddress}
                                <div class="clearfix"></div>
                                <span class="fa fa-sitemap"></span><span>No Branches</span>
                                <div class="clearfix"></div>
                                <span class="fa fa-phone"></span>${companyDetailsTableW2.companyTp1}
                                <div class="clearfix"></div>
                                <span class="fa fa-envelope"></span><a href="mailto:hilton@gmail.com">${companyDetailsTableW2.companyEmail}</a>
                                <div class="clearfix"></div>
                                <span class="fa fa-facebook"></span><a href="https://www.facebook.com/hilton/" target="_blank">${companyDetailsTableW2.companyFbPage}</a>
                                <div class="clearfix"></div>
                                <span class="fa fa-skype"></span>${companyDetailsTableW2.supplierPersonalDetailsSkype}
                                <div class="clearfix"></div>
                                <span class="fa fa-globe"></span><a href="hilton.com" target="_blank">${companyDetailsTableW2.companyWebURl}
                            </div>
                        </div>
			</div>
		 <div class="clearfix"></div>
	</display:column>
	<display:setProperty name="basic.empty.showtable" value="true" />
	<display:setProperty name="basic.msg.empty_list" value="" />
</display:table>