package com.example.pengxuanping.eventbus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends Activity {

    //ref bind view
    @BindView(R.id.btn_try)
    Button btnTry;
    @BindView(R.id.tv)
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this); // fragment need unbind only

        /* 1. register */
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        /* 2. unregister*/
        EventBus.getDefault().unregister(this);
    }

    /* 3. receive msg Note：add @Subscribe */
    @Subscribe(threadMode = ThreadMode.MAIN) //POSTING, BACKGROUND, ASYNC()
    public void onEventMainThread(FirstEvent event) {

        String msg = "onEventMainThread received Msg:" + event.getMsg();
        Log.d("hugo", msg);
        tv.setText(msg);
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.btn_try) //view(R.id.xxx) bind mtd(@onClick)
    public void onViewClicked() {
        Intent intent = new Intent(getApplicationContext(), secondaty.class);
        startActivity(intent);
    }
}
