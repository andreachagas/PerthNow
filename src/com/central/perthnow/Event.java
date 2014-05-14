package com.central.perthnow;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class Event implements Parcelable{
	
	private static final String TAG = "Event";

	public static final String JSON_KEY_ID = "id";
	public static final String JSON_KEY_START_TIMES = "startTime";
	public static final String JSON_KEY_END_TIMES = "endTime";
	public static final String JSON_KEY_DATES = "date";
	public static final String JSON_KEY_SUBURB = "suburb";
	public static final String JSON_KEY_PRICE = "displayPrice";
	public static final String JSON_KEY_EVENT = "event";
	
	/**
	 * The ID of the event
	 */
	private long mId;
	
	/**
	 * The time of the event
	 */
	private String mStartTime;
	
	/**
	 * The time of the event
	 */
	private String mEndTime;
	
	/**
	 * the date of the event
	 */
	private String mDate;
	
	/**
	 * the name of the suburb
	 */
	private String mSuburb;
	
	/**
	 * the displaybable price of the event
	 */
	private String mPrice;
	
	/**
	 * the event name
	 */
	private String mEvent;
	
	/**
	 * the raw JSON representation of the object
	 */
	private String mRawJson;
	
	public Event(JSONObject json) throws JSONException {
		
		mId = json.getLong(JSON_KEY_ID);
		mStartTime = json.getString(JSON_KEY_START_TIMES);
		mEndTime = json.getString(JSON_KEY_END_TIMES);
		mDate = json.getString(JSON_KEY_DATES);
		mSuburb = json.getString(JSON_KEY_SUBURB);
		mPrice = json.getString(JSON_KEY_PRICE);
		mEvent = json.getString(JSON_KEY_EVENT);
		mRawJson = json.toString();
	}
	
		
	public Event(long id, String mStartTime, String mEndTime, String mDate, String mSuburb,
			String mPrice, String mEvent) {
		super();
		this.mId = id;
		this.mStartTime = mStartTime;
		this.mEndTime = mEndTime;
		this.mDate = mDate;
		this.mSuburb = mSuburb;
		this.mPrice = mPrice;
		this.mEvent = mEvent;
	}


	@Override
	public int describeContents(){
		return 0;
	}
	
	public long getId() {
		return mId;
	}

	public void setId(long id) {
		this.mId = id;
	}

	/**
	 * Returns the event time
	 */
	public String getStartTime(){
		return mStartTime;
	}
	
	/**
	 * Returns the event time
	 */
	public String getEndTime(){
		return mEndTime;
	}
	
	/**
	 * Returns the date
	 */
	public String getDate(){
		return mDate;
	}
	
	/**
	 * Returns the name of the suburb
	 */
	public String getSuburb(){
		return mSuburb;
	}
	
	/**
	 * Returns the displayable price of the event
	 */
	public String getPrice(){
		return mPrice;
	}
	
	/**
	 * Returns the name of the event
	 */
	public String getEvent(){
		return mEvent;
	}
	
	@Override
	public void writeToParcel(Parcel dest, int flags){
		dest.writeString(mRawJson);
	}
	
	/** 
	 * Parcelable. Creator required to construct an Event object from a Parcel.
	 */
	public static final Parcelable.Creator<Event> CREATOR = new Parcelable.Creator<Event>() {
		@Override
		public Event createFromParcel(Parcel source){
			final String rawJson = source.readString();
			try{
				final JSONObject jsonObject = new JSONObject(rawJson);
				return new Event(jsonObject);
			} catch(JSONException e){
				//In theory, it's impossible to get here
				Log.e(TAG, "Failed to create Event from JSON String: " + e.getMessage());
				return null;
			}
		}
		
		@Override
		public Event[] newArray(int size){
			return new Event[size];
		}
	};

	
	
}
