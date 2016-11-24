package vn.com.hiringviet.binder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.PropertiesEditor;

public class DateBinder extends PropertiesEditor {
	private SimpleDateFormat simpleDateFormat;

	public DateBinder() {
		simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	}

	@Override
	public void setAsText(String value) throws IllegalArgumentException {
		try {
			setValue(simpleDateFormat.parse(value));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

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
