/*******************************************************************************
 * Copyright (C) 2013 HealthCare IT, Inc. - All Rights Reserved
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium is strictly prohibited
 * Proprietary and confidential
 ******************************************************************************/
package com.healthcit.cacure.web.function;

import com.healthcit.cacure.model.FormLibraryForm;
import com.healthcit.cacure.model.FormLibraryModule;
import com.healthcit.cacure.model.Module;
import com.healthcit.cacure.model.QuestionLibraryForm;
import com.healthcit.cacure.model.QuestionnaireForm;
import com.healthcit.cacure.model.QuestionsLibraryModule;
import com.healthcit.cacure.utils.Constants;

public class ObjectUrlBuilder {
	
	private String EDIT_ACTION;
	private String LIST_ACTION;
	
	public static String buildObjectUrl(Object object, String action)
	{
		if(object instanceof Module)
		{
			return buildModuleUrl(action);
		}
		else if(object instanceof FormLibraryModule)
		{
			return buildFormLibraryModuleUrl(action);
		}
		else if(object instanceof QuestionsLibraryModule)
		{
			return buildQuestionLibraryModuleUrl(action);
		}
		else if(object instanceof QuestionnaireForm)
		{
			return buildQuestionnarieFormUrl(action);
		}
		else if(object instanceof FormLibraryForm)
		{
			return buildFormLibraryFormUrl(action);
		}
		else if(object instanceof QuestionLibraryForm)
		{
			return buildQuestionLibraryFormUrl(action);
		}
		return Constants.MODULE_LISTING_URI;
	}
	
	private static String buildModuleUrl(String action)
	{
		if("EDIT".equals(action))
		{
			return Constants.MODULE_EDIT_URI;
		} 
		return Constants.MODULE_LISTING_URI;
	}
	
	public static String buildFormLibraryModuleUrl(String action)
	{
		if("EDIT".equals(action))
		{
			return Constants.FORM_LIBRARY_EDIT_URI;
		}
		return Constants.LIBRARY_MANAGE_URI;
	}
	
	public static String buildQuestionLibraryModuleUrl(String action)
	{
		if("EDIT".equals(action))
		{
			return Constants.QUESTION_LIBRARY_EDIT_URI;
		}
		return Constants.LIBRARY_MANAGE_URI;
	}
	
	private static String buildQuestionnarieFormUrl(String action)
	{
		if("EDIT".equals(action))
		{
			return Constants.QUESTIONNAIREFORM_EDIT_URI;
		}
		return Constants.QUESTIONNAIREFORM_LISTING_URI;
	}
	
	private static String buildFormLibraryFormUrl(String action)
	{
		if("EDIT".equals(action))
		{
			return Constants.FORM_LIBRARY_FORM_EDIT_URI;
		}
		return Constants.QUESTIONNAIREFORM_LISTING_URI;
	}
	
	private static String buildQuestionLibraryFormUrl(String action)
	{
		if("EDIT".equals(action))
		{
			return Constants.QUESTION_LIBRARY_FORM_EDIT_URI;
		}
		return Constants.QUESTIONNAIREFORM_LISTING_URI;
	}
}
