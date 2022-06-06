package Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.dhruvil.pixcel_effect.R;

import java.util.ArrayList;
import java.util.List;

import Adapter.Adapter3D;
import Model.model3D;
import Utils.utils;

public class activity_imageEdit extends AppCompatActivity {

    ImageView croped_image;
    ImageView back;
    RecyclerView menu_3d;
    LinearLayout icon_3d;

    List<Integer> model3D = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_edit);

        croped_image = findViewById(R.id.croped_image);
        back = findViewById(R.id.back);
        menu_3d = findViewById(R.id.menu_3d);
        icon_3d = findViewById(R.id.icon_3d);

        croped_image.setImageBitmap(activity_crop.bitmap);

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

        for (int i = 0; i < utils.icon.length; i++) {

            model3D.add(utils.icon[i]);

        }

        RecyclerView.LayoutManager manager = new LinearLayoutManager(activity_imageEdit.this,LinearLayoutManager.HORIZONTAL,false);
        Adapter3D adapter3D = new Adapter3D(activity_imageEdit.this,model3D);
        menu_3d.setAdapter(adapter3D);
        menu_3d.setLayoutManager(manager);

    }
}