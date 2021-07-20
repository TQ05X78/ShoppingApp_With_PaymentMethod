package com.example.shoppingappwithpayment.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.ecommerceapp.R;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

public class PaymentActivity extends AppCompatActivity implements PaymentResultListener {


    double amount = 0.0;


    Toolbar toolbar;


    TextView subTotal, discount, shipping, total;

    Button paymentBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

    toolbar = findViewById(R.id.payment_toolbar);

    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    amount = getIntent().getDoubleExtra("amount", 0.0);



    subTotal = findViewById(R.id.subTotal);
    discount = findViewById(R.id.textView17);
    shipping = findViewById(R.id.textView18);
    total = findViewById(R.id.total_amt);
     paymentBtn = findViewById(R.id.payment_btn);

     subTotal.setText(amount+"$");

     paymentBtn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             paymentMethod();
         }
     });


    }

    private void paymentMethod() {

        Checkout checkout = new Checkout();

        checkout.setKeyID("rzp_test_e0PRQjuz46Vwmz");

        final Activity activity = PaymentActivity.this;

        try {
            JSONObject options = new JSONObject();

            //SET company name

            options.put ("name", "My E-Commerce App");

            //ref no

            options.put("description","Reference No. #123456");

            //Image to be display
            options.put("image","https://s3.amazonaws.com/rzp-mobile//images/rzp.png");

            //currency type
            options.put("currency", "USD");

            //double total = Double.parseDouble(mAmountText.getText().toString());

            //multiply with 100 to get exact amount in rupee

            amount = amount * 100;


            //amount
            options.put("amount", amount);

            JSONObject preFill = new JSONObject();

            //email

            preFill.put("email", "eail.com");

            preFill.put("context", "");

            options.put("prefill", preFill);


            checkout.open(activity, options);
        }


        catch (Exception e)
        {
            Log.e("TAG", "Error in starting Razorpay Checkout", e);
        }

    }


    @Override
    public void onPaymentSuccess(String s) {
        Toast.makeText(this, "Payment Successful!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPaymentError(int i, String s) {
       Toast.makeText(this, "Payment Cancel", Toast.LENGTH_SHORT).show();
    }
}