package com.example.pengxuanping.progressbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ProgressBar pb;
    private Button bt_vis;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pb = findViewById(R.id.pb);
        bt_vis = findViewById(R.id.bt_vis);
        pb.setOnClickListener(this);
        bt_vis.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pb:
                int progress = pb.getProgress();
                if (progress > 0) {
                    progress -= 10;
                } else {
                    progress = 100;
                }
                pb.setProgress(progress);
                break;

            case R.id.bt_vis:

                if (View.VISIBLE == pb.getVisibility()) {
                    pb.setVisibility(View.INVISIBLE);
                } else {
                    pb.setVisibility(View.VISIBLE);
                }
                break;

            default:
                break;


        }
    }
}
