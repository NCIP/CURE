/*******************************************************************************
 * Copyright (C) 2013 HealthCare IT, Inc. - All Rights Reserved
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium is strictly prohibited
 * Proprietary and confidential
 ******************************************************************************/
package com.healthcit.cacure.model;

import static org.junit.Assert.assertEquals;

import java.util.EnumSet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.healthcit.cacure.model.Answer.AnswerType;
import com.healthcit.cacure.test.AbstractIntegrationTestCase;
import com.healthcit.cacure.test.DataSet;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:extend-and-override-config.xml"})
@TransactionConfiguration(defaultRollback=true)
public class FormElementTest extends AbstractIntegrationTestCase {

	@PersistenceContext
	private EntityManager em;
	
	@Test
	@DataSet
	public void testRead() {
		TableElement staticTable = em.find(TableElement.class, 1044L);
		EnumSet<AnswerType> expected = EnumSet.of(AnswerType.TEXT,
				AnswerType.NUMBER,
				AnswerType.DROPDOWN,
				AnswerType.YEAR,
				AnswerType.MONTHYEAR,
				AnswerType.DATE,
				AnswerType.DROPDOWN);
		
		//assertEquals(expected, staticTable.getAnswerTypes());
	}
	
}
