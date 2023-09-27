package com.example.practica10_jetpacknavigation.login.onBoarding;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.practica10_jetpacknavigation.R;
import com.example.practica10_jetpacknavigation.databinding.FragmentContentBinding;
import com.example.practica10_jetpacknavigation.login.onBoarding.viewpager.PageAdapter;



public class ContentFragment extends Fragment {


    private FragmentContentBinding binding;

    public interface ViewPagerChangeListener {
        //Implementa el metodo de la activity onBoarding
        void changeViewPagerPosition(int position);
    }

    public ContentFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentContentBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Adapter
        PageAdapter adapter = new PageAdapter(requireActivity());
        binding.contentVp2.setAdapter(adapter);

    }



}