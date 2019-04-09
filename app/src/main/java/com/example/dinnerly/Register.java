package com.example.dinnerly;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity implements View.OnClickListener{

    private Button buttonRegister;
    private EditText emailid,password;
    private ProgressDialog progressDialog;
    private TextView Login;
    private FirebaseAuth firebaseauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        firebaseauth=FirebaseAuth.getInstance();
        if(firebaseauth.getCurrentUser()!=null){
            //user is already logged in.. start the profile
            finish();//close the current activity
            startActivity(new Intent(this,Home.class));
        }

        buttonRegister=(Button) findViewById(R.id.buttonRegister);
        Login=(TextView) findViewById(R.id.login);
        emailid = (EditText) findViewById(R.id.Email);
        password=(EditText) findViewById(R.id.Password);
        progressDialog = new ProgressDialog(this);

        buttonRegister.setOnClickListener(this);
        Login.setOnClickListener(this);
    }

    private void registeruser(){
        String email= emailid.getText().toString().trim();
        String pass= password.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Please Enter your email",Toast.LENGTH_SHORT).show();
            return;

        }
        if(TextUtils.isEmpty(pass)){
            Toast.makeText(this,"Please Enter your password",Toast.LENGTH_SHORT).show();
            return;

        }
        //validated
        progressDialog.setMessage("Registering user...");
        progressDialog.show();

        firebaseauth.createUserWithEmailAndPassword(email,pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            //sucessfully registered

                            //user is already logged in.. start the profile

                            progressDialog.dismiss();
                            startActivity(new Intent(Register.this,Home.class));
                            finish();//close the current activity



                        }
                        else{
                            progressDialog.dismiss();
                            Toast.makeText(Register.this,"Could not Register",Toast.LENGTH_SHORT);
                        }
                    }
                });
    }

    private void loginuser(){
        startActivity(new Intent(this,MainActivity.class));

    }

    @Override
    public void onClick(View v) {
        if(v==buttonRegister){
            registeruser();
        }
        else if(v== Login)
        {
            loginuser();
        }
    }
}
