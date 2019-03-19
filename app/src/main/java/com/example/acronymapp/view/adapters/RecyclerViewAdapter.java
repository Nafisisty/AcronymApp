package com.example.acronymapp.view.adapters;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.acronymapp.R;
import com.example.acronymapp.databinding.ItemBinding;
import com.example.acronymapp.model.datasource.acronym.Lf;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    ArrayList<Lf> resultArrayList;
    ViewGroup viewGroupTemp;

    public RecyclerViewAdapter(ArrayList<Lf> lfArrayList) {
        resultArrayList = lfArrayList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(viewGroup.getContext()),
                        R.layout.item, viewGroup, false);

        viewGroupTemp = viewGroup;
        ViewHolder viewHolder = new ViewHolder(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder viewHolder, int position) {

        Lf lf = resultArrayList.get(position);
        if(lf != null) {
            viewHolder.itemBinding.setLf(lf);
        }
    }

    @Override
    public int getItemCount() {
        return resultArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemBinding itemBinding;
        public ViewHolder(@NonNull ItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }
    }
}
