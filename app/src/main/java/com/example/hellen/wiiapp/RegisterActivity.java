package com.example.hellen.wiiapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
    EditText username,userpassword,confirmpassword,useremail;
    Button regbutton;

    private FirebaseAuth mAuth;

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser=mAuth.getCurrentUser();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth=FirebaseAuth.getInstance();

        findIds();
        validate();
    }

    private boolean validate() {
        boolean result=false;
        String getname=username.getText().toString();
        String getemail=useremail.getText().toString();
        String getpassword=userpassword.getText().toString();
        String getconfirmpassword=confirmpassword.getText().toString();

        if (getname.isEmpty()){
            Toast.makeText(this,"The username is Empty",Toast.LENGTH_SHORT).show();
        } else if(getemail.isEmpty()){
            Toast.makeText(this, "Email is empty", Toast.LENGTH_SHORT).show();
        } else if(getpassword.isEmpty()){
            Toast.makeText(this, "password is empty", Toast.LENGTH_SHORT).show();
        } else if(getconfirmpassword.isEmpty()){
            Toast.makeText(this, "confirm password is empty", Toast.LENGTH_SHORT).show();
        }

        else{
            result=true;
        }
        return result;

    }

    private void findIds() {
        username=(EditText)findViewById(R.id.etUserName);
        useremail=(EditText)findViewById(R.id.etUserEmail);
        userpassword=(EditText)findViewById(R.id.etUserPass);
        confirmpassword=(EditText)findViewById(R.id.etConfirmPass);

        regbutton=(Button)findViewById(R.id.btnRegister);
    }

    public void MovetoLogin(View view) {
        startActivity(new Intent(RegisterActivity.this,MainActivity.class));
    }


    public void RegisterUser(View view) { if (validate()){
        String reg_email=useremail.getText().toString().trim();
        String reg_password=userpassword.getText().toString().trim();

        mAuth.createUserWithEmailAndPassword(reg_email,reg_password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()){
                        Toast.makeText(RegisterActivity.this, "Registration was successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity.this,MainActivity.class));
                    } else {
                        Toast.makeText(RegisterActivity.this, "Registration not successful", Toast.LENGTH_SHORT).show();
                    }

                });
    }
    }
}