package com.example.firstui;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class OptionsActivity extends AppCompatActivity {

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options_activity);
        findViewById(R.id.launch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = ((Spinner)(findViewById(R.id.mySpinner2))).getSelectedItemPosition();
                Intent implicitIntent = null;
                switch (position){
                    case 0:
                        break;
                    case 1:
                        implicitIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ahsanjkhan.github.io"));
                        break;
                    case 2:
                        implicitIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:(+800)4448888"));
                        break;
                    case 3:
                        implicitIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:30.0000,-97.000"));
                        break;
                    case 4:
                        implicitIntent = new Intent("android.media.action.IMAGE_CAPTURE");
                        break;
                }
                if (implicitIntent!=null){
                    if (isIntentAvailable(implicitIntent)){
                        startActivity(implicitIntent);
                    }
                    else{
                        Toast.makeText(v.getContext(),"application not found",Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
    }

    public boolean isIntentAvailable(Intent i){
        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> activites = packageManager.queryIntentActivities(i,0);
        boolean isIntentSafe = activites.size() > 0;
        return isIntentSafe;
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
