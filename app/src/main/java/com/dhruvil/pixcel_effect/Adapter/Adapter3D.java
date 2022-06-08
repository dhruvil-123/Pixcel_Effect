package com.dhruvil.pixcel_effect.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dhruvil.pixcel_effect.Activity.Activity_crop;
import com.dhruvil.pixcel_effect.R;

import java.util.List;

import com.dhruvil.pixcel_effect.Activity.activity_imageEdit;

public class Adapter3D extends RecyclerView.Adapter<Adapter3D.Holder>{

    Activity activity;
    List<Integer> model3D;

    public Adapter3D(activity_imageEdit activity_imageEdit, List<Integer> model3D) {

        activity = activity_imageEdit;
        this.model3D = model3D;

    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(activity).inflate(R.layout.menu_3d,parent,false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, @SuppressLint( "RecyclerView" ) int position) {

        holder.back_img.setImageBitmap(Activity_crop.bitmap);
        holder.icon.setImageResource(model3D.get(position));

        holder.icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                activity_imageEdit.front_img.setImageResource(model3D.get(position));

            }
        });

    }

    @Override
    public int getItemCount() {
        return model3D.size();
    }

    class Holder extends RecyclerView.ViewHolder {

        ImageView icon;
        ImageView back_img;

        public Holder(@NonNull View itemView) {
            super(itemView);

            icon = itemView.findViewById(R.id.icon);
            back_img = itemView.findViewById(R.id.back_img);


        }
    }

}
