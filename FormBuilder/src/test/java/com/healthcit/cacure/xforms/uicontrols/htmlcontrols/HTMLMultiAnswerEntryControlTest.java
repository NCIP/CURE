/*******************************************************************************
 * Copyright (C) 2013 HealthCare IT, Inc. - All Rights Reserved
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium is strictly prohibited
 * Proprietary and confidential
 ******************************************************************************/
package com.healthcit.cacure.xforms.uicontrols.htmlcontrols;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jdom.Element;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.healthcit.cacure.businessdelegates.QuestionAnswerManager;
import com.healthcit.cacure.model.TableElement;
import com.healthcit.cacure.model.TableQuestion;
import com.healthcit.cacure.test.AbstractIntegrationTestCase;
import com.healthcit.cacure.test.DataSet;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:extend-and-override-config.xml"})
public class HTMLMultiAnswerEntryControlTest extends AbstractIntegrationTestCase {

	@Autowired
	protected QuestionAnswerManager qaManager;
	
	@PersistenceContext
	private EntityManager em;
	
	@Test
//	@DataSet("")
	public void testGetAnswerElementsWithEmbeddedTags() {
		TableElement staticTable = (TableElement) qaManager.getFormElement(100L);
		HTMLMultiAnswerEntryControl control = new HTMLMultiAnswerEntryControl(staticTable, qaManager);
//		control.skipAffectee(list, question);
	}
	
	@Test
	@DataSet("classpath:skips_on_tables.xml")
	public void testSkipAffectee() {
		TableElement staticTable = (TableElement) qaManager.getFormElement(1024L);
		HTMLMultiAnswerEntryControl control = new HTMLMultiAnswerEntryControl(staticTable, qaManager);
//		control.getAnswerElementsWithEmbeddedTags();
		ArrayList<Element> list = new ArrayList<Element>();
		control.addSkips(list, staticTable.getFirstQuestion());
	}
}
