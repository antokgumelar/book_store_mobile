package com.example.renbistore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Store extends AppCompatActivity implements OnMapReadyCallback {
    GoogleMap map;
    LatLng  home, position;
    Double latitude, longitude, x, y;
    int PLACE_AUTO = 1;

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        home = new LatLng(-7.002822, 110.445092);
        map.addMarker(new MarkerOptions().position(home).title("Welcome to Renbi Store")).showInfoWindow();
        map.moveCamera(CameraUpdateFactory.newLatLng(home));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(home, 16));
        map.setTrafficEnabled(true);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PLACE_AUTO) {
            if (resultCode == RESULT_OK) {
                Place place = PlaceAutocomplete.getPlace(this, data);
                LatLng search = place.getLatLng();
                x = place.getLatLng().latitude;
                y = place.getLatLng().longitude;
                String alamat = place.getAddress().toString();
                String telp = place.getPhoneNumber().toString();
                String nama = place.getName().toString();
                String snip = alamat + System.getProperty("line.separator") + telp;
                map.addMarker(new MarkerOptions().position(search).title(nama).snippet(snip)).showInfoWindow();
                map.animateCamera(CameraUpdateFactory.newLatLng(search));
                map.animateCamera(CameraUpdateFactory.newLatLngZoom(search, 18));
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        try {
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
        }

        Button btnHome = (Button) findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Home.class);
                startActivity(i);
            }
        });


        Button btnBook = (Button) findViewById(R.id.btnBook);
        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Book.class);
                startActivity(i);
            }
        });

        Button btnProfil = (Button) findViewById(R.id.btnProfil);
        btnProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Profile.class);
                startActivity(i);
            }
        });

        Button btnSocmed = (Button) findViewById(R.id.btnSocmed);
        btnSocmed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Sosmed.class);
                startActivity(i);
            }
        });

        Button btnPhoVid = (Button) findViewById(R.id.btnPhoVid);
        btnPhoVid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Video.class);
                startActivity(i);
            }
        });

    }
}