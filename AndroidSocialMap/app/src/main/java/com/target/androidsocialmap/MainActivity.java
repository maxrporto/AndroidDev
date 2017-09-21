package com.target.androidsocialmap;

import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.maps.model.LatLng;

import static android.R.attr.tag;

public class MainActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
    }

    public  void buttonclick(View view){

        try {
            LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
            double longitude = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER).getLongitude();
            double latitude =locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER).getLatitude();

            Intent intent = new Intent(this, MapsActivity.class);
            intent.putExtra("tag_long", longitude);
            intent.putExtra("tag_lat",latitude);
            intent.putExtra("tag_msg", editText.getText().toString());
            startActivity(intent);

        }catch (SecurityException e ){e.printStackTrace();}


    }
}
