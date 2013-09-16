/*******************************************************************************
 * Copyright (C) 2013 HealthCare IT, Inc. - All Rights Reserved
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium is strictly prohibited
 * Proprietary and confidential
 ******************************************************************************/
package com.healthcit.cacure.web.controller;

import java.util.Map;

//import org.apache.log4j.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;

import com.healthcit.cacure.businessdelegates.FormManager;
import com.healthcit.cacure.businessdelegates.ModuleManager;
import com.healthcit.cacure.dao.SkipPatternDao;
import com.healthcit.cacure.model.BaseForm;
import com.healthcit.cacure.model.FormSkipRule;
import com.healthcit.cacure.web.editors.SkipPatternPropertyEditor;

public class BaseFormEditController implements EditControllable{

	@Autowired
    protected FormManager formManager;

	@Autowired
	protected ModuleManager moduleMgr;

	@Autowired
	SkipPatternDao skipDao;
	
	private static final Logger log = LoggerFactory.getLogger(BaseFormEditController.class);
	public static final String COMMAND_NAME = "formCmd";
	public static final String MODULE_ID_NAME = "moduleId";

	@InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(null, "formSkip", new SkipPatternPropertyEditor<FormSkipRule>(FormSkipRule.class, skipDao));
    }

	/**
	 * Determines whether the current entity is open to modifications in the current
	 * context
	 * @param module
	 * @return true when editable
	 */
	public boolean isEditable(BaseForm form) {
		return formManager.isEditableInCurrentContext(form);
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean isModelEditable(ModelAndView mav)
	{
		Map map = mav.getModel();
		// get form from model
		Object o = map.get(COMMAND_NAME);
		if (o != null && o instanceof BaseForm )
		{
			return isEditable((BaseForm)o);
		}
		return false;
	}

	public void setFormManager(FormManager formManager) {
		this.formManager = formManager;
	}

	public void setModuleMgr(ModuleManager moduleMgr) {
		this.moduleMgr = moduleMgr;
	}
}
