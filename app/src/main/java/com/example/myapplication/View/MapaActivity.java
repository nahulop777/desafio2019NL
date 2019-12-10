package com.example.myapplication.View;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.example.myapplication.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapaActivity extends FragmentActivity implements OnMapReadyCallback {


        GoogleMap map;
        Double v1 = null;
        Double v = null;
        public static final String LATITUD= "latitud";
        public static final String LONGITUD= "longitud";


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_mapa);

            Intent intent = getIntent();
            Bundle bundle = intent.getExtras();
            v = bundle.getDouble(LATITUD);
            v1 = bundle.getDouble(LONGITUD);

            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);
        }

        @Override
        public void onMapReady(GoogleMap googleMap) {

            this.map=googleMap;
            LatLng place = new LatLng(v,v1);
            map.addMarker(new MarkerOptions().position(place).title("Donde estoy ahora"));
            map.moveCamera(CameraUpdateFactory.newLatLng(place));

        }
}
