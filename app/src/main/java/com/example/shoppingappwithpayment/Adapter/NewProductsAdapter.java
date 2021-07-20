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
import com.example.ecommerceapp.models.NewProductsModel;

import java.util.List;

public class NewProductsAdapter extends RecyclerView.Adapter<NewProductsAdapter.ViewHolder> {


    private Context context;
    private List<NewProductsModel> newProductsModelList;


    public NewProductsAdapter(Context context, List<NewProductsModel> newProductsModelList) {
        this.context = context;
        this.newProductsModelList = newProductsModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.new_products,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Glide.with(context).load(newProductsModelList.get(position).getImg_url()).into(holder.new_img);
        holder.new_productName.setText(newProductsModelList.get(position).getName());
        holder.newPrice.setText(String.valueOf(newProductsModelList.get(position).getPrice()));


        //In Popular Product item selected when touched
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailedActivity.class);
                intent.putExtra("detailed",newProductsModelList.get(position));

                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return newProductsModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView new_img;
        TextView new_productName, newPrice;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            new_img = itemView.findViewById(R.id.new_img);
            new_productName = itemView.findViewById(R.id.new_product_name);
            newPrice = itemView.findViewById(R.id.new_price);

        }
    }
}






