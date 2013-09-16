/*******************************************************************************
 * Copyright (C) 2013 HealthCare IT, Inc. - All Rights Reserved
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium is strictly prohibited
 * Proprietary and confidential
 ******************************************************************************/
package com.healthcit.cacure.model.breadcrumb;

/**
 * Breadcrumb for Add/Edit Form Library pages.
 *
 */
public class FormLibraryBreadCrumb extends ManageLibraryBreadCrumb {
	private Action action;
	
	public FormLibraryBreadCrumb(Action action) {
		this.action = action;
	}
	
	@Override
	public Link getLink() {
		Link link = super.getLink();
		Link currentLink = null;
		if(Action.ADD.equals(this.action)){
			currentLink = new Link("Add Form Library", null, this);
		} else if(Action.EDIT.equals(this.action)){
			currentLink = new Link("Edit Form Library", null, this);
		}
		this.addLastChild(link, currentLink);
		return link;
	}
}
