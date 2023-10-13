package com.example.practica10_jetpacknavigation.login.login;

import static com.example.practica10_jetpacknavigation.Constants.*;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.practica10_jetpacknavigation.R;
import com.example.practica10_jetpacknavigation.Service.HotelService;
import com.example.practica10_jetpacknavigation.Service.LoginService;
import com.example.practica10_jetpacknavigation.databinding.FragmentLoginBinding;
import com.example.practica10_jetpacknavigation.home.HomeActivity;
import com.example.practica10_jetpacknavigation.login.LoginActivity;
import com.example.practica10_jetpacknavigation.login.register.RegisterFragment;
import com.example.practica10_jetpacknavigation.model.Hotel.HotelResponse;
import com.example.practica10_jetpacknavigation.model.User;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;
    private String name;
    private String password;
    NavController navController;

    private static LoginService apiService;

    User user;
    Bundle bundle;
    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(getActivity(),R.id.login_activity_frame);
        getNameAndPass();
        enableButton();
        listeners();
        esconderToolbar();
    }

    private void esconderToolbar() {
        LoginActivity loginActivity = (LoginActivity) getActivity();
        loginActivity.esconderToolbar();
    }

    private void getNameAndPass() {
        try {

                    Bundle args = getArguments();
                    if (args.isEmpty()){
                        Log.e("ERROR", "ARGS vacio");
                    }
                    if (args !=null){
                        Log.i("info", "ARGS OK");

                        user = getArguments().getParcelable(KEY_USER);

                        if (user !=null) {
                            Log.i("info", "USERS OK");
                            name = user.getUsername();
                            password = user.getPassword();
                            Log.i("USER",name);
                            Log.i("PASSWORD", password);
                        }else {
                            Log.e("Adrian","NULO");
                        }
                    }

            //bundle = getIntent().getExtras().getBundle("bundle");

        }catch (Exception e){
            Log.i("Mensaje", "No hay password ni contraseña");
        }

    }

    private void functionNotAvailableSnackbar() {
        Snackbar.make(binding.getRoot(), R.string.main_activity_snackbar_not_available_function, BaseTransientBottomBar.LENGTH_LONG).show();
    }

    private void listeners() {
        //GET NEW PASSWORD
        binding.activityMainTv2GetNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                functionNotAvailableSnackbar();
            }
        });

        //CREATE NEW ACCOUNT
        binding.activityMainTv4CreateNew.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.toRegister));

        binding.registerActivityLoginEdittext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (binding.registerActivityLoginEdittext.getText().length()==0){
                    binding.registerActivityLoginIl.setError("Debes rellenar este campo");
                }else{
                    binding.registerActivityLoginIl.setError(null);
                }
                enableButton();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        binding.registerActivityPasswordEdittext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (binding.registerActivityPasswordEdittext.getText().length()==0){
                    binding.registerActivityPasswordIl.setError("Debes rellenar este campo");
                }else{
                    binding.registerActivityPasswordIl.setError(null);
                }
                enableButton();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        binding.activityMainLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name != null && password != null){
                    postService();


                    //navController.navigate(R.id.toHome);
                    Log.i("Hola", "Siguiente Actividad");
                }else{
                    Snackbar.make(binding.getRoot(), R.string.main_activity_login_failed, BaseTransientBottomBar.LENGTH_LONG).show();
                }
            }
        });


    }

    //Crea la peticion
    private void postService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://01394d44-8918-4a1d-8059-629c50c25e87.mock.pstmn.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(LoginService.class);
        Call<User> call = apiService.postLogin(user);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                //Si da respuesta lleva a la home
                bundle = new Bundle();
                bundle.putParcelable(KEY_USER, user);
                Intent intent = new Intent(getContext(), HomeActivity.class).putExtra(KEY_USER_BUNDLE, bundle);
                startActivity(intent);
                Log.i("Hola", "Siguiente Actividad");
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("Error de api", t.getMessage());

            }
        });

    }

    private void enableButton() {
        if (binding.registerActivityPasswordIl.getError()!=null || binding.registerActivityLoginIl.getError()!=null || binding.registerActivityPasswordEdittext.getText().toString().isEmpty() || binding.registerActivityLoginEdittext.getText().toString().isEmpty()){
            binding.activityMainLoginBtn.setEnabled(false);
        }else{
            binding.activityMainLoginBtn.setEnabled(true);
        }
    }
}