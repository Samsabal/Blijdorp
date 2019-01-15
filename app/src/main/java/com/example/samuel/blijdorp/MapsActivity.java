package com.example.samuel.blijdorp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
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

        int route = getIntent().getIntExtra("ROUTE", 0);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            this.requestPermissions(new String[] {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 99);
        }

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
        }

        LatLng leeuwen = new LatLng(51.928423,4.450090);
        LatLng olifant = new LatLng(51.928391, 4.451794);
        LatLng tijger = new LatLng(51.927190, 4.451310);
        LatLng gorilla = new LatLng(51.925592, 4.451792);


        switch (route) {
            case 0:
                mMap.addMarker(new MarkerOptions().position(leeuwen).title("Aziatische leeuw").snippet("Voedertijd: 11:00"));
                mMap.addMarker(new MarkerOptions().position(olifant).title("Aziatische Olifant").snippet("Voedertijd: 12:00"));
                mMap.addMarker(new MarkerOptions().position(tijger).title("Sumatraanse tijger").snippet("Voedertijd: 13:00"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(leeuwen, 15f));
                break;
            case 1:
                mMap.addMarker(new MarkerOptions().position(leeuwen).title("Aziatische leeuw").snippet("Voedertijd: 11:00"));
                mMap.addMarker(new MarkerOptions().position(olifant).title("Aziatische Olifant").snippet("Voedertijd: 12:00"));

                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(leeuwen, 15f));
                break;
            case 2:
                mMap.addMarker(new MarkerOptions().position(olifant).title("Aziatische Olifant").snippet("Voedertijd: 12:00"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(olifant, 15f));
                break;

        }
    }
}
