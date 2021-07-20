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
import com.example.ecommerceapp.models.ShowAllModel;

import java.util.List;

public class ShowAllAdapter extends RecyclerView.Adapter<ShowAllAdapter.ViewHolder> {

    private Context context;

    private List<ShowAllModel> showAllModelList;

    public ShowAllAdapter(Context context, List<ShowAllModel> showAllModelList) {
        this.context = context;
        this.showAllModelList = showAllModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view = LayoutInflater.from(context).inflate(R.layout.show_all_item,parent,false);
         return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(showAllModelList.get(position).getImg_url()).into(holder.itemImage);
        holder.itemName.setText(showAllModelList.get(position).getName());
        holder.itemPrice.setText("$"+showAllModelList.get(position).getPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailedActivity.class);
                intent.putExtra("detailed", showAllModelList.get(position));//for this line serializable in model call is necessary
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return showAllModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView itemImage;

        TextView itemName, itemPrice;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

        itemImage = itemView.findViewById(R.id.item_image);

        itemName = itemView.findViewById(R.id.item_name);
        itemPrice = itemView.findViewById(R.id.item_cost);

        }
    }
}
