package com.dhruvil.pixcel_effect.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.dhruvil.pixcel_effect.Adapter.AdapterFilter;
import com.dhruvil.pixcel_effect.Adapter.AdapterGlare;
import com.dhruvil.pixcel_effect.Effects;
import com.dhruvil.pixcel_effect.R;

import java.util.ArrayList;
import java.util.List;

import com.dhruvil.pixcel_effect.Adapter.Adapter3D;
import com.dhruvil.pixcel_effect.Adapter.AdapterEffect;
import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorSelectedListener;
import com.flask.colorpicker.builder.ColorPickerClickListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;

import com.dhruvil.pixcel_effect.Utils.utils;
import com.jsibbold.zoomage.ZoomageView;

public class Activity_imageEdit extends AppCompatActivity {

    public static ImageView frontImg;
    public static ZoomageView cropedImage;
    ImageView back;
    RecyclerView menu3D, menuEffect, menuFilter, menuGlare;
    LinearLayout icon3D, iconEffect, colorPick, line3D, iconFilter, iconRotate, iconFlip,lineEffect,lineGlare,lineFilter,iconSticker,iconGlare;

    int check = 0, check2 = 0, check3 = 0,check4 = 0, rotate = 0, flip = 0;

    List<Integer> model3D = new ArrayList<>();
    List<Integer> modelEffect = new ArrayList<>();
    List<Integer> modelGlares = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_edit);

        Binding();

        cropedImage.setImageBitmap(ActivityCrop.bitmap);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_imageEdit.this, Activity_home.class));
            }
        });

        icon3D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (check == 0) {
                    menu3D.setVisibility(View.VISIBLE);
                    menuEffect.setVisibility(View.GONE);
                    menuFilter.setVisibility(View.GONE);
                    menuGlare.setVisibility(View.GONE);

                    Animation animation = AnimationUtils.loadAnimation(Activity_imageEdit.this,R.anim.up);
                    line3D.startAnimation(animation);

                    check = 1;
                } else if (check == 1) {
                    menu3D.setVisibility(View.GONE);
                    menuEffect.setVisibility(View.GONE);
                    menuFilter.setVisibility(View.GONE);
                    menuGlare.setVisibility(View.GONE);
                    check = 0;
                }

            }
        });

        iconEffect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (check2 == 0) {
                    menuEffect.setVisibility(View.VISIBLE);
                    menu3D.setVisibility(View.GONE);
                    menuFilter.setVisibility(View.GONE);
                    menuGlare.setVisibility(View.GONE);

                    Animation animation = AnimationUtils.loadAnimation(Activity_imageEdit.this,R.anim.up);
                    lineEffect.startAnimation(animation);

                    check2 = 1;
                } else if (check2 == 1) {
                    menuEffect.setVisibility(View.GONE);
                    menu3D.setVisibility(View.GONE);
                    menuFilter.setVisibility(View.GONE);
                    menuGlare.setVisibility(View.GONE);
                    check2 = 0;
                }

            }
        });

        colorPick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                colorPicker();
            }
        });

        iconGlare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(check4 == 0){
                    menuGlare.setVisibility(View.VISIBLE);
                    menu3D.setVisibility(View.GONE);
                    menuEffect.setVisibility(View.GONE);
                    menuFilter.setVisibility(View.GONE);

                    Animation animation = AnimationUtils.loadAnimation(Activity_imageEdit.this,R.anim.up);
                    lineGlare.startAnimation(animation);

                    check4 = 1;
                }else{
                    menuGlare.setVisibility(View.GONE);
                    menu3D.setVisibility(View.GONE);
                    menuEffect.setVisibility(View.GONE);
                    menuFilter.setVisibility(View.GONE);
                    check4 = 0;
                }

            }
        });

        iconFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (check3 == 0) {
                    menuEffect.setVisibility(View.GONE);
                    menu3D.setVisibility(View.GONE);
                    menuFilter.setVisibility(View.VISIBLE);
                    menuGlare.setVisibility(View.GONE);

                    Animation animation = AnimationUtils.loadAnimation(Activity_imageEdit.this,R.anim.up);
                    lineFilter.startAnimation(animation);

                    check3 = 1;
                } else if (check3 == 1) {
                    menuEffect.setVisibility(View.GONE);
                    menu3D.setVisibility(View.GONE);
                    menuFilter.setVisibility(View.GONE);
                    menuGlare.setVisibility(View.GONE);
                    check3 = 0;
                }

            }
        });

        iconRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (rotate == 0) {
                    cropedImage.setRotation(90);
                    rotate = 1;
                } else if (rotate == 1) {
                    cropedImage.setRotation(180);
                    rotate = 2;
                } else if (rotate == 2) {
                    cropedImage.setRotation(270);
                    rotate = 3;
                } else if (rotate == 3) {
                    cropedImage.setRotation(360);
                    rotate = 0;
                }

            }
        });

        iconFlip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (flip == 0) {
                    cropedImage.setRotationY(180);
                    flip = 1;
                } else {
                    cropedImage.setRotationY(0);
                    flip = 0;
                }

            }
        });


    }

    @SuppressLint( "WrongViewCast" )
    private void Binding() {
        cropedImage = findViewById(R.id.croped_image);
        back = findViewById(R.id.back);
        frontImg = findViewById(R.id.front_img);
        menu3D = findViewById(R.id.menu_3d);
        icon3D = findViewById(R.id.icon);
        menuEffect = findViewById(R.id.menu_effect);
        iconEffect = findViewById(R.id.icon_effect);
        menuFilter = findViewById(R.id.menuFilter);
        menuGlare = findViewById(R.id.menuGlare);
        colorPick = findViewById(R.id.color_pick);
        iconFilter = findViewById(R.id.icon_filter);
        line3D = findViewById(R.id.line_3d);
        iconRotate = findViewById(R.id.icon_rotate);
        iconFlip = findViewById(R.id.icon_flip);
        lineEffect = findViewById(R.id.lineEffect);
        lineGlare = findViewById(R.id.lineGlare);
        lineFilter = findViewById(R.id.lineFilter);
        iconSticker = findViewById(R.id.iconSticker);
        iconGlare = findViewById(R.id.iconGlare);
    }

    public static void setFilter(int position) {

        switch (position) {

            case 0:
                Effects.applyEffectNone(cropedImage);
                break;
            case 1:
                Effects.applyEffect1(cropedImage);
                break;
            case 2:
                Effects.applyEffect2(cropedImage);
                break;
            case 3:
                Effects.applyEffect3(cropedImage);
                break;
            case 4:
                Effects.applyEffect4(cropedImage);
                break;
            case 5:
                Effects.applyEffect5(cropedImage);
                break;
            case 6:
                Effects.applyEffect6(cropedImage);
                break;
            case 7:
                Effects.applyEffect7(cropedImage);
                break;
            case 8:
                Effects.applyEffect8(cropedImage);
                break;
            case 9:
                Effects.applyEffect9(cropedImage);
                break;
            case 10:
                Effects.applyEffect10(cropedImage);
                break;
            case 11:
                Effects.applyEffect11(cropedImage);
                break;
            case 12:
                Effects.applyEffect12(cropedImage);
                break;
            case 13:
                Effects.applyEffect13(cropedImage);
                break;
            case 14:
                Effects.applyEffect14(cropedImage);
                break;
            case 15:
                Effects.applyEffect15(cropedImage);
                break;
            case 16:
                Effects.applyEffect16(cropedImage);
                break;
            case 17:
                Effects.applyEffect17(cropedImage);
                break;
            case 18:
                Effects.applyEffect18(cropedImage);
                break;
            case 19:
                Effects.applyEffect19(cropedImage);
                break;
            case 20:
                Effects.applyEffect20(cropedImage);
                break;
            case 21:
                Effects.applyEffect21(cropedImage);
                break;
            case 22:
                Effects.applyEffect22(cropedImage);
                break;

        }

    }

    private void colorPicker() {
        ColorPickerDialogBuilder
                .with(Activity_imageEdit.this)
                .setTitle("Choose color")
                .wheelType(ColorPickerView.WHEEL_TYPE.FLOWER)
                .density(12)
                .setOnColorSelectedListener(new OnColorSelectedListener() {
                    @Override
                    public void onColorSelected(int selectedColor) {

                    }
                })
                .setPositiveButton("ok", new ColorPickerClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int selectedColor, Integer[] allColors) {
                        frontImg.setColorFilter(selectedColor);
                        frontImg.setImageAlpha(400);
                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .build()
                .show();
    }

    private void RecycleView(){

        RecyclerView.LayoutManager manager = new LinearLayoutManager(Activity_imageEdit.this, LinearLayoutManager.HORIZONTAL, false);
        Adapter3D adapter3D = new Adapter3D(Activity_imageEdit.this, model3D);
        menu3D.setAdapter(adapter3D);
        menu3D.setVisibility(View.GONE);
        menu3D.setLayoutManager(manager);

        RecyclerView.LayoutManager manager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        AdapterEffect adapterEffect = new AdapterEffect(this, modelEffect);
        menuEffect.setAdapter(adapterEffect);
        menuEffect.setVisibility(View.GONE);
        menuEffect.setLayoutManager(manager1);

        RecyclerView.LayoutManager manager2 = new LinearLayoutManager(Activity_imageEdit.this, LinearLayoutManager.HORIZONTAL, false);
        AdapterFilter adapterFilter = new AdapterFilter(Activity_imageEdit.this);
        menuFilter.setLayoutManager(manager2);
        menuFilter.setVisibility(View.GONE);

        RecyclerView.LayoutManager manager3 = new LinearLayoutManager(Activity_imageEdit.this, LinearLayoutManager.HORIZONTAL, false);
        AdapterGlare adapterGlare = new AdapterGlare(Activity_imageEdit.this, modelGlares);
        menuGlare.setLayoutManager(manager3);
        menuGlare.setAdapter(adapterGlare);
        menuGlare.setVisibility(View.GONE);

    }

    private void dataStore(){

        for (int i = 0; i < utils.icon.length; i++) {

            model3D.add(utils.icon[i]);

        }

        for (int i = 0; i < utils.icon_effect.length; i++) {

            modelEffect.add(utils.icon_effect[i]);

        }

        for (int i = 0; i < utils.glare.length; i++) {

            modelGlares.add(utils.glare[i]);

        }

    }
}