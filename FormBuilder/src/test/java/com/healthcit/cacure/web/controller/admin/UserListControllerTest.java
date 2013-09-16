/*******************************************************************************
 * Copyright (C) 2013 HealthCare IT, Inc. - All Rights Reserved
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium is strictly prohibited
 * Proprietary and confidential
 ******************************************************************************/
package com.healthcit.cacure.web.controller.admin;

import java.util.ArrayList;
import java.util.List;

import org.easymock.classextension.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.healthcit.cacure.businessdelegates.UserManager;
import com.healthcit.cacure.model.Role;
import com.healthcit.cacure.model.UserCredentials;
import com.healthcit.cacure.model.Role.RoleCode;


public class UserListControllerTest {
	private UserManager userManager;
	private UserListController userListController;
	
	
	@Before
	public void setUp() {
		userListController = new UserListController();
		userManager = EasyMock.createMock(UserManager.class);
		userListController.setUserManager(userManager);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testShowForms() {
		List<UserCredentials> users = new ArrayList<UserCredentials>();
		users.add(createMockUserCredentials(1l));
		users.add(createMockUserCredentials(2l));
		EasyMock.expect(userManager.getAllUsers()).andReturn(users);
		EasyMock.replay(userManager);
		ModelAndView expected = createMockModelAndView(1l);
		ModelAndView actual = userListController.showUserList();
		Assert.assertNotNull(actual);
		Assert.assertEquals((((List<UserCredentials>)expected.getModelMap().get("users")).size()), ((List<UserCredentials>)expected.getModelMap().get("users")).size());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testDelete() {
		ModelAndView expected = createMockModelAndView(1l);
		ModelAndView actual = userListController.deleteUser(1l, true);
		Assert.assertNotNull(actual);
		Assert.assertEquals((((List<UserCredentials>)expected.getModelMap().get("users")).size()), ((List<UserCredentials>)expected.getModelMap().get("users")).size());
	}
	
	private UserCredentials createMockUserCredentials(Long id) {
		UserCredentials user =new UserCredentials();
		user.setId(id);
		Role author = new Role();
		author.setRoleCode(RoleCode.ROLE_ADMIN);
		user.addRole(author);
		return user;
	}
	
	private ModelAndView createMockModelAndView(long moduleId) {
		List<UserCredentials> users = new ArrayList<UserCredentials>();
		users.add(createMockUserCredentials(1l));
		users.add(createMockUserCredentials(2l));
		ModelAndView modelAndView = new ModelAndView("userList", "users", users);
		return modelAndView;
	}
}

