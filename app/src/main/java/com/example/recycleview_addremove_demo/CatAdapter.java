package com.example.recycleview_addremove_demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.ViewHolder> {
    List<Cat> cats;
    Context context;
    public CatAdapter(List<Cat> cats, Context context) {
        this.cats = cats;
        this.context = context;
    }

    @NonNull
    @Override
    public CatAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatAdapter.ViewHolder holder, int position) {
        Glide.with(context)
                .load(cats.get(position).getImg())
                .centerCrop()
                .into(holder.ava);
        holder.name.setText(cats.get(position).getName());
        holder.cost.setText(cats.get(position).getCost());
        holder.removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cats.remove(cats.get(position));
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return cats.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ava;
        TextView name, cost;
        Button removeBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ava = itemView.findViewById(R.id.imgView);
            name = itemView.findViewById(R.id.textView5);
            cost = itemView.findViewById(R.id.textView6);
            removeBtn = itemView.findViewById(R.id.button2);
        }
    }
}
