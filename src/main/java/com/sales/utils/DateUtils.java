package com.sales.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtils {

	public static String addToCurrentDate(int daysToAdd) {

		System.out.println("Days to add: " + daysToAdd);

		// get calendar instance and add the number of days to it
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, daysToAdd);
		// format the string using the desired format (to match current database
		// records)

		System.out.println("New Date: " + cal.getTime().toString());
		
		return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
	}

}
