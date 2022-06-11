package com.dhruvil.pixcel_effect.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.dhruvil.pixcel_effect.Adapter.AdapterFilter;
import com.dhruvil.pixcel_effect.Effects;
import com.dhruvil.pixcel_effect.Multitouch.MultiTouchListener;
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

public class Activity_imageEdit extends AppCompatActivity {

    public static ImageView croped_image, front_img;
    ImageView back;
    RecyclerView menu_3d, menu_effect, menu_filter;
    LinearLayout icon_3d, icon_effect, color_pick, line_3d,icon_filter;

    int check = 0;

    List<Integer> model3D = new ArrayList<>();
    List<Integer> modelEffect = new ArrayList<>();

    public static void setFilter(int position) {

        switch (position) {

            case 0:
                Effects.applyEffectNone(croped_image);
                break;
            case 1:
                Effects.applyEffect1(croped_image);
                break;
            case 2:
                Effects.applyEffect2(croped_image);
                break;
            case 3:
                Effects.applyEffect3(croped_image);
                break;
            case 4:
                Effects.applyEffect4(croped_image);
                break;
            case 5:
                Effects.applyEffect5(croped_image);
                break;
            case 6:
                Effects.applyEffect6(croped_image);
                break;
            case 7:
                Effects.applyEffect7(croped_image);
                break;
            case 8:
                Effects.applyEffect8(croped_image);
                break;
            case 9:
                Effects.applyEffect9(croped_image);
                break;
            case 10:
                Effects.applyEffect10(croped_image);
                break;
            case 11:
                Effects.applyEffect11(croped_image);
                break;
            case 12:
                Effects.applyEffect12(croped_image);
                break;
            case 13:
                Effects.applyEffect13(croped_image);
                break;
            case 14:
                Effects.applyEffect14(croped_image);
                break;
            case 15:
                Effects.applyEffect15(croped_image);
                break;
            case 16:
                Effects.applyEffect16(croped_image);
                break;
            case 17:
                Effects.applyEffect17(croped_image);
                break;
            case 18:
                Effects.applyEffect18(croped_image);
                break;
            case 19:
                Effects.applyEffect19(croped_image);
                break;
            case 20:
                Effects.applyEffect20(croped_image);
                break;
            case 21:
                Effects.applyEffect21(croped_image);
                break;
            case 22:
                Effects.applyEffect22(croped_image);
                break;

        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_edit);

        Binding();

        croped_image.setImageBitmap(Activity_crop.bitmap);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_imageEdit.this, Activity_home.class));
            }
        });

        for (int i = 0; i < utils.icon.length; i++) {

            model3D.add(utils.icon[i]);

        }

        RecyclerView.LayoutManager manager = new LinearLayoutManager(Activity_imageEdit.this, LinearLayoutManager.HORIZONTAL, false);
        Adapter3D adapter3D = new Adapter3D(Activity_imageEdit.this, model3D);
        menu_3d.setAdapter(adapter3D);
        menu_3d.setVisibility(View.GONE);
        menu_3d.setLayoutManager(manager);

        icon_3d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (check == 0) {
                    menu_3d.setVisibility(View.VISIBLE);
                    menu_effect.setVisibility(View.GONE);
                    menu_filter.setVisibility(View.GONE);

//                    Animation animation = AnimationUtils.loadAnimation(activity_imageEdit.this,R.anim.up);
//                    line_3d.startAnimation(animation);

                    check = 1;
                } else if (check == 1) {
                    menu_3d.setVisibility(View.GONE);
                    menu_effect.setVisibility(View.GONE);
                    menu_filter.setVisibility(View.GONE);
                    check = 0;
                }

            }
        });

        for (int i = 0; i < utils.icon_effect.length; i++) {

            modelEffect.add(utils.icon_effect[i]);

        }

        RecyclerView.LayoutManager manager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        AdapterEffect adapterEffect = new AdapterEffect(this, modelEffect);
        menu_effect.setAdapter(adapterEffect);
        menu_effect.setVisibility(View.GONE);
        menu_effect.setLayoutManager(manager1);

        icon_effect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                check = 0;

                if (check == 0) {
                    menu_effect.setVisibility(View.VISIBLE);
                    menu_3d.setVisibility(View.GONE);
                    menu_filter.setVisibility(View.GONE);
                    check = 1;
                } else if (check == 1) {
                    menu_effect.setVisibility(View.GONE);
                    menu_3d.setVisibility(View.GONE);
                    menu_filter.setVisibility(View.GONE);
                    check = 0;
                }

            }
        });

        color_pick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                                front_img.setColorFilter(selectedColor);
                                front_img.setImageAlpha(100);
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
        });

        RecyclerView.LayoutManager manager2 = new LinearLayoutManager(Activity_imageEdit.this, LinearLayoutManager.HORIZONTAL, false);
        AdapterFilter adapterFilter = new AdapterFilter(Activity_imageEdit.this);
        menu_filter.setLayoutManager(manager2);
        menu_filter.setVisibility(View.GONE);
        menu_filter.setAdapter(adapterFilter);

        check = 0;

        icon_filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if (check == 0) {
                    menu_effect.setVisibility(View.GONE);
                    menu_3d.setVisibility(View.GONE);
                    menu_filter.setVisibility(View.VISIBLE);
                    check = 1;
                } else if (check == 1) {
                    menu_effect.setVisibility(View.GONE);
                    menu_3d.setVisibility(View.GONE);
                    menu_filter.setVisibility(View.GONE);
                    check = 0;
                }

            }
        });

        croped_image.setOnTouchListener(new MultiTouchListener());

    }

    @SuppressLint( "WrongViewCast" )
    private void Binding() {
        croped_image = findViewById(R.id.croped_image);
        back = findViewById(R.id.back);
        front_img = findViewById(R.id.front_img);
        menu_3d = findViewById(R.id.menu_3d);
        icon_3d = findViewById(R.id.icon);
        menu_effect = findViewById(R.id.menu_effect);
        icon_effect = findViewById(R.id.icon_effect);
        menu_filter = findViewById(R.id.menu_filter);
        color_pick = findViewById(R.id.color_pick);
        icon_filter = findViewById(R.id.icon_filter);
//        line_3d = findViewById(R.id.line_3d);
    }
}