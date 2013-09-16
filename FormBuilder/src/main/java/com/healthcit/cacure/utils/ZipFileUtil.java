/*******************************************************************************
 * Copyright (C) 2013 HealthCare IT, Inc. - All Rights Reserved
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium is strictly prohibited
 * Proprietary and confidential
 ******************************************************************************/
package com.healthcit.cacure.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

//import org.apache.log4j.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.healthcit.cacure.businessdelegates.QuestionAnswerManager;
import com.healthcit.cacure.model.BaseForm;
import com.healthcit.cacure.model.Module;
import com.healthcit.cacure.xforms.XForm;
import com.healthcit.cacure.xforms.XModuleModel;
import com.healthcit.cacure.xforms.XForm.XFormContainerType;

public class ZipFileUtil {
	
	/** Mar File Ouptut */
	private static final Logger logger = LoggerFactory.getLogger(ZipFileUtil.class);
	
	/** The xml files extension */
	public final static String XML_FILE_EXTENSION = "xml";
	public final static String XFORM_FILE_EXTENSION = "xform";
	
	public static void writeMar(Module module, OutputStream oStream, QuestionAnswerManager qaManager) {
		ZipOutputStream zipOutStream = null;
		ByteArrayOutputStream baos = null;
		try {
			baos = new ByteArrayOutputStream();
			zipOutStream = new ZipOutputStream(baos);
			
			List<BaseForm> forms = module.getForms();
			
			// First we add the forms
			for(BaseForm form : forms) {
				
				String fileName = String.format("%s.%s", form.getUuid(), XFORM_FILE_EXTENSION);
				ZipEntry xformZipEntry = new ZipEntry(fileName);
				XForm xForm = new XForm( form, XFormContainerType.HTML , qaManager);
				Writer zipWriter = new PrintWriter(zipOutStream);
				try {
					zipOutStream.putNextEntry(xformZipEntry);
					xForm.write(zipWriter);
				} catch (Exception e) {
					logger.error("Error outputing module: " + module.getId(), e);
				}
			}
			
			// Then the metadata
			String fileName = "metaData." + XML_FILE_EXTENSION;
			ZipEntry metadataZipEntry = new ZipEntry(fileName);
			
			try {
				zipOutStream.putNextEntry(metadataZipEntry);
				XModuleModel moduleModel = new XModuleModel(module);
				moduleModel.writeMetadata(zipOutStream);
				zipOutStream.finish();
			} catch (IOException e) {
				logger.error("Error outputing module: " + module.getId(), e);
			}
			
			baos.writeTo(oStream);
		} catch (IOException e) {
			logger.error("Error outputing module: " + module.getId(), e);
			e.printStackTrace();
		} 
		catch (Exception e)
		{
			logger.error("Error outputing module: " + module.getId(), e);
			e.printStackTrace();
		}finally {
		
			try {
				zipOutStream.close();
				baos.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}	
		}
	}
	
}
