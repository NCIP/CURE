/*******************************************************************************
 * Copyright (C) 2013 HealthCare IT, Inc. - All Rights Reserved
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium is strictly prohibited
 * Proprietary and confidential
 ******************************************************************************/
package com.healthcit.cacure.model.breadcrumb;

/**
 * Breadcrumb for Add/Edit question library pages.
 *
 */
public class QuestionLibraryBreadCrumb extends ManageLibraryBreadCrumb {
	
	private Action action;
	
	public QuestionLibraryBreadCrumb(Action action) {
		this.action = action;
	}
	
	@Override
	public Link getLink() {
		Link link = super.getLink();
		Link currentLink = null;
		if(Action.ADD.equals(this.action)){
			currentLink = new Link("Add Question Library", null, this);
		} else if(Action.EDIT.equals(this.action)){
			currentLink = new Link("Edit Question Library", null, this);
		}
		this.addLastChild(link, currentLink);
		return link;
	}
}
