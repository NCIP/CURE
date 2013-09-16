/*******************************************************************************
 * Copyright (C) 2013 HealthCare IT, Inc. - All Rights Reserved
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium is strictly prohibited
 * Proprietary and confidential
 ******************************************************************************/
package com.healthcit.cacure.dao;

/**
 * @author Suleman Choudhry
 * @version
 */

import java.util.List;

import javax.persistence.Query;

//import org.apache.log4j.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.transaction.annotation.Transactional;

import com.healthcit.cacure.model.Role;
import com.healthcit.cacure.model.UserCredentials;

public class UserManagerDao extends BaseJpaDao<UserCredentials, Long> 
{

	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(UserManagerDao.class);

	public UserManagerDao()
	{
		super(UserCredentials.class);
	}

	@Transactional(readOnly=true)
	public UserCredentials findByName(String uName) {		
	    Query query = this.em.createQuery("from UserCredentials where username = :uName");
	    query.setParameter("uName", uName);	    
	    return (UserCredentials) query.getSingleResult();
	}	
	
	@Transactional(readOnly=true)
	@SuppressWarnings("unchecked")
	public List<Role> getUserRoles(UserCredentials user) {
		String jpql = "select u.roles from UserCredentials u where u = :user";
		Query query = em.createQuery(jpql);
	    query.setParameter("user", user);
		return query.getResultList();
	}
	
}
