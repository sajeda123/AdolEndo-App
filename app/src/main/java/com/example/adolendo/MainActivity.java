package com.example.adolendo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText signInEmailEditText,signInPasswordEditText;
    private TextView signInTextview,forgotPassword;
    private Button signInButton;
    private CheckBox PasswordVisble;
    private ProgressBar progressbar1;
    private FirebaseAuth mAuth;
    private static final String TAG=MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //------------------ Id Indentifier ------------------------//
        signInEmailEditText=findViewById(R.id.SignInEmailEditTextId);
        signInPasswordEditText=findViewById(R.id.SignInPasswordEditTextId);
        signInButton=findViewById(R.id.SignInButtonId);
        signInTextview=findViewById(R.id.SignInTextViewId);
        signInTextview.setOnClickListener(this);
        signInButton.setOnClickListener(this);
        PasswordVisble = findViewById(R.id.showHideBtn1);
        progressbar1=findViewById(R.id.ProgreassBarId);
        forgotPassword=findViewById(R.id.ForgetPassword);


        mAuth = FirebaseAuth.getInstance(); // For FirebaseAuth
        //------------------------- Password Visibility -----------------//
        PasswordVisble.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // checkbox status is changed from uncheck to checked.
                if (!isChecked) {
                    // show password
                    signInPasswordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    // hide password
                    signInPasswordEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });
        //-----------------------Forgot Password -------------------------//
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ForgotPasswordActivity.class));
            }
        });

    }
    //-----------------Register + User Login Clicked ---------------------//
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.SignInButtonId:
                UserLogin();
                break;

            case R.id.SignInTextViewId:
                Intent intent=new Intent(getApplicationContext(),Consent_Activity.class);
                startActivity(intent);
                break;


        }

    }
    //-------------- User Register Validation ------------------//
    private void UserLogin() {


        String email1=signInEmailEditText.getText().toString().trim();
        String pass1=signInPasswordEditText.getText().toString().trim();

        String[] email_part = email1.split("@");
        DemoClass.message=email_part[0];

        if(email1.isEmpty())
        {
            signInEmailEditText.setError("Enter an Email Address");
            signInEmailEditText.requestFocus();
            return;
        }
        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email1).matches())
        {
            signInEmailEditText.setError("Enter a Valid Email Address");
            signInEmailEditText.requestFocus();
            return;
        }

        //checking the validity of the password
        if(pass1.isEmpty())
        {
            signInPasswordEditText.setError("Enter a password");
            signInPasswordEditText.requestFocus();
            return;
        }
        if(pass1.length()<6){
            signInPasswordEditText.setError("Minimum length of password should be 6");
            signInPasswordEditText.requestFocus();
            return;
        }
        progressbar1.setVisibility(View.VISIBLE);
        //---------------------- Firebase Task Start --------------//
        mAuth.signInWithEmailAndPassword(email1,pass1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressbar1.setVisibility(View.GONE);
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"LogIn Successfully",Toast.LENGTH_LONG).show();
                    //Intent intent=new Intent(MainActivity.this,HOME.class);
                    Intent intent=new Intent(MainActivity.this,HOME.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                else{
                    //Toast.makeText(MainActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    String text=task.getException().getMessage();
                    Log.d(TAG,"Text: "+text);
                    Toast toast= Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG);
                        View view=toast.getView();
                        TextView  view1=(TextView)view.findViewById(android.R.id.message);

                        view1.setTextColor(Color.RED);
                        //view.setBackgroundResource(R.color.white);
                        toast.show();

                }
            }
        });
    }
}