package com.example.practica10_jetpacknavigation.home;

import static com.example.practica10_jetpacknavigation.Constants.GOOGLE_MAPS_COORDINATE;
import static com.example.practica10_jetpacknavigation.Constants.GOOGLE_MAPS_HOTEL;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.practica10_jetpacknavigation.R;
import com.example.practica10_jetpacknavigation.databinding.ActivityGoogleMapsBinding;
import com.example.practica10_jetpacknavigation.model.Hotel.Coordinate;
import com.example.practica10_jetpacknavigation.model.Hotel.Hotel;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class GoogleMapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    ActivityGoogleMapsBinding binding;
    private GoogleMap map;
    private Hotel hotel;
    private Coordinate coordinateHotel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGoogleMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        createFragment();
    }

    private void createFragment() {
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapFragment);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        map = googleMap;
        createMarker();
    }

    private void createMarker() {
        Log.i("MARKER", "GET INTENT");
        hotel = (Hotel) getIntent().getExtras().getParcelable(GOOGLE_MAPS_HOTEL);
        coordinateHotel = (Coordinate) getIntent().getExtras().getParcelable(GOOGLE_MAPS_COORDINATE);

        if (hotel !=null && coordinateHotel != null){
            Log.i("HOTEL","Hotel no nulo "+hotel.getName());
            Log.i("HOTEL","Hotel lat"+coordinateHotel.getLat());
            LatLng coordinate = new LatLng(coordinateHotel.getLat(), coordinateHotel.getLon());
            MarkerOptions marker = new MarkerOptions().position(coordinate).title(hotel.getName());
            marker.snippet("Puntuacion: "+hotel.getStarRating());
            map.addMarker(marker);
            map.animateCamera(CameraUpdateFactory.newLatLngZoom(coordinate,18f));
        }

    }

}