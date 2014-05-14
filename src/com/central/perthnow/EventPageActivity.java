package com.central.perthnow;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class EventPageActivity extends Activity {

	private Event event;
	
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_event_page);
		
		event = (Event) getIntent().getParcelableExtra("obj");
		
		// when send to calendar button is clicked
		Button Activity1 = (Button) findViewById(R.id.calendarIntent);
		Activity1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {

				Intent calIntent = new Intent(Intent.ACTION_INSERT);
				SendEvent.sendEvents(calIntent, event);

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
