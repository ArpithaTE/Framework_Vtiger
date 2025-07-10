package own.framework.GenericUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Java_Utility_Own {

	public int getRandomNumber() {
		Random ranDom = new Random();
		int ranDomNumber = ranDom.nextInt(5000);
		return ranDomNumber;
	}

	public String getCurrentDateYYYYDDMM() {
		Date dateObj = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(dateObj);
		System.out.println(date);
		return date;
	}

	public String getRequiredDateYYYYDDMM(int days) {
		Date dateObj = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.format(dateObj);

		Calendar cal = sdf.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String reqDate = sdf.format(cal.getTime());
		System.out.println(reqDate);
		return reqDate;
	}

}
