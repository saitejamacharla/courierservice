package courierUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAndTimeUtil {
	
	private static final String DATE_FORMAT = "yyyy-MM-dd";

	public static Date getFormatedDate(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		Date formatedDate = null;
		try {
			formatedDate = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return formatedDate;
	}
}
