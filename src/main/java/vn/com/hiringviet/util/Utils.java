package vn.com.hiringviet.util;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import vn.com.hiringviet.dto.MemberDTO;

public class Utils {

	/**
	 * function check string empty or not
	 * 
	 * @param str
	 * @return status string
	 * @author AnhNT
	 */
	public static String getStringValue(String str) {

		if (!isEmptyString(str)) {
			return str;
		}
		return "";
	}

	/**
	 * function check string empty or not
	 * 
	 * @param str
	 * @return status string
	 * @author AnhNT
	 */
	public static boolean isEmptyString(String str) {
		boolean isEmpty = true;

		// check string not empty
		if (str != null && !"".equals(str)) {
			isEmpty = false;
		}

		return isEmpty;
	}

	/**
	 * function check list object empty
	 * 
	 * @param list
	 * @return status list
	 * @author AnhNT
	 */
	public static boolean isEmptyList(List<?> list) {
		boolean isEmpty = true;

		// check list not empty
		if (list != null && list.size() > 0) {
			isEmpty = false;
		}

		return isEmpty;
	}

	/**
	 * function check number empty
	 * 
	 * @param numner
	 * @return status number
	 * @author AnhNT
	 */
	public static boolean isEmptyNumber(Integer number) {
		boolean isEmpty = true;

		// check Integer not empty
		if (number != null && number > 0) {
			isEmpty = false;
		}

		return isEmpty;
	}

	/** init value for integer if its value is null
	 * 
	 * @param value
	 * @return its value
	 */
	public static int intValue(Integer value) {
		if (value != null) {
			return value;
		}
		return 0;
	}

	/**
	 * function get page current
	 * 
	 * @param totalRecord
	 * @param numberRecordInpage
	 * @param pageCurrent
	 * @return page current
	 * @author AnhNT
	 */
	public static int getPageCurrent(int totalRecord, int numberRecordInpage, int pageCurrent) {
		// get max page
		int pages = (int) Math.ceil((double) totalRecord / numberRecordInpage);
		// check page overlimit
		if (pageCurrent > pages) {
			pageCurrent = pages;
		}
		
		// check if page is zero
		if (pageCurrent == 0) {
			pageCurrent = 1;
		}
		
		return pageCurrent;
	}

	public static int getFirstResult(int page, int maxItem) {

		if (page > 0) {
			return (page * maxItem) - maxItem;
		} else {
			return 0;
		}
	}

	public static int getTotalPage(long maxItem, int maxRecord) {

		if (maxItem > 0) {
			return (int) Math.ceil((double) maxRecord / maxItem);
		} else {
			return 0;
		}
	}

	public static MemberDTO getMemberSession(HttpSession session) {
		return (MemberDTO) session.getAttribute("memberDTO");
	}

	public static boolean isEmptyObject(Object object) {
		boolean isEmpty = true;

		// check object not empty
		if (object != null) {
			isEmpty = false;
		}

		return isEmpty;
	}
	
	public static void copyProperties(Object source, Object target) {
		try {
			BeanUtils.copyProperties(source, target);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
