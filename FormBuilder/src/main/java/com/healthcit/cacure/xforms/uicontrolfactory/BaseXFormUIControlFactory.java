/*******************************************************************************
 * Copyright (C) 2013 HealthCare IT, Inc. - All Rights Reserved
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium is strictly prohibited
 * Proprietary and confidential
 ******************************************************************************/
package com.healthcit.cacure.xforms.uicontrolfactory;

import java.util.ArrayList;
import java.util.List;

import com.healthcit.cacure.businessdelegates.QuestionAnswerManager;
import com.healthcit.cacure.model.FormElement;
import com.healthcit.cacure.xforms.XFormsConstants.SubmissionControls;
import com.healthcit.cacure.xforms.uicontrols.XFormUIControl;

public abstract class BaseXFormUIControlFactory {
	public XFormUIControl createXFormUIControl(FormElement fe, QuestionAnswerManager qaManager){
		return null;
	}	

	public XFormUIControl createSubmissionControl(SubmissionControls s){
		return null;
	}
	
	public XFormUIControl createFormTitleControl(){
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	public List createCustomJSScripts() {
		return new ArrayList();
	}
}
