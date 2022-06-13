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
import com.dhruvil.pixcel_effect.Activity.Activity_imageEdit;
import com.dhruvil.pixcel_effect.Effects;
import com.dhruvil.pixcel_effect.R;

public class AdapterFilter extends RecyclerView.Adapter<AdapterFilter.EffectHolder>{

    Activity activity;

    public AdapterFilter(Activity_imageEdit activity_imageEdit) {
        activity = activity_imageEdit;
    }

    @NonNull
    @Override
    public EffectHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(activity).inflate(R.layout.menu_filter,parent,false);

        return new EffectHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EffectHolder holder, @SuppressLint( "RecyclerView" ) int position) {

        holder.icon_filter.setImageBitmap(ActivityCrop.bitmap);

        switch (position) {

            case 0:
                Effects.applyEffectNone(holder.icon_filter);
                break;
            case 1:
                Effects.applyEffect1(holder.icon_filter);
                break;
            case 2:
                Effects.applyEffect2(holder.icon_filter);
                break;
            case 3:
                Effects.applyEffect3(holder.icon_filter);
                break;
            case 4:
                Effects.applyEffect4(holder.icon_filter);
                break;
            case 5:
                Effects.applyEffect5(holder.icon_filter);
                break;
            case 6:
                Effects.applyEffect6(holder.icon_filter);
                break;
            case 7:
                Effects.applyEffect7(holder.icon_filter);
                break;
            case 8:
                Effects.applyEffect8(holder.icon_filter);
                break;
            case 9:
                Effects.applyEffect9(holder.icon_filter);
                break;
            case 10:
                Effects.applyEffect10(holder.icon_filter);
                break;
            case 11:
                Effects.applyEffect11(holder.icon_filter);
                break;
            case 12:
                Effects.applyEffect12(holder.icon_filter);
                break;
            case 13:
                Effects.applyEffect13(holder.icon_filter);
                break;
            case 14:
                Effects.applyEffect14(holder.icon_filter);
                break;
            case 15:
                Effects.applyEffect15(holder.icon_filter);
                break;
            case 16:
                Effects.applyEffect16(holder.icon_filter);
                break;
            case 17:
                Effects.applyEffect17(holder.icon_filter);
                break;
            case 18:
                Effects.applyEffect18(holder.icon_filter);
                break;
            case 19:
                Effects.applyEffect19(holder.icon_filter);
                break;
            case 20:
                Effects.applyEffect20(holder.icon_filter);
                break;
            case 21:
                Effects.applyEffect21(holder.icon_filter);
                break;
            case 22:
                Effects.applyEffect22(holder.icon_filter);
                break;

        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Activity_imageEdit.setFilter(position);



            }
        });

    }

    @Override
    public int getItemCount() {
        return 23;
    }

    class EffectHolder extends RecyclerView.ViewHolder {

        ImageView icon_filter;

        public EffectHolder(@NonNull View itemView) {
            super(itemView);

            icon_filter = itemView.findViewById(R.id.icon_filter);

        }
    }

}
