package com.ssm.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyUtil {
	
	public static String newDateToString() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		Date date=new Date();  
		String str=sdf.format(date);
		return str;
	}
	
	public static Date stringToDate(String str) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		Date date = null;
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

}
