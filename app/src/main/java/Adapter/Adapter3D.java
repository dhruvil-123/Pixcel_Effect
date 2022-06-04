package Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dhruvil.pixcel_effect.R;

import java.util.List;

import Activity.activity_imageEdit;

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
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        holder.icon.setImageResource(model3D.get(position));

    }

    @Override
    public int getItemCount() {
        return model3D.size();
    }

    class Holder extends RecyclerView.ViewHolder {

        ImageView icon;

        public Holder(@NonNull View itemView) {
            super(itemView);

            icon = itemView.findViewById(R.id.icon);

        }
    }

}
