package vn.com.hiringviet.util;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class FileUtil.
 */
public class FileUtil {

	/**
	 * Get properties from message properties file.
	 *
	 * @return the config properties
	 */
	public static Properties getConfigProperties() {

		// read properites file:
		Properties props = new Properties();
		InputStream in = FileUtil.class.getResourceAsStream("/config.properties");
		try {
			props.load(in);
		} catch (Exception e) {
			return null;
		}
		return props;
	}
	
	/**
	 * Gets the message properties.
	 *
	 * @return the message properties
	 */
	public static Properties getMessageProperties() {

		// read properites file:
		Properties props = new Properties();
		InputStream in = FileUtil.class.getResourceAsStream("/messages_en.properties");
		try {
			props.load(in);
		} catch (Exception e) {
			return null;
		}
		return props;
	}

	/**
	 * Copy file on server.
	 *
	 * @param des the des
	 * @param source the source
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public static boolean copyFileOnServer(String des, String source) throws Exception {

		File fileDes = new File(des);
		File fileSource = new File(source);
		if (fileSource.exists()) {

			// copy to path 
			FileUtils.copyFile(fileSource, fileDes);
		} else {
			return false;
		}

		return true;
	}

	/**
	 * Delete list file.
	 *
	 * @param lstFile the lst file
	 */
	public static void deleteListFile(List<File> lstFile) {

		for (File file : lstFile) {
			// check exist and delete
			if (file.exists()) {
				// delete file
				file.delete();
			}
		}
	}
}
