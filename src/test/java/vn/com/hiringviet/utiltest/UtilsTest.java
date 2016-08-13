package vn.com.hiringviet.utiltest;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class UtilsTest {
	@Test
	public void should_print_out_the_date() throws Exception {
		SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(simpleDateFormat.format(new Date()));
	}
}
