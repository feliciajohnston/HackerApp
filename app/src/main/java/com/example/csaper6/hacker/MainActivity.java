package com.example.csaper6.hacker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText hackText;
    private TextView hackView;
    private Credit myCredits;
    private String changedButton;
    public static final String EXTRA_CREDITS = "current credits";
    public static final String EXTRA_BUTTON = "button pressed";
    public static final int REQUEST_CREDITS = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myCredits = new Credit(50);
        hackText = (EditText) findViewById(R.id.editText_hacker);
        hackView = (TextView) findViewById(R.id.hack_textView);
        Log.e("TextWatcherTest", "Set text xyz");
        hackView.setText("xyz");
        hackText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.e("TextWatcherTest", "afterTextChanged:\t" + s.toString());
                hackView.append("hi");
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.my_features:
                Intent openMyFeaturesActivity = new Intent(MainActivity.this, MyFeaturesActivity.class);
                openMyFeaturesActivity.putExtra(EXTRA_BUTTON, changedButton);
                startActivity(openMyFeaturesActivity);
                return true;
            case R.id.get_features:
                Intent openGetFeaturesActivity = new Intent(MainActivity.this, GetFeaturesActivity.class);
                openGetFeaturesActivity.putExtra(EXTRA_CREDITS, myCredits);
                startActivity(openGetFeaturesActivity);
                return true;
            case R.id.get_credits:
                Intent openGetCreditsActivity = new Intent(MainActivity.this, GetCreditsActivity.class);
                startActivityForResult(openGetCreditsActivity,REQUEST_CREDITS);
                return true;
            default:
                return false;

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(REQUEST_CREDITS == requestCode && RESULT_OK == resultCode )
        {
            myCredits.setCredits(data.getIntExtra(GetFeaturesActivity.EXTRA_CREDITS, -1));
            changedButton = data.getStringExtra(GetFeaturesActivity.EXTRA_BUTTON);
        }
    }
}
