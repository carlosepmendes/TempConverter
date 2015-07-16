package com.example.android.tempconverter;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


public class MainActivity extends ActionBarActivity {

    private EditText tempEditText;
    private Button cButton;
    private Button fButton;
    private TextView tempTextView;

    DecimalFormat round = new DecimalFormat("0.0");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tempEditText = (EditText) findViewById(R.id.editid);
        cButton = (Button) findViewById(R.id.cbuttonid);
        fButton = (Button) findViewById(R.id.fbuttonid);
        tempTextView = (TextView) findViewById(R.id.result);

        cButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //call to convert to C function
                String editTextVal = tempEditText.getText().toString();
                if (editTextVal.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Enter a value", Toast.LENGTH_LONG).show();
                }else{
                    double doubleeditText = Double.parseDouble(editTextVal);
                    double convertvalue = convertToCelsius(doubleeditText);
                    String convert = String.valueOf(round.format(convertvalue));
                    tempTextView.setText(convert + " C");
                }
            }
        });

        fButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //call to convert to F function
                String editTextVal = tempEditText.getText().toString();
                if (editTextVal.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Enter a value", Toast.LENGTH_LONG).show();
                }else{
                    double doubleeditText = Double.parseDouble(editTextVal);
                    double convertvalue = converToF(doubleeditText);
                    String convert = String.valueOf(round.format(convertvalue));
                    tempTextView.setText(convert + " F");
                }
            }
        });
    }

    public double convertToCelsius(double temp){
        double result;
        result = (temp  - 32)* 5/9;
        return result;
    };

    public double converToF(double temp){
        double result;
        result = temp * 9/5 + 32;
        return result;
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
