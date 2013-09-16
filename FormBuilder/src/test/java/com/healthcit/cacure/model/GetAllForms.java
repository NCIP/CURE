/*******************************************************************************
 * Copyright (C) 2013 HealthCare IT, Inc. - All Rights Reserved
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium is strictly prohibited
 * Proprietary and confidential
 ******************************************************************************/
package com.healthcit.cacure.model;


import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.EntityManagerHolder;
import org.springframework.orm.jpa.support.SharedEntityManagerBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.healthcit.cacure.businessdelegates.FormManager;
import com.healthcit.cacure.businessdelegates.QuestionAnswerManager;
import com.healthcit.cacure.dao.FormDao;
import com.healthcit.cacure.dao.ModuleDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/app-config.xml",
		"file:src/main/webapp/WEB-INF/spring/dao-config.xml", 
		"file:src/main/webapp/WEB-INF/spring/mailTemplates-config.xml"  
//		"file:src/main/webapp/WEB-INF/spring/security-config.xml" 
		})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
//
public class GetAllForms {
		@Autowired
		EntityManagerFactory emf;

		@Autowired
		SharedEntityManagerBean em;

		protected Session session;
		
		@Autowired
		FormManager fManager;
		
		
		@Before
	    public void setUp() {
//			EntityManagerFactory emf = (EntityManagerFactory)context.getBean("entityManagerFactory");
			EntityManager em = emf.createEntityManager();
			TransactionSynchronizationManager.bindResource(emf , new EntityManagerHolder(em));
	    }
		
		   @After
		    public void tearDown() throws Exception {
		    	TransactionSynchronizationManager.unbindResourceIfPossible(emf);
		    }
		   
		   
	@Test
		public void getAllChildren()
		{
			List<BaseForm> elements = fManager.getModuleForms(2l);
			assertNotNull(elements);
		}


}
