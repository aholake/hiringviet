package vn.com.hiringviet.util;

import org.apache.commons.codec.binary.Base64;
import org.springframework.web.multipart.MultipartFile;


public class ImageUtil {

	/** Constant for base64 string */
	private static final String JPEG_PREFIX = "data:image/jpeg;base64,";
	private static final String PNG_PREFIX = "data:image/png;base64,";

	/**
	 * Convert image data to byte[] 
	 */
	public static byte[] convertImageToByte(MultipartFile imgFile) {

		byte[] imgBytes = null;
		try {
			// Convert image to byte[]
			if (imgFile != null) {
				imgBytes = imgFile.getBytes();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return imgBytes;
	}

	/**
	 * Convert image data to byte[] 
	 */
	public static byte[] convertImageToByte(String base64Str) {

		byte[] imgData = null;
		if (base64Str != null) {
			imgData = Base64.decodeBase64(
						base64Str.replace(PNG_PREFIX, "")
								.replace(JPEG_PREFIX, ""));
		}

		return imgData;
	}
}
