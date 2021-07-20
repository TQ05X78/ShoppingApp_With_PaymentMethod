package com.example.shoppingappwithpayment.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.example.ecommerceapp.R;

public class Slideradapter extends PagerAdapter {

    Context context;

    LayoutInflater layoutInflater;



    public Slideradapter(Context context) {
        this.context = context;
    }


    int imageArray[] = {

            R.drawable.onboardscreen,
            R.drawable.onboardscreen2,
            R.drawable.onboardscreen3

    };


    //R.String.
    int headingArray[] = {
       R.string.first_slide,
       R.string.second_slide,
       R.string.third_slide
    };


    int descriptionArray[] = {
      R.string.dexcription,
      R.string.dexcription,
      R.string.dexcription
    };









    @Override
    public int getCount() {
        return headingArray.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, Object object) {
        return view == (ConstraintLayout) object;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull  ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.sliding_layout,container,false);


        ImageView imageView = view.findViewById(R.id.slider_img);
        TextView heading = view.findViewById(R.id.heading);
        TextView description = view.findViewById(R.id.description);


        imageView.setImageResource(imageArray[position]);
        heading.setText(headingArray[position]);
        description.setText(descriptionArray[position]);


        container.addView(view);


        return view;
    }


    @Override
    public void destroyItem(@NonNull  ViewGroup container, int position, @NonNull  Object object) {
        container.removeView((ConstraintLayout)object);
    }
}











