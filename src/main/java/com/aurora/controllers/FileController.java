package com.aurora.controllers;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.displaytag.tags.TableTagParameters;
import org.displaytag.util.ParamEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.aurora.dao.ImageTableDao;
import com.aurora.model.FileMeta;
import com.aurora.model.ImageTable;
import com.aurora.model.UploadFiles;
import com.aurora.service.FileUploadService;
import com.aurora.util.Constant;
import com.aurora.util.FileUploadDTO;
import com.aurora.util.JsonResponce;
import com.lowagie.tools.concat_pdf;


@Controller
@RequestMapping("/fileUploadController")
public class FileController implements ServletContextAware{

	 private ImageTableDao imageTableDao = null;
	
     LinkedList<FileMeta> files = null; 
     FileMeta fileMeta = null;
     ServletContext servletContext;
	 FileUploadService fileUploadService = null;
	 String testFileUploadLocation = Constant.FILE_UPLOAD_LOCAL;
	 String UPLOAD_DIRECTORY = Constant.FILE_UPLOAD_SERVER;
	
	 @Autowired
	 public void setFileUploadService(FileUploadService fileUploadService) {
		 this.fileUploadService = fileUploadService;
	 }
	@Autowired
	public void setImageTableDao(ImageTableDao imageTableDao) {
		this.imageTableDao = imageTableDao;
	}
    
