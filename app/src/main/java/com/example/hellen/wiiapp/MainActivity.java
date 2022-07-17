package com.example.hellen.wiiapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;



public class MainActivity extends AppCompatActivity {
    EditText mEmailaddress,mPassword;
    Button mButtonLogin;

    private FirebaseAuth mAuth;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser currentUser) {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEmailaddress=(EditText)findViewById(R.id.e_mail);
        mPassword=(EditText)findViewById(R.id.password);
        mButtonLogin=(Button)findViewById(R.id.btnLogin);
        mAuth = FirebaseAuth.getInstance();
        validate();
    }

    private boolean validate() {
        boolean result=false;

        String getmEmail=mEmailaddress.getText().toString();
        String getmPass=mPassword.getText().toString();

        if (getmEmail.isEmpty()){
            Toast.makeText(this, "Email value is empty", Toast.LENGTH_SHORT).show();
        } else if (getmPass.isEmpty()){
            Toast.makeText(this, "password Empty", Toast.LENGTH_SHORT).show();
        } else{
            result=true;
        }
        return result;
    }


    public void MovetoSignup(View view) {
        startActivity(new Intent(MainActivity.this,RegisterActivity.class));
    }

    public void Login(View view) { if (validate()){
        String reg_email=mEmailaddress.getText().toString().trim();
        String reg_password=mPassword.getText().toString().trim();

        mAuth.signInWithEmailAndPassword(reg_email,reg_password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()){
                        Toast.makeText(MainActivity.this, "Registration was successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, HomeActivity.class));
                    } else {
                        Toast.makeText(MainActivity.this, "Registration not successful", Toast.LENGTH_SHORT).show();
                    }

                });
    }
    }
}