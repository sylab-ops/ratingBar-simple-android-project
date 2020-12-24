package com.sylabblueprint.finalexam_ratingbar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView rateCount; TextView showRating;
    EditText review;
    Button submitBtn;
    RatingBar ratingBar;
    float rateValue; String temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rateCount = findViewById(R.id.rateCount);
        ratingBar = findViewById(R.id.ratingBar);
        review = findViewById(R.id.review);
        submitBtn = findViewById(R.id.submitBtn);
        showRating =findViewById(R.id.showRating);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            rateValue = ratingBar.getRating();

            if(rateValue< 1 && rateValue >0)
                rateCount.setText("You rate, Poor " + rateValue + "/5.0");
                else if(rateValue<=2 && rateValue >1)
                rateCount.setText(" You rate, OK " + rateValue + "/5.0");
                else if(rateValue<=3 && rateValue > 2)
                    rateCount.setText("You rate, Good " + rateValue + "/5.0");
                    else if(rateValue<=4 && rateValue > 3)
                        rateCount.setText(" You rate, Very good " + rateValue + "/5.0");
                        else if(rateValue<=5 && rateValue > 4)
                            rateCount.setText(" You rate, Excellent " + rateValue + "/5.0");

            }


        });
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
                temp = rateCount.getText().toString();
                showRating.setText("Your rating: \n" +temp + "\n" +review.getText());
                review.setText("");
                ratingBar.setRating(0);
                rateCount.setText("");
            }
        });
    }
    public void openActivity2(){
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }
}