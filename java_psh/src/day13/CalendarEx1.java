package day13;

import java.util.Calendar;

public class CalendarEx1 {

	public static void main(String[] args) {
		//캘린더 예제
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		System.out.print(year+"년 ");
		int month = cal.get(Calendar.MONTH)+1;
		System.out.print(month+"월 ");
		int day = cal.get(Calendar.DATE);
		System.out.print(day+"일 ");
		int hour = cal.get(Calendar.HOUR);
		System.out.print(hour+"시 ");
		int min = cal.get(Calendar.MINUTE);
		System.out.print(min+"분 ");
		int sec = cal.get(Calendar.SECOND);
		System.out.print(sec+"초 ");
		

	}

}
