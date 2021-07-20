package com.example.shoppingappwithpayment.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerceapp.R;
import com.example.ecommerceapp.models.AddressModel;

import java.util.List;

public class AddressAdapter  extends RecyclerView.Adapter<AddressAdapter.ViewHolder> {

     Context context;

     List<AddressModel> addressModelList;

     SelectedAddress selectedAddress;

     private RadioButton selectedRadioBtn;

    public AddressAdapter(Context context, List<AddressModel> addressModelList, SelectedAddress selectedAddress) {
        this.context = context;
        this.addressModelList = addressModelList;
        this.selectedAddress = selectedAddress;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.address_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.address.setText(addressModelList.get(position).getUserAddress());
        holder.radio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(AddressModel address: addressModelList)
                {
                    address.setSelected(false);
                }
                addressModelList.get(position).setSelected(true);
                    if(selectedRadioBtn!=null)
                {
                    selectedRadioBtn.setChecked(false);
                }
                  selectedRadioBtn = (RadioButton) v;
                    selectedRadioBtn.setChecked(true);
                    selectedAddress.setAddress(addressModelList.get(position).getUserAddress());


            }
        });









    }

    @Override
    public int getItemCount() {
        return addressModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView address;

        RadioButton radio;




        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            address = itemView.findViewById(R.id.address_add);
            radio  = itemView.findViewById(R.id.select_address);
        }
    }

    public interface SelectedAddress{
        void setAddress(String address);
    }















}
