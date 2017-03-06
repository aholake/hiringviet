package vn.com.hiringviet.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

// TODO: Auto-generated Javadoc
/**
 * The Class DateUtil.
 */
public class DateUtil {

	/**
	 * Get now time.
	 *
	 * @return the date
	 */
	public static Date now() {
		return Calendar.getInstance().getTime();
	}

	/**
	 * Get year of date input.
	 *
	 * @param time the time
	 * @return the year
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
	 * Format date to String.
	 *
	 * @param date the date
	 * @param format the format
	 * @param locale the locale
	 * @return the string
	 */
	public static String format(Date date, String format, Locale locale) {

		if (date != null && format != null && locale != null) {
			return new SimpleDateFormat(format, locale).format(date);
		}
		return null;
	}

	/**
	 * Gets the time.
	 *
	 * @param millisecond the millisecond
	 * @return the time
	 * @throws Exception the exception
	 */
	public static Date getTime(Long millisecond) throws Exception {

		Date time = null;
		if (millisecond != null) {

			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(millisecond);
			time = cal.getTime();
		}

		return time;
	}

	/**
	 * Gets the date ago.
	 *
	 * @param value the value
	 * @return the date ago
	 */
	@SuppressWarnings("deprecation")
	public static Date getDateAgo(Integer value) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DATE, Calendar.getInstance().getTime().getDate() - value);
		return calendar.getTime();
	}
}
