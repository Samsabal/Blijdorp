package com.example.samuel.blijdorp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

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

        LatLng ingang = new LatLng(51.928121, 4.444192);
        LatLng zeeleeuw = new LatLng(51.928617, 4.444528);
        LatLng ijsbeer = new LatLng(51.927691, 4.445150);
        LatLng vlinders = new LatLng(51.928511, 4.447350);
        LatLng leeuwen = new LatLng(51.928423,4.450090);
        LatLng olifant = new LatLng(51.928391, 4.451794);
        LatLng tijger = new LatLng(51.927190, 4.451310);
        LatLng gorilla = new LatLng(51.925592, 4.451792);

        LatLng r1 = new LatLng(51.928020, 4.444452);
        LatLng r2 = new LatLng(51.927996, 4.446437);
        LatLng r3 = new LatLng(51.927938, 4.451841);
        LatLng r4 = new LatLng(51.927389, 4.451841);
        LatLng r5 = new LatLng(51.926942, 4.450709);
        LatLng r6 = new LatLng(51.925959, 4.451020);



        switch (route) {
            case 1:
                mMap.addMarker(new MarkerOptions().position(ingang).title("Ingang"));
                mMap.addMarker(new MarkerOptions().position(zeeleeuw).title("Zeeleeuw").snippet("Voedertijd: 10:00"));
                mMap.addMarker(new MarkerOptions().position(ijsbeer).title("Ijsbeer").snippet("Voedertijd: 11:00"));
                mMap.addMarker(new MarkerOptions().position(vlinders).title("Vlinders").snippet("Voedertijd: 11:30"));
                mMap.addMarker(new MarkerOptions().position(leeuwen).title("Aziatische leeuw").snippet("Voedertijd: 12:00"));
                mMap.addMarker(new MarkerOptions().position(olifant).title("Aziatische olifant").snippet("Voedertijd: 13:00"));
                mMap.addMarker(new MarkerOptions().position(tijger).title("Sumatraanse tijger").snippet("Voedertijd: 14:00"));
                mMap.addMarker(new MarkerOptions().position(gorilla).title("Westelijke laagland gorilla").snippet("Voedertijd: 15:00"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ingang, 15f));
                mMap.addPolyline(
                        new PolylineOptions()
                            .add(ingang)
                            .add(r1)
                            .add(zeeleeuw)
                            .add(r1)
                            .add(ijsbeer)
                            .add(r2)
                            .add(vlinders)
                            .add(leeuwen)
                            .add(olifant)
                            .add(r3)
                            .add(r4)
                            .add(tijger)
                            .add(r5)
                            .add(r6)
                            .add(gorilla)
                );
                break;
            case 2:
                mMap.addMarker(new MarkerOptions().position(ingang).title("Ingang"));
                mMap.addMarker(new MarkerOptions().position(zeeleeuw).title("Zeeleeuw").snippet("Voedertijd: 10:00"));
                mMap.addMarker(new MarkerOptions().position(ijsbeer).title("Ijsbeer").snippet("Voedertijd: 11:00"));
                mMap.addMarker(new MarkerOptions().position(vlinders).title("Vlinders").snippet("Voedertijd: 11:30"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ingang, 15f));
                mMap.addPolyline(
                        new PolylineOptions()
                                .add(ingang)
                                .add(r1)
                                .add(zeeleeuw)
                                .add(r1)
                                .add(ijsbeer)
                                .add(r2)
                                .add(vlinders)
                );
                break;
            case 3:
                mMap.addMarker(new MarkerOptions().position(ingang).title("Ingang"));
                mMap.addMarker(new MarkerOptions().position(leeuwen).title("Aziatische leeuw").snippet("Voedertijd: 12:00"));
                mMap.addMarker(new MarkerOptions().position(olifant).title("Aziatische olifant").snippet("Voedertijd: 13:00"));
                mMap.addMarker(new MarkerOptions().position(tijger).title("Sumatraanse tijger").snippet("Voedertijd: 14:00"));
                mMap.addMarker(new MarkerOptions().position(gorilla).title("Westelijke laagland gorilla").snippet("Voedertijd: 15:00"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ingang, 15f));
                mMap.addPolyline(
                        new PolylineOptions()
                                .add(ingang)
                                .add(r1)
                                .add(ijsbeer)
                                .add(r2)
                                .add(vlinders)
                                .add(leeuwen)
                                .add(olifant)
                                .add(r3)
                                .add(r4)
                                .add(tijger)
                                .add(r5)
                                .add(r6)
                                .add(gorilla)
                );
                break;
                default:
                    mMap.addMarker(new MarkerOptions().position(ingang).title("Ingang"));
                    mMap.addMarker(new MarkerOptions().position(zeeleeuw).title("Zeeleeuw").snippet("Voedertijd: 10:00"));
                    mMap.addMarker(new MarkerOptions().position(ijsbeer).title("Ijsbeer").snippet("Voedertijd: 11:00"));
                    mMap.addMarker(new MarkerOptions().position(vlinders).title("Vlinders").snippet("Voedertijd: 11:30"));
                    mMap.addMarker(new MarkerOptions().position(leeuwen).title("Aziatische leeuw").snippet("Voedertijd: 12:00"));
                    mMap.addMarker(new MarkerOptions().position(olifant).title("Aziatische olifant").snippet("Voedertijd: 13:00"));
                    mMap.addMarker(new MarkerOptions().position(tijger).title("Sumatraanse tijger").snippet("Voedertijd: 14:00"));
                    mMap.addMarker(new MarkerOptions().position(gorilla).title("Westelijke laagland gorilla").snippet("Voedertijd: 15:00"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ingang, 15f));

        }
    }
    public void startRouteActivity2 (View view) {
        Intent intent = new Intent(this, RouteActivity.class);
        startActivity(intent);
    }
}
