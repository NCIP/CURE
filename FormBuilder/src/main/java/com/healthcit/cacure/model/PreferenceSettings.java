/*******************************************************************************
 * Copyright (C) 2013 HealthCare IT, Inc. - All Rights Reserved
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium is strictly prohibited
 * Proprietary and confidential
 ******************************************************************************/
package com.healthcit.cacure.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="preferences")
public class PreferenceSettings {
	@Id
	@SequenceGenerator(name = "genericSequence", sequenceName = "\"GENERIC_ID_SEQ\"", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genericSequence")
	protected Long id;
	
	@Column(name = "show_please_select_option")
	protected boolean showPleaseSelectOptionInDropDown = false;
	
	@Column(name = "insert_check_all_that_apply")
	protected boolean insertCheckAllThatApplyForMultiSelectAnswers = false;

	public boolean isShowPleaseSelectOptionInDropDown() {
		return showPleaseSelectOptionInDropDown;
	}

	public void setShowPleaseSelectOptionInDropDown(boolean showPleaseSelectOptionInDropDown) {
		this.showPleaseSelectOptionInDropDown = showPleaseSelectOptionInDropDown;
	}

	public boolean isInsertCheckAllThatApplyForMultiSelectAnswers() {
		return insertCheckAllThatApplyForMultiSelectAnswers;
	}

	public void setInsertCheckAllThatApplyForMultiSelectAnswers(
			boolean insertCheckAllThatApplyForMultiSelectAnswers) {
		this.insertCheckAllThatApplyForMultiSelectAnswers = insertCheckAllThatApplyForMultiSelectAnswers;
	}
	
}
