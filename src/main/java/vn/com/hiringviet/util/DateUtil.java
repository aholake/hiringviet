package vn.com.hiringviet.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

	/**
	 * Get now time
	 */
	public static Date now() {
		return Calendar.getInstance().getTime();
	}

	/**
	 * Get year of date input
	 */
	public static int getYear(Date time) {

		int year = 0;
		if (time != null) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(time);

			year = cal.get(Calendar.YEAR);
		}

		return year;
	}

	/**
	 * Format date to String
	 */
	public static String format(Date date, String format, Locale locale) {

		if (date != null && format != null && locale != null) {
			return new SimpleDateFormat(format, locale).format(date);
		}
		return null;
	}

	public static Date getTime(Long millisecond) throws Exception {

		Date time = null;
		if (millisecond != null) {

			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(millisecond);
			time = cal.getTime();
		}

		return time;
	}

	@SuppressWarnings("deprecation")
	public static Date getDateAgo(Integer value) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DATE, Calendar.getInstance().getTime().getDate() - value);
		return calendar.getTime();
	}
}
