package com.dhruvil.pixcel_effect.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.canhub.cropper.CropImageView;
import com.dhruvil.pixcel_effect.R;

public class Activity_crop extends AppCompatActivity {

    CropImageView open_img;
    ImageView save;

    public static Bitmap bitmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop);

        open_img = findViewById(R.id.open_img);
        save = findViewById(R.id.save);

        open_img.setImageUriAsync(Activity_home.uri);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bitmap = open_img.getCroppedImage();
                startActivity(new Intent(Activity_crop.this, Activity_imageEdit.class));

            }
        });

    }
}