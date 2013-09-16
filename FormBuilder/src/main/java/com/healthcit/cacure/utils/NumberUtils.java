/*******************************************************************************
 * Copyright (C) 2013 HealthCare IT, Inc. - All Rights Reserved
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium is strictly prohibited
 * Proprietary and confidential
 ******************************************************************************/
package com.healthcit.cacure.utils;

import java.text.DecimalFormat;

import org.apache.commons.lang.StringUtils;

public class NumberUtils {
	
	private static String DOT = ".";
	private static String POUND = "#";
	
	public static boolean isWholeNumber( Number num ) 
	{
		if ( num == null ) return false;
		
		double doubleValue = num.doubleValue();
		
		return ( Math.rint( doubleValue ) == doubleValue );
	}
	
	public static Number getPrecision( Number num )
	{
		if ( num == null ) return num;
		
		if ( Math.rint( num.doubleValue() ) == num.doubleValue() ) return 0;
		
		return StringUtils.substringAfter( String.valueOf( num ), DOT ).length();
	}
	
	public static Number getScale( Number num )
	{
		if ( num == null ) return num;
		
		return StringUtils.substringBefore( String.valueOf( num ), DOT ).length();
	}
	
	public static Number roundDown( Number num, int requiredPrecision )
	{
		if ( num == null ) return null;
		
		Number roundedDownNumber = null;
		
		int scale = getScale( num ).intValue();
				
		String formatString = StringUtils.rightPad( StringUtils.leftPad( DOT, scale+1, POUND ), requiredPrecision+(scale+1), POUND );
		
		System.out.println( formatString );
				
		roundedDownNumber = Double.parseDouble( new DecimalFormat( formatString ).format( num ) );
				
		return roundedDownNumber;
		
	}
}
