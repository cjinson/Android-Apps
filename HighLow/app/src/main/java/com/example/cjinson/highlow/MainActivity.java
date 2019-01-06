package com.example.cjinson.highlow;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int randomVal;

    public void genRand(){
        Random rand = new Random();

        randomVal = rand.nextInt(20) + 1;
    }

    public void click(View view){
        EditText editGuess=(EditText) findViewById(R.id.editText);
        int guess=Integer.parseInt(editGuess.getText().toString());
        String message = null;
        System.out.println(randomVal);

        if (guess>randomVal){

            message="Lower!";

        }
        else if (guess<randomVal){
            message="Higher!";

        }
        else if (guess==randomVal){
            message="You guessed the correct number!";
            genRand();

        }
        else if(editGuess.getText().length()==0){

        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        Log.i("Random Number", Integer.toString(randomVal));
        editGuess.setText("");
        InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(editGuess.getWindowToken(), 0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        genRand();
    }
}

