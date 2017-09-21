package com.target.androidaula8;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private String[] permissions={Manifest.permission.ACCESS_FINE_LOCATION};
    private SupportMapFragment mapFragment;
    private LocationManager locationManagercation;
    private LatLng latLng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);


        //pede permissão se a API for maior ou igual á 23
        //VERSION_CODES.M (versão marshmellon
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                && checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_DENIED){

            requestPermissions(permissions, 101);
        }else {

            initMap();
        }
    }

    private void initMap(){

        mapFragment.getMapAsync(this);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        locationManagercation = (LocationManager) getSystemService(LOCATION_SERVICE);

        try{
            locationManagercation.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    latLng = new LatLng(location.getLatitude(), location.getLongitude());

                    try {

                        Geocoder geocoder = new Geocoder(getBaseContext());
                        List<Address> addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1);

                        mMap.addMarker(new MarkerOptions().position(latLng).title(addresses.get(0).getPostalCode()));
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                        mMap.setMinZoomPreference(0.3f);
                    }catch (IOException e){e.printStackTrace();}

                }

                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {

                }

                @Override
                public void onProviderEnabled(String provider) {

                }

                @Override
                public void onProviderDisabled(String provider) {

                }
            });
        }catch ( SecurityException e){ e.printStackTrace();}

       // Add a marker in Sydney and move the camera
       // LatLng sydney = new LatLng(-34, 151);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] results){
        if(results.length > 0){

            if(results[0] == PackageManager.PERMISSION_GRANTED){
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                        && checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){

                    //AQUI JÁ TEMOS PERMISSÃO
                    initMap();
                }
            }
        }
    }
}
