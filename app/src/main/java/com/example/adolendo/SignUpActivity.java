package com.example.adolendo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    public EditText SignUpUserIdeEditText,signUpEmailEditText, signUpPasswordEditText, signUpCofirmEditText, signUpNameEditText, editTextIns, editTextClass, editTextSection,
            editTextRoll, editTextEmail, editTextMobile, editTextClassTeacher, editTextClassTeacherMobile, editTextClassTeacherEmail, editTextGurdian, editTextrel, editTextGurdianEmail, editTextdob;
    private TextView signUpTextview, signUpBirthTextview, SignUpTextSign;
    private Button signUpButton;
    private CheckBox PasswordVisble;
    private FirebaseAuth mAuth;
    private ProgressBar progressbar;

    private MaterialTextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        databaseReference = FirebaseDatabase.getInstance().getReference("students");

        ActionBar actionBar = getSupportActionBar();
        ((ActionBar) actionBar).setDisplayHomeAsUpEnabled(true);
        setTitle("Personal Information");

        mAuth = FirebaseAuth.getInstance(); // For FirebaseAuth

        //------------------ Id Indentifier ------------------------//

        signUpPasswordEditText = findViewById(R.id.SignUpPasswordEditTextId);
        signUpCofirmEditText = findViewById(R.id.SignUpConfirmEditTextId);
        signUpButton = findViewById(R.id.SignUpButtonId);
        signUpTextview = findViewById(R.id.SignUpTextViewId);
        SignUpTextSign = findViewById(R.id.SigninUp);
        progressbar = findViewById(R.id.ProgreassBarId);

        SignUpUserIdeEditText=findViewById(R.id.SignUpUserIdeEditTextId);
        signUpNameEditText = findViewById(R.id.SignUpNameEditTextId);
        editTextIns = findViewById(R.id.SignUpInsNameEditTextId);
        editTextClass = findViewById(R.id.SignUpClassEditTextId);
        editTextSection = findViewById(R.id.SignUpSectionEditTextId);
        editTextRoll = findViewById(R.id.SignUpRollEditTextId);
        signUpEmailEditText = findViewById(R.id.SignUpEmailEditTextId);
        editTextMobile = findViewById(R.id.SignUpMobileEditTextId);
        editTextClassTeacher = findViewById(R.id.SignUpTeacherEditTextId);
        editTextClassTeacherMobile = findViewById(R.id.SignUpTeacherMobileEditTextId);
        editTextClassTeacherEmail = findViewById(R.id.SignUpTeacherEmailEditTextId);
        editTextGurdian = findViewById(R.id.SignUpGurdianNameEditTextId);
        editTextGurdianEmail = findViewById(R.id.SignUpGurdianEmailEditTextId);
        editTextrel = findViewById(R.id.SignUpGurdianlRelEditTextId);


        //-------------Click On Method -------------//
        SignUpTextSign.setOnClickListener(this);
        signUpButton.setOnClickListener(this);

        //----------------For Date of Birth------------------//
        mDisplayDate = (MaterialTextView) findViewById(R.id.signUpBirthTextview);

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        SignUpActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                // Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                mDisplayDate.setText(date);
            }
        };

        //------------------------- Password Visibility -----------------//
        PasswordVisble = findViewById(R.id.showHideBtn2);
        PasswordVisble.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // checkbox status is changed from uncheck to checked.
                if (!isChecked) {
                    // show password
                    signUpPasswordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    signUpCofirmEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    // hide password
                    signUpPasswordEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    signUpCofirmEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });

    }

    //-------------- Register + Sign in Clicked -------------//
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.SignUpButtonId:
                User_register();
                Intent intent1 = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(intent1);
                break;

            case R.id.SigninUp:
                //Toast.makeText(getApplicationContext(),"Clicked",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(intent);
                break;

        }
    }

    //-------------- User Register Validation ------------------//
    private void User_register() {
        //Toast.makeText(getApplicationContext(),"User Register Clicked",Toast.LENGTH_SHORT  ).show();
        String email = signUpEmailEditText.getText().toString().trim();
        String pass = signUpPasswordEditText.getText().toString().trim();
        String con = signUpCofirmEditText.getText().toString().trim();
        String name = signUpNameEditText.getText().toString().trim();
        String user_id=SignUpUserIdeEditText.getText().toString().trim();


        //String dob=signUpBirthTextview.getText().toString().trim();
        //checking the validity of the email
        if (!pass.equals(con) || pass.length() != con.length()) {
            signUpCofirmEditText.setError("Password & Confirm Password must be same");
            signUpCofirmEditText.requestFocus();
            return;
        }
        if (name.isEmpty()) {
            signUpNameEditText.setError("Enter Your Name");
            signUpNameEditText.requestFocus();
            return;
        }
        if (email.isEmpty()) {
            signUpEmailEditText.setError("Enter an Email Address");
            signUpEmailEditText.requestFocus();
            return;
        }
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            signUpEmailEditText.setError("Enter a Valid Email Address");
            signUpEmailEditText.requestFocus();
            return;
        }

        //checking the validity of the password
        if (pass.isEmpty()) {
            signUpPasswordEditText.setError("Enter a password");
            signUpPasswordEditText.requestFocus();
            return;
        }
        if (con.isEmpty()) {
            signUpCofirmEditText.setError("Enter a password");
            signUpCofirmEditText.requestFocus();
            return;
        }
        if (pass.length() < 6) {
            signUpPasswordEditText.setError("Minimum length of password should be 6");
            signUpPasswordEditText.requestFocus();
            return;
        }
        if (con.length() < 6) {
            signUpCofirmEditText.setError("Minimum length of password should be 6");
            signUpCofirmEditText.requestFocus();
            return;
        }
        //---------------------- Firebase Task Start --------------//
        progressbar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressbar.setVisibility(View.GONE);
                if (task.isSuccessful()) {

                    //-----------------For Firebase -------------------//

                    String email = signUpEmailEditText.getText().toString().trim();
                    String pass = signUpPasswordEditText.getText().toString().trim();
                    String con = signUpCofirmEditText.getText().toString().trim();
                    String name = signUpNameEditText.getText().toString().trim();

                    String institutionName = editTextIns.getText().toString().trim();
                    String classnName = editTextClass.getText().toString().trim();
                    String section = editTextSection.getText().toString().trim();
                    String roll = editTextRoll.getText().toString().trim();
                    String mobile = editTextMobile.getText().toString().trim();
                    String classTeacherName = editTextClassTeacher.getText().toString().trim();
                    String classTeacherMobile = editTextClassTeacherMobile.getText().toString().trim();
                    String classTeacherEmail = editTextClassTeacherEmail.getText().toString().trim();
                    String gurdaianName = editTextGurdian.getText().toString().trim();
                    String gurdianRelation = editTextrel.getText().toString().trim();
                    String gurdianEmail = editTextGurdianEmail.getText().toString().trim();
                    String dob = mDisplayDate.getText().toString().trim();

                    //String key = databaseReference.push().getKey();

                    String[] email_part = email.split("@");
                    DemoClass.message=email_part[0];

                    Student student = new Student(name, institutionName, classnName, section, roll, email, mobile, classTeacherName, classTeacherMobile, classTeacherEmail, gurdaianName, gurdianRelation, gurdianEmail, dob);
                    databaseReference.child(email_part[0]).setValue(student);

                    Toast toast = Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_LONG);
                    View view = toast.getView();
                    TextView view1 = (TextView) view.findViewById(android.R.id.message);
                    view1.setTextColor(Color.GREEN);
                    toast.show();

                    signUpEmailEditText.setText("");
                    signUpPasswordEditText.setText("");
                    signUpCofirmEditText.setText("");
                    signUpNameEditText.setText("");
                    editTextIns.setText("");
                    editTextClass.setText("");
                    editTextSection.setText("");
                    editTextRoll.setText("");
                    editTextMobile.setText("");
                    editTextClassTeacher.setText("");
                    editTextClassTeacherMobile.setText("");
                    editTextClassTeacherEmail.setText("");
                    editTextGurdian.setText("");
                    editTextrel.setText("");
                    editTextGurdianEmail.setText("");
                    mDisplayDate.setText("");

                } else {
                    if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                        Toast toast = Toast.makeText(getApplicationContext(), "User is Already Registered", Toast.LENGTH_LONG);
                        View view = toast.getView();
                        TextView view1 = (TextView) view.findViewById(android.R.id.message);

                        view1.setTextColor(Color.RED);
                        toast.show();
                        //view.setBackgroundResource(R.color.whi);
                    } else {
                        Toast toast = Toast.makeText(getApplicationContext(), "Error: " + task.getException().getMessage(), Toast.LENGTH_LONG);
                        View view = toast.getView();
                        TextView view1 = (TextView) view.findViewById(android.R.id.message);

                        view1.setTextColor(Color.RED);
                        toast.show();
                        //view.setBackgroundResource(R.color.whi);

                    }
                }
            }
        });
        //----------------------------------------------//
    }
}
