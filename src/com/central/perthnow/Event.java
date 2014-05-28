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
	public static final String JSON_KEY_SDATES = "startDate";
	public static final String JSON_KEY_EDATES = "endDate";
	public static final String JSON_KEY_ADDRESS = "address";
	public static final String JSON_KEY_SUBURB = "suburb";
	public static final String JSON_KEY_STATE = "state";
	public static final String JSON_KEY_POSTCODE = "postcode";
	public static final String JSON_KEY_PRICE = "displayPrice";
	public static final String JSON_KEY_EVENT = "event";
	public static final String JSON_KEY_VENUE = "venue";
	public static final String JSON_KEY_DESCRIPTION = "description";
	
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
	private String mSDate;
	/**
	 * the date of the event
	 */
	private String mEDate;
	
	/**
	 * the name of the address
	 */
	private String mAddress;
	
	/**
	 * the name of the suburb
	 */
	private String mSuburb;
	
	/**
	 * the name of the state
	 */
	private String mState;
	
	/**
	 * the name of the postcode
	 */
	private String mPostcode;
	
	/**
	 * the displaybable price of the event
	 */
	private String mPrice;
	
	/**
	 * the event name
	 */
	private String mEvent;
	
	/**
	 * the event venue
	 */
	private String mVenue;
	
	/**
	 * the event description
	 */
	private String mDescription;
	
	/**
	 * the raw JSON representation of the object
	 */
	private String mRawJson;
	
	public Event(JSONObject json) throws JSONException {
		
		mId = json.getLong(JSON_KEY_ID);
		mEvent = json.getString(JSON_KEY_EVENT);
		mVenue = json.getString(JSON_KEY_VENUE);
		mAddress = json.getString(JSON_KEY_ADDRESS);
		mSuburb = json.getString(JSON_KEY_SUBURB);
		mState = json.getString(JSON_KEY_STATE);
		mPostcode = json.getString(JSON_KEY_POSTCODE);
		mSDate = json.getString(JSON_KEY_SDATES);
		mEDate = json.getString(JSON_KEY_EDATES);
		mStartTime = json.getString(JSON_KEY_START_TIMES);
		mEndTime = json.getString(JSON_KEY_END_TIMES);
		mPrice = json.getString(JSON_KEY_PRICE);
		mDescription = json.getString(JSON_KEY_DESCRIPTION);
		mRawJson = json.toString();
	}
	
		
	public Event(long id, String mEvent, String mVenue, String mAddress, String mSuburb, String mState, String mPostcode, String mStartTime, String mEndTime, String mSDate, String mEDate, 
			String mPrice, String mDescription) {
		super();
		this.mId = id;
		this.mEvent = mEvent;
		this.mVenue = mVenue;
		this.mAddress = mAddress;
		this.mSuburb = mSuburb;
		this.mState = mState;
		this.mPostcode = mPostcode;
		this.mStartTime = mStartTime;
		this.mEndTime = mEndTime;
		this.mSDate = mSDate;
		this.mEDate = mEDate;
		this.mPrice = mPrice;
		this.mDescription = mDescription;
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
	public String getSDate(){
		return mSDate;
	}
	
	/**
	 * Returns the date
	 */
	public String getEDate(){
		return mEDate;
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
	
	/**
	 * Returns the name of the venue
	 */
	public String getVenue(){
		return mVenue;
	}
	
	/**
	 * Returns the address
	 */
	public String getAddress(){
		return mAddress;
	}
	
	/**
	 * Returns the state
	 */
	public String getState(){
		return mState;
	}
	
	/**
	 * Returns the postcode
	 */
	public String getPostcode(){
		return mPostcode;
	}
	
	
	/**
	 * Returns the description of the event
	 */
	public String getDescription(){
		return mDescription;
	}
	
	
	@Override
	public void writeToParcel(Parcel dest, int flags){
		dest.writeString(mRawJson);
	}
	
	/** 
	 * Parcealable. Creator required to construct an Event object from a Parcel.
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
