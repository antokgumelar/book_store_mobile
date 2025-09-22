package com.example.renbistore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Filosofi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filosofi);

        Button btnBFilosofi = (Button) findViewById(R.id.btnBFilosofi);
        btnBFilosofi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Form.class);
                startActivity(i);
            }
        });

        ImageButton imgFilosofi2 = (ImageButton) findViewById(R.id.imgFilosofi2);
        imgFilosofi2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), FilosofiPhoto.class);
                startActivity(i);
            }
        });
    }
}