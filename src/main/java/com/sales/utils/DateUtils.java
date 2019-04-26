package com.sales.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtils {

	public static String addToCurrentDate(int daysToAdd) {

		// get calendar instance and add the number of days to it
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, daysToAdd);
		// format the string using the desired format (to match current database
		// records)
		return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
	}

}
