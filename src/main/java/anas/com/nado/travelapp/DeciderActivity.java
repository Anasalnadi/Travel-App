package anas.com.nado.travelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class DeciderActivity extends AppCompatActivity {

    Intent intent;
    public static String MyPREFERENCES="anas.com.nado.SHARED_PREF";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_decider);

        //TODO DECIDD WHICH ACTIVITY TO LAUNCH
        prepareProperties();

        finish(); //l enha2 3ml activity

    }


    private void prepareProperties() {

          SharedPreferences sharedpreferences= getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
          boolean seen=sharedpreferences.getBoolean("seen",false);

        //  if(seen) {
          //    intent = new Intent(this, HomeScreen.class);
          //}
            //else {
                intent=new Intent(this, OnBoardingScreen.class);
            //}

            startActivity( intent );
    }
}
