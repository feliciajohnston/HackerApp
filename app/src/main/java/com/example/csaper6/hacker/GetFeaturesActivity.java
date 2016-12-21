package com.example.csaper6.hacker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by csaper6 on 10/7/16.
 */
public class GetFeaturesActivity extends AppCompatActivity{
    private Button pentagonButton, nasaButton, mibButton, fbiButton, grantedButton, deniedButton;
    private Credit c;
    private ButtonAbility b;
    private ArrayList<String> disabledNames;
    private ArrayList<Button> buttonList;

    public static final String EXTRA_CREDITS = "current credits";
    public static final String EXTRA_BUTTON = "button pressed";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_features);

        disabledNames = new ArrayList<>();

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

        b = new ButtonAbility(true, true, true, true, true, true);
        disableFeatures();

        pentagonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {completeTransaction(pentagonButton);
            }
        });
        nasaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {completeTransaction(nasaButton);    }
        });
        mibButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                completeTransaction(mibButton);
            }
        });
        fbiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                completeTransaction(fbiButton);
            }
        });
        grantedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {completeTransaction(grantedButton);
            }
        });
        deniedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {completeTransaction(deniedButton);
            }
        });
        Intent i = getIntent();
        c = i.getParcelableExtra(MainActivity.EXTRA_CREDITS);

    }
    public void completeTransaction(Button butt)
    {

        int num = Integer.parseInt(butt.getText().toString().substring(0, (butt.getText().length() - 8)));

        if(c.getCredits() >= num)
        {
            c.removeCredits(num);
            Toast.makeText(GetFeaturesActivity.this, "Transaction Complete", Toast.LENGTH_SHORT).show();
            disabledNames.add(butt.getText() + "");
            b.changeAbility(butt, false);
        }
        else
        {
            Toast.makeText(GetFeaturesActivity.this, "Insufficient Funds " + c.getCredits(), Toast.LENGTH_SHORT).show();
        }
        Intent i = new Intent();
        i.putExtra(EXTRA_CREDITS,c.getCredits());
        i.putExtra(EXTRA_BUTTON, butt.getText());
        setResult(RESULT_OK, i);
    }

    private void disableFeatures()
    {
        for(int i = 0; i < buttonList.size()-1; i++)
        {
            for(int j = 0; j < disabledNames.size()-1; j++)
            {
                if (disabledNames.get(j).equals(buttonList.get(i).getText())) {
                    b.changeAbility(buttonList.get(i), false);

                }
            }

        }

    }



}
