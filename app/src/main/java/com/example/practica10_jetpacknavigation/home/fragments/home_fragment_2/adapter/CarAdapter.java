package com.example.practica10_jetpacknavigation.home.fragments.home_fragment_2.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practica10_jetpacknavigation.databinding.ItemCarListBinding;
import com.example.practica10_jetpacknavigation.model.Car;


import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<ItemCarViewHolder> {

    private final List<Car> items;
    private ItemCarListBinding binding;

    public interface OnCarItem{
        void onCarClick(Car itemSelected);
    }
    public CarAdapter(List<Car> carList) {
        this.items = carList;
    }

    @NonNull
    @Override
    public ItemCarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemCarListBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ItemCarViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemCarViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
