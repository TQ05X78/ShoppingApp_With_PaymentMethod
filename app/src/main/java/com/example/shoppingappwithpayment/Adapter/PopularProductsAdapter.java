package com.example.shoppingappwithpayment.Adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ecommerceapp.R;
import com.example.ecommerceapp.activity.DetailedActivity;
import com.example.ecommerceapp.models.PopularProductsModel;

import java.util.List;

//after model class 2nd create Adapter
public class PopularProductsAdapter extends RecyclerView.Adapter<PopularProductsAdapter.ViewHolder> {

    private Context context;
    private List<PopularProductsModel> popularProductsModelList;

    public PopularProductsAdapter(Context context, List<PopularProductsModel> popularProductsModelList) {
        this.context = context;
        this.popularProductsModelList = popularProductsModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.popular_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Glide.with(context).load(popularProductsModelList.get(position).getImg_url()).into(holder.popularProductImage);
        holder.productName.setText(popularProductsModelList.get(position).getName());
        holder.productPrice.setText(String.valueOf(popularProductsModelList.get(position).getPrice()));

          holder.itemView.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Intent intent = new Intent(context, DetailedActivity.class);
                  intent.putExtra("detailed", popularProductsModelList.get(position));
                  context.startActivity(intent);
              }
          });
    }

    @Override
    public int getItemCount() {
        return popularProductsModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView popularProductImage;

        TextView productName, productPrice;

        public ViewHolder(@NonNull  View itemView) {
            super(itemView);

            popularProductImage = itemView.findViewById(R.id.popular_img);
            productName = itemView.findViewById(R.id.popular_product_name);
            productPrice = itemView.findViewById(R.id.popular_price);


        }
    }
}
