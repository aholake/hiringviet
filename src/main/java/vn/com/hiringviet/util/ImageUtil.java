package vn.com.hiringviet.util;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import vn.com.hiringviet.api.dto.response.AccountDTO;
import vn.com.hiringviet.model.Account;
import vn.com.hiringviet.model.CompanyPhoto;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.images.ServingUrlOptions;


// TODO: Auto-generated Javadoc
/**
 * The Class ImageUtil.
 */
public class ImageUtil {

	/**  Constant for base64 string. */
	private static final String JPEG_PREFIX = "data:image/jpeg;base64,";
	
	/** The Constant PNG_PREFIX. */
	private static final String PNG_PREFIX = "data:image/png;base64,";

	/**
	 * Convert image data to byte[].
	 *
	 * @param imgFile the img file
	 * @return the byte[]
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
	 * Convert image data to byte[].
	 *
	 * @param base64Str the base64 str
	 * @return the byte[]
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

	/**
	 * Convert byte[] to image data.
	 *
	 * @param imgBytes the img bytes
	 * @return the string
	 */
	public static String convertByteToImage(byte[] imgBytes) {

		// Encode image byte
		String strImage = "";
		if (imgBytes != null) {
			strImage = PNG_PREFIX + Base64.encodeBase64String(imgBytes);
		}

		return strImage;
	}

	/**
	 * Convert image to byte.
	 *
	 * @param blobstoreService the blobstore service
	 * @param request the request
	 * @param account the account
	 * @return the account dto
	 */
	public static AccountDTO convertImageToByte(BlobstoreService blobstoreService, HttpServletRequest request, Account account) {

		AccountDTO accountDTO = new AccountDTO();

		Map<String, List<BlobKey>> blobs = blobstoreService.getUploads(request);
		List<BlobKey> blobKeys = blobs.get("multipartFile");

		if (blobKeys != null) {

			BlobKey blobKey = blobKeys.get(0);
			ImagesService services = ImagesServiceFactory.getImagesService();
			ServingUrlOptions serve = ServingUrlOptions.Builder.withBlobKey(blobKey);
			String imageUrl = services.getServingUrl(serve);
//			BlobInfoFactory blobInfoFactory = new BlobInfoFactory();
//			BlobInfo info = blobInfoFactory.loadBlobInfo(blobKey);

			if (!StringUtils.isEmpty(account.getAvatarImageKey())) {
				BlobKey blobKeyDelete = new BlobKey(account.getAvatarImageKey());
				blobstoreService.delete(blobKeyDelete);
			}
			accountDTO.setAvatarImage(imageUrl);
			accountDTO.setAvatarImageKey(blobKey.getKeyString());
		}

		return accountDTO;
	}

	/**
	 * Convert image to byte.
	 *
	 * @param blobstoreService the blobstore service
	 * @param request the request
	 * @param companyPhoto the company photo
	 * @return the company photo
	 */
	public static CompanyPhoto convertImageToByte(BlobstoreService blobstoreService, HttpServletRequest request, CompanyPhoto companyPhoto) {

		Map<String, List<BlobKey>> blobs = blobstoreService.getUploads(request);
		List<BlobKey> blobKeys = blobs.get("multipartFile");

		if (blobKeys != null) {

			BlobKey blobKey = blobKeys.get(0);
			ImagesService services = ImagesServiceFactory.getImagesService();
			ServingUrlOptions serve = ServingUrlOptions.Builder.withBlobKey(blobKey);
			String imageUrl = services.getServingUrl(serve);
//			BlobInfoFactory blobInfoFactory = new BlobInfoFactory();
//			BlobInfo info = blobInfoFactory.loadBlobInfo(blobKey);

			companyPhoto.setPhoto(imageUrl);
			companyPhoto.setPhotoKey(blobKey.getKeyString());
		}

		return companyPhoto;
	}
}
