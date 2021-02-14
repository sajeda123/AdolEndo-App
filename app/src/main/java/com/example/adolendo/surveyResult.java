package com.example.adolendo;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class surveyResult extends AppCompatActivity {

    private TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,trs;

    FirebaseAuth auth;
    FirebaseUser user;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey_result);

        ActionBar actionBar=getSupportActionBar();
        ((ActionBar) actionBar).setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        setTitle("Survey Result");

        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();

        t1=findViewById(R.id.ques1);
        t2=findViewById(R.id.ques2);
        t3=findViewById(R.id.ques3);
        t4=findViewById(R.id.ques4);
        t5=findViewById(R.id.ques5);
        t6=findViewById(R.id.ques6);
        t7=findViewById(R.id.ques7);
        t8=findViewById(R.id.ques8);
        t9=findViewById(R.id.ques9);
        trs=findViewById(R.id.surveyResult);

        databaseReference= FirebaseDatabase.getInstance().getReference().child("participants").child( DemoClass.message);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                if(!snapshot.child(DemoClass.message).exists()) {

                    t1.setText("??");
                    t2.setText("??");
                    t3.setText("??");
                    t4.setText("??");
                    t5.setText("??");
                    t6.setText("??");
                    t7.setText("??");
                    t8.setText("??");
                    t9.setText("??");
                    trs.setText("??");
                   // Toast.makeText(getApplicationContext(),"Please Fill Up Survey Question",Toast.LENGTH_LONG).show();
                    Toast toast= Toast.makeText(getApplicationContext(),"Please Fill Up Survey Question",Toast.LENGTH_LONG);
                    View view=toast.getView();
                    TextView  view1=(TextView)view.findViewById(android.R.id.message);
                    view1.setTextColor(Color.RED);
                    view1.setBackgroundResource(R.color.black);
                    toast.show();
                }
                else{
                    String text1 = snapshot.child("question_1").getValue().toString();
                    String text2 = snapshot.child("question_2").getValue().toString();
                    String text3 = snapshot.child("question_3").getValue().toString();
                    String text4 = snapshot.child("question_4").getValue().toString();
                    String text5 = snapshot.child("question_5").getValue().toString();
                    String text6 = snapshot.child("question_6").getValue().toString();
                    String text7 = snapshot.child("question_7").getValue().toString();
                    String text8 = snapshot.child("question_8").getValue().toString();
                    String text9 = snapshot.child("question_9").getValue().toString();
                    String textrs = snapshot.child("result").getValue().toString();

                    t1.setText(text1);
                    t2.setText(text2);
                    t3.setText(text3);
                    t4.setText(text4);
                    t5.setText(text5);
                    t6.setText(text6);
                    t7.setText(text7);
                    t8.setText(text8);
                    t9.setText(text9);
                    trs.setText(textrs);

                }
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });






    }
}