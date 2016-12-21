package com.example.csaper6.hacker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by csaper6 on 10/7/16.
 */
public class GetCreditsActivity extends AppCompatActivity{
    private Button credits10Button,credits50Button, credits100Button, credits500Button, credits1000Button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_credits);

        credits10Button = (Button) findViewById(R.id.credits_10_button);
        credits50Button = (Button) findViewById(R.id.credits_50_button);
        credits100Button = (Button) findViewById(R.id.credits_100_button);
        credits500Button = (Button) findViewById(R.id.credits_500_button);
        credits1000Button= (Button) findViewById(R.id.credits_1000_button);

        credits10Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        credits50Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        credits100Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        credits500Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        credits1000Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



    }
}
