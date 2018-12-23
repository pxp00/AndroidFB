package com.example.pengxuanping.portraitlandscapelifecycle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView person;
    private ImageView boss;
    private Button shortboxing;
    private Button longboxing;
    private Button heavyfeet;
    private ProgressBar pb;
    private int blood = 100;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        person = findViewById(R.id.iv_person);
        boss = findViewById(R.id.iv_boss);
        shortboxing = findViewById(R.id.bt_shortboxing);
        longboxing = findViewById(R.id.bt_longboxing);
        heavyfeet = findViewById(R.id.bt_heavyfeet);
        pb = findViewById(R.id.pb_blood);
        pb.setMax(blood);
        pb.setProgress(blood);
        shortboxing.setOnClickListener(this);
        longboxing.setOnClickListener(this);
        heavyfeet.setOnClickListener(this);
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_shortboxing:
                person.setImageResource(R.drawable.shortboxing);
                blood -= 3;
                pb.setProgress(blood);
                break;

            case R.id.bt_longboxing:
                person.setImageResource(R.drawable.longboxing);
                blood -= 6;
                pb.setProgress(blood);
                break;

            case R.id.bt_heavyfeet:
                person.setImageResource(R.drawable.heavyfeet);
                blood -= 10;
                pb.setProgress(blood);
                break;

            default:
                break;
        }
        if(blood <= 0)
        {
            boss.setImageResource(R.drawable.bossdied);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }


}
