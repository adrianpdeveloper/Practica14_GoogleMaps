package com.example.practica10_jetpacknavigation.home.fragments.home_fragment_1.adapter;

import static com.example.practica10_jetpacknavigation.Constants.GOOGLE_MAPS_COORDINATE;
import static com.example.practica10_jetpacknavigation.Constants.GOOGLE_MAPS_HOTEL;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practica10_jetpacknavigation.databinding.ItemHotelListBinding;
import com.example.practica10_jetpacknavigation.home.GoogleMapsActivity;
import com.example.practica10_jetpacknavigation.home.HomeActivity;
import com.example.practica10_jetpacknavigation.model.Hotel.Hotel;
import com.squareup.picasso.Picasso;

public class ItemHotelViewHolder extends RecyclerView.ViewHolder {

    private ItemHotelListBinding binding;
    public ItemHotelViewHolder(@NonNull ItemHotelListBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
    public void bind(Hotel itemHotel){

        Picasso.get().load(itemHotel.getOptimizedThumbUrls().getSrpDesktop()).into(binding.itemLayoutListcarImg);
        binding.itemLayoutListhotelName.setText(itemHotel.getName()+" - "+itemHotel.getAddress().getStreetAddress());
        binding.itemLayoutListhotelMunicipio.setText(itemHotel.getAddress().getLocality());
        binding.itemLayoutListhotelPrecio.setText(itemHotel.getRatePlan().getPrice().getExactCurrent()+"€/ppn");
        binding.itemLayoutListhotelRating.setText(itemHotel.getStarRating()+"/5");

        binding.itemLayoutListhotelName.setOnClickListener(view -> abrirMapa(view, itemHotel));
        binding.itemLayoutListhotelMunicipio.setOnClickListener(view -> abrirMapa(view, itemHotel));
        binding.itemLayoutListcarImg.setOnClickListener(view -> abrirMapa(view, itemHotel));

    }

    private void abrirMapa(View view,Hotel itemHotel) {
        Log.i("VIEW_HOLDER COORDINATE",itemHotel.getCoordinate().getLat()+"");
        Intent intent = new Intent(view.getContext(), GoogleMapsActivity.class);
        intent.putExtra(GOOGLE_MAPS_HOTEL,itemHotel);
        intent.putExtra(GOOGLE_MAPS_COORDINATE,itemHotel.getCoordinate());
        view.getContext().startActivity(intent);
    }


}
