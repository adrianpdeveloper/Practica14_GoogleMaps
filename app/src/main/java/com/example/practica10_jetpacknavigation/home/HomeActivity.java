package com.example.practica10_jetpacknavigation.home;

import static com.example.practica10_jetpacknavigation.Constants.KEY_USER;
import static com.example.practica10_jetpacknavigation.Constants.KEY_USER_BUNDLE;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import com.example.practica10_jetpacknavigation.R;


import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.util.Log;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;


import com.example.practica10_jetpacknavigation.databinding.ActivityHomeBinding;
import com.example.practica10_jetpacknavigation.home.fragments.home_fragment_1.HomeFragment;
import com.example.practica10_jetpacknavigation.home.viewpager.HomePageAdapter;
import com.example.practica10_jetpacknavigation.model.User;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_LOCATION_PERMISSION = 1;
    private static final int REQUEST_CODE_POST_NOTIFICATIONS_PERMISSION = 2;
    private ActivityHomeBinding binding;
    private String name;
    private User user;
    private String password;

    private Bundle bundle;
    ViewPager2 viewPager2;
    TabLayout tabLayout;
    private HomeFragment homeFragment;

    String[] permisos = new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};

    List<Fragment> fragments = getSupportFragmentManager().getFragments();

    public int fragmentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getNameAndPass();
        showNotification();
        //inflateFragment();
        locationPermission();
        viewPager();
        listeners();
    }

    private void showNotification() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED) {
            Log.i("Info", "Permiso concedido");
            //Comprobar si la version es compatible
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                Log.i("Info", "Version correcta");
                String id = "my_channel_01";
                //NotificationManager
                NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);

                //Canal de notificaciones
                NotificationChannel channel = new NotificationChannel(id, "chanelName", NotificationManager.IMPORTANCE_HIGH);
                channel.enableVibration(true);


                notificationManagerCompat.createNotificationChannel(channel);



            Bitmap imgBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.notification_img);

            //Crear notificación
            NotificationCompat.Builder noBuilder = new NotificationCompat.Builder(this, id)
                    .setContentTitle("Bienvenido " + user.getUsername())
                    .setContentText("Nos alegra verte en este paraíso.")
                    .setSmallIcon(R.drawable.air_plain)
                    .setLargeIcon(imgBitmap);


            notificationManagerCompat.notify(1, noBuilder.build());
            }
        }else {
            //En caso de no tener permisos, los pide
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.POST_NOTIFICATIONS},REQUEST_CODE_POST_NOTIFICATIONS_PERMISSION);
            showNotification();
        }

    }

    private void locationPermission() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)!= PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            //Pide los permisos necesarios
            ActivityCompat.requestPermissions(this,permisos, REQUEST_CODE_LOCATION_PERMISSION);
        }else{

        }
    }

    private void viewPager() {
        HomePageAdapter adapter = new HomePageAdapter(this);
        viewPager2 = binding.homeVp2;
        viewPager2.setAdapter(adapter);
        tabLayout = binding.homeTablayout;


        //Configura tabs
        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            switch (position){
                case 0:
                    tab.setIcon(R.drawable.baseline_camera_alt_black_24dp);
                    tab.view.setBackground(ContextCompat.getDrawable(this, R.drawable.blue_tab_background));

                    break;
                case 1:
                    tab.setIcon(R.drawable.baseline_directions_car_white_24dp);
                    tab.view.setBackground(ContextCompat.getDrawable(this, R.drawable.purple_tab_background));
                    break;
                case 2:
                    tab.setIcon(R.drawable.baseline_terrain_black_24dp);
                    tab.view.setBackground(ContextCompat.getDrawable(this, R.drawable.pink_tab_background));
                    break;
                case 3:
                    tab.setIcon(R.drawable.baseline_face_black_24dp);
                    tab.view.setBackground(ContextCompat.getDrawable(this, R.drawable.yellow_tab_background));
                    break;
            }

            //Cambia color de tab según la seleccion
            tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    tab.getIcon().setTint(ContextCompat.getColor(getApplicationContext(),R.color.white));
                }
                @Override
                public void onTabUnselected(TabLayout.Tab tab) {
                    tab.getIcon().setTint(ContextCompat.getColor(getApplicationContext(),R.color.black));
                }
                @Override
                public void onTabReselected(TabLayout.Tab tab) {
                }
            });
        }).attach();

    }

    private void listeners() {
        HomePageAdapter adapter = new HomePageAdapter(this);
        binding.mainActivityToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.menu_coche){
                    Log.i("Fragment","PULSADO");
                    //Genera fragment RentCar de HomeFragment1
                    homeFragment = (HomeFragment) getSupportFragmentManager().findFragmentByTag("f0");
                    if (homeFragment!=null){
                        Log.i("Fragment","NO NULO");
                        homeFragment.fragmentRentCar();
                    }
                }
                if (item.getItemId() == R.id.menu_disney){
                    String url = "https://www.disneylandparis.com/";
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                }
                return false;
            }
        });
    }

    private void getNameAndPass() {
        try {
            bundle = new Bundle();
            bundle = getIntent().getExtras().getBundle(KEY_USER_BUNDLE);
            user = bundle.getParcelable(KEY_USER);
            if (user!=null){
                name = user.getUsername();
                password = user.getPassword();
                Log.i("Nombre","Nombre: "+name);
                Log.i("Pass","Contraseña: "+password);
            }else {
                Log.e("NULO","NULO");
            }


        }catch (Exception e){
            Log.i("Mensaje", "No hay password ni contraseña");
        }
    }
    public int getCurrentFragment(){
        int position = viewPager2.getCurrentItem();
        return position;
    }


    //Maneja resultados de peticiones de permisos.
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //Maneja resultado de la peticion de permiso de localizacion.
        if (requestCode == REQUEST_CODE_LOCATION_PERMISSION){
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){

            }else{
                new AlertDialog.Builder(this)
                        .setTitle("Sin permisos de ubicacion")
                        .setMessage("No aceptaste los permisos de ubicacion, activalos desde configuración para continuar.")
                        .setPositiveButton("Ir a configuración", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                Uri uri = Uri.fromParts("package", getPackageName(), null);
                                intent.setData(uri);
                                startActivity(intent);
                            }
                        }).setNegativeButton("Salir", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        })
                        .create()
                        .show();

            }
        }
    }
    /*private void inflateFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(binding.homefragmentFrame.getId(), new HomeFragment())
                .addToBackStack(null)
                .commitAllowingStateLoss();
    }*/

}