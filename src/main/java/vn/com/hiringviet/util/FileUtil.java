package vn.com.hiringviet.util;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;

public class FileUtil {

	/**
	 * Get properties from message properties file
	 */
	public static Properties getProperties() {

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
