package com.example.practica10_jetpacknavigation.home.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.practica10_jetpacknavigation.databinding.FragmentHome3Binding;
import com.example.practica10_jetpacknavigation.home.HomeActivity;


public class HomeFragment3 extends Fragment {

    HomeActivity homeActivity;
    private FragmentHome3Binding binding;
    private int position;
    public HomeFragment3() {
        // Required empty public constructor
    }

    //Recoje la posicion proporcionada de HomePageAdapter
    public static HomeFragment3 newInstance(int position) {

        Bundle args = new Bundle();

        HomeFragment3 fragment = new HomeFragment3();
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
        binding = FragmentHome3Binding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Muestra la posicion en pantalla
        binding.fragment3Tv.setText("Fragment: "+position);
    }

}