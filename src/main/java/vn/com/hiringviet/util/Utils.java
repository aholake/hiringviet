package vn.com.hiringviet.util;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import vn.com.hiringviet.common.DegreeEnum;
import vn.com.hiringviet.common.StatusEnum;
import vn.com.hiringviet.constant.ConstantValues;
import vn.com.hiringviet.dto.PagingDTO;
import vn.com.hiringviet.model.ChangeLog;

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
	 * Checks if is empty set.
	 *
	 * @param list
	 *            the list
	 * @return true, if is empty set
	 */
	public static boolean isEmptySet(Set<?> list) {
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

	/**
	 * init value for integer if its value is null
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
	public static int getPageCurrent(int totalRecord, int numberRecordInpage,
			int pageCurrent) {
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

	public static PagingDTO calculatorPaging(PagingDTO pagingDTO,
			boolean fromStart) {

		if (fromStart) {
			if (ConstantValues.FIRST_RECORD == pagingDTO.getFirstItem()) {
				pagingDTO.setFirstItem(ConstantValues.FIRST_RECORD);
				pagingDTO.setCurrentPage(ConstantValues.CURRENT_PAGE);
			} else {
				pagingDTO.setFirstItem((pagingDTO.getCurrentPage() * ConstantValues.MAX_RECORD_COUNT) + 1);
				pagingDTO.setCurrentPage(pagingDTO.getCurrentPage() + 1);
			}
		} else {
			pagingDTO.setFirstItem((pagingDTO.getCurrentPage() * ConstantValues.MAX_RECORD_COUNT) + 1);
			pagingDTO.setCurrentPage(pagingDTO.getCurrentPage() + 1);
		}

		return pagingDTO;
	}

	public static boolean contains(List<?> list, List<?> sublist) {
		return Collections.indexOfSubList(list, sublist) != -1;
	}

	public static ChangeLog createDefaultChangeLog() {
		ChangeLog changeLog = new ChangeLog();
		changeLog.setStatus(StatusEnum.ACTIVE);
		changeLog.setCreatedDate(DateUtil.now());
		changeLog.setUpdatedDate(DateUtil.now());
		return changeLog;
	}

	public static int getAccountIdFromActiveCode(String activeCode) {
		int textLength = activeCode.length();
		return Integer.parseInt(activeCode.substring(0, textLength
				- TextGenerator.RANDOM_ACTIVE_STRING_LENGTH));
	}

	@SuppressWarnings("deprecation")
	public static List<Integer> generatorListYear() {

		Integer currentYear = (DateUtil.now().getYear() + 1900);

		List<Integer> list = new ArrayList<Integer>();

		currentYear += 10;
		for (int i = 40; i >= 0; i--) {
			list.add(currentYear--);
		}

		return list;
	}

	public static ChangeLog generatorChangeLog() {
		ChangeLog changeLog = new ChangeLog();
		changeLog.setCreatedDate(DateUtil.now());
		changeLog.setUpdatedDate(DateUtil.now());
		changeLog.setStatus(StatusEnum.ACTIVE);
		return changeLog;
	}

	public static HashMap<String, String> generatorDegree() {
		HashMap<String, String> maps = new HashMap<String, String>();
		maps.put(DegreeEnum.D1.getStatus(), DegreeEnum.D1.getValue());
		maps.put(DegreeEnum.D2.getStatus(), DegreeEnum.D2.getValue());
		maps.put(DegreeEnum.D3.getStatus(), DegreeEnum.D3.getValue());
		maps.put(DegreeEnum.D4.getStatus(), DegreeEnum.D4.getValue());
		maps.put(DegreeEnum.D5.getStatus(), DegreeEnum.D5.getValue());
		return maps;
	}

	public static HttpServletResponse exportWord(HttpServletResponse response,
			String fileName) {
		response.setContentType("application/msword");
		response.setHeader("Content-disposition", "inline; filename="
				+ fileName + ".odt");
		return response;
	}

	public static HttpServletResponse exportPDF(HttpServletResponse response,
			String fileName) {
		response.setContentType("application/x-pdf");
		response.setHeader("Content-disposition", "inline; filename="
				+ fileName + ".pdf");
		return response;
	}
}
