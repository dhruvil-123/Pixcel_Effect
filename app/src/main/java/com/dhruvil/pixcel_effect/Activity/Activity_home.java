package com.dhruvil.pixcel_effect.Activity;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.dhruvil.pixcel_effect.R;

public class Activity_home extends AppCompatActivity {

    public static Uri uri;
    ImageView btnmenu,btn_start;
    String permission[] = {Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnmenu = findViewById(R.id.btnmenu);
        btn_start = findViewById(R.id.btn_start);

        btnmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PopupMenu menu = new PopupMenu(Activity_home.this, btnmenu);
                menu.getMenuInflater().inflate(R.menu.home_menu, menu.getMenu());
                menu.show();

                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {

                        switch (menuItem.getItemId()) {

                            case R.id.rateus:
                                Toast.makeText(Activity_home.this, "Please Rate Us", Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.share:
                                Intent intent = new Intent(Intent.ACTION_SEND);
                                intent.setType("text/plain");
                                intent.putExtra(Intent.EXTRA_SUBJECT, "Pixel Effect");
                                String shareMessage = "\nLet me recommend you this Application\n\n";
                                shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=photovideozone.pixeleffect&hl=en" + "\n\n";
                                intent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                                startActivity(Intent.createChooser(intent, "Choose One"));
                                break;
                        }

                        return false;
                    }
                });

            }
        });

        btn_start.setOnClickListener(new View.OnClickListener() {
            @RequiresApi( api = Build.VERSION_CODES.M )
            @Override
            public void onClick(View view) {

                if(checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){

                    requestPermissions(permission,1001);

                }else{

                    btn_start(view);

                }

            }
        });

    }

    public void btn_start(View view) {

        Intent intent = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(intent, 1001);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == 1001) {

                uri = data.getData();

                Intent intent1 = new Intent(Activity_home.this, Activity_crop.class);
                startActivity(intent1);

            }
        }

    }

}