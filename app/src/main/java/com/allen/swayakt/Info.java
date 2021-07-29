package com.allen.swayakt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Info extends AppCompatActivity {

    private TextView disc;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        disc = findViewById(R.id.diseasename);
        disc.setMovementMethod(new ScrollingMovementMethod());

        Intent i = getIntent();
        String diseaseType = i.getStringExtra("message");

        b1=findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Info.this,PredictActivity.class);
                startActivity(intent);
            }
        });
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://svayakt-diseaseapi.herokuapp.com/"+diseaseType+"/";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
//                        disc.setText(response.replaceAll("\\\n", System.getProperty("line.separator")));
                        if (diseaseType.equals("Potato__healthy") || diseaseType.equals("Tomato_healthy")) {
                            try {;
                                JSONObject jObject = new JSONObject(response);
                                String theDisease = jObject.getString("diseaseName");
                                String description = jObject.getString("description");
                                String sourceString = "<b>Disease Name:</b> ";
                                disc.setText(Html.fromHtml(sourceString));
                                disc.append("\n"+theDisease+"\n\n");
                                sourceString = "<b>Description:</b> ";
                                disc.append(Html.fromHtml(sourceString));
                                disc.append("\n"+description+"\n\n");
                            } catch (JSONException e) {
                                disc.setText("(ﾉ≧ڡ≦) oopsy doopsy pants poopsy");
                            }
                        }
                        else {
                            try {
                                disc.setClickable(true);
                                disc.setMovementMethod(LinkMovementMethod.getInstance());
                                JSONObject jObject = new JSONObject(response);
                                String theDisease = jObject.getString("diseaseName");
                                String description = jObject.getString("description");
                                String moreDetails = jObject.getString("moreDetails");
                                String prevention = jObject.getString("prevention");
                                String readMore = jObject.getString("readMore");
                                String sourceString = "<b>Disease Name:</b> ";
                                disc.setText(Html.fromHtml(sourceString));
                                disc.append("\n"+theDisease+"\n\n");
                                sourceString = "<b>Description:</b> ";
                                disc.append(Html.fromHtml(sourceString));
                                disc.append("\n"+description+"\n\n");
                                sourceString = "<b>More Details:</b> ";
                                disc.append(Html.fromHtml(sourceString));
                                disc.append("\n"+moreDetails+"\n\n");
                                sourceString = "<b>Prevention:</b> ";
                                disc.append(Html.fromHtml(sourceString));
                                disc.append("\n"+prevention+"\n\n");
                                sourceString = "<b>Read More:</b> ";
                                disc.append(Html.fromHtml(sourceString));
                                sourceString = "<br><a>"+readMore+"</a> ";
                                disc.append(Html.fromHtml(sourceString));
                            } catch (JSONException e) {
                                disc.setText("(ﾉ≧ڡ≦) oopsy doopsy pants poopsy");
                            }
                        }

//                        disc.setText("hey\nokay\nokay\nhey");
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                disc.setText("(ﾉ≧ڡ≦) oopsy doopsy pants poopsy");
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}