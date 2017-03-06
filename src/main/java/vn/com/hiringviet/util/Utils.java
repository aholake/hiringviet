package vn.com.hiringviet.util;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import vn.com.hiringviet.common.CommonEnum;
import vn.com.hiringviet.common.DegreeEnum;
import vn.com.hiringviet.common.StatusEnum;
import vn.com.hiringviet.constant.ConstantValues;
import vn.com.hiringviet.dto.PagingDTO;
import vn.com.hiringviet.model.ChangeLog;
import vn.com.hiringviet.model.Company;
import vn.com.hiringviet.model.Job;

// TODO: Auto-generated Javadoc
/**
 * The Class Utils.
 */
public class Utils {

	/**
	 * function check string empty or not.
	 *
	 * @author AnhNT
	 * @param str the str
	 * @return status string
	 */
	public static String getStringValue(String str) {

		if (!isEmptyString(str)) {
			return str;
		}
		return "";
	}

	/**
	 * function check string empty or not.
	 *
	 * @author AnhNT
	 * @param str the str
	 * @return status string
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
	 * function check list object empty.
	 *
	 * @author AnhNT
	 * @param list the list
	 * @return status list
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
	 * function check number empty.
	 *
	 * @author AnhNT
	 * @param number the number
	 * @return status number
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
	 * init value for integer if its value is null.
	 *
	 * @param value the value
	 * @return its value
	 */
	public static int intValue(Integer value) {
		if (value != null) {
			return value;
		}
		return 0;
	}

	/**
	 * function get page current.
	 *
	 * @author AnhNT
	 * @param totalRecord the total record
	 * @param numberRecordInpage the number record inpage
	 * @param pageCurrent the page current
	 * @return page current
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

	/**
	 * Gets the first result.
	 *
	 * @param page the page
	 * @param maxItem the max item
	 * @return the first result
	 */
	public static int getFirstResult(int page, int maxItem) {

		if (page > 0) {
			return (page * maxItem) - maxItem;
		} else {
			return 0;
		}
	}

	/**
	 * Gets the total page.
	 *
	 * @param maxItem the max item
	 * @param maxRecord the max record
	 * @return the total page
	 */
	public static int getTotalPage(long maxItem, int maxRecord) {

		if (maxItem > 0) {
			return (int) Math.ceil((double) maxRecord / maxItem);
		} else {
			return 0;
		}
	}

	/**
	 * Checks if is empty object.
	 *
	 * @param object the object
	 * @return true, if is empty object
	 */
	public static boolean isEmptyObject(Object object) {
		boolean isEmpty = true;

		// check object not empty
		if (object != null) {
			isEmpty = false;
		}

		return isEmpty;
	}

