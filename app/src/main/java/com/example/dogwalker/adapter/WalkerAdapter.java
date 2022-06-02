package com.example.dogwalker.adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dogwalker.model.WalkerDog;
import com.example.dogwalker.R;
import com.example.dogwalker.customer.CustomerRegister;
import com.example.dogwalker.model.CustomerLocationModel;
import com.example.dogwalker.customer.WalkerUserLocation;
import com.example.dogwalker.owner.OwnerRegister;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class WalkerAdapter extends RecyclerView.Adapter<WalkerAdapter.viewHolder> {
    private Context mContext;
    private List<WalkerDog> mDogList = new ArrayList<>();

    public WalkerAdapter(Context mContext, List<WalkerDog> mDogList) {
        this.mContext = mContext;
        this.mDogList = mDogList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.walker_order_layout, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        WalkerDog dog = mDogList.get(position);
        holder.tv_userName.setText(dog.getUserName());
        holder.tv_dogName.setText(dog.getDogName());
        Glide.with(mContext).load(dog.getDogImage()).into(holder.cv_dogImage);

        holder.btn_userLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
                if (firebaseUser.getUid() != null) {
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child(CustomerRegister.LOCATION_CUSTOMERS).child(dog.getUserName());
                    reference.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            CustomerLocationModel model = snapshot.getValue(CustomerLocationModel.class);
                            Double latitude = Double.parseDouble(model.getLatitude());
                            Double longitude = Double.parseDouble(model.getLongitude());
                            Intent intent = new Intent(mContext, WalkerUserLocation.class);
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            mContext.startActivity(intent);

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }

            }
        });

        holder.btn_restLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
                if (firebaseUser.getUid() != null) {
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child(OwnerRegister.LOCATION);
                    reference.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            CustomerLocationModel model = snapshot.getValue(CustomerLocationModel.class);
                            Double latitude = Double.parseDouble(model.getLatitude());
                            Double longitude = Double.parseDouble(model.getLongitude());
                            Intent intent = new Intent(mContext, WalkerUserLocation.class);
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            mContext.startActivity(intent);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }
        });

        holder.btn_completed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog = new ProgressDialog(mContext);
                progressDialog.setTitle("Complete...");
                FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
                if (firebaseUser.getUid() != null) {
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child(CustomerRegister.ORDER).child(dog.getId()).child(dog.getDogId());
                    reference.removeValue();
                    progressDialog.dismiss();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDogList.size();
    }

    class viewHolder extends RecyclerView.ViewHolder {

        private ImageView cv_dogImage;
        private TextView tv_userName;
        private TextView tv_dogName;
        private Button btn_userLocation;
        private Button btn_restLocation;
        private Button btn_completed;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            cv_dogImage = itemView.findViewById(R.id.cv_dogImage);
            tv_userName = itemView.findViewById(R.id.tv_userName);
            tv_dogName = itemView.findViewById(R.id.tv_dogName);
            btn_userLocation = itemView.findViewById(R.id.btn_userLocation);
            btn_restLocation = itemView.findViewById(R.id.btn_restLocation);
            btn_completed = itemView.findViewById(R.id.btn_completed);
        }
    }
}
