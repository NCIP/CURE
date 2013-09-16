/*******************************************************************************
 * Copyright (C) 2013 HealthCare IT, Inc. - All Rights Reserved
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium is strictly prohibited
 * Proprietary and confidential
 ******************************************************************************/
package com.healthcit.cacure.model;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="skip_rule")
@DiscriminatorValue("formElementSkip")
public class FormElementSkipRule extends BaseSkipRule{

	@OneToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},  fetch=FetchType.LAZY )
	@JoinColumn(name="parent_id")
	private FormElement element;
	

	
	public FormElement getFormElement() {
		return element;
	}

	public void setFormElement(FormElement element) {
		this.element = element;
	}
	
	@PrePersist
	@PreUpdate
	@PreRemove
	@SuppressWarnings("unused")
	private void onUpdate() {
		BaseForm form = getFormElement().getForm();
		form.setLastUpdatedBy(form.getLockedBy());
	}
	
	@Override
	public FormElementSkipRule clone()
	{
		FormElementSkipRule o = new FormElementSkipRule();
		o.setLogicalOp(logicalOp);
		return o;
	}
}
