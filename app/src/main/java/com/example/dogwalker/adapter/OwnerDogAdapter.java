package com.example.dogwalker.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dogwalker.R;
import com.example.dogwalker.model.OwnerDogs;

import java.util.ArrayList;
import java.util.List;

public class OwnerDogAdapter extends RecyclerView.Adapter<OwnerDogAdapter.viewHolder> {

    private Context mContext;
    private List<OwnerDogs> ownerDogList = new ArrayList<>();

    public OwnerDogAdapter(Context mContext, List<OwnerDogs> ownerDogList) {
        this.mContext = mContext;
        this.ownerDogList = ownerDogList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.dogs_layout, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        OwnerDogs dogs = ownerDogList.get(position);
        holder.tv_foodDesc.setText(dogs.getDogDesc());
        holder.tv_foodName.setText(dogs.getDogName());
        holder.tv_foodPrice.setText(dogs.getDoghourprice());
        Glide.with(mContext).load(dogs.getDogImage()).into(holder.iv_dogImage);
    }

    @Override
    public int getItemCount() {
        return ownerDogList.size();
    }

    class viewHolder extends RecyclerView.ViewHolder {

        private ImageView iv_dogImage;
        private TextView tv_foodName;
        private TextView tv_foodPrice;
        private TextView tv_foodDesc;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

           // iv_dogImage = itemView.findViewById(R.id.iv_dogImage);
            tv_foodName = itemView.findViewById(R.id.tv_dogName);
            tv_foodPrice = itemView.findViewById(R.id.tv_doghourprice);
            tv_foodDesc = itemView.findViewById(R.id.tv_dogdesc);
        }
    }
}
