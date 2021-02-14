package com.example.adolendo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileActivity extends AppCompatActivity {

    DatabaseReference databaseReference;
    private RadioGroup r_Group1,r_Group2,r_Group3,r_Group4,r_Group5,r_Group6,r_Group7,r_Group8,r_Group9;
    private RadioButton r_button1,r_button2,r_button3,r_button4,r_button5,r_button6,r_button7,r_button8,r_button9;
    private Button send_btn;

   // private static final String TAG=MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        r_Group1=findViewById(R.id.radio_group1);
        r_Group2=findViewById(R.id.radio_group2);
        r_Group3=findViewById(R.id.radio_group3);
        r_Group4=findViewById(R.id.radio_group4);
        r_Group5=findViewById(R.id.radio_group5);
        r_Group6=findViewById(R.id.radio_group6);
        r_Group7=findViewById(R.id.radio_group7);
        r_Group8=findViewById(R.id.radio_group8);
        r_Group9=findViewById(R.id.radio_group9);

        databaseReference= FirebaseDatabase.getInstance().getReference("participants");
        send_btn=findViewById(R.id.show_button);
        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selected_id1=r_Group1.getCheckedRadioButtonId();
                int selected_id2=r_Group2.getCheckedRadioButtonId();
                int selected_id3=r_Group3.getCheckedRadioButtonId();
                int selected_id4=r_Group4.getCheckedRadioButtonId();
                int selected_id5=r_Group5.getCheckedRadioButtonId();
                int selected_id6=r_Group6.getCheckedRadioButtonId();
                int selected_id7=r_Group7.getCheckedRadioButtonId();
                int selected_id8=r_Group8.getCheckedRadioButtonId();
                int selected_id9=r_Group9.getCheckedRadioButtonId();

                r_button1=(RadioButton)findViewById(selected_id1);
                String ans1=r_button1.getText().toString().trim();

                r_button2=(RadioButton)findViewById(selected_id2);
                String ans2=r_button2.getText().toString().trim();

                r_button3=(RadioButton)findViewById(selected_id3);
                String ans3=r_button3.getText().toString().trim();

                r_button4=(RadioButton)findViewById(selected_id4);
                String ans4=r_button4.getText().toString().trim();

                r_button5=(RadioButton)findViewById(selected_id5);
                String ans5=r_button5.getText().toString().trim();

                r_button6=(RadioButton)findViewById(selected_id6);
                String ans6=r_button6.getText().toString().trim();

                r_button7=(RadioButton)findViewById(selected_id7);
                String ans7=r_button7.getText().toString().trim();

                r_button8=(RadioButton)findViewById(selected_id8);
                String ans8=r_button8.getText().toString().trim();

                r_button9=(RadioButton)findViewById(selected_id9);
                String ans9=r_button9.getText().toString().trim();

                //---------------------------Algo start ----------------------//
                String result;
                if(ans1.equals("Yes") || ans2.equals("Yes")){
                    if(ans3.equals("Yes")|| ans4.equals("Yes") || ans5.equals("Yes") || ans6.equals("Yes")){
                        result="Most porbably Endometriosis";
                    }
                    else{
                        if(ans7.equals("Yes") || ans8.equals("Yes") || ans9.equals("Yes")){
                            result="High Risk Of Endometriosis ";
                        }
                        else{
                            result="Low Risk Of Endometriosis ";
                        }

                    }

                }
                else{
                    result="No Risk Of Endometriosis";
                }
                Participant participants=new Participant(ans1,ans2,ans3,ans4,ans5,ans6,ans7,ans8,ans9,result);
                databaseReference.child(DemoClass.message).setValue(participants);
                Toast.makeText(getApplicationContext(),"Participants info is recorded",Toast.LENGTH_LONG).show();

                //Toast.makeText(getApplicationContext(),ans1,Toast.LENGTH_LONG).show();
                //Log.d(TAG,"Click: "+ans1);
            }
        });

    }
}