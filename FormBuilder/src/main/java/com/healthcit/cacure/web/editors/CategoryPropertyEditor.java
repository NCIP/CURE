/*******************************************************************************
 * Copyright (C) 2013 HealthCare IT, Inc. - All Rights Reserved
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium is strictly prohibited
 * Proprietary and confidential
 ******************************************************************************/
package com.healthcit.cacure.web.editors;

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.healthcit.cacure.model.Category;

public class CategoryPropertyEditor extends PropertyEditorSupport {
	
	public CategoryPropertyEditor() { }
	
    @SuppressWarnings("unchecked")
	@Override
    public void setAsText(String jsonText) throws IllegalArgumentException {
    	List<Category> categories = new ArrayList<Category>();
    	JSONObject jsonDoc = JSONObject.fromObject(jsonText);
		Iterator<JSONObject> iter = jsonDoc.getJSONArray("categories").iterator();
		while (iter.hasNext()) {
			JSONObject jsonCategory = iter.next();
			Category category = new Category();
			category.setId(jsonCategory.getString("id").length() == 0 ? null : jsonCategory.getLong("id"));
			category.setName(jsonCategory.getString("name"));
			category.setDescription(jsonCategory.getString("description"));

			categories.add(category);
		}
    	setValue(categories);
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public String getAsText() {
    	List<Category> categories = (List<Category>) getValue();

    	JSONObject jsonCategories = new JSONObject();
    	JSONArray jsonArrayCategory = new JSONArray();
    	
    	for (Category category : categories) {
    		JSONObject jsonCategory = new JSONObject();
    		jsonCategory.put("id", category.getId());
    		jsonCategory.put("name", category.getName());
    		jsonCategory.put("description", category.getDescription());
    		jsonArrayCategory.add(jsonCategory);
    	}
    	jsonCategories.put("categories", jsonArrayCategory);
    	String res = jsonCategories.toString();
    	return res;
    }


	
	

}
