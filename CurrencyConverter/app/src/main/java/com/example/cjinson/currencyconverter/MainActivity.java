package com.example.cjinson.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public void clickBtn(View view){
        EditText editText= (EditText) findViewById(R.id.editText);
        String pound = editText.getText().toString();
       double p= Double.parseDouble(pound);


        double dollar= p*1.27;

        String d= String.format("%.2f", dollar);

        Toast.makeText(this, "£ "+p+" is $ "+dollar, Toast.LENGTH_SHORT).show();


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
