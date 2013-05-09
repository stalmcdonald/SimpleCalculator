/*
* Crystal McDonald
* Java II 1303
* Week 1
*/
package com.cm.simplecalculator;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MyMain extends Activity implements OnClickListener{

Button firstNum, secondNum, calc;
TextView myTotal;

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_my_main);
firstNum = (Button) findViewById(R.id.button1);
secondNum = (Button) findViewById(R.id.button2);
calc = (Button) findViewById(R.id.button3);
myTotal = (TextView) findViewById(R.id.textView1);

//setup onclick listener
firstNum.setOnClickListener(this);
secondNum.setOnClickListener(this);
calc.setOnClickListener(this);

}

    //EXPLICIT INTENT
@Override
public void onClick(View v) {
// if button 1-2 are pressed go to new activity
Intent i = new Intent(this, Calculations.class);
switch (v.getId()){

//buttons
case R.id.button1:

        //first number
i.putExtra("numbers", "firstNum");
startActivityForResult(i, 1);
break;
case R.id.button2:

            //second number
i.putExtra("numbers", "secondNum");
startActivityForResult(i, 1);
break;
case R.id.button3:

                //Add Sums
//converting integer to string
int a = Integer.valueOf(firstNum.getText().toString());
int b = Integer.valueOf(secondNum.getText().toString());
// Object sum = Integer.valueOf(firstNum+secondNum.getText().toString());
//displays the total in a string replacing "Total"
myTotal.setText("Total: " + (a+b));
break;

default:
break;
}
}
    //RETRIEVES NUMBERS ENTERED FROM CALCULATIONS TO BE ADDED
//capture info being sent back
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data){
super.onActivityResult(requestCode, resultCode, data);
if(data.getExtras().containsKey("firstInfo")){
firstNum.setText(data.getStringExtra("firstInfo"));
}
if(data.getExtras().containsKey("secondInfo")){
secondNum.setText(data.getStringExtra("secondInfo"));
}
}


}//end
