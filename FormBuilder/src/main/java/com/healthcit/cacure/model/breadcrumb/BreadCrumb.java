/*******************************************************************************
 * Copyright (C) 2013 HealthCare IT, Inc. - All Rights Reserved
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium is strictly prohibited
 * Proprietary and confidential
 ******************************************************************************/
package com.healthcit.cacure.model.breadcrumb;

import org.apache.commons.lang.StringUtils;


/**
 * Model to display breadcrumb on a page.
 *
 */
public interface BreadCrumb {
	
	public static final int MAX_LABEL_LENGTH = 25;
	
	public enum Action{
		ADD, EDIT, DELETE;
	}
	
	/**
	 * Returns breadcrumb link.
	 * 
	 * @return breadcrumb link
	 */
	public Link getLink();
	
	public static class Link {

		private static final String NAME_ALL_ATTR = "name_all_json=true";
		private String name;
		private String url;
		private String nameAllUrl;
		private Link childLink;
		private BreadCrumb breadCrumb;
		
		public Link(final String name, String url, BreadCrumb breadCrumb) {
			this.name = name;
			this.url = url;
			if(StringUtils.isNotBlank(url)) {
				nameAllUrl = url + (url.contains("?") ? "&" : "?") + NAME_ALL_ATTR;
			}
			this.breadCrumb = breadCrumb;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public void setUrl(String url) {
			if(StringUtils.isBlank(nameAllUrl)) {
				nameAllUrl = url + (url.contains("?") ? "&" : "?") + NAME_ALL_ATTR;
			}
			this.url = url;
		}
		
		public String getName() {
			return name;
		}
		
		public String getUrl() {
			return url;
		}
		
		public Link getChildLink() {
			return childLink;
		}
		
		public void setChildLink(Link childLink) {
			this.childLink = childLink;
		}
		
		public boolean hasChild() {
			return this.childLink != null;
		}

		public BreadCrumb getBreadCrumb() {
			return breadCrumb;
		}

		public void setBreadCrumb(BreadCrumb breadCrumb) {
			this.breadCrumb = breadCrumb;
		}

		public String getNameAllUrl() {
			return nameAllUrl;
		}

		public void setNameAllUrl(String nameAllUrl) {
			this.nameAllUrl = nameAllUrl + (nameAllUrl.contains("?") ? "&" : "?") + NAME_ALL_ATTR;
		}
	}
}