	/**
	 * Copy properties.
	 *
	 * @param source the source
	 * @param target the target
	 */
	public static void copyProperties(Object source, Object target) {
		try {
			BeanUtils.copyProperties(source, target);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Calculator paging.
	 *
	 * @param pagingDTO the paging dto
	 * @param fromStart the from start
	 * @return the paging dto
	 */
	public static PagingDTO calculatorPaging(PagingDTO pagingDTO,
			boolean fromStart) {

		if (fromStart && ConstantValues.FIRST_RECORD == pagingDTO.getFirstItem()) {
			pagingDTO.setFirstItem(ConstantValues.FIRST_RECORD);
			pagingDTO.setCurrentPage(ConstantValues.CURRENT_PAGE);
		} else {
			pagingDTO.setFirstItem((pagingDTO.getCurrentPage() * ConstantValues.MAX_RECORD_COUNT));
			pagingDTO.setCurrentPage(pagingDTO.getCurrentPage() + 1);
		}

		return pagingDTO;
	}

	/**
	 * Contains.
	 *
	 * @param list the list
	 * @param sublist the sublist
	 * @return true, if successful
	 */
	public static boolean contains(List<?> list, List<?> sublist) {
		return Collections.indexOfSubList(list, sublist) != -1;
	}

	/**
	 * Creates the default change log.
	 *
	 * @return the change log
	 */
	public static ChangeLog createDefaultChangeLog() {
		ChangeLog changeLog = new ChangeLog();
		changeLog.setStatus(StatusEnum.ACTIVE);
		changeLog.setCreatedDate(DateUtil.now());
		changeLog.setUpdatedDate(DateUtil.now());
		return changeLog;
	}

	/**
	 * Generator list year.
	 *
	 * @return the list
	 */
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

	/**
	 * Generator change log.
	 *
	 * @return the change log
	 */
	public static ChangeLog generatorChangeLog() {
		ChangeLog changeLog = new ChangeLog();
		changeLog.setCreatedDate(DateUtil.now());
		changeLog.setUpdatedDate(DateUtil.now());
		changeLog.setStatus(StatusEnum.ACTIVE);
		return changeLog;
	}

	/**
	 * Generator degree.
	 *
	 * @return the hash map
	 */
	public static HashMap<String, String> generatorDegree() {
		HashMap<String, String> maps = new HashMap<String, String>();
		maps.put(DegreeEnum.D1.getStatus(), DegreeEnum.D1.getValue());
		maps.put(DegreeEnum.D2.getStatus(), DegreeEnum.D2.getValue());
		maps.put(DegreeEnum.D3.getStatus(), DegreeEnum.D3.getValue());
		maps.put(DegreeEnum.D4.getStatus(), DegreeEnum.D4.getValue());
		maps.put(DegreeEnum.D5.getStatus(), DegreeEnum.D5.getValue());
		return maps;
	}

	/**
	 * Export odt.
	 *
	 * @param response the response
	 * @param fileName the file name
	 * @return the http servlet response
	 */
	public static HttpServletResponse exportODT(HttpServletResponse response,
			String fileName) {
		response.setContentType("application/msword");
		response.setHeader("Content-disposition", "inline; filename="
				+ fileName + ".odt");
		return response;
	}

	/**
	 * Export pdf.
	 *
	 * @param response the response
	 * @param fileName the file name
	 * @return the http servlet response
	 */
	public static HttpServletResponse exportPDF(HttpServletResponse response,
			String fileName) {
		response.setContentType("application/x-pdf");
		response.setHeader("Content-disposition", "inline; filename="
				+ fileName + ".pdf");
		return response;
	}

	/**
	 * Export docx.
	 *
	 * @param response the response
	 * @param fileName the file name
	 * @return the http servlet response
	 */
	public static HttpServletResponse exportDocx(HttpServletResponse response,
			String fileName) {
		response.setContentType("application/msword");
		response.setHeader("Content-disposition", "inline; filename="
				+ fileName + ".docx");
		return response;
	}

	/**
	 * Gets the message.
	 *
	 * @param commonStatus the common status
	 * @param name the name
	 * @return the message
	 */
	public static String getMessage(String commonStatus, String name) {

		if (CommonEnum.FOLLOW.getStatus().equalsIgnoreCase(commonStatus)) {
			return name + " vừa follow bạn";
		}

		if (CommonEnum.REPLY_COMMENT.getStatus().equalsIgnoreCase(commonStatus)) {
			return name + " vừa trả lời comment của bạn";
		}

		return commonStatus;
	}

	/**
	 * Gen log follow.
	 *
	 * @param company the company
	 * @param job the job
	 * @param isJob the is job
	 * @return the string
	 */
	public static String genLogFollow(Company company, Job job, boolean isJob) {

		StringBuilder sb = new StringBuilder();

		if (isJob) {
			sb.append("<p><a href='/company?companyId=" + company.getId() + "&mode=HOME'>" + company.getDisplayName() + "</a> vừa đăng 1 <b>công việc</b> mới</p>");
			sb.append("<p class='small-text'><b><a>" + job.getTitle() + "</a></b></p>");
		} else {
			sb.append("<p><a href='/company?companyId=" + company.getId() + "'>" + company.getDisplayName() + "</a> vừa đăng 1 <b>trạng thái</b> mới</p>");
		}
		return sb.toString();
	}
}
