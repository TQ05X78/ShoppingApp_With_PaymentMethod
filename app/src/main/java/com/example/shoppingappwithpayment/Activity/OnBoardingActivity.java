package com.example.shoppingappwithpayment.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.ecommerceapp.R;
import com.example.ecommerceapp.adapter.Slideradapter;

public class OnBoardingActivity extends AppCompatActivity {

    ViewPager viewPager;

    Button btn;

    LinearLayout dotsLayout;

    Slideradapter slideradapter;

    TextView[] dots;

    Animation animation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_on_boarding);

        viewPager = findViewById(R.id.slider);
        dotsLayout = findViewById(R.id.dots);
        btn = findViewById(R.id.get_started_btn);


    addDots(0);

    viewPager.addOnPageChangeListener(changeListener);

    //Call Adapter
    slideradapter = new Slideradapter(this);
    viewPager.setAdapter(slideradapter);

    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(OnBoardingActivity.this, RegistrationActivity.class));
             finish();
        }
    });
    }

    //adding dots
    private void addDots(int position) {
        dots = new TextView[3];  //dots is a textview
        dotsLayout.removeAllViews();
        for(int i = 0; i < dots.length ; i++)
        {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));  //this is dot the no. &#8226 (dot show hora)
            dots[i].setTextSize(35);
            dotsLayout.addView(dots[i]);
        }


        if(dots.length > 0)
        {
            dots[position].setTextColor(getResources().getColor(R.color.pink));
        }

    }

    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {


            //visibility of button
            addDots(position);
            if(position == 0)
            {
                btn.setVisibility(View.INVISIBLE);
            }else if(position == 1)
            {
                btn.setVisibility(View.INVISIBLE);
            }else {
                animation = AnimationUtils.loadAnimation(OnBoardingActivity.this, R.anim.slide_animation);
                btn.setAnimation(animation);
                btn.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}