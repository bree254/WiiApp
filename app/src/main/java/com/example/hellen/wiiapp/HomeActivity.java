package com.example.hellen.wiiapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {


    RecyclerView recyclerHome;
    List<Integer> imageList = new ArrayList<>();
    List<String> imageDescriptionList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        initialize();
    }
    public void initialize(){


        recyclerHome = findViewById(R.id.recyclerView);

        //Setting layout manager for our RecyclerView

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerHome.setLayoutManager(gridLayoutManager);
        //next create an adapter for the recyclerView in  HomeAdapter;



        imageList.add(R.drawable.wifibutton);
        imageList.add(R.drawable.installation);
        imageList.add(R.drawable.addressbook);
        imageList.add(R.drawable.customersupport);
        imageList.add(R.drawable.logout);



        imageDescriptionList.add(getResources().getString(R.string.packages));
        imageDescriptionList.add(getResources().getString(R.string.install));
        imageDescriptionList.add(getResources().getString(R.string.my_account));
        imageDescriptionList.add(getResources().getString(R.string.customer_support));
        imageDescriptionList.add(getResources().getString(R.string.log));
        //after list are ready we send it to the adapter
        recyclerHome.setAdapter(new HomeAdapter(imageList,imageDescriptionList));
    }



    public void GoToPackages(View view) {
        startActivity(new Intent(HomeActivity.this, PackagesActivity.class));

    }

    public void GoToInstallation(View view) {
        startActivity(new Intent(HomeActivity.this, InstallationActivity.class));

    }

    public void GoToMyAccount(View view) {
        startActivity(new Intent(HomeActivity.this, MyAccountActivity.class));
    }

}