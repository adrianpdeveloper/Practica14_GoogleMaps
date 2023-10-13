package com.example.practica10_jetpacknavigation.home.fragments.home_fragment_1.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practica10_jetpacknavigation.databinding.ItemHotelListBinding;
import com.example.practica10_jetpacknavigation.model.Car;
import com.example.practica10_jetpacknavigation.model.Hotel.Hotel;

import java.util.List;

public class HotelAdapter extends RecyclerView.Adapter<ItemHotelViewHolder> {
    private final List<Hotel> items;

    private ItemHotelListBinding binding;

    public HotelAdapter(List<Hotel> hotelList) {
        this.items = hotelList;
    }
    @NonNull
    @Override
    public ItemHotelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemHotelListBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ItemHotelViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHotelViewHolder holder, int position) {
        holder.bind(items.get(position));

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
