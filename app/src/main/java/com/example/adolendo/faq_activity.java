package com.example.adolendo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

public class faq_activity extends AppCompatActivity {
    EditText edit1;
    ImageView img_view1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq_activity);
        edit1=findViewById(R.id.edit1);
        img_view1=findViewById(R.id.img_view1);
    }
}