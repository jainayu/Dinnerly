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

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
    private Button buttonlogin;
    private EditText email;
    private EditText passward;
    private TextView Register;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth= FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser()!=null){
            //user is already logged in.. start the profile
            finish();//close the current activity
            startActivity(new Intent(this,Home.class));
        }
        email= (EditText) findViewById(R.id.LoginEmail);
        passward=(EditText) findViewById(R.id.LoginPassword);
        buttonlogin=(Button) findViewById(R.id.buttonLogin);
        Register=(TextView) findViewById(R.id.Register);
        progressDialog = new ProgressDialog(this);

        buttonlogin.setOnClickListener(this);
        Register.setOnClickListener(this);
    }



    private void userLogin(){
        String emailId= email.getText().toString().trim();
        String pass= passward.getText().toString().trim();
        if(TextUtils.isEmpty(emailId)){
            Toast.makeText(this,"Please Enter your email",Toast.LENGTH_SHORT).show();
            return;

        }
        if(TextUtils.isEmpty(pass)){
            Toast.makeText(this,"Please Enter your password",Toast.LENGTH_SHORT).show();
            return;

        }
        //validated
        progressDialog.setMessage("Logging in...");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(emailId,pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            progressDialog.dismiss();
                            //close the current activity
                            startActivity(new Intent(getApplicationContext(),Home.class));
                            finish();

                        }
                        else{
                            progressDialog.dismiss();
                            Toast.makeText(MainActivity.this,"Invalid Email or Password",Toast.LENGTH_SHORT).show();
                        }

                    }
                });


    }
    @Override
    public void onClick(View v) {
        if(v == buttonlogin){
            userLogin();
        }
        else if(v==Register){
            startActivity(new Intent(MainActivity.this,Register.class));
        }

    }
}


