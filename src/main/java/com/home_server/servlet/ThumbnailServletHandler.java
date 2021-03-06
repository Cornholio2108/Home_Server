package com.home_server.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;



/**
 * This class is a part of Spring-to-Servlet setup, as detailed here:
 * 
 * 	https://www.sourceallies.com/2012/02/injecting-spring-beans-into-java-servlets/
 * 
 * The Servlet handling part is adapted from and an abbreviated version of these:
 * 
 * https://github.com/omnifaces/omnifaces/blob/3.3/src/main/java/org/omnifaces/servlet/FileServlet.java
 * and https://github.com/omnifaces/omnifaces/blob/3.3/src/main/java/org/omnifaces/util/Servlets.java
 * 
 * This thumbnail servlet supports caching 
 */
@Component("thumbnailServletHandler")
public class ThumbnailServletHandler implements HttpRequestHandler {

	private static final Logger logger = LoggerFactory.getLogger(ThumbnailServletHandler.class);
	
	// set browser cache to expire in 5 minutes
	// TODO: make EXPIRE_TIME_IN_SECONDS configurable through application properties file
	private static final Long EXPIRE_TIME_IN_SECONDS = TimeUnit.MINUTES.toSeconds(5);
//	
//	@Value("#{ '${FileUpload.rootDirectory}' + systemProperties['file.separator'] + '${Comment.thumbnailPath}' }")
//	private String thumbnailDirectory;
//	
//	@Resource
//	private GenericService genericService;
//	
//	@Override
//	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		
//		response.reset();
//		
//		// pathInfo contains fileInfo id
//		String pathInfo = request.getPathInfo();
//		
//		if(pathInfo != null && pathInfo.length() > 1) {
//			// remove the leading "/" character in the pathInfo
//			pathInfo = pathInfo.substring(1);
//		}
//		
//		Long fileInfoId = null;
//		try {
//			fileInfoId = new Long(pathInfo);
//		}
//		catch(NumberFormatException e) {
//			logger.warn("Bad requested pathInfo, not a valid number: " + pathInfo);
//			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
//			return;
//		}
//		
//		FileInfo fileInfo = genericService.getEntity(FileInfo.class, fileInfoId).getDataObject();
//		
//		// make sure this is a valid fileInfoId
//		if(fileInfo == null) {
//			logger.warn("Bad requested pathInfo, not a valid fileInfo id: " + pathInfo);
//			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
//			return;
//		}
//		
//		response.setContentType(fileInfo.getContentType());
//		
//		InputStream is = null;
//		
//		File thumbnailFile = new File(this.thumbnailDirectory + File.separator + fileInfo.getPath());
//		
//		if(thumbnailFile.exists()) {
//			is = new FileInputStream(thumbnailFile);
//			
//			String eTag = buildETag(thumbnailFile);
//			
//			setCacheHeaders(response, eTag, EXPIRE_TIME_IN_SECONDS);
//			
//			if(notModified(request, eTag, thumbnailFile.lastModified())) {
//				is.close();
//				response.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
//				return;
//			}
//		}
//		else {
//			logger.warn("Bad requested pathInfo, not a valid fileInfo id: " + pathInfo);
//			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
//			return;
//		}		
//		
//		// OK, now serve up the binary content:
//		// note per document, this method (or all method of IOUtils for that matter) buffers data internally
//		// so no need to use a BufferedInputStream or BufferedOutputStream
//		IOUtils.copy(is, response.getOutputStream());
//		
//		is.close();
//	}

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
}
