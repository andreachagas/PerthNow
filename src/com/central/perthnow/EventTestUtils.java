package com.central.perthnow;

import java.util.ArrayList;
import java.util.Random;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Creates Event objects with test data
 * @author Andrea
 *
 */

public class EventTestUtils {
	
	private int idCount = 0;
	
	private static final String[] STARTTIMES = {
		"10:00", "08:30", "21:00", "23:00",};
	
	private static final String[] ENDTIMES = {
		"12:00", "10:30", "23:00", "00:00",};
	
	private static final String[] SDATES = {
		"20/04/2015", "21/04/2015", "22/04/2015", "23/04/2015",};
	
	private static final String[] EDATES = {
		"20/04/2015", "22/04/2015", "23/04/2015", "23/04/2015",};
	
	private static final String[] SUBURB = {
		"Perth", "Mount Lawley", "Cottesloe", "Scarborough",};
	
	private static final String[] PRICE = {
		"FREE", "$40", "$300", "FREE",};
	
	private static final String[] EVENT = {
		"Brunch at Perth Now", "Breakkie in Hipster Town", "Rock at the Beach", "International Beach Bum Festival",};
	
	private final Random mRandom;
	
	/**
	 * Constructs a new EventTestUtils object with the specified seed
	 * 
	 * @param seed
	 * 			long to seed the {@link Random} with
	 */
	public EventTestUtils(long seed){
		mRandom = new Random(seed);
	}
	
	//public static int[] id = int[TIMES.length];
	/**
	 * Returns ArrayList of Event objects
	 * 
	 * @param count
	 * 			int number of Event objects to return
	 * @return ArrayList of Event objects
	 */
	public ArrayList<Event> getNewEvents(int count){
		final ArrayList<Event> list = new ArrayList<Event>();
		for(int i = 0; i < count; i++){
			list.add(getNewEvent());
		}
		return list;
	}
	
	/**
	 * Returns new Event filled with test data
	 * 
	 * @return new Event filled with test data
	 */
	public Event getNewEvent(){
		
		final JSONObject json = new JSONObject();
		try{
			long idValue = ++idCount;
			
			json.put(Event.JSON_KEY_ID, idValue);
			json.put(Event.JSON_KEY_START_TIMES, "14:30");
			json.put(Event.JSON_KEY_END_TIMES, "15:30");
			json.put(Event.JSON_KEY_SDATES, "15/05/2014");
			json.put(Event.JSON_KEY_EDATES, "15/05/2014");
			json.put(Event.JSON_KEY_SUBURB, "Perth");
			json.put(Event.JSON_KEY_PRICE, "$15.00");
			json.put(Event.JSON_KEY_EVENT, "Breakkie in Hipster Town");
			
			return new Event(json);
		}catch (JSONException e){
			//This should never happen
			throw new RuntimeException(e);
		}
	}
	
	
}


