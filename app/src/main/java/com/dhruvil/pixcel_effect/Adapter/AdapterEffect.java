package com.dhruvil.pixcel_effect.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dhruvil.pixcel_effect.Activity.ActivityCrop;
import com.dhruvil.pixcel_effect.R;

import java.util.List;

import com.dhruvil.pixcel_effect.Activity.Activity_imageEdit;

public class AdapterEffect extends RecyclerView.Adapter<AdapterEffect.EffectHolder>{

    Activity activity;
    List<Integer> modelEffect;

    public AdapterEffect(Activity_imageEdit activity_imageEdit, List<Integer> modelEffect) {

        activity = activity_imageEdit;
        this.modelEffect = modelEffect;

    }

    @NonNull
    @Override
    public EffectHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(activity).inflate(R.layout.menu_3d,parent,false);

        return new EffectHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EffectHolder holder, @SuppressLint( "RecyclerView" ) int position) {

        holder.back_img.setImageBitmap(ActivityCrop.bitmap);
        holder.icon.setImageResource(modelEffect.get(position));

        holder.icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Activity_imageEdit.frontImg.setImageResource(modelEffect.get(position));

            }
        });

    }

    @Override
    public int getItemCount() {
        return modelEffect.size();
    }

    class EffectHolder extends RecyclerView.ViewHolder {

        ImageView icon,back_img;

        public EffectHolder(@NonNull View itemView) {
            super(itemView);

            icon = itemView.findViewById(R.id.icon);
            back_img = itemView.findViewById(R.id.back_img);

        }
    }

}
