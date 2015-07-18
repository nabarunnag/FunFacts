package com.riben.nabarunnag.funfacts;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class FunFactsActivity extends ActionBarActivity {
    public static final String TAG = FunFactsActivity.class.getSimpleName();

    private FactBook mFactBook = new FactBook();
    private ColorWheel mColorWheel = new ColorWheel();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        //Declare our view variables and assign the values from the layout file to the View
        final TextView factLabel = (TextView) findViewById(R.id.textView);
        final RelativeLayout factRelLayout = (RelativeLayout) findViewById(R.id.funFactRelLayout);
        final Button showFactButton = (Button) findViewById(R.id.showFactButton);
        View.OnClickListener listener = new View.OnClickListener(){
            public void onClick(View view){


                String fact = mFactBook.getFact();
                // if random number = 0
                int color = mColorWheel.getColor();
                factRelLayout.setBackgroundColor(color);
                showFactButton.setTextColor(color);
                factLabel.setText(fact);
            }
        };

        showFactButton.setOnClickListener(listener);

        //Toast.makeText(this, "Activity created taost!!", Toast.LENGTH_LONG).show();
        Log.d(TAG, "We are logging from the OnCreate Method");




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fun_facts, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
