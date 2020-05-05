package com.example.firstui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }*/

    Number [] myStrings = new Number[]{
            new Number(1,"ONE"),
            new Number(2,"TWO"),
            new Number(3,"THREE"),
            new Number(4,"FOUR"),
            new Number(5,"FIVE"),
            new Number(6,"SIX"),
            new Number(7,"SEVEN"),
            new Number(8,"EIGHT"),
            new Number(9,"NINE"),
            new Number(10,"TEN")
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);

        Bundle extras = getIntent().getExtras();
        if (extras!=null){
            String detailValue = extras.getString("KeyForSending");
            if (detailValue!=null){
                Toast.makeText(this,detailValue,Toast.LENGTH_SHORT).show();
            }
        }

        findViewById(R.id.more).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),OptionsActivity.class);
                startActivity(i);
            }
        });

        findViewById(R.id.second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                String mySelection = ((Spinner)findViewById(R.id.mySpinner)).getSelectedItem().toString();
                returnIntent.putExtra("KeyForReturning",mySelection);
                setResult(RESULT_OK,returnIntent);
                finish();
            }
        });

        ((ListView)(findViewById(R.id.myListView))).setAdapter(new NumberAdapter(this,R.layout.row,myStrings));
        ((ListView)(findViewById(R.id.myListView))).setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(view.getContext(),("Selected: " + myStrings[position].myName),Toast.LENGTH_LONG).show();
            }
        });

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
