package com.example.pengxuanping.attr;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.NotificationCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by cmo on 16-4-15.
 */
public class CostomImgView extends ImageView {

    private int mAlphaDelta=0;//透明度每次改变的大小
    private int mCurrAphla=0;//当前透明度
    private final int SPEED=500;//每隔500ms 改变一次
  @SuppressLint("HandlerLeak")
  Handler hander =new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what==0x123){
                Log.d("TAG","Handle message"+String.valueOf(mCurrAphla));
                mCurrAphla +=mAlphaDelta;
                if(mCurrAphla>255){
                    mCurrAphla=255;
                }
                CostomImgView.this.setAlpha((float) mCurrAphla);
                CostomImgView.this.setRotation((float)mCurrAphla);
            }
        }
    };

    public CostomImgView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray=context.obtainStyledAttributes(attrs, R.styleable.AlphaImgView);
        int duration=typedArray.getInt(R.styleable.AlphaImgView_duration,0);
        mAlphaDelta=255*SPEED/duration;
        Log.d("TAG"," 构造方法"+String.valueOf(mAlphaDelta));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        this.setAlpha((float) mCurrAphla);
        Log.d("TAG",String.valueOf(mCurrAphla));
        super.onDraw(canvas);
        final Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Message msg=new Message();
                msg.what=0x123;
                Log.d("TAG","timer run"+String.valueOf(mCurrAphla));
                if(mCurrAphla>=255){

                    timer.cancel();
                }
                else{
                    handler.sendMessage(msg);
                }
            }
        },0,SPEED);
    }
}

