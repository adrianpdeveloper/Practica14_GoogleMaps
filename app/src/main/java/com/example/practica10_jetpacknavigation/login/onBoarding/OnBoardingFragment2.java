package com.example.practica10_jetpacknavigation.login.onBoarding;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import com.example.practica10_jetpacknavigation.R;
import com.example.practica10_jetpacknavigation.databinding.FragmentOnboarding2Binding;
import com.example.practica10_jetpacknavigation.login.LoginActivity;

public class OnBoardingFragment2 extends Fragment {

    private FragmentOnboarding2Binding binding;
    public OnBoardingFragment2() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentOnboarding2Binding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listeners();
    }

    private void listeners() {
        binding.onboardingSkipBtn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.toLogin));
        binding.onboardingNextBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewPager2 viewPager2 = getActivity().findViewById(R.id.content_vp2);
                viewPager2.setCurrentItem(2);
            }
        });
    }
}