package vn.com.hiringviet.binder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.PropertiesEditor;

// TODO: Auto-generated Javadoc
/**
 * The Class DateBinder.
 */
public class DateBinder extends PropertiesEditor {
	
	/** The simple date format. */
	private SimpleDateFormat simpleDateFormat;

	/**
	 * Instantiates a new date binder.
	 */
	public DateBinder() {
		simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	}

	/* (non-Javadoc)
	 * @see org.springframework.beans.propertyeditors.PropertiesEditor#setAsText(java.lang.String)
	 */
	@Override
	public void setAsText(String value) throws IllegalArgumentException {
		try {
			setValue(simpleDateFormat.parse(value));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see java.beans.PropertyEditorSupport#getAsText()
	 */
	@Override
	public String getAsText() {
		String s = "";
		if (getValue() != null && getValue() instanceof Date) {
			Date date = (Date) getValue();
			s = simpleDateFormat.format(date).toString();
		}
		return s;
	}

}
