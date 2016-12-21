package com.example.csaper6.hacker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

/**
 * Created by csaper6 on 10/7/16.
 */
public class MyFeaturesActivity extends AppCompatActivity{
    private Button pentagonButton, nasaButton, mibButton, fbiButton, grantedButton, deniedButton;
    private ButtonAbility b;
    private String changedButton;
    private ArrayList<Button> buttonList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_features);

        b = new ButtonAbility(false, false, false, false, false, false);

        pentagonButton = (Button) findViewById(R.id.pentagon_button);
        nasaButton = (Button) findViewById(R.id.nasa_button);
        mibButton = (Button) findViewById(R.id.mib_button);
        fbiButton = (Button) findViewById(R.id.fbi_button);
        grantedButton = (Button) findViewById(R.id.granted_button);
        deniedButton = (Button) findViewById(R.id.denied_button);

        buttonList = new ArrayList<>();
        buttonList.add(pentagonButton);
        buttonList.add(nasaButton);
        buttonList.add(mibButton);
        buttonList.add(fbiButton);
        buttonList.add(grantedButton);
        buttonList.add(deniedButton);

        pentagonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        nasaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {}
        });
        mibButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        fbiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        grantedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        deniedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        enableFeatures();

        Intent i = getIntent();
        changedButton = i.getStringExtra(MainActivity.EXTRA_BUTTON);
    }

        public void enableFeatures() {

            for(Button butt : buttonList)
            {
                if (butt.getText().equals(changedButton)) {
                    butt.setEnabled(true);
                    butt.setText(butt.getText() + " ENABLED");
                }

            }
        }
}
