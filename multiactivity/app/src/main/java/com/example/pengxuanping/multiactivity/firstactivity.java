package com.example.pengxuanping.multiactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class firstactivity extends AppCompatActivity {
    //private Button bt_another = (Button) findViewById(R.id.bt_anotheractivity);
    private Button bt_another;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstactivity);
        bt_another = (Button) findViewById(R.id.bt_anotheractivity);
        bt_another.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(firstactivity.this, second.class);
                startActivities(new Intent[]{intent});
            }
        });
    }

}
