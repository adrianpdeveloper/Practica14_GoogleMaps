package com.example.practica10_jetpacknavigation.login;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.practica10_jetpacknavigation.R;
import com.example.practica10_jetpacknavigation.model.Hotel.HotelResponse;
import com.example.practica10_jetpacknavigation.Service.HotelService;
import com.example.practica10_jetpacknavigation.databinding.*;
import com.example.practica10_jetpacknavigation.model.Hotel.Hotel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;
    NavController navController;

    private static HotelService apiService;
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

        probarServicio();
    }

    private void probarServicio() {
        Log.i("Servicio","Servicio aqui");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://01394d44-8918-4a1d-8059-629c50c25e87.mock.pstmn.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(HotelService.class);
        Call<HotelResponse> call = apiService.getApiResponse();
        call.enqueue(new Callback<HotelResponse>() {
            @Override
            public void onResponse(Call<HotelResponse> call, Response<HotelResponse> response) {
                HotelResponse apiResponse = response.body();
                Log.i("COUNT",""+apiResponse.getTotalCount());
                List<Hotel> hotelList = apiResponse.getResult();
                Log.i("Primer Hotel",hotelList.get(0).getName());
            }

            @Override
            public void onFailure(Call<HotelResponse> call, Throwable t) {

            }
        });

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