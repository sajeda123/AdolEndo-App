package com.example.adolendo;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class Consent_Activity extends AppCompatActivity {
    CheckBox chkyes,chkno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consent_);

        ActionBar actionBar=getSupportActionBar();
        ((ActionBar) actionBar).setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        setTitle("Consent");

        chkyes = (CheckBox)findViewById(R.id.chkYes);
        chkno = (CheckBox)findViewById(R.id.chkNo);

    }
    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        String str="";
        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.chkYes:
               // Toast.makeText(getApplicationContext(),"Checked Yes", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Consent_Activity.this,SignUpActivity.class);
                startActivity(intent);
                break;

            case R.id.chkNo:
                //Toast.makeText(getApplicationContext(),"Checked No", Toast.LENGTH_SHORT).show();
               // System.exit(0);
                finish();
                moveTaskToBack(true);
                break;
        }
    }

}