package com.example.dogwalker.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dogwalker.R;
import com.example.dogwalker.model.CustomerOrderModel;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CustomerOrderAdapter extends RecyclerView.Adapter<CustomerOrderAdapter.viewHolder> {

    private Context mContext;
    private List<CustomerOrderModel> mRestaurantFoodList = new ArrayList<>();

    public CustomerOrderAdapter(Context mContext, List<CustomerOrderModel> mRestaurantFoodList) {
        this.mContext = mContext;
        this.mRestaurantFoodList = mRestaurantFoodList;
    }

    @NonNull
    @Override
    public CustomerOrderAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.order_items, parent, false);
        return new CustomerOrderAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerOrderAdapter.viewHolder holder, int position) {
        CustomerOrderModel food = mRestaurantFoodList.get(position);
        holder.tv_foodDesc.setText(food.getFoodDesc());
        holder.tv_foodName.setText(food.getFoodName());
        holder.tv_foodPrice.setText(food.getFoodPrice());
        Glide.with(mContext).load(food.getFoodImage()).into(holder.iv_foodImage);

    }

    @Override
    public int getItemCount() {
        return mRestaurantFoodList.size();
    }

    class viewHolder extends RecyclerView.ViewHolder {

        private CircleImageView iv_foodImage;
        private TextView tv_foodName;
        private TextView tv_foodPrice;
        private TextView tv_foodDesc;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            iv_foodImage = itemView.findViewById(R.id.cv_foodImage);
            tv_foodName = itemView.findViewById(R.id.tv_dogName);
            tv_foodPrice = itemView.findViewById(R.id.tv_doghourprice);
            tv_foodDesc = itemView.findViewById(R.id.tv_dogdesc);


        }
    }

}
