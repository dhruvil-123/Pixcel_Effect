package com.dhruvil.pixcel_effect.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.ColorFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.dhruvil.pixcel_effect.R;

import java.util.ArrayList;
import java.util.List;

import com.dhruvil.pixcel_effect.Adapter.Adapter3D;
import com.dhruvil.pixcel_effect.Adapter.AdapterEffect;
import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorSelectedListener;
import com.flask.colorpicker.builder.ColorPickerClickListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;

import Utils.utils;

public class activity_imageEdit extends AppCompatActivity {

    public static ImageView croped_image,front_img;
    ImageView back;
    RecyclerView menu_3d,menu_effect;
    LinearLayout icon_3d,icon_effect,color_pick;

    List<Integer> model3D = new ArrayList<>();
    List<Integer> modelEffect = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_edit);

        Binding();

        color_pick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ColorPickerDialogBuilder
                        .with(activity_imageEdit.this)
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
                                back.setColorFilter(selectedColor);
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

        croped_image.setImageBitmap(Activity_crop.bitmap);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(activity_imageEdit.this,activity_home.class));
            }
        });

        icon_3d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                menu_3d.setVisibility(View.VISIBLE);

            }
        });

        icon_effect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                menu_effect.setVisibility(View.VISIBLE);

            }
        });

        for (int i = 0; i < utils.icon.length; i++) {

            model3D.add(utils.icon[i]);

        }

        for (int i = 0; i < utils.icon_effect.length; i++) {

            modelEffect.add(utils.icon_effect[i]);

        }

        RecyclerView.LayoutManager manager = new LinearLayoutManager(activity_imageEdit.this,LinearLayoutManager.HORIZONTAL,false);
        Adapter3D adapter3D = new Adapter3D(activity_imageEdit.this,model3D);
        menu_3d.setAdapter(adapter3D);
        menu_3d.setVisibility(View.GONE);
        menu_3d.setLayoutManager(manager);

        RecyclerView.LayoutManager manager1 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        AdapterEffect adapterEffect = new AdapterEffect(this,modelEffect);
        menu_effect.setAdapter(adapterEffect);
        menu_effect.setVisibility(View.GONE);
        menu_effect.setLayoutManager(manager1);

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
        color_pick = findViewById(R.id.color_pick);
    }
}