package com.example.francisco.datapersistance;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String MY_PREF_FILE = "mypref_file";
    private static final String TAG = "Main";
    EditText et1,et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
    }

    public void sendData(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences(MY_PREF_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("value1", et1.getText().toString());
        editor.putString("value2", et2.getText().toString());
        editor.commit();

        Toast.makeText(this, et1.getText().toString() + " " +et2.getText().toString(), Toast.LENGTH_SHORT).show();
    }

    public void getData(View view) {
        SharedPreferences sharePreferences = getSharedPreferences(MY_PREF_FILE,Context.MODE_PRIVATE);
        Log.d(TAG, "getData: " + sharePreferences.getString("value1","default"));
        Toast.makeText(this, "The data was retrieved", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);

        Log.d(TAG, "getData: ");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            Toast.makeText(this, "Landscape", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "onConfigurationChanged: Landscape");
        }
        if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this, "Portrait", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "onConfigurationChanged: Portrait");
        }
    }

    public void Second(View view) {
        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }
}
