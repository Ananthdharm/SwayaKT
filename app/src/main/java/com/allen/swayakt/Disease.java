package com.allen.swayakt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Disease extends AppCompatActivity {
    Button button1,button2;
    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9,tv10,tv11,tv12,tv13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease);
        button1=findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Disease.this,MainPage1.class);
                startActivity(intent);
            }
        });
        button2=findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Disease.this,PredictActivity.class);
                startActivity(intent);
            }
        });
    }
    public void peb (View view) {
        Intent intent=new Intent(Disease.this,Info.class);
        intent.putExtra("message", "Potato__Early_blight");
        startActivity(intent);
    }
    public void ph (View view) {
        Intent intent=new Intent(Disease.this,Info.class);
        intent.putExtra("message", "Potato__healthy");
        startActivity(intent);
    }
    public void plb (View view) {
        Intent intent=new Intent(Disease.this,Info.class);
        intent.putExtra("message", "Potato__Late_blight");
        startActivity(intent);
    }
    public void tylcv (View view) {
        Intent intent=new Intent(Disease.this,Info.class);
        intent.putExtra("message", "Tomato_Tomato_YellowLeaf_Curl_Virus");
        startActivity(intent);
    }
    public void tts (View view) {
        Intent intent=new Intent(Disease.this,Info.class);
        intent.putExtra("message", "Tomato_Target_Spot");
        startActivity(intent);
    }
    public void tmv (View view) {
        Intent intent=new Intent(Disease.this,Info.class);
        intent.putExtra("message", "Tomato_Tomato_mosaic_virus");
        startActivity(intent);
    }
    public void tbs (View view) {
        Intent intent=new Intent(Disease.this,Info.class);
        intent.putExtra("message", "Tomato_Bacterial_spot");
        startActivity(intent);
    }
    public void teb (View view) {
        Intent intent=new Intent(Disease.this,Info.class);
        intent.putExtra("message", "Tomato_Early_blight");
        startActivity(intent);
    }
    public void thy (View view) {
        Intent intent=new Intent(Disease.this,Info.class);
        intent.putExtra("message", "Tomato_healthy");
        startActivity(intent);
    }
    public void tlb (View view) {
        Intent intent=new Intent(Disease.this,Info.class);
        intent.putExtra("message", "Tomato_Late_blight");
        startActivity(intent);
    }
    public void tlm (View view) {
        Intent intent=new Intent(Disease.this,Info.class);
        intent.putExtra("message", "Tomato_Leaf_Mold");
        startActivity(intent);
    }
    public void tsm (View view) {
        Intent intent=new Intent(Disease.this,Info.class);
        intent.putExtra("message", "Tomato_Spider_mites_Two_spotted_spider_mite");
        startActivity(intent);
    }
    public void tsl (View view) {
        Intent intent=new Intent(Disease.this,Info.class);
        intent.putExtra("message", "Tomato_Septoria_leaf_spot");
        startActivity(intent);
    }
}