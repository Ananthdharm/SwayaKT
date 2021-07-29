package com.allen.swayakt;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.allen.swayakt.ml.Output;
import com.android.volley.RequestQueue;

import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.image.TensorImage;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

import java.io.IOException;
import java.nio.ByteBuffer;

public class PredictActivity extends AppCompatActivity {

    // One Button
    private TextView result;
    private RequestQueue mQueue;
    Button BSelectImage,PredictImage,info,b1;
    TextView Label;
    // One Preview Image
    ImageView IVPreviewImage;

    String diseaseType;

//    Bundle bundle = new Bundle();

    Bitmap img;
    // constant to compare
    // the activity result code
    int SELECT_PICTURE = 200;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_predict);

        // register the UI widgets with their appropriate IDs
        BSelectImage = findViewById(R.id.BSelectImage);
        IVPreviewImage = findViewById(R.id.IVPreviewImage);
        PredictImage = findViewById(R.id.PredictImage);
        info = findViewById(R.id.Information);
        Label = findViewById(R.id.Label);
        b1=findViewById(R.id.back1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(PredictActivity.this,MainPage1.class);
                startActivity(intent);
            }
        });
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(PredictActivity.this,Info.class);
                intent.putExtra("message", diseaseType);
//                intent.putExtra("data",bundle);
                startActivity(intent);
            }
        });
        //result=findViewById(R.id.)

        BSelectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, 100);
            }
        });
        PredictImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                img = Bitmap.createScaledBitmap(img, 256, 256, true);

                try {
                    Output model = Output.newInstance(getApplicationContext());

                    // Creates inputs for reference.
                    TensorBuffer inputFeature0 = TensorBuffer.createFixedSize(new int[]{1, 256, 256, 3}, DataType.FLOAT32);

                    TensorImage tensorImage = new TensorImage(DataType.FLOAT32);
                    tensorImage.load(img);
                    ByteBuffer byteBuffer = tensorImage.getBuffer();

                    inputFeature0.loadBuffer(byteBuffer);

                    // Runs model inference and gets result.
                    Output.Outputs outputs = model.process(inputFeature0);
                    TensorBuffer outputFeature0 = outputs.getOutputFeature0AsTensorBuffer();

                    // Releases model resources if no longer used.
                    model.close();

                    if(outputFeature0.getFloatArray()[0] == 1.0){Label.setText("Potato -- Early-blight");diseaseType="Potato__Early_blight";}
                    else if(outputFeature0.getFloatArray()[1] == 1.0){Label.setText("Potato -- Late-blight");diseaseType="Potato__Late_blight";}
                    else if(outputFeature0.getFloatArray()[2] == 1.0){Label.setText("Potato -- healthy");diseaseType="Potato__healthy";}
                    else if(outputFeature0.getFloatArray()[3] == 1.0){Label.setText("Tomato -- Bacterial-spot");diseaseType="Tomato_Bacterial_spot";}
                    else if(outputFeature0.getFloatArray()[4] == 1.0){Label.setText("Tomato -- Early-blight");diseaseType="Tomato_Early_blight";}
                    else if(outputFeature0.getFloatArray()[5] == 1.0){Label.setText("Tomato -- Late-blight");diseaseType="Tomato_Late_blight";}
                    else if(outputFeature0.getFloatArray()[6] == 1.0){Label.setText("Tomato -- Leaf-Mold");diseaseType="Tomato_Leaf_Mold";}
                    else if(outputFeature0.getFloatArray()[7] == 1.0){Label.setText("Tomato -- Septoria-leaf-spot");diseaseType="Tomato_Septoria_leaf_spot";}
                    else if(outputFeature0.getFloatArray()[8] == 1.0){Label.setText("Tomato -- Spider-mites Two-spotted-spider-mite");diseaseType="Tomato_Spider_mites_Two_spotted_spider_mite";}
                    else if(outputFeature0.getFloatArray()[9] == 1.0){Label.setText("Tomato -- Target-Spot");diseaseType="Tomato_Target_Spot";}
                    else if(outputFeature0.getFloatArray()[10] == 1.0){Label.setText("Tomato -- Tomato-mosaic-virus");diseaseType="Tomato_Tomato_mosaic_virus";}
                    else if(outputFeature0.getFloatArray()[11] == 1.0){Label.setText("Tomato --healthy");diseaseType="Tomato_healthy";}

//                    bundle.putString("diseaseType",diseaseType);


                } catch (IOException e) {
                    // TODO Handle the exception
                }

            }
        });
    }

    // this function is triggered when
    // the Select Image Button is clicked

    // this function is triggered when user
    // selects the image from the imageChooser

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 100)
        {
            IVPreviewImage.setImageURI(data.getData());

            Uri uri = data.getData();
            try {
                img = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}



















