package com.example.adolendo;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ParProfile_Activity extends AppCompatActivity {
    private TextView textViewIns;
    private TextView textViewClass;
    private TextView textViewSection;
    private TextView textViewRoll;
    private TextView textViewEmail;
    private TextView textViewMobile;
    private TextView textViewClassTeacher;
    private TextView textViewClassTeacherEmail;
    private TextView textViewClassTeacherPhone;
    private TextView textViewGurdian;
    private TextView textViewReal;
    private TextView textViewGurdianEmail;
    private TextView textViewdob;
    private TextView textViewName;

    FirebaseAuth auth;
    FirebaseUser user;
    DatabaseReference databaseReference;

    private static final String TAG=ParProfile_Activity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_par_profile_);

        ActionBar actionBar=getSupportActionBar();
        ((ActionBar) actionBar).setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        setTitle("Profile Information");

        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();

        textViewName = findViewById(R.id.text_name);
        textViewIns=findViewById(R.id.text_ins);
        textViewClass=findViewById(R.id.text_class);
        textViewSection=findViewById(R.id.text_sec);
        textViewRoll=findViewById(R.id.text_roll);
        textViewEmail=findViewById(R.id.text_email);
        textViewMobile=findViewById(R.id.text_mobile);
        textViewClassTeacher=findViewById(R.id.text_classTeacher);
        textViewClassTeacherEmail=findViewById(R.id.text_teacherEmail);
        textViewClassTeacherPhone=findViewById(R.id.classTeacherMobile);
        textViewGurdian=findViewById(R.id.text_gurdian);
        textViewReal=findViewById(R.id.text_rel);
        textViewGurdianEmail=findViewById(R.id.text_gurdiansEmail);
        textViewdob=findViewById(R.id.text_dob);

        //SharedPreferences sh = getSharedPreferences("MySharedPref", 0);
        //String s1 = sh.getString("name", "");

        //String url=(DemoClass.message).toString().trim();

       // Log.d("Details",url);
        String key=DemoClass.message;
        databaseReference= FirebaseDatabase.getInstance().getReference().child("students").child( DemoClass.message);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                String text1=snapshot.child("name").getValue().toString();
                String text2=snapshot.child("institutionName").getValue().toString();
                String text3=snapshot.child("className").getValue().toString();
                String text4=snapshot.child("section").getValue().toString();
                String text5=snapshot.child("roll").getValue().toString();
                String text6=snapshot.child("email").getValue().toString();
                String text7=snapshot.child("mobileNumber").getValue().toString();
                String text8=snapshot.child("classTeacherName").getValue().toString();
                String text9=snapshot.child("classTeacherMobile").getValue().toString();
                String text10=snapshot.child("classTeacherEmail").getValue().toString();
                String text11=snapshot.child("gurdianName").getValue().toString();
                String text12=snapshot.child("gurdianRelation").getValue().toString();
                String text13=snapshot.child("gurdianEmail").getValue().toString();
                String text14=snapshot.child("dateOfBirth").getValue().toString();

                // Toast.makeText(getApplicationContext(),name+"\n"+ins,Toast.LENGTH_LONG).show();

                textViewName.setText("Name :"+text1);
                textViewIns.setText("Institution Name :"+text2);
                textViewClass.setText("Class : "+text3);
                textViewSection.setText("Section : "+text4);
                textViewRoll.setText("Roll : "+text5);
                textViewEmail.setText("Email Address : "+text6);
                textViewMobile.setText("Mobile Number : "+text7);
                textViewClassTeacher.setText("Class Teacher Name : "+text8);
                textViewClassTeacherPhone.setText("Class Teacher Mobiler Number : "+text9);
                textViewClassTeacherEmail.setText("Class Teacher Mobiler Number : "+text10);
                textViewGurdian.setText("Guardian Name : "+text11);
                textViewReal.setText("Relationship with Gurdian : "+text12);
                textViewGurdianEmail.setText("Guardian Email Address : "+text13);
                textViewdob.setText("Date Of Birth : "+text14);

            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });




    }
}