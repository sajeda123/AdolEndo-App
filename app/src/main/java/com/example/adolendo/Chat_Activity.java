package com.example.adolendo;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Chat_Activity extends AppCompatActivity {
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_);
        ActionBar actionBar=getSupportActionBar();
        ((ActionBar) actionBar).setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        setTitle("Chat");

        btn = findViewById(R.id.send_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Toast.makeText(Chat_Activity.this, "Whatsapp is not installed", Toast.LENGTH_LONG).show();
              /* boolean installed = appInstalledOrNot("com.whatsapp");
                if (installed) {
                   //Intent intent=new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://api.whatsapp.com/send?phone"+"+88"+number+"&text="+text));
                   // startActivity(intent);
                    Intent intentWhatsapp = new Intent(Intent.ACTION_VIEW);
                    String url = "https://chat.whatsapp.com/https://chat.whatsapp.com/EK244j2AIVJ1bvTZRWwK73";
                    intentWhatsapp.setData(Uri.parse(url));
                    intentWhatsapp.setPackage("com.whatsapp");
                    startActivity(intentWhatsapp);
                } else {
                    Toast.makeText(Chat_Activity.this, "Whatsapp is not installed", Toast.LENGTH_LONG).show();
                }
                */
            }
        });
    }

    private boolean appInstalledOrNot(String url) {
        PackageManager packageManager = getPackageManager();
        boolean app_installed;
        try {
            packageManager.getPackageInfo(url, PackageManager.GET_ACTIVITIES);
            app_installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            app_installed = true;
        }
        return app_installed;
    }
}