package com.example.practica10_jetpacknavigation.data;

import com.example.practica10_jetpacknavigation.R;
import com.example.practica10_jetpacknavigation.model.Car;


import java.util.ArrayList;
import java.util.List;

public abstract class RepositoryCars {
    public static List<Car> getCarList(){
        ArrayList<Car> listCar= new ArrayList<>();
        listCar.add(new Car("Classic Car",34.00f,false, R.color.classic_car,R.drawable.classic_car));
        listCar.add(new Car("Sport Car",55.00f,false, R.color.sport_car, R.drawable.sport_cart));
        listCar.add(new Car("Flying Car",500.00f,false, R.color.flying_car, R.drawable.flying_car));
        listCar.add(new Car("Flying Car", 500.00f, false, R.color.electic_car, R.drawable.electric_car));
        listCar.add(new Car("Motorhome", 23.00f, false, R.color.motor_home, R.drawable.motor_home));
        listCar.add(new Car("Pickup", 10.00f, false, R.color.pick_up_car, R.drawable.pick_up_car));
        listCar.add(new Car("Airplane", 11.00f, false, R.color.air_plain, R.drawable.air_plain));
        listCar.add(new Car("Airplane", 14.00f, false, R.color.bus, R.drawable.bus));
        return listCar;
    }
}
