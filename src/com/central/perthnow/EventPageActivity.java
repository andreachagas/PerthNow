package com.central.perthnow;

import java.util.List;

import org.w3c.dom.Text;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EventPageActivity extends Activity {

	private Event event;
	
	private TextView txtSuburb;
	private TextView txtEvent;
	private TextView txtStartDate;
	private TextView txtEndDate;
	private TextView txtStartTime;
	private TextView txtEndTime;
	private TextView txtPrice;
	private TextView txtDescription;

	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_event_page);

		event = (Event) getIntent().getParcelableExtra("obj");

		txtSuburb = (TextView) findViewById(R.id.suburb);
		txtSuburb.setText(event.getSuburb());

		txtEvent = (TextView) findViewById(R.id.event);
		txtEvent.setText(event.getEvent());

		txtStartDate = (TextView) findViewById(R.id.start_date);
		txtStartDate.setText(event.getSDate());

		txtEndDate = (TextView) findViewById(R.id.end_date);
		txtEndDate.setText(event.getEDate());

		txtStartTime = (TextView) findViewById(R.id.start_time);
		txtStartTime.setText(event.getStartTime());

		txtEndTime = (TextView) findViewById(R.id.end_time);
		txtEndTime.setText(event.getEndTime());

		txtPrice = (TextView) findViewById(R.id.price);
		txtPrice.setText(event.getPrice());

		txtDescription = (TextView) findViewById(R.id.description);
		txtDescription.setText(event.getDescription());

		Log.i(EventPageActivity.class.getSimpleName(), event.getEvent());

		// when send to calendar button is clicked
		Button Activity1 = (Button) findViewById(R.id.calendarIntent);
		Activity1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {

				// Intent calIntent = new Intent(Intent.ACTION_INSERT);
				// SendEvent.sendEvents(calIntent, event);

				Intent calIntent = SendEvent.foo(event);

				// Verify it resolves
				PackageManager packageManager = getPackageManager();
				List<ResolveInfo> activities = packageManager
						.queryIntentActivities(calIntent, 0);
				boolean isIntentSafe = activities.size() > 0;

				// Start an activity if it's safe
				if (isIntentSafe) {
					startActivity(calIntent);
				}
			}

		});

		// when map button is clicked
		Button mapButton = (Button) findViewById(R.id.mapsIntent);
		mapButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {

				Intent mapIntent = new Intent(Intent.ACTION_INSERT);
				SendEvent.sendEvents(mapIntent, event);

				// Verify it resolves
				PackageManager packageManager = getPackageManager();
				List<ResolveInfo> activities = packageManager
						.queryIntentActivities(mapIntent, 0);
				boolean isIntentSafe = activities.size() > 0;

				// Start an activity if it's safe
				if (isIntentSafe) {
					startActivity(mapIntent);
				}
			}

		});

		Log.d("test", Long.toString(event.getId()));
	}

}
