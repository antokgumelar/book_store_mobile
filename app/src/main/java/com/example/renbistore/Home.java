package com.example.renbistore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // button View Book
        Button btnVMantappu = (Button) findViewById(R.id.btnVMantappu);
        btnVMantappu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Mantappu.class);
                startActivity(i);

            }
        });

        Button btnVQuarter = (Button) findViewById(R.id.btnVQuarter);
        btnVQuarter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Quarter.class);
                startActivity(i);
            }
        });

        Button btnVYouDo = (Button) findViewById(R.id.btnVYouDo);
        btnVYouDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), YouDo.class);
                startActivity(i);
            }
        });

        Button btnVFilosofi = (Button) findViewById(R.id.btnVFilosofi);
        btnVFilosofi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Filosofi.class);
                startActivity(i);
            }
        });

        // Navbar
        Button btnBook = (Button) findViewById(R.id.btnBook);
        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Book.class);
                startActivity(i);
            }
        });

        Button btnStore = (Button) findViewById(R.id.btnStore);
        btnStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Store.class);
                startActivity(i);
            }
        });

        Button btnProfile = (Button) findViewById(R.id.btnProfil);
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Profile.class);
                startActivity(i);
            }
        });
    }
}