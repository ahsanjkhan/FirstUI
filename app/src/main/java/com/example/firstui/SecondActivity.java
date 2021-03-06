package com.example.firstui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.*;

public class SecondActivity extends AppCompatActivity {

    public static final int DETAIL_REQUEST = 1;

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),MainActivity.class);
                startActivity(i);
            }
        });
        findViewById(R.id.details).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),ThirdActivity.class);
                i.putExtra("KeyForSending","Loading booking details");
                startActivityForResult(i,DETAIL_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (1==0){
            super.onActivityResult(requestCode, resultCode, data);
        }
        if (resultCode == RESULT_OK && requestCode == DETAIL_REQUEST) {
            if (data.hasExtra("KeyForReturning")) {
                String myChoice = data.getExtras().getString("KeyForReturning");
                ((TextView) (findViewById(R.id.userSelection))).setText(myChoice);
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.connect, menu);
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

}

