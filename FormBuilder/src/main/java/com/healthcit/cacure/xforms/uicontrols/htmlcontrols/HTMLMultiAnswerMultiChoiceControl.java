/*******************************************************************************
 * Copyright (C) 2013 HealthCare IT, Inc. - All Rights Reserved
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium is strictly prohibited
 * Proprietary and confidential
 ******************************************************************************/
package com.healthcit.cacure.xforms.uicontrols.htmlcontrols;

import com.healthcit.cacure.businessdelegates.QuestionAnswerManager;
import com.healthcit.cacure.model.Answer;
import com.healthcit.cacure.model.TableElement;
import com.healthcit.cacure.xforms.XFormsConstants;
import com.healthcit.cacure.xforms.XFormsConstructionException;
import com.healthcit.cacure.xforms.XFormsUtils;

public class HTMLMultiAnswerMultiChoiceControl extends HTMLMultiAnswerAnyChoiceControl
{
	
	public HTMLMultiAnswerMultiChoiceControl(TableElement fe, QuestionAnswerManager qaManager)
	{
		super(fe, qaManager);
	}
	
	@Override
	protected String getSelectControlName()
	{
		return SELECT_TAG;
	}
	
	@Override
	protected String getBaseCssClass(Answer answer)
	{
		return XFormsConstants.CSS_CLASS_ANSWER_RADIO;
	}
	
	@Override
	protected String getControlTextRef()
	{
		if(formElement instanceof TableElement)
		{
			return XFormsUtils.getTableQuestionTextXPath((TableElement)formElement);
	}
		else
			throw new XFormsConstructionException("Element is not a table '" + formElement.getUuid() + "'");
	
	}

}
