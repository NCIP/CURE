/*******************************************************************************
 * Copyright (C) 2013 HealthCare IT, Inc. - All Rights Reserved
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium is strictly prohibited
 * Proprietary and confidential
 ******************************************************************************/
package com.healthcit.cacure.xforms.uicontrols;

import java.util.List;

import org.jdom.Element;

import com.healthcit.cacure.businessdelegates.QuestionAnswerManager;
import com.healthcit.cacure.xforms.XFormsConstants;

public abstract class XFormUIControl implements XFormsConstants{
	
    protected QuestionAnswerManager qaManager;
	
	public abstract List<Element> getControlElements();
	
	protected Element createLabel(String text)
	{
		Element labelElem = new Element(LABEL_TAG, XFORMS_NAMESPACE);
		labelElem.setText(text);
		return labelElem;
	}
	
	protected Element createRefLabel(String xPathRef)
	{
		Element labelElem = new Element(LABEL_TAG, XFORMS_NAMESPACE);
		labelElem.setAttribute("ref", xPathRef);
		return labelElem;
	}
	
}
