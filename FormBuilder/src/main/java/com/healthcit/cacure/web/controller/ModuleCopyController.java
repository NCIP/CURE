/*******************************************************************************
 * Copyright (C) 2013 HealthCare IT, Inc. - All Rights Reserved
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium is strictly prohibited
 * Proprietary and confidential
 ******************************************************************************/
package com.healthcit.cacure.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import com.healthcit.cacure.model.Module;
import com.healthcit.cacure.utils.Constants;

@Controller
public class ModuleCopyController extends BaseModuleEditController {

	@RequestMapping(value=Constants.MODULE_COPY_URI, method = RequestMethod.POST)
	public View onSubmit(@RequestParam(value = "moduleId", required = true) Long moduleId) {
		
		Module module = (Module) moduleMgr.getModule(moduleId);
		
		moduleMgr.copyModule(module);
		
		return new RedirectView (Constants.MODULE_LISTING_URI, true);
    }

}
