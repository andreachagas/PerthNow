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
			json.put(Event.JSON_KEY_EVENT, "Brekkie in Hipster Town");
			json.put(Event.JSON_KEY_VENUE, "Central");
			json.put(Event.JSON_KEY_ADDRESS, "19 Aberdeen Street");
			json.put(Event.JSON_KEY_SUBURB, "Perth");
			json.put(Event.JSON_KEY_STATE, "WA");
			json.put(Event.JSON_KEY_POSTCODE, "6000");
			json.put(Event.JSON_KEY_SDATES, "15/05/2014");
			json.put(Event.JSON_KEY_EDATES, "15/05/2014");
			json.put(Event.JSON_KEY_START_TIMES, "14:30");
			json.put(Event.JSON_KEY_END_TIMES, "15:30");
			json.put(Event.JSON_KEY_PRICE, "$15.00");
			json.put(Event.JSON_KEY_DESCRIPTION,  "Breakfast at Hispster Town. Food will be provided by the good people of the Town and you should make a donation to your preferred entity.");
			
			return new Event(json);
		}catch (JSONException e){
			//This should never happen
			throw new RuntimeException(e);
		}
	}
	
	
}


