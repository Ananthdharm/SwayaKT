package com.allen.swayakt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class About extends AppCompatActivity {
    private Button m1,m2,m3,m4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        m1=findViewById(R.id.button1);
        m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(About.this,Adarsh.class);
                startActivity(intent);
            }
        });
        m2=findViewById(R.id.button2);
        m2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(About.this,Ananth.class);
                startActivity(intent);
            }
        });
        m3=findViewById(R.id.button3);
        m3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(About.this,Karanupdated.class);
                startActivity(intent);
            }
        });
        m4=findViewById(R.id.button4);
        m4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(About.this,MainPage1.class);
                startActivity(intent);
            }
        });
    }
}