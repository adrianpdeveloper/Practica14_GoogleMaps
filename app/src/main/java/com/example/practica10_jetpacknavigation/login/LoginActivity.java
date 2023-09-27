package com.example.practica10_jetpacknavigation.login;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.practica10_jetpacknavigation.R;
import com.example.practica10_jetpacknavigation.databinding.*;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;
    NavController navController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.loginActivityToolbar);
        NavHostFragment host = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.login_activity_frame);
        navController = new NavController(this);
        esconderToolbar();
        listeners();
    }

    public void mostrarToolbar() {
        binding.loginActivityToolbar.setVisibility(View.VISIBLE);
    }

    public void esconderToolbar() {
        binding.loginActivityToolbar.setVisibility(View.GONE);
    }

    private void listeners() {
        binding.loginActivityToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController navController, @NonNull NavDestination navDestination, @Nullable Bundle bundle) {
                if (navDestination.getId()==R.id.register_fragment){
                    mostrarToolbar();
                }else{
                    esconderToolbar();
                }
            }
        });

    }

    /*private void inflateFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(binding.loginActivityFrame.getId(), new LoginFragment())
                .addToBackStack(null)
                .commitAllowingStateLoss();
    }*/

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        navController.popBackStack();
    }
}