package course.labs.activitylab;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class ActivityOne extends Activity {

		// string for logcat documentation
	private final static String TAG = "Lab-ActivityOne";
	private int onCreateCounter = 0;
	private int onStartCounter = 0;
	private int onResumeCounter = 0;
	private int onPauseCounter = 0;
	private int onStopCounter = 0;
	private int onDestroyCounter = 0;
	private int onRestartCounter = 0;


	private TextView onCreateCounterTV;
	private TextView onStartCounterTV;
	private TextView onResumeCounterTV;
	private TextView onPauseCounterTV;
	private TextView onStopCounterTV;
	private TextView onDestroyCounterTV;
	private TextView onRestartCounterTV;

	/**
	 * Find the TextViews  />
	 */
	private void findViews() {
		onCreateCounterTV = (TextView)findViewById( R.id.create );
		onStartCounterTV = (TextView)findViewById( R.id.start );
		onResumeCounterTV = (TextView)findViewById( R.id.resume );
		onPauseCounterTV = (TextView)findViewById( R.id.pause );
		onStopCounterTV = (TextView)findViewById( R.id.stop );
		onDestroyCounterTV = (TextView)findViewById( R.id.destroy );
		onRestartCounterTV = (TextView)findViewById( R.id.restart );
	}


	// lifecycle counts
		//TODO: Create 7 counter variables, each corresponding to a different one of the lifecycle callback methods.
		//TODO:  increment the variables' values when their corresponding lifecycle methods get called.
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			if (savedInstanceState != null){
				onCreateCounter = savedInstanceState.getInt("onCreateCounter");
				onStartCounter = savedInstanceState.getInt("onStartCounter");
				onResumeCounter = savedInstanceState.getInt("onResumeCounter");
				onPauseCounter = savedInstanceState.getInt("onPauseCounter");
				onStopCounter = savedInstanceState.getInt("onStopCounter");
				onDestroyCounter= savedInstanceState.getInt("onDestroyCounter");
				onRestartCounter = savedInstanceState.getInt("onRestartCounter");
			}
			onCreateCounter++;
			setContentView(R.layout.activity_one);
			findViews();
			updateViews();
			//Log cat print out
			Log.i(TAG, "onCreate called " + onCreateCounter + " times");
			
			//TODO: update the appropriate count variable & update the view
		}

	private void updateViews() {
		onCreateCounterTV.setText(getString(R.string.onCreate )+ " " + String.valueOf(onCreateCounter));
		onStartCounterTV.setText(getString(R.string.onStart )+ " " + String.valueOf(onStartCounter));
		onRestartCounterTV.setText(getString(R.string.onRestart )+ " " + String.valueOf(onRestartCounter));
		onResumeCounterTV.setText(getString(R.string.onResume )+ " " + String.valueOf(onResumeCounter));
		onPauseCounterTV.setText(getString(R.string.onPause )+ " " + String.valueOf(onPauseCounter));
		onStopCounterTV.setText(getString(R.string.onStop )+ " " + String.valueOf(onStopCounter));
		onDestroyCounterTV.setText(getString(R.string.onDestroy) + " " + String.valueOf(onDestroyCounter));
	}

	@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.activity_one, menu);
			return true;
		}
		
		// lifecycle callback overrides
		@Override
		public void onStart(){
			super.onStart();
			onStartCounter++;
			onStartCounterTV.setText(getString(R.string.onStart )+ " " + String.valueOf(onStartCounter));
			//Log cat print out
			Log.i(TAG, "onStart called" + onStartCounter + " times");
			

		}

	    // TODO: implement 5 missing lifecycle callback methods

		@Override
		protected void onRestart() {
			super.onRestart();
			onRestartCounter++;
			onRestartCounterTV.setText(getString(R.string.onRestart )+ " " + String.valueOf(onRestartCounter));
			Log.i(TAG, "onRestart called" + onRestartCounter + " times");
		}

		@Override
		protected void onResume() {
			super.onResume();
			onResumeCounter++;
			onResumeCounterTV.setText(getString(R.string.onResume )+ " " + String.valueOf(onResumeCounter));
			Log.i(TAG, "onResume called" + onResumeCounter+ " times");
		}

		@Override
		protected void onPause() {
			super.onPause();
			onPauseCounter++;
			onPauseCounterTV.setText(getString(R.string.onPause )+ " " + String.valueOf(onPauseCounter));
			Log.i(TAG, "onPause called" + onPauseCounter+ " times");
		}

		@Override
		protected void onStop() {
			super.onStop();
			onStopCounter++;
			onStopCounterTV.setText(getString(R.string.onStop )+ " " + String.valueOf(onStopCounter));
			Log.i(TAG, "onStop called" + onStopCounter+ " times");
		}

		@Override
		protected void onDestroy() {
			super.onDestroy();
			onDestroyCounter++;
			onDestroyCounterTV.setText(getString(R.string.onDestroy) + " " + String.valueOf(onDestroyCounter));
			Log.i(TAG, "onDestroy called" + onDestroyCounter+ " times");
		}

		@Override
		public void onSaveInstanceState(Bundle outState){
			super.onSaveInstanceState(outState);
			outState.putInt("onCreateCounter", onCreateCounter);
			outState.putInt("onStartCounter", onStartCounter);
			outState.putInt("onResumeCounter", onResumeCounter);
			outState.putInt("onPauseCounter", onPauseCounter);
			outState.putInt("onStopCounter", onStopCounter);
			outState.putInt("onDestroyCounter", onDestroyCounter);
			outState.putInt("onRestartCounter", onRestartCounter);


		}


		public void launchActivityTwo(View view) {
			startActivity(new Intent(this, ActivityTwo.class));
		}
		

}
