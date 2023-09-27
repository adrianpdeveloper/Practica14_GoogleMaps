package com.example.practica10_jetpacknavigation.home.fragments.home_fragment_2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.practica10_jetpacknavigation.R;
import com.example.practica10_jetpacknavigation.data.RepositoryCars;
import com.example.practica10_jetpacknavigation.databinding.FragmentHome2Binding;
import com.example.practica10_jetpacknavigation.home.HomeActivity;
import com.example.practica10_jetpacknavigation.home.fragments.home_fragment_2.adapter.CarAdapter;

public class HomeFragment2 extends Fragment {


    HomeActivity homeActivity;
    private int position;
    private FragmentHome2Binding binding;
    public HomeFragment2() {
        // Required empty public constructor
    }

    //Recoje la posicion proporcionada de HomePageAdapter
    public static HomeFragment2 newInstance(int position) {

        Bundle args = new Bundle();

        HomeFragment2 fragment = new HomeFragment2();
        args.putInt("position",position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt("position", 0);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHome2Binding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter();
    }

    private void adapter() {

        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(getContext());
        CarAdapter adapter = new CarAdapter(RepositoryCars.getCarList());
        binding.homeFragment2Recycler.setAdapter(adapter);
        binding.homeFragment2Recycler.setLayoutManager(layoutManager);

    }

}