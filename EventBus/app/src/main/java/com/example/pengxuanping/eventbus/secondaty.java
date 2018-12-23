package com.example.pengxuanping.eventbus;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/* butterknife: view(R.id.btn) of layout(xml: R.layout.xxx) bind mtd(onclick(), @onClick)/fields(Button btn, @BindView); Zelezny(plug)  */
public class secondaty extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondaty);
        ButterKnife.bind(this);

        /*btn_FirstEvent = (Button) findViewById(R.id.btn_first_event);
        btn_FirstEvent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                *//* 4. send msg *//*

                //EventBus.getDefault().post(new FirstEvent("FirstEvent btn clicked"));
            }
        });*/
    }

    /* 4. posting  msg */
    @OnClick(R.id.btn_first_event)
    public void onViewClicked() {
        EventBus.getDefault().post(new FirstEvent("hello world "));
    }
}
