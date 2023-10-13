package com.example.practica10_jetpacknavigation.home.viewpager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.practica10_jetpacknavigation.home.fragments.home_fragment_1.HomeFragment;
import com.example.practica10_jetpacknavigation.home.fragments.HomeFragment3;
import com.example.practica10_jetpacknavigation.home.fragments.HomeFragment4;
import com.example.practica10_jetpacknavigation.home.fragments.home_fragment_2.HomeFragment2;



public class HomePageAdapter extends FragmentStateAdapter {
    public HomePageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            default:
            case 0:
                return new HomeFragment();
            case 1:
                //Proporciona la posicion al el fragment
                return new HomeFragment2().newInstance(position+1);
            case 2:
                return new HomeFragment3().newInstance(position+1);
            case 3:
                return new HomeFragment4().newInstance(position+1);
        }

    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
