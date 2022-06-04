package Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.dhruvil.pixcel_effect.R;

public class activity_home extends AppCompatActivity {

    public static Uri uri;
    ImageView btnmenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnmenu = findViewById(R.id.btnmenu);

        btnmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PopupMenu menu = new PopupMenu(activity_home.this, btnmenu);
                menu.getMenuInflater().inflate(R.menu.home_menu, menu.getMenu());
                menu.show();

                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {

                        switch (menuItem.getItemId()) {

                            case R.id.rateus:
                                Toast.makeText(activity_home.this, "Please Rate Us", Toast.LENGTH_SHORT).show();

                            case R.id.share:
                                Intent intent = new Intent(Intent.ACTION_SEND);
                                intent.setType("text/plain");
                                intent.putExtra(Intent.EXTRA_SUBJECT, "Pixel Effect");
                                String shareMessage = "\nLet me recommend you this Application\n\n";
                                shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=photovideozone.pixeleffect&hl=en" + "\n\n";
                                intent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                                startActivity(Intent.createChooser(intent, "Choose One"));
                        }

                        return false;
                    }
                });

            }
        });

    }


    public void btn_start(View view) {

        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, 1001);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == 1001) {

                uri = data.getData();

                Intent intent1 = new Intent(activity_home.this, activity_crop.class);
                startActivity(intent1);

            }
        }

    }

}