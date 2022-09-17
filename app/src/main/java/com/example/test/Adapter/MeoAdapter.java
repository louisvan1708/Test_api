package com.example.test.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.test.MainActivity;
import com.example.test.Model.ModelApi;
import com.example.test.R;

import java.util.List;

public class MeoAdapter extends RecyclerView.Adapter<MeoAdapter.MeoViewHolder> {

    private List<ModelApi> data;
    private com.example.test.itemClick itemClick;
    MainActivity context;

    public MeoAdapter(com.example.test.itemClick itemClick) {
        this.itemClick = itemClick;
    }

    public MeoAdapter(List<ModelApi> data, MainActivity context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public MeoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_meo, parent,false);
        return new MeoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MeoViewHolder holder, int position) {
        ModelApi modelApi = data.get(position);
        Glide.with(context).load(modelApi.getUrl()).centerCrop().into(holder.imageView);
        String id = modelApi.getId();
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.DetailsMeo(id);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class MeoViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;

        public MeoViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imgMeo);
        }
    }
}
