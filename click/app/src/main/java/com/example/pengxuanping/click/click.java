package com.example.pengxuanping.click;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class click extends AppCompatActivity implements View.OnClickListener {

    private Button bt_1 ; //alt + enter
    private Button bt_2 ; //alt + enter
    private Button bt_3 ; //alt + enter


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click);

        bt_1 = (Button) findViewById(R.id.bt_1);
        bt_2 = (Button) findViewById(R.id.bt_2);
        bt_3 = (Button) findViewById(R.id.bt_3);

        bt_1.setOnClickListener(this);
        bt_2.setOnClickListener(this);
        bt_3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_1:
                Toast.makeText(this, "press button 1", Toast.LENGTH_SHORT).show();
                break;

            case R.id.bt_2:
                Toast.makeText(this, "press button 2", Toast.LENGTH_SHORT).show();
                break;

            case R.id.bt_3:
                Toast.makeText(this, "press button 3", Toast.LENGTH_SHORT).show();
                break;

            default:
                Toast.makeText(this, "err press", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void clickDirectly(View v)
    {
        Toast.makeText(this, "press button 4", Toast.LENGTH_SHORT).show();
    }
}
