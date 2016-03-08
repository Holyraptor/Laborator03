package com.example.phonedialer;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class PhoneDialerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_dialer);
        
        Button oneButton = (Button)findViewById(R.id.button1);
        Button twoButton = (Button)findViewById(R.id.button2);
        Button threeButton = (Button)findViewById(R.id.button3);
        Button fourButton = (Button)findViewById(R.id.button4);
        Button fiveButton = (Button)findViewById(R.id.button5);
        Button sixButton = (Button)findViewById(R.id.button6);
        Button sevenButton = (Button)findViewById(R.id.button7);
        Button eightButton = (Button)findViewById(R.id.button8);
        Button nineButton = (Button)findViewById(R.id.button9);
        Button zeroButton = (Button)findViewById(R.id.button11);
        Button starButton = (Button)findViewById(R.id.button10);
        Button diezButton = (Button)findViewById(R.id.button12);
        
        ImageButton deleteButton = (ImageButton)findViewById(R.id.imageButton3);
        ImageButton callButton = (ImageButton)findViewById(R.id.imageButton1);
        ImageButton closeButton = (ImageButton)findViewById(R.id.imageButton2);

        final TextView phoneText = (TextView)findViewById(R.id.textView2);
        
        oneButton.setOnClickListener(new PhoneListener(oneButton, phoneText));
        twoButton.setOnClickListener(new PhoneListener(twoButton, phoneText));
        threeButton.setOnClickListener(new PhoneListener(threeButton, phoneText));
        fourButton.setOnClickListener(new PhoneListener(fourButton, phoneText));
        fiveButton.setOnClickListener(new PhoneListener(fiveButton, phoneText));
        sixButton.setOnClickListener(new PhoneListener(sixButton, phoneText));
        sevenButton.setOnClickListener(new PhoneListener(sevenButton, phoneText));
        eightButton.setOnClickListener(new PhoneListener(eightButton, phoneText));
        nineButton.setOnClickListener(new PhoneListener(nineButton, phoneText));
        zeroButton.setOnClickListener(new PhoneListener(zeroButton, phoneText));
        starButton.setOnClickListener(new PhoneListener(starButton, phoneText));
        diezButton.setOnClickListener(new PhoneListener(diezButton, phoneText));
        
    	deleteButton.setOnClickListener(new View.OnClickListener() {
			
        	@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
        		
        		String currentText = phoneText.getText().toString();
        		if (currentText != null && currentText.length() > 0) {
        			currentText = currentText.substring(0, currentText.length()-1);
        		    }
        		
        		phoneText.setText(currentText);
			}
		});
        
    	callButton.setOnClickListener(new View.OnClickListener() {
			
        	@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
        		
        		Intent intent = new Intent(Intent.ACTION_CALL);
        		String phoneNumber = phoneText.getText().toString();
        		intent.setData(Uri.parse("tel:"+phoneNumber));
        		startActivity(intent);
			}
		});

    	closeButton.setOnClickListener(new View.OnClickListener() {
	
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			finish();
		}
    	});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.phone_dialer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    private class PhoneListener implements View.OnClickListener{
    	
    	private Button myButton;
    	private TextView myTextView;
    	
    	public PhoneListener(Button _button, TextView _textView){
    		myButton = _button;
    		myTextView = _textView;
    	}
    	
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			String buttonText = myButton.getText().toString();
			String currentText = myTextView.getText().toString();
			myTextView.setText(currentText + buttonText);
		}
    	
    }
}
