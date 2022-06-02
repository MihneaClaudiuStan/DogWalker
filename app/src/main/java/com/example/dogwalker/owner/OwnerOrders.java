package com.example.dogwalker.owner;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dogwalker.R;
import com.example.dogwalker.adapter.CustomerOrderAdapter;
import com.example.dogwalker.customer.CustomerRegister;
import com.example.dogwalker.model.CustomerOrderModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class OwnerOrders extends AppCompatActivity {

    RecyclerView rv_showalldogs;
    String restName = "";
    List<CustomerOrderModel> mList = new ArrayList<>();
    CustomerOrderAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_orders);

        rv_showalldogs = findViewById(R.id.rv_showAllOrders);
        rv_showalldogs.setHasFixedSize(true);
        rv_showalldogs.setLayoutManager(new LinearLayoutManager(OwnerOrders.this));

        Intent intent = getIntent();
        restName = intent.getStringExtra("restName");

        getAllOrders();

    }

    private void getAllOrders() {
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        String userId = firebaseUser.getUid();
        if (firebaseUser.getUid() != null) {
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child(CustomerRegister.ORDER).child(restName);
            reference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    mList.clear();
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            CustomerOrderModel ownerDogs = dataSnapshot1.getValue(CustomerOrderModel.class);
                            mList.add(ownerDogs);
                        }
                    }
                    mAdapter = new CustomerOrderAdapter(OwnerOrders.this, mList);
                    rv_showalldogs.setAdapter(mAdapter);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
    }
}