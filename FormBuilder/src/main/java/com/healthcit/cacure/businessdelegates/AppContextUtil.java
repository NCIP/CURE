/*******************************************************************************
 * Copyright (C) 2013 HealthCare IT, Inc. - All Rights Reserved
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium is strictly prohibited
 * Proprietary and confidential
 ******************************************************************************/
package com.healthcit.cacure.businessdelegates;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class AppContextUtil implements ApplicationContextAware 
{
    private static final AppContextUtil instance = new AppContextUtil();
    private ApplicationContext applicationContext;

    private AppContextUtil() {}

    public static AppContextUtil getInstance() 
    {
        return instance;
    }

    public <T> T getBean(Class<T> clazz) 
    {
        return applicationContext.getBean(clazz);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException 
    {
        this.applicationContext = applicationContext;
    }
}
