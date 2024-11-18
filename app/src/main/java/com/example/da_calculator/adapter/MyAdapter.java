package com.example.da_calculator.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.da_calculator.databinding.LayoutItemBinding;
import com.example.da_calculator.interfaces.IRecyclerItemClickListener;
import com.example.da_calculator.model.Item;
import com.squareup.picasso.Picasso;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<Item> items;
    private IRecyclerItemClickListener listener;

    public MyAdapter(List<Item> items, IRecyclerItemClickListener listener) {
        this.items = items;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutItemBinding binding = LayoutItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Item item = items.get(position);
        holder.binding.txtTitle.setText(item.title);
        holder.binding.txtPublished.setText(item.pubDate);
        holder.binding.txtAuthor.setText(item.creator);

        Picasso.get()
                .load(item.content.url)
                .resize(80, 80)
                .centerCrop()
                .into(holder.binding.image);

        holder.binding.card.setOnClickListener(view -> listener.onItemClick(items.get(position).link));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        LayoutItemBinding binding;

        public MyViewHolder(@NonNull LayoutItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}