package com.am.myapplication11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ReadCounters extends AppCompatActivity implements LocationListener {

EditText read_Count,image_Cupture;
Button location,done;
String readCounter,setReader1;
LocationManager locationManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_counters);

        read_Count=findViewById(R.id.read_count);
        image_Cupture=findViewById(R.id.image_cupture);
        location=findViewById(R.id.location);
        done=findViewById(R.id.done);

     readCounter=read_Count.getText().toString();

       location.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               getLocation();

        /*Intent goToMap=new Intent(ReadCounters.this,MapsActivity.class);
         startActivity(goToMap);*/


           }
       });


done.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast.makeText(ReadCounters.this, ""+readCounter, Toast.LENGTH_SHORT).show();

    }
});

    }


    void getLocation() {
        try {
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5, this);
        }
        catch(SecurityException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onLocationChanged(Location location) {
       // locationText.setText("Current Location: " + location.getLatitude() + ", " + location.getLongitude());
        Toast.makeText(this, "\"Please Enable GPS and Internet\"", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProviderDisabled(String provider) {
        Toast.makeText(this, "Please Enable GPS and Internet", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

}
