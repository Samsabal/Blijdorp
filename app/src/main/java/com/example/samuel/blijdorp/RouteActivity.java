package com.example.samuel.blijdorp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RouteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route);
    }
    public void startMapsActivity (View view) {
        Intent intent = new Intent(this, MapsActivity.class);

        intent.putExtra("ROUTE", 0);

        startActivity(intent);
    }
    public void startMapsActivity1 (View view) {
        Intent intent = new Intent(this, MapsActivity.class);

        intent.putExtra("ROUTE", 1);

        startActivity(intent);
    }
    public void startMapsActivity2 (View view) {
        Intent intent = new Intent(this, MapsActivity.class);

        intent.putExtra("ROUTE", 2);

        startActivity(intent);
    }


}
