/*******************************************************************************
 * Copyright (C) 2013 HealthCare IT, Inc. - All Rights Reserved
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium is strictly prohibited
 * Proprietary and confidential
 ******************************************************************************/
package com.healthcit.cacure.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.log4j.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.healthcit.cacure.utils.ResourceBundleMessageSource;

/**
 * This interceptor is responsible for building the menu of breadcrumbs that is
 * displayed for a given controller.
 * 
 * @author Oawofolu
 * 
 */
public class MessageBundleInterceptor extends HandlerInterceptorAdapter {

	/*-------------------*/
	/* Logger */
	/*-------------------*/
	@SuppressWarnings("unused")
	private static Logger log = LoggerFactory
			.getLogger(MessageBundleInterceptor.class);

	/*-------------------*/
	/* Static Strings */
	/*-------------------*/
	private static final String MESSAGE_MAP = "messagesMap";

	@Autowired
	ResourceBundleMessageSource resourceMessageSource;

	/* HandlerInterceptor method */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		// Add the breadcrumb list to the ModelMap with the key "breadCrumbList"
		if (modelAndView != null) {
			modelAndView.getModelMap().addAttribute(MESSAGE_MAP,
					resourceMessageSource.getMessages(request.getLocale()));
		}

	}

}
