	/*
	* Crystal McDonald
	* Java II 1305
	* Week 1
	*/

package com.cm.simplecalculator;

	import java.net.URL;

	import android.app.Activity;
	import android.content.Intent;
	import android.net.Uri;
	import android.os.Bundle;
	import android.view.View;
	import android.view.View.OnClickListener;
	import android.widget.Button;
	import android.widget.EditText;

	public class Calculations extends Activity implements OnClickListener {
	EditText number;
	Button songInfo;
	Button browse;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.calc);
	number = (EditText)findViewById(R.id.editText1);
	songInfo = (Button)findViewById(R.id.button1);
	// set listener for browse button
	browse = (Button) findViewById(R.id.browseBttn);
	songInfo.setOnClickListener(this);

	        //IMPLICIT INTENT
	        browse.setOnClickListener(new OnClickListener() {

	         @Override
	     public void onClick(View interwebs) {
	         // Sends user to site that shows kids the learn to add song from Sesame Street
	        Uri uriUrl = Uri.parse("http://www.metrolyrics.com/adding-lyrics-sesame-street.html");

	        Intent browse_intent = new Intent(Intent.ACTION_VIEW, uriUrl);

	        startActivity(browse_intent);
	        
	    }



	});


	}
	//ACTIVITY2 TAKES IN A NUMBER TO DISPLAY IT ON ACIVITY1
	@Override
	public void onClick(View v) {
	// get info from edit text and send back
	String nums = number.getText().toString();
	//get info from intent that opens numQuote class
	Intent i = getIntent ();
	//looking for i.putextras
	String msg = i.getStringExtra("numbers");
	if(msg.contentEquals("firstNum")){
	i.putExtra("firstInfo", nums);
	setResult(RESULT_OK, i);
	finish();
	}	
	//takes the results and closes the page and appends to MainActivity in its button
	if(msg.contentEquals("secondNum")){
	i.putExtra("secondInfo", nums);
	setResult(RESULT_OK, i);
	finish();

	}


	}
	}
