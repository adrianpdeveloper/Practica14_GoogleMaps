package com.example.practica10_jetpacknavigation.home.fragments.home_fragment_1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.practica10_jetpacknavigation.model.Hotel.HotelResponse;
import com.example.practica10_jetpacknavigation.Service.HotelService;
import com.example.practica10_jetpacknavigation.databinding.FragmentHomeBinding;
import com.example.practica10_jetpacknavigation.home.fragments.RentCarFragment;
import com.example.practica10_jetpacknavigation.home.fragments.home_fragment_1.adapter.HotelAdapter;
import com.example.practica10_jetpacknavigation.model.Hotel.Hotel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    private static HotelService apiService;
    private List<Hotel> hotelList;

    public HomeFragment() {
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
        binding = FragmentHomeBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listeners();
        getService();
    }

    public void fragmentRentCar() {
        Log.i("Fragment","PULSADO dentro");
        getChildFragmentManager().beginTransaction().add(binding.homeactivityFragmentFrame.getId(), new RentCarFragment()).commitAllowingStateLoss();
    }

    private void listeners() {

    }

    private void adapter(List<Hotel> hotelModelList) {

        //Proporciona la lista al RecyclerView
        hotelModelList = hotelModelList.subList(0, 10);

        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(getContext());
        HotelAdapter adapter = new HotelAdapter(hotelModelList);
        binding.homeFragmentRecycler.setAdapter(adapter);
        binding.homeFragmentRecycler.setLayoutManager(layoutManager);

    }

    //Crea la peticion get
    private void getService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://01394d44-8918-4a1d-8059-629c50c25e87.mock.pstmn.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(HotelService.class);
        Call<HotelResponse> call = apiService.getApiResponse();
        call.enqueue(new Callback<HotelResponse>() {
            @Override
            public void onResponse(Call<HotelResponse> call, Response<HotelResponse> response) {
                //call recibe el objeto HotelResponse, que contiene la lista de hoteles y el total
                HotelResponse apiResponse = response.body();
                Log.i("COUNT",""+apiResponse.getTotalCount());
                //El parametro result de la api devuelve la lista de hoteles
                hotelList = apiResponse.getResult();
                Log.i("Primer Hotel",hotelList.get(0).getName());

                //Rellena recycler view
                adapter(hotelList);
            }

            @Override
            public void onFailure(Call<HotelResponse> call, Throwable t) {
                Log.e("Error de api", t.getMessage());
            }
        });

    }

}