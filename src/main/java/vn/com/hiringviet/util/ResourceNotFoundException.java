package vn.com.hiringviet.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// TODO: Auto-generated Javadoc
/**
 * The Class ResourceNotFoundException.
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public final class ResourceNotFoundException extends RuntimeException{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

}
