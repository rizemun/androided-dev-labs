package com.example.firstapp;


import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class lab02Fragment2 extends Fragment {


    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;

    private FusedLocationProviderClient mFusedLocationClient;

    //сюда будем писать название города когда получим
    private String locationCur;

    //эти перменные используются приватные а не локальные потому что объявляются в методе onCreate а вызываются где попало

    //активити, когда создадим фрагмент запишется тут
    private Activity activity;
    //контекст активити, для быстрого написания
    private Context context;
    //переменная хранящая в себе сам фрагмент
    private View view;

    public lab02Fragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_lab02_2, container, false);


        activity = getActivity();               //наша вторая активити
        context = activity.getBaseContext();    //контекст второй активити

        mFusedLocationClient =
                LocationServices.getFusedLocationProviderClient(context);


        //если данные пермишны(разрешения) не совпадают с нужными
        if (ActivityCompat.checkSelfPermission(context,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            //я не уверен, но
            //если пермишны которые нам нужны относятся к опасным и не даны
            if (!ActivityCompat.shouldShowRequestPermissionRationale(activity,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
                //запрашиваем разрешения
                //ВАЖНО!! так как мы во фрагменте - нужно использовать функцию не из лабника а эту
                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);

                Log.i("Location permission", "asked for permissions");
            } else {
                Log.i("Location permission", "some text");
                getLocation();
            }
        } else {
            //сюда попадаем если у нас изначально были пермишны,
            //то есть каждый раз кроме первого запуска.
            //в лабнике этого ветвления нет.
            getLocation();
        }

        return view;
    }


    /**
     * Функция обрабатывающая выбор пользователя при запросе разрешений.
     * Если разрешил - пишем город.
     */
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[]
                                                   grantResults) {
        if (grantResults.length > 0
                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Log.i("Permission", "access!");
            getLocation();

        } else {
            Log.i("Permission", "denied!");
        }
    }

    //до следующего комментария - код из лабника
    @SuppressLint("MissingPermission")
    private void getLocation() {
        String loc;
        mFusedLocationClient.getLastLocation()
                .addOnSuccessListener(activity, new
                        OnSuccessListener<Location>() {
                            @Override
                            public void onSuccess(Location location) {
                                Log.i("Location", "started!");
                                if (location != null) {
                                    Log.i("Location", "success!");
                                    Geocoder geocoder = new Geocoder(getActivity().getBaseContext(),
                                            Locale.getDefault());
                                    try {
                                        Address address =
                                                geocoder.getFromLocation(location.getLatitude(),
                                                        location.getLongitude(), 1).get(0);
                                        Log.i("Location", "my location is " +
                                                address.getLocality());


                                        locationCur = address.getLocality();

                                        /*Тут мы получили название города и записываем его в список*/

                                        mRecyclerView = view.findViewById(R.id.my_recycler_view2);
                                        mRecyclerView.setHasFixedSize(true);
                                        mLayoutManager = new LinearLayoutManager(view.getContext());
                                        mRecyclerView.setLayoutManager(mLayoutManager);
                                        String[] myString = new String[1];
                                        if (locationCur == null) {
                                            locationCur = "Местоположение не найдено";
                                        }
                                        //сделано так чтобы было меньше расхождений с лабой,
                                        //можно сразу в список пихать полученную строку
                                        myString[0] = locationCur;
                                        List<String> recyclerData = Arrays.asList(myString);
                                        List<String> countries = new ArrayList();
                                        countries.add("Россия");        //используется для надписи и картиночки
                                        mAdapter = new MyRecyclerViewAdapter(recyclerData, countries);
                                        mRecyclerView.setAdapter(mAdapter);


                                        //до конца метода - код из лабника

                                    } catch (IOException e) {

                                        Log.i("Location", "error!");
                                        e.printStackTrace();
                                    }
                                }
                            }
                        })
                .addOnFailureListener(activity, new
                        OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.i("Location", "failed!");
                            }
                        });
    }
}
