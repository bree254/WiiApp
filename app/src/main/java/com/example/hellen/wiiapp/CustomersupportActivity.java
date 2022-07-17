package com.example.hellen.wiiapp;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class CustomersupportActivity extends AppCompatActivity  {
    Button msg, call,BTN_feedback;
    EditText et_feedback;
    RatingBar ratingbar;
    SwipeRefreshLayout swipeRefreshLayout;
    Vibrator v;
    String getPhone, rating;
    private final int MY_PERMISSIONS_REQUEST_CALL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customersupport);

        msg = findViewById(R.id.msg);
        call = findViewById(R.id.call);
        BTN_feedback = findViewById(R.id.btn_feedback);
        ratingbar = findViewById(R.id.ratingBar);
        et_feedback = findViewById(R.id.et_feedback);
        getPhone = "0701314414";


    }

    public void onClick(View v) {
        if(v==msg){
            //Toast.makeText(this, "msg2", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,MsgActivity.class);
            intent.putExtra("getPhone",getPhone);
            startActivity(intent);
        }
        if(v==call) {
            if (ContextCompat.checkSelfPermission(CustomersupportActivity.this, Manifest.permission.CALL_PHONE)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(CustomersupportActivity.this, new String[]{Manifest.permission.CALL_PHONE},
                        MY_PERMISSIONS_REQUEST_CALL);
            } else {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                //callIntent.setData(Uri.parse("tel:0790780464"));
                callIntent.setData(Uri.parse("tel:"+getPhone));
                startActivity(callIntent);
            }
        }
        if(v==BTN_feedback){
            // Toast.makeText(this, "Feedback", Toast.LENGTH_SHORT).show();
            // String rating=String.valueOf(ratingbar.getRating());
            // Toast.makeText(getApplicationContext(), rating, Toast.LENGTH_LONG).show();
            AlertDialog();
        }
    }
    private void AlertDialog() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        rating=String.valueOf(ratingbar.getRating());
        alertDialogBuilder.setMessage("Are you sure you want to Rate "+rating+" rating");
        alertDialogBuilder.setPositiveButton("YES",
                (arg0, arg1) -> Submit());

        alertDialogBuilder.setNegativeButton("NO",
                (dialog, which) -> Toast.makeText(CustomersupportActivity.this, "Feedback not posted", Toast.LENGTH_SHORT).show());
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void Submit() {
    }
    private void swipe() {
        swipeRefreshLayout = findViewById(R.id.swipe);
        swipeRefreshLayout.setOnRefreshListener(() -> {
            finish();
            startActivity(getIntent());
            swipeRefreshLayout.setRefreshing(false);
        });
    }

}