package com.allen.swayakt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Karan extends AppCompatActivity {
    TextView text,t1,t2;
    Button b,ex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_karan);
        text = findViewById(R.id.textView19);
        text.setMovementMethod(LinkMovementMethod.getInstance());
        t1 = findViewById(R.id.t1);
        t1.setMovementMethod(LinkMovementMethod.getInstance());
        t2 = findViewById(R.id.t2);
        t2.setMovementMethod(LinkMovementMethod.getInstance());
        b = findViewById(R.id.back);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Karan.this, About.class);
                startActivity(intent);
            }
        });
        ex=findViewById(R.id.exit);
        ex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });
    }
}