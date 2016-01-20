package com.aurora.util;

import java.io.File;

public class Constant {
	  /**
	   * This is file upload local path
	   */
	public static final String FILE_UPLOAD_LOCAL = "/media/aurora/Other/fileUpload";
	   /**
	   * This is file upload server path
	   */
	public static final String FILE_UPLOAD_SERVER = "img"+File.separator+"otherImages";
	
	/**
	   * name of the parameter specifying the success.
	*/
	public static final String SUCCESS= "success";
	/**
	   * name of the parameter specifying the saved.
	*/
	public static final String SAVED= "saved";
	/**
	   * name of the parameter specifying the updated.
	*/
	public static final String UPDATED= "updated";
	/**
	   * name of the parameter specifying the fileexist.
	*/
	public static final String EXIST= "exist";
	/**
	   * name of the parameter specifying the fail.
	*/
	public static final String FAIL= "fail";
	
	/**
	   * name of the parameter specifying the current search string.
	*/
	public static final String PARAMETER_SEARCH = "q";
    /**
     * This is table size
     */
    public static final String TABLE_SIZE = "size";   
    /**
     * size of the grid table .
     */
    public static final int GRID_TABLE_SIZE = 5;
    /**
     * key for parse the grid table .
     */
    public static final String GRID_TABLE_SIZE_KEY = "gridSize";
	  /**
	   * This is districtTable table id
	   */
	public static final String TABLE_DISTRICT = "districtTable";
	  /**
	   * This is supplierCategoryTable table id
	   */
	public static final String TABLE_SUPPLIER_CATEGORY = "supplierCategoryTable";
	  /**
	   * This is imageCategoryTable table id
	   */
	public static final String TABLE_IMAGE_CATEGORY = "imageCategoryTable";
	  /**
	   * This is addDetailsTable table id
	   */
	public static final String TABLE_ADD_DETAILS= "addDetailsTable";
	  /**
	   * This is supplierDetails table id
	   */
	public static final String TABLE_SUPPLIER_DETAILS = "supplierDetailsTable";
	  /**
	   * This is companyDetails table id
	   */
	public static final String TABLE_COMPANY_DETAILS = "companyDetailsTable";
	  /**
	   * This is companyDetailW2 table id
	   */
	public static final String TABLE_COMPANY_DETAILW2 = "companyDetailsTableW2";
	  /**
	   * This is fileDetails table id
	   */
	public static final String TABLE_FILE_DETAILS = "fileDetailsTable";
}
