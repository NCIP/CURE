/*******************************************************************************
 * Copyright (C) 2013 HealthCare IT, Inc. - All Rights Reserved
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium is strictly prohibited
 * Proprietary and confidential
 ******************************************************************************/
package com.healthcit.cacure.web.controller.admin;


import java.util.List;

//import org.apache.log4j.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.healthcit.cacure.businessdelegates.UserManager;
import com.healthcit.cacure.businessdelegates.UserManagerService;
import com.healthcit.cacure.model.UserCredentials;
import com.healthcit.cacure.utils.Constants;

@Controller

public class UserListController {
	private static final Logger log = LoggerFactory.getLogger(UserListController.class);
	
	@Autowired
	private UserManager userManager;
	
	@Autowired
	private UserManagerService userService;
	
	@RequestMapping(value=Constants.USER_LISTING_URI)
	public ModelAndView showUserList() {
		return getModel();
	}

//	@RequestMapping(value=Constants.HOME_URI)
//	public ModelAndView showHome() {
//		return getModel();
//	}
	
	/**
	 * delete user from list.
	 * @param moduleId Long
	 * @param delete boolean
	 * @return view with list of Module items
	 */
	@RequestMapping(value = Constants.USER_LISTING_URI, method = RequestMethod.GET, params = {"userId", "delete"})
	public ModelAndView deleteUser(@RequestParam(value = "userId", required = true) Long userId, 
			@RequestParam(value = "delete", required = true) boolean delete) {
		if (delete) {
			// TODO - add 		
		}
		return getModel();
	}	

	
	private ModelAndView getModel() {
		List<UserCredentials> users;
		log.info("in UserListController. showList....");
		try // TODO: handle errors appropriately through error binding
		{
			users =  userService.getAllUsers();			
		}
		catch (Exception e)
		{			
			log.error(e.getMessage(),e);
			return null; 
		}		
		return new ModelAndView("userList", "users", users );
		
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

}	

