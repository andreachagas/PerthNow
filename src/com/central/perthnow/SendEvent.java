package com.central.perthnow;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import android.content.Intent;
import android.provider.CalendarContract;
import android.provider.CalendarContract.Events;
import android.text.format.DateFormat;
import android.util.Log;

public class SendEvent {

	static void sendEvents(Intent calIntent, Event event) {

		// initialized values to be linked with Database
		int year = 0, month = 0, day = 0, Shour = 0, Sminute = 0, Ehour = 0, Eminute = 0;

		Calendar d = Calendar.getInstance();

		// decides if event is allday
		@SuppressWarnings("unused")
		boolean allday = true;

		// calIntent.setData(CalendarContract.Events.CONTENT_URI);
		calIntent.setType("vnd.android.cursor.item/event");
		calIntent.putExtra(Events.TITLE, 
				event.getEvent());
		calIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
				event.getStartTime());
		calIntent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY,
				event.getEndTime());
		calIntent.putExtra(Events.EVENT_LOCATION, 
				event.getSuburb());
		calIntent.putExtra(Events.DESCRIPTION,
				event.getDescription());

		// gets event values
		getYear(year);
		getMonth(month);
		getDay(day);
		getStartHour(Shour);
		getStartMinute(Sminute);
		getEndHour(Ehour);
		getEndMinute(Eminute);

		GregorianCalendar startDate = new GregorianCalendar(year, month, day,
				Shour, Sminute);
		GregorianCalendar endDate = new GregorianCalendar(year, month, day,
				Ehour, Eminute);

		if (allday = true) {
			calIntent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);
			calIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
					startDate.getTimeInMillis());
			calIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
					startDate.getTimeInMillis());
		}
		if (allday = false) {
			calIntent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, false);
			calIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
					startDate.getTimeInMillis());
			calIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
					endDate.getTimeInMillis());
		}

	}

	// methods to get event values
	private static int getYear(int year) {
		year = 2014;
		return year;
	}

	private static int getMonth(int month) {
		month = 4;
		return month;
	}

	private static int getDay(int day) {
		day = 14;
		return day;
	}

	private static int getStartHour(int Shour) {
		Shour = 7;
		return Shour;
	}

	private static int getStartMinute(int Sminute) {
		Sminute = 30;
		return Sminute;
	}

	private static int getEndHour(int Ehour) {
		Ehour = 16;
		return Ehour;
	}

	private static int getEndMinute(int Eminute) {
		Eminute = 0;
		return Eminute;
	}

	public static Intent foo(Event event) {

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		String startDate = event.getSDate() + " " + event.getStartTime();
		String endDate = event.getEDate() + " " + event.getEndTime();

		Calendar startCal = Calendar.getInstance();
		Calendar endCal = Calendar.getInstance();

		try {
			startCal.setTime(formatter.parse(startDate));
			endCal.setTime(formatter.parse(endDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		int year = startCal.get(Calendar.YEAR);
		int month = startCal.get(Calendar.MONTH);
		int day = startCal.get(Calendar.DAY_OF_WEEK_IN_MONTH);
		int hour = startCal.get(Calendar.HOUR_OF_DAY);
		int minute = startCal.get(Calendar.MINUTE);
		
		int year1 = endCal.get(Calendar.YEAR);
		int month1 = endCal.get(Calendar.MONTH);
		int day1 = endCal.get(Calendar.DAY_OF_WEEK_IN_MONTH);
		int hour1 = endCal.get(Calendar.HOUR);
		int minute1 = endCal.get(Calendar.MINUTE);
		
		Intent intent = new Intent(Intent.ACTION_INSERT);
		intent.setType("vnd.android.cursor.item/event");
		intent.putExtra(Events.TITLE, 
				event.getEvent());
		intent.putExtra(Events.DESCRIPTION, 
				event.getDescription());
		intent.putExtra(Events.EVENT_LOCATION, 
				event.getSuburb());

		GregorianCalendar startGreg = new GregorianCalendar(year, month, day, hour, minute);
		intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
				startGreg.getTimeInMillis());
		
		GregorianCalendar endGreg = new GregorianCalendar(year1, month1, day1, hour1, minute1);
		intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
				endGreg.getTimeInMillis());

		intent.putExtra(Events.ALL_DAY, false);
		return intent;
	}

}
