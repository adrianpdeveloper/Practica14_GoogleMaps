package com.example.practica10_jetpacknavigation.home.fragments.home_fragment_1.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practica10_jetpacknavigation.databinding.ItemHotelListBinding;
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
    }
}
