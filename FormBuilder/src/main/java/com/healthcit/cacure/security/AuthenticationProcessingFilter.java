/*******************************************************************************
 * Copyright (C) 2013 HealthCare IT, Inc. - All Rights Reserved
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium is strictly prohibited
 * Proprietary and confidential
 ******************************************************************************/
package com.healthcit.cacure.security;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.log4j.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.healthcit.cacure.businessdelegates.UserManager;
import com.healthcit.cacure.businessdelegates.UserManagerService;
import com.healthcit.cacure.model.UserCredentials;
import com.healthcit.cacure.utils.Constants;

/**
 * Filter for authentification.
 * @author vetali
 *
 */
public class AuthenticationProcessingFilter extends UsernamePasswordAuthenticationFilter {
		//org.springframework.security.ui.webapp.AuthenticationProcessingFilter {
	
	
	private static Logger log = LoggerFactory.getLogger(AuthenticationProcessingFilter.class);

	@Autowired
    private UserManager userManager;
	
	@Autowired
    private UserManagerService userService;

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

		try{
			//call to daoAuthenticationProvider
			Authentication auth = super.attemptAuthentication(request, response);
			
			//store currentUser in HttpSession
			UserCredentials currentUser = userService.findByName(auth.getName()); 
			request.getSession().setAttribute(Constants.CURRENT_USER, currentUser);
			
			//display info about currentUser
			Collection<GrantedAuthority> gs = auth.getAuthorities();
			StringBuilder sb = new StringBuilder("===== Authentification Succesful : userName = " + auth.getName()); 
			sb.append(" with roles: ");
			for (GrantedAuthority x : gs){
				sb.append(x.getAuthority()).append(",");
			}			
			log.info(sb.toString());			
			return auth;
		} catch(AuthenticationException e) {
			log.info("Login wasn't successful for " + obtainUsername(request));
			throw e;
		}
	}

}
