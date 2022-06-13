package com.dhruvil.pixcel_effect.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dhruvil.pixcel_effect.Activity.Activity_imageEdit;
import com.dhruvil.pixcel_effect.R;

import java.util.List;

public class AdapterGlare extends RecyclerView.Adapter<AdapterGlare.GlareHolder>{

    Activity activity;
    List<Integer> modelGlares;

    public AdapterGlare(Activity_imageEdit activity_imageEdit, List<Integer> modelGlares) {

        activity = activity_imageEdit;
        this.modelGlares = modelGlares;

    }


    @NonNull
    @Override
    public GlareHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(activity).inflate(R.layout.menu_filter,parent,false);

        return new GlareHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GlareHolder holder, int position) {

        holder.menu_glare.setImageResource(modelGlares.get(position));

    }

    @Override
    public int getItemCount() {
        return modelGlares.size();
    }

    class GlareHolder extends RecyclerView.ViewHolder {

        ImageView menu_glare;

        public GlareHolder(@NonNull View itemView) {
            super(itemView);

            menu_glare = itemView.findViewById(R.id.icon_filter);

        }
    }

}
