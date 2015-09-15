package jdk.time;

import java.time.LocalDateTime;
import java.util.Calendar;

public class TimeTest {

	public static void main(String[] args) {
		
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH)); // 0 -11
		System.out.println(cal.get(Calendar.DATE));
		System.out.println(cal.get(Calendar.HOUR_OF_DAY));
		System.out.println(cal.get(Calendar.MINUTE));
		System.out.println(cal.get(Calendar.SECOND));
		
		LocalDateTime dt = LocalDateTime.now();
		System.out.println(dt.getYear());
		System.out.println(dt.getMonthValue()); // 1 - 12
		System.out.println(dt.getDayOfMonth());
		System.out.println(dt.getHour());
		System.out.println(dt.getMinute());
		System.out.println(dt.getSecond());
		
		Calendar cal1 = Calendar.getInstance();
		cal1.add(Calendar.DATE, - 1);
		System.out.println(cal.getTime());
	}
}
