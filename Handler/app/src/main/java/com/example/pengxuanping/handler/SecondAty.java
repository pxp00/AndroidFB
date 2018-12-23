package com.example.pengxuanping.handler;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

@SuppressLint("Registered")
public class SecondAty extends Activity {
    private static final String TAG = "ThreadDemo";
    private int count = 0;

    /* as a timer, use with runable */
    private Handler mHandler = new Handler(); //1. create

    private Runnable mRunnable = new Runnable() {

        public void run() {

            //为了方便 查看，我们用Log打印出来
            Log.e(TAG, Thread.currentThread().getName() + " " +count);
            count++;
            setTitle("" +count);

            //3. as a timer, Recurse: interval = 2000ms
            mHandler.postDelayed(mRunnable, 2000); //**recurse: runable -> postDelayed //post msg -> runable
        }

    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2. 通过Handler启动线程
        mHandler.post(mRunnable);
    }

    @Override
    protected void onDestroy() {

        //4. 将线程销毁掉
        mHandler.removeCallbacks(mRunnable); //remove runable
        super.onDestroy();
    }
}