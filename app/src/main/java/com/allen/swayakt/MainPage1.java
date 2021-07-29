package com.allen.swayakt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainPage1 extends AppCompatActivity {
    private Button m1,m2,m3,m4,exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page1);
        m1=findViewById(R.id.button1);
        m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainPage1.this,About.class);
                startActivity(intent);
            }
        });
        m2=findViewById(R.id.button2);
        m2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainPage1.this,Mainpage.class);
                startActivity(intent);
            }
        });
        m3=findViewById(R.id.button3);
        m3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainPage1.this,PredictActivity.class);
                startActivity(intent);
            }
        });
        m4=findViewById(R.id.button4);
        m4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainPage1.this,Disease.class);
                startActivity(intent);
            }
        });
       exit=findViewById(R.id.button5);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });
    }
}