package com.example.practica10_jetpacknavigation.login.onBoarding;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import com.example.practica10_jetpacknavigation.R;
import com.example.practica10_jetpacknavigation.databinding.FragmentOnBoarding1Binding;
import com.example.practica10_jetpacknavigation.login.LoginActivity;
public class OnBoardingFragment1 extends Fragment {
    private FragmentOnBoarding1Binding binding;
    public OnBoardingFragment1() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentOnBoarding1Binding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listeners();
    }

    private void listeners() {
        binding.onboardingNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Utiliza el metodo de la activity implementado en ContentFragment
                /*Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
                if (getActivity() instanceof ContentFragment.ViewPagerChangeListener) {
                    ((ContentFragment.ViewPagerChangeListener) getActivity()).changeViewPagerPosition(1); // Cambia al fragmento deseado
                }*/
                ViewPager2 viewPager2 = getActivity().findViewById(R.id.content_vp2);
                viewPager2.setCurrentItem(1);

            }
        });
    }
}