/*******************************************************************************
 * Copyright (C) 2013 HealthCare IT, Inc. - All Rights Reserved
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium is strictly prohibited
 * Proprietary and confidential
 ******************************************************************************/
package com.healthcit.cacure.model.breadcrumb;

import com.healthcit.cacure.model.BaseModule;

/**
 * Breadcrumb for Add/Edit module form pages.
 *
 */
public class FormBreadCrumb extends ModuleDetailsBreadCrumb {

	private Action action;
	
	public FormBreadCrumb(BaseModule module, Action action) {
		super(module);
		this.action = action;
	}

	@Override
	public Link getLink() {
		Link link = super.getLink();
		Link currentLink = null;
		if(Action.ADD.equals(this.action))
		{
			currentLink = new Link("Add Section", null, this);
		} else if(Action.EDIT.equals(this.action)) {
			currentLink = new Link("Edit Section", null, this);
		}
		this.addLastChild(link, currentLink);
		return link;
	}
}