	 @RequestMapping(method = RequestMethod.GET)
	 public ModelAndView districtDetails() throws Exception {
		 return new ModelAndView("fileImageUpload");
	 }
	 
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public ServletContext getServletContext() {
        return servletContext;
    }
    
    
    /***************************************************
     * URL: /rest/controller/upload  
     * upload(): receives files
     * @param request : MultipartHttpServletRequest auto passed
     * @param response : HttpServletResponse auto passed
     * @return LinkedList<FileMeta> as json format
     ****************************************************/
    @RequestMapping(value="/upload", method = RequestMethod.POST)
    public @ResponseBody LinkedList<FileMeta> upload(MultipartHttpServletRequest request, HttpServletResponse response) {
    	 files = new LinkedList<FileMeta>();
        //1. build an iterator
         Iterator<String> itr =  request.getFileNames();
         MultipartFile mpf = null;
         String prefix = request.getParameter("prefix");
         //2. get each file
         while(itr.hasNext()){
 
             //2.1 get next MultipartFile
             mpf = request.getFile(itr.next()); 
             System.out.println(mpf.getOriginalFilename() +" uploaded! "+files.size());
 
             //2.2 if files > 10 remove the first from the list
             if(files.size() >= 10)
                 files.pop();
             
             String oriFileEx = null;
             String oriFileName= mpf.getOriginalFilename();
             oriFileEx = oriFileName.substring(oriFileName.lastIndexOf("."));
             oriFileName = oriFileName.substring(0,oriFileName.lastIndexOf("."));
             oriFileName = oriFileName.concat("_"+prefix);
             
             String newFileName = oriFileName.concat(oriFileEx);
             //String uploadDir = servletContext.getRealPath(File.separator+"img"+File.separator+"otherImages");
             //2.3 create new fileMeta
             fileMeta = new FileMeta();
             fileMeta.setFileName(testFileUploadLocation+File.separator+newFileName);
             fileMeta.setFileSize(mpf.getSize()/1024+" Kb");
             fileMeta.setFileType(mpf.getContentType());
             try {
               fileMeta.setBytes(mpf.getBytes());
                
               //String UPLOAD_DIRECTORY ="img"+File.separator+"otherImages";
               //String uploadPath = servletContext.getRealPath("") +UPLOAD_DIRECTORY;
               
                
              //  System.out.println("uploadPath with image:"+uploadPath+File.separator+mpf.getOriginalFilename());
               System.out.println("uploadDir:"+testFileUploadLocation);
                
              // FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(uploadPath+File.separator+mpf.getOriginalFilename()));
               FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(testFileUploadLocation+File.separator+newFileName));
                
            } catch (IOException e) {
               System.out.println("File upload error :"+e);
            }

             //2.4 add to files
             files.add(fileMeta);
         }
        // result will be like this
        // [{"fileName":"app_engine-85x77.png","fileSize":"8 Kb","fileType":"image/png"},...]
        return files;
    }
    /***************************************************
     * URL: /rest/controller/get/{value}
     * get(): get file as an attachment
     * @param response : passed by the server
     * @param value : value from the URL
     * @return void
     ****************************************************/
    @RequestMapping(value = "/get/{value}", method = RequestMethod.GET)
     public void get(HttpServletResponse response,@PathVariable String value){
         FileMeta getFile = files.get(Integer.parseInt(value));
         try {      
                response.setContentType(getFile.getFileType());
                response.setHeader("Content-disposition", "attachment; filename=\""+getFile.getFileName()+"\"");
                FileCopyUtils.copy(getFile.getBytes(), response.getOutputStream());
         }catch (IOException e) {
        	 System.out.println("File get Error :"+e);
         }
     }
    /***************************************************
     * URL: /rest/controller/deleteFile/{value}
     * deleteFile(): delete file from physical location
     * @param response : passed by the server
     * @param value : value from the URL
     * @return void
     ****************************************************/
    @RequestMapping(value = "/deleteFile", method = RequestMethod.GET)
     public  @ResponseBody JsonResponce deleteFile(HttpServletRequest request,HttpServletResponse response){
    	JsonResponce res= new JsonResponce();
    	String fstatus = Constant.FAIL;
        boolean status = false;
         try {        	
        	 Long fileId = ServletRequestUtils.getLongParameter(request, "fileId");
        	// String fileName = ServletRequestUtils.getStringParameter(request, "fileUrl");
        	 //System.out.println("File Name :"+fileName);
        	 
        	 String deleteStatus = fileUploadService.deleteImage(fileId);
        	// String uploadPath = servletContext.getRealPath("") +UPLOAD_DIRECTORY;
        	 
      /*  	 if(deleteStatus.equalsIgnoreCase(Constant.SUCCESS)) {
            	 File file = new File(fileName);
            	 status = file.delete();
        	 }*/
        	 if(status){
        		 fstatus = Constant.SUCCESS;
        		//System.out.println("Deleted :"+fileName); 
        	 } else {
        		 System.out.println("Delete operation is failed.");
        	 }
         }catch (Exception e) {
                System.out.println("Delete file error:"+e);
         }
         res.setStatus(fstatus);
         return res;
     }
    /***************************************************
     * URL: /rest/controller/saveFile
     * saveFile(): saveFile to db
     * @param response : passed by the server
     * @param value : value from the URL
     * @return void
     ****************************************************/
    @RequestMapping(value = "/saveFile", method = RequestMethod.POST)
     public  @ResponseBody JsonResponce saveFile(MultipartHttpServletRequest request,HttpServletResponse response){
		 JsonResponce res= new JsonResponce();
		 
		 String status = fileUploadService.saveFile(request);
		 
		 res.setStatus(status);
		 
		 return res;
     }
    /***************************************************
     * URL: /rest/controller/saveFile
     * saveFile(): saveFile to db
     * @param response : passed by the server
     * @param value : value from the URL
     * @return void
     ****************************************************/
	 @RequestMapping(method = RequestMethod.GET, value="/getFileDetailsTable")
	 public ModelAndView getFileDetailsTable(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 Model model = new ExtendedModelMap();
		 ParamEncoder paramEncoder = new ParamEncoder(Constant.TABLE_FILE_DETAILS);
		 
	    	try{
	    		String sortField = ServletRequestUtils.getStringParameter(request, paramEncoder.encodeParameterName(TableTagParameters.PARAMETER_SORT));
	    		int order = ServletRequestUtils.getIntParameter(request, paramEncoder.encodeParameterName(TableTagParameters.PARAMETER_ORDER), 0);
	    		int page = ServletRequestUtils.getIntParameter(request, paramEncoder.encodeParameterName(TableTagParameters.PARAMETER_PAGE), 0);
	    		int start = (page>0) ? (page - 1) * 5 : 0;
	    		String searchq = ServletRequestUtils.getStringParameter(request, Constant.PARAMETER_SEARCH);
	    		Long caterogyId = ServletRequestUtils.getLongParameter(request, "fileCategoryId",0L);
	    		Long companyId = ServletRequestUtils.getLongParameter(request, "fileCompanyId",0L);
	    		Long fileImageCategoryId = ServletRequestUtils.getLongParameter(request, "fileImageCategoryId",0L);
			
	    		List<FileUploadDTO> uploadFilesList = fileUploadService.getFileDetailsTable(sortField,order,start, 5,caterogyId,companyId,fileImageCategoryId, searchq);
	    		int uploadFilesCount = fileUploadService.getFileDetailsTableCount(caterogyId,companyId,fileImageCategoryId,searchq);
			
	    		request.setAttribute(Constant.TABLE_SIZE, uploadFilesCount );
	    		request.setAttribute(Constant.GRID_TABLE_SIZE_KEY, 5);
	    		model.addAttribute(Constant.TABLE_FILE_DETAILS, uploadFilesList);
	    	} catch (Exception e) {
	    		System.out.println(e);
	    	}
		 
		 
		 return new ModelAndView("dynamicTables/dynamicFileDetailsTable", model.asMap());
	 }
	    /***************************************************
	     * URL: /rest/controller/getImagesByImageCategoryId
	     * getImagesByImageCategoryId(): get files from db
	     * @param response : passed by the server
	     * @param value : value from the URL
	     * @return JsonResponce
	     ****************************************************/
		 @RequestMapping(method = RequestMethod.GET, value="/getImagesByImageCategoryId")
		 public @ResponseBody JsonResponce getImagesByImageCategoryId(HttpServletRequest request, HttpServletResponse response) throws Exception {
			 JsonResponce res= new JsonResponce();
			 
			 Long fileImageCategoryId = ServletRequestUtils.getLongParameter(request, "fileImageCategoryId",0L);
			 
			 List<FileUploadDTO> uploadFilesList = fileUploadService.getImagesByImageCategoryId(fileImageCategoryId);
			 if(uploadFilesList.size() > 0 ) {
				 res.setStatus(Constant.SUCCESS);
				 res.setResult(uploadFilesList);
			 } else {
				 res.setStatus(Constant.FAIL);
			 }
			 
			 
			 return res;
		 }
	    /**
	     * ImageDownloader
		 * @param request
		 * @param response
		 * @return FileSystemResource
		 * @throws Exception
		 */
		 @RequestMapping(value = "/imageDownloader", method = RequestMethod.GET)
		 public @ResponseBody void imageDownloader(HttpServletRequest request, HttpServletResponse response) throws Exception {	

			 String filename = null;
		     Pattern p = Pattern.compile("([^\\s]+(\\.(?i)(xlsx|xlsm|xlsb|xls|xlm|xltx|xlam|xla|xlw|jpg|png|gif|bmp|jpeg|pdf|doc|docx))$)");

		     	//String uploadPath = servletContext.getRealPath("") +UPLOAD_DIRECTORY;
		        filename = request.getParameter("fileName");
		        
		        if(!filename.equalsIgnoreCase("") && filename != null) {
			        Matcher m = p.matcher(filename);
			        
			        FileInputStream in = null;
			        OutputStream out = null;
			        try {
			        	if (m.matches()) {

				            System.out.println("file Name: " + filename);
				            
				            //filename = filename;
				            
				            // Get the MIME type of the PDF
				            ServletContext sc = getServletContext();
				            String mimeType = sc.getMimeType(filename);
				            System.out.println("mimeType" + mimeType);
				            if (mimeType == null) {
				                mimeType = "application/octet-stream";
				            }

				            // Set content type
				            response.setContentType(mimeType);

				            // Set content size
				            File file = new File(filename);
				        
				            response.setContentLength((int) file.length());
				            
				            // Open the file and output streams
				            in = new FileInputStream(file);
				            out = response.getOutputStream();

				            // Copy the contents of the file to the output stream
				            byte[] buf = new byte[1024];
				            int count = 0;
				            while ((count = in.read(buf)) >= 0) {
				                out.write(buf, 0, count);
				            }

				        }
			        	
					} catch (RuntimeException e) {
					    throw e;
					}  catch (Exception e) {
					} finally{
						try {
				            out.flush();
				            in.close();
				            out.close();
						} catch (Exception e2) {
							e2.printStackTrace();
						}
					}
		        } else{
		        	System.out.println("No file name");
		        }

		 }
		 
	    /**
	     * ImageDownloader
		 * @param request
		 * @param response
		 * @return FileSystemResource
		 * @throws Exception
		 */
		 @RequestMapping(value = "/imageDownloader1", method = RequestMethod.GET)
		 public @ResponseBody void imageDownloader1(HttpServletRequest request, HttpServletResponse response) throws Exception {
			 
			 	Long imageId = Long.parseLong(request.getParameter("ITID"));
				ImageTable it = imageTableDao.getImageDetailsByITID(imageId);
				try {
					response.setHeader("Content-Disposition", "inline;filename=\"" +it.getImageName()+ "\"");
					OutputStream out = response.getOutputStream();
					response.setContentType(it.getImageType());
					IOUtils.copy(new ByteArrayInputStream(it.getImageContent()), out);
					out.flush();
					out.close();
				
				} catch (IOException e) {
					e.printStackTrace();
				} 
		 }
		 
		    /**
		     * ImageDownloader
			 * @param request
			 * @param response
			 * @return FileSystemResource
			 * @throws Exception
			 */
			 @RequestMapping(value = "/fileDownloader", method = RequestMethod.GET)
			 public @ResponseBody void fileDownloader(HttpServletRequest request, HttpServletResponse response) throws Exception {
				 
				 	Long ufid = Long.parseLong(request.getParameter("UFID"));
				 	UploadFiles uf = fileUploadService.getFileByUFID(ufid);
					try {
						response.setHeader("Content-Disposition", "inline;filename=\"" +uf.getImageName()+ "\"");
						OutputStream out = response.getOutputStream();
						response.setContentType(uf.getImageType());
						IOUtils.copy(new ByteArrayInputStream(uf.getImageContent()), out);
						out.flush();
						out.close();
					
					} catch (IOException e) {
						e.printStackTrace();
					} 
			 }
}
